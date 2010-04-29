import junit.framework.TestCase;
  public class TestSet extends TestCase {
  	String T, P;
  	public void test1_1_3e4() {
 		T = "Texto original para posterior comparacao com casamento exato";
 		P = "original pa";
 		assertEquals("6", Main.main(T, P));
 	}
  	public void test1_2() {
 		T = "Texto original para posterior comparacao com casamento exato";
 		P = "teste";
 		assertEquals("-1", Main.main(T, P));
 	}
  	public void test1_1_I() {
 		T = "Texto original para posterior comparacao com casamento exato";
 		P = "g";
 		assertEquals("9", Main.main(T, P));
 	}
  	public void test1_1_S() {
 		T = "Texto";
 		P = "Texto";
 		assertEquals("0", Main.main(T, P));
 	}
  	public void test1_3_I() {
 		T = "Texto original para posterior comparacao com casamento exato";
 		P = "g";
 		assertEquals("9", Main.main(T, P));
 	}
  	public void test1_3_S() {
 		T = "Texto";
 		P = "Texto";
 		assertEquals("0", Main.main(T, P));
 	}
  	public void test1_4_I() {
 		T = "T";
 		P = "T";
 		assertEquals("0", Main.main(T, P));
 	}
  	public void test1_4_S() {
 		T = "TextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTexTextoTex";
 		P = "Texto";
 		assertEquals("0", Main.main(T, P));
 	}
  	public void testEst_1_1() {
 		T = "Texto original para posterior comparacao com casamento exato";
 		P = "";
 		assertEquals("0", Main.main(T, P));
 	}
  	public void testEst_1_2() {
 		T = "";
 		P = "teste";
 		assertEquals("-1", Main.main(T, P));
 	}
  }
 