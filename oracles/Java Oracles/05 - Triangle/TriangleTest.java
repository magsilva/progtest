import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void test1() {
	
		int a = 5, b = 4, c = 3;
	
		assertEquals(1, Triangle.triangle(a, b, c));

	}

	@Test
	public void test2() {

		int a = 5, b = 3, c = 4;

		assertEquals(1, Triangle.triangle(a, b, c));

	}

	@Test
	public void test3() {

		int a = 4, b = 5, c = 3;

		assertEquals(1, Triangle.triangle(a, b, c));

	}

	@Test
	public void test4() {

		int a = 3, b = 5, c = 4;

		assertEquals(1, Triangle.triangle(a, b, c));

	}

	@Test
	public void test5() {

		int a = 4, b = 3, c = 5;

		assertEquals(1, Triangle.triangle(a, b, c));

	}

	@Test
	public void test6() {

		int a = 3, b = 4, c = 5;

		assertEquals(1, Triangle.triangle(a, b, c));

	}

	@Test
	public void test7() {

		int a = 5, b = 5, c = 3;

		assertEquals(2, Triangle.triangle(a, b, c));

	}

	@Test
	public void test8() {

		int a = 3, b = 5, c = 5;

		assertEquals(2, Triangle.triangle(a, b, c));

	}

	@Test
	public void test9() {

		int a = 5, b = 3, c = 5;

		assertEquals(2, Triangle.triangle(a, b, c));

	}

	@Test
	public void test10() {

		int a = 3, b = 3, c = 5;

		assertEquals(2, Triangle.triangle(a, b, c));

	}

	@Test
	public void test11() {

		int a = 5, b = 3, c = 3;

		assertEquals(2, Triangle.triangle(a, b, c));

	}

	@Test
	public void test12() {

		int a = 3, b = 5, c = 3;

		assertEquals(2, Triangle.triangle(a, b, c));

	}

	@Test
	public void test13() {

		int a = 4, b = 4, c = 4;

		assertEquals(3, Triangle.triangle(a, b, c));

	}

	@Test
	public void test14() {

		int a = 4, b = 2, c = 2;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test15() {

		int a = 2, b = 4, c = 2;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test16() {

		int a = 2, b = 2, c = 4;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test17() {

		int a = 5, b = 2, c = 2;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test18() {

		int a = 2, b = 5, c = 2;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test19() {

		int a = 2, b = 2, c = 5;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test20() {

		int a = 0, b = 4, c = 5;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test21() {

		int a = 5, b = 0, c = 4;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test22() {

		int a = 4, b = 5, c = 0;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test23() {

		int a = 0, b = 0, c = 3;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test24() {

		int a = 3, b = 0, c = 0;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test25() {

		int a = 0, b = 3, c = 0;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test26() {

		int a = 0, b = 0, c = 0;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test27() {

		int a = 1, b = 1, c = 0;

		assertEquals(0, Triangle.triangle(a, b, c));

	}

	@Test
	public void test28() {

		new Triangle();

	}

}
