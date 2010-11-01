package progtest.view.student;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Course;
import progtest.common.User;
import progtest.database.Querier;
import progtest.util.Constants;
import progtest.util.FacesUtil;

public class CoursesInfo {

	private List<Course> courses = new ArrayList<Course>();

	private UIData coursesTable;

	private Course course = null;

	private String activedCourse;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public UIData getCoursesTable() {
		return coursesTable;
	}

	public void setCoursesTable(UIData coursesTable) {
		this.coursesTable = coursesTable;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getActivedCourse() {
		return activedCourse;
	}

	public void setActivedCourse(String activedCourse) {
		this.activedCourse = activedCourse;
	}

	public CoursesInfo() {
		refresh();
	}

	public String selectCourse() {
		Course course = (Course) coursesTable.getRowData();
		FacesUtil.setSession(Constants.SESSION_COURSE, course);
		refresh();
		return Constants.ACTION_SELECT;
	}

	public String back() {
		return Constants.ACTION_BACK;
	}

	private void refresh() {
		
		User user = (User) FacesUtil.getSession(Constants.SESSION_USER);
		
		courses = Querier.getCoursesAsStudent(user);
		
		Course course = (Course) FacesUtil
				.getSession(Constants.SESSION_COURSE);
		
		if(course != null)
			activedCourse = course.getName();
		else
			activedCourse = null;
		
		this.course = course; 
		
	}

}
