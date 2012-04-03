#include "Factorial.h"

unsigned long long int factorial(unsigned char n) {
	if (n <= 1)
		return 1;
	else
		return n * factorial(n - 1);
}
