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
import progtest.reports.Report;
import progtest.reports.TXTReport;
import progtest.reports.XMLReport;
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

	private XMLReport xmlReport;

	private UIData recordsTable;

	private TXTReport txtReport;

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

	public Assignment() {

		activedReport = Constants.EMPTY;

		progtest.common.Assignment assignment = (progtest.common.Assignment) FacesUtil
				.getSession(Constants.SESSION_ASSIGNMENT);

		title = assignment.getTitle();

		description = assignment.getDescription();

		startDate = assignment.getStartDate();

		endDate = assignment.getEndDate();

		submissions = Querier.getEvaluations(assignment);
		
		tools = assignment.getTools();

		for (File file : FileUtil.listFiles(new File(Directories
				.getPitiDirPath(assignment))))
			if (!file.getName().endsWith(".properties"))
				reports.add(new Report(file));

		xmlReport = null;

		txtReport = null;

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

		try {

			if (report.getFile().getName().endsWith(".xml")) {

				xmlReport = new XMLReport(report.getFile());
				viewId = 2;
				activedReport = report.getName();

			} else {

				txtReport = new TXTReport(report.getFile());
				viewId = 3;
				activedReport = report.getName();

			}

		} catch (Exception e) {
		}

		return Constants.ACTION_SELECT;

	}

	public String edit() {
		return Constants.ACTION_EDIT;
	}

	public String remove() {
		return Constants.ACTION_REMOVE;
	}

}
