package progtest.addons.proteum;

import java.util.List;

public class Reader {

	public static double getTotal(List<Result> results) {

		double total = 0;

		try {

			for (Result result : results)
				total += result.getScore();

			if (results.size() != 0)
				total /= (double) results.size();

		} catch (Throwable t) {

			total = 0;
			t.printStackTrace();

		}

		return total;

	}

}
