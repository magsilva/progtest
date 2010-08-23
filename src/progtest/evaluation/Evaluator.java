package progtest.evaluation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

import progtest.common.Evaluation;
import progtest.database.EvaluationDAO;
import progtest.exceptions.EvaluationException;
import progtest.reports.XMLParser;
import progtest.util.DirControl;
import progtest.util.Math;

public class Evaluator {

	private static double coveragePinstTinstFunctional;

	private static double coveragePalTalFunctional;

	private static double coveragePinstTalFunctional;

	private static double coveragePalTinstFunctional;

	private static double coveragePinstTinstAllNodes;

	private static double coveragePalTalAllNodes;

	private static double coveragePinstTalAllNodes;

	private static double coveragePalTinstAllNodes;

	private static double coveragePinstTinstAllEdges;

	private static double coveragePalTalAllEdges;

	private static double coveragePinstTalAllEdges;

	private static double coveragePalTinstAllEdges;

	private static double coveragePinstTinstAllUses;

	private static double coveragePalTalAllUses;

	private static double coveragePinstTalAllUses;

	private static double coveragePalTinstAllUses;

	private static double coveragePinstTinstAllPotUses;

	private static double coveragePalTalAllPotUses;

	private static double coveragePinstTalAllPotUses;

	private static double coveragePalTinstAllPotUses;

	private static double weightPalTal;

	private static double weightPinstTal;

	private static double weightPalTinst;

	private static double weightFunctional;

	private static double weightAllNodes;

	private static double weightAllEdges;

	private static double weightAllUses;

	private static double weightAllPotUses;

	private static double coveragePinstTinst;

	private static double coveragePalTal;

	private static double coveragePinstTal;

	private static double coveragePalTinst;

	private static double totalScore;

	public static void evaluate(Evaluation avaliation)
			throws EvaluationException {
		try {
			initializeAttributes(avaliation);
			calculateScore();
			generateXMLFiles(avaliation);
			saveAvaliation(avaliation);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new EvaluationException(e.getMessage(), e.getCause());
		}
	}

	private static void initializeAttributes(Evaluation avaliation) {
		initializeCoverages(avaliation);
		initializeWeights(avaliation);
	}

	private static void initializeCoverages(Evaluation avaliation) {
		initializePinstTinstCoverages(avaliation);
		initializePalTalCoverages(avaliation);
		initializePinstTalCoverages(avaliation);
		initializePalTinstCoverages(avaliation);
	}

	private static void initializePinstTinstCoverages(Evaluation avaliation) {

		initializePinstTinstFuncionalCoverage(avaliation);

		String path = DirControl.getPinstTinstReportsPath(avaliation
				.getAssignment())
				+ File.separator + "CriterionCoverage.xml";

		File XMLFile = new File(path);

		String values[][] = XMLParser.parse(XMLFile);

		coveragePinstTinstAllNodes = Double.parseDouble(values[1][3]) / 100;
		coveragePinstTinstAllEdges = Double.parseDouble(values[3][3]) / 100;
		coveragePinstTinstAllUses = Double.parseDouble(values[5][3]) / 100;
		coveragePinstTinstAllPotUses = Double.parseDouble(values[7][3]) / 100;

	}

	private static void initializePinstTinstFuncionalCoverage(
			Evaluation avaliation) {

		String path = DirControl.getPinstTinstReportsPath(avaliation
				.getAssignment())
				+ File.separator + "Funcional.xml";

		File XMLFile = new File(path);

		String values[][] = XMLParser.parse(XMLFile);

		coveragePinstTinstFunctional = Double.parseDouble(values[1][3]) / 100;

	}

	private static void initializePalTalCoverages(Evaluation avaliation) {

		initializePalTalFuncionalCoverage(avaliation);

		String path = DirControl.getPalTalReportsPath(avaliation
				.getAssignment(), avaliation.getStudent())
				+ File.separator + "CriterionCoverage.xml";

		File XMLFile = new File(path);

		String values[][] = XMLParser.parse(XMLFile);

		coveragePalTalAllNodes = Double.parseDouble(values[1][3]) / 100;
		coveragePalTalAllEdges = Double.parseDouble(values[3][3]) / 100;
		coveragePalTalAllUses = Double.parseDouble(values[5][3]) / 100;
		coveragePalTalAllPotUses = Double.parseDouble(values[7][3]) / 100;

	}

	private static void initializePalTalFuncionalCoverage(Evaluation avaliation) {

		String path = DirControl.getPalTalReportsPath(avaliation
				.getAssignment(), avaliation.getStudent())
				+ File.separator + "Funcional.xml";

		File XMLFile = new File(path);

		String values[][] = XMLParser.parse(XMLFile);

		coveragePalTalFunctional = Double.parseDouble(values[1][3]) / 100;

	}

	private static void initializePinstTalCoverages(Evaluation avaliation) {

		initializePinstTalFuncionalCoverage(avaliation);

		String path = DirControl.getPinstTalReportsPath(avaliation
				.getAssignment(), avaliation.getStudent())
				+ File.separator + "CriterionCoverage.xml";

		File XMLFile = new File(path);

		String values[][] = XMLParser.parse(XMLFile);

		coveragePinstTalAllNodes = Double.parseDouble(values[1][3]) / 100;
		coveragePinstTalAllEdges = Double.parseDouble(values[3][3]) / 100;
		coveragePinstTalAllUses = Double.parseDouble(values[5][3]) / 100;
		coveragePinstTalAllPotUses = Double.parseDouble(values[7][3]) / 100;

	}

	private static void initializePinstTalFuncionalCoverage(
			Evaluation avaliation) {

		String path = DirControl.getPinstTalReportsPath(avaliation
				.getAssignment(), avaliation.getStudent())
				+ File.separator + "Funcional.xml";

		File XMLFile = new File(path);

		String values[][] = XMLParser.parse(XMLFile);

		coveragePinstTalFunctional = Double.parseDouble(values[1][3]) / 100;

	}

	private static void initializePalTinstCoverages(Evaluation avaliation) {

		initializePalTinstFuncionalCoverage(avaliation);

		String path = DirControl.getPalTinstReportsPath(avaliation
				.getAssignment(), avaliation.getStudent())
				+ File.separator + "CriterionCoverage.xml";

		File XMLFile = new File(path);

		String values[][] = XMLParser.parse(XMLFile);

		coveragePalTinstAllNodes = Double.parseDouble(values[1][3]) / 100;
		coveragePalTinstAllEdges = Double.parseDouble(values[3][3]) / 100;
		coveragePalTinstAllUses = Double.parseDouble(values[5][3]) / 100;
		coveragePalTinstAllPotUses = Double.parseDouble(values[7][3]) / 100;

	}

	private static void initializePalTinstFuncionalCoverage(
			Evaluation avaliation) {

		String path = DirControl.getPalTinstReportsPath(avaliation
				.getAssignment(), avaliation.getStudent())
				+ File.separator + "Funcional.xml";

		File XMLFile = new File(path);

		String values[][] = XMLParser.parse(XMLFile);

		coveragePalTinstFunctional = Double.parseDouble(values[1][3]) / 100;

	}

	private static void initializeWeights(Evaluation avaliation) {
		weightPalTal = avaliation.getAssignment().getWeightPalTal();
		weightPinstTal = avaliation.getAssignment().getWeightPinstTal();
		weightPalTinst = avaliation.getAssignment().getWeightPalTinst();
		weightFunctional = avaliation.getAssignment().getWeightFunctional();
		weightAllNodes = avaliation.getAssignment().getWeightAllNodes();
		weightAllEdges = avaliation.getAssignment().getWeightAllEdges();
		weightAllUses = avaliation.getAssignment().getWeightAllUses();
		weightAllPotUses = avaliation.getAssignment().getWeightAllPotUses();
	}

	private static void calculateScore() {

		coveragePinstTinst = coveragePinstTinst();
		coveragePalTal = coveragePalTal();
		coveragePinstTal = coveragePinstTal();
		coveragePalTinst = coveragePalTinst();

		totalScore = (coveragePalTal * weightPalTal + coveragePinstTal
				* weightPinstTal + (coveragePalTinst/coveragePinstTinst) * weightPalTinst)
				/ (weightPalTal + weightPinstTal + weightPalTinst);

	}

	private static double coveragePinstTinst() {
		return (coveragePinstTinstFunctional * weightFunctional
				+ coveragePinstTinstAllNodes * weightAllNodes
				+ coveragePinstTinstAllEdges * weightAllEdges
				+ coveragePinstTinstAllUses * weightAllUses + coveragePinstTinstAllPotUses
				* weightAllPotUses)
				/ (weightFunctional + weightAllNodes + weightAllEdges
						+ weightAllUses + weightAllPotUses);
	}

	private static double coveragePalTal() {
		return (coveragePalTalFunctional * weightFunctional
				+ coveragePalTalAllNodes * weightAllNodes
				+ coveragePalTalAllEdges * weightAllEdges
				+ coveragePalTalAllUses * weightAllUses + coveragePalTalAllPotUses
				* weightAllPotUses)
				/ (weightFunctional + weightAllNodes + weightAllEdges
						+ weightAllUses + weightAllPotUses);
	}

	private static double coveragePalTinst() {
		return (coveragePalTinstFunctional * weightFunctional
				+ coveragePalTinstAllNodes * weightAllNodes
				+ coveragePalTinstAllEdges * weightAllEdges
				+ coveragePalTinstAllUses * weightAllUses + coveragePalTinstAllPotUses
				* weightAllPotUses)
				/ (weightFunctional + weightAllNodes + weightAllEdges
						+ weightAllUses + weightAllPotUses);
	}

	private static double coveragePinstTal() {
		return (coveragePinstTalFunctional * weightFunctional
				+ coveragePinstTalAllNodes * weightAllNodes
				+ coveragePinstTalAllEdges * weightAllEdges
				+ coveragePinstTalAllUses * weightAllUses + coveragePinstTalAllPotUses
				* weightAllPotUses)
				/ (weightFunctional + weightAllNodes + weightAllEdges
						+ weightAllUses + weightAllPotUses);
	}

	private static void generateXMLFiles(Evaluation avaliation)
			throws FileNotFoundException {
		generateXMLGeneralCoverage(avaliation);
		generateXMLTotalCoverage(avaliation);
	}

	private static void generateXMLGeneralCoverage(Evaluation avaliation)
			throws FileNotFoundException {

		String values[][] = new String[6][5];
		values[0][0] = "Criterion";
		values[0][1] = "P_Inst-T_Inst";
		values[0][2] = "P_St-T_St";
		values[0][3] = "P_Inst-T_Stu";
		values[0][4] = "P_St-T_Inst";
		values[1][0] = "Functional";
		values[1][1] = String.valueOf(Math.round(
				coveragePinstTinstFunctional * 100, 2))
				+ "%";
		values[1][2] = String.valueOf(Math.round(
				coveragePalTalFunctional * 100, 2))
				+ "%";
		values[1][3] = String.valueOf(Math.round(
				coveragePinstTalFunctional * 100, 2))
				+ "%";
		values[1][4] = String.valueOf(Math.round(
				coveragePalTinstFunctional * 100, 2))
				+ "%";
		values[2][0] = "All-Nodes";
		values[2][1] = String.valueOf(Math.round(
				coveragePinstTinstAllNodes * 100, 2))
				+ "%";
		values[2][2] = String.valueOf(Math.round(coveragePalTalAllNodes * 100,
				2))
				+ "%";
		values[2][3] = String.valueOf(Math.round(
				coveragePinstTalAllNodes * 100, 2))
				+ "%";
		values[2][4] = String.valueOf(Math.round(
				coveragePalTinstAllNodes * 100, 2))
				+ "%";
		values[3][0] = "All-Edges";
		values[3][1] = String.valueOf(Math.round(
				coveragePinstTinstAllEdges * 100, 2))
				+ "%";
		values[3][2] = String.valueOf(Math.round(coveragePalTalAllEdges * 100,
				2))
				+ "%";
		values[3][3] = String.valueOf(Math.round(
				coveragePinstTalAllEdges * 100, 2))
				+ "%";
		values[3][4] = String.valueOf(Math.round(
				coveragePalTinstAllEdges * 100, 2))
				+ "%";
		values[4][0] = "All-Uses";
		values[4][1] = String.valueOf(Math.round(
				coveragePinstTinstAllUses * 100, 2))
				+ "%";
		values[4][2] = String.valueOf(Math
				.round(coveragePalTalAllUses * 100, 2))
				+ "%";
		values[4][3] = String.valueOf(Math.round(coveragePinstTalAllUses * 100,
				2))
				+ "%";
		values[4][4] = String.valueOf(Math.round(coveragePalTinstAllUses * 100,
				2))
				+ "%";
		values[5][0] = "All-Pot-Uses";
		values[5][1] = String.valueOf(Math.round(
				coveragePinstTinstAllPotUses * 100, 2))
				+ "%";
		values[5][2] = String.valueOf(Math.round(
				coveragePalTalAllPotUses * 100, 2))
				+ "%";
		values[5][3] = String.valueOf(Math.round(
				coveragePinstTalAllPotUses * 100, 2))
				+ "%";
		values[5][4] = String.valueOf(Math.round(
				coveragePalTinstAllPotUses * 100, 2))
				+ "%";

		String root = "GeneralCoverage";

		String path = DirControl.getUserReportsPath(avaliation.getAssignment(),
				avaliation.getStudent())
				+ File.separator + "GeneralCoverage.xml";

		XMLParser.generateXML(root, values, path);

	}

	private static void generateXMLTotalCoverage(Evaluation avaliation)
			throws FileNotFoundException {

		String values[][] = new String[5][2];
		values[0][0] = "Executions";
		values[1][0] = "Instructor's Program - Instructor's Test Set (P_Inst-T-Inst)";
		values[2][0] = "Student's Program - Student's Test Set (P_St-T-St)";
		values[3][0] = "Instructor's Program - Student's Test Set (P_Inst-T-St)";
		values[4][0] = "Student's Program - Instructor's Test Set (P_St-T-Inst)";
		values[0][1] = "Coverage";
		values[1][1] = String.valueOf(Math.round(coveragePinstTinst * 100, 2))
				+ "%";
		values[2][1] = String.valueOf(Math.round(coveragePalTal * 100, 2))
				+ "%";
		values[3][1] = String.valueOf(Math.round(coveragePinstTal * 100, 2))
				+ "%";
		values[4][1] = String.valueOf(Math.round(coveragePalTinst * 100, 2))
				+ "%";

		String root = "TotalCoverage";

		String path = DirControl.getUserReportsPath(avaliation.getAssignment(),
				avaliation.getStudent())
				+ File.separator + "TotalCoverage.xml";

		XMLParser.generateXML(root, values, path);

	}

	private static void saveAvaliation(Evaluation avaliation) {
		avaliation.setSubmissionDate(new Date());
		avaliation.setScore(Math.round(totalScore * 100, 2));
		EvaluationDAO.update(avaliation);
	}

}
