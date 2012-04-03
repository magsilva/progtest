#include "Max.h"

short int maximum(short int *values, unsigned char n) {
	short int max = values[0];
	unsigned char i;
	for (i = 1; i < n; i++)
		if (max < values[i])
			max = values[i];
	return max;
}

short int *max(short int *values, unsigned char n) {
	short int *max = (short int *) calloc(2, sizeof(short int));
	if (n > 0) {
		max[0] = 1;
		max[1] = maximum(values, n);
	} else {
		max[0] = 0;
	}
	return max;
}
