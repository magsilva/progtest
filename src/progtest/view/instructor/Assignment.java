package progtest.view.instructor;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Submission;
import progtest.common.Tool;
import progtest.database.Querier;
import progtest.execution.Directories;
import progtest.execution.Runner;
import progtest.report.Report;
import progtest.report.XML2Report;
import progtest.util.Constants;
import progtest.util.FacesUtil;
import progtest.util.FileUtil;

public class Assignment {

	private int viewId;

	private String activedReport;

	private String title;

	private String description;

	private Date startDate;

	private Date endDate;

	private List<Submission> submissions = new ArrayList<Submission>();

	private UIData submissionsTable;

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

	public List<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}

	public UIData getSubmissionsTable() {
		return submissionsTable;
	}

	public void setSubmissionsTable(UIData submissionsTable) {
		this.submissionsTable = submissionsTable;
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

	public Assignment() {

		try {

			activedReport = Constants.EMPTY;

			progtest.common.Assignment assignment = (progtest.common.Assignment) FacesUtil
					.getSession(Constants.SESSION_ASSIGNMENT);

			title = assignment.getTitle();

			description = assignment.getDescription();

			startDate = assignment.getStartDate();

			endDate = assignment.getEndDate();

			submissions = Querier.getEvaluations(assignment);

			tools = assignment.getTools();

			downloadable = Runner.getDownloadable(assignment);

			report = null;

			for (File file : FileUtil.listFiles(new File(Directories
					.getPitiDirPath(assignment))))
				if (file.getName().endsWith(".xml"))
					reports.add(XML2Report.parse(file));

		} catch (Throwable t) {

			t.printStackTrace();

		}

		selectAboutView();

	}

	public String selectAboutView() {
		viewId = 0;
		return Constants.ACTION_SELECT;
	}

	public String selectGradesView() {
		viewId = 1;
		return Constants.ACTION_SELECT;
	}

	public String selectReportView() {

		Report report = (Report) reportsTable.getRowData();
		viewId = 2;
		activedReport = report.getName();

		return Constants.ACTION_SELECT;

	}

	public String edit() {
		return Constants.ACTION_EDIT;
	}

	public String execute() {

		progtest.common.Assignment assignment = (progtest.common.Assignment) FacesUtil
				.getSession(Constants.SESSION_ASSIGNMENT);

		try {

			Runner.execute(assignment);
			Runner.evaluate(assignment);

		} catch (Throwable t) {

			t.printStackTrace();

		}

		return Constants.ACTION_SELECT;

	}

	public String evaluate() {

		progtest.common.Assignment assignment = (progtest.common.Assignment) FacesUtil
				.getSession(Constants.SESSION_ASSIGNMENT);

		try {

			Runner.evaluate(assignment);

		} catch (Throwable t) {

			t.printStackTrace();

		}

		return Constants.ACTION_SELECT;

	}

	public String remove() {
		return Constants.ACTION_REMOVE;
	}

}
