package progtest.view.instructor;

import java.util.Date;

import progtest.common.Course;
import progtest.database.CourseDAO;
import progtest.util.Constants;
import progtest.util.FacesUtil;

public class RemoveCourse {

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
	
	public RemoveCourse() {
		Course course = (Course) FacesUtil.getSession(Constants.SESSION_COURSE);
		name = course.getName();
		startDate = course.getStartDate();
		endDate = course.getEndDate();
	}

	public String remove() {
			
		Course course = (Course) FacesUtil.getSession(Constants.SESSION_COURSE);
		
		CourseDAO.delete(course);
		
		FacesUtil.setSession(Constants.SESSION_COURSE, null);
		
		return Constants.ACTION_SUCCESS;
	
	}
	
	public String cancel() {
		return Constants.ACTION_CANCEL;
	}

}
