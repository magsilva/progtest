package progtest.addons.cunit;

public class Evaluator {

	public static double calculate(Result result) {
		
		if (result.getTotal() != 0)
			return result.getSuceeded() / result.getTotal();
		else
			return 0;
		
	}

}
