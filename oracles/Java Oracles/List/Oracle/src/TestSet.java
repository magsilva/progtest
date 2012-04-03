import static org.junit.Assert.*;

import org.junit.Test;

public class TestSet {

	Lista list;

	@Test
	public void test1() {
		list = new Lista();
		list.add(4);
		list.add(8);
		String expected = "4,8";
		assertEquals(expected, list.print());
	}

	@Test
	public void test2() {
		list = new Lista();
		list.add(4);
		String expected = "4";
		assertEquals(expected, list.print());
	}

	@Test
	public void test3() {
		list = new Lista();
		for (int i = 0; i < 35; i++)
			list.add(i + 5);
		String expected = "5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39";
		assertEquals(expected, list.print());
	}

	@Test
	public void test4() {
		list = new Lista();
		String expected = "";
		assertEquals(expected, list.print());
	}

	@Test
	public void test5() {
		try {
			list = new Lista();
			list.remove(4);
			fail();
		} catch (Exception e) {}
	}

	@Test
	public void test6() {
		try {
			list = new Lista();
			list.add(4);
			list.remove(null);
			fail();
		} catch (Exception e) {}
	}

	@Test
	public void test7() {
		list = new Lista();
		list.add(4);
		list.add(8);
		Integer expected = null;
		assertEquals(expected, list.remove(7));
	}

	@Test
	public void test8() {
		list = new Lista();
		list.add(4);
		list.add(8);
		int expected = 4;
		assertEquals(expected, list.remove(4));
	}

}
