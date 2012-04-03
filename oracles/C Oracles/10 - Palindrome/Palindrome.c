#include "Palindrome.h"

unsigned char valid_char(char c) {
	if (((c >= 'A') &&
		(c <= 'Z')) ||
		((c >= 'a') &&
		(c <= 'z')))
		return 1;
	else
		return 0;
}

unsigned char palindrome(char *word) {
	unsigned char i, j, n;
	n = strlen(word);
	for (i = 0; i < n; i++)
		if(!valid_char(word[i]))
			return 0;
	for (i = 0; i < n; i++)
		if(word[i] >= 'a')
			word[i] = word[i] - ' ';
	for (i = 0, j = n - 1; i <= j; i++, j--)
		if(word[i] != word[j])
			return 0;
	return 1;
}
