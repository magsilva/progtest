import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {
	
	@Test
	public void test1() {
	
		int[] values = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	
		Sort.sort(values);
	
		assertEquals(1, values[0]);
		assertEquals(2, values[1]);
		assertEquals(3, values[2]);
		assertEquals(4, values[3]);
		assertEquals(5, values[4]);
		assertEquals(6, values[5]);
		assertEquals(7, values[6]);
		assertEquals(8, values[7]);
		assertEquals(9, values[8]);
		assertEquals(10, values[9]);
	
	}
	
	@Test
	public void test2() {
	
		int[] values = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	
		Sort.sort(values);
	
		assertEquals(0, values[0]);
		assertEquals(1, values[1]);
		assertEquals(2, values[2]);
		assertEquals(3, values[3]);
		assertEquals(4, values[4]);
		assertEquals(5, values[5]);
		assertEquals(6, values[6]);
		assertEquals(7, values[7]);
		assertEquals(8, values[8]);
		assertEquals(9, values[9]);
	
	}
	
	@Test
	public void test3() {
	
		int[] values = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
	
		Sort.sort(values);
	
		assertEquals(-10, values[0]);
		assertEquals(-9, values[1]);
		assertEquals(-8, values[2]);
		assertEquals(-7, values[3]);
		assertEquals(-6, values[4]);
		assertEquals(-5, values[5]);
		assertEquals(-4, values[6]);
		assertEquals(-3, values[7]);
		assertEquals(-2, values[8]);
		assertEquals(-1, values[9]);
	
	}
	
	@Test
	public void test4() {
	
		int[] values = {};
	
		Sort.sort(values);
	
		assertEquals(0, values.length);
	
	}
	
	@Test
	public void test5() {
	
		int[] values = {10};
	
		Sort.sort(values);
	
		assertEquals(10, values[0]);
	
	}
	
	@Test
	public void test6() {
	
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
		Sort.sort(values);
	
		assertEquals(1, values[0]);
		assertEquals(2, values[1]);
		assertEquals(3, values[2]);
		assertEquals(4, values[3]);
		assertEquals(5, values[4]);
		assertEquals(6, values[5]);
		assertEquals(7, values[6]);
		assertEquals(8, values[7]);
		assertEquals(9, values[8]);
		assertEquals(10, values[9]);
	
	}
	
	@Test
	public void test7() {
	
		int[] values = {9, 10, 7, 8, 5, 6, 3, 4, 1, 2};
	
		Sort.sort(values);
	
		assertEquals(1, values[0]);
		assertEquals(2, values[1]);
		assertEquals(3, values[2]);
		assertEquals(4, values[3]);
		assertEquals(5, values[4]);
		assertEquals(6, values[5]);
		assertEquals(7, values[6]);
		assertEquals(8, values[7]);
		assertEquals(9, values[8]);
		assertEquals(10, values[9]);
	
	}
	
	@Test
	public void test8() {
	
		int[] values = {10, 10, 8, 7, 6, 5, 4, 3, 2, 1};
	
		Sort.sort(values);
	
		assertEquals(1, values[0]);
		assertEquals(2, values[1]);
		assertEquals(3, values[2]);
		assertEquals(4, values[3]);
		assertEquals(5, values[4]);
		assertEquals(6, values[5]);
		assertEquals(7, values[6]);
		assertEquals(8, values[7]);
		assertEquals(10, values[8]);
		assertEquals(10, values[9]);
	
	}
	
	@Test
	public void test9() {
	
		int[] values = {10, 9, 8, 7, 6, 5, 4, 3, 1, 1};
	
		Sort.sort(values);
	
		assertEquals(1, values[0]);
		assertEquals(1, values[1]);
		assertEquals(3, values[2]);
		assertEquals(4, values[3]);
		assertEquals(5, values[4]);
		assertEquals(6, values[5]);
		assertEquals(7, values[6]);
		assertEquals(8, values[7]);
		assertEquals(9, values[8]);
		assertEquals(10, values[9]);
	
	}
	
	@Test
	public void test10() {
	
		int[] values = {10, 9, 9, 7, 6, 5, 4, 3, 2, 1};
	
		Sort.sort(values);
	
		assertEquals(1, values[0]);
		assertEquals(2, values[1]);
		assertEquals(3, values[2]);
		assertEquals(4, values[3]);
		assertEquals(5, values[4]);
		assertEquals(6, values[5]);
		assertEquals(7, values[6]);
		assertEquals(9, values[7]);
		assertEquals(9, values[8]);
		assertEquals(10, values[9]);
	
	}
	
	@Test
	public void test11() {
	
		int[] values = {9, 10, 7, 8, 5, 6, 4, 1, 2, 3};
	
		Sort.sort(values);
	
		assertEquals(1, values[0]);
		assertEquals(2, values[1]);
		assertEquals(3, values[2]);
		assertEquals(4, values[3]);
		assertEquals(5, values[4]);
		assertEquals(6, values[5]);
		assertEquals(7, values[6]);
		assertEquals(8, values[7]);
		assertEquals(9, values[8]);
		assertEquals(10, values[9]);
	
	}
	
	@Test
	public void test12() {
	
		new Sort();
	
	}

}
