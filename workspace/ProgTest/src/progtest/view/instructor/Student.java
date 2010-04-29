package progtest.view.instructor;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Evaluation;
import progtest.common.Course;
import progtest.common.User;
import progtest.database.EvaluationDAO;
import progtest.util.Constants;
import progtest.util.ContextManager;

public class Student {

	private int viewId = 0;

	private String userName = Constants.EMPTY;

	private String name = Constants.EMPTY;

	private String email = Constants.EMPTY;

	private List<Evaluation> evaluations = new ArrayList<Evaluation>(0);

	private UIData evaluationsTable;

	public int getViewId() {
		return viewId;
	}

	public void setViewId(int viewId) {
		this.viewId = viewId;
	}

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

	public Student() {

		User user = (User) ContextManager.getSession(Constants.SESSION_STUDENT);

		Course course = (Course) ContextManager
				.getSession(Constants.SESSION_COURSE);

		evaluations = EvaluationDAO.getEvaluations(user, course);

		userName = user.getUserName();
		name = user.getName();
		email = user.getEmail();

		selectAboutView();

	}

	public String selectAboutView() {
		viewId = 0;
		return Constants.ACTION_SELECT;
	}

	public String selectGradesView() {
		viewId = 1;
		return Constants.ACTION_SELECT;
	}

	public String remove() {
		return Constants.ACTION_REMOVE;
	}

}
