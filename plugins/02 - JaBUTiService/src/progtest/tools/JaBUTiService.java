package progtest.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import progtest.compilers.Javac;
import br.icmc.usp.jabuti.service.ClassNotFoundFaultException3;
import br.icmc.usp.jabuti.service.InvalidExpressionFaultException4;
import br.icmc.usp.jabuti.service.InvalidFileFaultException2;
import br.icmc.usp.jabuti.service.InvalidNameFaultException5;
import br.icmc.usp.jabuti.service.InvalidProjectIdFaultException0;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.AddTestCases;
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
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.MethodDetails;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.RequiredElementsDetails;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.SelectClassesToInstrument;
import br.icmc.usp.jabuti.service.JaBUTiService1_0Stub.SendTraceFile;
import br.icmc.usp.jabuti.service.OperationSequenceFaultException1;

public class JaBUTiService {
	
	private static final String XML_FILE = JaBUTiService.class.getProtectionDomain()
	.getCodeSource().getLocation().getPath()
	+ File.separator + "progtest-addon.xml";

	private static String PROJECT_NAME = "ProgTest Project";

	private static String USER = "ProgTest";

	private static final String PROGRAM_FILE_NAME = "program.jar";

	private static final String TESTS_FILE_NAME = "tests.jar";

	private static final String INSTRUMENTED_FILE_NAME = "instrumented_program.jar";

	private static final String TRACE_FILE_NAME = "trace.trc";

	private static final String TEST_SUITE_SOURCE_FILE_NAME = "testSuite.java";

	private static final String TEST_SUITE_CLASS_FILE_NAME = "testSuite.class";

	public static void main(String args[]) {

		if (args.length < 7) {

			System.out
					.println("Usage: progtest.tools.JabutiService <end point> <patch jar> <source directory> <binaries directory> <program directory> <tests directory> <instrumented files directory> <temporaries directory> <reports directory>");

		} else {

			String endPoint = args[0];

			File patchPackage = new File(args[1]);

			File srcDir = new File(args[2]);
			File binDir = new File(args[3]);
			File progDir = new File(args[4]);
			File testDir = new File(args[5]);
			File instDir = new File(args[6]);
			File tmpDir = new File(args[7]);
			File rptDir = new File(args[8]);

			if (!srcDir.exists()) {

				System.err.println("Directory not found: " + srcDir.getPath());

			} else if (!binDir.exists()) {

				System.err.println("Directory not found: " + binDir.getPath());

			} else if (!progDir.exists()) {

				System.err.println("Directory not found: " + progDir.getPath());

			} else if (!testDir.exists()) {

				System.err.println("Directory not found: " + testDir.getPath());

			} else if (!instDir.exists()) {

				System.err.println("Directory not found: " + instDir.getPath());

			} else if (!tmpDir.exists()) {

				System.err.println("Directory not found: " + tmpDir.getPath());

			} else if (!rptDir.exists()) {

				System.err.println("Directory not found: " + rptDir.getPath());

			} else if (!srcDir.isDirectory()) {

				System.err.println("It's not a directory: " + srcDir.getPath());

			} else if (!binDir.isDirectory()) {

				System.err.println("It's not a directory: " + binDir.getPath());

			} else if (!progDir.isDirectory()) {

				System.err
						.println("It's not a directory: " + progDir.getPath());

			} else if (!testDir.isDirectory()) {

				System.err
						.println("It's not a directory: " + testDir.getPath());

			} else if (!instDir.isDirectory()) {

				System.err
						.println("It's not a directory: " + instDir.getPath());

			} else if (!tmpDir.isDirectory()) {

				System.err.println("It's not a directory: " + tmpDir.getPath());

			} else if (!rptDir.isDirectory()) {

				System.err.println("It's not a directory: " + rptDir.getPath());

			} else {

				try {

					File program = new File(tmpDir.getPath() + File.separator
							+ PROGRAM_FILE_NAME);
					File testClasses = new File(tmpDir.getPath()
							+ File.separator + TESTS_FILE_NAME);
					File testSuiteSourceFile = new File(srcDir.getPath()
							+ File.separator + TEST_SUITE_SOURCE_FILE_NAME);
					File testSuiteClassFile = new File(binDir.getPath()
							+ File.separator + TEST_SUITE_CLASS_FILE_NAME);
					File instrumentedFile = new File(instDir.getPath()
							+ File.separator + INSTRUMENTED_FILE_NAME);
					File traceFile = new File(instDir.getPath()
							+ File.separator + TRACE_FILE_NAME);

					Javac.execute(srcDir, binDir);

					split(binDir, progDir, testDir);

					generateTestSuite(testDir, testSuiteSourceFile);

					Javac.execute(srcDir, binDir);

					copy(testSuiteClassFile, testDir);

					zip(progDir.listFiles(), program);

					zip(testDir.listFiles(), testClasses);

					execute(endPoint, patchPackage, program, testClasses,
							TEST_SUITE_CLASS_FILE_NAME, instrumentedFile,
							traceFile, rptDir);

				} catch (Throwable t) {

					t.printStackTrace();

				}

			}

		}

	}

	private static void split(File sourceDir, File programDir, File testsDir)
			throws IOException {

		File[] localFiles = sourceDir.listFiles();

		for (File file : localFiles) {

			if (file.isDirectory()) {

				File newProgramDir = new File(sourceDir + File.separator
						+ file.getName());
				File newTestsDir = new File(sourceDir + File.separator
						+ file.getName());

				if (!newProgramDir.exists())
					newProgramDir.mkdirs();

				if (!newTestsDir.exists())
					newTestsDir.mkdirs();

				split(file, newProgramDir, newTestsDir);

			} else {

				if (isTestClass(file)) {
					copy(file, testsDir);
				} else {
					copy(file, programDir);
				}

			}

		}

	}

	private static boolean isTestClass(File file) {

		try {

			URL urls[] = new URL[1];

			urls[0] = new URL("file://"
					+ file.getParentFile().getPath().replace("\\", "/") + "/");

			URLClassLoader loader = new URLClassLoader(urls);

			Class<?> clazz = loader.loadClass(file.getName().replace(".class",
					""));

			for (Method method : clazz.getDeclaredMethods())
				for (Annotation annotation : method.getAnnotations())
					if (annotation.annotationType().equals(Test.class))
						return true;

		} catch (MalformedURLException e) {

			System.err.println("Warnning: Invalid URL: " + "file://"
					+ file.getParentFile().getPath().replace("\\", "/") + "/");

		} catch (ClassNotFoundException e) {

			System.err.println("Class not found: " + file.getName());

		}

		return false;

	}

	private static void generateTestSuite(File testsDir, File testSuiteFile)
			throws IOException {

		if (!testSuiteFile.getName().endsWith(".java"))
			throw new IllegalArgumentException();

		String text = "import org.junit.runner.RunWith;"
				+ "\nimport org.junit.runners.Suite;"
				+ "\nimport org.junit.runners.Suite.SuiteClasses;" + "\n"
				+ "\n@RunWith(value=Suite.class)" + "\n@SuiteClasses(value={";

		for (File file : listFiles(testsDir, ".class"))
			if (isTestClass(file)) {

				try {

					URL urls[] = new URL[1];

					urls[0] = new URL("file://"
							+ file.getParentFile().getPath().replace("\\", "/")
							+ "/");

					URLClassLoader loader = new URLClassLoader(urls);

					Class<?> clazz = loader.loadClass(file.getName().replace(
							".class", ""));

					text += "\n\t" + clazz.getName() + ".class" + ",";

				} catch (MalformedURLException e) {

					System.err.println("Warnning: Invalid URL: " + "file://"
							+ file.getParentFile().getPath().replace("\\", "/")
							+ "/");

				} catch (ClassNotFoundException e) {

					System.err.println("Class not found: " + file.getName());

				}
			}

		text = text.substring(0, text.lastIndexOf(",")) + "\n})"
				+ "\npublic class "
				+ testSuiteFile.getName().replace(".java", "") + " {" + "\n}";

		FileWriter fw = new FileWriter(testSuiteFile);
		fw.write(text);
		fw.close();

	}

	private static void execute(String endPoint, File patchPackage,
			File program, File testClasses, String testSuiteFileName,
			File instrumentedFile, File traceFile, File reportsDir)
			throws InvalidNameFaultException5, InvalidFileFaultException2,
			InvalidExpressionFaultException4, ClassNotFoundFaultException3,
			InvalidProjectIdFaultException0, OperationSequenceFaultException1,
			IOException, InterruptedException {

		JaBUTiService1_0Stub stub = connect(endPoint);

		String projectId = createProject(stub, PROJECT_NAME, USER, program);

		selectClassesToInstrument(stub, projectId, USER);

		addTestCases(stub, projectId, USER, testClasses, testSuiteFileName);

		getInstrumentedFile(stub, projectId, USER, instrumentedFile);

		applyPatch(instrumentedFile, patchPackage);

		executeInstrumentedFile(instrumentedFile, traceFile, testSuiteFileName);

		sendTraceFile(stub, projectId, USER, traceFile);

		getRequiredElements(stub, projectId, USER,
				new File(reportsDir.getPath() + File.separator
						+ "Required Elements.xml"));

		getCoverageByClass(stub, projectId, USER, new File(reportsDir.getPath()
				+ File.separator + "Coverage By Class.xml"));

		getCoverageByMethod(stub, projectId, USER,
				new File(reportsDir.getPath() + File.separator
						+ "Coverage By Method.xml"));

		getCoverageByCriterion(stub, projectId, USER,
				new File(reportsDir.getPath() + File.separator
						+ "Coverage By Criterion.xml"));

		getCoveredAndUncoveredElements(stub, projectId, USER, new File(
				reportsDir.getPath() + File.separator
						+ "Covered and Uncovered Elements.xml"));

		saveOutput(stub, projectId, USER, reportsDir);

	}

	private static JaBUTiService1_0Stub connect(String endPoint)
			throws AxisFault {

		JaBUTiService1_0Stub stub = new JaBUTiService1_0Stub(endPoint);
		stub._getServiceClient()
				.getOptions()
				.setProperty(Constants.Configuration.ENABLE_MTOM,
						Constants.VALUE_TRUE);
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(4000000);

		return stub;

	}

	private static String createProject(JaBUTiService1_0Stub stub,
			String projectName, String user, File program)
			throws RemoteException, InvalidNameFaultException5,
			InvalidFileFaultException2 {

		CreateProject input = new CreateProject();
		input.setProjectName(projectName);
		input.setIdUserName(user);

		FileDataSource fds = new FileDataSource(program);
		DataHandler dh = new DataHandler(fds);
		input.setProjectFile(dh);

		CreateProjectResponse output = stub.createProject(input);

		return output.get_return();

	}

	private static void selectClassesToInstrument(JaBUTiService1_0Stub stub,
			String projectId, String user) throws RemoteException,
			InvalidExpressionFaultException4, ClassNotFoundFaultException3,
			InvalidProjectIdFaultException0 {

		SelectClassesToInstrument input = new SelectClassesToInstrument();
		input.setProjectId(projectId);
		input.setIdUserName(user);

		String classes[] = { "*" };
		input.setClasses(classes);

		stub.selectClassesToInstrument(input);

	}

	private static void addTestCases(JaBUTiService1_0Stub stub,
			String projectId, String user, File testClasses,
			String testSuiteFileName) throws RemoteException,
			InvalidFileFaultException2, ClassNotFoundFaultException3,
			InvalidProjectIdFaultException0, OperationSequenceFaultException1 {

		AddTestCases input = new AddTestCases();
		input.setProjectId(projectId);
		input.setIdUserName(user);
		input.setTestSuiteClass(testSuiteFileName);

		FileDataSource fds = new FileDataSource(testClasses);
		DataHandler dh = new DataHandler(fds);
		input.setTestCaseFile(dh);

		stub.addTestCases(input);

	}

	private static void getInstrumentedFile(JaBUTiService1_0Stub stub,
			String projectId, String user, File instrumentedFile)
			throws IOException, InvalidProjectIdFaultException0,
			OperationSequenceFaultException1 {

		GetInstrumentedProject input = new GetInstrumentedProject();
		input.setProjectId(projectId);
		input.setIdUserName(user);

		GetInstrumentedProjectResponse output = stub
				.getInstrumentedProject(input);

		if (instrumentedFile.exists())
			delete(instrumentedFile);

		DataHandler dh = output.get_return().getFile();
		FileOutputStream fos = new FileOutputStream(instrumentedFile);
		dh.writeTo(fos);
		fos.flush();
		fos.close();

	}

	private static void applyPatch(File instrumentedFile, File patchPackage)
			throws IOException {

		File tmpDir = new File(instrumentedFile.getParentFile().getPath()
				+ File.separator + "tmp");

		unzip(instrumentedFile, tmpDir);

		delete(new File(tmpDir.getPath() + File.separator + "br"));

		unzip(patchPackage, tmpDir);

		delete(instrumentedFile);
		zip(tmpDir.listFiles(), instrumentedFile);

		delete(tmpDir);

	}

	private static void executeInstrumentedFile(File instrumentedFile,
			File traceFile, String testSuiteClassName) throws IOException,
			InterruptedException {

		String[] args = { "java", "-cp", instrumentedFile.getPath(),
				"br.jabuti.junitexec.JUnitJabutiCore", "-trace", traceFile.getPath(),
				"-cp", instrumentedFile.getPath(), "-tcClass",
				testSuiteClassName.replace(".class", "") };

		Process p = Runtime.getRuntime().exec(args);

		InputStream st = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(st);
		BufferedReader br = new BufferedReader(isr);
		while (br.ready())
			System.out.println(br.readLine());

		st = p.getErrorStream();
		isr = new InputStreamReader(st);
		br = new BufferedReader(isr);
		while (br.ready())
			System.err.println(br.readLine());

		p.waitFor();

	}

	private static void sendTraceFile(JaBUTiService1_0Stub stub,
			String projectId, String user, File traceFile)
			throws RemoteException, InvalidFileFaultException2,
			InvalidProjectIdFaultException0, OperationSequenceFaultException1 {

		SendTraceFile input = new SendTraceFile();
		input.setProjectId(projectId);
		input.setIdUserName(user);

		FileDataSource fds = new FileDataSource(traceFile);
		DataHandler dh = new DataHandler(fds);
		input.setTracefile(dh);

		stub.sendTraceFile(input);

	}

	private static void getRequiredElements(JaBUTiService1_0Stub stub,
			String projectId, String user, File reportFile)
			throws FileNotFoundException, SecurityException, RemoteException,
			InvalidProjectIdFaultException0, OperationSequenceFaultException1 {

		GetAllRequiredElements input = new GetAllRequiredElements();
		input.setProjectId(projectId);
		input.setIdUserName(user);

		GetAllRequiredElementsResponse output = stub
				.getAllRequiredElements(input);

		RequiredElementsDetails details[] = output.get_return();
		String data[][] = new String[details.length + 1][9];

		data[0][0] = "Method";

		Criterion c[] = details[0].getCriterion();

		for (int i = 0; i < c.length; i++)
			data[0][i + 1] = c[i].getName();

		for (int i = 0; i < details.length; i++) {
			data[i + 1][0] = details[i].getMethodName();
			c = details[i].getCriterion();
			for (int j = 0; j < c.length; j++) {
				data[i + 1][j + 1] = "";
				String elems[] = c[j].getElements();
				if (elems != null)
					for (int j2 = 0; j2 < elems.length; j2++) {
						data[i + 1][j + 1] += elems[j2] += ",";
					}
			}
		}

		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < 9; j++) {
				if (data[i][j] != null) {
					data[i][j] = data[i][j].replace("<", "&lt;");
					data[i][j] = data[i][j].replace(">", "&gt;");
				}
			}

		generateXML(reportFile, data);

	}

	private static void getCoverageByClass(JaBUTiService1_0Stub stub,
			String projectId, String user, File reportFile)
			throws FileNotFoundException, SecurityException, RemoteException,
			InvalidProjectIdFaultException0, OperationSequenceFaultException1 {

		GetCoverageByClasses input = new GetCoverageByClasses();
		input.setIdUserName(user);
		input.setProjectId(projectId);

		GetCoverageByClassesResponse output = stub.getCoverageByClasses(input);
		CoverageDetails coverageClasses[] = output.get_return();
		String data[][] = new String[coverageClasses.length + 1][9];

		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < 9; j++)
				data[i][j] = "";

		data[0][0] = "Class";
		data[0][1] = "All-Nodes-ei";
		data[0][2] = "All-Nodes-ed";
		data[0][3] = "All-Edges-ei";
		data[0][4] = "All-Edges-ed";
		data[0][5] = "All-Uses-ei";
		data[0][6] = "All-Uses-ed";
		data[0][7] = "All-Pot-Uses-ei";
		data[0][8] = "All-Pot-Uses-ed";

		for (int i = 0; i < coverageClasses.length; i++) {
			data[i + 1][0] = coverageClasses[i].getName();
			CoverageCriterionDetails criterion[] = coverageClasses[i]
					.getCriteria();
			for (int j = 0; j < criterion.length; j++) {
				data[i + 1][j + 1] = String.valueOf(criterion[j]
						.getNumberOfCoveredElements())
						+ " of "
						+ String.valueOf(criterion[j].getNumberOfElements())
						+ "("
						+ String.valueOf(criterion[j].getCoveragePercentage())
						+ ")";
			}
		}

		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < 9; j++) {
				data[i][j] = data[i][j].replace("<", "&lt;");
				data[i][j] = data[i][j].replace(">", "&gt;");
			}

		generateXML(reportFile, data);

	}

	private static void getCoverageByMethod(JaBUTiService1_0Stub stub,
			String projectId, String user, File reportFile)
			throws FileNotFoundException, SecurityException, RemoteException,
			InvalidProjectIdFaultException0, OperationSequenceFaultException1 {

		GetCoverageByMethods input = new GetCoverageByMethods();
		input.setIdUserName(user);
		input.setProjectId(projectId);

		GetCoverageByMethodsResponse output = stub.getCoverageByMethods(input);
		CoverageDetails coverageMethods[] = output.get_return();

		String data[][] = new String[coverageMethods.length + 1][9];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < 9; j++)
				data[i][j] = "";

		data[0][0] = "Method";
		data[0][1] = "All-Nodes-ei";
		data[0][2] = "All-Nodes-ed";
		data[0][3] = "All-Edges-ei";
		data[0][4] = "All-Edges-ed";
		data[0][5] = "All-Uses-ei";
		data[0][6] = "All-Uses-ed";
		data[0][7] = "All-Pot-Uses-ei";
		data[0][8] = "All-Pot-Uses-ed";

		for (int i = 0; i < coverageMethods.length; i++) {
			data[i + 1][0] = coverageMethods[i].getName();
			CoverageCriterionDetails criterion2[] = coverageMethods[i]
					.getCriteria();
			for (int j = 0; j < criterion2.length; j++) {
				data[i + 1][j + 1] = String.valueOf(criterion2[j]
						.getNumberOfCoveredElements())
						+ " of "
						+ String.valueOf(criterion2[j].getNumberOfElements())
						+ "("
						+ String.valueOf(criterion2[j].getCoveragePercentage())
						+ ")";
			}
		}

		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < 9; j++) {
				data[i][j] = data[i][j].replace("<", "&lt;");
				data[i][j] = data[i][j].replace(">", "&gt;");
			}

		generateXML(reportFile, data);

	}

	private static void getCoverageByCriterion(JaBUTiService1_0Stub stub,
			String projectId, String user, File reportFile)
			throws FileNotFoundException, SecurityException, RemoteException,
			InvalidProjectIdFaultException0, OperationSequenceFaultException1 {

		GetCoverageByCriteria input = new GetCoverageByCriteria();
		input.setProjectId(projectId);
		input.setIdUserName(user);
		GetCoverageByCriteriaResponse output = stub
				.getCoverageByCriteria(input);

		CoverageCriterionDetails criterion[] = output.get_return();

		String data[][] = new String[criterion.length + 1][4];

		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < 4; j++)
				data[i][j] = "";

		data[0][0] = "Criterion";
		data[0][1] = "Number Of Elements";
		data[0][2] = "Number Of Covered Elements";
		data[0][3] = "Percentage";

		for (int i = 0; i < criterion.length; i++) {
			data[i + 1][0] = criterion[i].getCriterionName();
			data[i + 1][1] = String.valueOf(criterion[i].getNumberOfElements());
			data[i + 1][2] = String.valueOf(criterion[i]
					.getNumberOfCoveredElements());
			data[i + 1][3] = String.valueOf(criterion[i]
					.getCoveragePercentage());
		}

		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < 4; j++) {
				data[i][j] = data[i][j].replace("<", "&lt;");
				data[i][j] = data[i][j].replace(">", "&gt;");
			}

		generateXML(reportFile, data);

	}

	private static void getCoveredAndUncoveredElements(
			JaBUTiService1_0Stub stub, String projectId, String user,
			File reportFile) throws RemoteException,
			InvalidProjectIdFaultException0, OperationSequenceFaultException1,
			FileNotFoundException, SecurityException {

		GetAllCoveredAndUncoveredRequiredElements input = new GetAllCoveredAndUncoveredRequiredElements();
		input.setIdUserName(user);
		input.setProjectId(projectId);

		GetAllCoveredAndUncoveredRequiredElementsResponse output = stub
				.getAllCoveredAndUncoveredRequiredElements(input);

		MethodDetails mdts[] = output.get_return();

		String data[][] = new String[mdts.length * 8 + 1][4];
		for (int i = 0; i < mdts.length * 8; i++)
			for (int j = 0; j < 4; j++)
				data[i][j] = "";

		data[0][0] = "Method";
		data[0][1] = "Criterion";
		data[0][2] = "Covered Elements";
		data[0][3] = "Uncovered Elements";

		int line = 1;

		for (int i = 0; i < mdts.length; i++) {

			data[line + 0][0] = mdts[i].getMethodName();
			data[line + 1][0] = mdts[i].getMethodName();
			data[line + 2][0] = mdts[i].getMethodName();
			data[line + 3][0] = mdts[i].getMethodName();
			data[line + 4][0] = mdts[i].getMethodName();
			data[line + 5][0] = mdts[i].getMethodName();
			data[line + 6][0] = mdts[i].getMethodName();
			data[line + 7][0] = mdts[i].getMethodName();

			data[line + 0][1] = "All-Nodes-ei";
			data[line + 1][1] = "All-Nodes-ed";
			data[line + 2][1] = "All-Edges-ei";
			data[line + 3][1] = "All-Edges-ed";
			data[line + 4][1] = "All-Uses-ei";
			data[line + 5][1] = "All-Uses-ed";
			data[line + 6][1] = "All-Pot-Uses-ei";
			data[line + 7][1] = "All-Pot-Uses-ed";

			CriterionCoveredUncovered ccucv[] = mdts[i].getCriteria();
			for (int j = 0; j < ccucv.length; j++) {
				String cve[] = ccucv[j].getCoveredElements();
				data[line][2] = "";
				data[line][3] = "";
				if (cve != null)
					for (int k = 0; k < cve.length; k++)
						data[line][2] += cve[k] + " ";

				cve = ccucv[j].getUncoveredElements();
				if (cve != null)
					for (int k = 0; k < cve.length; k++)
						data[line][3] += cve[k] + " ";
				line++;
			}

		}

		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < 4; j++) {
				data[i][j] = data[i][j].replace("<", "&lt;");
				data[i][j] = data[i][j].replace(">", "&gt;");
			}

		generateXML(reportFile, data);

	}

	private static void saveOutput(JaBUTiService1_0Stub stub, String projectId,
			String user, File reportsDir) throws SecurityException,
			InvalidProjectIdFaultException0, OperationSequenceFaultException1,
			IOException {
		
		File outputFile = new File(reportsDir.getPath() + File.separator + getOutFile());

		GetCoverageByCriteria input = new GetCoverageByCriteria();
		input.setProjectId(projectId);
		input.setIdUserName(user);
		GetCoverageByCriteriaResponse output = stub
				.getCoverageByCriteria(input);

		CoverageCriterionDetails criterion[] = output.get_return();

		for (int i = 0; i < criterion.length; i++) {

			if (criterion[i].getNumberOfElements() == 0) {

				FileWriter fw = new FileWriter(outputFile, true);
				fw.write(getCriterionKey(i) + " = " + "1.0\n");
				fw.close();

			} else {

				FileWriter fw = new FileWriter(outputFile, true);
				fw.write(getCriterionKey(i) + " = " + String.valueOf(criterion[i].getCoveragePercentage()
						/ (float) 100)
						+ "\n");
				fw.close();

			}

		}

	}

	private static List<File> listFiles(File dir, String extensionFilter) {
		List<File> files = new ArrayList<File>();
		File[] localFiles = dir.listFiles();
		for (File file : localFiles) {
			if (file.isDirectory()) {
				files.addAll(listFiles(file, extensionFilter));
			} else if (file.getName().endsWith(extensionFilter)) {
				files.add(file);
			}
		}
		return files;
	}

	private static File copy(File src, File dst) throws IOException {

		if (!dst.exists())
			dst.mkdirs();

		if (src.isDirectory()) {

			String[] children = src.list();

			for (int i = 0; i < children.length; i++)
				copy(new File(src, children[i]), new File(dst, src.getName()));

		} else {

			copyContent(src, new File(dst + File.separator + src.getName()));

		}

		return new File(dst + File.separator + src.getName());

	}

	private static void copyContent(File src, File dst) throws IOException {

		if (src.isDirectory()) {

			if (!dst.exists())
				dst.mkdirs();

			String[] children = src.list();

			for (int i = 0; i < children.length; i++)
				copy(new File(src, children[i]), dst);

		} else {

			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			in.close();
			out.close();

		}

	}

	private static void clean(File f) {
		if (f.isDirectory()) {
			File[] children = f.listFiles();
			for (int i = 0; i < children.length; i++)
				delete(children[i]);
		}
	}

	private static void delete(File f) {
		clean(f);
		f.delete();
	}

	private static void zip(File[] inputFiles, File outputFile)
			throws IOException {
		if (inputFiles != null && inputFiles.length > 0) {
			if (!outputFile.getParentFile().exists())
				outputFile.getParentFile().mkdirs();
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
					outputFile));
			Stack<File> parentDirs = new Stack<File>();
			zipFiles(parentDirs, inputFiles, out);
			out.close();
		}
	}

	private static void zipFiles(Stack<File> parentDirs, File[] inputFiles,
			ZipOutputStream out) throws IOException {

		byte[] buf = new byte[1024];

		for (int i = 0; i < inputFiles.length; i++) {

			if (inputFiles[i].isDirectory()) {

				parentDirs.push(inputFiles[i]);
				zipFiles(parentDirs, inputFiles[i].listFiles(), out);
				parentDirs.pop();

			} else {

				FileInputStream in = new FileInputStream(inputFiles[i]);

				String path = "";
				for (File parentDir : parentDirs) {
					path += parentDir.getName() + "/";
				}

				out.putNextEntry(new ZipEntry(path + inputFiles[i].getName()));

				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}

				out.closeEntry();
				in.close();

			}
		}
	}

	private static void unzip(File zipFile, File dst) throws IOException {

		ZipFile zip = null;
		File arquivo = null;
		InputStream is = null;
		OutputStream os = null;
		byte[] buffer = new byte[1024];

		try {

			if (!dst.exists())
				dst.mkdirs();

			if (!dst.isDirectory())
				throw new IOException();

			zip = new ZipFile(zipFile);

			Enumeration<?> e = zip.entries();
			while (e.hasMoreElements()) {

				ZipEntry entrada = (ZipEntry) e.nextElement();
				arquivo = new File(dst, entrada.getName());

				if (arquivo.exists())
					continue;

				if (entrada.isDirectory() && !arquivo.exists()) {
					arquivo.mkdirs();
					continue;
				}

				if (!arquivo.getParentFile().exists())
					arquivo.getParentFile().mkdirs();

				try {

					is = zip.getInputStream(entrada);
					os = new FileOutputStream(arquivo);

					int bytesLidos = 0;

					if (is == null)
						throw new ZipException();

					while ((bytesLidos = is.read(buffer)) > 0)
						os.write(buffer, 0, bytesLidos);

				} finally {

					if (is != null)
						is.close();

					if (os != null)
						os.close();

				}

			}

		} finally {

			if (zip != null)
				zip.close();

		}

	}

	private static void generateXML(File f, String[][] data)
			throws FileNotFoundException, SecurityException {

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report>");

		for (int i = 1; i < data.length; i++) {

			XMLFile.println("\t<record>");

			for (int j = 0; j < data[0].length; j++) {
				XMLFile.println("\t\t<" + data[0][j].replace(" ", "_")
						+ " value=\"" + data[i][j] + "\"/>");
			}

			XMLFile.println("\t</record>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static String getCriterionKey(int criterionId) {

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(XML_FILE);
			Element root = doc.getDocumentElement();

			int a, b;
			NodeList nodeList1 = root.getChildNodes();
			for (a = 0; a < nodeList1.getLength(); a++) {
				if (!(nodeList1.item(a).getNodeType() == Node.ELEMENT_NODE)
						&& !(nodeList1.item(a).getNodeType() == Node.ATTRIBUTE_NODE)) {
					root.removeChild(nodeList1.item(a));
					a--;
				} else {
					NodeList nodeList2 = nodeList1.item(a).getChildNodes();
					for (b = 0; b < nodeList2.getLength(); b++) {
						if (!(nodeList2.item(b).getNodeType() == Node.ELEMENT_NODE)
								&& !(nodeList2.item(b).getNodeType() == Node.ATTRIBUTE_NODE)) {
							nodeList1.item(a).removeChild(nodeList2.item(b));
							b--;
						}
					}
				}
			}

			for (int i = 0; i < root.getChildNodes().item(0).getChildNodes()
					.item(0).getAttributes().getLength(); i++) {
				Node node = root.getChildNodes().item(0).getChildNodes()
						.item(criterionId).getAttributes().item(i);
				if (node.getNodeName().equals("key"))
					return node.getNodeValue();
			}

			return null;

		} catch (Throwable e) {

			e.printStackTrace();

		}

		return null;

	}

	private static String getOutFile() {

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(XML_FILE);
			Element root = doc.getDocumentElement();

			int a, b;
			NodeList nodeList1 = root.getChildNodes();
			for (a = 0; a < nodeList1.getLength(); a++) {
				if (!(nodeList1.item(a).getNodeType() == Node.ELEMENT_NODE)
						&& !(nodeList1.item(a).getNodeType() == Node.ATTRIBUTE_NODE)) {
					root.removeChild(nodeList1.item(a));
					a--;
				} else {
					NodeList nodeList2 = nodeList1.item(a).getChildNodes();
					for (b = 0; b < nodeList2.getLength(); b++) {
						if (!(nodeList2.item(b).getNodeType() == Node.ELEMENT_NODE)
								&& !(nodeList2.item(b).getNodeType() == Node.ATTRIBUTE_NODE)) {
							nodeList1.item(a).removeChild(nodeList2.item(b));
							b--;
						}
					}
				}
			}

			for (int i = 0; i < root.getChildNodes().item(0).getAttributes()
					.getLength(); i++) {
				Node node = root.getChildNodes().item(0).getAttributes()
						.item(i);
				if (node.getNodeName().equals("outfile"))
					return node.getNodeValue();
			}

		} catch (Throwable e) {

			e.printStackTrace();

		}

		return null;

	}

}
