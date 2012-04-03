#include "Min.h"

short int minimum(short int *values, unsigned char n) {
	short int min = values[0];
	unsigned char i;
	for (i = 1; i < n; i++)
		if (min > values[i])
			min = values[i];
	return min;
}

short int *min(short int *values, unsigned char n) {
	short int *min = (short int *) calloc(2, sizeof(short int));
	if (n > 0) {
		min[0] = 1;
		min[1] = minimum(values, n);
	} else {
		min[0] = 0;
	}
	return min;
}
