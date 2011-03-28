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

public class Courses {

	private List<Course> courses = new ArrayList<Course>();

	private List<Assignment> assignments = new ArrayList<Assignment>();

	private List<User> students = new ArrayList<User>();

	private UIData coursesMenu;

	private UIData coursesTable;

	private UIData assignmentsTable;

	private UIData studentsTable;

	private Course course = null;

	private String activedCourse;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public List<User> getStudents() {
		return students;
	}

	public void setStudents(List<User> students) {
		this.students = students;
	}

	public UIData getCoursesMenu() {
		return coursesMenu;
	}

	public void setCoursesMenu(UIData coursesMenu) {
		this.coursesMenu = coursesMenu;
	}

	public UIData getCoursesTable() {
		return coursesTable;
	}

	public void setCoursesTable(UIData coursesTable) {
		this.coursesTable = coursesTable;
	}

	public UIData getAssignmentsTable() {
		return assignmentsTable;
	}

	public void setAssignmentsTable(UIData assignmentsTable) {
		this.assignmentsTable = assignmentsTable;
	}

	public UIData getStudentsTable() {
		return studentsTable;
	}

	public void setStudentsTable(UIData studentsTable) {
		this.studentsTable = studentsTable;
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

	public Courses() {
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

	public String selectTableCourse() {
		Course course = (Course) coursesTable.getRowData();
		FacesUtil.setSession(Constants.SESSION_COURSE, course);
		refresh();
		return Constants.ACTION_SELECT;
	}

	public String viewAssignment() {
		Assignment assignment = (Assignment) assignmentsTable.getRowData();
		FacesUtil.setSession(Constants.SESSION_ASSIGNMENT, assignment);
		return Constants.ACTION_VIEW_ASSIGNMENT;
	}

	public String viewStudent() {
		User student = (User) studentsTable.getRowData();
		FacesUtil.setSession(Constants.SESSION_STUDENT, student);
		return Constants.ACTION_VIEW_STUDENT;
	}

	private void refresh() {
		
		User user = (User) FacesUtil.getSession(Constants.SESSION_USER);
		
		courses = Querier.getCoursesAsInstructor(user);
		
		Course course = (Course) FacesUtil
				.getSession(Constants.SESSION_COURSE);
		
		if(course != null) {
			
			activedCourse = course.getName();
			
			assignments = Querier.getAssignments(course);
			students = Querier.getStudents(course);
		
		} else
			activedCourse = null;
		
		this.course = course; 
		
	}
	
	public String create() {
		return Constants.ACTION_CREATE;
	}
	
	public String edit() {
		return Constants.ACTION_EDIT;
	}
	
	public String remove() {
		return Constants.ACTION_REMOVE;
	}

}
