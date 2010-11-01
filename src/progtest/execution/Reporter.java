package progtest.execution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import progtest.common.Assignment;
import progtest.common.Requisite;
import progtest.common.Submission;
import progtest.common.User;
import progtest.database.Querier;
import progtest.util.MathUtil;
import progtest.util.XMLUtil;

public class Reporter {

	public static void generateReports(Assignment oracle) {

	}

	public static void generateReports(Submission submission) throws FileNotFoundException {
		generateCoveragesReport(submission);
		generateEvaluationReport(submission);
	}

	public static void generateCoveragesReport(Submission submission) throws FileNotFoundException {
		
		Assignment assignment = submission.getAssignment();
		User student = submission.getStudent();

		File report = new File(
				Directories.getStudentReportsDirPath(assignment, student) + File.separator + "Coverages.xml");

		List<Requisite> requisites = Querier
				.getAssignmentCriteria(assignment);
		
		String[][] data = new String[requisites.size() + 1][5];
		
		data[0][0] = "Criteria";
		data[0][1] = "Pinst-Tinst";
		data[0][2] = "Pst-Tst";
		data[0][3] = "Pinst-Tst";
		data[0][4] = "Pst-Tinst";
		
		for(int i = 1; i <= requisites.size(); i++) {
			
			Requisite requisite = requisites.get(i - 1);
			
			data[i][0] = requisite.getCriterion().getTool().getName() + "/" + requisite.getCriterion().getName();
			data[i][1] = String.valueOf(MathUtil.round(Reader.readPiTi(requisite) * 100, 2)) + "%";
			data[i][2] = String.valueOf(MathUtil.round(Reader.readPsTs(requisite, student) * 100, 2)) + "%";
			data[i][3] = String.valueOf(MathUtil.round(Reader.readPiTs(requisite, student) * 100, 2)) + "%";
			data[i][4] = String.valueOf(MathUtil.round(Reader.readPsTi(requisite, student) * 100, 2)) + "%";
			
		}
		
		XMLUtil.generateXML(report, data);

	}

	private static void generateEvaluationReport(Submission submission) throws FileNotFoundException {

		File report = new File(
				Directories.getStudentReportsDirPath(submission.getAssignment(), submission.getStudent()) + File.separator + "Evaluation Result.xml");
		
		String[][] data = new String[6][2];
		
		data[0][0] = "Measures";
		data[0][1] = "Value";
		data[1][0] = "Pinst-Tinst";
		data[1][1] = String.valueOf(MathUtil.round(submission.getAssignment().getPinstTinst() * 100, 2)) + "%";
		data[2][0] = "Pst-Tst";
		data[2][1] = String.valueOf(MathUtil.round(submission.getPstTst() * 100, 2)) + "%";
		data[3][0] = "Pinst-Tst";
		data[3][1] = String.valueOf(MathUtil.round(submission.getPinstTst() * 100, 2)) + "%";
		data[4][0] = "Pst-Tinst";
		data[4][1] = String.valueOf(MathUtil.round(submission.getPstTinst() * 100, 2)) + "%";
		data[5][0] = "Grade";
		data[5][1] = String.valueOf(MathUtil.round(submission.getScore() * 10, 2));
		
		XMLUtil.generateXML(report, data);
		
	}

}
