#include "PalindromeTest.h"

void test1(void) {

	char word[3] = {'M', 'M', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test2(void) {

	char word[4] = {'M', 'N', 'M', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test3(void) {

	char word[5] = {'M', 'N', 'N', 'M','\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test4(void) {

	char word[4] = {'/', 'M', '/', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test5(void) {

	char word[4] = {'0', 'M', '0', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test6(void) {

	char word[4] = {'1', 'M', '1', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test7(void) {

	char word[4] = {'8', 'M', '8', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test8(void) {

	char word[4] = {'9', 'M', '9', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test9(void) {

	char word[4] = {':', 'M', ':', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test10(void) {

	char word[4] = {'@', 'M', '@', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test11(void) {

	char word[4] = {'A', 'M', 'A', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test12(void) {

	char word[4] = {'B', 'M', 'B', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test13(void) {

	char word[4] = {'Y', 'M', 'Y', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test14(void) {

	char word[4] = {'Z', 'M', 'Z', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test15(void) {

	char word[4] = {'[', 'M', '[', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test16(void) {

	char word[4] = {'`', 'm', '`', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test17(void) {

	char word[4] = {'a', 'm', 'a', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test18(void) {

	char word[4] = {'b', 'm', 'b', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test19(void) {

	char word[4] = {'y', 'm', 'y', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test20(void) {

	char word[4] = {'z', 'm', 'z', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test21(void) {

	char word[4] = {'{', 'm', '{', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test22(void) {

	char word[4] = {'@', 'M', '`', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test23(void) {

	char word[4] = {'`', 'M', '@', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test24(void) {

	char word[4] = {'A', 'M', 'a', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test25(void) {

	char word[4] = {'a', 'M', 'A', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test26(void) {

	char word[4] = {'B', 'M', 'b', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test27(void) {

	char word[4] = {'b', 'M', 'B', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test28(void) {

	char word[4] = {'Y', 'M', 'y', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test29(void) {

	char word[4] = {'y', 'M', 'Y', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test30(void) {

	char word[4] = {'Z', 'M', 'z', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test31(void) {

	char word[4] = {'z', 'M', 'Z', '\0'};

	CU_ASSERT_EQUAL(1, palindrome(word));

}

void test32(void) {

	char word[4] = {'[', 'M', '{', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test33(void) {

	char word[4] = {'{', 'M', '[', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test34(void) {

	char word[2] = {'{', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

}

void test35(void) {

	char word[4] = {'a', 'b', 'c', '\0'};

	CU_ASSERT_EQUAL(0, palindrome(word));

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
		(NULL == CU_add_test(pSuite, "test31", test31)) ||
		(NULL == CU_add_test(pSuite, "test32", test32)) ||
		(NULL == CU_add_test(pSuite, "test33", test33)) ||
		(NULL == CU_add_test(pSuite, "test34", test34)) ||
		(NULL == CU_add_test(pSuite, "test35", test35))
	) {
		CU_cleanup_registry();
		return CU_get_error();
	}

	CU_automated_run_tests();

	CU_cleanup_registry();

	return CU_get_error();

}
