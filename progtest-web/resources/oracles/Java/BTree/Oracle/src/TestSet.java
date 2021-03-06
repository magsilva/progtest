import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestSet {

	BTree dicionario;
	int max;

	@Before
	public void setUp() {
		dicionario = new BTree();
		max = 10;
	}
	
	@Test
	public void test1() {
		dicionario = new BTree();
		String expected = "";
		assertEquals(expected, dicionario.print());
	}

	@Test
	public void test2() {
		dicionario = new BTree();
		dicionario.add(32);
		dicionario.add(48);
		dicionario.add(54);
		dicionario.add(100);
		String expected = "32,48,54,100";
		assertEquals(expected, dicionario.print());
	}

	@Test
	public void test3() {
		dicionario = new BTree();
		dicionario.add(100);
		dicionario.add(54);
		dicionario.add(48);
		dicionario.add(32);
		String expected = "32,48,54,100";
		assertEquals(expected, dicionario.print());
	}

	@Test
	public void test4() {
		dicionario = new BTree();
		dicionario.add(48);
		dicionario.add(100);
		dicionario.add(54);
		dicionario.add(23);
		String expected = "23,48,54,100";
		assertEquals(expected, dicionario.print());
	}

	@Test
	public void test5() {
		dicionario = new BTree();
		dicionario.add(48);
		dicionario.add(100);
		dicionario.add(54);
		dicionario.add(23);
		dicionario.remove(48);
		String expected = "23,54,100";
		assertEquals(expected, dicionario.print());
	}

	@Test
	public void test6() {
		dicionario = new BTree();
		dicionario.add(48);
		dicionario.add(100);
		dicionario.add(54);
		dicionario.add(23);
		dicionario.remove(100);
		String expected = "23,48,54";
		assertEquals(expected, dicionario.print());
	}

	@Test
	public void test7() {
		dicionario = new BTree();
		dicionario.add(48);
		dicionario.add(100);
		dicionario.add(54);
		dicionario.add(23);
		dicionario.remove(54);
		String expected = "23,48,100";
		assertEquals(expected, dicionario.print());
	}

	@Test
	public void test8() {
		dicionario = new BTree();
		dicionario.add(48);
		dicionario.add(100);
		dicionario.add(54);
		dicionario.add(23);
		dicionario.remove(23);
		String expected = "48,54,100";
		assertEquals(expected, dicionario.print());
	}

	@Test
	public void test9() {
		dicionario = new BTree();
		dicionario.add(48);
		dicionario.remove(48);
		String expected = "";
		assertEquals(expected, dicionario.print());
	}

	@Test
	public void test10() {
		try {
			dicionario = new BTree();
			dicionario.remove(48);
			fail();
		} catch (Exception e) {
		}
	}

}
