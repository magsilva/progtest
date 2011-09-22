package progtest.view.student;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;

import edu.emory.mathcs.backport.java.util.Collections;

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

public class AssignmentInfo {

	private int viewId;

	private String activedReport;

	private String title;

	private String description;

	private Date startDate;

	private Date endDate;

	private Date submissionDate;

	private double score;

	private boolean evaluationReport;

	private List<Tool> tools;

	private List<Report> reports = new ArrayList<Report>();

	private UIData reportsTable;

	private Report report;

	private String downloadable = null;

	public int getViewId() {
		return viewId;
	}

	public void setViewId(int viewId) {
		this.viewId = viewId;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
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

	public AssignmentInfo() {
		init();
	}

	public void init() {

		activedReport = Constants.EMPTY;

		Submission submission = (Submission) FacesUtil
				.getSession(Constants.SESSION_EVALUATION);

		title = submission.getAssignment().getTitle();

		description = submission.getAssignment().getDescription();

		startDate = submission.getAssignment().getStartDate();

		endDate = submission.getAssignment().getEndDate();

		submissionDate = submission.getSubmissionDate();

		score = submission.getScore();

		if (submission.getSubmissionDate() == null) {

			selectDefaultView();

		} else {

			try {

				Assignment assignment = submission.getAssignment();

				User student = submission.getStudent();

				tools = assignment.getTools();

				downloadable = Runner.getDownloadable(submission);

				report = null;

				reports.clear();

				List<File> reportFiles = FileUtil.listFiles(new File(
						Directories.getPstsDirPath(assignment, student)));

				Collections.sort(reportFiles);

				for (File file : reportFiles)
					if (file.getName().endsWith(".xml"))
						reports.add(XML2Report.parse(file));

			} catch (Throwable t) {

				t.printStackTrace();

			}

			selectResultView();

			viewId = 2;

		}

	}

	public String selectDefaultView() {
		viewId = 0;
		evaluationReport = false;
		return Constants.ACTION_SELECT;
	}

	public String selectAboutView() {
		viewId = 1;
		evaluationReport = false;
		return Constants.ACTION_SELECT;
	}

	public String selectResultView() {

		try {

			Submission submission = (Submission) FacesUtil
					.getSession(Constants.SESSION_EVALUATION);
			
			File xmlFile = new File(Directories.getReportsDirPath(
					submission.getAssignment(), submission.getStudent())
					+ File.separator + "Evaluation Result.xml");
			
			report = XML2Report.parse(xmlFile);

		} catch (Throwable t) {

			t.printStackTrace();

		}
		
		activedReport = null;

		evaluationReport = true;

		return Constants.ACTION_SELECT;

	}

	public String selectReportView() {

		report = (Report) reportsTable.getRowData();
		viewId = 2;
		activedReport = report.getName();
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

}
