package progtest.view.instructor;

import java.util.Date;

import javax.faces.application.FacesMessage;

import progtest.common.Course;
import progtest.common.User;
import progtest.database.CourseDAO;
import progtest.util.Constants;
import progtest.util.ContextManager;

public class CreateCourse {

	private String name = Constants.EMPTY;

	private Date startDate = new Date();

	private Date endDate = new Date();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String create() {
		
		if(validate()) {
			
			Course course = new Course();
			course.setName(name);
			course.setStartDate(startDate);
			course.setEndDate(endDate);
			
			User user = (User) ContextManager.getSession(Constants.SESSION_USER);
			course.setInstructor(user);
			
			CourseDAO.insert(course);
			
			return Constants.ACTION_SUCCESS;
			
		}
		
		return Constants.ACTION_FAILURE;
		
	}

	private boolean validate() {
		
		if(name.equals(Constants.EMPTY)) {
			
			ContextManager.addMessage(Constants.KEY_ERROR_EMPTYBLANKS,
					FacesMessage.SEVERITY_ERROR);
			
		} else if(startDate.getTime() > endDate.getTime()) {
			
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
