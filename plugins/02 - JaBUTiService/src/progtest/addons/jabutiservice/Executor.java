package progtest.addons.jabutiservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.rmi.RemoteException;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.Path;
import org.junit.Test;
import org.junit.runner.JUnitCore;

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

public class Executor {

	private final String PROJECT_NAME = "ProgTest Project";

	private final String USER = "ProgTest";

	private final String PROGRAM_FILE_NAME = "program.jar";

	private final String TESTS_FILE_NAME = "tests.jar";

	private final String INSTRUMENTED_FILE_NAME = "instrumented_program.jar";

	private final String TRACE_FILE_NAME = "trace.trc";

	private final String TEST_SUITE_SOURCE_FILE_NAME = "testSuite.java";

	private final String TEST_SUITE_CLASS_FILE_NAME = "testSuite.class";

	private String endPoint = null;

	private File patchPackage = null;

	private File srcDir = null;

	private File binDir = null;

	private File progDir = null;

	private File testDir = null;

	private File program = null;

	private File testClasses = null;

	private File testSuiteSourceFile = null;

	private File testSuiteClassFile = null;

	private File instrumentedFile = null;

	private File traceFile = null;

	public Executor(String endPoint, File patchPackage, File srcDir,
			File binDir, File progDir, File testDir, File instDir, File tmpDir) {

		this.endPoint = endPoint;
		this.patchPackage = patchPackage;
		this.srcDir = srcDir;
		this.binDir = binDir;
		this.progDir = progDir;
		this.testDir = testDir;

		program = new File(tmpDir.getPath() + File.separator
				+ PROGRAM_FILE_NAME);
		testClasses = new File(tmpDir.getPath() + File.separator
				+ TESTS_FILE_NAME);
		testSuiteSourceFile = new File(srcDir.getPath() + File.separator
				+ TEST_SUITE_SOURCE_FILE_NAME);
		testSuiteClassFile = new File(binDir.getPath() + File.separator
				+ TEST_SUITE_CLASS_FILE_NAME);
		instrumentedFile = new File(instDir.getPath() + File.separator
				+ INSTRUMENTED_FILE_NAME);
		traceFile = new File(instDir.getPath() + File.separator
				+ TRACE_FILE_NAME);

	}

	public void compile() throws Throwable {

		try {

			Project project = new Project();
			project.init();
			org.apache.tools.ant.taskdefs.Javac javac = (org.apache.tools.ant.taskdefs.Javac) project
					.createTask("javac");
			javac.init();
			javac.setDebug(true);
			javac.setVerbose(true);

			Path source = javac.createSourcepath();
			source.setLocation(srcDir);
			javac.setSrcdir(source);

			javac.setDestdir(binDir);

			FileUtil.clean(binDir);

			PrintStream out = System.out;
			PrintStream err = System.err;

			String time = String.valueOf(new Date().getTime());

			File tmp = File.createTempFile(time, time);

			System.setOut(new PrintStream(tmp));
			System.setErr(new PrintStream(tmp));

			javac.perform();

			System.setOut(out);
			System.setErr(err);

			FileReader fr = new FileReader(tmp);
			BufferedReader br = new BufferedReader(fr);

			while (br.ready())
				System.out.println(br.readLine().replace(srcDir.getPath(), "")
						.replace(binDir.getPath(), ""));

		} catch (Throwable t) {

			throw t;

		}

	}

	public Result execute() throws Throwable {

		System.out.println("");
		System.out.println("Isolating test files ...");
		System.out.println("");

		split(binDir, progDir, testDir);

		System.out.println("");
		System.out.println("Creating test suite ...");
		System.out.println("");

		createTestSuite(testDir, testSuiteSourceFile);

		compileTestSuite();

		// if(!executeTestSuite(testSuiteClassFile))
		// throw new
		// Throwable("Error while executing test suite. Make sure that don't have failing tests in your test classes!");

		System.out.println("");
		System.out.println("Preparing packages to be sent to the service ...");
		System.out.println("");

		FileUtil.copy(testSuiteClassFile, testDir);

		FileUtil.zip(progDir.listFiles(), program);

		FileUtil.zip(testDir.listFiles(), testClasses);

		System.out.println("");
		System.out.println("Connecting to the service ...");
		System.out.println("");

		JaBUTiService1_0Stub stub = connect(endPoint);

		System.out.println("");
		System.out.println("Creating testing project ...");
		System.out.println("");

		String projectId = createProject(stub, PROJECT_NAME, USER, program);

		System.out.println("");
		System.out.println("Instrumenting classes ...");
		System.out.println("");

		selectClassesToInstrument(stub, projectId, USER);

		System.out.println("");
		System.out.println("Adding test cases to the project ...");
		System.out.println("");

		addTestCases(stub, projectId, USER, testClasses,
				TEST_SUITE_CLASS_FILE_NAME);

		System.out.println("");
		System.out.println("Executing instrumented file ...");
		System.out.println("");

		getInstrumentedFile(stub, projectId, USER, instrumentedFile);

		applyPatch(instrumentedFile, patchPackage);

		executeInstrumentedFile(instrumentedFile, traceFile,
				TEST_SUITE_CLASS_FILE_NAME);

		System.out.println("");
		System.out.println("Analysing trace generated ...");
		System.out.println("");

		sendTraceFile(stub, projectId, USER, traceFile);

		System.out.println("");
		System.out.println("Analysing coverage ...");
		System.out.println("");

		return getResult(stub, projectId, USER);

	}

	private void split(File sourceDir, File programDir, File testsDir)
			throws IOException {

		File[] localFiles = sourceDir.listFiles();

		for (File file : localFiles) {

			if (file.isDirectory()) {

				File newProgramDir = new File(programDir + File.separator
						+ file.getName());
				File newTestsDir = new File(testsDir + File.separator
						+ file.getName());

				if (!newProgramDir.exists())
					newProgramDir.mkdirs();

				if (!newTestsDir.exists())
					newTestsDir.mkdirs();

				split(file, newProgramDir, newTestsDir);

			} else {

				if (isTestClass(file)) {
					FileUtil.copy(file, testsDir);
				} else {
					FileUtil.copy(file, programDir);
				}

			}

		}

	}

	private boolean isTestClass(File file) {

		String clazzName = file.getName().replace(".class", "");
		File root = file.getParentFile();

		try {

			while (!root.getPath().equals(srcDir.getPath())
					&& !root.getPath().equals(binDir.getPath())
					&& !root.getPath().equals(progDir.getPath())
					&& !root.getPath().equals(testDir.getPath())) {
				clazzName = root.getName() + "." + clazzName;
				root = root.getParentFile();
			}

			URL urls[] = new URL[1];

			urls[0] = new URL("file://" + root.getPath().replace("\\", "/")
					+ "/");

			URLClassLoader loader = new URLClassLoader(urls);

			Class<?> clazz = loader.loadClass(clazzName);

			for (Method method : clazz.getDeclaredMethods())
				for (Annotation annotation : method.getAnnotations())
					if (annotation.annotationType().equals(Test.class))
						return true;

		} catch (MalformedURLException e) {

			System.err.println("Warnning: Invalid URL: " + "file://"
					+ file.getParentFile().getPath().replace("\\", "/") + "/");

		} catch (ClassNotFoundException e) {

			System.err.println("Class not found: " + clazzName);

		}

		return false;

	}

	private void createTestSuite(File testsDir, File testSuiteFile)
			throws IOException {

		if (!testSuiteFile.getName().endsWith(".java"))
			throw new IllegalArgumentException();

		String text = "import org.junit.runner.RunWith;"
				+ "\nimport org.junit.runners.Suite;"
				+ "\nimport org.junit.runners.Suite.SuiteClasses;" + "\n"
				+ "\n@RunWith(value=Suite.class)" + "\n@SuiteClasses(value={";

		for (File file : FileUtil.listFiles(testsDir, ".class"))

			if (isTestClass(file)) {

				String clazzName = file.getName().replace(".class", "");
				File root = file.getParentFile();

				try {

					while (!root.getPath().equals(srcDir.getPath())
							&& !root.getPath().equals(binDir.getPath())
							&& !root.getPath().equals(progDir.getPath())
							&& !root.getPath().equals(testDir.getPath())) {
						clazzName = root.getName() + "." + clazzName;
						root = root.getParentFile();
					}

					URL urls[] = new URL[1];

					urls[0] = new URL("file://"
							+ root.getPath().replace("\\", "/") + "/");

					URLClassLoader loader = new URLClassLoader(urls);

					Class<?> clazz = loader.loadClass(clazzName);

					text += "\n\t" + clazz.getName() + ".class" + ",";

				} catch (MalformedURLException e) {

					System.err.println("Warnning: Invalid URL: " + "file://"
							+ file.getParentFile().getPath().replace("\\", "/")
							+ "/");

				} catch (ClassNotFoundException e) {

					System.err.println("Class not found: " + clazzName);

				}

			}

		text = text.substring(0, text.lastIndexOf(",")) + "\n})"
				+ "\npublic class "
				+ testSuiteFile.getName().replace(".java", "") + " {" + "\n}";

		FileWriter fw = new FileWriter(testSuiteFile);
		fw.write(text);
		fw.close();

	}

	private void compileTestSuite() throws Throwable {

		try {

			Project project = new Project();
			project.init();
			org.apache.tools.ant.taskdefs.Javac javac = (org.apache.tools.ant.taskdefs.Javac) project
					.createTask("javac");
			javac.init();
			javac.setDebug(true);
			javac.setVerbose(true);

			Path source = javac.createSourcepath();
			source.setLocation(srcDir);
			javac.setSrcdir(source);

			javac.setDestdir(binDir);

			FileUtil.clean(binDir);

			PrintStream out = System.out;
			PrintStream err = System.err;

			String time = String.valueOf(new Date().getTime());

			File tmp = File.createTempFile(time, time);

			System.setOut(new PrintStream(tmp));
			System.setErr(new PrintStream(tmp));

			javac.perform();

			System.setOut(out);
			System.setErr(err);

		} catch (Throwable t) {

			throw t;

		}

	}

	private boolean executeTestSuite(File testSuiteFile) {

		try {

			String clazzName = testSuiteFile.getName().replace(".class", "");
			File root = testSuiteFile.getParentFile();

			URL urls[] = new URL[1];

			urls[0] = new URL("file://" + root.getPath().replace("\\", "/")
					+ "/");

			URLClassLoader loader = new URLClassLoader(urls);

			Class<?> clazz = loader.loadClass(clazzName);

			org.junit.runner.Result result = JUnitCore.runClasses(clazz);

			if (result.getFailureCount() == 0)
				return true;

		} catch (MalformedURLException e) {

			System.err.println("Warnning: Invalid URL: "
					+ "file://"
					+ testSuiteFile.getParentFile().getPath()
							.replace("\\", "/") + "/");

		} catch (ClassNotFoundException e) {

			System.err.println("Class not found: " + testSuiteFile);

		}

		return false;

	}

	private JaBUTiService1_0Stub connect(String endPoint) throws AxisFault {

		JaBUTiService1_0Stub stub = new JaBUTiService1_0Stub(endPoint);
		stub._getServiceClient()
				.getOptions()
				.setProperty(Constants.Configuration.ENABLE_MTOM,
						Constants.VALUE_TRUE);
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(4000000);

		return stub;

	}

	private String createProject(JaBUTiService1_0Stub stub, String projectName,
			String user, File program) throws RemoteException,
			InvalidNameFaultException5, InvalidFileFaultException2 {

		CreateProject input = new CreateProject();
		input.setProjectName(projectName);
		input.setIdUserName(user);

		FileDataSource fds = new FileDataSource(program);
		DataHandler dh = new DataHandler(fds);
		input.setProjectFile(dh);

		CreateProjectResponse output = stub.createProject(input);

		return output.get_return();

	}

	private void selectClassesToInstrument(JaBUTiService1_0Stub stub,
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

	private void addTestCases(JaBUTiService1_0Stub stub, String projectId,
			String user, File testClasses, String testSuiteFileName)
			throws RemoteException, InvalidFileFaultException2,
			ClassNotFoundFaultException3, InvalidProjectIdFaultException0,
			OperationSequenceFaultException1 {

		AddTestCases input = new AddTestCases();
		input.setProjectId(projectId);
		input.setIdUserName(user);
		input.setTestSuiteClass(testSuiteFileName);

		FileDataSource fds = new FileDataSource(testClasses);
		DataHandler dh = new DataHandler(fds);
		input.setTestCaseFile(dh);

		stub.addTestCases(input);

	}

	private void getInstrumentedFile(JaBUTiService1_0Stub stub,
			String projectId, String user, File instrumentedFile)
			throws IOException, InvalidProjectIdFaultException0,
			OperationSequenceFaultException1 {

		GetInstrumentedProject input = new GetInstrumentedProject();
		input.setProjectId(projectId);
		input.setIdUserName(user);

		GetInstrumentedProjectResponse output = stub
				.getInstrumentedProject(input);

		if (instrumentedFile.exists())
			FileUtil.delete(instrumentedFile);

		DataHandler dh = output.get_return().getFile();
		FileOutputStream fos = new FileOutputStream(instrumentedFile);
		dh.writeTo(fos);
		fos.flush();
		fos.close();

	}

	private void applyPatch(File instrumentedFile, File patchPackage)
			throws IOException {

		File tmpDir = new File(instrumentedFile.getParentFile().getPath()
				+ File.separator + "tmp");

		boolean ok = false;

		while (!ok) {

			try {

				FileUtil.unzip(instrumentedFile, tmpDir);

				FileUtil.delete(new File(tmpDir.getPath() + File.separator
						+ "br"));

				FileUtil.unzip(patchPackage, tmpDir);

				FileUtil.delete(instrumentedFile);
				FileUtil.zip(tmpDir.listFiles(), instrumentedFile);

				ok = true;

			} catch (Throwable t) {

				ok = false;

			} finally {

				FileUtil.delete(tmpDir);

			}
		}

	}

	private void executeInstrumentedFile(File instrumentedFile, File traceFile,
			String testSuiteClassName) throws IOException, InterruptedException {

		String[] args = { "java", "-cp", instrumentedFile.getPath(),
				"br.jabuti.junitexec.JUnitJabutiCore", "-trace",
				traceFile.getPath(), "-cp", instrumentedFile.getPath(),
				"-tcClass", testSuiteClassName.replace(".class", "") };

		ProcessBuilder processBuilder = null;
		Process process = null;

		Worker worker = null;

		try {

			processBuilder = new ProcessBuilder(args);
			process = processBuilder.start();

			worker = new Worker(process);
			worker.start();
			worker.join();

		} catch (InterruptedException e) {

			worker.interrupt();
			Thread.currentThread().interrupt();
			throw e;

		} finally {

			process.destroy();

		}

	}

	private void sendTraceFile(JaBUTiService1_0Stub stub, String projectId,
			String user, File traceFile) throws RemoteException,
			InvalidFileFaultException2, InvalidProjectIdFaultException0,
			OperationSequenceFaultException1 {

		SendTraceFile input = new SendTraceFile();
		input.setProjectId(projectId);
		input.setIdUserName(user);

		FileDataSource fds = new FileDataSource(traceFile);
		DataHandler dh = new DataHandler(fds);
		input.setTracefile(dh);

		stub.sendTraceFile(input);

	}

	private Result getResult(JaBUTiService1_0Stub stub, String projectId,
			String user) throws Throwable {
		Result r = new Result();
		r.setRequiredElements(getRequiredElements(stub, projectId, USER));
		r.setCoverageByClass(getCoverageByClass(stub, projectId, USER));
		r.setCoverageByMethod(getCoverageByMethod(stub, projectId, USER));
		r.setCoverageByCriterion(getCoverageByCriterion(stub, projectId, USER));
		r.setCoveredAndUncoveredElements(getCoveredAndUncoveredElements(stub,
				projectId, USER));
		return r;
	}

	private String[][] getRequiredElements(JaBUTiService1_0Stub stub,
			String projectId, String user) throws FileNotFoundException,
			SecurityException, RemoteException,
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
						data[i + 1][j + 1] += elems[j2];
						if (j2 + 1 != elems.length)
							data[i + 1][j + 1] += ", ";
						else
							data[i + 1][j + 1] += ";";
					}
			}
		}

		return data;

	}

	private String[][] getCoverageByClass(JaBUTiService1_0Stub stub,
			String projectId, String user) throws FileNotFoundException,
			SecurityException, RemoteException,
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
						+ String.valueOf(criterion[j].getNumberOfElements());
				if (criterion[j].getCoveragePercentage() == 0.0f)
					data[i + 1][j + 1] += " (100.0)";
				else
					data[i + 1][j + 1] += " ("
							+ String.valueOf(criterion[j]
									.getCoveragePercentage()) + ")";
			}
		}

		return data;

	}

	private String[][] getCoverageByMethod(JaBUTiService1_0Stub stub,
			String projectId, String user) throws FileNotFoundException,
			SecurityException, RemoteException,
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
						+ String.valueOf(criterion2[j].getNumberOfElements());
				if (criterion2[j].getCoveragePercentage() == 0.0f)
					data[i + 1][j + 1] += " (100.0)";
				else
					data[i + 1][j + 1] += " ("
							+ String.valueOf(criterion2[j]
									.getCoveragePercentage()) + ")";
			}
		}

		return data;

	}

	private String[][] getCoverageByCriterion(JaBUTiService1_0Stub stub,
			String projectId, String user) throws FileNotFoundException,
			SecurityException, RemoteException,
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
		data[0][1] = "Number of Elements";
		data[0][2] = "Number of Covered Elements";
		data[0][3] = "Percentage";

		for (int i = 0; i < criterion.length; i++) {
			data[i + 1][0] = criterion[i].getCriterionName();
			data[i + 1][1] = String.valueOf(criterion[i].getNumberOfElements());
			data[i + 1][2] = String.valueOf(criterion[i]
					.getNumberOfCoveredElements());
			if (criterion[3].getCoveragePercentage() == 0.0f)
				data[i + 1][3] = "100.0";
			else
				data[i + 1][3] = String.valueOf(criterion[i]
						.getCoveragePercentage());
		}

		return data;

	}

	private String[][] getCoveredAndUncoveredElements(
			JaBUTiService1_0Stub stub, String projectId, String user)
			throws RemoteException, InvalidProjectIdFaultException0,
			OperationSequenceFaultException1, FileNotFoundException,
			SecurityException {

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
				if (cve != null) {
					for (int k = 0; k < cve.length; k++) {
						data[line][2] += cve[k];
						if (k + 1 != cve.length)
							data[line][2] += ", ";
						else
							data[line][2] += ";";
					}
				}

				cve = ccucv[j].getUncoveredElements();
				if (cve != null) {
					for (int k = 0; k < cve.length; k++) {
						data[line][3] += cve[k];
						if (k + 1 != cve.length)
							data[line][3] += ", ";
						else
							data[line][3] += ";";
					}
				}
				line++;
			}

		}

		return data;

	}

	private static class Worker extends Thread {

		private final Process process;

		private Worker(Process process) {
			this.process = process;
		}

		public void run() {

			try {

				InputStream st = process.getInputStream();
				InputStreamReader isr = new InputStreamReader(st);
				BufferedReader br = new BufferedReader(isr);
				while (br.ready())
					System.out.println(br.readLine());

				st = process.getErrorStream();
				isr = new InputStreamReader(st);
				br = new BufferedReader(isr);
				while (br.ready())
					System.out.println(br.readLine());

				process.waitFor();

				st = process.getInputStream();
				isr = new InputStreamReader(st);
				br = new BufferedReader(isr);
				while (br.ready())
					System.out.println(br.readLine());

				st = process.getErrorStream();
				isr = new InputStreamReader(st);
				br = new BufferedReader(isr);
				while (br.ready())
					System.out.println(br.readLine());

			} catch (InterruptedException ignore) {

				return;

			} catch (IOException e) {

				return;

			}

		}

	}

}
