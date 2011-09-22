package progtest.view.instructor;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import progtest.common.Submission;
import progtest.common.Tool;
import progtest.database.Querier;
import progtest.execution.Directories;
import progtest.execution.Runner;
import progtest.reports.Report;
import progtest.reports.xml.XML2Report;
import progtest.util.Constants;
import progtest.util.FacesUtil;
import progtest.util.FileUtil;
import edu.emory.mathcs.backport.java.util.Collections;

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

	private boolean processing = false;

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

	public boolean isProcessing() {
		return processing;
	}

	public void setProcessing(boolean processing) {
		this.processing = processing;
	}

	public Assignment() {
		init();
	}

	public void init() {

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

			processing = false;

			report = null;

			reports.clear();

			List<File> reportFiles = FileUtil.listFiles(new File(Directories
					.getPitiDirPath(assignment)));

			Collections.sort(reportFiles);

			for (File file : reportFiles)
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

		report = (Report) reportsTable.getRowData();
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

		init();

		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						Constants.ACTION_SELECT);

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

		init();

		return Constants.ACTION_SELECT;

	}

	public String remove() {
		return Constants.ACTION_REMOVE;
	}

	public void process(ActionEvent event) {

		processing = true;

		FacesContext context = FacesContext.getCurrentInstance();
		context.setViewRoot(context.getApplication().getViewHandler()
				.createView(context, context.getViewRoot().getViewId()));

		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						Constants.ACTION_SELECT);

	}

}
