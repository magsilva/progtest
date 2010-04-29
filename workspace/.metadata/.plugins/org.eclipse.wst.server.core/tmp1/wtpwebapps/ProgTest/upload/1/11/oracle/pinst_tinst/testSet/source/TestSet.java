

import junit.framework.TestCase;

public class TestSet extends TestCase {

	List list;

	public void test4_1() {
		list = new List();
		list.add(4);
		list.add(8);
		String expected = "4,8";
		assertEquals(expected, list.print());
	}

	public void test4_2() {
		list = new List();
		list.add(4);
		String expected = "4";
		assertEquals(expected, list.print());
	}

	public void test5_1() {
		list = new List();
		for (int i = 0; i < 35; i++)
			list.add(i + 5);
		String expected = "5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39";
		assertEquals(expected, list.print());
	}

	public void test5_2() {
		list = new List();
		String expected = "";
		assertEquals(expected, list.print());
	}

}

