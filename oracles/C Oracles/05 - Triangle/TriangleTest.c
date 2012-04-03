#include "TriangleTest.h"

void test1(void) {

	unsigned char a = 5, b = 4, c = 3;

	CU_ASSERT_EQUAL(1, triangle(a, b, c));

}

void test2(void) {

	unsigned char a = 5, b = 3, c = 4;

	CU_ASSERT_EQUAL(1, triangle(a, b, c));

}

void test3(void) {

	unsigned char a = 4, b = 5, c = 3;

	CU_ASSERT_EQUAL(1, triangle(a, b, c));

}

void test4(void) {

	unsigned char a = 3, b = 5, c = 4;

	CU_ASSERT_EQUAL(1, triangle(a, b, c));

}

void test5(void) {

	unsigned char a = 4, b = 3, c = 5;

	CU_ASSERT_EQUAL(1, triangle(a, b, c));

}

void test6(void) {

	unsigned char a = 3, b = 4, c = 5;

	CU_ASSERT_EQUAL(1, triangle(a, b, c));

}

void test7(void) {

	unsigned char a = 5, b = 5, c = 3;

	CU_ASSERT_EQUAL(2, triangle(a, b, c));

}

void test8(void) {

	unsigned char a = 3, b = 5, c = 5;

	CU_ASSERT_EQUAL(2, triangle(a, b, c));

}

void test9(void) {

	unsigned char a = 5, b = 3, c = 5;

	CU_ASSERT_EQUAL(2, triangle(a, b, c));

}

void test10(void) {

	unsigned char a = 3, b = 3, c = 5;

	CU_ASSERT_EQUAL(2, triangle(a, b, c));

}

void test11(void) {

	unsigned char a = 5, b = 3, c = 3;

	CU_ASSERT_EQUAL(2, triangle(a, b, c));

}

void test12(void) {

	unsigned char a = 3, b = 5, c = 3;

	CU_ASSERT_EQUAL(2, triangle(a, b, c));

}

void test13(void) {

	unsigned char a = 4, b = 4, c = 4;

	CU_ASSERT_EQUAL(3, triangle(a, b, c));

}

void test14(void) {

	unsigned char a = 4, b = 2, c = 2;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

}

void test15(void) {

	unsigned char a = 2, b = 4, c = 2;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

}

void test16(void) {

	unsigned char a = 2, b = 2, c = 4;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

}

void test17(void) {

	unsigned char a = 5, b = 2, c = 2;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

}

void test18(void) {

	unsigned char a = 2, b = 5, c = 2;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

}

void test19(void) {

	unsigned char a = 2, b = 2, c = 5;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

}

void test20(void) {

	unsigned char a = 0, b = 4, c = 5;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

}

void test21(void) {

	unsigned char a = 5, b = 0, c = 4;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

}

void test22(void) {

	unsigned char a = 4, b = 5, c = 0;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

}

void test23(void) {

	unsigned char a = 0, b = 0, c = 3;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

}

void test24(void) {

	unsigned char a = 3, b = 0, c = 0;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

}

void test25(void) {

	unsigned char a = 0, b = 3, c = 0;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

}

void test26(void) {

	unsigned char a = 0, b = 0, c = 0;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

}

void test27(void) {

	unsigned char a = 1, b = 1, c = 0;

	CU_ASSERT_EQUAL(0, triangle(a, b, c));

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
		(NULL == CU_add_test(pSuite, "test14", test14)) ||
		(NULL == CU_add_test(pSuite, "test15", test15)) ||
		(NULL == CU_add_test(pSuite, "test16", test16)) ||
		(NULL == CU_add_test(pSuite, "test17", test17)) ||
		(NULL == CU_add_test(pSuite, "test18", test18)) ||
		(NULL == CU_add_test(pSuite, "test19", test19)) ||
		(NULL == CU_add_test(pSuite, "test20", test20)) ||
		(NULL == CU_add_test(pSuite, "test21", test21)) ||
		(NULL == CU_add_test(pSuite, "test22", test22)) ||
		(NULL == CU_add_test(pSuite, "test23", test23)) ||
		(NULL == CU_add_test(pSuite, "test24", test24)) ||
		(NULL == CU_add_test(pSuite, "test25", test25)) ||
		(NULL == CU_add_test(pSuite, "test26", test26)) ||
		(NULL == CU_add_test(pSuite, "test27", test27))
	) {
		CU_cleanup_registry();
		return CU_get_error();
	}

	CU_automated_run_tests();

	CU_cleanup_registry();

	return CU_get_error();

}
