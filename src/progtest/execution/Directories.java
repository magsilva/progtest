package progtest.execution;

import java.io.File;

import progtest.common.Assignment;
import progtest.common.Oracle;
import progtest.common.Tool;
import progtest.common.User;
import progtest.util.BundleUtil;
import progtest.util.Constants;

public class Directories {
	
	private static final String LABEL_COURSE = "course";
	
	private static final String LABEL_ASSIGNMENT = "assignment";
	
	private static final String LABEL_STUDENT = "student";
	
	private static final String LABEL_TOOL = "tool";

	private static final String DIR_ORACLE = "oracle";

	//private static final String DIR_STUDENTS = "students";

	private static final String DIR_PACKAGE = "package";

	private static final String DIR_SOURCE = "source";

	private static final String DIR_PROGRAM = "program";

	private static final String DIR_TESTS = "tests";

	private static final String DIR_REPORTS = "reports";

	//private static final String FILE_OUTPUT = "output";

	private static final String DIR_SRC = "src";

	private static final String DIR_BIN = "bin";

	private static final String DIR_PROG = "prog";

	private static final String DIR_TEST = "test";

	private static final String DIR_INST = "inst";

	private static final String DIR_LIB = "lib";

	private static final String DIR_TMP = "tmp";

	private static final String DIR_RPT = "rpt";

	private static final String DIR_PITI = "pi-ti";

	private static final String DIR_PSTS = "ps-ts";

	private static final String DIR_PITS = "pi-ts";

	private static final String DIR_PSTI = "ps-ti";

	//private static final String FILE_OUT = "out";

	public static String getUploadDirPath(Assignment assignment) {
		return BundleUtil.getString(Constants.BUNDLE_PROGTEST, "upload.directory.path");
	}

	public static String getCourseDirPath(Assignment assignment) {
		return getUploadDirPath(assignment) + File.separator + LABEL_COURSE
				+ assignment.getCourse().getIdCode();
	}

	public static String getAssignmentDirPath(Assignment assignment) {
		return getCourseDirPath(assignment) + File.separator + LABEL_ASSIGNMENT
				+ assignment.getIdCode();
	}

	public static String getOracleDirPath(Assignment assignment) {
		return getAssignmentDirPath(assignment) + File.separator + DIR_ORACLE;
	}

	public static String getPackageDirPath(Assignment assignment) {
		return getOracleDirPath(assignment) + File.separator + DIR_PACKAGE;
	}

	public static String getSourceDirPath(Assignment assignment) {
		return getOracleDirPath(assignment) + File.separator + DIR_SOURCE;
	}

	public static String getProgramDirPath(Assignment assignment) {
		return getOracleDirPath(assignment) + File.separator + DIR_PROGRAM;
	}

	public static String getTestsDirPath(Assignment assignment) {
		return getOracleDirPath(assignment) + File.separator + DIR_TESTS;

	}

	public static String getReportsDirPath(Assignment assignment) {
		return getOracleDirPath(assignment) + File.separator + DIR_REPORTS;
	}

	public static String getPitiDirPath(Assignment assignment) {
		return getReportsDirPath(assignment) + File.separator + DIR_PITI;
	}

	/*public static String getPitiReportsDirPath(Assignment assignment) {
		return getPitiDirPath(assignment) + File.separator + DIR_REPORTS;
	}*/

	/*public static String getPitiOutputFilePath(Assignment assignment) {
		return getPitiDirPath(assignment) + File.separator + FILE_OUTPUT;
	}*/

	/*public static String getStudentsDirPath(Assignment assignment) {
		return getAssignmentDirPath(assignment) + File.separator + DIR_STUDENTS;
	}*/

	/*public static String getOracleReportsDirPath(Assignment assignment) {
		return getOracleDirPath(assignment) + File.separator + DIR_REPORTS;
	}*/

	/*public static String getOracleOutputFilePath(Assignment assignment) {
		return getOracleDirPath(assignment) + File.separator + FILE_OUTPUT;
	}*/

	public static String getStudentDirPath(Assignment assignment, User student) {
		return getAssignmentDirPath(assignment) + File.separator + LABEL_STUDENT
				+ student.getIdCode();
	}

	public static String getPackageDirPath(Assignment assignment, User student) {
		return getStudentDirPath(assignment, student) + File.separator
				+ DIR_PACKAGE;
	}

	public static String getSourceDirPath(Assignment assignment, User student) {
		return getStudentDirPath(assignment, student) + File.separator
				+ DIR_SOURCE;
	}

	public static String getProgramDirPath(Assignment assignment, User student) {
		return getStudentDirPath(assignment, student) + File.separator
				+ DIR_PROGRAM;
	}

	public static String getTestsDirPath(Assignment assignment, User student) {
		return getStudentDirPath(assignment, student) + File.separator
				+ DIR_TESTS;

	}

	public static String getReportsDirPath(Assignment assignment, User student) {
		return getStudentDirPath(assignment, student) + File.separator
				+ DIR_REPORTS;
	}

	public static String getPstsDirPath(Assignment assignment, User student) {
		return getReportsDirPath(assignment, student) + File.separator
				+ DIR_PSTS;
	}

	/*public static String getPstsReportsDirPath(Assignment assignment, User student) {
		return getPstsDirPath(assignment, student) + File.separator + DIR_REPORTS;
	}*/

	/*public static String getPstsOutputFilePath(Assignment assignment, User student) {
		return getPstsDirPath(assignment, student) + File.separator + FILE_OUTPUT;
	}*/

	public static String getPitsDirPath(Assignment assignment, User student) {
		return getReportsDirPath(assignment, student) + File.separator
				+ DIR_PITS;
	}

	/*public static String getPitsReportsDirPath(Assignment assignment, User student) {
		return getPitsDirPath(assignment, student) + File.separator + DIR_REPORTS;
	}*/

	/*public static String getPitsOutputFilePath(Assignment assignment, User student) {
		return getPitsDirPath(assignment, student) + File.separator + FILE_OUTPUT;
	}*/

	public static String getPstiDirPath(Assignment assignment, User student) {
		return getStudentDirPath(assignment, student) + File.separator
				+ DIR_PSTI;
	}

	/*public static String getPstiReportsDirPath(Assignment assignment, User student) {
		return getPstiDirPath(assignment, student) + File.separator + DIR_REPORTS;
	}*/

	/*public static String getPstiOutputFilePath(Assignment assignment, User student) {
		return getPstiDirPath(assignment, student) + File.separator + FILE_OUTPUT;
	}*/

	/*public static String getStudentReportsDirPath(Assignment assignment, User student) {
		return getStudentDirPath(assignment, student) + File.separator + DIR_REPORTS;
	}*/

	/*public static String getStudentOutputFilePath(Assignment assignment, User student) {
		return getStudentDirPath(assignment, student) + File.separator + FILE_OUTPUT;
	}*/
	

	public static String getToolReportsDirPath(File reportsDir, Tool tool) {
		return reportsDir + File.separator
				+ LABEL_TOOL + tool.getIdCode();
	}

	/*public static String getToolReportsDirPath(File outputDir, Tool tool) {
		return getToolDirPath(outputDir, tool) + File.separator
				+ DIR_REPORTS;
	}*/

	/*public static String getToolOutputFilePath(File outputDir, Tool tool) {
		return getToolDirPath(outputDir, tool) + File.separator
				+ FILE_OUTPUT;
	}*/

	public static String getToolDirPath(File rootDir, Tool tool) {
		return rootDir.getPath() + File.separator + LABEL_TOOL + tool.getIdCode();
	}

	public static String getSrcDirPath(File rootDir, Tool tool) {
		return getToolDirPath(rootDir, tool) + File.separator + DIR_SRC;
	}

	public static String getBinDirPath(File rootDir, Tool tool) {
		return getToolDirPath(rootDir, tool) + File.separator + DIR_BIN;
	}

	public static String getProgDirPath(File rootDir, Tool tool) {
		return getToolDirPath(rootDir, tool) + File.separator + DIR_PROG;
	}

	public static String getTestDirPath(File rootDir, Tool tool) {
		return getToolDirPath(rootDir, tool) + File.separator + DIR_TEST;
	}

	public static String getInstDirPath(File rootDir, Tool tool) {
		return getToolDirPath(rootDir, tool) + File.separator + DIR_INST;
	}

	public static String getLibDirPath(File rootDir, Tool tool) {
		return getToolDirPath(rootDir, tool) + File.separator + DIR_LIB;
	}

	public static String getTmpDirPath(File rootDir, Tool tool) {
		return getToolDirPath(rootDir, tool) + File.separator + DIR_TMP;
	}

	public static String getRptDirPath(File rootDir, Tool tool) {
		return getToolDirPath(rootDir, tool) + File.separator + DIR_RPT;
	}

	/*public static String getOutFilePath(File rootDir, Tool tool) {
		return getToolDirPath(rootDir, tool) + File.separator + FILE_OUT;
	}*/


	public static String getOracleFilePath(Oracle oracle) {
		return Constants.PATH_ORACLES + File.separator + oracle.getIdCode()
				+ ".jar";
	}

	public static String getToolFilePath(Tool tool) {
		return Constants.PATH_TOOLS + File.separator + tool.getIdCode()
				+ ".jar";
	}

}
