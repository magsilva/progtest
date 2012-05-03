package progtest.view.student;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Assignment;
import progtest.common.Submission;
import progtest.common.Tool;
import progtest.common.User;
import progtest.execution.Directories;
import progtest.execution.Runner;
import progtest.reports.Report;
import progtest.reports.xml.XML2Report;
import progtest.util.Constants;
import progtest.util.FacesUtil;
import progtest.util.FileUtil;
import edu.emory.mathcs.backport.java.util.Collections;

public class AssignmentInfo {

	private String activedReport;

	private String title;

	private double score;

	private boolean isPsTsVisible;

	private boolean isPiTsVisible;

	private boolean isPsTiVisible;

	private boolean evaluationReport;

	private List<Tool> tools;

	private List<Report> reports = new ArrayList<Report>();

	private UIData reportsTable;

	private Report report;

	private String downloadable = null;

	private boolean instructorTests = false;

	private boolean instructorProgram = false;

	public String getActivedReport() {
		return activedReport;
	}

	public void setActivedReport(String activedReport) {
		this.activedReport = activedReport;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public boolean isPsTsVisible() {
		return isPsTsVisible;
	}

	public void setPsTsVisible(boolean isPsTsVisible) {
		this.isPsTsVisible = isPsTsVisible;
	}

	public boolean isPiTsVisible() {
		return isPiTsVisible;
	}

	public void setPiTsVisible(boolean isPiTsVisible) {
		this.isPiTsVisible = isPiTsVisible;
	}

	public boolean isPsTiVisible() {
		return isPsTiVisible;
	}

	public void setPsTiVisible(boolean isPsTiVisible) {
		this.isPsTiVisible = isPsTiVisible;
	}

	public boolean isEvaluationReport() {
		return evaluationReport;
	}

	public void setEvaluationReport(boolean evaluationReport) {
		this.evaluationReport = evaluationReport;
	}

	public List<Tool> getTools() {
		return tools;
	}

	public void setTools(List<Tool> tools) {
		this.tools = tools;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public UIData getReportsTable() {
		return reportsTable;
	}

	public void setReportsTable(UIData reportsTable) {
		this.reportsTable = reportsTable;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String getDownloadable() {
		return downloadable;
	}

	public void setDownloadable(String downloadable) {
		this.downloadable = downloadable;
	}

	public boolean getInstructorTests() {
		return instructorTests;
	}

	public void setInstructorTests(boolean instructorTests) {
		this.instructorTests = instructorTests;
	}

	public boolean isInstructorProgram() {
		return instructorProgram;
	}

	public void setInstructorProgram(boolean instructorProgram) {
		this.instructorProgram = instructorProgram;
	}

	public AssignmentInfo() {
		init();
	}

	public void init() {

		activedReport = Constants.EMPTY;

		Submission submission = (Submission) FacesUtil
				.getSession(Constants.SESSION_EVALUATION);

		title = submission.getAssignment().getTitle();

		score = submission.getGrade();

		try {

			Assignment assignment = submission.getAssignment();

			User student = submission.getStudent();

			isPsTsVisible = assignment.isPstsVisible();

			isPiTsVisible = assignment.isPitsVisible();

			isPsTiVisible = assignment.isPstiVisible();

			tools = assignment.getTools();

			downloadable = Runner.getDownloadable(submission);

			report = null;

			reports.clear();

			List<File> reportFiles = null;

			if (instructorProgram)
				reportFiles = FileUtil.listFiles(new File(Directories
						.getPitsDirPath(assignment, student)));
			else if (instructorTests)
				reportFiles = FileUtil.listFiles(new File(Directories
						.getPstiDirPath(assignment, student)));
			else if (isPsTsVisible) {
				reportFiles = FileUtil.listFiles(new File(Directories
						.getPstsDirPath(assignment, student)));
				instructorProgram = false;
				instructorTests = false;
			} else if (isPiTsVisible) {
				reportFiles = FileUtil.listFiles(new File(Directories
						.getPitsDirPath(assignment, student)));
				instructorProgram = true;
				instructorTests = false;
			} else if (isPsTiVisible) {
				reportFiles = FileUtil.listFiles(new File(Directories
						.getPstsDirPath(assignment, student)));
				instructorProgram = false;
				instructorTests = true;
			} else
				reportFiles = new ArrayList<File>();

			Collections.sort(reportFiles);

			for (File file : reportFiles)
				if (file.getName().endsWith(".xml"))
					reports.add(XML2Report.parse(file,
							Directories.getFiguresDir(student)));

		} catch (Throwable t) {

			t.printStackTrace();

		}

		selectResultView();

	}

	public String selectPsTsReports() {
		instructorTests = false;
		instructorProgram = false;
		init();
		return Constants.ACTION_SELECT;
	}

	public String selectPiTsReports() {
		instructorTests = false;
		instructorProgram = true;
		init();
		return Constants.ACTION_SELECT;
	}

	public String selectPsTiReports() {
		instructorTests = true;
		instructorProgram = false;
		init();
		return Constants.ACTION_SELECT;
	}

	public String selectResultView() {

		try {

			Submission submission = (Submission) FacesUtil
					.getSession(Constants.SESSION_EVALUATION);

			File xmlFile = new File(Directories.getReportsDirPath(
					submission.getAssignment(), submission.getStudent())
					+ File.separator + "Evaluation Result.xml");

			int i = 1;

			File destDir = new File(Constants.PATH_FIGURES + File.separator + i);

			for (i = 2; destDir.exists(); i++)
				destDir = new File(Constants.PATH_FIGURES + File.separator + i);

			report = XML2Report.parse(xmlFile, Directories.getFiguresDir(
					submission.getStudent()));

		} catch (Throwable t) {

			t.printStackTrace();

		}

		evaluationReport = true;

		return Constants.ACTION_SELECT;

	}

	public String selectReportView() {

		report = (Report) reportsTable.getRowData();
		evaluationReport = false;

		return Constants.ACTION_SELECT;

	}

	public String send() {

		FacesUtil.setSession(Constants.SESSION_BACKPAGE,
				Constants.BACKPAGE_ASSIGNMENT);

		return Constants.ACTION_SEND;

	}

	public String execute() {

		Submission submission = (Submission) FacesUtil
				.getSession(Constants.SESSION_EVALUATION);

		try {

			Runner.psts(submission);
			Runner.pits(submission);
			Runner.psti(submission);
			Runner.evaluate(submission);
			Runner.report(submission);

		} catch (Throwable t) {

			t.printStackTrace();

		}

		init();

		return Constants.ACTION_SELECT;

	}

	public String evaluate() {

		Submission submission = (Submission) FacesUtil
				.getSession(Constants.SESSION_EVALUATION);

		try {

			Runner.evaluate(submission);
			Runner.report(submission);

		} catch (Throwable t) {

			t.printStackTrace();

		}

		init();

		return Constants.ACTION_SELECT;

	}

	public String back() {

		FacesUtil.setSession(Constants.SESSION_BACKPAGE,
				Constants.BACKPAGE_ASSIGNMENT);

		return Constants.ACTION_BACK;

	}

}
