package progtest.view;

import progtest.util.Constants;
import progtest.util.ContextManager;

public class Logoff {
	
	public String logoff() {
		ContextManager.setSession(Constants.SESSION_USER, null);
		ContextManager.setSession(Constants.SESSION_COURSE, null);
		ContextManager.setSession(Constants.SESSION_ASSIGNMENT, null);
		ContextManager.setSession(Constants.SESSION_STUDENT, null);
		ContextManager.setSession(Constants.SESSION_EVALUATION, null);
		ContextManager.setSession(Constants.SESSION_ORACLE, null);
		return Constants.ACTION_LOGOFF;
	}

}
