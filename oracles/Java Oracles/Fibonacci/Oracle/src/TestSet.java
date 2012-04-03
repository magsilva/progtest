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
		String input = "0";
		String expected = "0";
		assertEquals(Main.main(input), expected);
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
		String input = "1";
		String expected = "1";
		assertEquals(Main.main(input), expected);
	}

	@Test
	public void test6() {
		String input = "8";
		String expected = "21";
		assertEquals(Main.main(input), expected);
	}

}
