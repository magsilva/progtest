package progtest.view;

import javax.faces.application.FacesMessage;

import progtest.common.User;
import progtest.database.Querier;
import progtest.database.UserDAO;
import progtest.util.Constants;
import progtest.util.FacesUtil;

public class Register {

	private String userName = Constants.EMPTY;

	private String name = Constants.EMPTY;

	private String email = Constants.EMPTY;

	private String password = Constants.EMPTY;

	private String confirmationPassword = Constants.EMPTY;

	private String role = Constants.ROLE_STUDENT;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmationPassword() {
		return confirmationPassword;
	}

	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String register() {

		if (validate()) {

			User user = new User();
			user.setUserName(userName);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(role);

			UserDAO.insert(user);

			return Constants.ACTION_SUCCESS;

		}

		return Constants.ACTION_FAILURE;

	}

	private boolean validate() {

		if (userName.equals(Constants.EMPTY) || name.equals(Constants.EMPTY)
				|| email.equals(Constants.EMPTY)
				|| password.equals(Constants.EMPTY)
				|| confirmationPassword.equals(Constants.EMPTY)
				|| role.equals(Constants.EMPTY)) {

			FacesUtil.addMessage(Constants.KEY_ERROR_EMPTYBLANKS,
					FacesMessage.SEVERITY_ERROR);

		} else if (!confirmationPassword.equals(password)) {

			FacesUtil.addMessage(Constants.KEY_ERROR_DIFFERENTPASSWORDS,
					FacesMessage.SEVERITY_ERROR);

		} else if (Querier.checkEmail(email, userName)) {

			FacesUtil.addMessage(Constants.KEY_ERROR_DUPLICATEDEMAIL,
					FacesMessage.SEVERITY_ERROR);

		} else if (Querier.checkUserName(userName)) {

			FacesUtil.addMessage(Constants.KEY_ERROR_DUPLICATEDUSERNAME,
					FacesMessage.SEVERITY_ERROR);

		} else {

			return true;

		}

		return false;
	}

	public String cancel() {
		return Constants.ACTION_CANCEL;
	}

}
