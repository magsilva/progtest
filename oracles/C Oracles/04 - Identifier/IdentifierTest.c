#include "IdentifierTest.h"

void test1(void) {

	char str[1] = "";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test2(void) {

	char str[2] = "a";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test3(void) {

	char str[3] = "a1";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test4(void) {

	char str[6] = "a1b2c";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test5(void) {

	char str[7] = "a1b2c3";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test6(void) {

	char str[8] = "a1b2c3d";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test7(void) {

	char str[7] = "01b2c3";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test8(void) {

	char str[7] = "#1b2c3";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test9(void) {

	char str[7] = "a#b2c3";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test10(void) {

	char str[7] = "A1b2c3";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test11(void) {

	char str[7] = "B1b2c3";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test12(void) {

	char str[7] = "[1b2c3";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test13(void) {

	char str[7] = "b1b2c3";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test14(void) {

	char str[7] = "{1b2c3";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test15(void) {

	char str[7] = "Z1b2c3";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test16(void) {

	char str[7] = "z1b2c3";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test17(void) {

	char str[7] = "@1b2c3";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test18(void) {

	char str[7] = "`1b2c3";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test19(void) {

	char str[7] = "a1A2c3";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test20(void) {

	char str[7] = "a1@2c3";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test21(void) {

	char str[7] = "a1[2c3";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test22(void) {

	char str[7] = "a1B2c3";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test23(void) {

	char str[7] = "a1{2c3";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test24(void) {

	char str[7] = "a1Z2c3";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test25(void) {

	char str[7] = "a1a2c3";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test26(void) {

	char str[7] = "a1z2c3";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test27(void) {

	char str[7] = "a102c3";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test28(void) {

	char str[7] = "a192c3";

	CU_ASSERT_EQUAL(1, identifier(str));

}

void test29(void) {

	char str[7] = "a1`2c3";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test30(void) {

	char str[7] = "a/2c3";

	CU_ASSERT_EQUAL(0, identifier(str));

}

void test31(void) {

	char str[7] = "a1:2c3";

	CU_ASSERT_EQUAL(0, identifier(str));

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
		(NULL == CU_add_test(pSuite, "test27", test27)) ||
		(NULL == CU_add_test(pSuite, "test28", test28)) ||
		(NULL == CU_add_test(pSuite, "test29", test29)) ||
		(NULL == CU_add_test(pSuite, "test30", test30)) ||
		(NULL == CU_add_test(pSuite, "test31", test31)))
	{
		CU_cleanup_registry();
		return CU_get_error();
	}

	CU_automated_run_tests();

	CU_cleanup_registry();

	return CU_get_error();

}
