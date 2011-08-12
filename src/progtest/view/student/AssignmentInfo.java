package progtest.view.student;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Submission;
import progtest.execution.Directories;
import progtest.execution.Runner;
import progtest.report.Report;
import progtest.report.XML2Report;
import progtest.util.Constants;
import progtest.util.FacesUtil;
import progtest.util.FileUtil;

public class AssignmentInfo {

	private int viewId;

	private String title;

	private String description;

	private Date startDate;

	private Date endDate;

	private Date submissionDate;

	private double score;

	private String activedReport;

	private List<Report> reports = new ArrayList<Report>();

	private UIData reportsTable;

	private Report report;

	private boolean evaluationReport;

	private String downloadable = null;

	public int getViewId() {
		return viewId;
	}

	public void setViewId(int viewId) {
		this.viewId = viewId;
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

	public String getActivedReport() {
		return activedReport;
	}

	public void setActivedReport(String activedReport) {
		this.activedReport = activedReport;
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

	public boolean isEvaluationReport() {
		return evaluationReport;
	}

	public void setEvaluationReport(boolean evaluationReport) {
		this.evaluationReport = evaluationReport;
	}

	public String getDownloadable() {
		return downloadable;
	}

	public void setDownloadable(String downloadable) {
		this.downloadable = downloadable;
	}

	public AssignmentInfo() {

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

				downloadable = Runner.getDownloadable(submission);

			} catch (Throwable t) {

				t.printStackTrace();

			}

			try {

				for (File file : FileUtil.listFiles(new File(Directories
						.getPstsDirPath(submission.getAssignment(),
								submission.getStudent()))))
					if (file.getName().endsWith(".xml"))
						reports.add(XML2Report.parse(file));

				report = null;

			} catch (Throwable t) {

			}

			selectResultView();
			
			viewId = 2;

		}

	}

	public String selectDefaultView() {
		viewId = 0;
		return Constants.ACTION_SELECT;
	}

	public String selectAboutView() {
		viewId = 1;
		return Constants.ACTION_SELECT;
	}

	public String selectResultView() {
		Submission submission = (Submission) FacesUtil
				.getSession(Constants.SESSION_EVALUATION);
		File xmlFile = new File(Directories.getReportsDirPath(
				submission.getAssignment(), submission.getStudent())
				+ File.separator + "Evaluation Result.xml");
		try {
			report = XML2Report.parse(xmlFile);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public String add() {
		FacesUtil.setSession(Constants.SESSION_BACKPAGE,
				Constants.BACKPAGE_ASSIGNMENT);
		return Constants.ACTION_ADD;
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

		return Constants.ACTION_SELECT;

	}

}
