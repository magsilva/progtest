import static org.junit.Assert.*;

import org.junit.Test;

public class CalTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void test1() {
	
		int day = 15;
		int month = 6;
		int year = 0;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test2() {
	
		int day = 15;
		int month = 6;
		int year = 1;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test3() {
	
		int day = 15;
		int month = 6;
		int year = 2;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test4() {
	
		int day = 15;
		int month = 6;
		int year = 9998;
	
		assertEquals(2, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test5() {
	
		int day = 15;
		int month = 6;
		int year = 9999;
	
		assertEquals(3, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test6() {
	
		int day = 15;
		int month = 6;
		int year = 10000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test7() {
	
		int day = 15;
		int month = 0;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test8() {
	
		int day = 15;
		int month = 1;
		int year = 5000;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test9() {
	
		int day = 15;
		int month = 2;
		int year = 5000;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test10() {
	
		int day = 15;
		int month = 11;
		int year = 5000;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test11() {
	
		int day = 15;
		int month = 12;
		int year = 5000;
	
		assertEquals(2, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test12() {
	
		int day = 15;
		int month = 13;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test13() {
	
		int day = 0;
		int month = 1;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test14() {
	
		int day = 1;
		int month = 1;
		int year = 5000;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test15() {
	
		int day = 2;
		int month = 1;
		int year = 5000;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test16() {
	
		int day = 30;
		int month = 1;
		int year = 5000;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test17() {
	
		int day = 31;
		int month = 1;
		int year = 5000;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test18() {
	
		int day = 32;
		int month = 1;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test19() {
	
		int day = 0;
		int month = 3;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test20() {
	
		int day = 1;
		int month = 3;
		int year = 5000;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test21() {
	
		int day = 2;
		int month = 3;
		int year = 5000;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test22() {
	
		int day = 30;
		int month = 3;
		int year = 5000;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test23() {
	
		int day = 31;
		int month = 3;
		int year = 5000;
	
		assertEquals(2, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test24() {
	
		int day = 32;
		int month = 3;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test25() {
	
		int day = 0;
		int month = 4;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test26() {
	
		int day = 1;
		int month = 4;
		int year = 5000;
	
		assertEquals(3, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test27() {
	
		int day = 2;
		int month = 4;
		int year = 5000;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test28() {
	
		int day = 29;
		int month = 4;
		int year = 5000;
	
		assertEquals(3, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test29() {
	
		int day = 30;
		int month = 4;
		int year = 5000;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test30() {
	
		int day = 31;
		int month = 4;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test31() {
	
		int day = 0;
		int month = 5;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test32() {
	
		int day = 1;
		int month = 5;
		int year = 5000;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test33() {
	
		int day = 2;
		int month = 5;
		int year = 5000;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test34() {
	
		int day = 30;
		int month = 5;
		int year = 5000;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test35() {
	
		int day = 31;
		int month = 5;
		int year = 5000;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test36() {
	
		int day = 32;
		int month = 5;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test37() {
	
		int day = 0;
		int month = 6;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test38() {
	
		int day = 1;
		int month = 6;
		int year = 5000;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test39() {
	
		int day = 2;
		int month = 6;
		int year = 5000;
	
		assertEquals(2, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test40() {
	
		int day = 29;
		int month = 6;
		int year = 5000;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test41() {
	
		int day = 30;
		int month = 6;
		int year = 5000;
	
		assertEquals(2, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test42() {
	
		int day = 31;
		int month = 6;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test43() {
	
		int day = 0;
		int month = 7;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test44() {
	
		int day = 1;
		int month = 7;
		int year = 5000;
	
		assertEquals(3, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test45() {
	
		int day = 2;
		int month = 7;
		int year = 5000;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test46() {
	
		int day = 30;
		int month = 7;
		int year = 5000;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test47() {
	
		int day = 31;
		int month = 7;
		int year = 5000;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test48() {
	
		int day = 32;
		int month = 7;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test49() {
	
		int day = 0;
		int month = 8;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test50() {
	
		int day = 1;
		int month = 8;
		int year = 5000;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test51() {
	
		int day = 2;
		int month = 8;
		int year = 5000;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test52() {
	
		int day = 30;
		int month = 8;
		int year = 5000;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test53() {
	
		int day = 31;
		int month = 8;
		int year = 5000;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test54() {
	
		int day = 32;
		int month = 8;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test55() {
	
		int day = 0;
		int month = 10;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test56() {
	
		int day = 1;
		int month = 10;
		int year = 5000;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test57() {
	
		int day = 2;
		int month = 10;
		int year = 5000;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test58() {
	
		int day = 30;
		int month = 10;
		int year = 5000;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test59() {
	
		int day = 31;
		int month = 10;
		int year = 5000;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test60() {
	
		int day = 32;
		int month = 10;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test61() {
	
		int day = 0;
		int month = 11;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test62() {
	
		int day = 1;
		int month = 11;
		int year = 5000;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test63() {
	
		int day = 2;
		int month = 11;
		int year = 5000;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test64() {
	
		int day = 29;
		int month = 11;
		int year = 5000;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test65() {
	
		int day = 30;
		int month = 11;
		int year = 5000;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test66() {
	
		int day = 31;
		int month = 11;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test67() {
	
		int day = 0;
		int month = 12;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test68() {
	
		int day = 1;
		int month = 12;
		int year = 5000;
	
		assertEquals(2, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test69() {
	
		int day = 2;
		int month = 12;
		int year = 5000;
	
		assertEquals(3, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test70() {
	
		int day = 30;
		int month = 12;
		int year = 5000;
	
		assertEquals(3, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test71() {
	
		int day = 31;
		int month = 12;
		int year = 5000;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test72() {
	
		int day = 32;
		int month = 12;
		int year = 5000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test73() {
	
		int day = 0;
		int month = 2;
		int year = 1600;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test74() {
	
		int day = 1;
		int month = 2;
		int year = 1600;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test75() {
	
		int day = 2;
		int month = 2;
		int year = 1600;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test76() {
	
		int day = 28;
		int month = 2;
		int year = 1600;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test77() {
	
		int day = 29;
		int month = 2;
		int year = 1600;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test78() {
	
		int day = 30;
		int month = 2;
		int year = 1600;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test79() {
	
		int day = 0;
		int month = 2;
		int year = 1700;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test80() {
	
		int day = 1;
		int month = 2;
		int year = 1700;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test81() {
	
		int day = 2;
		int month = 2;
		int year = 1700;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test82() {
	
		int day = 28;
		int month = 2;
		int year = 1700;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test83() {
	
		int day = 29;
		int month = 2;
		int year = 1700;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test84() {
	
		int day = 30;
		int month = 2;
		int year = 1700;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test85() {
	
		int day = 0;
		int month = 2;
		int year = 1748;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test86() {
	
		int day = 1;
		int month = 2;
		int year = 1748;
	
		assertEquals(2, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test87() {
	
		int day = 2;
		int month = 2;
		int year = 1748;
	
		assertEquals(3, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test88() {
	
		int day = 28;
		int month = 2;
		int year = 1748;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test89() {
	
		int day = 29;
		int month = 2;
		int year = 1748;
	
		assertEquals(2, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test90() {
	
		int day = 30;
		int month = 2;
		int year = 1748;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test91() {
	
		int day = 0;
		int month = 2;
		int year = 1751;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test92() {
	
		int day = 1;
		int month = 2;
		int year = 1751;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test93() {
	
		int day = 2;
		int month = 2;
		int year = 1751;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test94() {
	
		int day = 27;
		int month = 2;
		int year = 1751;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test95() {
	
		int day = 28;
		int month = 2;
		int year = 1751;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test96() {
	
		int day = 29;
		int month = 2;
		int year = 1751;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test97() {
	
		int day = 0;
		int month = 2;
		int year = 1752;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test98() {
	
		int day = 1;
		int month = 2;
		int year = 1752;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test99() {
	
		int day = 2;
		int month = 2;
		int year = 1752;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test100() {
	
		int day = 28;
		int month = 2;
		int year = 1752;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test101() {
	
		int day = 29;
		int month = 2;
		int year = 1752;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test102() {
	
		int day = 30;
		int month = 2;
		int year = 1752;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test103() {
	
		int day = 0;
		int month = 2;
		int year = 1753;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test104() {
	
		int day = 1;
		int month = 2;
		int year = 1753;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test105() {
	
		int day = 2;
		int month = 2;
		int year = 1753;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test106() {
	
		int day = 27;
		int month = 2;
		int year = 1753;
	
		assertEquals(3, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test107() {
	
		int day = 28;
		int month = 2;
		int year = 1753;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test108() {
	
		int day = 29;
		int month = 2;
		int year = 1753;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test109() {
	
		int day = 0;
		int month = 2;
		int year = 1756;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test110() {
	
		int day = 1;
		int month = 2;
		int year = 1756;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test111() {
	
		int day = 2;
		int month = 2;
		int year = 1756;
	
		assertEquals(2, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test112() {
	
		int day = 28;
		int month = 2;
		int year = 1756;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test113() {
	
		int day = 29;
		int month = 2;
		int year = 1756;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test114() {
	
		int day = 30;
		int month = 2;
		int year = 1756;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test115() {
	
		int day = 0;
		int month = 2;
		int year = 1800;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test116() {
	
		int day = 1;
		int month = 2;
		int year = 1800;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test117() {
	
		int day = 2;
		int month = 2;
		int year = 1800;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test118() {
	
		int day = 27;
		int month = 2;
		int year = 1800;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test119() {
	
		int day = 28;
		int month = 2;
		int year = 1800;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test120() {
	
		int day = 29;
		int month = 2;
		int year = 1800;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test121() {
	
		int day = 0;
		int month = 2;
		int year = 2000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test122() {
	
		int day = 1;
		int month = 2;
		int year = 2000;
	
		assertEquals(3, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test123() {
	
		int day = 2;
		int month = 2;
		int year = 2000;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test124() {
	
		int day = 28;
		int month = 2;
		int year = 2000;
	
		assertEquals(2, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test125() {
	
		int day = 29;
		int month = 2;
		int year = 2000;
	
		assertEquals(3, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test126() {
	
		int day = 30;
		int month = 2;
		int year = 2000;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test127() {
	
		int day = 0;
		int month = 9;
		int year = 1751;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test128() {
	
		int day = 1;
		int month = 9;
		int year = 1751;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test129() {
	
		int day = 2;
		int month = 9;
		int year = 1751;
	
		assertEquals(2, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test130() {
	
		int day = 29;
		int month = 9;
		int year = 1751;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test131() {
	
		int day = 30;
		int month = 9;
		int year = 1751;
	
		assertEquals(2, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test132() {
	
		int day = 31;
		int month = 9;
		int year = 1751;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test133() {
	
		int day = 0;
		int month = 9;
		int year = 1752;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test134() {
	
		int day = 1;
		int month = 9;
		int year = 1752;
	
		assertEquals(3, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test135() {
	
		int day = 2;
		int month = 9;
		int year = 1752;
	
		assertEquals(4, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test136() {
	
		int day = 3;
		int month = 9;
		int year = 1752;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test139() {
	
		int day = 13;
		int month = 9;
		int year = 1752;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test140() {
	
		int day = 14;
		int month = 9;
		int year = 1752;
	
		assertEquals(5, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test141() {
	
		int day = 15;
		int month = 9;
		int year = 1752;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test142() {
	
		int day = 29;
		int month = 9;
		int year = 1752;
	
		assertEquals(6, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test143() {
	
		int day = 30;
		int month = 9;
		int year = 1752;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test144() {
	
		int day = 31;
		int month = 9;
		int year = 1752;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test145() {
	
		int day = 0;
		int month = 9;
		int year = 1753;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test146() {
	
		int day = 1;
		int month = 9;
		int year = 1753;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test147() {
	
		int day = 2;
		int month = 9;
		int year = 1753;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test148() {
	
		int day = 29;
		int month = 9;
		int year = 1753;
	
		assertEquals(7, Cal.cal(day, month, year));
	
	}
	
	@Test
	public void test149() {
	
		int day = 30;
		int month = 9;
		int year = 1753;
	
		assertEquals(1, Cal.cal(day, month, year));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test150() {
	
		int day = 31;
		int month = 9;
		int year = 1753;
	
		Cal.cal(day, month, year);
	
	}
	
	@Test
	public void test151() {
	
		new Cal();
	
	}

}
