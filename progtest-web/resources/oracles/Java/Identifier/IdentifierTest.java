import static org.junit.Assert.*;

import org.junit.Test;

public class IdentifierTest {
	
	@Test
	public void test1() {
	
		String str = "";
	
		assertFalse(Identifier.identifier(str));
	
	}

	@Test
	public void test2() {
	
		String str = "a";
	
		assertTrue(Identifier.identifier(str));
	
	}
	
	@Test
	public void test3() {
	
		String str = "a1";
	
		assertTrue(Identifier.identifier(str));
	
	}
	
	@Test
	public void test4() {
	
		String str = "a1b2c";
	
		assertTrue(Identifier.identifier(str));
	
	}
	
	@Test
	public void test5() {
	
		String str = "a1b2c3";
	
		assertTrue(Identifier.identifier(str));
	
	}
	
	@Test
	public void test6() {
	
		String str = "a1b2c3d";
	
		assertFalse(Identifier.identifier(str));
	
	}
	
	@Test
	public void test7() {
	
		String str = "01b2c3";
	
		assertFalse(Identifier.identifier(str));
	
	}
	
	@Test
	public void test8() {
	
		String str = "#1b2c3";
	
		assertFalse(Identifier.identifier(str));
	
	}
	
	@Test
	public void test9() {
	
		String str = "a#b2c3";
	
		assertFalse(Identifier.identifier(str));
	
	}
	
	@Test
	public void test10() {
	
		String str = "A1b2c3";
	
		assertTrue(Identifier.identifier(str));
	
	}
	
	@Test
	public void test11() {
	
		String str = "B1b2c3";
	
		assertTrue(Identifier.identifier(str));
	
	}
	
	@Test
	public void test12() {
	
		String str = "[1b2c3";
	
		assertFalse(Identifier.identifier(str));
	
	}
	
	@Test
	public void test13() {
	
		String str = "b1b2c3";
	
		assertTrue(Identifier.identifier(str));
	
	}
	
	@Test
	public void test14() {
	
		String str = "{1b2c3";
	
		assertFalse(Identifier.identifier(str));
	
	}

	@Test
	public void test15() {
	
		String str = "Z1b2c3";
	
		assertTrue(Identifier.identifier(str));
	
	}
	
	@Test
	public void test16() {
	
		String str = "z1b2c3";
	
		assertTrue(Identifier.identifier(str));
	
	}

	@Test
	public void test17() {
	
		String str = "@1b2c3";
	
		assertFalse(Identifier.identifier(str));
	
	}
	
	@Test
	public void test18() {
	
		String str = "`1b2c3";
	
		assertFalse(Identifier.identifier(str));
	
	}

	@Test
	public void test19() {
	
		String str = "a1A2c3";

		assertTrue(Identifier.identifier(str));

	}

	@Test
	public void test20() {

		String str = "a1@2c3";
	
		assertFalse(Identifier.identifier(str));
	
	}

	@Test
	public void test21() {

		String str = "a1[2c3";
	
		assertFalse(Identifier.identifier(str));

	}

	@Test
	public void test22() {
	
		String str = "a1B2c3";
	
		assertTrue(Identifier.identifier(str));
	
	}

	@Test
	public void test23() {
	
		String str = "a1{2c3";
	
		assertFalse(Identifier.identifier(str));
	
	}

	@Test
	public void test24() {

		String str = "a1Z2c3";

		assertTrue(Identifier.identifier(str));

	}

	@Test
	public void test25() {

		String str = "a1a2c3";

		assertTrue(Identifier.identifier(str));

	}

	@Test
	public void test26() {

		String str = "a1z2c3";

		assertTrue(Identifier.identifier(str));

	}

	@Test
	public void test27() {

		String str = "a102c3";
	
		assertTrue(Identifier.identifier(str));

	}

	@Test
	public void test28() {

		String str = "a192c3";

		assertTrue(Identifier.identifier(str));

	}

	@Test
	public void test29() {

		String str = "a1`2c3";

		assertFalse(Identifier.identifier(str));

	}

	@Test
	public void test30() {

		String str = "a/2c3";

		assertFalse(Identifier.identifier(str));

	}

	@Test
	public void test31() {

		String str = "a1:2c3";

		assertFalse(Identifier.identifier(str));

	}

	@Test
	public void test32() {

		new Identifier();

	}

}
