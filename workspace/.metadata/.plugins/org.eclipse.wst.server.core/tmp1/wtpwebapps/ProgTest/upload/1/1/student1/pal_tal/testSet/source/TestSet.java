

import static org.junit.Assert.*;

import org.junit.Test;


public class TestSet {

	@Test
	public void test1() {
		try {
			String input = null;
			Main.main(input);
			fail();
		} catch (Throwable e) {
		}
	}

	@Test
	public void test2() {
		try {
			String input = "0";
			Main.main(input);
			fail();
		} catch (Throwable e) {
		}
	}

	@Test
	public void test3() {
		try {
			String input = "";
			Main.main(input);
			fail();
		} catch (Throwable e) {
		}
	}

	@Test
	public void test4() {
		try {
			String input = "0,a,b";
			Main.main(input);
			fail();
		} catch (Throwable e) {
		}
	}
	
	@Test
	public void test5() {
		String input = "0,4,3,2,1,0,6,78,9,3";
		String expected = "78";
		assertEquals(Main.main(input), expected);
	}

	@Test
	public void test6() {
		String input = "78,4,3,2,1,0,6,0,9,3";
		String expected = "9";
		assertEquals(Main.main(input), expected);
	}

	@Test
	public void test7() {
		String input = "0,4,3,2,1,0,6,0,9,78";
		String expected = "78";
		assertEquals(Main.main(input), expected);
	}

}
