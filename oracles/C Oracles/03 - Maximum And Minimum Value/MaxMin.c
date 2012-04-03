#include "MaxMin.h"

short int maximum(short int *values, unsigned char n) {
	short int max = values[0];
	unsigned char i;
	for (i = 1; i < n; i++)
		if (max < values[i])
			max = values[i];
	return max;
}

short int minimum(short int *values, unsigned char n) {
	short int min = values[0];
	unsigned char i;
	for (i = 1; i < n; i++)
		if (min > values[i])
			min = values[i];
	return min;
}

short int *maxmin(short int *values, unsigned char n) {
	short int *maxmin = (short int *) calloc(3, sizeof(short int));
	if (n > 0) {
		maxmin[0] = 1;
		maxmin[1] = maximum(values, n);
		maxmin[2] = minimum(values, n);
	} else {
		maxmin[0] = 0;
	}
	return maxmin;
}
