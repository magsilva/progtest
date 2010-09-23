package progtest.execution;

import java.io.File;

import progtest.common.Assignment;
import progtest.common.Tool;
import progtest.common.User;
import progtest.util.Constants;

public class DirControl {

	private static final String DIR_ORACLE = "oracle";

	private static final String DIR_STUDENTS = "students";

	private static final String DIR_PACKAGE = "package";

	private static final String DIR_PROGRAM = "program";

	private static final String DIR_TESTS = "tests";

	private static final String DIR_REPORTS = "reports";

	private static final String DIR_SRC = "src";

	private static final String DIR_BIN = "bin";

	private static final String DIR_PROG = "prog";

	private static final String DIR_TEST = "test";

	private static final String DIR_INST = "inst";

	private static final String DIR_LIB = "lib";

	private static final String DIR_RPT = "rpt";

	private static final String DIR_PSTS = "ps-ts";

	private static final String DIR_PITS = "pi-ts";

	private static final String DIR_PSTI = "ps-ti";

	public static String getStorageDirPath(Assignment assignment) {
		return Constants.PATH_UPLOAD;
	}

	public static String getCourseDirPath(Assignment assignment) {
		return getStorageDirPath(assignment) + File.separator
				+ assignment.getCourse().getIdCode();
	}

	public static String getAssignmentDirPath(Assignment assignment) {
		return getCourseDirPath(assignment) + File.separator
				+ assignment.getIdCode();
	}

	public static String getOracleDirPath(Assignment assignment) {
		return getAssignmentDirPath(assignment) + File.separator + DIR_ORACLE;
	}

	public static String getPackageDirPath(Assignment assignment) {
		return getOracleDirPath(assignment) + File.separator + DIR_PACKAGE;
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

	public static String getToolDirPath(Assignment assignment, Tool tool) {
		return getOracleDirPath(assignment) + File.separator + tool.getIdCode();
	}

	public static String getSrcDirPath(Assignment assignment, Tool tool) {
		return getToolDirPath(assignment, tool) + File.separator + DIR_SRC;
	}

	public static String getBinDirPath(Assignment assignment, Tool tool) {
		return getToolDirPath(assignment, tool) + File.separator + DIR_BIN;
	}

	public static String getProgDirPath(Assignment assignment, Tool tool) {
		return getToolDirPath(assignment, tool) + File.separator + DIR_PROG;
	}

	public static String getTestDirPath(Assignment assignment, Tool tool) {
		return getToolDirPath(assignment, tool) + File.separator + DIR_TEST;
	}

	public static String getInstDirPath(Assignment assignment, Tool tool) {
		return getToolDirPath(assignment, tool) + File.separator + DIR_INST;
	}

	public static String getLibDirPath(Assignment assignment, Tool tool) {
		return getToolDirPath(assignment, tool) + File.separator + DIR_LIB;
	}

	public static String getRptDirPath(Assignment assignment, Tool tool) {
		return getToolDirPath(assignment, tool) + File.separator + DIR_RPT;
	}

	public static String getStudentsDirPath(Assignment assignment) {
		return getAssignmentDirPath(assignment) + File.separator + DIR_STUDENTS;
	}

	public static String getStudentDirPath(Assignment assignment, User student) {
		return getAssignmentDirPath(assignment) + File.separator
				+ student.getIdCode();
	}

	public static String getPackageDirPath(Assignment assignment, User student) {
		return getStudentDirPath(assignment, student) + File.separator
				+ DIR_PACKAGE;
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

	public static String getPitsDirPath(Assignment assignment, User student) {
		return getReportsDirPath(assignment, student) + File.separator
				+ DIR_PITS;
	}

	public static String getPstiDirPath(Assignment assignment, User student) {
		return getReportsDirPath(assignment, student) + File.separator
				+ DIR_PSTI;
	}

	public static String getToolDirPath(Assignment assignment, User student,
			Tool tool) {
		return getStudentDirPath(assignment, student) + File.separator
				+ tool.getIdCode();
	}

	public static String getSrcDirPath(Assignment assignment, User student,
			Tool tool) {
		return getToolDirPath(assignment, student, tool) + File.separator
				+ DIR_SRC;
	}

	public static String getBinDirPath(Assignment assignment, User student,
			Tool tool) {
		return getToolDirPath(assignment, student, tool) + File.separator
				+ DIR_BIN;
	}

	public static String getProgDirPath(Assignment assignment, User student,
			Tool tool) {
		return getToolDirPath(assignment, student, tool) + File.separator
				+ DIR_PROG;
	}

	public static String getTestDirPath(Assignment assignment, User student,
			Tool tool) {
		return getToolDirPath(assignment, student, tool) + File.separator
				+ DIR_TEST;
	}

	public static String getInstDirPath(Assignment assignment, User student,
			Tool tool) {
		return getToolDirPath(assignment, student, tool) + File.separator
				+ DIR_INST;
	}

	public static String getLibDirPath(Assignment assignment, User student,
			Tool tool) {
		return getToolDirPath(assignment, student, tool) + File.separator
				+ DIR_LIB;
	}

	public static String getRptDirPath(Assignment assignment, User student,
			Tool tool) {
		return getToolDirPath(assignment, student, tool) + File.separator
				+ DIR_RPT;
	}

}
