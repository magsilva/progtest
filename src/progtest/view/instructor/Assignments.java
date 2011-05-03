package progtest.view.instructor;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Assignment;
import progtest.common.Course;
import progtest.common.User;
import progtest.database.Querier;
import progtest.util.Constants;
import progtest.util.FacesUtil;

public class Assignments {

	private List<Course> courses = new ArrayList<Course>();

	private UIData coursesMenu;

	private List<Assignment> assignments = new ArrayList<Assignment>();

	private UIData assignmentsTable;

	private String activedCourse;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public UIData getCoursesMenu() {
		return coursesMenu;
	}

	public void setCoursesMenu(UIData coursesMenu) {
		this.coursesMenu = coursesMenu;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public UIData getAssignmentsTable() {
		return assignmentsTable;
	}

	public void setAssignmentsTable(UIData assignmentsTable) {
		this.assignmentsTable = assignmentsTable;
	}

	public String getActivedCourse() {
		return activedCourse;
	}

	public void setActivedCourse(String activedCourse) {
		this.activedCourse = activedCourse;
	}

	public Assignments() {
		refresh();
	}

	public String selectAllCourses() {
		Course course = null;
		FacesUtil.setSession(Constants.SESSION_COURSE, course);
		refresh();
		return Constants.ACTION_SELECT;
	}

	public String selectMenuCourse() {
		Course course = (Course) coursesMenu.getRowData();
		FacesUtil.setSession(Constants.SESSION_COURSE, course);
		refresh();
		return Constants.ACTION_SELECT;
	}

	private void refresh() {

		User user = (User) FacesUtil.getSession(Constants.SESSION_USER);

		courses = Querier.getCoursesAsInstructor(user);

		Course course = (Course) FacesUtil
				.getSession(Constants.SESSION_COURSE);

		if (course != null) {
			
			activedCourse = course.getName();
			assignments = Querier.getAssignments(course);
			
		} else {
			
			activedCourse = null;
			assignments.clear();
			
			for(Course c: courses)
				assignments.addAll(Querier.getAssignments(c));
			
		}

	}

	public String create() {
		return Constants.ACTION_CREATE;
	}

	public String add() {
		return Constants.ACTION_ADD;
	}

	public String view() {
		FacesUtil.setSession(Constants.SESSION_ASSIGNMENT, assignmentsTable
				.getRowData());
		return Constants.ACTION_VIEW;
	}

}
