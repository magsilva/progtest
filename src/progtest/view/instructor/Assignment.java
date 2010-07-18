package progtest.view.instructor;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Evaluation;
import progtest.database.Querier;
import progtest.reports.ClassCoverage;
import progtest.reports.CoveredAndUncovered;
import progtest.reports.CriterionCoverage;
import progtest.reports.FuncionalCoverage;
import progtest.reports.MethodCoverage;
import progtest.reports.ReportGenerator;
import progtest.reports.RequiredElement;
import progtest.util.Constants;
import progtest.util.ContextManager;
import progtest.util.DirControl;

public class Assignment {

	private int viewId;

	private String title;

	private String description;

	private Date startDate;

	private Date endDate;

	private List<Evaluation> evaluations = new ArrayList<Evaluation>();

	private UIData evaluationsTable;

	private List<FuncionalCoverage> funcionalCoverageReport = new ArrayList<FuncionalCoverage>();

	private UIData funcionalCoverageTable;

	private List<RequiredElement> requiredElementsReport = new ArrayList<RequiredElement>();

	private UIData requiredElementTable;

	private List<ClassCoverage> classCoverageReport = new ArrayList<ClassCoverage>();

	private UIData classCoverageTable;

	private List<MethodCoverage> methodCoverageReport = new ArrayList<MethodCoverage>();

	private UIData methodCoverageTable;

	private List<CriterionCoverage> criterionCoverageReport = new ArrayList<CriterionCoverage>();

	private UIData criterionCoverageTable;

	private List<CoveredAndUncovered> coveredAndUncoveredReport = new ArrayList<CoveredAndUncovered>();

	private UIData coveredAndUncoveredTable;

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

	public List<FuncionalCoverage> getFuncionalCoverageReport() {
		return funcionalCoverageReport;
	}

	public void setFuncionalCoverageReport(
			List<FuncionalCoverage> funcionalCoverageReport) {
		this.funcionalCoverageReport = funcionalCoverageReport;
	}

	public UIData getFuncionalCoverageTable() {
		return funcionalCoverageTable;
	}

	public void setFuncionalCoverageTable(UIData funcionalCoverageTable) {
		this.funcionalCoverageTable = funcionalCoverageTable;
	}

	public List<RequiredElement> getRequiredElementsReport() {
		return requiredElementsReport;
	}

	public void setRequiredElementsReport(
			List<RequiredElement> requiredElementsReport) {
		this.requiredElementsReport = requiredElementsReport;
	}

	public UIData getRequiredElementTable() {
		return requiredElementTable;
	}

	public void setRequiredElementTable(UIData requiredElementTable) {
		this.requiredElementTable = requiredElementTable;
	}

	public List<ClassCoverage> getClassCoverageReport() {
		return classCoverageReport;
	}

	public void setClassCoverageReport(List<ClassCoverage> classCoverageReport) {
		this.classCoverageReport = classCoverageReport;
	}

	public UIData getClassCoverageTable() {
		return classCoverageTable;
	}

	public void setClassCoverageTable(UIData classCoverageTable) {
		this.classCoverageTable = classCoverageTable;
	}

	public List<MethodCoverage> getMethodCoverageReport() {
		return methodCoverageReport;
	}

	public void setMethodCoverageReport(
			List<MethodCoverage> methodCoverageReport) {
		this.methodCoverageReport = methodCoverageReport;
	}

	public UIData getMethodCoverageTable() {
		return methodCoverageTable;
	}

	public void setMethodCoverageTable(UIData methodCoverageTable) {
		this.methodCoverageTable = methodCoverageTable;
	}

	public List<CriterionCoverage> getCriterionCoverageReport() {
		return criterionCoverageReport;
	}

	public void setCriterionCoverageReport(
			List<CriterionCoverage> criterionCoverageReport) {
		this.criterionCoverageReport = criterionCoverageReport;
	}

	public UIData getCriterionCoverageTable() {
		return criterionCoverageTable;
	}

	public void setCriterionCoverageTable(UIData criterionCoverageTable) {
		this.criterionCoverageTable = criterionCoverageTable;
	}

	public List<CoveredAndUncovered> getCoveredAndUncoveredReport() {
		return coveredAndUncoveredReport;
	}

	public void setCoveredAndUncoveredReport(
			List<CoveredAndUncovered> coveredAndUncoveredReport) {
		this.coveredAndUncoveredReport = coveredAndUncoveredReport;
	}

	public UIData getCoveredAndUncoveredTable() {
		return coveredAndUncoveredTable;
	}

	public void setCoveredAndUncoveredTable(UIData coveredAndUncoveredTable) {
		this.coveredAndUncoveredTable = coveredAndUncoveredTable;
	}

	public Assignment() {

		progtest.common.Assignment assignment = (progtest.common.Assignment) ContextManager
				.getSession(Constants.SESSION_ASSIGNMENT);

		title = assignment.getTitle();

		description = assignment.getDescription();

		startDate = assignment.getStartDate();

		endDate = assignment.getEndDate();
		
		evaluations = Querier.getEvaluations(assignment);

		selectAboutView();
		
		funcionalCoverageReport = ReportGenerator
				.getFuncionalCoverageReport(new File(DirControl
						.getPinstTinstReportsPath(assignment)
						+ File.separator + "Funcional.xml"));

		requiredElementsReport = ReportGenerator
				.getRequiredElementsReport(new File(DirControl
						.getPinstTinstReportsPath(assignment)
						+ File.separator + "RequiredElements.xml"));

		classCoverageReport = ReportGenerator.getClassCoverageReport(new File(
				DirControl.getPinstTinstReportsPath(assignment) + File.separator
						+ "ClassCoverage.xml"));

		methodCoverageReport = ReportGenerator
				.getMethodCoverageReport(new File(DirControl
						.getPinstTinstReportsPath(assignment)
						+ File.separator + "MethodCoverage.xml"));

		criterionCoverageReport = ReportGenerator
				.getCriterionCoverageReport(new File(DirControl
						.getPinstTinstReportsPath(assignment)
						+ File.separator + "CriterionCoverage.xml"));

		coveredAndUncoveredReport = ReportGenerator
				.getCoveredAndUncoveredReport(new File(DirControl
						.getPinstTinstReportsPath(assignment)
						+ File.separator + "CoveredAndUncovered.xml"));

	}

	public String selectAboutView() {
		viewId = 0;
		return Constants.ACTION_SELECT;
	}

	public String selectGradesView() {
		viewId = 1;
		return Constants.ACTION_SELECT;
	}

	public String selectFunctionalTestView() {
		viewId = 2;
		return Constants.ACTION_SELECT;
	}

	public String selectRequiredElementsView() {
		viewId = 3;
		return Constants.ACTION_SELECT;
	}

	public String selectClassCoverageView() {
		viewId = 4;
		return Constants.ACTION_SELECT;
	}

	public String selectMethodCoverageView() {
		viewId = 5;
		return Constants.ACTION_SELECT;
	}

	public String selectCriterionCoverageView() {
		viewId = 6;
		return Constants.ACTION_SELECT;
	}

	public String selectCoveredAndUncoveredView() {
		viewId = 7;
		return Constants.ACTION_SELECT;
	}

	public String edit() {
		return Constants.ACTION_EDIT;
	}

	public String remove() {
		return Constants.ACTION_REMOVE;
	}

}
