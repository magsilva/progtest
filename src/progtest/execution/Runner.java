package progtest.execution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Assignment;
import progtest.common.Evaluation;
import progtest.common.Oracle;
import progtest.common.Tool;
import progtest.common.User;
import progtest.database.Querier;
import progtest.util.Constants;
import progtest.util.FileUtil;
import progtest.util.JUnitUtil;

public class Runner {

	public static void run(Assignment assignment, UploadedFile uf)
			throws IllegalArgumentException, IOException, InterruptedException {

		File oracleDir = new File(Directories.getOracleDirPath(assignment));
		File packageDir = new File(Directories.getPackageDirPath(assignment));
		File sourceDir = new File(Directories.getSourceDirPath(assignment));
		File programDir = new File(Directories.getProgramDirPath(assignment));
		File testsDir = new File(Directories.getTestsDirPath(assignment));

		File pitiDir = new File(Directories.getPitiDirPath(assignment));

		makeDirectories(oracleDir, packageDir, sourceDir, programDir, testsDir,
				pitiDir, null, null, null);

		upload(uf, packageDir);

		extract(packageDir, sourceDir);

		split(sourceDir, programDir, testsDir);

		execute(Querier.getTools(assignment), oracleDir, programDir, testsDir,
				pitiDir);

		evaluate(assignment);

		report(assignment);

	}

	public static void run(Assignment assignment, Oracle oracle)
			throws IOException, InterruptedException {

		File oracleFile = new File(Directories.getOracleFilePath(oracle));
		File oracleDir = new File(Directories.getOracleDirPath(assignment));
		File packageDir = new File(Directories.getPackageDirPath(assignment));
		File sourceDir = new File(Directories.getSourceDirPath(assignment));
		File programDir = new File(Directories.getProgramDirPath(assignment));
		File testsDir = new File(Directories.getTestsDirPath(assignment));

		File pitiDir = new File(Directories.getPitiDirPath(assignment));

		makeDirectories(oracleDir, packageDir, sourceDir, programDir, testsDir,
				pitiDir, null, null, null);

		copy(oracleFile, packageDir);

		extract(packageDir, sourceDir);

		split(sourceDir, programDir, testsDir);

		execute(Querier.getTools(assignment), oracleDir, programDir, testsDir,
				pitiDir);

		evaluate(assignment);

		report(assignment);

	}

	public static void run(Evaluation evaluation, UploadedFile uf)
			throws IOException, InterruptedException {

		Assignment assignment = evaluation.getAssignment();
		User student = evaluation.getStudent();

		File studentDir = new File(Directories.getStudentDirPath(assignment,
				student));
		File packageDir = new File(Directories.getPackageDirPath(assignment,
				student));
		File sourceDir = new File(Directories.getSourceDirPath(assignment,
				student));
		File programDir = new File(Directories.getProgramDirPath(assignment,
				student));
		File testsDir = new File(Directories.getTestsDirPath(assignment,
				student));

		// File pitiReportsDir = new
		// File(Directories.getPitiReportsDirPath(assignment));
		File pstsDir = new File(Directories.getPstsDirPath(assignment, student));
		File pitsDir = new File(Directories.getPitsDirPath(assignment, student));
		File pstiDir = new File(Directories.getPstiDirPath(assignment, student));

		File oracleProgramDir = new File(
				Directories.getProgramDirPath(assignment));

		File oracleTestsDir = new File(Directories.getTestsDirPath(assignment));

		makeDirectories(studentDir, packageDir, sourceDir, programDir,
				testsDir, null, pstsDir, pitsDir, pstiDir);

		upload(uf, packageDir);

		extract(packageDir, sourceDir);

		split(sourceDir, programDir, testsDir);

		execute(Querier.getTools(assignment), studentDir, programDir, testsDir,
				pstsDir);

		execute(Querier.getTools(assignment), studentDir, oracleProgramDir,
				testsDir, pitsDir);

		execute(Querier.getTools(assignment), studentDir, programDir,
				oracleTestsDir, pstiDir);

		evaluate(evaluation);

		report(evaluation);

	}

	private static void makeDirectories(File rootDir, File packageDir,
			File sourceDir, File programDir, File testsDir,
			File pitiReportsDir, File pstsReportsDir, File pitsReportsDir,
			File pstiReportsDir) {

		if (rootDir.exists())
			FileUtil.clean(rootDir);
		else
			FileUtil.mkdirs(rootDir);

		if (packageDir != null)
			FileUtil.mkdirs(packageDir);
		if (sourceDir != null)
			FileUtil.mkdirs(sourceDir);
		if (programDir != null)
			FileUtil.mkdirs(programDir);
		if (testsDir != null)
			FileUtil.mkdirs(testsDir);

		if (pitiReportsDir != null)
			FileUtil.mkdirs(pitiReportsDir);
		if (pstsReportsDir != null)
			FileUtil.mkdirs(pstsReportsDir);
		if (pitsReportsDir != null)
			FileUtil.mkdirs(pitsReportsDir);
		if (pstiReportsDir != null)
			FileUtil.mkdirs(pstiReportsDir);

	}

	private static void upload(UploadedFile uf, File packageDir)
			throws IllegalArgumentException, IOException {
		Uploader.upload(uf, packageDir);
	}

	private static void copy(File oracleFile, File packageDir)
			throws IOException {
		FileUtil.copy(oracleFile, packageDir);
	}

	private static void extract(File packageDir, File sourceDir)
			throws IOException {
		for (File file : FileUtil
				.listFiles(packageDir, Constants.EXTENSION_JAR))
			FileUtil.unzip(file, sourceDir);
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
					FileUtil.mkdir(newProgramDir);

				if (!newTestsDir.exists())
					FileUtil.mkdir(newTestsDir);

				split(file, newProgramDir, newTestsDir);

			} else {

				if (JUnitUtil.isTestClass(file)) {
					FileUtil.copy(file, testsDir);
				} else {
					FileUtil.copy(file, programDir);
				}

			}

		}

	}

	private static void execute(List<Tool> tools, File rootDir,
			File programDir, File testsDir, File outputDir) throws IOException,
			InterruptedException {

		for (Tool tool : tools) {
			File reportsDir = new File(Directories.getToolReportsDirPath(
					outputDir, tool));
			File outputFile = new File(Directories.getToolOutputFilePath(
					outputDir, tool));
			Executor.execute(tool, rootDir, programDir, testsDir, reportsDir,
					outputFile);
		}

	}

	private static void evaluate(Assignment oracle) {
		Evaluator.evaluate(oracle);
	}

	private static void evaluate(Evaluation evaluation) {
		Evaluator.evaluate(evaluation);
	}

	private static void report(Assignment oracle) {
		Reporter.generateReports(oracle);
	}

	private static void report(Evaluation evaluation)
			throws FileNotFoundException {
		Reporter.generateReports(evaluation);
	}

}
