package progtest.execution;

import java.io.File;
import java.util.List;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Assignment;
import progtest.common.Oracle;
import progtest.common.Submission;
import progtest.common.Tool;
import progtest.common.User;
import progtest.database.Querier;
import progtest.execution.exceptions.CopyException;
import progtest.execution.exceptions.EvaluationException;
import progtest.execution.exceptions.ExecutionException;
import progtest.execution.exceptions.ExtractionException;
import progtest.execution.exceptions.ReportException;
import progtest.execution.exceptions.RunDirectoriesException;
import progtest.execution.exceptions.SplitException;
import progtest.execution.exceptions.UploadException;
import progtest.util.FileUtil;
import progtest.util.JUnitUtil;

public class Runner {

	public static void run(Assignment assignment, UploadedFile uf)
			throws RunDirectoriesException, UploadException,
			ExtractionException, SplitException, ExecutionException,
			EvaluationException, ReportException {

		File oracleDir = new File(Directories.getOracleDirPath(assignment));
		File packageDir = new File(Directories.getPackageDirPath(assignment));
		File sourceDir = new File(Directories.getSourceDirPath(assignment));
		File programDir = new File(Directories.getProgramDirPath(assignment));
		File testsDir = new File(Directories.getTestsDirPath(assignment));

		File pitiDir = new File(Directories.getPitiDirPath(assignment));

		makeDirectories(oracleDir, packageDir, sourceDir, programDir, testsDir,
				pitiDir, null, null, null);

		File savedFile = upload(uf, packageDir);

		extract(savedFile, sourceDir);

		split(sourceDir, programDir, testsDir);

		execute(Querier.getTools(assignment), oracleDir, programDir, testsDir,
				pitiDir);

		evaluate(assignment);

		report(assignment);

	}

	public static void run(Assignment assignment, Oracle oracle)
			throws RunDirectoriesException, CopyException, ExtractionException,
			SplitException, ExecutionException, EvaluationException,
			ReportException {

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

	public static void run(Submission submission, UploadedFile uf)
			throws RunDirectoriesException, UploadException,
			ExtractionException, SplitException, ExecutionException,
			EvaluationException, ReportException {

		Assignment assignment = submission.getAssignment();
		User student = submission.getStudent();

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

		File pstsDir = new File(Directories.getPstsDirPath(assignment, student));
		File pitsDir = new File(Directories.getPitsDirPath(assignment, student));
		File pstiDir = new File(Directories.getPstiDirPath(assignment, student));

		File oracleProgramDir = new File(
				Directories.getProgramDirPath(assignment));

		File oracleTestsDir = new File(Directories.getTestsDirPath(assignment));

		makeDirectories(studentDir, packageDir, sourceDir, programDir,
				testsDir, null, pstsDir, pitsDir, pstiDir);

		File savedFile = upload(uf, packageDir);

		extract(savedFile, sourceDir);

		split(sourceDir, programDir, testsDir);

		execute(Querier.getTools(assignment), studentDir, programDir, testsDir,
				pstsDir);

		execute(Querier.getTools(assignment), studentDir, oracleProgramDir,
				testsDir, pitsDir);

		execute(Querier.getTools(assignment), studentDir, programDir,
				oracleTestsDir, pstiDir);

		evaluate(submission);

		report(submission);

	}

	private static void makeDirectories(File rootDir, File packageDir,
			File sourceDir, File programDir, File testsDir,
			File pitiReportsDir, File pstsReportsDir, File pitsReportsDir,
			File pstiReportsDir) throws RunDirectoriesException {

		try {

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

		} catch (Throwable t) {

			throw new RunDirectoriesException(t);

		}

	}

	private static File upload(UploadedFile uf, File packageDir)
			throws UploadException {

		try {

			return Uploader.upload(uf, packageDir);

		} catch (Throwable t) {

			throw new UploadException(t);

		}

	}

	private static void copy(File oracleFile, File packageDir)
			throws CopyException {

		try {

			FileUtil.copy(oracleFile, packageDir);

		} catch (Throwable t) {

			throw new CopyException(t);

		}

	}

	private static void extract(File zipFile, File sourceDir)
			throws ExtractionException {

		try {

			FileUtil.unzip(zipFile, sourceDir);

		} catch (Throwable t) {

			throw new ExtractionException(t);

		}

	}

	private static void split(File sourceDir, File programDir, File testsDir)
			throws SplitException {

		try {

			JUnitUtil.split(sourceDir, programDir, testsDir);

		} catch (Throwable t) {

			throw new SplitException(t);

		}

	}

	private static void execute(List<Tool> tools, File rootDir,
			File programDir, File testsDir, File outputDir)
			throws ExecutionException {

		try {

			for (Tool tool : tools) {

				File reportsDir = new File(Directories.getToolReportsDirPath(
						outputDir, tool));

				File outputFile = new File(Directories.getToolOutputFilePath(
						outputDir, tool));

				try {

					Executor.execute(tool, rootDir, programDir, testsDir,
							reportsDir, outputFile);

				} catch (Throwable t) {

					t.printStackTrace();

				}

			}

		} catch (Throwable t) {

			throw new ExecutionException(t);

		}

	}

	private static void evaluate(Assignment oracle) throws EvaluationException {

		try {

			Evaluator.evaluate(oracle);

		} catch (Throwable t) {

			throw new EvaluationException(t);

		}

	}

	private static void evaluate(Submission evaluation)
			throws EvaluationException {

		try {

			Evaluator.evaluate(evaluation);

		} catch (Throwable t) {

			throw new EvaluationException(t);

		}

	}

	private static void report(Assignment oracle) throws ReportException {

		try {

			Reporter.generateReports(oracle);

		} catch (Throwable t) {

			throw new ReportException(t);

		}

	}

	private static void report(Submission evaluation) throws ReportException {

		try {

			Reporter.generateReports(evaluation);

		} catch (Throwable t) {

			throw new ReportException(t);

		}

	}

}
