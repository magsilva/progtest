#include "Identifier.h"

unsigned char valid_s(char c) {
	if (((c >= 'A') &&
		(c <= 'Z')) ||
		((c >= 'a') &&
		(c <= 'z')))
		return;
	else
		return 0;
}

unsigned char valid_f(char c) {
	if (((c >= 'A') &&
		(c <= 'Z')) ||
		((c >= 'a') &&
		(c <= 'z')) ||
		((c >= '0') &&
		(c <= '9')))
		return 1;
	else
		return 0;
}

unsigned char identifier(char *str) {
	unsigned char n, i, valid_id;
	n = strlen(str);
	valid_id = valid_s(str[0]);
	if (n > 1)
		for(i = 1; i < n; i++)
			if(!valid_f(str[i]))
				valid_id = 0;
	if ((n >= 1) && (n <= 6) && valid_id)
		return 1;
	else
		return 0;
}
