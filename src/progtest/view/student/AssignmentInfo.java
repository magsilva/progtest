package progtest.view.student;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Evaluation;
import progtest.execution.Directories;
import progtest.reports.Report;
import progtest.util.Constants;
import progtest.util.ContextManager;
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

	private List<File> files = new ArrayList<File>();

	private UIData filesTable;

	private Report report;

	private UIData reportTable;

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

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public UIData getFilesTable() {
		return filesTable;
	}

	public void setFilesTable(UIData filesTable) {
		this.filesTable = filesTable;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public UIData getReportTable() {
		return reportTable;
	}

	public void setReportTable(UIData reportTable) {
		this.reportTable = reportTable;
	}

	public AssignmentInfo() {
		
		activedReport = Constants.EMPTY;

		Evaluation evaluation = (Evaluation) ContextManager
				.getSession(Constants.SESSION_EVALUATION);

		title = evaluation.getAssignment().getTitle();

		description = evaluation.getAssignment().getDescription();

		startDate = evaluation.getAssignment().getStartDate();

		endDate = evaluation.getAssignment().getEndDate();

		submissionDate = evaluation.getSubmissionDate();

		score = evaluation.getScore();

		if (evaluation.getSubmissionDate() == null) {

			selectDefaultView();

		} else {
		
			files = FileUtil.listFiles(new File(Directories.getStudentReportsDirPath(evaluation.getAssignment(), evaluation.getStudent())), Constants.EXTENSION_XML);
			
			File file = (File) files.get(0);
			report = new Report(file);
			viewId = 2;
			activedReport = file.getName();
			
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

	public String selectReportView() {
		File file = (File) filesTable.getRowData();
		report = new Report(file);
		viewId = 2;
		activedReport = file.getName();
		return Constants.ACTION_SELECT;
	}
	
	public String send() {
		ContextManager.setSession(Constants.SESSION_BACKPAGE,
				Constants.BACKPAGE_ASSIGNMENT);
		return Constants.ACTION_SEND;
	}
	
	public String add() {
		ContextManager.setSession(Constants.SESSION_BACKPAGE,
				Constants.BACKPAGE_ASSIGNMENT);
		return Constants.ACTION_ADD;
	}

}
