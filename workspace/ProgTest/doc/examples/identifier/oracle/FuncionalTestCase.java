import junit.framework.TestCase;

public class FuncionalTestCase extends TestCase
{
	public FuncionalTestCase(String s)
	{
		super(s);
	}

	public void testVerify1()
	{
		assertTrue(Identifier.verify("m"));
	}

	public void testVerify2()
	{
		assertTrue(Identifier.verify("ndfeas"));
	}

	public void testVerify3()
	{
		assertFalse(Identifier.verify("abcdefg"));
	}

	public void testVerify4()
	{
		assertFalse(Identifier.verify("1aB"));
	}

	public void testVerify5()
	{
		assertFalse(Identifier.verify("abc-d"));
	}

	public void testVerify6()
	{
		assertFalse(Identifier.verify(""));
	}
}
