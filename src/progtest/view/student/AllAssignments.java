package progtest.view.student;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Course;
import progtest.common.Submission;
import progtest.common.User;
import progtest.database.Querier;
import progtest.util.Constants;
import progtest.util.FacesUtil;

public class AllAssignments {

	private List<Course> courses = new ArrayList<Course>();

	private UIData coursesTable;

	private List<Submission> submissions = new ArrayList<Submission>();

	private UIData submissionsTable;

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

	public List<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}

	public UIData getSubmissionsTable() {
		return submissionsTable;
	}

	public void setSubmissionsTable(UIData submissionsTable) {
		this.submissionsTable = submissionsTable;
	}

	public String getActivedCourse() {
		return activedCourse;
	}

	public void setActivedCourse(String activedCourse) {
		this.activedCourse = activedCourse;
	}

	public AllAssignments() {
		refresh();
	}

	public String selectAllCourses() {
		FacesUtil.setSession(Constants.SESSION_COURSE, null);
		refresh();
		return Constants.ACTION_SELECT;
	}

	public String selectCourse() {
		Course course = (Course) coursesTable.getRowData();
		FacesUtil.setSession(Constants.SESSION_COURSE, course);
		refresh();
		return Constants.ACTION_SELECT;
	}

	public String submitAssignment() {
		Submission evaluation = (Submission) submissionsTable.getRowData();
		FacesUtil.setSession(Constants.SESSION_EVALUATION, evaluation);
		FacesUtil.setSession(Constants.SESSION_BACKPAGE,
				Constants.BACKPAGE_ASSIGNMENTS);
		return Constants.ACTION_SEND;
	}

	public String assignmentInfo() {
		Submission evaluation = (Submission) submissionsTable.getRowData();
		FacesUtil.setSession(Constants.SESSION_EVALUATION, evaluation);
		return Constants.ACTION_VIEW;
	}

	public String back() {
		return Constants.ACTION_BACK;
	}

	private void refresh() {

		User user = (User) FacesUtil.getSession(Constants.SESSION_USER);
		Course course = (Course) FacesUtil
				.getSession(Constants.SESSION_COURSE);

		courses = Querier.getCoursesAsStudent(user);

		if (course == null) {

			submissions = Querier.getEvaluations(user);
			activedCourse = null;

		} else {

			submissions = Querier.getEvaluations(user, course);
			activedCourse = course.getName();

		}

	}

}
