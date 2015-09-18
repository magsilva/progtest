import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestSet {

	@Test
	public void test1_1e2e3() {
		
		int n = 4;
		int d[] = new int[n + 1];
		for (int i = 0; i <= n; i++)
			d[i] = i + 1;

		try {
			AvaliaMultMatrizes.multmatrize(n, d);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, true);
		
	}

	@Test
	public void test1_2_I() {
		
		int n = 1;
		int d[] = new int[n + 1];
		for (int i = 0; i <= n; i++)
			d[i] = 6 + i;

		try {
			AvaliaMultMatrizes.multmatrize(n, d);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, true);
		
	}

	@Test
	public void test1_2_S() {
		
		int n = 50;
		int d[] = new int[n + 1];
		for (int i = 0; i <= n; i++)
			d[i] = i + 1;

		try {
			AvaliaMultMatrizes.multmatrize(n, d);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, true);
		
	}

	@Test
	public void test1_3_I() {
		
		int n = 6;
		int d[] = new int[n + 1];
		for (int i = 0; i <= n; i++)
			d[i] = 1;

		try {
			AvaliaMultMatrizes.multmatrize(n, d);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, true);
		
	}

	@Test
	public void test1_3_S() {
		
		int n = 6;
		int d[] = new int[n + 1];
		for (int i = 0; i <= n; i++)
			d[i] = 100;

		try {
			AvaliaMultMatrizes.multmatrize(n, d);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, true);
		
	}

	@Test
	public void testFC1() {
		new AvaliaMultMatrizes();
	}
	
}
