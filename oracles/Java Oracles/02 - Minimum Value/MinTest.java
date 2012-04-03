import static org.junit.Assert.*;

import org.junit.Test;

public class MinTest {

	@Test
	public void test1() {
	
		int[] values = {-1};
		
		int minimum = Min.min(values);
	
		assertEquals(-1, minimum);
	
	}
	
	@Test
	public void test2() {
	
		int[] values = {0};
		
		int minimum = Min.min(values);
	
		assertEquals(0, minimum);
	
	}
	
	@Test
	public void test3() {
	
		int[] values = {1};
		
		int minimum = Min.min(values);
	
		assertEquals(1, minimum);
	
	}
	
	@Test
	public void test4() {
	
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int minimum = Min.min(values);
	
		assertEquals(1, minimum);
	
	}
	
	@Test
	public void test5() {
	
		int[] values = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		int minimum = Min.min(values);
	
		assertEquals(1, minimum);
	
	}
	
	@Test
	public void test6() {
	
		int[] values = {3, 1, 4, 2, 5, 6, 7, 8, 10, 9};
		
		int minimum = Min.min(values);
	
		assertEquals(1, minimum);
	
	}
	
	@Test
	public void test7() {
	
		int[] values = {1, 1, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int minimum = Min.min(values);
	
		assertEquals(1, minimum);
	
	}
	
	@Test
	public void test8() {
	
		int[] values = {1, 2, 2, 4, 5, 6, 7, 8, 9, 10};
		
		int minimum = Min.min(values);
	
		assertEquals(1, minimum);
	
	}
	
	@Test
	public void test9() {
	
		int[] values = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
		
		int minimum = Min.min(values);
	
		assertEquals(-10, minimum);
	
	}
	
	@Test
	public void test10() {
	
		int[] values = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int minimum = Min.min(values);
	
		assertEquals(0, minimum);
	
	}
	
	@Test
	public void test11() {
	
		int[] values = {-1, 0, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int minimum = Min.min(values);
	
		assertEquals(-1, minimum);
	
	}
	
	@Test
	public void test12() {
	
		int[] values = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1};
		
		int minimum = Min.min(values);
	
		assertEquals(-10, minimum);
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test13() {
	
		int[] values = {};
		
		Min.min(values);
	
	}
	
	@Test(expected = NullPointerException.class)
	public void test14() {
	
		Min.min(null);
	
	}
	
	@Test
	public void test15() {
	
		new Min();
	
	}

}
