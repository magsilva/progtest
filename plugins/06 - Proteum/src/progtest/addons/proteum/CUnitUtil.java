package progtest.addons.proteum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CUnitUtil {

	public static final String CUNIT_OUTPUT_FILENAMEROOT = "CUNIT";

	public static final String CUNIT_OUTPUT_FILENAME = "CUNIT-Results.xml";

	public static File configureCUnitOutput(File srcDir, File tmpDir)
			throws IOException {

		List<File> cFiles = FileUtil.list(srcDir, ".c");

		for (File file : cFiles) {

			boolean replace = false;

			FileReader fr = null;
			BufferedReader br = null;

			File tf = null;
			FileWriter fw = null;

			try {

				fr = new FileReader(file);
				br = new BufferedReader(fr);

				tf = new File(tmpDir + File.separator + "cunit_test.c");
				tf.createNewFile();
				fw = new FileWriter(tf);

				while (br.ready()) {

					String line = br.readLine();

					if (line.contains("CU_automated_run_tests()")) {

						fw.write("CU_set_output_filename(\"" + tmpDir
								+ File.separator + CUNIT_OUTPUT_FILENAMEROOT
								+ "\");\n");

						fw.write(line + "\n");

						fw.write("{\n");

						fw.write("FILE* f = NULL;\n");

						fw.write("char c = ' ';\n");

						fw.write("char* line = malloc (100 * sizeof (char));\n");

						fw.write("int i = 0;\n");

						fw.write("if((f = fopen (\"" + tmpDir + File.separator
								+ CUNIT_OUTPUT_FILENAME
								+ "\", \"r\")) != NULL) {\n");
						
						fw.write("c = getc(f);\n");
						
						fw.write("while(c != EOF) {\n");
						
						fw.write("if(i < 100) {\n");
						
						fw.write("line[i] = c;\n");
						
						fw.write("i++;\n");
						
						fw.write("}\n");
						
						fw.write("if(c == '\\n') {\n");
						
						fw.write("if(i >= 34) {\n");
						
						fw.write("if(line[0] == ' ' && line[1] == ' ' && line[2] == ' ' && line[3] == ' ' && line[4] == ' ' && line[5] == ' ' && line[6] == ' ' && line[7] == ' ' && line[8] == ' ' && line[9] == ' ' && line[10] == '<' && line[11] == 'C' && line[12] == 'U' && line[13] == 'N' && line[14] == 'I' && line[15] == 'T' && line[16] == '_' && line[17] == 'R' && line[18] == 'U' && line[19] == 'N' && line[20] == '_' && line[21] == 'T' && line[22] == 'E' && line[23] == 'S' && line[24] == 'T' && line[25] == '_' && line[26] == 'S' && line[27] == 'U' && line[28] == 'C' && line[29] == 'C' && line[30] == 'E' && line[31] == 'S' && line[32] == 'S' && line[33] == '>' && line[34] == ' ')\n");
						
						fw.write("printf(\"PASS\\n\");\n");
						
						fw.write("if(line[0] == ' ' && line[1] == ' ' && line[2] == ' ' && line[3] == ' ' && line[4] == ' ' && line[5] == ' ' && line[6] == ' ' && line[7] == ' ' && line[8] == ' ' && line[9] == ' ' && line[10] == '<' && line[11] == 'C' && line[12] == 'U' && line[13] == 'N' && line[14] == 'I' && line[15] == 'T' && line[16] == '_' && line[17] == 'R' && line[18] == 'U' && line[19] == 'N' && line[20] == '_' && line[21] == 'T' && line[22] == 'E' && line[23] == 'S' && line[24] == 'T' && line[25] == '_' && line[26] == 'F' && line[27] == 'A' && line[28] == 'I' && line[29] == 'L' && line[30] == 'U' && line[31] == 'R' && line[32] == 'E' && line[33] == '>' && line[34] == ' ')\n");
						
						fw.write("printf(\"FAIL\\n\");\n");
						
						fw.write("}\n");
						
						fw.write("i = 0;\n");
						
						fw.write("}\n");
						
						fw.write("c = getc(f);\n");
						
						fw.write("}\n");
						
						fw.write("fclose(f);\n");
						
						fw.write("}\n");

						fw.write("}\n");

						replace = true;

					} else {

						fw.write(line + "\n");

					}

				}

				fw.close();
				br.close();
				fr.close();

				if (replace) {
					file.delete();
					tf.renameTo(file);
				}

			} finally {

				if (fw != null)
					fw.close();
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();

			}

			File shareDir = new File(Constants.CUNIT_SHARE_FILE);
			FileUtil.unzip(shareDir, tmpDir);

		}

		return new File(tmpDir + File.separator + CUNIT_OUTPUT_FILENAME);

	}

	public static boolean isCUnitTest(File cFile) throws IOException {

		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(cFile);
			br = new BufferedReader(fr);

			while (br.ready()) {

				String line = br.readLine();

				if (line.contains("CU_automated_run_tests()"))
					return true;

			}

			br.close();
			fr.close();

		} finally {

			if (br != null)
				br.close();
			if (fr != null)
				fr.close();

		}

		return false;

	}

}
