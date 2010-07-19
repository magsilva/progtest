package progtest.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	private int idCode;

	private String userName;

	private String name;

	private String email;

	private String password;

	private String role;

	private List<Course> coursesAsInstructor = new ArrayList<Course>();

	private List<Course> coursesAsStudent = new ArrayList<Course>();

	private List<Evaluation> evaluations = new ArrayList<Evaluation>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCode() {
		return idCode;
	}

	public void setIdCode(int idCode) {
		this.idCode = idCode;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@OneToMany(mappedBy = "instructor")
	public List<Course> getCoursesAsInstructor() {
		return coursesAsInstructor;
	}

	public void setCoursesAsInstructor(List<Course> coursesAsInstructor) {
		this.coursesAsInstructor = coursesAsInstructor;
	}

	@ManyToMany(targetEntity = progtest.common.Course.class)
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student"), inverseJoinColumns = @JoinColumn(name = "course"))
	public List<Course> getCoursesAsStudent() {
		return coursesAsStudent;
	}

	public void setCoursesAsStudent(List<Course> coursesAsStudent) {
		this.coursesAsStudent = coursesAsStudent;
	}

	@OneToMany(mappedBy = "student")
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

}
