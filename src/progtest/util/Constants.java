package progtest.util;

import java.io.File;

public class Constants {
	
	/* Paths */
	
	public static final String PATH_ROOT = new File(Constants.class
			.getProtectionDomain().getCodeSource().getLocation().getPath())
			.getParent()
			+ File.separator
			+ ".."
			+ File.separator
			+ ".."
			+ File.separator
			+ ".." + File.separator + "..";

	public static final String PATH_LIBRARY = PATH_ROOT + File.separator
			+ "WEB-INF" + File.separator + "lib";

	public static final String PATH_UPLOAD = PATH_ROOT + File.separator
			+ "upload";
	
	public static final String PATH_ORACLES = PATH_ROOT + File.separator
			+ "oracles";
	
	
	/* Directories */
	
	public static final String DIR_PACKAGE = "package";
	public static final String DIR_SOURCE = "source";
	public static final String DIR_BUILD = "build";
	public static final String DIR_REPORTS = "reports";
	public static final String DIR_APPLICATION = "aplication";
	public static final String DIR_TESTSET = "testSet";
	public static final String DIR_ORACLE = "oracle";
	public static final String DIR_JABUTI = "jabuti";
	public static final String DIR_JUNIT = "junit";
	public static final String DIR_TEMP = "temp";
	
	public static final String DIR_PINSTTINST = "pinst_tinst";
	public static final String DIR_PALTAL = "pal_tal";
	public static final String DIR_PINSTTAL = "pinst_tal";
	public static final String DIR_PALTINST = "pal_tinst";
	
	
	/* Files */
	
	public static final String FILE_APPLICATION = "aplication";
	public static final String FILE_TESTSET = "testSet";
	public static final String FILE_TESTSUITE = "testSuite";
	
	
	/* Extensions */

	public static final String EXTENSION_JAR = ".jar";
	public static final String EXTENSION_JAVA = ".java";
	public static final String EXTENSION_CLASS = ".class";
	
	
	/* Values */
	
	public static final String RESOURCE_BUNDLE = "resources.Messages";
	public static final String EMPTY = "";

	
	/* Session */
	
	public static final String SESSION_USER = "user";
	public static final String SESSION_COURSE = "course";
	public static final String SESSION_ASSIGNMENT = "assignment";
	public static final String SESSION_STUDENT = "student";
	public static final String SESSION_ORACLE = "oracle";
	public static final String SESSION_EVALUATION = "evaluation";
	public static final String SESSION_BACKPAGE = "backPage";
	
	
	/* Back Pages */
	
	public static final String BACKPAGE_OUTSTANDING = "outstanding";
	public static final String BACKPAGE_ASSIGNMENTS = "assignments";
	public static final String BACKPAGE_ASSIGNMENT = "assignment";

	
	/* Key */

	public static final String KEY_ERROR_EXPIREDSESSION = "error_expiredSession";
	
	public static final String KEY_ERROR_EMPTYBLANKS = "error_emptyBlanks";
	public static final String KEY_ERROR_WRONGUSERNAME = "error_wrongUserName";
	public static final String KEY_ERROR_WRONGPASSWORD = "error_wrongPassword";
	public static final String KEY_ERROR_DIFFERENTPASSWORDS = "error_differentPasswords";
	public static final String KEY_ERROR_DUPLICATEDUSERNAME = "error_duplicatedUserName";
	public static final String KEY_ERROR_DUPLICATEDEMAIL = "error_duplicatedEmail";
	public static final String KEY_ERROR_DATEINCONSISTENT = "error_dataInconsistent";
	public static final String KEY_ERROR_NOTFOUNDTESTCASES = "error_notFoundTestCases";
	public static final String KEY_ERROR_NOTFOUNDAPPLICATION = "error_notFoundApplication";
	
	public static final String KEY_ERROR_ANYCRITERIONSELECTED = "error_anyCriterionSelected";
	public static final String KEY_ERROR_ANYORACLESELECTED = "error_anyOracleSelected";
	public static final String KEY_ERROR_ANYLANGUAGESELECTED = "error_anyLanguageSelected";
	
	public static final String KEY_ERROR_DECOMPRESSING = "error_Descompressing";
	public static final String KEY_ERROR_COMPILING = "error_Compiling";
	public static final String KEY_ERROR_COMPRESSING = "error_Compressing";
	public static final String KEY_ERROR_UPLOADING = "error_Uploading";
	public static final String KEY_ERROR_TESTING = "error_Testing";
	public static final String KEY_ERROR_RUNNING = "error_Running";
	public static final String KEY_ERROR_EVALUATING = "error_Avaliating";

	
	/* Action */
	
	public static final String ACTION_STUDENTHOME = "studentHome";
	public static final String ACTION_INSTRUCTORHOME = "instructorHome";
	public static final String ACTION_LOGOFF = "logoff";

	public static final String ACTION_SUCCESS = "success";
	public static final String ACTION_FAILURE = "failure";
	public static final String ACTION_BACK = "back";
	public static final String ACTION_CANCEL = "cancel";

	public static final String ACTION_REGISTER = "register";
	public static final String ACTION_RECOVER = "recover";
	public static final String ACTION_SELECT = "select";
	public static final String ACTION_VIEW = "view";
	public static final String ACTION_CREATE = "create";
	public static final String ACTION_ADD = "add";
	public static final String ACTION_EDIT = "edit";
	public static final String ACTION_REMOVE = "remove";
	public static final String ACTION_SEND = "send";
	public static final String ACTION_RECIVE = "recive";

	
	/* Reports */
	
	public static final String REPORT_REPORTS = "reports";
	public static final String REPORT_FUNCIONALCOVERAGE = "funcionalCoverage";
	public static final String REPORT_REQUIREDELEMENTS = "requiredElements";
	public static final String REPORT_METRICS = "metrics";
	public static final String REPORT_CLASSCOVERAGE = "classCoverage";
	public static final String REPORT_METHODCOVERAGE = "methodCoverage";
	public static final String REPORT_CRITERIONCOVERAGE = "criterionCoverage";
	public static final String REPORT_COVEREDANDUNCOVERED = "coveredAndUncovered";
	public static final String REPORT_RESULTAVALIATION = "resultAvaliation";

	
	/* Roles */
	
	public static final String ROLE_STUDENT = "student";
	public static final String ROLE_INSTRUCTOR = "instructor";

}