package progtest.plagiarism;

import java.io.FileInputStream;



/*
 * sherlock.c - written by Loki from Rob Pike's sig and comp programs.
 * http://sydney.edu.au/engineering/it/~scilect/sherlock/
 *
 * This program takes filenames given on the command line, and reads those
 * files into memory, then compares them all pairwise to find those which
 * are most similar.
 *
 * It uses a digital signature generation scheme to randomly discard
 * information, thus allowing a better match. Essentially it hashes up N
 * adjacent 'words' of input, and semi-randomly throws away many of the
 * hashed values so that it become hard to hide the plagiarised text.
 *  
 * Sherlock works on text files such as essays, computer source code files,
 * and other assignments in digital form. It will even work with Tar files,
 * but not compressed archives such as Gzipped or Zipped files (you'll have
 * to unzip those files first). 
 */


public class Sherlock
{
	/**
	 * Controls how many words are used to form one digital signature. This 
	 * also contributes to the granularity of the comparison. A higher number
	 * is slower while a lower number is less exact. The default is 3 words,
	 * which works fine in most cases.
	 */
	private static int Ntoken = 3;
	
	/**
	 * Controls the "granularity" of the comparison. The higher this number,
	 * the cruder the comparison but the faster it will proceed. The lower
	 * this number, the more exact the comparison, but it will be slower, and
	 * it may be harder to detect plagiarism because small changes will fool
	 * the program into thinking the files are different. The default is 4,
	 * but the number can range from 0 to 31.
	 */
	private static int Zerobits = 4;
	
	private static long zeromask;
	
	private static int ntoken = 0;
	
	private String[] token;
	
	/**
	 * Controls how similar files must be before they will be mentioned.
	 * Increase this to 50% or higher if you only want to see very similar
	 * files. The default is 20%
	 */
	private int Thresh = 20;

	/**
	 * Characters to ignore at start and end of each word.
	 */
	private static char[] Ignore = { ' ', '\t', '\n' };

	/**
	 * Characters to treat as word-separators or words on their own.
	 */
	private static char[] Punct_full = {
		',', '.', '<', '>', '/', '?', ';', ':', '\'', '"', '`', '~',
		'[', ']', '{', '}', '\\', '|', '!', '@', '#', '$', '%', '^',
		'&', '*', '(', ')', '-', '+', '_', '='
	};
	
	private static char Punct = '\0';

	private static class Sig {
		public int	nval;
		public long[] val;
	};

	private void usage() {
		System.err.println("Find similar files\n");
		System.err.println("Usage:");
		System.err.println(" [options] file1 file2 ...\n");
		System.err.println("options:");
		System.err.println(" [-t threshold%%]");
		System.err.println(" [-z zerobits]");
		System.err.println(" [-n chainlength]");
		System.err.println(" [-o outfile]");
		System.err.println("\n");
		System.err.println("defaults:");
		System.err.println(" threshold=20%%");
		System.err.println(" zerobits=3");
		System.err.println(" chainlength=4");
		System.err.println(" outfile=the screen");
		System.exit(2);
	}


	/**
	 * Read_word: read a 'word' from the input, ignoring leading characters
	 * which are inside the 'ignore' string, and stopping if one of the
	 * 'ignore' or 'punct' characters is found. Uses memory allocation to
	 * avoid buffer overflow problems.
	 */
	private String read_word(FileInputStream fis, int *length, char *ignore, char *punct)
	{
		long max;
		String word;
		long pos;
		int c;
		int ch, is_ignore, is_punct;

		/* allocate a buffer to hold the string */
		pos = 0;
		max = 128;
		
		/* initialise some defaults */
		if (ignore == NULL) {
			ignore = "";
		}
		if (punct == NULL) {
			punct = "";
		}

		/* read characters into the buffer, resizing it if necessary */
		while ((ch = fis.read(b)getc(f)) != EOF) {
			is_ignore = (strchr(ignore, ch) != NULL);
			if (pos == 0) {
				if (is_ignore)
					/* ignorable char found at start, skip it */
					continue;
			}
			if (is_ignore)
				/* ignorable char found after start, stop */
				break;
			is_punct = (strchr(punct, ch) != NULL);
			if (is_punct && (pos > 0)) {
				ungetc(ch, f);
				break;
			}
	                *c = ch;
	                c++;
	                pos++;
			if (is_punct)
				break;
	                if (pos == max) {
	                        /* realloc buffer twice the size */
	                        max += max;
	                        word = realloc(word, max);
	                        c = & word[pos];
	                }
	        }

	        /* set length and check for EOF condition */
	        *length = pos;
	        if (pos == 0) {
	                free(word);
	                return NULL;
	        }

	        /* terminate the string and shrink to smallest required space */
	        *c = '\0';
	        word = realloc(word, pos+1);
	        return word;
	}

	/* ulcmp:  compare *p1 and *p2 */
	int ulcmp(const void *p1, const void *p2)
	{
		unsigned long v1, v2;

		v1 = *(unsigned long *) p1;
		v2 = *(unsigned long *) p2;
		if (v1 < v2)
			return -1;
		else if (v1 == v2)
			return 0;
		else
			return 1;
	}

	/* hash:  hash an array of char* into an unsigned long hash code */
	unsigned long hash(char *tok[])
	{
		unsigned long h;
		unsigned char *s;
		int i;

		h = 0;
		for (i=0; i < Ntoken; i++)
			for (s=(unsigned char*)tok[i]; *s; s++)
				h = h*31 + *s;
		return h;
	}

	void init_token_array(void)
	{
		int i;

		/* create global array of char* and initialise all to NULL */
		token = malloc(Ntoken * sizeof(char*));
		for (i=0; i < Ntoken; i++)
			token[i] = NULL;
	}

	Sig * signature(FILE *f)
	{
		int nv, na;
		unsigned long *v, h;
		char *str;
		int i, ntoken;
		Sig *sig;

		/* start loading hash values, after we have Ntoken of them */
		v = NULL;
		na = 0;
		nv = 0;
		ntoken = 0;
		while ((str = read_word(f, &i, Ignore, Punct)) != NULL)
		{
			/* step words down by one */
			free(token[0]);
			for (i=0; i < Ntoken-1; i++)
				token[i] = token[i+1];
			/* add new word into array */
			token[Ntoken-1] = str;

			/* if we don't yet have enough words in the array continue */
			ntoken++;
			if (ntoken < Ntoken)
				continue;

			/* hash the array of words */
			h = hash(token);
			if ((h & zeromask) != 0)
				continue;

			/* discard zeros from end of hash value */
			h = h >> Zerobits;

			/* add value into the signature array, resizing if needed */
			if (nv == na) {
				na += 100;
				v = realloc(v, na*sizeof(unsigned long));
			}
			v[nv++] = h;
		}

		/* sort the array of hash values for speed */
		qsort(v, nv, sizeof(v[0]), ulcmp);

		/* allocate and return the Sig structure for this file */
		sig = malloc(sizeof(Sig));
		sig->nval = nv;
		sig->val = v;
		return sig;
	}

	/*
	 * 
	 * 
	 * 
	 *  Let f1 == filesize(file1) == A+B
	 *  and f2 == filesize(file2) == A+C
	 *  where A is the similar section and B or C are dissimilar
	 *
	 *  Similarity = 100 * A / (f1 + f2 - A)
	 *             = 100 * A / (A+B + A+C - A)
	 *             = 100 * A / (A+B+C)
	 *
	 *  Thus if A==B==C==n the similarity will be 33% (one third)
	 *  This is desireable since we are finding the ratio of similarities
	 *  as a fraction of (similarities+dissimilarities).
	 *
	 *  The other way of doing things would be to find the ratio of
	 *  the sum of similarities as a fraction of total file size:
	 *  Similarity = 100 * (A+A) / (A+B + A+C)
	 *  This produces higher percentages and more false matches.
	 */
	int compare(Sig *s0, Sig *s1)
	{
		int i0, i1, nboth, nsimilar;
		unsigned long v;

		i0 = 0;
		i1 = 0;
		nboth = 0;
		while (i0 < s0->nval && i1 < s1->nval) {
			if (s0->val[i0] == s1->val[i1]) {
				v = s0->val[i0];
				while (i0 < s0->nval && v == s0->val[i0]) {
					i0++;
					nboth++;
				}
				while (i1 < s1->nval && v == s1->val[i1]) {
					i1++;
					nboth++;
				}
				continue;
			}
			if (s0->val[i0] < s1->val[i1])
				i0++;
			else
				i1++;
		}

		if (s0->nval + s1->nval == 0)
			return 0;	/* ignore if both are empty files */

		if (s0->nval + s1->nval == nboth)
			return 100;	/* perfect match if all hash codes match */

		nsimilar = nboth / 2;
		return 100 * nsimilar / (s0->nval + s1->nval - nsimilar);
	}

	/**
	 * Sherlock performs an N2 comparison between all the files, so every file
	 * is compared with every other file.
	 * 
	 * The output lists the similarity indexes between each pair of files. This
	 * index is a percentage, where 0% means no similarity and 100% means there
	 * is a very high chance of a lot of similarity. 100% does not mean that
	 * the files are exactly the same, since the Sherlock program randomly
	 * throws away some data in order to perform a faster match.
	 */
	public static void main(String[] args)
	{
		FILE *f;
		int i, j, nfiles, start, percent;
		char *s, *outname;
		Sig **sig;

		Outfile = stdout;
		outname = NULL;

		/* handle options */
		for (start=1; start < argc; start++) {
			if (argv[start][0] != '-')
				break;
			switch (argv[start][1]) {
			case 't':
				s = argv[++start];
				if (s == NULL)
					usage();
				Thresh = atoi(s);
				if (Thresh < 0 || Thresh > 100)
					usage();
				break;
			case 'z':
				s = argv[++start];
				if (s == NULL)
					usage();
				Zerobits = atoi(s);
				if (Zerobits < 0 || Zerobits > 31)
					usage();
				break;
			case 'n':
				s = argv[++start];
				if (s == NULL)
					usage();
				Ntoken = atoi(s);
				if (Ntoken <= 0)
					usage();
				break;
			case 'o':
				s = argv[++start];
				if (s == NULL)
					usage();
				outname = s;
				break;
			default:
				usage();
			}
		}

		nfiles = argc - start;
		if (nfiles < 2)
			usage();

		/* initialise */
		if (outname != NULL)
			Outfile = fopen(outname, "w");
		init_token_array();
		zeromask = (1<<Zerobits)-1;
		sig = malloc(nfiles * sizeof(Sig *));

		/* generate signatures for each file */
		for (i=0; i < nfiles; i++) {
			/* fprintf(stderr, "%s: Reading %s\n", Progname, argv[i+start]); */
			f = fopen(argv[i+start], "r");
			if (f == NULL) {
				fprintf(stderr, "%s: can't open %s:",
					Progname, argv[i+start]);
				perror(NULL);
				continue;
			}
			sig[i] = signature(f);
			fclose(f);
		}

		/* compare each signature pair-wise */
		for (i=0; i < nfiles; i++)
			for (j=i+1; j < nfiles; j++) {
				percent = compare(sig[i], sig[j]);
				if (percent >= Thresh)
					fprintf(Outfile, "%s and %s: %d%%\n",
						argv[i+start], argv[j+start], percent);
			}

		return 0;
	}
	
	
}
