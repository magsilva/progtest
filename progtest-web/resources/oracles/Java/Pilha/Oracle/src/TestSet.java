import static org.junit.Assert.*;

import org.junit.Test;

public class TestSet {

	Pilha pilha;

	@Test
	public void test1() {
		pilha = new Pilha();
		pilha.push(8);
		String expected = "8";
		assertEquals(expected, pilha.print());
	}

	@Test
	public void test2() {
		pilha = new Pilha();
		pilha.push(4);
		pilha.push(8);
		pilha.pop();
		String expected = "4";
		assertEquals(expected, pilha.print());
	}

	@Test
	public void test3() {
		pilha = new Pilha();
		for (int i = 0; i < 10; i++)
			pilha.push(i + 5);
		String expected = "14,13,12,11,10,9,8,7,6,5";
		assertEquals(expected, pilha.print());
	}

	@Test
	public void test4() {
		pilha = new Pilha();
		String expected = "";
		assertEquals(expected, pilha.print());
	}

	@Test
	public void test5() {
		pilha = new Pilha();
		pilha.push(8);
		pilha.pop();
		String expected = "";
		assertEquals(expected, pilha.print());
	}

	@Test
	public void test6() {
		pilha = new Pilha();
		pilha.pop();
		String expected = "";
		assertEquals(expected, pilha.print());
	}
	
}
