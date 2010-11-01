package progtest.view.instructor;

import java.util.Date;

import progtest.common.Assignment;
import progtest.database.AssignmentDAO;
import progtest.util.Constants;
import progtest.util.FacesUtil;

public class RemoveAssignment {
	
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
	
	public RemoveAssignment() {
		Assignment assignment = (Assignment) FacesUtil.getSession(Constants.SESSION_ASSIGNMENT);
		title = assignment.getTitle();
		description = assignment.getDescription();
		startDate = assignment.getStartDate();
		endDate = assignment.getEndDate();
	}
	
	public String remove() {
		
		Assignment assignment = (Assignment) FacesUtil.getSession(Constants.SESSION_ASSIGNMENT);
		
		AssignmentDAO.delete(assignment);
		
		return Constants.ACTION_SUCCESS;
	
	}
	
	public String cancel() {
		return Constants.ACTION_CANCEL;
	}

}
