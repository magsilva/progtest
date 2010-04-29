import junit.framework.TestCase;

import org.junit.Test;

public class TestSet extends TestCase {

	@Test
	public void test1() {
		try {
			String sequence = null;
			int iteration = 2;
			Main.main(sequence, iteration);
			fail();
		} catch (Throwable e) {
		}
	}

	@Test
	public void test2() {
		String sequence = "0";
		int iteration = 1;
		String expected = "0";
		assertEquals(Main.main(sequence, iteration), expected);
	}

	@Test
	public void test3() {
		try {
			String sequence = "";
			int iteration = 2;
			Main.main(sequence, iteration);
			fail();
		} catch (Throwable e) {
		}
	}

	@Test
	public void test4() {
		try {
			String sequence = "0,a,b";
			int iteration = 2;
			Main.main(sequence, iteration);
			fail();
		} catch (Throwable e) {
		}
	}

	@Test
	public void test5() {
		String sequence = "2,4,3,2,1,0,6,78,9,3";
		int iteration = 2;
		String expected = "2,3,4,2,1,0,6,78,9,3";
		assertEquals(Main.main(sequence, iteration), expected);
	}

	@Test
	public void test6() {
		String sequence = "78,9,7,6,5,4,3,2,1,0";
		int iteration = 2;
		String expected = "7,9,78,6,5,4,3,2,1,0";
		assertEquals(Main.main(sequence, iteration), expected);
	}

	@Test
	public void test7() {
		String sequence = "0,1,2,3,4,5,6,7,9,78";
		int iteration = 2;
		String expected = "0,1,2,3,4,5,6,7,9,78";
		assertEquals(Main.main(sequence, iteration), expected);
	}

}
