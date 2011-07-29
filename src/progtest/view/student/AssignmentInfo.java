package progtest.view.student;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Submission;
import progtest.execution.Directories;
import progtest.execution.Runner;
import progtest.reports.Report;
import progtest.reports.TXTReport;
import progtest.reports.XMLReport;
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

	private XMLReport xmlReport;

	private UIData recordsTable;

	private TXTReport txtReport;

	private XMLReport generalCoverages;

	private UIData generalCoveragesTable;

	private XMLReport totalCoverages;

	private UIData totalCoveragesTable;

	private String grade;

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

	public XMLReport getXmlReport() {
		return xmlReport;
	}

	public void setXmlReport(XMLReport xmlReport) {
		this.xmlReport = xmlReport;
	}

	public UIData getRecordsTable() {
		return recordsTable;
	}

	public void setRecordsTable(UIData recordsTable) {
		this.recordsTable = recordsTable;
	}

	public TXTReport getTxtReport() {
		return txtReport;
	}

	public void setTxtReport(TXTReport txtReport) {
		this.txtReport = txtReport;
	}

	public XMLReport getGeneralCoverages() {
		return generalCoverages;
	}

	public void setGeneralCoverages(XMLReport generalCoverages) {
		this.generalCoverages = generalCoverages;
	}

	public UIData getGeneralCoveragesTable() {
		return generalCoveragesTable;
	}

	public void setGeneralCoveragesTable(UIData generalCoveragesTable) {
		this.generalCoveragesTable = generalCoveragesTable;
	}

	public XMLReport getTotalCoverages() {
		return totalCoverages;
	}

	public void setTotalCoverages(XMLReport totalCoverages) {
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

			for (File file : FileUtil.listFiles(new File(Directories
					.getPstsDirPath(submission.getAssignment(),
							submission.getStudent()))))
				if (!file.getName().endsWith(".properties"))
					reports.add(new Report(file));

			xmlReport = null;

			txtReport = null;

			try {

				File xmlFile = new File(Directories.getReportsDirPath(
						submission.getAssignment(), submission.getStudent())
						+ File.separator + "Coverages.xml");
				generalCoverages = new XMLReport(xmlFile);

				xmlFile = new File(Directories.getReportsDirPath(
						submission.getAssignment(), submission.getStudent())
						+ File.separator + "Evaluation Result.xml");
				totalCoverages = new XMLReport(xmlFile);

				totalCoverages
						.getRecords()
						.get(0)
						.setColumn1(
								"Instructor's test set against instructor's program (P_Inst - T_Inst)");
				totalCoverages
						.getRecords()
						.get(1)
						.setColumn1(
								"Student's test set against student's program (P_St - T_St)");
				totalCoverages
						.getRecords()
						.get(2)
						.setColumn1(
								"Student's test set against instructor's program (P_Inst - T_St)");
				totalCoverages
						.getRecords()
						.get(3)
						.setColumn1(
								"Instructor's test set against student's program (P_St - T_Inst)");

				grade = totalCoverages.getRecords().get(4).getColumn2();
				totalCoverages.getRecords().remove(4);

			} catch (Exception e) {
			}

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

		Report report = (Report) reportsTable.getRowData();

		try {

			if (report.getFile().getName().endsWith(".xml")) {

				xmlReport = new XMLReport(report.getFile());
				viewId = 3;
				activedReport = report.getName();

			} else {

				txtReport = new TXTReport(report.getFile());
				viewId = 4;
				activedReport = report.getName();

			}

		} catch (Exception e) {
		}

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
