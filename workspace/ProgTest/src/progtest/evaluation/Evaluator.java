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

	private static double coveragePinstTinst;

	private static double coveragePalTal;

	private static double coveragePinstTal;

	private static double coveragePalTinst;

	private static double coveragePinstTinstFuncional;

	private static double coveragePalTalFuncional;

	private static double coveragePinstTalFuncional;

	private static double coveragePalTinstFuncional;

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

	private static double weightProgram;

	private static double weightTest;

	private static double weightFuncional;

	private static double weightAllNodes;

	private static double weightAllEdges;

	private static double weightAllUses;

	private static double weightAllPotUses;
	
	private static double programScore;
	
	private static double testScore;

	private static double totalScore;

	public static void evaluate(Evaluation avaliation) throws EvaluationException {
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

		coveragePinstTinstFuncional = Double.parseDouble(values[1][3]) / 100;
		
	}

	private static void initializePalTalCoverages(Evaluation avaliation) {
		
		initializePalTalFuncionalCoverage(avaliation);

		String path = DirControl.getPalTalReportsPath(
				avaliation.getAssignment(), avaliation.getStudent())
				+ File.separator + "CriterionCoverage.xml";

		File XMLFile = new File(path);

		String values[][] = XMLParser.parse(XMLFile);

		coveragePalTalAllNodes = Double.parseDouble(values[1][3]) / 100;
		coveragePalTalAllEdges = Double.parseDouble(values[3][3]) / 100;
		coveragePalTalAllUses = Double.parseDouble(values[5][3]) / 100;
		coveragePalTalAllPotUses = Double.parseDouble(values[7][3]) / 100;

	}

	private static void initializePalTalFuncionalCoverage(
			Evaluation avaliation) {

		String path = DirControl.getPalTalReportsPath(avaliation
				.getAssignment(), avaliation.getStudent())
				+ File.separator + "Funcional.xml";

		File XMLFile = new File(path);

		String values[][] = XMLParser.parse(XMLFile);

		coveragePalTalFuncional = Double.parseDouble(values[1][3]) / 100;
		
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

		coveragePinstTalFuncional = Double.parseDouble(values[1][3]) / 100;
		
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

		coveragePalTinstFuncional = Double.parseDouble(values[1][3]) / 100;
		
	}

	private static void initializeWeights(Evaluation avaliation) {
		weightProgram = avaliation.getAssignment().getWeightPinstTal();
		weightTest = avaliation.getAssignment().getWeightPalTinst();
		weightFuncional = avaliation.getAssignment().getWeightFunctional();
		weightAllNodes = avaliation.getAssignment().getWeightAllNodes();
		weightAllEdges = avaliation.getAssignment().getWeightAllEdges();
		weightAllUses = avaliation.getAssignment().getWeightAllUses();
		weightAllPotUses = avaliation.getAssignment().getWeightAllPotUses();
	}

	private static void calculateScore() {

		coveragePinstTinst = calculatePinstTinst();
		coveragePalTal = calculatePalTal();
		coveragePinstTal = calculatePinstTal();
		coveragePalTinst = calculatePalTinst();
		
		double ts1;
		
		double ts2;
		
		if(coveragePinstTinst > 0)
			ts1 = coveragePinstTal / coveragePinstTinst;
		else
			ts1 = 1;
		
		if(ts1 > 1)
			ts1 = 1;
		
		if(coveragePalTinst > 0)
			ts2 = coveragePalTal / coveragePalTinst;
		else
			ts2 = 1;
		
		if(ts2 > 1)
			ts2 = 1;
		
		testScore = (ts1 + ts2) / 2;
		
		programScore = coveragePalTinstFuncional;
		
		if(programScore > 1)
			programScore = 1;

		totalScore = (programScore * weightProgram + testScore * weightTest) / (weightProgram + weightTest);

	}

	private static double calculatePinstTinst() {

		return (coveragePinstTinstFuncional * weightFuncional + coveragePinstTinstAllNodes * weightAllNodes
				+ coveragePinstTinstAllEdges * weightAllEdges
				+ coveragePinstTinstAllUses * weightAllUses + coveragePinstTinstAllPotUses
				* weightAllPotUses)
				/ (weightFuncional + weightAllNodes + weightAllEdges + weightAllUses + weightAllPotUses);

	}

	private static double calculatePalTal() {

		return (coveragePalTalFuncional * weightFuncional + coveragePalTalAllNodes * weightAllNodes
				+ coveragePalTalAllEdges * weightAllEdges
				+ coveragePalTalAllUses * weightAllUses + coveragePalTalAllPotUses
				* weightAllPotUses)
				/ (weightFuncional + weightAllNodes + weightAllEdges + weightAllUses + weightAllPotUses);

	}

	private static double calculatePinstTal() {

		return (coveragePinstTalFuncional * weightFuncional + coveragePinstTalAllNodes * weightAllNodes
				+ coveragePinstTalAllEdges * weightAllEdges
				+ coveragePinstTalAllUses * weightAllUses + coveragePinstTalAllPotUses
				* weightAllPotUses)
				/ (weightFuncional + weightAllNodes + weightAllEdges + weightAllUses + weightAllPotUses);

	}

	private static double calculatePalTinst() {

		return (coveragePalTinstFuncional * weightFuncional + coveragePalTinstAllNodes * weightAllNodes
				+ coveragePalTinstAllEdges * weightAllEdges
				+ coveragePalTinstAllUses * weightAllUses + coveragePalTinstAllPotUses
				* weightAllPotUses)
				/ (weightFuncional + weightAllNodes + weightAllEdges + weightAllUses + weightAllPotUses);

	}

	private static void generateXMLFiles(Evaluation avaliation)
			throws FileNotFoundException {
		generateXMLGeneralCoverage(avaliation);
		generateXMLTotalCoverage(avaliation);
		generateXMLResultAvaliation(avaliation);
	}

	private static void generateXMLGeneralCoverage(Evaluation avaliation)
			throws FileNotFoundException {

		String values[][] = new String[6][5];
		values[0][0] = "Criterio";
		values[0][1] = "Pinst-Tinst";
		values[0][2] = "Pal-Tal";
		values[0][3] = "Pinst-Tal";
		values[0][4] = "Pal-Tinst";
		values[1][0] = "Funcional";
		values[1][1] = String.valueOf(coveragePinstTinstFuncional * 100) + "%";
		values[1][2] = String.valueOf(coveragePalTalFuncional * 100) + "%";
		values[1][3] = String.valueOf(coveragePinstTalFuncional * 100) + "%";
		values[1][4] = String.valueOf(coveragePalTinstFuncional * 100) + "%";
		values[2][0] = "Todos-Nos";
		values[2][1] = String.valueOf(coveragePinstTinstAllNodes * 100) + "%";
		values[2][2] = String.valueOf(coveragePalTalAllNodes * 100) + "%";
		values[2][3] = String.valueOf(coveragePinstTalAllNodes * 100) + "%";
		values[2][4] = String.valueOf(coveragePalTinstAllNodes * 100) + "%";
		values[3][0] = "Todos-Arcos";
		values[3][1] = String.valueOf(coveragePinstTinstAllEdges * 100) + "%";
		values[3][2] = String.valueOf(coveragePalTalAllEdges * 100) + "%";
		values[3][3] = String.valueOf(coveragePinstTalAllEdges * 100) + "%";
		values[3][4] = String.valueOf(coveragePalTinstAllEdges * 100) + "%";
		values[4][0] = "Todos-Usos";
		values[4][1] = String.valueOf(coveragePinstTinstAllUses * 100) + "%";
		values[4][2] = String.valueOf(coveragePalTalAllUses * 100) + "%";
		values[4][3] = String.valueOf(coveragePinstTalAllUses * 100) + "%";
		values[4][4] = String.valueOf(coveragePalTinstAllUses * 100) + "%";
		values[5][0] = "Todos-Potenciais-Usos";
		values[5][1] = String.valueOf(coveragePinstTinstAllPotUses * 100) + "%";
		values[5][2] = String.valueOf(coveragePalTalAllPotUses * 100) + "%";
		values[5][3] = String.valueOf(coveragePinstTalAllPotUses * 100) + "%";
		values[5][4] = String.valueOf(coveragePalTinstAllPotUses * 100) + "%";

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
		values[1][0] = "Programa do Professor - Conjunto de Teste do Professor";
		values[2][0] = "Programa do Aluno - Conjunto de Teste do Aluno";
		values[3][0] = "Programa do Professor - Conjunto de Teste do Aluno";
		values[4][0] = "Programa do Aluno - Conjunto de Teste do Professor";
		values[0][1] = "Coverage";
		values[1][1] = String.valueOf(Math.round(coveragePinstTinst * 100, 2)) + "%";
		values[2][1] = String.valueOf(Math.round(coveragePalTal * 100, 2)) + "%";
		values[3][1] = String.valueOf(Math.round(coveragePinstTal * 100, 2)) + "%";
		values[4][1] = String.valueOf(Math.round(coveragePalTinst * 100, 2)) + "%";

		String root = "TotalCoverage";

		String path = DirControl.getUserReportsPath(avaliation.getAssignment(),
				avaliation.getStudent())
				+ File.separator + "TotalCoverage.xml";

		XMLParser.generateXML(root, values, path);

	}

	private static void generateXMLResultAvaliation(Evaluation avaliation)
			throws FileNotFoundException {

		String values[][] = new String[3][2];
		values[0][0] = "Result";
		values[1][0] = "Qualidade do Programa";
		values[2][0] = "Qualidade do Conjunto de Teste";
		values[0][1] = "Score";
		values[1][1] = String.valueOf(Math.round(programScore * 100, 2)) + "%";
		values[2][1] = String.valueOf(Math.round(testScore * 100, 2)) + "%";

		String root = "EvaluationResult";

		String path = DirControl.getUserReportsPath(avaliation.getAssignment(),
				avaliation.getStudent())
				+ File.separator + "ResultAvaliation.xml";

		XMLParser.generateXML(root, values, path);

	}

	private static void saveAvaliation(Evaluation avaliation) {
		avaliation.setSubmissionDate(new Date());
		avaliation.setScore(Math.round(totalScore * 100, 2));
		EvaluationDAO.update(avaliation);
	}

}
