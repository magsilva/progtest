  import junit.framework.TestCase;
  import org.junit.Test;
  public class TestSet extends TestCase {
  	@Test 	public void test1() {
 		try {
 			String sequence = null;
 			int iteration = 2;
 			Main.main(sequence, iteration);
 			fail();
 		}
 catch (Throwable e) {
 		}
 	}
  	@Test 	public void test2() {
 		String sequence = "0";
 		int iteration = 2;
 		String expected = "0";
 		assertEquals(Main.main(sequence, iteration), expected);
 	}
  	@Test 	public void test3() {
 		try {
 			String sequence = "";
 			int iteration = 2;
 			Main.main(sequence, iteration);
 			fail();
 		}
 catch (Throwable e) {
 		}
 	}
  	@Test 	public void test4() {
 		try {
 			String sequence = "0,a,b";
 			int iteration = 2;
 			Main.main(sequence, iteration);
 			fail();
 		}
 catch (Throwable e) {
 		}
 	}
 	 	@Test 	public void test5() {
 		String sequence = "4,3,2,1,0,6,78,22,23,12,14,13,12,11,10,16,78,19,15,2";
 		int iteration = 2;
 		String expected = "4,12,23,22,19,14,12,16,3,15,6,13,1,11,10,2,0,2,78,78";
 		assertEquals(Main.main(sequence, iteration), expected);
 	}
 	 }
 