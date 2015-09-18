import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void test1() {

		int n = 0;

		assertEquals(0, Fibonacci.fibonacci(n));

	}

	@Test
	public void test2() {

		int n = 1;

		assertEquals(1, Fibonacci.fibonacci(n));

	}

	@Test
	public void test3() {

		int n = 2;

		assertEquals(1, Fibonacci.fibonacci(n));

	}

	@Test
	public void test4() {

		int n = 4;

		assertEquals(3, Fibonacci.fibonacci(n));

	}

	@Test
	public void test5() {

		new Fibonacci();

	}

}
