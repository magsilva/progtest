package progtest.addons.jabutiservice;

public class Reader {

	public static double getTotal(int i, Result r) {
		
		double total = Double.parseDouble(r.getCoverageByCriterion()[i][1]);
		
		double covered = Double.parseDouble(r.getCoverageByCriterion()[i][2]);
		
		if(total != 0)
			return covered / total;
		else
			return 1.0;
		
	}

}
