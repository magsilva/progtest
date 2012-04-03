#include "MaxMinTest.h"

void test1(void) {

	short int values[1] = {-1};
	unsigned char n = 1;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(1, max_min[0]);
	CU_ASSERT_EQUAL(-1, max_min[1]);
	CU_ASSERT_EQUAL(-1, max_min[2]);

	free(max_min);

}

void test2(void) {

	short int values[1] = {0};
	unsigned char n = 1;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(1, max_min[0]);
	CU_ASSERT_EQUAL(0, max_min[1]);
	CU_ASSERT_EQUAL(0, max_min[2]);

	free(max_min);

}

void test3(void) {

	short int values[1] = {1};
	unsigned char n = 1;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(1, max_min[0]);
	CU_ASSERT_EQUAL(1, max_min[1]);
	CU_ASSERT_EQUAL(1, max_min[2]);

	free(max_min);

}

void test4(void) {

	short int values[0] = {};
	unsigned char n = 0;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(0, max_min[0]);

	free(max_min);

}

void test5(void) {

	short int values[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	unsigned char n = 10;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(1, max_min[0]);
	CU_ASSERT_EQUAL(10, max_min[1]);
	CU_ASSERT_EQUAL(1, max_min[2]);

	free(max_min);

}

void test6(void) {

	short int values[10] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	unsigned char n = 10;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(1, max_min[0]);
	CU_ASSERT_EQUAL(10, max_min[1]);
	CU_ASSERT_EQUAL(1, max_min[2]);

	free(max_min);

}

void test7(void) {

	short int values[10] = {3, 1, 4, 2, 5, 6, 7, 8, 10, 9};
	unsigned char n = 10;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(1, max_min[0]);
	CU_ASSERT_EQUAL(10, max_min[1]);
	CU_ASSERT_EQUAL(1, max_min[2]);

	free(max_min);

}

void test8(void) {

	short int values[10] = {1, 2, 3, 4, 5, 6, 7, 8, 10, 10};
	unsigned char n = 10;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(1, max_min[0]);
	CU_ASSERT_EQUAL(10, max_min[1]);
	CU_ASSERT_EQUAL(1, max_min[2]);

	free(max_min);

}

void test9(void) {

	short int values[10] = {1, 1, 3, 4, 5, 6, 7, 8, 9, 10};
	unsigned char n = 10;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(1, max_min[0]);
	CU_ASSERT_EQUAL(10, max_min[1]);
	CU_ASSERT_EQUAL(1, max_min[2]);

	free(max_min);

}

void test10(void) {

	short int values[10] = {1, 2, 2, 4, 5, 6, 7, 8, 9, 10};
	unsigned char n = 10;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(1, max_min[0]);
	CU_ASSERT_EQUAL(10, max_min[1]);
	CU_ASSERT_EQUAL(1, max_min[2]);

	free(max_min);

}

void test11(void) {

	short int values[10] = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
	unsigned char n = 10;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(1, max_min[0]);
	CU_ASSERT_EQUAL(-1, max_min[1]);
	CU_ASSERT_EQUAL(-10, max_min[2]);

	free(max_min);

}

void test12(void) {

	short int values[10] = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	unsigned char n = 10;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(1, max_min[0]);
	CU_ASSERT_EQUAL(10, max_min[1]);
	CU_ASSERT_EQUAL(0, max_min[2]);

	free(max_min);

}

void test13(void) {

	short int values[10] = {-1, 0, 3, 4, 5, 6, 7, 8, 9, 10};
	unsigned char n = 10;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(1, max_min[0]);
	CU_ASSERT_EQUAL(10, max_min[1]);
	CU_ASSERT_EQUAL(-1, max_min[2]);

	free(max_min);

}

void test14(void) {

	short int values[10] = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1};
	unsigned char n = 10;

	short int *max_min = maxmin(values, n);

	CU_ASSERT_EQUAL(1, max_min[0]);
	CU_ASSERT_EQUAL(-1, max_min[1]);
	CU_ASSERT_EQUAL(-10, max_min[2]);

	free(max_min);

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
		(NULL == CU_add_test(pSuite, "test4", test4)) ||
		(NULL == CU_add_test(pSuite, "test5", test5)) ||
		(NULL == CU_add_test(pSuite, "test6", test6)) ||
		(NULL == CU_add_test(pSuite, "test7", test7)) ||
		(NULL == CU_add_test(pSuite, "test8", test8)) ||
		(NULL == CU_add_test(pSuite, "test9", test9)) ||
		(NULL == CU_add_test(pSuite, "test10", test10)) ||
		(NULL == CU_add_test(pSuite, "test11", test11)) ||
		(NULL == CU_add_test(pSuite, "test12", test12)) ||
		(NULL == CU_add_test(pSuite, "test13", test13)) ||
		(NULL == CU_add_test(pSuite, "test14", test14))
	) {
		CU_cleanup_registry();
		return CU_get_error();
	}

	CU_automated_run_tests();

	CU_cleanup_registry();

	return CU_get_error();

}
