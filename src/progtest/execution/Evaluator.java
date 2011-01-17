package progtest.execution;

import java.util.List;

import progtest.common.Assignment;
import progtest.common.Requisite;
import progtest.common.Submission;
import progtest.database.Querier;

public class Evaluator {

	public static void evaluate(Assignment oracle) {
		oracle.setPinstTinst(calculatePiTi(oracle));
	}

	public static void evaluate(Submission submission) {
		submission.setPstTst(calculatePsTs(submission));
		submission.setPinstTst(calculatePiTs(submission));
		submission.setPstTinst(calculatePsTi(submission));
		submission.setScore(calculateScore(submission));
	}

	private static double calculatePiTi(Assignment oracle) {

		double pinstTinst = 0;

		double quotient = 0;

		List<Requisite> requisites = Querier
				.getAssignmentCriteria(oracle);

		for (Requisite requisite : requisites) {

			pinstTinst += Reader.readPiTi(requisite)
					* requisite.getWeight();

			quotient += requisite.getWeight();

		}

		if (quotient != 0) {
			pinstTinst /= quotient;
		}

		return pinstTinst;
	}

	private static double calculatePsTs(Submission submission) {

		double pstTst = 0;

		double quotient = 0;

		List<Requisite> requisites = Querier
				.getAssignmentCriteria(submission.getAssignment());

		for (Requisite requisite : requisites) {

			pstTst += Reader.readPsTs(requisite,
					submission.getStudent())
					* requisite.getWeight();

			quotient += requisite.getWeight();

		}

		if (quotient != 0) {
			pstTst /= quotient;
		}

		return pstTst;
	}

	private static double calculatePiTs(Submission submission) {

		double pinstTst = 0;

		double quotient = 0;

		List<Requisite> requisites = Querier
				.getAssignmentCriteria(submission.getAssignment());

		for (Requisite requisite : requisites) {

			pinstTst += Reader.readPiTs(requisite,
					submission.getStudent())
					* requisite.getWeight();

			quotient += requisite.getWeight();

		}

		if (quotient != 0) {
			pinstTst /= quotient;
		}

		return pinstTst;
	}

	private static double calculatePsTi(Submission submission) {

		double pstTinst = 0;

		double quotient = 0;

		List<Requisite> requisites = Querier
				.getAssignmentCriteria(submission.getAssignment());

		for (Requisite requisite : requisites) {

			pstTinst += Reader.readPsTi(requisite,
					submission.getStudent())
					* requisite.getWeight();

			quotient += requisite.getWeight();

		}

		if (quotient != 0) {
			pstTinst /= quotient;
		}

		return pstTinst;
	}

	private static double calculateScore(Submission submission) {

		double piti = submission.getAssignment().getPinstTinst();
		double psts = submission.getPstTst();
		double pits = submission.getPinstTst();
		double psti = submission.getPstTinst();

		return (psts + pits + psti) / 3;

	}

}
