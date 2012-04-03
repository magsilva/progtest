#include "CalTest.h"

void test1(void) {

	short int day = 15;
	short int month = 6;
	short int year = 0;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test2(void) {

	short int day = 15;
	short int month = 6;
	short int year = 1;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test3(void) {

	short int day = 15;
	short int month = 6;
	short int year = 2;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test4(void) {

	short int day = 15;
	short int month = 6;
	short int year = 9998;

	CU_ASSERT_EQUAL(2, cal(day, month, year));

}

void test5(void) {

	short int day = 15;
	short int month = 6;
	short int year = 9999;

	CU_ASSERT_EQUAL(3, cal(day, month, year));

}

void test6(void) {

	short int day = 15;
	short int month = 6;
	short int year = 10000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test7(void) {

	short int day = 15;
	short int month = 0;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test8(void) {

	short int day = 15;
	short int month = 1;
	short int year = 5000;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test9(void) {

	short int day = 15;
	short int month = 2;
	short int year = 5000;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test10(void) {

	short int day = 15;
	short int month = 11;
	short int year = 5000;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test11(void) {

	short int day = 15;
	short int month = 12;
	short int year = 5000;

	CU_ASSERT_EQUAL(2, cal(day, month, year));

}

void test12(void) {

	short int day = 15;
	short int month = 13;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test13(void) {

	short int day = 0;
	short int month = 1;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test14(void) {

	short int day = 1;
	short int month = 1;
	short int year = 5000;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test15(void) {

	short int day = 2;
	short int month = 1;
	short int year = 5000;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test16(void) {

	short int day = 30;
	short int month = 1;
	short int year = 5000;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test17(void) {

	short int day = 31;
	short int month = 1;
	short int year = 5000;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test18(void) {

	short int day = 32;
	short int month = 1;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test19(void) {

	short int day = 0;
	short int month = 3;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test20(void) {

	short int day = 1;
	short int month = 3;
	short int year = 5000;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test21(void) {

	short int day = 2;
	short int month = 3;
	short int year = 5000;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test22(void) {

	short int day = 30;
	short int month = 3;
	short int year = 5000;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test23(void) {

	short int day = 31;
	short int month = 3;
	short int year = 5000;

	CU_ASSERT_EQUAL(2, cal(day, month, year));

}

void test24(void) {

	short int day = 32;
	short int month = 3;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test25(void) {

	short int day = 0;
	short int month = 4;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test26(void) {

	short int day = 1;
	short int month = 4;
	short int year = 5000;

	CU_ASSERT_EQUAL(3, cal(day, month, year));

}

void test27(void) {

	short int day = 2;
	short int month = 4;
	short int year = 5000;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test28(void) {

	short int day = 29;
	short int month = 4;
	short int year = 5000;

	CU_ASSERT_EQUAL(3, cal(day, month, year));

}

void test29(void) {

	short int day = 30;
	short int month = 4;
	short int year = 5000;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test30(void) {

	short int day = 31;
	short int month = 4;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test31(void) {

	short int day = 0;
	short int month = 5;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test32(void) {

	short int day = 1;
	short int month = 5;
	short int year = 5000;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test33(void) {

	short int day = 2;
	short int month = 5;
	short int year = 5000;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test34(void) {

	short int day = 30;
	short int month = 5;
	short int year = 5000;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test35(void) {

	short int day = 31;
	short int month = 5;
	short int year = 5000;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test36(void) {

	short int day = 32;
	short int month = 5;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test37(void) {

	short int day = 0;
	short int month = 6;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test38(void) {

	short int day = 1;
	short int month = 6;
	short int year = 5000;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test39(void) {

	short int day = 2;
	short int month = 6;
	short int year = 5000;

	CU_ASSERT_EQUAL(2, cal(day, month, year));

}

void test40(void) {

	short int day = 29;
	short int month = 6;
	short int year = 5000;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test41(void) {

	short int day = 30;
	short int month = 6;
	short int year = 5000;

	CU_ASSERT_EQUAL(2, cal(day, month, year));

}

void test42(void) {

	short int day = 31;
	short int month = 6;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test43(void) {

	short int day = 0;
	short int month = 7;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test44(void) {

	short int day = 1;
	short int month = 7;
	short int year = 5000;

	CU_ASSERT_EQUAL(3, cal(day, month, year));

}

void test45(void) {

	short int day = 2;
	short int month = 7;
	short int year = 5000;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test46(void) {

	short int day = 30;
	short int month = 7;
	short int year = 5000;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test47(void) {

	short int day = 31;
	short int month = 7;
	short int year = 5000;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test48(void) {

	short int day = 32;
	short int month = 7;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test49(void) {

	short int day = 0;
	short int month = 8;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test50(void) {

	short int day = 1;
	short int month = 8;
	short int year = 5000;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test51(void) {

	short int day = 2;
	short int month = 8;
	short int year = 5000;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test52(void) {

	short int day = 30;
	short int month = 8;
	short int year = 5000;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test53(void) {

	short int day = 31;
	short int month = 8;
	short int year = 5000;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test54(void) {

	short int day = 32;
	short int month = 8;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test55(void) {

	short int day = 0;
	short int month = 10;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test56(void) {

	short int day = 1;
	short int month = 10;
	short int year = 5000;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test57(void) {

	short int day = 2;
	short int month = 10;
	short int year = 5000;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test58(void) {

	short int day = 30;
	short int month = 10;
	short int year = 5000;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test59(void) {

	short int day = 31;
	short int month = 10;
	short int year = 5000;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test60(void) {

	short int day = 32;
	short int month = 10;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test61(void) {

	short int day = 0;
	short int month = 11;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test62(void) {

	short int day = 1;
	short int month = 11;
	short int year = 5000;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test63(void) {

	short int day = 2;
	short int month = 11;
	short int year = 5000;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test64(void) {

	short int day = 29;
	short int month = 11;
	short int year = 5000;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test65(void) {

	short int day = 30;
	short int month = 11;
	short int year = 5000;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test66(void) {

	short int day = 31;
	short int month = 11;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test67(void) {

	short int day = 0;
	short int month = 12;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test68(void) {

	short int day = 1;
	short int month = 12;
	short int year = 5000;

	CU_ASSERT_EQUAL(2, cal(day, month, year));

}

void test69(void) {

	short int day = 2;
	short int month = 12;
	short int year = 5000;

	CU_ASSERT_EQUAL(3, cal(day, month, year));

}

void test70(void) {

	short int day = 30;
	short int month = 12;
	short int year = 5000;

	CU_ASSERT_EQUAL(3, cal(day, month, year));

}

void test71(void) {

	short int day = 31;
	short int month = 12;
	short int year = 5000;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test72(void) {

	short int day = 32;
	short int month = 12;
	short int year = 5000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test73(void) {

	short int day = 0;
	short int month = 2;
	short int year = 1600;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test74(void) {

	short int day = 1;
	short int month = 2;
	short int year = 1600;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test75(void) {

	short int day = 2;
	short int month = 2;
	short int year = 1600;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test76(void) {

	short int day = 28;
	short int month = 2;
	short int year = 1600;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test77(void) {

	short int day = 29;
	short int month = 2;
	short int year = 1600;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test78(void) {

	short int day = 30;
	short int month = 2;
	short int year = 1600;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test79(void) {

	short int day = 0;
	short int month = 2;
	short int year = 1700;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test80(void) {

	short int day = 1;
	short int month = 2;
	short int year = 1700;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test81(void) {

	short int day = 2;
	short int month = 2;
	short int year = 1700;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test82(void) {

	short int day = 28;
	short int month = 2;
	short int year = 1700;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test83(void) {

	short int day = 29;
	short int month = 2;
	short int year = 1700;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test84(void) {

	short int day = 30;
	short int month = 2;
	short int year = 1700;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test85(void) {

	short int day = 0;
	short int month = 2;
	short int year = 1748;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test86(void) {

	short int day = 1;
	short int month = 2;
	short int year = 1748;

	CU_ASSERT_EQUAL(2, cal(day, month, year));

}

void test87(void) {

	short int day = 2;
	short int month = 2;
	short int year = 1748;

	CU_ASSERT_EQUAL(3, cal(day, month, year));

}

void test88(void) {

	short int day = 28;
	short int month = 2;
	short int year = 1748;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test89(void) {

	short int day = 29;
	short int month = 2;
	short int year = 1748;

	CU_ASSERT_EQUAL(2, cal(day, month, year));

}

void test90(void) {

	short int day = 30;
	short int month = 2;
	short int year = 1748;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test91(void) {

	short int day = 0;
	short int month = 2;
	short int year = 1751;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test92(void) {

	short int day = 1;
	short int month = 2;
	short int year = 1751;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test93(void) {

	short int day = 2;
	short int month = 2;
	short int year = 1751;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test94(void) {

	short int day = 27;
	short int month = 2;
	short int year = 1751;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test95(void) {

	short int day = 28;
	short int month = 2;
	short int year = 1751;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test96(void) {

	short int day = 29;
	short int month = 2;
	short int year = 1751;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test97(void) {

	short int day = 0;
	short int month = 2;
	short int year = 1752;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test98(void) {

	short int day = 1;
	short int month = 2;
	short int year = 1752;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test99(void) {

	short int day = 2;
	short int month = 2;
	short int year = 1752;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test100(void) {

	short int day = 28;
	short int month = 2;
	short int year = 1752;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test101(void) {

	short int day = 29;
	short int month = 2;
	short int year = 1752;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test102(void) {

	short int day = 30;
	short int month = 2;
	short int year = 1752;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test103(void) {

	short int day = 0;
	short int month = 2;
	short int year = 1753;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test104(void) {

	short int day = 1;
	short int month = 2;
	short int year = 1753;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test105(void) {

	short int day = 2;
	short int month = 2;
	short int year = 1753;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test106(void) {

	short int day = 27;
	short int month = 2;
	short int year = 1753;

	CU_ASSERT_EQUAL(3, cal(day, month, year));

}

void test107(void) {

	short int day = 28;
	short int month = 2;
	short int year = 1753;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test108(void) {

	short int day = 29;
	short int month = 2;
	short int year = 1753;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test109(void) {

	short int day = 0;
	short int month = 2;
	short int year = 1756;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test110(void) {

	short int day = 1;
	short int month = 2;
	short int year = 1756;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test111(void) {

	short int day = 2;
	short int month = 2;
	short int year = 1756;

	CU_ASSERT_EQUAL(2, cal(day, month, year));

}

void test112(void) {

	short int day = 28;
	short int month = 2;
	short int year = 1756;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test113(void) {

	short int day = 29;
	short int month = 2;
	short int year = 1756;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test114(void) {

	short int day = 30;
	short int month = 2;
	short int year = 1756;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test115(void) {

	short int day = 0;
	short int month = 2;
	short int year = 1800;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test116(void) {

	short int day = 1;
	short int month = 2;
	short int year = 1800;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test117(void) {

	short int day = 2;
	short int month = 2;
	short int year = 1800;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test118(void) {

	short int day = 27;
	short int month = 2;
	short int year = 1800;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test119(void) {

	short int day = 28;
	short int month = 2;
	short int year = 1800;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test120(void) {

	short int day = 29;
	short int month = 2;
	short int year = 1800;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test121(void) {

	short int day = 0;
	short int month = 2;
	short int year = 2000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test122(void) {

	short int day = 1;
	short int month = 2;
	short int year = 2000;

	CU_ASSERT_EQUAL(3, cal(day, month, year));

}

void test123(void) {

	short int day = 2;
	short int month = 2;
	short int year = 2000;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test124(void) {

	short int day = 28;
	short int month = 2;
	short int year = 2000;

	CU_ASSERT_EQUAL(2, cal(day, month, year));

}

void test125(void) {

	short int day = 29;
	short int month = 2;
	short int year = 2000;

	CU_ASSERT_EQUAL(3, cal(day, month, year));

}

void test126(void) {

	short int day = 30;
	short int month = 2;
	short int year = 2000;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test127(void) {

	short int day = 0;
	short int month = 9;
	short int year = 1751;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test128(void) {

	short int day = 1;
	short int month = 9;
	short int year = 1751;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test129(void) {

	short int day = 2;
	short int month = 9;
	short int year = 1751;

	CU_ASSERT_EQUAL(2, cal(day, month, year));

}

void test130(void) {

	short int day = 29;
	short int month = 9;
	short int year = 1751;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test131(void) {

	short int day = 30;
	short int month = 9;
	short int year = 1751;

	CU_ASSERT_EQUAL(2, cal(day, month, year));

}

void test132(void) {

	short int day = 31;
	short int month = 9;
	short int year = 1751;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test133(void) {

	short int day = 0;
	short int month = 9;
	short int year = 1752;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test134(void) {

	short int day = 1;
	short int month = 9;
	short int year = 1752;

	CU_ASSERT_EQUAL(3, cal(day, month, year));

}

void test135(void) {

	short int day = 2;
	short int month = 9;
	short int year = 1752;

	CU_ASSERT_EQUAL(4, cal(day, month, year));

}

void test136(void) {

	short int day = 3;
	short int month = 9;
	short int year = 1752;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

//void test137(void) {
//
//	short int day = 4;
//	short int month = 9;
//	short int year = 1582;
//
//	CU_ASSERT_EQUAL(5, cal(day, month, year));
//
//}

//void test138(void) {
//
//	short int day = 5;
//	short int month = 9;
//	short int year = 1582;
//
//	CU_ASSERT_EQUAL(0, cal(day, month, year));
//
//}

void test139(void) {

	short int day = 13;
	short int month = 9;
	short int year = 1752;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test140(void) {

	short int day = 14;
	short int month = 9;
	short int year = 1752;

	CU_ASSERT_EQUAL(5, cal(day, month, year));

}

void test141(void) {

	short int day = 15;
	short int month = 9;
	short int year = 1752;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test142(void) {

	short int day = 29;
	short int month = 9;
	short int year = 1752;

	CU_ASSERT_EQUAL(6, cal(day, month, year));

}

void test143(void) {

	short int day = 30;
	short int month = 9;
	short int year = 1752;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test144(void) {

	short int day = 31;
	short int month = 9;
	short int year = 1752;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test145(void) {

	short int day = 0;
	short int month = 9;
	short int year = 1753;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

void test146(void) {

	short int day = 1;
	short int month = 9;
	short int year = 1753;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test147(void) {

	short int day = 2;
	short int month = 9;
	short int year = 1753;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test148(void) {

	short int day = 29;
	short int month = 9;
	short int year = 1753;

	CU_ASSERT_EQUAL(7, cal(day, month, year));

}

void test149(void) {

	short int day = 30;
	short int month = 9;
	short int year = 1753;

	CU_ASSERT_EQUAL(1, cal(day, month, year));

}

void test150(void) {

	short int day = 31;
	short int month = 9;
	short int year = 1753;

	CU_ASSERT_EQUAL(0, cal(day, month, year));

}

//void test151(void) {
//
//	short int day = 14;
//	short int month = 9;
//	short int year = 1582;
//
//	CU_ASSERT_EQUAL(0, cal(day, month, year));
//
//}

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
		(NULL == CU_add_test(pSuite, "test35", test35)) ||
		(NULL == CU_add_test(pSuite, "test36", test36)) ||
		(NULL == CU_add_test(pSuite, "test37", test37)) ||
		(NULL == CU_add_test(pSuite, "test38", test38)) ||
		(NULL == CU_add_test(pSuite, "test39", test39)) ||
		(NULL == CU_add_test(pSuite, "test40", test40)) ||
		(NULL == CU_add_test(pSuite, "test41", test41)) ||
		(NULL == CU_add_test(pSuite, "test42", test42)) ||
		(NULL == CU_add_test(pSuite, "test43", test43)) ||
		(NULL == CU_add_test(pSuite, "test44", test44)) ||
		(NULL == CU_add_test(pSuite, "test45", test45)) ||
		(NULL == CU_add_test(pSuite, "test46", test46)) ||
		(NULL == CU_add_test(pSuite, "test47", test47)) ||
		(NULL == CU_add_test(pSuite, "test48", test48)) ||
		(NULL == CU_add_test(pSuite, "test49", test49)) ||
		(NULL == CU_add_test(pSuite, "test50", test50)) ||
		(NULL == CU_add_test(pSuite, "test51", test51)) ||
		(NULL == CU_add_test(pSuite, "test52", test52)) ||
		(NULL == CU_add_test(pSuite, "test53", test53)) ||
		(NULL == CU_add_test(pSuite, "test54", test54)) ||
		(NULL == CU_add_test(pSuite, "test55", test55)) ||
		(NULL == CU_add_test(pSuite, "test56", test56)) ||
		(NULL == CU_add_test(pSuite, "test57", test57)) ||
		(NULL == CU_add_test(pSuite, "test58", test58)) ||
		(NULL == CU_add_test(pSuite, "test59", test59)) ||
		(NULL == CU_add_test(pSuite, "test60", test60)) ||
		(NULL == CU_add_test(pSuite, "test61", test61)) ||
		(NULL == CU_add_test(pSuite, "test62", test62)) ||
		(NULL == CU_add_test(pSuite, "test63", test63)) ||
		(NULL == CU_add_test(pSuite, "test64", test64)) ||
		(NULL == CU_add_test(pSuite, "test65", test65)) ||
		(NULL == CU_add_test(pSuite, "test66", test66)) ||
		(NULL == CU_add_test(pSuite, "test67", test67)) ||
		(NULL == CU_add_test(pSuite, "test68", test68)) ||
		(NULL == CU_add_test(pSuite, "test69", test69)) ||
		(NULL == CU_add_test(pSuite, "test70", test70)) ||
		(NULL == CU_add_test(pSuite, "test71", test71)) ||
		(NULL == CU_add_test(pSuite, "test72", test72)) ||
		(NULL == CU_add_test(pSuite, "test73", test73)) ||
		(NULL == CU_add_test(pSuite, "test74", test74)) ||
		(NULL == CU_add_test(pSuite, "test75", test75)) ||
		(NULL == CU_add_test(pSuite, "test76", test76)) ||
		(NULL == CU_add_test(pSuite, "test77", test77)) ||
		(NULL == CU_add_test(pSuite, "test78", test78)) ||
		(NULL == CU_add_test(pSuite, "test79", test79)) ||
		(NULL == CU_add_test(pSuite, "test80", test80)) ||
		(NULL == CU_add_test(pSuite, "test81", test81)) ||
		(NULL == CU_add_test(pSuite, "test82", test82)) ||
		(NULL == CU_add_test(pSuite, "test83", test83)) ||
		(NULL == CU_add_test(pSuite, "test84", test84)) ||
		(NULL == CU_add_test(pSuite, "test85", test85)) ||
		(NULL == CU_add_test(pSuite, "test86", test86)) ||
		(NULL == CU_add_test(pSuite, "test87", test87)) ||
		(NULL == CU_add_test(pSuite, "test88", test88)) ||
		(NULL == CU_add_test(pSuite, "test89", test89)) ||
		(NULL == CU_add_test(pSuite, "test90", test90)) ||
		(NULL == CU_add_test(pSuite, "test91", test91)) ||
		(NULL == CU_add_test(pSuite, "test92", test92)) ||
		(NULL == CU_add_test(pSuite, "test93", test93)) ||
		(NULL == CU_add_test(pSuite, "test94", test94)) ||
		(NULL == CU_add_test(pSuite, "test95", test95)) ||
		(NULL == CU_add_test(pSuite, "test96", test96)) ||
		(NULL == CU_add_test(pSuite, "test97", test97)) ||
		(NULL == CU_add_test(pSuite, "test98", test98)) ||
		(NULL == CU_add_test(pSuite, "test99", test99)) ||
		(NULL == CU_add_test(pSuite, "test100", test100)) ||
		(NULL == CU_add_test(pSuite, "test101", test101)) ||
		(NULL == CU_add_test(pSuite, "test102", test102)) ||
		(NULL == CU_add_test(pSuite, "test103", test103)) ||
		(NULL == CU_add_test(pSuite, "test104", test104)) ||
		(NULL == CU_add_test(pSuite, "test105", test105)) ||
		(NULL == CU_add_test(pSuite, "test106", test106)) ||
		(NULL == CU_add_test(pSuite, "test107", test107)) ||
		(NULL == CU_add_test(pSuite, "test108", test108)) ||
		(NULL == CU_add_test(pSuite, "test109", test109)) ||
		(NULL == CU_add_test(pSuite, "test110", test110)) ||
		(NULL == CU_add_test(pSuite, "test111", test111)) ||
		(NULL == CU_add_test(pSuite, "test112", test112)) ||
		(NULL == CU_add_test(pSuite, "test113", test113)) ||
		(NULL == CU_add_test(pSuite, "test114", test114)) ||
		(NULL == CU_add_test(pSuite, "test115", test115)) ||
		(NULL == CU_add_test(pSuite, "test116", test116)) ||
		(NULL == CU_add_test(pSuite, "test117", test117)) ||
		(NULL == CU_add_test(pSuite, "test118", test118)) ||
		(NULL == CU_add_test(pSuite, "test119", test119)) ||
		(NULL == CU_add_test(pSuite, "test120", test120)) ||
		(NULL == CU_add_test(pSuite, "test121", test121)) ||
		(NULL == CU_add_test(pSuite, "test122", test122)) ||
		(NULL == CU_add_test(pSuite, "test123", test123)) ||
		(NULL == CU_add_test(pSuite, "test124", test124)) ||
		(NULL == CU_add_test(pSuite, "test125", test125)) ||
		(NULL == CU_add_test(pSuite, "test126", test126)) ||
		(NULL == CU_add_test(pSuite, "test127", test127)) ||
		(NULL == CU_add_test(pSuite, "test128", test128)) ||
		(NULL == CU_add_test(pSuite, "test129", test129)) ||
		(NULL == CU_add_test(pSuite, "test130", test130)) ||
		(NULL == CU_add_test(pSuite, "test131", test131)) ||
		(NULL == CU_add_test(pSuite, "test132", test132)) ||
		(NULL == CU_add_test(pSuite, "test133", test133)) ||
		(NULL == CU_add_test(pSuite, "test134", test134)) ||
		(NULL == CU_add_test(pSuite, "test135", test135)) ||
		(NULL == CU_add_test(pSuite, "test136", test136)) ||
//		(NULL == CU_add_test(pSuite, "test137", test137)) ||
//		(NULL == CU_add_test(pSuite, "test138", test138)) ||
		(NULL == CU_add_test(pSuite, "test139", test139)) ||
		(NULL == CU_add_test(pSuite, "test140", test140)) ||
		(NULL == CU_add_test(pSuite, "test141", test141)) ||
		(NULL == CU_add_test(pSuite, "test142", test142)) ||
		(NULL == CU_add_test(pSuite, "test143", test143)) ||
		(NULL == CU_add_test(pSuite, "test144", test144)) ||
		(NULL == CU_add_test(pSuite, "test145", test145)) ||
		(NULL == CU_add_test(pSuite, "test146", test146)) ||
		(NULL == CU_add_test(pSuite, "test147", test147)) ||
		(NULL == CU_add_test(pSuite, "test148", test148)) ||
		(NULL == CU_add_test(pSuite, "test149", test149)) ||
		(NULL == CU_add_test(pSuite, "test150", test150)) //||
//		(NULL == CU_add_test(pSuite, "test150", test151))
	) {
		CU_cleanup_registry();
		return CU_get_error();
	}

	CU_automated_run_tests();

	CU_cleanup_registry();

	return CU_get_error();

}
