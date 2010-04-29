import junit.framework.TestCase;

public class TCFatorial extends TestCase {
	
	public TCFatorial(String s)
	{
		super(s);
	}

	public void test1()
	{
		assertEquals(Fatorial.fatorial(4), 24);
	}

	public void test2()
	{
		assertEquals(Fatorial.fatorial(1), 1);
	}

}
