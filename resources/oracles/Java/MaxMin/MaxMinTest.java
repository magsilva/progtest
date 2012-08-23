import static org.junit.Assert.*;

import org.junit.Test;

public class MaxMinTest {

	@Test
	public void test1() {

		int[] values = {-1};
	
		int[] maxmin = MaxMin.maxmin(values);
	
		assertEquals(2, maxmin.length);
		assertEquals(-1, maxmin[0]);
		assertEquals(-1, maxmin[1]);
	
	}
	
	@Test
	public void test2() {
	
		int[] values = {0};
	
		int[] maxmin = MaxMin.maxmin(values);
	
		assertEquals(2, maxmin.length);
		assertEquals(0, maxmin[0]);
		assertEquals(0, maxmin[1]);
	
	}
	
	@Test
	public void test3() {
	
		int[] values = {1};
	
		int[] maxmin = MaxMin.maxmin(values);
	
		assertEquals(2, maxmin.length);
		assertEquals(1, maxmin[0]);
		assertEquals(1, maxmin[1]);
	
	}
	
	@Test
	public void test4() {
	
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
		int[] maxmin = MaxMin.maxmin(values);
	
		assertEquals(2, maxmin.length);
		assertEquals(10, maxmin[0]);
		assertEquals(1, maxmin[1]);
	
	}
	
	@Test
	public void test5() {
	
		int[] values = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	
		int[] maxmin = MaxMin.maxmin(values);
	
		assertEquals(2, maxmin.length);
		assertEquals(10, maxmin[0]);
		assertEquals(1, maxmin[1]);
	
	}
	
	@Test
	public void test6() {
	
		int[] values = {3, 1, 4, 2, 5, 6, 7, 8, 10, 9};
	
		int[] maxmin = MaxMin.maxmin(values);
	
		assertEquals(2, maxmin.length);
		assertEquals(10, maxmin[0]);
		assertEquals(1, maxmin[1]);
	
	}
	
	@Test
	public void test7() {
	
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 10, 10};
	
		int[] maxmin = MaxMin.maxmin(values);
	
		assertEquals(2, maxmin.length);
		assertEquals(10, maxmin[0]);
		assertEquals(1, maxmin[1]);
	
	}
	
	@Test
	public void test8() {
	
		int[] values = {1, 1, 3, 4, 5, 6, 7, 8, 9, 10};
	
		int[] maxmin = MaxMin.maxmin(values);
	
		assertEquals(2, maxmin.length);
		assertEquals(10, maxmin[0]);
		assertEquals(1, maxmin[1]);
	
	}
	
	@Test
	public void test9() {
	
		int[] values = {1, 2, 2, 4, 5, 6, 7, 8, 9, 10};
	
		int[] maxmin = MaxMin.maxmin(values);
	
		assertEquals(2, maxmin.length);
		assertEquals(10, maxmin[0]);
		assertEquals(1, maxmin[1]);
	
	}
	
	@Test
	public void test10() {
	
		int[] values = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
	
		int[] maxmin = MaxMin.maxmin(values);
	
		assertEquals(2, maxmin.length);
		assertEquals(-1, maxmin[0]);
		assertEquals(-10, maxmin[1]);
	
	}
	
	@Test
	public void test11() {
	
		int[] values = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
		int[] maxmin = MaxMin.maxmin(values);
	
		assertEquals(10, maxmin[0]);
		assertEquals(0, maxmin[1]);
	
	}
	
	@Test
	public void test12() {
	
		int[] values = {-1, 0, 3, 4, 5, 6, 7, 8, 9, 10};
	
		int[] maxmin = MaxMin.maxmin(values);
	
		assertEquals(2, maxmin.length);
		assertEquals(10, maxmin[0]);
		assertEquals(-1, maxmin[1]);
	
	}
	
	@Test
	public void test13() {
	
		int[] values = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1};
	
		int[] maxmin = MaxMin.maxmin(values);
	
		assertEquals(2, maxmin.length);
		assertEquals(-1, maxmin[0]);
		assertEquals(-10, maxmin[1]);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test14() {
	
		int[] values = {};
	
		int[] maxmin = MaxMin.maxmin(values);
	
	}
	
	@Test(expected = NullPointerException.class)
	public void test15() {
	
		MaxMin.maxmin(null);
	
	}
	
	@Test
	public void test16() {
	
		new MaxMin();
	
	}

}
