import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeTest {
	
	@Test
	public void test1() {
	
		String str = "MM";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test2() {
	
		String str = "MNM";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test3() {
	
		String str = "MNNM";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test4() {
	
		String str = "/M/";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test5() {
	
		String str = "0M0";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test6() {
	
		String str = "1M1";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test7() {
	
		String str = "8M8";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test8() {
	
		String str = "9M9";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test9() {
	
		String str = ":M:";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test10() {
	
		String str = "@M@";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test11() {
	
		String str = "AMA";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test12() {
	
		String str = "BMB";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test13() {
	
		String str = "YMY";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test14() {
	
		String str = "ZMZ";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test15() {
	
		String str = "[M[";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test16() {
	
		String str = "`m`";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test17() {
	
		String str = "ama";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test18() {
	
		String str = "bmb";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test19() {
	
		String str = "ymy";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test20() {
	
		String str = "zmz";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test21() {
	
		String str = "{m{";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test22() {
	
		String str = "@M`";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test23() {
	
		String str = "`M@";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test24() {
	
		String str = "AMa";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test25() {
	
		String str = "aMA";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test26() {
	
		String str = "BMb";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test27() {
	
		String str = "bMB";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test28() {
	
		String str = "YMy";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test29() {
	
		String str = "yMY";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test30() {
	
		String str = "ZMz";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test31() {
	
		String str = "zMZ";
	
		assertTrue(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test32() {
	
		String str = "[M{";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test33() {
	
		String str = "{M[";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test34() {
	
		String str = "{";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test35() {
	
		String str = "abc";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test36() {
	
		String str = "a@a";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test37() {
	
		String str = "";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test38() {
	
		String str = "abca";
	
		assertFalse(Palindrome.palindrome(str));
	
	}
	
	@Test
	public void test39() {
	
		new Palindrome();
	
	}

}
