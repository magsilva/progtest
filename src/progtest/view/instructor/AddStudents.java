package progtest.view.instructor;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import progtest.common.Course;
import progtest.common.Enrollment;
import progtest.common.User;
import progtest.database.Querier;
import progtest.database.EnrollmentDAO;
import progtest.util.Constants;
import progtest.util.FacesUtil;

public class AddStudents {

	private SelectItem[] students = loadStudents();

	private List<String> selectedStudents = new ArrayList<String>();

	public SelectItem[] getStudents() {
		return students;
	}

	public void setStudents(SelectItem[] students) {
		this.students = students;
	}

	public List<String> getSelectedStudents() {
		return selectedStudents;
	}

	public void setSelectedStudents(List<String> selectedStudents) {
		this.selectedStudents = selectedStudents;
	}

	public String add() {

		List<User> users = new ArrayList<User>();

		for (String student : selectedStudents)
			users.add(Querier.getStudent(student.substring(
					student.indexOf("(") + 1, student.indexOf(")"))));

		Course course = (Course) FacesUtil
				.getSession(Constants.SESSION_COURSE);

		for (User user : users) {

			Enrollment enrollment = new Enrollment();
			enrollment.setCourse(course);
			enrollment.setStudent(user);
			EnrollmentDAO.insert(enrollment);

		}

		return Constants.ACTION_SUCCESS;

	}

	private SelectItem[] loadStudents() {

		Course course = (Course) FacesUtil
				.getSession(Constants.SESSION_COURSE);

		List<User> users = Querier.getStudentsNotCourse(course);

		SelectItem[] itens = new SelectItem[users.size()];

		for (int i = 0; i < users.size(); i++)
			itens[i] = new SelectItem(users.get(i).getUserName() + " - "
					+ users.get(i).getName() + " (" + users.get(i).getEmail()
					+ ") ");

		return itens;

	}

	public String register() {
		return Constants.ACTION_REGISTER;
	}

	public String cancel() {
		return Constants.ACTION_CANCEL;
	}

}
