import static org.junit.Assert.*;

import org.junit.Test;

public class TestSet {

	String T, P;

	@Test
	public void test1() {
		T = "Texto original para posterior comparacao com casamento exato";
		P = "original pa";
		assertEquals("6", Main.main(T, P));
	}

	@Test
	public void test2() {
		T = "Texto original para posterior comparacao com casamento exato";
		P = "teste";
		assertEquals("-1", Main.main(T, P));
	}

	@Test
	public void test3() {
		T = "Texto original para posterior comparacao com casamento exato";
		P = "g";
		assertEquals("9", Main.main(T, P));
	}

	@Test
	public void test4() {
		T = "Texto";
		P = "Texto";
		assertEquals("0", Main.main(T, P));
	}

	@Test
	public void test5() {
		T = "Texto original para posterior comparacao com casamento exato";
		P = "g";
		assertEquals("9", Main.main(T, P));
	}

	@Test
	public void test6() {
		T = "Texto";
		P = "Texto";
		assertEquals("0", Main.main(T, P));
	}

	@Test
	public void test7() {
		T = "T";
		P = "T";
		assertEquals("0", Main.main(T, P));
	}

	@Test
	public void test8() {
		T = "TextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTex";
		P = "Texto";
		assertEquals("0", Main.main(T, P));
	}

	@Test
	public void test9() {
		T = "Texto original para posterior comparacao com casamento exato";
		P = "";
		assertEquals("0", Main.main(T, P));
	}

	@Test
	public void test10() {
		T = "";
		P = "teste";
		assertEquals("-1", Main.main(T, P));
	}

}
