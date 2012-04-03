#include "Fibonacci.h"

unsigned char fibonacci(unsigned char n) {
	if (n < 2)
		return n;
	else
		return (fibonacci(n - 1) + fibonacci(n - 2));
}
