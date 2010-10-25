package progtest.view.instructor;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Evaluation;
import progtest.database.Querier;
import progtest.execution.Directories;
import progtest.reports.Report;
import progtest.util.Constants;
import progtest.util.ContextManager;
import progtest.util.FileUtil;

public class Assignment {

	private int viewId;
	
	private String activedReport;

	private String title;

	private String description;

	private Date startDate;

	private Date endDate;

	private List<Evaluation> evaluations = new ArrayList<Evaluation>();

	private UIData evaluationsTable;

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

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public UIData getEvaluationsTable() {
		return evaluationsTable;
	}

	public void setEvaluationsTable(UIData evaluationsTable) {
		this.evaluationsTable = evaluationsTable;
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

	public Assignment() {
		
		activedReport = Constants.EMPTY;

		progtest.common.Assignment assignment = (progtest.common.Assignment) ContextManager
				.getSession(Constants.SESSION_ASSIGNMENT);

		title = assignment.getTitle();

		description = assignment.getDescription();

		startDate = assignment.getStartDate();

		endDate = assignment.getEndDate();
		
		evaluations = Querier.getEvaluations(assignment);
		
		files = FileUtil.listFiles(new File(Directories.getPitiDirPath(assignment)), Constants.EXTENSION_XML);
		
		report = null;

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
		File file = (File) filesTable.getRowData();
		report = new Report(file);
		viewId = 2;
		activedReport = file.getName();
		return Constants.ACTION_SELECT;
	}

	public String edit() {
		return Constants.ACTION_EDIT;
	}

	public String remove() {
		return Constants.ACTION_REMOVE;
	}

}
