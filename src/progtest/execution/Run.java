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
import progtest.exceptions.NotFoundApplicationException;
import progtest.exceptions.NotFoundTestCasesException;
import progtest.util.Constants;
import progtest.util.FileUpload;
import progtest.util.FileUtil;
import progtest.util.TestCaseUtil;

public class Run {

	public static void run(Assignment assignment, UploadedFile uf)
			throws IllegalArgumentException, IOException,
			NotFoundTestCasesException, NotFoundApplicationException {

		File assignmentDir = new File(DirControl.getAssignmentDirPath(assignment));

		File packageDir = new File(DirControl.getPackageDirPath(assignment));

		File programDir = new File(DirControl.getProgramDirPath(assignment));

		File testsDir = new File(DirControl.getTestsDirPath(assignment));

		upload(uf, assignmentDir, packageDir, programDir, testsDir);
		
		execute(assignment);

	}

	public static void run(Assignment assignment, Oracle oracle)
			throws IOException, NotFoundTestCasesException, NotFoundApplicationException {
		
		File oracleFile = new File(DirControl.getOracleFilePath(oracle));

		File assignmentDir = new File(DirControl.getAssignmentDirPath(assignment));

		File packageDir = new File(DirControl.getPackageDirPath(assignment));

		File programDir = new File(DirControl.getProgramDirPath(assignment));

		File testsDir = new File(DirControl.getTestsDirPath(assignment));
		
		FileUtil.clean(assignmentDir);

		upload(oracleFile, assignmentDir, packageDir, programDir, testsDir);
		
		execute(assignment);
		
	}

	public static void run(Evaluation evaluation, UploadedFile uf) {
		
	}

	private static void upload(UploadedFile uf, File assignmentDir,
			File packageDir, File programDir, File testsDir)
			throws IllegalArgumentException, IOException,
			NotFoundTestCasesException, NotFoundApplicationException {

		File savedFile = FileUpload.save(uf, packageDir);
		
		split(savedFile, programDir, testsDir);

	}
	
	private static void upload(File oracleFile, File assignmentDir,
			File packageDir, File programDir, File testsDir)
			throws IOException, NotFoundTestCasesException, NotFoundApplicationException {

		File copiedFile = FileUtil.copy(oracleFile, packageDir);
		
		split(copiedFile, programDir, testsDir);
		
	}
	
	private static void split(File zipFile, File programDir, File testsDir) throws IOException, NotFoundTestCasesException, NotFoundApplicationException {

		FileUtil.unzip(zipFile, programDir);

		FileUtil.unzip(zipFile, testsDir);

		for (File file : FileUtil.listFiles(programDir))
			if (TestCaseUtil.isTestCase(file))
				file.delete();

		for (File file : FileUtil.listFiles(testsDir))
			if (!file.getName().endsWith(Constants.EXTENSION_JAVA)
					|| !TestCaseUtil.isTestCase(file))
				file.delete();

		if (FileUtil.listFiles(testsDir, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundTestCasesException();

		if (FileUtil.listFiles(programDir, Constants.EXTENSION_JAVA) == null)
			throw new NotFoundApplicationException();
		
	}
	
	private static void execute(Assignment assignment) {

		for (Tool tool : listTools(assignment)) {
			makeDirectories(assignment, tool);
			preprocess(assignment, tool);
			compile(assignment);
			postprocess(assignment, tool);
			generageReports(assignment, tool);
		}
		
	}

	private static List<Tool> listTools(Assignment assignment) {

		List<Tool> tools = new ArrayList<Tool>();

		for (Criterion criterion : assignment.getCriteria())
			if (!tools.contains(criterion.getTool()))
				tools.add(criterion.getTool());

		return tools;

	}

	private static void makeDirectories(Assignment assignment, Tool tool) {

	}

	private static void preprocess(Assignment assignment, Tool tool) {
		// File preprocessFile = DirControl
		// .getToolPreprocessFile(assignment, tool);
		// process(assignment, tool, preprocessFile);
	}

	private static void compile(Assignment assignment) {

	}

	private static void postprocess(Assignment assignment, Tool tool) {
		// File postprocessFile = DirControl.getToolPostprocessFile(assignment,
		// tool);
		// process(assignment, tool, postprocessFile);
	}

	private static void generageReports(Assignment assignment, Tool tool) {

	}

	private static void process(Assignment assignment, Tool tool,
			File processFile) throws IOException {

		/*
		 * FileInputStream fis = new FileInputStream(processFile);
		 * DataInputStream dis = new DataInputStream(fis); InputStreamReader isr
		 * = new InputStreamReader(dis); BufferedReader br = new
		 * BufferedReader(isr);
		 * 
		 * while (br.ready()) {
		 * 
		 * String args[] = br.readLine().split(" ");
		 * 
		 * }
		 */

	}

}
