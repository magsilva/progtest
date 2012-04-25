package progtest.addons.jumble;

public class Reader {

	public static double getTotal(Result r) {

		double total = 0;
		
		double numerator = 0;
		
		double denominator = 0;
		
		for(int i = 1; i < r.getScoreByClass().length; i++) {
			numerator += Double.parseDouble(r.getScoreByClass()[i][3]);
			denominator++;
		}
		
		if(denominator > 0)
			total = (numerator / denominator) / 100;
		
		return total;
		
	}

}
