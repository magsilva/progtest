package progtest.view.instructor;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;

import progtest.common.Course;
import progtest.common.Submission;
import progtest.common.User;
import progtest.database.Querier;
import progtest.util.Constants;
import progtest.util.FacesUtil;

public class Student {

	private int viewId = 0;

	private String userName = Constants.EMPTY;

	private String name = Constants.EMPTY;

	private String email = Constants.EMPTY;

	private List<Submission> submissions = new ArrayList<Submission>(0);

	private UIData submissionsTable;

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

	public Student() {

		User user = (User) FacesUtil.getSession(Constants.SESSION_STUDENT);

		Course course = (Course) FacesUtil
				.getSession(Constants.SESSION_COURSE);

		submissions = Querier.getEvaluations(user, course);

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
		return Constants.ACTION_REMOVE_STUDENT;
	}

	public String back() {
		return Constants.ACTION_BACK;
	}

}
