package progtest.view;

import javax.faces.application.FacesMessage;

import progtest.common.User;
import progtest.database.Querier;
import progtest.util.Constants;
import progtest.util.FacesUtil;

public class Login {

	private String userName = Constants.EMPTY;

	private String password = Constants.EMPTY;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		
		if (validate()) {
			
			User user = Querier.getUser(userName);
			FacesUtil.setSession(Constants.SESSION_USER, user);
			
			if(user.getRole().equals(Constants.ROLE_STUDENT))
				return Constants.ACTION_STUDENTHOME;
			
			if(user.getRole().equals(Constants.ROLE_INSTRUCTOR))
				return Constants.ACTION_INSTRUCTORHOME;
		
		}
		
		return Constants.ACTION_FAILURE;
		
	}
	
	private boolean validate() {
		
		if (userName.equals(Constants.EMPTY)
				|| (password.equals(Constants.EMPTY))) {

			FacesUtil.addMessage(Constants.KEY_ERROR_EMPTYBLANKS,
					FacesMessage.SEVERITY_ERROR);

		} else if (!Querier.checkUserName(userName)) {

			FacesUtil.addMessage(Constants.KEY_ERROR_WRONGUSERNAME,
					FacesMessage.SEVERITY_ERROR);

		} else if (!Querier.checkPassword(userName, password)) {

			FacesUtil.addMessage(Constants.KEY_ERROR_WRONGPASSWORD,
					FacesMessage.SEVERITY_ERROR);

		} else {
			
			return true;
			
		}
		
		return false;
		
	}

	public String register() {
		return Constants.ACTION_REGISTER_STUDENT;
	}

	public String recover() {
		return Constants.ACTION_RECOVER;
	}

}
