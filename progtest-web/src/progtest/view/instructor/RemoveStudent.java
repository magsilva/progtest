package progtest.view.instructor;

import java.util.ArrayList;
import java.util.List;

import progtest.common.Course;
import progtest.common.User;
import progtest.database.Querier;
import progtest.database.UserDAO;
import progtest.util.Constants;
import progtest.util.FacesUtil;

public class RemoveStudent {

	private String userName = Constants.EMPTY;

	private String name = Constants.EMPTY;

	private String email = Constants.EMPTY;

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

	public RemoveStudent() {

		User user = (User) FacesUtil.getSession(Constants.SESSION_STUDENT);

		userName = user.getUserName();
		name = user.getName();
		email = user.getEmail();

	}

	public String remove() {

		User student = (User) FacesUtil.getSession(Constants.SESSION_STUDENT);

		Course course = (Course) FacesUtil.getSession(Constants.SESSION_COURSE);

		List<Course> courses = Querier.getCoursesAsStudent(student);
		
		List<Course> newCourses = new ArrayList<Course>();
		
		for (Course c: courses)
			if(c.getIdCode() != course.getIdCode())
				newCourses.add(c);
		
		student.setCoursesAsStudent(newCourses);
		
		UserDAO.update(student);

		return Constants.ACTION_SUCCESS;

	}

	public String cancel() {
		return Constants.ACTION_CANCEL;
	}

}
