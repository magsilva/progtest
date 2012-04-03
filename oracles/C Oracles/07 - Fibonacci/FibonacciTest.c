#include "FibonacciTest.h"

void test1(void) {

	unsigned char n = 0;

	CU_ASSERT_EQUAL(0, fibonacci(n));

}

void test2(void) {

	unsigned char n = 1;

	CU_ASSERT_EQUAL(1, fibonacci(n));

}

void test3(void) {

	unsigned char n = 2;

	CU_ASSERT_EQUAL(1, fibonacci(n));

}

void test4(void) {

	unsigned char n = 4;

	CU_ASSERT_EQUAL(3, fibonacci(n));

}

int main(void) {

	CU_pSuite pSuite = NULL;

	if (CUE_SUCCESS != CU_initialize_registry())
		return CU_get_error();

	pSuite = CU_add_suite("CUnit Suite", NULL, NULL);
	if (NULL == pSuite) {
		CU_cleanup_registry();
		return CU_get_error();
	}

	if ((NULL == CU_add_test(pSuite, "test1", test1)) ||
		(NULL == CU_add_test(pSuite, "test2", test2)) ||
		(NULL == CU_add_test(pSuite, "test3", test3)) ||
		(NULL == CU_add_test(pSuite, "test4", test4))
	) {
		CU_cleanup_registry();
		return CU_get_error();
	}

	CU_automated_run_tests();

	CU_cleanup_registry();

	return CU_get_error();

}
