package progtest.execution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import progtest.common.Assignment;
import progtest.common.AssignmentCriterion;
import progtest.common.Evaluation;
import progtest.common.User;
import progtest.database.Querier;
import progtest.reports.XMLParser;
import progtest.util.Math;

public class Reporter {

	public static void generateReports(Assignment oracle) {

	}

	public static void generateReports(Evaluation evaluation) throws FileNotFoundException {
		generateCoveragesReport(evaluation);
		generateEvaluationReport(evaluation);
	}

	public static void generateCoveragesReport(Evaluation evaluation) throws FileNotFoundException {
		
		Assignment assignment = evaluation.getAssignment();
		User student = evaluation.getStudent();

		File report = new File(
				Directories.getStudentReportsDirPath(assignment, student) + File.separator + "Coverages.xml");

		List<AssignmentCriterion> assignmentCriteria = Querier
				.getAssignmentCriteria(assignment);
		
		String[][] data = new String[assignmentCriteria.size() + 1][5];
		
		data[0][0] = "Criteria";
		data[0][1] = "Pinst-Tinst";
		data[0][2] = "Pst-Tst";
		data[0][3] = "Pinst-Tst";
		data[0][4] = "Pst-Tinst";
		
		for(int i = 1; i <= assignmentCriteria.size(); i++) {
			
			AssignmentCriterion ac = assignmentCriteria.get(i - 1);
			
			data[i][0] = ac.getCriterion().getTool().getName() + "/" + ac.getCriterion().getName();
			data[i][1] = String.valueOf(Math.round(Reader.readPiTi(ac) * 100, 2)) + "%";
			data[i][2] = String.valueOf(Math.round(Reader.readPsTs(ac, student) * 100, 2)) + "%";
			data[i][3] = String.valueOf(Math.round(Reader.readPiTs(ac, student) * 100, 2)) + "%";
			data[i][4] = String.valueOf(Math.round(Reader.readPsTi(ac, student) * 100, 2)) + "%";
			
		}
		
		XMLParser.generateXML(report, data);

	}

	private static void generateEvaluationReport(Evaluation evaluation) throws FileNotFoundException {

		File report = new File(
				Directories.getStudentReportsDirPath(evaluation.getAssignment(), evaluation.getStudent()) + File.separator + "Evaluation Result.xml");
		
		String[][] data = new String[6][2];
		
		data[0][0] = "Measures";
		data[0][1] = "Value";
		data[1][0] = "Pinst-Tinst";
		data[1][1] = String.valueOf(Math.round(evaluation.getAssignment().getPinstTinst() * 100, 2)) + "%";
		data[2][0] = "Pst-Tst";
		data[2][1] = String.valueOf(Math.round(evaluation.getPstTst() * 100, 2)) + "%";
		data[3][0] = "Pinst-Tst";
		data[3][1] = String.valueOf(Math.round(evaluation.getPinstTst() * 100, 2)) + "%";
		data[4][0] = "Pst-Tinst";
		data[4][1] = String.valueOf(Math.round(evaluation.getPstTinst() * 100, 2)) + "%";
		data[5][0] = "Grade";
		data[5][1] = String.valueOf(Math.round(evaluation.getScore() * 10, 2));
		
		XMLParser.generateXML(report, data);
		
	}

}
