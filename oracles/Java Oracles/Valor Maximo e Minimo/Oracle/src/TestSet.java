import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
		String expected = "0,0";
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
		String input = "2,4,3,2,1,0,6,78,9,3";
		String expected = "78,0";
		assertEquals(Main.main(input), expected);
	}
	
	@Test
	public void test6() {
		String input = "0,4,3,2,1,2,6,78,9,3";
		String expected = "78,0";
		assertEquals(Main.main(input), expected);
	}
	
	@Test
	public void test7() {
		String input = "2,4,3,2,1,2,6,78,9,0";
		String expected = "78,0";
		assertEquals(Main.main(input), expected);
	}
	
	@Test
	public void test8() {
		String input = "78,4,3,2,1,2,6,0,9,3";
		String expected = "78,0";
		assertEquals(Main.main(input), expected);
	}
	
	@Test
	public void test9() {
		String input = "2,4,3,2,1,2,6,0,9,78";
		String expected = "78,0";
		assertEquals(Main.main(input), expected);
	}

}