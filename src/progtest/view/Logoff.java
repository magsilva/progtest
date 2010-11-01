package progtest.view;

import progtest.util.Constants;
import progtest.util.FacesUtil;

public class Logoff {
	
	public String logoff() {
		FacesUtil.setSession(Constants.SESSION_USER, null);
		FacesUtil.setSession(Constants.SESSION_COURSE, null);
		FacesUtil.setSession(Constants.SESSION_ASSIGNMENT, null);
		FacesUtil.setSession(Constants.SESSION_STUDENT, null);
		FacesUtil.setSession(Constants.SESSION_EVALUATION, null);
		FacesUtil.setSession(Constants.SESSION_ORACLE, null);
		return Constants.ACTION_LOGOFF;
	}

}
