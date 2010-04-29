package progtest.view.student;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Evaluation;
import progtest.reports.ClassCoverage;
import progtest.reports.CoveredAndUncovered;
import progtest.reports.CriterionCoverage;
import progtest.reports.FuncionalCoverage;
import progtest.reports.GeneralCoverage;
import progtest.reports.MethodCoverage;
import progtest.reports.ReportGenerator;
import progtest.reports.RequiredElement;
import progtest.reports.ResultAvaliation;
import progtest.reports.TotalCoverage;
import progtest.util.Constants;
import progtest.util.ContextManager;
import progtest.util.DirControl;

public class AssignmentInfo {

	private int viewId;

	private String title;

	private String description;

	private Date startDate;

	private Date endDate;

	private Date submissionDate;

	private double score;

	private List<GeneralCoverage> generalCoverageReport = new ArrayList<GeneralCoverage>();

	private UIData generalCoverageTable;

	private List<TotalCoverage> totalCoverageReport = new ArrayList<TotalCoverage>();

	private UIData totalCoverageTable;

	private List<ResultAvaliation> resultAvaliationReport = new ArrayList<ResultAvaliation>();

	private UIData resultAvaliationTable;

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

	public List<GeneralCoverage> getGeneralCoverageReport() {
		return generalCoverageReport;
	}

	public void setGeneralCoverageReport(
			List<GeneralCoverage> generalCoverageReport) {
		this.generalCoverageReport = generalCoverageReport;
	}

	public UIData getGeneralCoverageTable() {
		return generalCoverageTable;
	}

	public void setGeneralCoverageTable(UIData generalCoverageTable) {
		this.generalCoverageTable = generalCoverageTable;
	}

	public List<TotalCoverage> getTotalCoverageReport() {
		return totalCoverageReport;
	}

	public void setTotalCoverageReport(List<TotalCoverage> totalCoverageReport) {
		this.totalCoverageReport = totalCoverageReport;
	}

	public UIData getTotalCoverageTable() {
		return totalCoverageTable;
	}

	public void setTotalCoverageTable(UIData totalCoverageTable) {
		this.totalCoverageTable = totalCoverageTable;
	}

	public List<ResultAvaliation> getResultAvaliationReport() {
		return resultAvaliationReport;
	}

	public void setResultAvaliationReport(
			List<ResultAvaliation> resultAvaliationReport) {
		this.resultAvaliationReport = resultAvaliationReport;
	}

	public UIData getResultAvaliationTable() {
		return resultAvaliationTable;
	}

	public void setResultAvaliationTable(UIData resultAvaliationTable) {
		this.resultAvaliationTable = resultAvaliationTable;
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

	public AssignmentInfo() {

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

			selectResultAvaliationView();

			generalCoverageReport = ReportGenerator
					.getGeneralCoverageReport(new File(DirControl
							.getUserReportsPath(evaluation.getAssignment(),
									evaluation.getStudent())
							+ File.separator + "GeneralCoverage.xml"));

			totalCoverageReport = ReportGenerator
					.getTotalCoverageReport(new File(DirControl
							.getUserReportsPath(evaluation.getAssignment(),
									evaluation.getStudent())
							+ File.separator + "TotalCoverage.xml"));

			resultAvaliationReport = ReportGenerator
					.getResultAvaliationReport(new File(DirControl
							.getUserReportsPath(evaluation.getAssignment(),
									evaluation.getStudent())
							+ File.separator + "ResultAvaliation.xml"));

			funcionalCoverageReport = ReportGenerator
					.getFuncionalCoverageReport(new File(DirControl
							.getPalTalReportsPath(evaluation.getAssignment(),
									evaluation.getStudent())
							+ File.separator + "Funcional.xml"));

			requiredElementsReport = ReportGenerator
					.getRequiredElementsReport(new File(DirControl
							.getPalTalReportsPath(evaluation.getAssignment(),
									evaluation.getStudent())
							+ File.separator + "RequiredElements.xml"));

			classCoverageReport = ReportGenerator
					.getClassCoverageReport(new File(DirControl
							.getPalTalReportsPath(evaluation.getAssignment(),
									evaluation.getStudent())
							+ File.separator + "ClassCoverage.xml"));

			methodCoverageReport = ReportGenerator
					.getMethodCoverageReport(new File(DirControl
							.getPalTalReportsPath(evaluation.getAssignment(),
									evaluation.getStudent())
							+ File.separator + "MethodCoverage.xml"));

			criterionCoverageReport = ReportGenerator
					.getCriterionCoverageReport(new File(DirControl
							.getPalTalReportsPath(evaluation.getAssignment(),
									evaluation.getStudent())
							+ File.separator + "CriterionCoverage.xml"));

			coveredAndUncoveredReport = ReportGenerator
					.getCoveredAndUncoveredReport(new File(DirControl
							.getPalTalReportsPath(evaluation.getAssignment(),
									evaluation.getStudent())
							+ File.separator + "CoveredAndUncovered.xml"));

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

	public String selectResultAvaliationView() {
		viewId = 2;
		return Constants.ACTION_SELECT;
	}

	public String selectFunctionalTestView() {
		viewId = 3;
		return Constants.ACTION_SELECT;
	}

	public String selectRequiredElementsView() {
		viewId = 4;
		return Constants.ACTION_SELECT;
	}

	public String selectClassCoverageView() {
		viewId = 5;
		return Constants.ACTION_SELECT;
	}

	public String selectMethodCoverageView() {
		viewId = 6;
		return Constants.ACTION_SELECT;
	}

	public String selectCriterionCoverageView() {
		viewId = 7;
		return Constants.ACTION_SELECT;
	}

	public String selectCoveredAndUncoveredView() {
		viewId = 8;
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
