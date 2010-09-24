package progtest.execution;

import java.io.File;
import java.io.IOException;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import progtest.common.Assignment;
import progtest.common.Evaluation;
import progtest.common.Oracle;
import progtest.common.User;
import progtest.exceptions.NotFoundApplicationException;
import progtest.exceptions.NotFoundTestCasesException;
import progtest.util.FileUpload;
import progtest.util.FileUtil;
import progtest.util.TestCaseUtil;

public class Run {

	public static void run(Assignment assignment, UploadedFile uf)
			throws IllegalArgumentException, IOException,
			NotFoundTestCasesException, NotFoundApplicationException {

		File oracleDir = new File(DirControl.getOracleDirPath(assignment));
		File packageDir = new File(DirControl.getPackageDirPath(assignment));
		File sourceDir = new File(DirControl.getSourceDirPath(assignment));
		File programDir = new File(DirControl.getProgramDirPath(assignment));
		File testsDir = new File(DirControl.getTestsDirPath(assignment));
		File reportsDir = new File(DirControl.getReportsDirPath(assignment));
		
		makeDirectories(oracleDir, packageDir, sourceDir, programDir, testsDir, reportsDir);
		
		upload(uf, packageDir);
		
		extract(packageDir, sourceDir);
		
		split(sourceDir, programDir, testsDir);

	}

	public static void run(Assignment assignment, Oracle oracle)
			throws IOException, NotFoundTestCasesException, NotFoundApplicationException {
		
		File oracleFile = new File(DirControl.getOracleFilePath(oracle));
		File oracleDir = new File(DirControl.getOracleDirPath(assignment));
		File packageDir = new File(DirControl.getPackageDirPath(assignment));
		File sourceDir = new File(DirControl.getSourceDirPath(assignment));
		File programDir = new File(DirControl.getProgramDirPath(assignment));
		File testsDir = new File(DirControl.getTestsDirPath(assignment));
		File reportsDir = new File(DirControl.getReportsDirPath(assignment));
		
		makeDirectories(oracleDir, packageDir, sourceDir, programDir, testsDir, reportsDir);
		
		copy(oracleFile, packageDir);
		
		extract(packageDir, sourceDir);
		
		split(sourceDir, programDir, testsDir);
		
	}

	public static void run(Evaluation evaluation, UploadedFile uf)
			throws IOException {
		
		Assignment assignment = evaluation.getAssignment();
		User student = evaluation.getStudent();
		
		File studentDir = new File(DirControl.getStudentDirPath(assignment, student));
		File packageDir = new File(DirControl.getPackageDirPath(assignment, student));
		File sourceDir = new File(DirControl.getSourceDirPath(assignment, student));
		File programDir = new File(DirControl.getProgramDirPath(assignment, student));
		File testsDir = new File(DirControl.getTestsDirPath(assignment, student));
		File reportsDir = new File(DirControl.getReportsDirPath(assignment));
		
		makeDirectories(studentDir, packageDir, sourceDir, programDir, testsDir, reportsDir);
		
		upload(uf, packageDir);
		
		extract(packageDir, sourceDir);
		
		split(sourceDir, programDir, testsDir);
		
	}

	private static void makeDirectories(File rootDir, File packageDir, File sourceDir, File programDir,
			File testsDir, File reportsDir) {
		
		if(rootDir.exists())
			FileUtil.clean(rootDir);
		else
			FileUtil.mkdirs(rootDir);
		
		FileUtil.mkdir(packageDir);
		FileUtil.mkdir(sourceDir);
		FileUtil.mkdir(programDir);
		FileUtil.mkdir(testsDir);
		FileUtil.mkdir(reportsDir);
		
	}

	private static void upload(UploadedFile uf, File packageDir) throws IllegalArgumentException, IOException {
		FileUpload.save(uf,packageDir);
	}

	private static void copy(File oracleFile, File packageDir) throws IOException {
		FileUtil.copy(oracleFile, packageDir);
	}

	private static void extract(File packageDir, File sourceDir) throws IOException {
		FileUtil.unzip(packageDir, sourceDir);
	}

	private static void split(File sourceDir, File programDir, File testsDir) throws IOException {
		
			File[] localFiles = sourceDir.listFiles();
			
			for (File file : localFiles) {
				
				if (file.isDirectory()) {
					
					File newProgramDir = new File(sourceDir + File.separator + file.getName());
					File newTestsDir = new File(sourceDir + File.separator + file.getName());
					
					if(!newProgramDir.exists())
						FileUtil.mkdir(newProgramDir);
					
					if(!newTestsDir.exists())
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

}
