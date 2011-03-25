package progtest.execution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Assignment;
import progtest.common.Oracle;
import progtest.common.Submission;
import progtest.common.Tool;
import progtest.common.User;
import progtest.util.FileUtil;

public class Runner {

	public static void run(Assignment assignment, UploadedFile uf) {

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

			File savedFile = upload(uf, packageDir);

			extract(savedFile, sourceDir);

			split(sourceDir, programDir, testsDir);

			execute(assignment, oracleDir, programDir, testsDir, pitiDir);

			evaluate(assignment);

			report(assignment);

		} catch (Throwable t) {

		} finally {

		}

	}

	public static void run(Assignment assignment, Oracle oracle) {

		try {

			File oracleFile = new File(Directories.getOracleFilePath(oracle));
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

			File savedFile = copy(oracleFile, packageDir);

			extract(savedFile, sourceDir);

			split(sourceDir, programDir, testsDir);

			execute(assignment, oracleDir, programDir, testsDir, pitiDir);

			evaluate(assignment);

			report(assignment);

		} catch (Throwable t) {

		} finally {

		}

	}

	public static void run(Submission submission, UploadedFile uf) {

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

			File oracleProgramDir = new File(
					Directories.getProgramDirPath(assignment));

			File oracleTestsDir = new File(
					Directories.getTestsDirPath(assignment));

			makeDirectories(studentDir, packageDir, sourceDir, programDir,
					testsDir, null, pstsDir, pitsDir, pstiDir);

			File savedFile = upload(uf, packageDir);

			extract(savedFile, sourceDir);

			split(sourceDir, programDir, testsDir);

			execute(assignment, studentDir, programDir, testsDir, pstsDir);

			execute(assignment, studentDir, oracleProgramDir, testsDir, pitsDir);

			execute(assignment, studentDir, programDir, oracleTestsDir, pstiDir);

			evaluate(submission);

			report(submission);

		} catch (Throwable t) {

		} finally {

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

	private static File copy(File oracleFile, File packageDir) throws Throwable {

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
				if (clazz.getName().contains("Test"))
					FileUtil.copy(clazz, testsDir);
				else
					FileUtil.copy(clazz, programDir);
			}

			List<File> files = FileUtil.listFiles(sourceDir);

			for (File file : files) {
				if (file.getName().endsWith(".c")) {
					File hFile = FileUtil.extendTo(file, "h");
					if (hasCUnitTests(file)) {
						FileUtil.copy(file, testsDir);
						if (hFile.exists())
							FileUtil.copy(hFile, testsDir);
					} else {
						FileUtil.copy(file, programDir);
					}
				} else {
					FileUtil.copy(file, programDir);
				}
			}

		} catch (Throwable t) {

			throw t;

		}

	}

	private static boolean hasCUnitTests(File file) {

		try {

			FileReader fr = new FileReader(FileUtil.extendTo(file, "h"));
			BufferedReader br = new BufferedReader(fr);

			while (br.ready()) {
				String line = br.readLine();
				if (line.trim().startsWith("#include"))
					if (line.contains("CUnit"))
						return true;
			}

		} catch (Throwable e) {

			e.printStackTrace();

		}

		return false;

	}

	private static void execute(Assignment assignment, File rootDir,
			File programDir, File testsDir, File outputDir) throws Throwable {

		try {

			for (Tool tool : assignment.getTools()) {

				try {

					Executor.execute(tool, rootDir, programDir, testsDir,
							outputDir);

				} catch (Throwable t) {

				}

			}

		} catch (Throwable t) {

			throw t;

		}

	}

	private static void evaluate(Assignment oracle) throws Throwable {

		try {

			Evaluator.evaluate(oracle);

		} catch (Throwable t) {

			throw t;

		}

	}

	private static void evaluate(Submission submission) throws Throwable {

		try {

			Evaluator.evaluate(submission);

		} catch (Throwable t) {

			throw t;

		}

	}

	private static void report(Assignment assignment) throws Throwable {

		try {

			Reporter.generateReports(assignment);

		} catch (Throwable t) {

			throw t;

		}

	}

	private static void report(Submission submission) throws Throwable {

		try {

			Reporter.generateReports(submission);

		} catch (Throwable t) {

			throw t;

		}

	}

}
