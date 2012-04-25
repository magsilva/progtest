package progtest.addons.gcov;

public class Evaluator {

	public static double linesCoverage(Result result) {

		double linesCoverage = 0;

		for (int i = 0; i < result.getCoverages().length; i++)
			linesCoverage += (Double.parseDouble(result.getCoverages()[i][1]
					.substring(0, result.getCoverages()[i][1].indexOf("%") - 1)) / ((double) 100));

		linesCoverage /= result.getCoverages().length;

		return linesCoverage;

	}

	public static double branchesCoverage(Result result) {

		double linesCoverage = 0;

		for (int i = 0; i < result.getCoverages().length; i++)
			linesCoverage += (Double.parseDouble(result.getCoverages()[i][1]
					.substring(0, result.getCoverages()[i][3].indexOf("%") - 1)) / ((double) 100));

		linesCoverage /= result.getCoverages().length;

		return linesCoverage;

	}

}
