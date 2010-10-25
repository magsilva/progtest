package progtest.view.instructor;

import java.util.Date;

import javax.faces.application.FacesMessage;

import progtest.common.Assignment;
import progtest.database.AssignmentDAO;
import progtest.util.Constants;
import progtest.util.ContextManager;

public class EditAssignment {

	private String title = Constants.EMPTY;

	private String description = Constants.EMPTY;

	private Date startDate = new Date();

	private Date endDate = new Date();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public EditAssignment() {
		Assignment assignment = (Assignment) ContextManager
				.getSession(Constants.SESSION_ASSIGNMENT);
		title = assignment.getTitle();
		description = assignment.getDescription();
		startDate = assignment.getStartDate();
		endDate = assignment.getEndDate();
	}

	public String edit() {

		if (validate()) {

			Assignment assignment = (Assignment) ContextManager
					.getSession(Constants.SESSION_ASSIGNMENT);
			
			assignment.setTitle(title);
			assignment.setDescription(description);
			assignment.setStartDate(startDate);
			assignment.setEndDate(endDate);
			
			AssignmentDAO.update(assignment);
			
			ContextManager.setSession(Constants.SESSION_ASSIGNMENT, assignment);

			return Constants.ACTION_SUCCESS;

		}

		return Constants.ACTION_FAILURE;

	}

	private boolean validate() {

		if (title.equals(Constants.EMPTY)
				|| description.equals(Constants.EMPTY)) {

			ContextManager.addMessage(Constants.KEY_ERROR_EMPTYBLANKS,
					FacesMessage.SEVERITY_ERROR);

		} else if (startDate.getTime() > endDate.getTime()) {

			ContextManager.addMessage(Constants.KEY_ERROR_DATEINCONSISTENT,
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
