package progtest.view.student;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Submission;
import progtest.execution.Directories;
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

	private Report generalCoverages;

	private UIData generalCoveragesTable;

	private Report totalCoverages;

	private UIData totalCoveragesTable;
	
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

	public Report getGeneralCoverages() {
		return generalCoverages;
	}

	public void setGeneralCoverages(Report generalCoverages) {
		this.generalCoverages = generalCoverages;
	}

	public UIData getGeneralCoveragesTable() {
		return generalCoveragesTable;
	}

	public void setGeneralCoveragesTable(UIData generalCoveragesTable) {
		this.generalCoveragesTable = generalCoveragesTable;
	}

	public Report getTotalCoverages() {
		return totalCoverages;
	}

	public void setTotalCoverages(Report totalCoverages) {
		this.totalCoverages = totalCoverages;
	}

	public UIData getTotalCoveragesTable() {
		return totalCoveragesTable;
	}

	public void setTotalCoveragesTable(UIData totalCoveragesTable) {
		this.totalCoveragesTable = totalCoveragesTable;
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
		
			files = FileUtil.listFiles(new File(Directories.getPstsDirPath(submission.getAssignment(), submission.getStudent())), Constants.EXTENSION_XML);
			
			File xmlFile = new File(Directories.getReportsDirPath(submission.getAssignment(), submission.getStudent()) + File.separator + "Coverages.xml");
			generalCoverages = new Report(xmlFile);
			
			xmlFile = new File(Directories.getReportsDirPath(submission.getAssignment(), submission.getStudent()) + File.separator + "Evaluation Result.xml");
			totalCoverages = new Report(xmlFile);
			
			totalCoverages.getRecords().get(0).setColumn1("Instructor's test set against instructor's program (P_Inst - T_Inst)");
			totalCoverages.getRecords().get(1).setColumn1("Student's test set against student's program (P_St - T_St)");
			totalCoverages.getRecords().get(2).setColumn1("Student's test set against instructor's program (P_Inst - T_St)");
			totalCoverages.getRecords().get(3).setColumn1("Instructor's test set against student's program (P_St - T_Inst)");
			
			grade = totalCoverages.getRecords().get(4).getColumn2();
			totalCoverages.getRecords().remove(4);
			
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
		viewId = 2;
		return Constants.ACTION_SELECT;
	}

	public String selectReportView() {
		File file = (File) filesTable.getRowData();
		report = new Report(file);
		viewId = 3;
		activedReport = file.getName();
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
