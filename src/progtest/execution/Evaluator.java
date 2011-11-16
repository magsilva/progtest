package progtest.execution;

import java.util.List;

import progtest.common.Assignment;
import progtest.common.Requisite;
import progtest.common.Submission;
import progtest.database.Querier;

public class Evaluator {

	public static void evaluate(Assignment oracle) {
		oracle.setPitiCoverage(calculatePiTi(oracle));
	}

	public static void evaluate(Submission submission) {
		submission.setPstsCoverage(calculatePsTs(submission));
		submission.setPitsCoverage(calculatePiTs(submission));
		submission.setPstiCoverage(calculatePsTi(submission));
		submission.setGrade(calculateScore(submission));
	}

	private static double calculatePiTi(Assignment oracle) {

		double pinstTinst = 0;

		double quotient = 0;

		List<Requisite> requisites = Querier.getAssignmentCriteria(oracle);

		for (Requisite requisite : requisites) {

			pinstTinst += Reader.readPiTi(requisite) * requisite.getWeight();

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

		List<Requisite> requisites = Querier.getAssignmentCriteria(submission
				.getAssignment());

		for (Requisite requisite : requisites) {

			if (requisite.isPstsRequired()) {

				pstTst += Reader.readPsTs(requisite, submission.getStudent())
						* requisite.getWeight();

				quotient += requisite.getWeight();

			}

		}

		if (quotient != 0) {
			pstTst /= quotient;
		}

		return pstTst;
	}

	private static double calculatePiTs(Submission submission) {

		double pinstTst = 0;

		double quotient = 0;

		List<Requisite> requisites = Querier.getAssignmentCriteria(submission
				.getAssignment());

		for (Requisite requisite : requisites) {

			if (requisite.isPitsRequired()) {

				pinstTst += Reader.readPiTs(requisite, submission.getStudent())
						/ submission.getAssignment().getPitiCoverage();

				if (pinstTst > 1)
					pinstTst = 1;

				pinstTst *= requisite.getWeight();

				quotient += requisite.getWeight();

			}

		}

		if (quotient != 0) {
			pinstTst /= quotient;
		}

		return pinstTst;
	}

	private static double calculatePsTi(Submission submission) {

		double pstTinst = 0;

		double quotient = 0;

		List<Requisite> requisites = Querier.getAssignmentCriteria(submission
				.getAssignment());

		for (Requisite requisite : requisites) {

			if (requisite.isPstiRequired()) {

				pstTinst += Reader.readPsTi(requisite, submission.getStudent())
						* requisite.getWeight();

				quotient += requisite.getWeight();

			}

		}

		if (quotient != 0) {
			pstTinst /= quotient;
		}

		return pstTinst;
	}

	private static double calculateScore(Submission submission) {

		double psts = submission.getPstsCoverage();
		double pits = submission.getPitsCoverage();
		double psti = submission.getPstsCoverage();

		double pstsWeight = submission.getAssignment().getPstsWeight();
		double pitsWeight = submission.getAssignment().getPitsWeight();
		double pstiWeight = submission.getAssignment().getPstiWeight();
		
		double minimumCoverage = submission.getAssignment().getMinimumCoverage();
		
		double coverage = (((psts * pstsWeight) + (pits * pitsWeight) + (psti * pstiWeight))
				/ pstsWeight + pitsWeight + pstiWeight);
		
		return ((double) 0.5 ) * coverage / minimumCoverage;

	}

}
