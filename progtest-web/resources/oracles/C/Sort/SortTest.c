#include "SortTest.h"

void test1(void) {

	unsigned char n = 10;
	short int values[10] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

	sort(values, n);

	CU_ASSERT_EQUAL(1, values[0]);
	CU_ASSERT_EQUAL(2, values[1]);
	CU_ASSERT_EQUAL(3, values[2]);
	CU_ASSERT_EQUAL(4, values[3]);
	CU_ASSERT_EQUAL(5, values[4]);
	CU_ASSERT_EQUAL(6, values[5]);
	CU_ASSERT_EQUAL(7, values[6]);
	CU_ASSERT_EQUAL(8, values[7]);
	CU_ASSERT_EQUAL(9, values[8]);
	CU_ASSERT_EQUAL(10, values[9]);

}

void test2(void) {

	unsigned char n = 10;
	short int values[10] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

	sort(values, n);

	CU_ASSERT_EQUAL(0, values[0]);
	CU_ASSERT_EQUAL(1, values[1]);
	CU_ASSERT_EQUAL(2, values[2]);
	CU_ASSERT_EQUAL(3, values[3]);
	CU_ASSERT_EQUAL(4, values[4]);
	CU_ASSERT_EQUAL(5, values[5]);
	CU_ASSERT_EQUAL(6, values[6]);
	CU_ASSERT_EQUAL(7, values[7]);
	CU_ASSERT_EQUAL(8, values[8]);
	CU_ASSERT_EQUAL(9, values[9]);

}

void test3(void) {

	unsigned char n = 10;
	short int values[10] = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};

	sort(values, n);

	CU_ASSERT_EQUAL(-10, values[0]);
	CU_ASSERT_EQUAL(-9, values[1]);
	CU_ASSERT_EQUAL(-8, values[2]);
	CU_ASSERT_EQUAL(-7, values[3]);
	CU_ASSERT_EQUAL(-6, values[4]);
	CU_ASSERT_EQUAL(-5, values[5]);
	CU_ASSERT_EQUAL(-4, values[6]);
	CU_ASSERT_EQUAL(-3, values[7]);
	CU_ASSERT_EQUAL(-2, values[8]);
	CU_ASSERT_EQUAL(-1, values[9]);

}

void test4(void) {

	unsigned char n = 0;
	short int values[0] = {};

	sort(values, n);

	CU_PASS("");

}

void test5(void) {

	unsigned char n = 1;
	short int values[1] = {10};

	sort(values, n);

	CU_ASSERT_EQUAL(10, values[0]);

}

void test6(void) {

	unsigned char n = 10;
	short int values[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

	sort(values, n);

	CU_ASSERT_EQUAL(1, values[0]);
	CU_ASSERT_EQUAL(2, values[1]);
	CU_ASSERT_EQUAL(3, values[2]);
	CU_ASSERT_EQUAL(4, values[3]);
	CU_ASSERT_EQUAL(5, values[4]);
	CU_ASSERT_EQUAL(6, values[5]);
	CU_ASSERT_EQUAL(7, values[6]);
	CU_ASSERT_EQUAL(8, values[7]);
	CU_ASSERT_EQUAL(9, values[8]);
	CU_ASSERT_EQUAL(10, values[9]);

}

void test7(void) {

	unsigned char n = 10;
	short int values[10] = {9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

	sort(values, n);

	CU_ASSERT_EQUAL(1, values[0]);
	CU_ASSERT_EQUAL(2, values[1]);
	CU_ASSERT_EQUAL(3, values[2]);
	CU_ASSERT_EQUAL(4, values[3]);
	CU_ASSERT_EQUAL(5, values[4]);
	CU_ASSERT_EQUAL(6, values[5]);
	CU_ASSERT_EQUAL(7, values[6]);
	CU_ASSERT_EQUAL(8, values[7]);
	CU_ASSERT_EQUAL(9, values[8]);
	CU_ASSERT_EQUAL(10, values[9]);

}

void test8(void) {

	unsigned char n = 10;
	short int values[10] = {10, 10, 8, 7, 6, 5, 4, 3, 2, 1};

	sort(values, n);

	CU_ASSERT_EQUAL(1, values[0]);
	CU_ASSERT_EQUAL(2, values[1]);
	CU_ASSERT_EQUAL(3, values[2]);
	CU_ASSERT_EQUAL(4, values[3]);
	CU_ASSERT_EQUAL(5, values[4]);
	CU_ASSERT_EQUAL(6, values[5]);
	CU_ASSERT_EQUAL(7, values[6]);
	CU_ASSERT_EQUAL(8, values[7]);
	CU_ASSERT_EQUAL(10, values[8]);
	CU_ASSERT_EQUAL(10, values[9]);

}

void test9(void) {

	unsigned char n = 10;
	short int values[10] = {10, 9, 8, 7, 6, 5, 4, 3, 1, 1};

	sort(values, n);

	CU_ASSERT_EQUAL(1, values[0]);
	CU_ASSERT_EQUAL(1, values[1]);
	CU_ASSERT_EQUAL(3, values[2]);
	CU_ASSERT_EQUAL(4, values[3]);
	CU_ASSERT_EQUAL(5, values[4]);
	CU_ASSERT_EQUAL(6, values[5]);
	CU_ASSERT_EQUAL(7, values[6]);
	CU_ASSERT_EQUAL(8, values[7]);
	CU_ASSERT_EQUAL(9, values[8]);
	CU_ASSERT_EQUAL(10, values[9]);

}

void test10(void) {

	unsigned char n = 10;
	short int values[10] = {10, 9, 9, 7, 6, 5, 4, 3, 2, 1};

	sort(values, n);

	CU_ASSERT_EQUAL(1, values[0]);
	CU_ASSERT_EQUAL(2, values[1]);
	CU_ASSERT_EQUAL(3, values[2]);
	CU_ASSERT_EQUAL(4, values[3]);
	CU_ASSERT_EQUAL(5, values[4]);
	CU_ASSERT_EQUAL(6, values[5]);
	CU_ASSERT_EQUAL(7, values[6]);
	CU_ASSERT_EQUAL(9, values[7]);
	CU_ASSERT_EQUAL(9, values[8]);
	CU_ASSERT_EQUAL(10, values[9]);

}

void test11(void) {

	unsigned char n = 10;
	short int values[10] = {9, 10, 7, 8, 5, 6, 4, 1, 2, 3};

	sort(values, n);

	CU_ASSERT_EQUAL(1, values[0]);
	CU_ASSERT_EQUAL(2, values[1]);
	CU_ASSERT_EQUAL(3, values[2]);
	CU_ASSERT_EQUAL(4, values[3]);
	CU_ASSERT_EQUAL(5, values[4]);
	CU_ASSERT_EQUAL(6, values[5]);
	CU_ASSERT_EQUAL(7, values[6]);
	CU_ASSERT_EQUAL(8, values[7]);
	CU_ASSERT_EQUAL(9, values[8]);
	CU_ASSERT_EQUAL(10, values[9]);

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
		(NULL == CU_add_test(pSuite, "test11", test11)) ||
		(NULL == CU_add_test(pSuite, "test10", test10))
	) {
		CU_cleanup_registry();
		return CU_get_error();
	}

	CU_automated_run_tests();

	CU_cleanup_registry();

	return CU_get_error();

}
