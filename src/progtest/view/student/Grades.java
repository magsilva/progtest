package progtest.view.student;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Course;
import progtest.common.Evaluation;
import progtest.common.User;
import progtest.database.EvaluationDAO;
import progtest.database.Querier;
import progtest.util.Constants;
import progtest.util.ContextManager;

public class Grades {

	private List<Course> courses = new ArrayList<Course>();

	private UIData coursesTable;

	private List<Evaluation> evaluations = new ArrayList<Evaluation>();

	private UIData evaluationsTable;

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

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public UIData getEvaluationsTable() {
		return evaluationsTable;
	}

	public void setEvaluationsTable(UIData evaluationsTable) {
		this.evaluationsTable = evaluationsTable;
	}

	public String getActivedCourse() {
		return activedCourse;
	}

	public void setActivedCourse(String activedCourse) {
		this.activedCourse = activedCourse;
	}

	public Grades() {
		refresh();
	}

	public String selectAllCourses() {
		ContextManager.setSession(Constants.SESSION_COURSE, null);
		refresh();
		return Constants.ACTION_SELECT;
	}

	public String selectCourse() {
		Course course = (Course) coursesTable.getRowData();
		ContextManager.setSession(Constants.SESSION_COURSE, course);
		refresh();
		return Constants.ACTION_SELECT;
	}

	public String back() {
		return Constants.ACTION_BACK;
	}

	private void refresh() {

		User user = (User) ContextManager.getSession(Constants.SESSION_USER);
		Course course = (Course) ContextManager
				.getSession(Constants.SESSION_COURSE);

		courses = Querier.getCoursesAsStudent(user);

		if (course == null) {

			evaluations = EvaluationDAO.getEvaluations(user);
			activedCourse = null;

		} else {

			evaluations = EvaluationDAO.getEvaluations(user, course);
			activedCourse = course.getName();

		}

	}

}
