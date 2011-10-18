package progtest.execution;

import java.io.File;
import java.util.List;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Assignment;
import progtest.common.Oracle;
import progtest.common.Requisite;
import progtest.common.Submission;
import progtest.common.Tool;
import progtest.common.User;
import progtest.database.Querier;
import progtest.util.FileUtil;
import progtest.util.TestCaseUtil;

public class Runner {

	public static void makeDirectories(Assignment assignment) throws Throwable {

		try {

			File oracleDir = new File(Directories.getOracleDirPath(assignment));
			File packageDir = new File(
					Directories.getPackageDirPath(assignment));
			File sourceDir = new File(Directories.getSourceDirPath(assignment));
			File programDir = new File(
					Directories.getProgramDirPath(assignment));
			File testsDir = new File(Directories.getTestsDirPath(assignment));

			File pitiDir = new File(Directories.getPitiDirPath(assignment));

			makeDirectories(oracleDir, packageDir, sourceDir, programDir,
					testsDir, pitiDir, null, null, null);

		} catch (Throwable t) {

			throw t;

		}

	}

	public static void upload(Assignment assignment, UploadedFile uf)
			throws Throwable {

		try {

			File packageDir = new File(
					Directories.getPackageDirPath(assignment));
			File sourceDir = new File(Directories.getSourceDirPath(assignment));
			File programDir = new File(
					Directories.getProgramDirPath(assignment));
			File testsDir = new File(Directories.getTestsDirPath(assignment));

			File savedFile = upload(uf, packageDir);

			extract(savedFile, sourceDir);

			split(sourceDir, programDir, testsDir);

		} catch (Throwable t) {

			throw t;

		}

	}

	public static void useOracle(Assignment assignment, Oracle oracle)
			throws Throwable {

		try {

			File oracleFile = new File(Directories.getOracleFilePath(oracle));
			File packageDir = new File(
					Directories.getPackageDirPath(assignment));
			File sourceDir = new File(Directories.getSourceDirPath(assignment));
			File programDir = new File(
					Directories.getProgramDirPath(assignment));
			File testsDir = new File(Directories.getTestsDirPath(assignment));

			File savedFile = useOracle(oracleFile, packageDir);

			extract(savedFile, sourceDir);

			split(sourceDir, programDir, testsDir);

		} catch (Throwable t) {

			throw t;

		}

	}

	public static void execute(Assignment assignment) throws Throwable {

		try {

			File oracleDir = new File(Directories.getOracleDirPath(assignment));
			File programDir = new File(
					Directories.getProgramDirPath(assignment));
			File testsDir = new File(Directories.getTestsDirPath(assignment));

			File pitiDir = new File(Directories.getPitiDirPath(assignment));

			execute(assignment, oracleDir, programDir, testsDir, pitiDir);

		} catch (Throwable t) {

			throw t;

		}

	}

	public static void evaluate(Assignment assignment) throws Throwable {

		try {

			Evaluator.evaluate(assignment);

		} catch (Throwable t) {

			throw t;

		}

	}

	public static String getDownloadable(Assignment assignment)
			throws Throwable {

		try {

			File packageDir = new File(
					Directories.getPackageDirPath(assignment));
			File downloadableDir = new File(
					Directories.getDownloadableDirPath(assignment));

			File savedFile = packageDir.listFiles()[0];

			return toDownload(savedFile, downloadableDir);

		} catch (Throwable t) {

			throw t;

		}

	}

	public static void makeDirectories(Submission submission) throws Throwable {

		try {

			Assignment assignment = submission.getAssignment();
			User student = submission.getStudent();

			File studentDir = new File(Directories.getStudentDirPath(
					assignment, student));
			File packageDir = new File(Directories.getPackageDirPath(
					assignment, student));
			File sourceDir = new File(Directories.getSourceDirPath(assignment,
					student));
			File programDir = new File(Directories.getProgramDirPath(
					assignment, student));
			File testsDir = new File(Directories.getTestsDirPath(assignment,
					student));

			File pstsDir = new File(Directories.getPstsDirPath(assignment,
					student));
			File pitsDir = new File(Directories.getPitsDirPath(assignment,
					student));
			File pstiDir = new File(Directories.getPstiDirPath(assignment,
					student));

			makeDirectories(studentDir, packageDir, sourceDir, programDir,
					testsDir, null, pstsDir, pitsDir, pstiDir);

		} catch (Throwable t) {

			throw t;

		}

	}

	public static void upload(Submission submission, UploadedFile uf)
			throws Throwable {

		try {

			Assignment assignment = submission.getAssignment();
			User student = submission.getStudent();

			File packageDir = new File(Directories.getPackageDirPath(
					assignment, student));
			File sourceDir = new File(Directories.getSourceDirPath(assignment,
					student));
			File programDir = new File(Directories.getProgramDirPath(
					assignment, student));
			File testsDir = new File(Directories.getTestsDirPath(assignment,
					student));

			File savedFile = upload(uf, packageDir);

			extract(savedFile, sourceDir);

			split(sourceDir, programDir, testsDir);

		} catch (Throwable t) {

			throw t;

		}

	}

	public static void psts(Submission submission) throws Throwable {

		try {

			Assignment assignment = submission.getAssignment();
			User student = submission.getStudent();

			File studentDir = new File(Directories.getStudentDirPath(
					assignment, student));
			File programDir = new File(Directories.getProgramDirPath(
					assignment, student));
			File testsDir = new File(Directories.getTestsDirPath(assignment,
					student));

			File pstsDir = new File(Directories.getPstsDirPath(assignment,
					student));

			execute(assignment, studentDir, programDir, testsDir, pstsDir);

		} catch (Throwable t) {

			throw t;

		}

	}

	public static void pits(Submission submission) throws Throwable {

		try {

			Assignment assignment = submission.getAssignment();
			User student = submission.getStudent();

			File studentDir = new File(Directories.getStudentDirPath(
					assignment, student));
			File programDir = new File(
					Directories.getProgramDirPath(assignment));
			File testsDir = new File(Directories.getTestsDirPath(assignment,
					student));

			File pitsDir = new File(Directories.getPitsDirPath(assignment,
					student));

			execute(assignment, studentDir, programDir, testsDir, pitsDir);

		} catch (Throwable t) {

			throw t;

		}

	}

	public static void psti(Submission submission) throws Throwable {

		try {

			Assignment assignment = submission.getAssignment();
			User student = submission.getStudent();

			File studentDir = new File(Directories.getStudentDirPath(
					assignment, student));
			File programDir = new File(Directories.getProgramDirPath(
					assignment, student));
			File testsDir = new File(Directories.getTestsDirPath(assignment));

			File pstiDir = new File(Directories.getPstiDirPath(assignment,
					student));

			execute(assignment, studentDir, programDir, testsDir, pstiDir);

		} catch (Throwable t) {

			throw t;

		}

	}

	public static void evaluate(Submission submission) throws Throwable {

		try {

			Evaluator.evaluate(submission);

		} catch (Throwable t) {

			throw t;

		}

	}

	public static void report(Submission submission) throws Throwable {

		try {

			Reporter.generateReports(submission);

		} catch (Throwable t) {

			throw t;

		}

	}

	public static String getDownloadable(Submission submission)
			throws Throwable {

		try {

			Assignment assignment = submission.getAssignment();
			User student = submission.getStudent();

			File packageDir = new File(Directories.getPackageDirPath(
					assignment, student));
			File downloadableDir = new File(Directories.getDownloadableDirPath(
					assignment, student));

			File savedFile = packageDir.listFiles()[0];

			return toDownload(savedFile, downloadableDir);

		} catch (Throwable t) {

			throw t;

		}

	}

	private static void makeDirectories(File rootDir, File packageDir,
			File sourceDir, File programDir, File testsDir,
			File pitiReportsDir, File pstsReportsDir, File pitsReportsDir,
			File pstiReportsDir) throws Throwable {

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

			throw t;

		}

	}

	private static File upload(UploadedFile uf, File packageDir)
			throws Throwable {

		try {

			return Uploader.upload(uf, packageDir);

		} catch (Throwable t) {

			throw t;

		}

	}

	private static String toDownload(File savedFile, File downloadableDir)
			throws Throwable {

		try {

			if (!downloadableDir.exists())
				downloadableDir.mkdir();
			else
				FileUtil.clean(downloadableDir);

			FileUtil.copy(savedFile, downloadableDir);

			return "/ProgTest/files/" + downloadableDir.getName() + "/"
					+ savedFile.getName();

		} catch (Throwable t) {

			throw t;

		}

	}

	private static File useOracle(File oracleFile, File packageDir)
			throws Throwable {

		try {

			return FileUtil.copy(oracleFile, packageDir);

		} catch (Throwable t) {

			throw t;

		}

	}

	private static void extract(File zipFile, File sourceDir) throws Throwable {

		try {

			FileUtil.unzip(zipFile, sourceDir);

		} catch (Throwable t) {

			throw t;

		}

	}

	private static void split(File sourceDir, File programDir, File testsDir)
			throws Throwable {

		try {

			List<File> classes = FileUtil.listFiles(sourceDir, ".java");

			for (File clazz : classes) {

				File dstDir = null;

				if (TestCaseUtil.isTestCase(clazz))
					dstDir = new File(testsDir
							+ File.separator
							+ TestCaseUtil.getPackage(clazz).replace(".",
									File.separator));
				else
					dstDir = new File(programDir
							+ File.separator
							+ TestCaseUtil.getPackage(clazz).replace(".",
									File.separator));

				FileUtil.copy(clazz, dstDir);

			}

		} catch (Throwable t) {

			throw t;

		}

	}

	private static void execute(Assignment assignment, File rootDir,
			File programDir, File testsDir, File outputDir) throws Throwable {

		try {

			for (Tool tool : assignment.getTools()) {

				String execInfo = "";

				for (Requisite requisite : Querier
						.getAssignmentCriteria(assignment))
					execInfo += requisite.getExecInfo();

				try {

					Executor.execute(tool, rootDir, programDir, testsDir,
							outputDir, execInfo);

				} catch (Throwable t) {

				}

			}

		} catch (Throwable t) {

			throw t;

		}

	}

}
