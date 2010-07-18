package progtest.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {

	public static List<FuncionalCoverage> getFuncionalCoverageReport(File f) {

		List<FuncionalCoverage> funcionalCoverageReport = new ArrayList<FuncionalCoverage>();

		String report[][] = XMLParser.parse(f);

		for (int i = 1; i < report.length; i++) {

			FuncionalCoverage funcionalCoverage = new FuncionalCoverage();
			funcionalCoverage.setTests(report[i][0]);
			funcionalCoverage.setErrors(report[i][1]);
			funcionalCoverage.setFailures(report[i][2]);
			funcionalCoverage.setCoverage(report[i][3] + "%");
			funcionalCoverageReport.add(funcionalCoverage);

		}

		return funcionalCoverageReport;

	}

	public static List<TestCase> getTestCaseReport(File f) {

		List<TestCase> testCaseReport = new ArrayList<TestCase>();

		String report[][] = XMLParser.parse(f);

		for (int i = 1; i < report.length; i++) {

			TestCase testCase = new TestCase();
			testCase.setClassName(report[i][0]);
			testCase.setName(report[i][1]);
			testCase.setStatus(report[i][2]);
			testCaseReport.add(testCase);

		}

		return testCaseReport;

	}

	public static List<RequiredElement> getRequiredElementsReport(File f) {

		List<RequiredElement> requiredElementsReport = new ArrayList<RequiredElement>();

		String report[][] = XMLParser.parse(f);

		for (int i = 1; i < report.length; i++) {

			RequiredElement requiredElement = new RequiredElement();
			requiredElement.setMethod(report[i][0]);
			requiredElement.setAllNodes(report[i][1]);
			requiredElement.setAllEdges(report[i][3]);
			requiredElement.setAllUses(report[i][5]);
			requiredElement.setAllPotUses(report[i][7]);
			requiredElementsReport.add(requiredElement);

		}

		return requiredElementsReport;

	}

	public static List<Metric> getMetricsReport(File f) {

		List<Metric> metricsReport = new ArrayList<Metric>();

		String report[][] = XMLParser.parse(f);

		for (int i = 1; i < report.length; i++) {

			Metric metric = new Metric();
			metric.setClazz(report[i][0]);
			metric.setAMZ_LOCM(report[i][1]);
			metric.setAMZ_SIZE(report[i][2]);
			metric.setANPM(report[i][3]);
			metric.setCBO(report[i][4]);
			metric.setCC_AVG(report[i][5]);
			metric.setCC_MAX(report[i][6]);
			metric.setDIT(report[i][7]);
			metric.setLCOM(report[i][8]);
			metric.setLCOM_2(report[i][9]);
			metric.setLCOM_3(report[i][10]);
			metric.setMNPM(report[i][11]);
			metric.setNCM(report[i][12]);
			metric.setNCM_2(report[i][13]);
			metric.setNCV(report[i][14]);
			metric.setNII(report[i][15]);
			metric.setNIV(report[i][16]);
			metric.setNMAS(report[i][17]);
			metric.setNMIS(report[i][18]);
			metric.setNMOS(report[i][19]);
			metric.setNOC(report[i][20]);
			metric.setNPIM(report[i][21]);
			metric.setRFC(report[i][22]);
			metric.setSI(report[i][23]);
			metric.setWMC_CC(report[i][24]);
			metric.setWMC_L(report[i][25]);
			metric.setWMC_LOCM(report[i][26]);
			metric.setWMC_SIZE(report[i][27]);
			metricsReport.add(metric);

		}

		return metricsReport;

	}

	public static List<ClassCoverage> getClassCoverageReport(File f) {

		List<ClassCoverage> classCoverageReport = new ArrayList<ClassCoverage>();

		String report[][] = XMLParser.parse(f);

		int i;

		for (i = 1; i < report.length; i++) {

			ClassCoverage classCoverage = new ClassCoverage();
			classCoverage.setClazz(report[i][0]);
			classCoverage.setAllNodes(report[i][1]);
			classCoverage.setAllEdges(report[i][3]);
			classCoverage.setAllUses(report[i][5]);
			classCoverage.setAllPotUses(report[i][7]);
			classCoverageReport.add(classCoverage);

		}

		return classCoverageReport;

	}

	public static List<MethodCoverage> getMethodCoverageReport(File f) {

		List<MethodCoverage> methodCoverageReport = new ArrayList<MethodCoverage>();

		String report[][] = XMLParser.parse(f);

		int i;

		for (i = 1; i < report.length; i++) {

			MethodCoverage methodCoverage = new MethodCoverage();
			methodCoverage.setMethod(report[i][0]);
			methodCoverage.setAllNodes(report[i][1]);
			methodCoverage.setAllEdges(report[i][3]);
			methodCoverage.setAllUses(report[i][5]);
			methodCoverage.setAllPotUses(report[i][7]);
			methodCoverageReport.add(methodCoverage);

		}

		return methodCoverageReport;

	}

	public static List<CriterionCoverage> getCriterionCoverageReport(File f) {

		List<CriterionCoverage> criterionCoverageReport = new ArrayList<CriterionCoverage>();

		String report[][] = XMLParser.parse(f);

		int i;

		for (i = 1; i < report.length; i += 2) {

			CriterionCoverage criterionCoverage = new CriterionCoverage();
			criterionCoverage.setCriterion(report[i][0]);
			criterionCoverage.setNumberOfElements(report[i][1]);
			criterionCoverage.setNumberOfCoveredElements(report[i][2]);
			criterionCoverage.setPercentage(report[i][3]);
			criterionCoverageReport.add(criterionCoverage);

		}

		return criterionCoverageReport;

	}

	public static List<CoveredAndUncovered> getCoveredAndUncoveredReport(File f) {

		List<CoveredAndUncovered> coveredAndUncoveredReport = new ArrayList<CoveredAndUncovered>();

		String report[][] = XMLParser.parse(f);

		int i;

		for (i = 1; i < report.length; i += 2) {

			CoveredAndUncovered coveredAndUncovered = new CoveredAndUncovered();
			coveredAndUncovered.setMethod(report[i][0]);
			coveredAndUncovered.setCriterion(report[i][1]);
			coveredAndUncovered.setCoveredElements(report[i][2]);
			coveredAndUncovered.setUncoveredElements(report[i][3]);
			coveredAndUncoveredReport.add(coveredAndUncovered);

		}

		return coveredAndUncoveredReport;

	}

	public static List<GeneralCoverage> getGeneralCoverageReport(File f) {

		List<GeneralCoverage> generalCoverageReport = new ArrayList<GeneralCoverage>();

		String report[][] = XMLParser.parse(f);

		int i;

		for (i = 1; i < report.length; i++) {

			GeneralCoverage generalCoverage = new GeneralCoverage();
			generalCoverage.setCriterion(report[i][0]);
			generalCoverage.setPinstTinst(report[i][1]);
			generalCoverage.setPalTal(report[i][2]);
			generalCoverage.setPinstTal(report[i][3]);
			generalCoverage.setPalTinst(report[i][4]);
			generalCoverageReport.add(generalCoverage);

		}

		return generalCoverageReport;

	}

	public static List<ResultAvaliation> getResultAvaliationReport(File f) {

		List<ResultAvaliation> resultAvaliationReport = new ArrayList<ResultAvaliation>();

		String report[][] = XMLParser.parse(f);

		int i;

		for (i = 1; i < report.length; i++) {

			ResultAvaliation resultAvaliation = new ResultAvaliation();
			resultAvaliation.setElement(report[i][0]);
			resultAvaliation.setValue(report[i][1]);
			resultAvaliationReport.add(resultAvaliation);

		}

		return resultAvaliationReport;

	}

	public static List<TotalCoverage> getTotalCoverageReport(File f) {

		List<TotalCoverage> totalCoverageReport = new ArrayList<TotalCoverage>();

		String report[][] = XMLParser.parse(f);

		int i;

		for (i = 1; i < report.length; i++) {

			TotalCoverage totalCoverage = new TotalCoverage();
			totalCoverage.setExecution(report[i][0]);
			totalCoverage.setCoverage(report[i][1]);
			totalCoverageReport.add(totalCoverage);

		}

		return totalCoverageReport;

	}

}
