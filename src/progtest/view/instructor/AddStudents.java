package progtest.view.instructor;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import progtest.common.Course;
import progtest.common.Enrollment;
import progtest.common.User;
import progtest.database.Querier;
import progtest.database.EnrollmentDAO;
import progtest.util.Constants;
import progtest.util.FacesUtil;

public class AddStudents {

	private String keyword = Constants.EMPTY;

	private SelectItem[] students = new SelectItem[0];

	private SelectItem[] enrolledStudents = new SelectItem[0];

	private List<String> selectedStudents = new ArrayList<String>();

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public SelectItem[] getStudents() {
		return students;
	}

	public void setStudents(SelectItem[] students) {
		this.students = students;
	}

	public SelectItem[] getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(SelectItem[] enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public List<String> getSelectedStudents() {
		return selectedStudents;
	}

	public void setSelectedStudents(List<String> selectedStudents) {
		this.selectedStudents = selectedStudents;
	}

	public AddStudents() {
		search();
	}

	public String search() {

		selectedStudents.clear();

		Course course = (Course) FacesUtil.getSession(Constants.SESSION_COURSE);

		List<User> students = new ArrayList<User>();

		List<User> enrolledStudents = new ArrayList<User>();

		for (User student : Querier.getStudentsLike(keyword))
			if (Querier.getStudents(course).contains(student))
				enrolledStudents.add(student);
			else
				students.add(student);

		this.enrolledStudents = new SelectItem[enrolledStudents.size()];

		for (int i = 0; i < enrolledStudents.size(); i++)
			this.enrolledStudents[i] = new SelectItem(enrolledStudents.get(i)
					.getUserName()
					+ " - "
					+ enrolledStudents.get(i).getName()
					+ " (" + enrolledStudents.get(i).getEmail() + ") ");

		this.students = new SelectItem[students.size()];

		for (int i = 0; i < students.size(); i++)
			this.students[i] = new SelectItem(students.get(i).getUserName()
					+ " - " + students.get(i).getName() + " ("
					+ students.get(i).getEmail() + ") ");

		return Constants.ACTION_SELECT;

	}

	public String add() {

		List<User> users = new ArrayList<User>();

		for (String student : selectedStudents)
			users.add(Querier.getStudent(student.substring(
					student.indexOf("(") + 1, student.indexOf(")"))));

		Course course = (Course) FacesUtil.getSession(Constants.SESSION_COURSE);

		for (User user : users) {

			Enrollment enrollment = new Enrollment();
			enrollment.setCourse(course);
			enrollment.setStudent(user);
			EnrollmentDAO.insert(enrollment);

		}

		refresh();

		return Constants.ACTION_SUCCESS;

	}

	public String cancel() {
		refresh();
		return Constants.ACTION_CANCEL;
	}

	public String register() {
		refresh();
		return Constants.ACTION_REGISTER_STUDENT;
	}

	public String back() {
		refresh();
		return Constants.ACTION_BACK;
	}

	public void change(ValueChangeEvent event) {
	}

	private void refresh() {
		keyword = Constants.EMPTY;
		students = new SelectItem[0];
		enrolledStudents = new SelectItem[0];
		selectedStudents = new ArrayList<String>();
		search();
	}

}
