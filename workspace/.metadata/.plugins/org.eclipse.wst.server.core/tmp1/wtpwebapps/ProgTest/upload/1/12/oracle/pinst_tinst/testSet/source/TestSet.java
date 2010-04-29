import junit.framework.TestCase;

public class TestSet extends TestCase {

	Pilha pilha;

	public void test3_2() {
		pilha = new Pilha();
		pilha.push(8);
		String expected = "8";
		assertEquals(expected, pilha.print());
	}

	public void test4_1() {
		pilha = new Pilha();
		pilha.push(4);
		pilha.push(8);
		pilha.pop();
		String expected = "4";
		assertEquals(expected, pilha.print());
	}

	public void test5_1() {
		pilha = new Pilha();
		for (int i = 0; i < 10; i++)
			pilha.push(i + 5);
		String expected = "14,13,12,11,10,9,8,7,6,5";
		assertEquals(expected, pilha.print());
	}

	public void test5_2() {
		pilha = new Pilha();
		String expected = "";
		assertEquals(expected, pilha.print());
	}

	public void test4_1_I() {
		pilha = new Pilha();
		pilha.push(8);
		pilha.pop();
		String expected = "";
		assertEquals(expected, pilha.print());
	}
}
