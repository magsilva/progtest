import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void test1() {

		int n = 0;

		assertEquals(1, Factorial.factorial(n));

	}

	@Test
	public void test2() {

		int n = 1;

		assertEquals(1, Factorial.factorial(n));

	}

	@Test
	public void test3() {

		int n = 2;

		assertEquals(2, Factorial.factorial(n));

	}

	@Test
	public void test4() {

		int n = 3;

		assertEquals(6, Factorial.factorial(n));

	}

	@Test
	public void test5() {

		new Factorial();

	}

}
