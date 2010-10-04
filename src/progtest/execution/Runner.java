package progtest.execution;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Assignment;
import progtest.common.Criterion;
import progtest.common.Evaluation;
import progtest.common.Oracle;
import progtest.common.Tool;
import progtest.common.User;
import progtest.database.Querier;
import progtest.exceptions.NotFoundApplicationException;
import progtest.exceptions.NotFoundTestCasesException;
import progtest.util.Constants;
import progtest.util.FileUpload;
import progtest.util.FileUtil;
import progtest.util.TestCaseUtil;

public class Runner {

	public static void run(Assignment assignment, UploadedFile uf)
			throws IllegalArgumentException, IOException,
			NotFoundTestCasesException, NotFoundApplicationException,
			InterruptedException {

		File oracleDir = new File(Directories.getOracleDirPath(assignment));
		File packageDir = new File(Directories.getPackageDirPath(assignment));
		File sourceDir = new File(Directories.getSourceDirPath(assignment));
		File programDir = new File(Directories.getProgramDirPath(assignment));
		File testsDir = new File(Directories.getTestsDirPath(assignment));
		File reportsDir = new File(Directories.getReportsDirPath(assignment));

		File pitiDir = new File(Directories.getPitiDirPath(assignment));

		makeDirectories(oracleDir, packageDir, sourceDir, programDir, testsDir,
				reportsDir, pitiDir, null, null, null);

		upload(uf, packageDir);

		extract(packageDir, sourceDir);

		split(sourceDir, programDir, testsDir);

		execute(assignment.getCriteria(), oracleDir,
				programDir, testsDir, pitiDir);

	}

	public static void run(Assignment assignment, Oracle oracle)
			throws IOException, NotFoundTestCasesException,
			NotFoundApplicationException, InterruptedException {

		File oracleFile = new File(Directories.getOracleFilePath(oracle));
		File oracleDir = new File(Directories.getOracleDirPath(assignment));
		File packageDir = new File(Directories.getPackageDirPath(assignment));
		File sourceDir = new File(Directories.getSourceDirPath(assignment));
		File programDir = new File(Directories.getProgramDirPath(assignment));
		File testsDir = new File(Directories.getTestsDirPath(assignment));
		File reportsDir = new File(Directories.getReportsDirPath(assignment));

		File pitiDir = new File(Directories.getPitiDirPath(assignment));

		makeDirectories(oracleDir, packageDir, sourceDir, programDir, testsDir,
				reportsDir, pitiDir, null, null, null);

		copy(oracleFile, packageDir);

		extract(packageDir, sourceDir);

		split(sourceDir, programDir, testsDir);

		execute(Querier.getCriteria(assignment), oracleDir,
				programDir, testsDir, pitiDir);

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
		File reportsDir = new File(Directories.getReportsDirPath(assignment));

		File pitiDir = new File(Directories.getPitiDirPath(assignment));
		File pstsDir = new File(Directories.getPstsDirPath(assignment, student));
		File pitsDir = new File(Directories.getPitsDirPath(assignment, student));
		File pstiDir = new File(Directories.getPstiDirPath(assignment, student));

		File oracleProgramDir = new File(
				Directories.getProgramDirPath(assignment));
		File oracleTestsDir = new File(Directories.getTestsDirPath(assignment));

		makeDirectories(studentDir, packageDir, sourceDir, programDir,
				testsDir, reportsDir, null, pstsDir, pitsDir, pstiDir);

		upload(uf, packageDir);

		extract(packageDir, sourceDir);

		split(sourceDir, programDir, testsDir);

		execute(assignment.getCriteria(), studentDir,
				programDir, testsDir, pstsDir);

		execute(assignment.getCriteria(), studentDir,
				oracleProgramDir, testsDir, pitsDir);

		execute(assignment.getCriteria(), studentDir,
				programDir, oracleTestsDir, pstiDir);

		evaluate(evaluation, pitiDir, pstsDir, pitsDir, pstiDir, reportsDir);

	}

	private static void makeDirectories(File rootDir, File packageDir,
			File sourceDir, File programDir, File testsDir, File reportsDir,
			File pitiDir, File pstsDir, File pitsDir, File pstiDir) {

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
		if (reportsDir != null)
			FileUtil.mkdirs(reportsDir);

		if (pitiDir != null)
			FileUtil.mkdirs(pitiDir);
		if (pstsDir != null)
			FileUtil.mkdirs(pstsDir);
		if (pitsDir != null)
			FileUtil.mkdirs(pitsDir);
		if (pstiDir != null)
			FileUtil.mkdirs(pstiDir);

	}

	private static void upload(UploadedFile uf, File packageDir)
			throws IllegalArgumentException, IOException {
		FileUpload.save(uf, packageDir);
	}

	private static void copy(File oracleFile, File packageDir)
			throws IOException {
		FileUtil.copy(oracleFile, packageDir);
	}

	private static void extract(File packageDir, File sourceDir)
			throws IOException {
		for(File file: FileUtil.listFiles(packageDir, Constants.EXTENSION_JAR))
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

				if (TestCaseUtil.isTestCase(file)) {
					FileUtil.copy(file, testsDir);
				} else {
					FileUtil.copy(file, programDir);
				}

			}

		}

	}

	private static void execute(List<Criterion> criteria,
			File rootDir, File programDir, File testsDir, File reportsDir)
			throws IOException, InterruptedException {

		List<Tool> tools = new ArrayList<Tool>();

		for (Criterion criterion : criteria) {

			Tool tool = criterion.getTool();

			if (!tools.contains(tool))
				tools.add(tool);

		}

		for (Tool tool : tools) {
			File targetDir = new File(Directories.getTargetDirPath(reportsDir, tool));
			Executor.execute(tool, rootDir, programDir, testsDir, targetDir);
		}

	}

	private static void evaluate(Evaluation evaluation, File pitiDir,
			File pstsDir, File pitsDir, File pstiDir, File reportsDir) {
		Evaluator.evaluate(evaluation, pitiDir, pstsDir, pitsDir, pstiDir,
				reportsDir);
	}

}
