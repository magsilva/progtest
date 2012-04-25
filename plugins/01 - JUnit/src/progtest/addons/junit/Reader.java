package progtest.addons.junit;

import java.util.List;

import org.junit.runner.Result;

public class Reader {

	public static double getTotal(List<Result> results) {

		double allSuccess = 0;

		double allRuns = 0;

		for (int i = 0; i < results.size(); i++) {

			Result r = results.get(i);

			int success = r.getRunCount() - r.getFailureCount();
			int runs = r.getRunCount();

			allSuccess += success;
			allRuns += runs;

		}

		double total = ((double) allSuccess) / ((double) allRuns);

		return total;

	}

}
