package progtest.trash;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Assignment;
import progtest.common.Evaluation;
import progtest.common.Oracle;
import progtest.common.User;
import progtest.exceptions.CompileException;
import progtest.exceptions.CompressException;
import progtest.exceptions.DecompressException;
import progtest.exceptions.FileException;
import progtest.exceptions.NotFoundApplicationException;
import progtest.exceptions.NotFoundTestCasesException;
import progtest.exceptions.TestingException;
import progtest.exceptions.UploadException;
import progtest.reports.ReportGenerator;
import progtest.reports.TestCase;
import progtest.util.Constants;
import progtest.util.DirControl;
import progtest.util.FileUpload;
import progtest.util.FileUtil;
import progtest.util.TestCaseUtil;

public class Runner {

	public static void executePinstTinst(UploadedFile uf, Assignment assigment)
			throws UploadException, DecompressException, TestingException,
			FileException, CompileException, CompressException,
			NotFoundTestCasesException, NotFoundApplicationException {

		File orc = new File(DirControl.getOraclePath(assigment));

		File pkg = new File(DirControl.getPinstTinstPackagePath(assigment));

		File appSrc = new File(DirControl
				.getPinstTinstApplicationSourcePath(assigment));

		File tsSrc = new File(DirControl.getPinstTinstTestSourcePath(assigment));

		File appBuild = new File(DirControl
				.getPinstTinstApplicationBuildPath(assigment));

		File tsBuild = new File(DirControl
				.getPinstTinstTestBuildPath(assigment));

		File app = new File(DirControl
				.getPinstTinstJabutiApplicationPath(assigment));

		File ts = new File(DirControl.getPinstTinstJabutiTestSetPath(assigment));

		File rpt = new File(DirControl.getPinstTinstReportsPath(assigment));

		File jbt = new File(DirControl.getPinstTinstJabutiPath(assigment));

		File temp = new File(DirControl.getPinstTinstTempPath(assigment));
		
		File temp_src = new File(DirControl.getPinstTinstTempPath(assigment) + File.separator + Constants.DIR_SOURCE);
		
		File temp_build = new File(DirControl.getPinstTinstTempPath(assigment) + File.separator + Constants.DIR_BUILD);

		FileUtil.delete(orc);

		File savedFile = upload(uf, pkg);

		unzip(savedFile, appSrc);

		unzip(savedFile, tsSrc);

		for (File file : FileUtil.listFiles(appSrc))
			if (TestCaseUtil.isTestCase(file)
					|| !file.getName().endsWith(Constants.EXTENSION_JAVA))
				file.delete();

		for (File file : FileUtil.listFiles(tsSrc))
			if (!TestCaseUtil.isTestCase(file)
					|| !file.getName().endsWith(Constants.EXTENSION_JAVA))
				file.delete();

		if (FileUtil.listFiles(tsSrc, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundTestCasesException();

		if (FileUtil.listFiles(appSrc, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundApplicationException();

		generateTestSuite(
				FileUtil.listFiles(tsSrc, Constants.EXTENSION_JAVA),
				new File(DirControl.getPinstTinstTestSourceSuitePath(assigment)));

		runJavac(Constants.PATH_LIBRARY, appSrc.getPath(), pkg.getPath(),
				appBuild.getPath());

		zip(appBuild.listFiles(), app);

		runJavac(Constants.PATH_LIBRARY, tsSrc.getPath(), jbt.getPath(),
				tsBuild.getPath());

		JUnit.run(DirControl.getPinstTinstTestBuildSuitePath(assigment)
				.replace(".class", ""), rpt.getPath(), appBuild.getPath()
				+ File.pathSeparator + tsBuild.getPath(), rpt.getPath());

		FileUtil.clean(temp);
		
		for (File file : FileUtil.listFiles(tsSrc, Constants.EXTENSION_JAVA))
			removeTestCases(rpt.getPath(), file, temp_src);

		runJavac(Constants.PATH_LIBRARY, temp_src.getPath(), jbt.getPath(),
				temp_build.getPath());

		zip(temp_build.listFiles(), ts);

		runJabuti(app.getPath(), ts.getPath(), Constants.FILE_TESTSUITE, rpt
				.getPath());

	}

	public static void executePinstTinst(Oracle oracle, Assignment assigment)
			throws DecompressException, TestingException, CompileException,
			CompressException, FileException, NotFoundTestCasesException,
			NotFoundApplicationException {

		File orcPkg = new File(DirControl.getOraclePackage(oracle.getIdCode()));

		File orc = new File(DirControl.getOraclePath(assigment));

		File pkg = new File(DirControl.getPinstTinstPackagePath(assigment));

		File appSrc = new File(DirControl
				.getPinstTinstApplicationSourcePath(assigment));

		File tsSrc = new File(DirControl.getPinstTinstTestSourcePath(assigment));

		File appBuild = new File(DirControl
				.getPinstTinstApplicationBuildPath(assigment));

		File tsBuild = new File(DirControl
				.getPinstTinstTestBuildPath(assigment));

		File app = new File(DirControl
				.getPinstTinstJabutiApplicationPath(assigment));

		File ts = new File(DirControl.getPinstTinstJabutiTestSetPath(assigment));

		File rpt = new File(DirControl.getPinstTinstReportsPath(assigment));

		File jbt = new File(DirControl.getPinstTinstJabutiPath(assigment));

		File temp = new File(DirControl.getPinstTinstTempPath(assigment));
		
		File temp_src = new File(DirControl.getPinstTinstTempPath(assigment) + File.separator + Constants.DIR_SOURCE);
		
		File temp_build = new File(DirControl.getPinstTinstTempPath(assigment) + File.separator + Constants.DIR_BUILD);

		FileUtil.delete(orc);

		copy(orcPkg, pkg);

		File savedFile = new File(pkg + File.separator + oracle.getIdCode()
				+ Constants.EXTENSION_JAR);

		unzip(savedFile, appSrc);

		unzip(savedFile, tsSrc);

		for (File file : FileUtil.listFiles(appSrc))
			if (TestCaseUtil.isTestCase(file)
					|| !file.getName().endsWith(Constants.EXTENSION_JAVA))
				file.delete();

		for (File file : FileUtil.listFiles(tsSrc))
			if (!TestCaseUtil.isTestCase(file)
					|| !file.getName().endsWith(Constants.EXTENSION_JAVA))
				file.delete();

		if (FileUtil.listFiles(tsSrc, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundTestCasesException();

		if (FileUtil.listFiles(appSrc, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundApplicationException();

		generateTestSuite(FileUtil.listFiles(tsSrc), new File(DirControl
				.getPinstTinstTestSourceSuitePath(assigment)));

		runJavac(Constants.PATH_LIBRARY, appSrc.getPath(), pkg.getPath(),
				appBuild.getPath());

		zip(appBuild.listFiles(), app);

		runJavac(Constants.PATH_LIBRARY, tsSrc.getPath(), jbt.getPath(),
				tsBuild.getPath());

		JUnit.run(DirControl.getPinstTinstTestBuildSuitePath(assigment)
				.replace(".class", ""), rpt.getPath(), appBuild.getPath()
				+ File.pathSeparator + tsBuild.getPath(), rpt.getPath());

		FileUtil.clean(temp);
		
		for (File file : FileUtil.listFiles(tsSrc, Constants.EXTENSION_JAVA))
			removeTestCases(rpt.getPath(), file, temp_src);

		runJavac(Constants.PATH_LIBRARY, temp_src.getPath(), jbt.getPath(),
				temp_build.getPath());

		zip(temp_build.listFiles(), ts);

		runJabuti(app.getPath(), ts.getPath(), "TestSet", rpt
				.getPath());

	}

	public static void executePalTal(UploadedFile uf, Evaluation avaliation)
			throws UploadException, DecompressException, TestingException,
			FileException, CompileException, CompressException,
			NotFoundTestCasesException, NotFoundApplicationException {

		Assignment assigment = avaliation.getAssignment();

		User user = avaliation.getStudent();

		File usr = new File(DirControl.getUserPath(assigment, user));

		File pkg = new File(DirControl.getPalTalPackagePath(assigment, user));

		File appSrc = new File(DirControl.getPalTalApplicationSourcePath(
				assigment, user));

		File tsSrc = new File(DirControl.getPalTalTestSourcePath(assigment,
				user));

		File appBuild = new File(DirControl.getPalTalApplicationBuildPath(
				assigment, user));

		File tsBuild = new File(DirControl.getPalTalTestBuildPath(assigment,
				user));

		File app = new File(DirControl.getPalTalJabutiApplicationPath(
				assigment, user));

		File ts = new File(DirControl.getPalTalJabutiTestSetPath(assigment,
				user));

		File rpt = new File(DirControl.getPalTalReportsPath(assigment, user));

		File jbt = new File(DirControl.getPalTalJabutiPath(assigment, user));

		File temp = new File(DirControl.getPalTalTempPath(assigment, user));
		
		File temp_src = new File(DirControl.getPalTalTempPath(assigment, user) + File.separator + Constants.DIR_SOURCE);
		
		File temp_build = new File(DirControl.getPalTalTempPath(assigment, user) + File.separator + Constants.DIR_BUILD);

		FileUtil.delete(usr);

		File savedFile = upload(uf, pkg);

		unzip(savedFile, appSrc);

		unzip(savedFile, tsSrc);

		for (File file : FileUtil.listFiles(appSrc))
			if (TestCaseUtil.isTestCase(file)
					|| !file.getName().endsWith(Constants.EXTENSION_JAVA))
				file.delete();

		for (File file : FileUtil.listFiles(tsSrc))
			if (!TestCaseUtil.isTestCase(file)
					|| !file.getName().endsWith(Constants.EXTENSION_JAVA))
				file.delete();

		if (FileUtil.listFiles(tsSrc, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundTestCasesException();

		if (FileUtil.listFiles(appSrc, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundApplicationException();

		generateTestSuite(FileUtil.listFiles(tsSrc), new File(DirControl
				.getPalTalTestSourceSuitePath(assigment, user)));

		runJavac(Constants.PATH_LIBRARY, appSrc.getPath(), pkg.getPath(),
				appBuild.getPath());

		zip(appBuild.listFiles(), app);

		runJavac(Constants.PATH_LIBRARY, tsSrc.getPath(), jbt.getPath(),
				tsBuild.getPath());

		JUnit.run(DirControl.getPalTalTestBuildSuitePath(assigment, user)
				.replace(".class", ""), rpt.getPath(), appBuild.getPath()
				+ File.pathSeparator + tsBuild.getPath(), rpt.getPath());

		FileUtil.clean(temp);
		
		for (File file : FileUtil.listFiles(tsSrc, Constants.EXTENSION_JAVA))
			removeTestCases(rpt.getPath(), file, temp_src);

		runJavac(Constants.PATH_LIBRARY, temp_src.getPath(), jbt.getPath(),
				temp_build.getPath());

		zip(temp_build.listFiles(), ts);

		runJabuti(app.getPath(), ts.getPath(), Constants.FILE_TESTSUITE, rpt
				.getPath());

	}

	public static void importPalTalTestCases(UploadedFile uf,
			Evaluation avaliation) throws UploadException, DecompressException,
			TestingException, FileException, CompileException,
			CompressException, NotFoundTestCasesException,
			NotFoundApplicationException {

		Assignment assigment = avaliation.getAssignment();

		User user = avaliation.getStudent();

		File pkg = new File(DirControl.getPalTalPackagePath(assigment, user));

		File temp = new File(DirControl.getPalTalTempPath(assigment, user));

		File appSrc = new File(DirControl.getPalTalApplicationSourcePath(
				assigment, user));

		File tsSrc = new File(DirControl.getPalTalTestSourcePath(assigment,
				user));

		File appBuild = new File(DirControl.getPalTalApplicationBuildPath(
				assigment, user));

		File tsBuild = new File(DirControl.getPalTalTestBuildPath(assigment,
				user));

		File app = new File(DirControl.getPalTalJabutiApplicationPath(
				assigment, user));

		File ts = new File(DirControl.getPalTalJabutiTestSetPath(assigment,
				user));

		File rpt = new File(DirControl.getPalTalReportsPath(assigment, user));

		File jbt = new File(DirControl.getPalTalJabutiPath(assigment, user));

		File usrPkg = FileUtil.listFiles(pkg, Constants.EXTENSION_JAR).get(0);
		
		File temp_src = new File(DirControl.getPalTalTempPath(assigment, user) + File.separator + Constants.DIR_SOURCE);
		
		File temp_build = new File(DirControl.getPalTalTempPath(assigment, user) + File.separator + Constants.DIR_BUILD);

		FileUtil.clean(temp);

		File savedFile = upload(uf, temp);

		unzip(savedFile, temp);

		for (File file : FileUtil.listFiles(temp))
			if (!TestCaseUtil.isTestCase(file)
					|| !file.getName().endsWith(Constants.EXTENSION_JAVA))
				file.delete();

		unzip(usrPkg, temp);

		FileUtil.clean(pkg);

		usrPkg = new File(pkg.getPath() + File.separator + "Pakage"
				+ Constants.EXTENSION_JAR);

		zip(temp.listFiles(), usrPkg);

		unzip(usrPkg, appSrc);

		unzip(usrPkg, tsSrc);

		for (File file : FileUtil.listFiles(appSrc))
			if (TestCaseUtil.isTestCase(file)
					|| !file.getName().endsWith(Constants.EXTENSION_JAVA))
				file.delete();

		for (File file : FileUtil.listFiles(tsSrc))
			if (!TestCaseUtil.isTestCase(file)
					|| !file.getName().endsWith(Constants.EXTENSION_JAVA))
				file.delete();

		if (FileUtil.listFiles(tsSrc, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundTestCasesException();

		if (FileUtil.listFiles(appSrc, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundApplicationException();

		generateTestSuite(FileUtil.listFiles(tsSrc), new File(DirControl
				.getPalTalTestSourceSuitePath(assigment, user)));

		runJavac(Constants.PATH_LIBRARY, appSrc.getPath(), pkg.getPath(),
				appBuild.getPath());

		zip(appBuild.listFiles(), app);

		runJavac(Constants.PATH_LIBRARY, tsSrc.getPath(), jbt.getPath(),
				tsBuild.getPath());

		JUnit.run(DirControl.getPalTalTestBuildSuitePath(assigment, user)
				.replace(".class", ""), rpt.getPath(), appBuild.getPath()
				+ File.pathSeparator + tsBuild.getPath(), rpt.getPath());

		FileUtil.clean(temp);
		
		for (File file : FileUtil.listFiles(tsSrc, Constants.EXTENSION_JAVA))
			removeTestCases(rpt.getPath(), file, temp_src);

		runJavac(Constants.PATH_LIBRARY, temp_src.getPath(), jbt.getPath(),
				temp_build.getPath());

		zip(temp_build.listFiles(), ts);

		runJabuti(app.getPath(), ts.getPath(), Constants.FILE_TESTSUITE, rpt
				.getPath());

	}

	public static void executePinstTal(Evaluation avaliation)
			throws TestingException, CompressException, CompileException,
			FileException, DecompressException, NotFoundTestCasesException,
			NotFoundApplicationException {

		Assignment assigment = avaliation.getAssignment();

		User user = avaliation.getStudent();

		File orcApp = new File(DirControl
				.getPinstTinstApplicationSourcePath(assigment));

		File usrTs = new File(DirControl.getPalTalTestSourcePath(assigment,
				user));

		File pkg = new File(DirControl.getPinstTalPackagePath(assigment, user));

		File orcAppPkg = new File(DirControl.getPinstTalPackageApplicationPath(
				assigment, user));

		File usrTsPkg = new File(DirControl.getPinstTalPackageTestSetPath(
				assigment, user));

		File appSrc = new File(DirControl.getPinstTalApplicationSourcePath(
				assigment, user));

		File tsSrc = new File(DirControl.getPinstTalTestSourcePath(assigment,
				user));

		File appBuild = new File(DirControl.getPinstTalApplicationBuildPath(
				assigment, user));

		File tsBuild = new File(DirControl.getPinstTalTestBuildPath(assigment,
				user));

		File app = new File(DirControl.getPinstTalJabutiApplicationPath(
				assigment, user));

		File ts = new File(DirControl.getPinstTalJabutiTestSetPath(assigment,
				user));

		File rpt = new File(DirControl.getPinstTalReportsPath(assigment, user));

		File jbt = new File(DirControl.getPinstTalJabutiPath(assigment, user));

		File temp = new File(DirControl.getPinstTalTempPath(assigment, user));
		
		File temp_src = new File(DirControl.getPinstTalTempPath(assigment, user) + File.separator + Constants.DIR_SOURCE);
		
		File temp_build = new File(DirControl.getPinstTalTempPath(assigment, user) + File.separator + Constants.DIR_BUILD);

		FileUtil.clean(new File(DirControl.getPinstTalPath(assigment, user)));

		zip(orcApp.listFiles(), orcAppPkg);

		zip(usrTs.listFiles(), usrTsPkg);

		unzip(orcAppPkg, appSrc);

		unzip(usrTsPkg, tsSrc);

		for (File file : FileUtil.listFiles(appSrc))
			if (TestCaseUtil.isTestCase(file)
					|| !file.getName().endsWith(Constants.EXTENSION_JAVA))
				file.delete();

		for (File file : FileUtil.listFiles(tsSrc))
			if (!TestCaseUtil.isTestCase(file)
					|| !file.getName().endsWith(Constants.EXTENSION_JAVA))
				file.delete();

		if (FileUtil.listFiles(tsSrc, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundTestCasesException();

		if (FileUtil.listFiles(appSrc, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundApplicationException();

		generateTestSuite(FileUtil.listFiles(tsSrc), new File(DirControl
				.getPinstTalTestSourceSuitePath(assigment, user)));

		runJavac(Constants.PATH_LIBRARY, appSrc.getPath(), pkg.getPath(),
				appBuild.getPath());

		zip(appBuild.listFiles(), app);

		runJavac(Constants.PATH_LIBRARY, tsSrc.getPath(), jbt.getPath(),
				tsBuild.getPath());

		JUnit.run(DirControl.getPinstTalTestBuildSuitePath(assigment, user)
				.replace(".class", ""), rpt.getPath(), appBuild.getPath()
				+ File.pathSeparator + tsBuild.getPath(), rpt.getPath());

		FileUtil.clean(temp);
		
		for (File file : FileUtil.listFiles(tsSrc, Constants.EXTENSION_JAVA))
			removeTestCases(rpt.getPath(), file, temp_src);

		runJavac(Constants.PATH_LIBRARY, temp_src.getPath(), jbt.getPath(),
				temp_build.getPath());

		zip(temp_build.listFiles(), ts);

		runJabuti(app.getPath(), ts.getPath(), Constants.FILE_TESTSUITE, rpt
				.getPath());

	}

	public static void executePalTinst(Evaluation avaliation)
			throws TestingException, CompressException, FileException,
			CompileException, DecompressException, NotFoundTestCasesException,
			NotFoundApplicationException {

		Assignment assigment = avaliation.getAssignment();

		User user = avaliation.getStudent();

		File usrApp = new File(DirControl.getPalTalApplicationSourcePath(
				assigment, user));

		File orcTs = new File(DirControl.getPinstTinstTestSourcePath(assigment));

		File pkg = new File(DirControl.getPalTinstPackagePath(assigment, user));

		File usrAppPkg = new File(DirControl.getPalTinstPackageApplicationPath(
				assigment, user));

		File orcTsPkg = new File(DirControl.getPalTinstPackageTestSetPath(
				assigment, user));

		File appSrc = new File(DirControl.getPalTinstApplicationSourcePath(
				assigment, user));

		File tsSrc = new File(DirControl.getPalTinstTestSourcePath(assigment,
				user));

		File appBuild = new File(DirControl.getPalTinstApplicationBuildPath(
				assigment, user));

		File tsBuild = new File(DirControl.getPalTinstTestBuildPath(assigment,
				user));

		File app = new File(DirControl.getPalTinstJabutiApplicationPath(
				assigment, user));

		File ts = new File(DirControl.getPalTinstJabutiTestSetPath(assigment,
				user));

		File rpt = new File(DirControl.getPalTinstReportsPath(assigment, user));

		File jbt = new File(DirControl.getPalTinstJabutiPath(assigment, user));
		
		File temp = new File(DirControl.getPalTinstTempPath(assigment, user));
		
		File temp_src = new File(DirControl.getPalTinstTempPath(assigment, user) + File.separator + Constants.DIR_SOURCE);
		
		File temp_build = new File(DirControl.getPalTinstTempPath(assigment, user) + File.separator + Constants.DIR_BUILD);

		FileUtil.clean(new File(DirControl.getPalTinstPath(assigment, user)));

		zip(usrApp.listFiles(), usrAppPkg);

		zip(orcTs.listFiles(), orcTsPkg);

		unzip(usrAppPkg, appSrc);

		unzip(orcTsPkg, tsSrc);

		for (File file : FileUtil.listFiles(appSrc))
			if (TestCaseUtil.isTestCase(file)
					|| !file.getName().endsWith(Constants.EXTENSION_JAVA))
				file.delete();

		for (File file : FileUtil.listFiles(tsSrc))
			if (!TestCaseUtil.isTestCase(file)
					|| !file.getName().endsWith(Constants.EXTENSION_JAVA))
				file.delete();

		if (FileUtil.listFiles(tsSrc, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundTestCasesException();

		if (FileUtil.listFiles(appSrc, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundApplicationException();

		generateTestSuite(FileUtil.listFiles(tsSrc), new File(DirControl
				.getPalTinstTestSourceSuitePath(assigment, user)));

		runJavac(Constants.PATH_LIBRARY, appSrc.getPath(), pkg.getPath(),
				appBuild.getPath());

		zip(appBuild.listFiles(), app);

		runJavac(Constants.PATH_LIBRARY, tsSrc.getPath(), jbt.getPath(),
				tsBuild.getPath());

		JUnit.run(DirControl.getPalTinstTestBuildSuitePath(assigment, user)
				.replace(".class", ""), rpt.getPath(), appBuild.getPath()
				+ File.pathSeparator + tsBuild.getPath(), rpt.getPath());

		FileUtil.clean(temp);
		
		for (File file : FileUtil.listFiles(tsSrc, Constants.EXTENSION_JAVA))
			removeTestCases(rpt.getPath(), file, temp_src);

		runJavac(Constants.PATH_LIBRARY, temp_src.getPath(), jbt.getPath(),
				temp_build.getPath());

		zip(temp_build.listFiles(), ts);

		runJabuti(app.getPath(), ts.getPath(), Constants.FILE_TESTSUITE, rpt
				.getPath());

	}

	private static void copy(File src, File dst) throws TestingException,
			FileException {
		try {
			FileUtil.copy(src, dst);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new FileException(e.getMessage(), e.getCause());
		}
	}

	private static File upload(UploadedFile uf, File dst)
			throws UploadException {
		try {
			return FileUpload.save(uf, dst);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new UploadException(e.getMessage(), e.getCause());
		}
	}

	private static void zip(File[] inputFiles, File outputFile)
			throws TestingException, CompressException {
		try {
			FileUtil.zip(inputFiles, outputFile);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new CompressException(e.getMessage(), e.getCause());
		}
	}

	private static void unzip(File inputFile, File dst)
			throws DecompressException {
		try {
			FileUtil.unzip(inputFile, dst);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DecompressException(e.getMessage(), e.getCause());
		}
	}

	private static void generateTestSuite(List<File> list, File dst)
			throws FileException {
		try {
			TestCaseUtil.genarateTestSuite(list, dst);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new FileException(e.getMessage(), e.getCause());
		}
	}

	private static void runJavac(String basicPath, String srcPath,
			String libPath, String dstPath) throws CompileException {
		try {
			JavacExecutor.run(basicPath, srcPath, libPath, dstPath);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new CompileException(e.getMessage(), e.getCause());
		}
	}

	private static void runJabuti(String appPath, String tcPath, String tsName,
			String rptPath) throws TestingException {
		try {
			Jabuti.run(appPath, tcPath, tsName, rptPath);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new TestingException(e.getMessage(), e.getCause());
		}
	}

	private static void removeTestCases(String testCasesReport, File testClass, File output) {
		
		File file = new File(testCasesReport + File.separator + "TestCases.xml");
		List<String> tcs = new ArrayList<String>();
		List<TestCase> report = ReportGenerator.getTestCaseReport(file);
		
		for(TestCase tc : report) {
			if(tc.getClassName().equals(testClass.getName().replace(".java", "")) && !tc.getStatus().equals("success"))
				tcs.add(tc.getName());
		}
		
		TestCaseUtil.removeTestCases(tcs, testClass, new File(output.getPath() + File.separator + testClass.getName()));
		
	}

}
