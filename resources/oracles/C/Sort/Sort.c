#include "Sort.h"

void swap(unsigned char x, unsigned char y, short int *values) {
	int aux = values[x];
	values[x] = values[y];
	values[y] = aux;
}

void redo(unsigned char begin, unsigned char end, short int *values) {
	unsigned char i, j;
	i = begin; 
	j = (i * 2) + 1;
	while (j <= end) {
		if (j < end)
			if (values[j] < values[j+1])
				j++;
		if (values[i] < values[j])
			swap(i, j, values);
		i = j;
		j = (i * 2) + 1;
	}
}

void build(short int *values, unsigned char n) {
	unsigned char begin, end;
	begin = n / 2;
	end = n - 1;
	while (begin > 0) {
		begin--;
		redo(begin, end, values);
	}
}

void heapsort(short int *values, unsigned char n) {
	unsigned char begin = 0, end = n - 1;
	build(values, n);
	while (end > 0) {
		swap(begin, end, values);
		end--;
		redo(begin, end, values);
	}
}

void sort(short int *values, unsigned char n) {
	if(n != 0)
		heapsort(values, n);
}

