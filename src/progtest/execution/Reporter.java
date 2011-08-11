package progtest.execution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import progtest.common.Assignment;
import progtest.common.Requisite;
import progtest.common.Submission;
import progtest.common.User;
import progtest.database.Querier;
import progtest.report.Report;
import progtest.report.Report2XML;
import progtest.report.Row;
import progtest.report.Section;
import progtest.report.Object;
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
				Directories.getReportsDirPath(assignment, student) + File.separator + "Coverages.xml");

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

		File reportFile = new File(
				Directories.getReportsDirPath(submission.getAssignment(), submission.getStudent()) + File.separator + "Evaluation Result.xml");
		
		Report report = new Report();
		report.setName("Evaluation Result");
		report.setTool("ProgTest");
		
		Section section1 = new Section();
		section1.setTitle("General Coverages");
		
		Object object1 = new Object(Object.TYPE_TABLE);
		
		object1.getTableHeader().setColumn1("Criteria");
		object1.getTableHeader().setColumn2("Pinst-Tinst");
		object1.getTableHeader().setColumn3("Pst-Pst");
		object1.getTableHeader().setColumn4("Pinst-Tst");
		object1.getTableHeader().setColumn5("Pst-Tinst");
		
		List<Requisite> requisites = Querier
		.getAssignmentCriteria(submission.getAssignment());
		
		User student = submission.getStudent();
		
		for(int i = 0; i <= requisites.size(); i++) {
			
			Requisite requisite = requisites.get(i);
			
			Row row = new Row();
			
			row.setColumn1(requisite.getCriterion().getTool().getName() + "/" + requisite.getCriterion().getName());
			row.setColumn2(String.valueOf(MathUtil.round(Reader.readPiTi(requisite) * 100, 2)) + "%");
			row.setColumn3(String.valueOf(MathUtil.round(Reader.readPsTs(requisite, student) * 100, 2)) + "%");
			row.setColumn4(String.valueOf(MathUtil.round(Reader.readPiTs(requisite, student) * 100, 2)) + "%");
			row.setColumn5(String.valueOf(MathUtil.round(Reader.readPsTi(requisite, student) * 100, 2)) + "%");
			
			object1.getTableRows().add(row);
			
		}
		
		section1.getObjects().add(object1);
		
		report.getSections().add(section1);
		
		Section section2 = new Section();
		section2.setTitle("Total Coverages");
		
		Object object2 = new Object(Object.TYPE_TABLE);
		
		object2.getTableHeader().setColumn1("Execution");
		object2.getTableHeader().setColumn1("Value");
		
		Row row1 = new Row();
		row1.setColumn1("Pinst-Tinst");
		row1.setColumn2(String.valueOf(MathUtil.round(submission.getAssignment().getPinstTinst() * 100, 2)) + "%");
		object2.getTableRows().add(row1);
		
		Row row2 = new Row();
		row1.setColumn1("Pst-Tst");
		row1.setColumn2(String.valueOf(MathUtil.round(submission.getPstTst() * 100, 2)) + "%");
		object2.getTableRows().add(row2);
		
		Row row3 = new Row();
		row1.setColumn1("Pinst-Tst");
		row1.setColumn2(String.valueOf(MathUtil.round(submission.getPinstTst() * 100, 2)) + "%");
		object2.getTableRows().add(row3);
		
		Row row4 = new Row();
		row1.setColumn1("Pst-Tinst");
		row1.setColumn2(String.valueOf(MathUtil.round(submission.getPstTinst() * 100, 2)) + "%");
		object2.getTableRows().add(row4);
		
		section2.getObjects().add(object2);
		
		report.getSections().add(section2);
		
		Section section3 = new Section();
		section3.setTitle("SUGGESTED GRADE: " + String.valueOf(MathUtil.round(submission.getScore() * 10, 2)));
		
		report.getSections().add(section3);
		
		Report2XML.generate(report, reportFile);
		
	}

}
