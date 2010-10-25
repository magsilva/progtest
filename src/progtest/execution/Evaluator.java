package progtest.execution;

import java.util.List;

import progtest.common.Assignment;
import progtest.common.AssignmentCriterion;
import progtest.common.Evaluation;
import progtest.database.Querier;

public class Evaluator {

	public static void evaluate(Assignment oracle) {
		oracle.setPinstTinst(calculatePiTi(oracle));
	}

	public static void evaluate(Evaluation evaluation) {
		evaluation.setPstTst(calculatePsTs(evaluation));
		evaluation.setPinstTst(calculatePiTs(evaluation));
		evaluation.setPstTinst(calculatePsTi(evaluation));
		evaluation.setScore(calculateScore(evaluation));
	}

	private static double calculatePiTi(Assignment oracle) {

		double pinstTinst = 0;

		double quotient = 0;

		List<AssignmentCriterion> assignmentCriteria = Querier
				.getAssignmentCriteria(oracle);

		for (AssignmentCriterion assignmentCriterion : assignmentCriteria) {

			pinstTinst += Reader.readPiTi(assignmentCriterion)
					* assignmentCriterion.getWeight();

			quotient += assignmentCriterion.getWeight();

		}

		if (quotient != 0) {
			pinstTinst /= quotient;
		}

		return pinstTinst;
	}

	private static double calculatePsTs(Evaluation evaluation) {

		double pstTst = 0;

		double quotient = 0;

		List<AssignmentCriterion> assignmentCriteria = Querier
				.getAssignmentCriteria(evaluation.getAssignment());

		for (AssignmentCriterion assignmentCriterion : assignmentCriteria) {

			pstTst += Reader.readPsTs(assignmentCriterion,
					evaluation.getStudent())
					* assignmentCriterion.getWeight();

			quotient += assignmentCriterion.getWeight();

		}

		if (quotient != 0) {
			pstTst /= quotient;
		}

		return pstTst;
	}

	private static double calculatePiTs(Evaluation evaluation) {

		double pinstTst = 0;

		double quotient = 0;

		List<AssignmentCriterion> assignmentCriteria = Querier
				.getAssignmentCriteria(evaluation.getAssignment());

		for (AssignmentCriterion assignmentCriterion : assignmentCriteria) {

			pinstTst += Reader.readPiTs(assignmentCriterion,
					evaluation.getStudent())
					* assignmentCriterion.getWeight();

			quotient += assignmentCriterion.getWeight();

		}

		if (quotient != 0) {
			pinstTst /= quotient;
		}

		return pinstTst;
	}

	private static double calculatePsTi(Evaluation evaluation) {

		double pstTinst = 0;

		double quotient = 0;

		List<AssignmentCriterion> assignmentCriteria = Querier
				.getAssignmentCriteria(evaluation.getAssignment());

		for (AssignmentCriterion assignmentCriterion : assignmentCriteria) {

			pstTinst += Reader.readPsTi(assignmentCriterion,
					evaluation.getStudent())
					* assignmentCriterion.getWeight();

			quotient += assignmentCriterion.getWeight();

		}

		if (quotient != 0) {
			pstTinst /= quotient;
		}

		return pstTinst;
	}

	private static double calculateScore(Evaluation evaluation) {

		double piti = evaluation.getAssignment().getPinstTinst();
		double psts = evaluation.getPstTst();
		double pits = evaluation.getPinstTst();
		double psti = evaluation.getPstTinst();

		return (piti + psts + pits + psti) / 4;

	}

}
