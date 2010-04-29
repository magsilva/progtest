  import org.junit.Test;
  import junit.framework.TestCase;
  public class TestSet extends TestCase {
  	@Test 	public void test1() {
 		try {
 			String input = null;
 			Main.main(input);
 			fail();
 		}
 catch (Throwable e) {
 		}
 	}
  	@Test 	public void test2() {
 		String input = "0";
 		String expected = "0";
 		assertEquals(Main.main(input), expected);
 	}
  	@Test 	public void test3() {
 		try {
 			String input = "";
 			Main.main(input);
 			fail();
 		}
 catch (Throwable e) {
 		}
 	}
  	@Test 	public void test4() {
 		try {
 			String input = "0,a,b";
 			Main.main(input);
 			fail();
 		}
 catch (Throwable e) {
 		}
 	}
  	public void test5() {
 		String input = "7";
 		String expected = "13";
 		assertEquals(Main.main(input), expected);
 	}
  	public void test6() {
 		String input = "46";
 		String expected = "1836311903";
 		assertEquals(Main.main(input), expected);
 	}
  }
 