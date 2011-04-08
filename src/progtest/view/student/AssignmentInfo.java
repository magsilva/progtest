package progtest.view.student;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Submission;
import progtest.execution.Directories;
import progtest.reports.Record;
import progtest.reports.Report;
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

	private List<File> files = new ArrayList<File>();

	private UIData filesTable;

	private Report report;

	private UIData reportTable;

	private Report report2;

	private UIData report2Table;
	
	private String grade;

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

	public void setReport2Table(UIData report2Table) {
		this.report2Table = report2Table;
	}

	public void setReport2(Report report2) {
		this.report2 = report2;
	}

	public Report getReport2() {
		return report2;
	}

	public UIData getReport2Table() {
		return report2Table;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
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
		
			files = FileUtil.listFiles(new File(Directories.getReportsDirPath(submission.getAssignment(), submission.getStudent())), Constants.EXTENSION_XML);
			
			File file = (File) files.get(1);
			report = new Report(file);
			file = (File) files.get(0);
			report2 = new Report(file);
			
			report2.getRecords().get(0).setColumn1("Instructor's test set against instructor's program (P_Inst - T_Inst)");
			report2.getRecords().get(1).setColumn1("Student's test set against student's program (P_St - T_St)");
			report2.getRecords().get(2).setColumn1("Student's test set against instructor's program (P_Inst - T_St)");
			report2.getRecords().get(3).setColumn1("Instructor's test set against student's program (P_St - T_Inst)");
			
			grade = report2.getRecords().get(4).getColumn2();
			report2.getRecords().set(4, new Record());
			
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
		viewId = 2;
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

}
