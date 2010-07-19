package progtest.view.instructor;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Course;
import progtest.common.User;
import progtest.database.Querier;
import progtest.util.Constants;
import progtest.util.ContextManager;

public class Students {

	private List<Course> courses = new ArrayList<Course>();

	private UIData coursesTable;

	private List<User> students = new ArrayList<User>();

	private UIData studentsTable;

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

	public List<User> getStudents() {
		return students;
	}

	public void setStudents(List<User> students) {
		this.students = students;
	}

	public UIData getStudentsTable() {
		return studentsTable;
	}

	public void setStudentsTable(UIData studentsTable) {
		this.studentsTable = studentsTable;
	}

	public String getActivedCourse() {
		return activedCourse;
	}

	public void setActivedCourse(String activedCourse) {
		this.activedCourse = activedCourse;
	}

	public Students() {
		refresh();
	}

	public String selectCourse() {
		Course course = (Course) coursesTable.getRowData();
		ContextManager.setSession(Constants.SESSION_COURSE, course);
		refresh();
		return Constants.ACTION_SELECT;
	}

	private void refresh() {

		User user = (User) ContextManager.getSession(Constants.SESSION_USER);

		courses = Querier.getCoursesAsInstructor(user);

		Course course = (Course) ContextManager
				.getSession(Constants.SESSION_COURSE);

		if (course != null) {
			activedCourse = course.getName();
			students = Querier.getStudents(course);
		} else {
			activedCourse = null;
			students.clear();
		}

	}

	public String register() {
		return Constants.ACTION_REGISTER;
	}

	public String add() {
		return Constants.ACTION_ADD;
	}

	public String view() {
		ContextManager.setSession(Constants.SESSION_STUDENT, studentsTable
				.getRowData());
		return Constants.ACTION_VIEW;
	}

}
