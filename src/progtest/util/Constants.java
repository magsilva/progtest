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
			+ File.separator + ".." + File.separator + "..";

	public static final String PATH_LIBRARY = PATH_ROOT + File.separator
			+ "WEB-INF" + File.separator + "lib";

	public static final String PATH_UPLOAD = PATH_ROOT + File.separator
			+ "upload";

	public static final String PATH_ORACLES = PATH_ROOT + File.separator
			+ "oracles";

	public static final String PATH_COMPILERS = PATH_ROOT + File.separator
			+ "compilers";

	public static final String PATH_TOOLS = PATH_ROOT + File.separator
			+ "tools";

	public static final String PATH_COMPILER = PATH_ROOT + File.separator
			+ "compilers";

	/* Extensions */
	
	public static final String EXTENSION_XML = ".xml";

	/* Bundles */

	public static final String BUNDLE_PROGTEST = "progtest";
	public static final String BUNDLE_MESSAGES = "messages";
	public static final String BUNDLE_LOGGER = "logger";
	
	/* Values */
	
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
	public static final String ACTION_VIEW_ASSIGNMENT = "viewAssignment";
	public static final String ACTION_VIEW_STUDENT = "viewStudent";
	public static final String ACTION_CREATE = "create";
	public static final String ACTION_ADD = "add";
	public static final String ACTION_EDIT = "edit";
	public static final String ACTION_REMOVE = "remove";
	public static final String ACTION_SEND = "send";
	public static final String ACTION_RECIVE = "recive";

	/* Roles */

	public static final String ROLE_STUDENT = "student";
	public static final String ROLE_INSTRUCTOR = "instructor";

}