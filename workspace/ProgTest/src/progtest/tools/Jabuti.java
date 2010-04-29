package progtest.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.axis2.Constants;

import progtest.util.FileUtil;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.AddTestCases;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.AddTestCasesResponse;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.CoverageCriterionDetails;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.CoverageDetails;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.CreateProject;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.CreateProjectResponse;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.Criterion;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.CriterionCoveredUncovered;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetAllCoveredAndUncoveredRequiredElements;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetAllCoveredAndUncoveredRequiredElementsResponse;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetAllRequiredElements;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetAllRequiredElementsResponse;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetCoverageByClasses;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetCoverageByClassesResponse;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetCoverageByCriteria;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetCoverageByCriteriaResponse;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetCoverageByMethods;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetCoverageByMethodsResponse;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetInstrumentedProject;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetInstrumentedProjectResponse;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetMetrics;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.GetMetricsResponse;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.MethodDetails;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.MetricResClass;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.OoMetric;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.RequiredElementsDetails;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.SelectClassesToInstrument;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.SelectClassesToInstrumentResponse;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.SendTraceFile;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.SendTraceFileResponse;

public class Jabuti {

	/**
	 * @param args
	 * @throws Exception
	 */

	public static void run(String program, String testCases, String testSuite,
			String reports) throws Exception {

		String projectName = "progtest";
		String user = "draylson";
		String endpoint = "http://localhost:9080/jabutiprojectSvn/services/JaBUTiService1_0";
		String tempDir = "/home/draylson/apache-tomcat-6.0.18/webapps/jabutitemporaries" + File.separator;

		File dir = new File(tempDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		FileUtil.clean(dir);

		File reports_dir = new File(reports);
		if (!reports_dir.exists()) {
			reports_dir.mkdirs();
		}

		JaBUTiService1_0Stub stub = new JaBUTiService1_0Stub(endpoint);
		stub._getServiceClient().getOptions().setProperty(
				Constants.Configuration.ENABLE_MTOM, Constants.VALUE_TRUE);
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(4000000);

		CreateProject input = new CreateProject();
		input.setProjectName(projectName);
		input.setIdUserName(user);

		File file = new File(program);
		FileDataSource fds = new FileDataSource(file);
		DataHandler datahandler = new DataHandler(fds);
		input.setProjectFile(datahandler);
		CreateProjectResponse output;
		String projectid = "";

		output = stub.createProject(input);
		projectid = output.get_return();
		System.out.println("project id: " + projectid);

		SelectClassesToInstrument in1 = new SelectClassesToInstrument();
		in1.setProjectId(projectid);
		String classes[] = new String[1];
		classes[0] = "*";
		in1.setClasses(classes);
		in1.setIdUserName(user);
		SelectClassesToInstrumentResponse out1 = stub
				.selectClassesToInstrument(in1);
		System.out.println("SelectClassesToInstrument operation");
		System.out.println("ret: " + out1.get_return());

		// Required Elements

		GetAllRequiredElements in2 = new GetAllRequiredElements();
		in2.setProjectId(projectid);
		in2.setIdUserName("user");
		GetAllRequiredElementsResponse out2 = stub.getAllRequiredElements(in2);

		RequiredElementsDetails details[] = out2.get_return();
		String required[][] = new String[details.length + 1][9];

		required[0][0] = "Method";
		Criterion c[] = details[0].getCriterion();
		for (int i = 0; i < c.length; i++)
			required[0][i + 1] = c[i].getName();
		for (int i = 0; i < details.length; i++) {
			required[i + 1][0] = details[i].getMethodName();
			c = details[i].getCriterion();
			for (int j = 0; j < c.length; j++) {
				required[i + 1][j + 1] = "";
				String elems[] = c[j].getElements();
				if (elems != null)
					for (int j2 = 0; j2 < elems.length; j2++) {
						required[i + 1][j + 1] += elems[j2] += ",";
					}
			}
		}

		for (int i = 0; i < required.length; i++)
			for (int j = 0; j < 9; j++) {
				if (required[i][j] != null) {
					required[i][j] = required[i][j].replace("<", "&lt;");
					required[i][j] = required[i][j].replace(">", "&gt;");
				}
			}

		generateHTMLPage("Required Elements", required, reports
				+ File.separator + "RequiredElements.html");

		generateXML("RequiredElements", required, reports + File.separator
				+ "RequiredElements.xml");

		// End

		String TestSuiteClass = testSuite;
		String TestFilePath = testCases;
		String TestDir = "/home/draylson/apache-tomcat-6.0.18/webapps/jabutitemporaries" + File.separator;

		AddTestCases in3 = new AddTestCases();
		in3.setProjectId(projectid);
		in3.setIdUserName(user);
		in3.setTestSuiteClass(TestSuiteClass);

		// attach the test file
		file = new File(TestFilePath);
		fds = new FileDataSource(file);
		datahandler = new DataHandler(fds);
		in3.setTestCaseFile(datahandler);

		AddTestCasesResponse out3 = stub.addTestCases(in3);
		System.out.println("addTestCases operation");
		System.out.println("ret: " + out3.get_return());

		// --------------------------------------------------------
		// getInstrumentedProject
		System.out.println("GetInstrumentedProject operation");
		GetInstrumentedProject in4 = new GetInstrumentedProject();
		in4.setProjectId(projectid);
		in4.setIdUserName(user);

		GetInstrumentedProjectResponse out4 = stub.getInstrumentedProject(in4);

		datahandler = out4.get_return().getFile();
		FileOutputStream fos = new FileOutputStream(new File(tempDir
				+ "package.jar"));
		datahandler.writeTo(fos);
		fos.flush();
		fos.close();
		
		File zipFile = new File(tempDir + "package.jar");
		
		File dst = new File(tempDir + "package");
		
		File src = new File(progtest.util.Constants.PATH_ROOT + File.separator + "jabuti");
		
		FileUtil.unzip(zipFile, dst);
		
		zipFile.delete();
		
		FileUtil.delete(new File(tempDir + "package" + File.separator + "br"));
		
		for(File f: src.listFiles())
			FileUtil.copy(f, dst);
		
		FileUtil.zip(dst.listFiles(), zipFile);

		String execString = "java -cp " + TestDir + "package.jar";
		execString += " br.jabuti.junitexec.JUnitJabutiCore -trace " + TestDir
				+ "test.trc -cp ";
		TestSuiteClass = TestSuiteClass.replace(".class", "");
		execString = execString + TestDir + "package.jar -tcClass "
				+ TestSuiteClass;
		System.out.println(execString);

		Runtime.getRuntime().exec(execString);

		Thread.sleep(10000);

		SendTraceFile in5 = new SendTraceFile();
		in5.setProjectId(projectid);
		in5.setIdUserName(user);

		// attach trace file
		fds = new FileDataSource(new File(tempDir + "test.trc"));
		datahandler = new DataHandler(fds);
		in5.setTracefile(datahandler);

		SendTraceFileResponse out5 = stub.sendTraceFile(in5);

		System.out.println("SendTraceFile operation");
		System.out.println("msg: " + out5.get_return());

		// Covered And Uncovered Required Elements

		GetAllCoveredAndUncoveredRequiredElements gcue = new GetAllCoveredAndUncoveredRequiredElements();
		gcue.setIdUserName(user);
		gcue.setProjectId(projectid);

		GetAllCoveredAndUncoveredRequiredElementsResponse gcuer = stub
				.getAllCoveredAndUncoveredRequiredElements(gcue);
		MethodDetails mdts[] = gcuer.get_return();

		String elements[][] = new String[mdts.length * 8 + 1][4];
		for (int i = 0; i < mdts.length * 8; i++)
			for (int j = 0; j < 4; j++)
				elements[i][j] = "";

		elements[0][0] = "Method";
		elements[0][1] = "Criterion";
		elements[0][2] = "CoveredElements";
		elements[0][3] = "UncoveredElements";

		int line = 1;

		for (int i = 0; i < mdts.length; i++) {

			elements[line + 0][0] = mdts[i].getMethodName();
			elements[line + 1][0] = mdts[i].getMethodName();
			elements[line + 2][0] = mdts[i].getMethodName();
			elements[line + 3][0] = mdts[i].getMethodName();
			elements[line + 4][0] = mdts[i].getMethodName();
			elements[line + 5][0] = mdts[i].getMethodName();
			elements[line + 6][0] = mdts[i].getMethodName();
			elements[line + 7][0] = mdts[i].getMethodName();

			elements[line + 0][1] = "All-Nodes-ei";
			elements[line + 1][1] = "All-Nodes-ed";
			elements[line + 2][1] = "All-Edges-ei";
			elements[line + 3][1] = "All-Edges-ed";
			elements[line + 4][1] = "All-Uses-ei";
			elements[line + 5][1] = "All-Uses-ed";
			elements[line + 6][1] = "All-Pot-Uses-ei";
			elements[line + 7][1] = "All-Pot-Uses-ed";

			CriterionCoveredUncovered ccucv[] = mdts[i].getCriteria();
			for (int j = 0; j < ccucv.length; j++) {
				String cve[] = ccucv[j].getCoveredElements();
				elements[line][2] = "";
				elements[line][3] = "";
				if (cve != null)
					for (int k = 0; k < cve.length; k++)
						elements[line][2] += cve[k] + " ";

				cve = ccucv[j].getUncoveredElements();
				if (cve != null)
					for (int k = 0; k < cve.length; k++)
						elements[line][3] += cve[k] + " ";
				line++;
			}

		}

		for (int i = 0; i < elements.length; i++)
			for (int j = 0; j < 4; j++) {
				elements[i][j] = elements[i][j].replace("<", "&lt;");
				elements[i][j] = elements[i][j].replace(">", "&gt;");
			}

		generateHTMLPage("Covered and Uncovered Elements", elements, reports
				+ File.separator + "CoveredAndUncovered.html");

		generateXML("CoveredAndUncovered", elements, reports + File.separator
				+ "CoveredAndUncovered.xml");

		// End

		// ClassCoverage

		GetCoverageByClasses gcbc = new GetCoverageByClasses();
		gcbc.setIdUserName(user);
		gcbc.setProjectId(projectid);

		GetCoverageByClassesResponse gcbcr = stub.getCoverageByClasses(gcbc);
		CoverageDetails coverageClasses[] = gcbcr.get_return();
		String cvrClasses[][] = new String[coverageClasses.length + 1][9];

		for (int i = 0; i < cvrClasses.length; i++)
			for (int j = 0; j < 9; j++)
				cvrClasses[i][j] = "";

		cvrClasses[0][0] = "Class";
		cvrClasses[0][1] = "All-Nodes-ei";
		cvrClasses[0][2] = "All-Nodes-ed";
		cvrClasses[0][3] = "All-Edges-ei";
		cvrClasses[0][4] = "All-Edges-ed";
		cvrClasses[0][5] = "All-Uses-ei";
		cvrClasses[0][6] = "All-Uses-ed";
		cvrClasses[0][7] = "All-Pot-Uses-ei";
		cvrClasses[0][8] = "All-Pot-Uses-ed";

		for (int i = 0; i < coverageClasses.length; i++) {
			cvrClasses[i + 1][0] = coverageClasses[i].getName();
			CoverageCriterionDetails criterion[] = coverageClasses[i]
					.getCriteria();
			for (int j = 0; j < criterion.length; j++) {
				cvrClasses[i + 1][j + 1] = String.valueOf(criterion[j]
						.getNumberOfCoveredElements())
						+ " of "
						+ String.valueOf(criterion[j].getNumberOfElements())
						+ "("
						+ String.valueOf(criterion[j].getCoveragePercentage())
						+ ")";
			}
		}
		for (int i = 0; i < cvrClasses.length; i++)
			for (int j = 0; j < 9; j++) {
				cvrClasses[i][j] = cvrClasses[i][j].replace("<", "&lt;");
				cvrClasses[i][j] = cvrClasses[i][j].replace(">", "&gt;");
			}

		generateHTMLPage("ClassCoverage", cvrClasses, reports + File.separator
				+ "ClassCoverage.html");

		generateXML("ClassCoverage", cvrClasses, reports + File.separator
				+ "ClassCoverage.xml");

		// End

		// CriterionCoverage

		GetCoverageByCriteria in6 = new GetCoverageByCriteria();
		in6.setProjectId(projectid);
		in6.setIdUserName(user);
		GetCoverageByCriteriaResponse out6 = stub.getCoverageByCriteria(in6);

		System.out.println("GetCoverageByCriteria operation");
		CoverageCriterionDetails criterion[] = out6.get_return();

		String coverageCriteria[][] = new String[criterion.length + 1][4];

		for (int i = 0; i < coverageCriteria.length; i++)
			for (int j = 0; j < 4; j++)
				coverageCriteria[i][j] = "";

		coverageCriteria[0][0] = "Criterion";
		coverageCriteria[0][1] = "NumberOfElements";
		coverageCriteria[0][2] = "NumberOfCoveredElements";
		coverageCriteria[0][3] = "Percentage";

		for (int i = 0; i < criterion.length; i++) {
			coverageCriteria[i + 1][0] = criterion[i].getCriterionName();
			coverageCriteria[i + 1][1] = String.valueOf(criterion[i]
					.getNumberOfElements());
			coverageCriteria[i + 1][2] = String.valueOf(criterion[i]
					.getNumberOfCoveredElements());
			coverageCriteria[i + 1][3] = String.valueOf(criterion[i]
					.getCoveragePercentage());
		}

		for (int i = 0; i < coverageCriteria.length; i++)
			for (int j = 0; j < 4; j++) {
				coverageCriteria[i][j] = coverageCriteria[i][j].replace("<",
						"&lt;");
				coverageCriteria[i][j] = coverageCriteria[i][j].replace(">",
						"&gt;");
			}

		generateHTMLPage("CriterionCoverage", coverageCriteria, reports
				+ File.separator + "CriterionCoverage.html");

		generateXML("CriterionCoverage", coverageCriteria, reports
				+ File.separator + "CriterionCoverage.xml");

		// End

		// MethodCoverage

		GetCoverageByMethods gcbm = new GetCoverageByMethods();
		gcbm.setIdUserName(user);
		gcbm.setProjectId(projectid);

		GetCoverageByMethodsResponse gcbmr = stub.getCoverageByMethods(gcbm);
		CoverageDetails coverageMethods[] = gcbmr.get_return();

		String cvrMethods[][] = new String[coverageMethods.length + 1][9];
		for (int i = 0; i < cvrMethods.length; i++)
			for (int j = 0; j < 9; j++)
				cvrMethods[i][j] = "";
		cvrMethods[0][0] = "Method";
		cvrMethods[0][1] = "All-Nodes-ei";
		cvrMethods[0][2] = "All-Nodes-ed";
		cvrMethods[0][3] = "All-Edges-ei";
		cvrMethods[0][4] = "All-Edges-ed";
		cvrMethods[0][5] = "All-Uses-ei";
		cvrMethods[0][6] = "All-Uses-ed";
		cvrMethods[0][7] = "All-Pot-Uses-ei";
		cvrMethods[0][8] = "All-Pot-Uses-ed";

		for (int i = 0; i < coverageMethods.length; i++) {
			cvrMethods[i + 1][0] = coverageMethods[i].getName();
			CoverageCriterionDetails criterion2[] = coverageMethods[i]
					.getCriteria();
			for (int j = 0; j < criterion2.length; j++) {
				cvrMethods[i + 1][j + 1] = String.valueOf(criterion2[j]
						.getNumberOfCoveredElements())
						+ " of "
						+ String.valueOf(criterion2[j].getNumberOfElements())
						+ "("
						+ String.valueOf(criterion2[j].getCoveragePercentage())
						+ ")";
			}
		}

		for (int i = 0; i < cvrMethods.length; i++)
			for (int j = 0; j < 9; j++) {
				cvrMethods[i][j] = cvrMethods[i][j].replace("<", "&lt;");
				cvrMethods[i][j] = cvrMethods[i][j].replace(">", "&gt;");
			}

		generateHTMLPage("MethodCoverage", cvrMethods, reports + File.separator
				+ "MethodCoverage.html");

		generateXML("MethodCoverage", cvrMethods, reports + File.separator
				+ "MethodCoverage.xml");

		// End

		// Metrics

		/*GetMetrics gm = new GetMetrics();
		String cl[] = new String[1];
		cl[0] = "*";
		gm.setClasses(cl);
		gm.setIdUserName(user);
		gm.setProjectId(projectid);

		GetMetricsResponse gmr = stub.getMetrics(gm);
		MetricResClass mrc[] = gmr.get_return();

		int qtdeMetricas = mrc[0].getMetrics().length;
		elements = new String[mrc.length + 1][qtdeMetricas + 1];
		for (int i = 0; i < mrc.length + 1; i++)
			for (int j = 0; j < qtdeMetricas + 1; j++)
				elements[i][j] = "";

		elements[0][0] = "Classes";
		for (int i = 0; i < qtdeMetricas; i++)
			elements[0][i + 1] = mrc[0].getMetrics()[i].getName();

		for (int i = 0; i < mrc.length; i++) {
			elements[i + 1][0] = mrc[i].getName();
			OoMetric om[] = mrc[i].getMetrics();
			for (int j = 0; j < om.length; j++) {
				elements[i + 1][j + 1] = String.valueOf(om[j].getValue());
			}
		}

		generateHTMLPage("Metrics", elements, reports + File.separator
				+ "Metrics.html");

		generateXML("Metrics", elements, reports + File.separator
				+ "Metrics.xml");*/

		// End

	}

	public static void generateHTMLPage(String title, String data[][],
			String name) throws FileNotFoundException {

		/*
		 * File f = new File(name);
		 * 
		 * if(!f.getParentFile().exists()) f.getParentFile().mkdirs();
		 * 
		 * PrintWriter fileHTML = new PrintWriter(new FileOutputStream(name));
		 * // saida.println(); fileHTML.println("<html>");
		 * fileHTML.println("<title> " + title + "</title>");
		 * fileHTML.println("<body>");
		 * 
		 * fileHTML.println("<table border=\"1\">");
		 * 
		 * for (int i = 0; i < data.length; i++) { fileHTML.println("<tr>"); for
		 * (int j = 0; j < data[0].length; j++) { fileHTML.println("<td>" +
		 * data[i][j] + "</td>"); } fileHTML.println("</tr>"); }
		 * fileHTML.println("</table>"); fileHTML.println("</body>");
		 * fileHTML.println("</html>"); fileHTML.close();
		 */
	}

	public static void generateXML(String root, String data[][], String name)
			throws FileNotFoundException {
		int j;
		PrintWriter fileXML = new PrintWriter(new FileOutputStream(name));
		// saida.println();
		fileXML.println("<?xml version='1.0'?>");
		fileXML.println("<" + root + ">");

		for (int i = 1; i < data.length; i++) {

			for (j = 0; j < data[0].length; j++) {
				if (j == 0)
					fileXML.println("   <" + data[0][j] + " name=\""
							+ data[i][j] + "\">");
				else
					fileXML.println("      <" + data[0][j] + " value=\""
							+ data[i][j] + "\"/>");
			}
			fileXML.println("   </" + data[0][0] + ">");
		}
		fileXML.println("</" + root + ">");
		fileXML.close();
	}
}
