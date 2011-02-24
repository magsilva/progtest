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
import javax.persistence.TableGenerator;

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

	private List<Submission> submissions = new ArrayList<Submission>();

	@Id
	@TableGenerator(name = "UserIDGEN", table = "Sequence", pkColumnName = "entity", valueColumnName = "id", pkColumnValue = "User", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "UserIDGEN")
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
	@JoinTable(name = "Enrollment", joinColumns = @JoinColumn(name = "student"), inverseJoinColumns = @JoinColumn(name = "course"))
	public List<Course> getCoursesAsStudent() {
		return coursesAsStudent;
	}

	public void setCoursesAsStudent(List<Course> coursesAsStudent) {
		this.coursesAsStudent = coursesAsStudent;
	}

	@OneToMany(mappedBy = "student")
	public List<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((coursesAsInstructor == null) ? 0 : coursesAsInstructor
						.hashCode());
		result = prime
				* result
				+ ((coursesAsStudent == null) ? 0 : coursesAsStudent.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idCode;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result
				+ ((submissions == null) ? 0 : submissions.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (coursesAsInstructor == null) {
			if (other.coursesAsInstructor != null)
				return false;
		} else if (!coursesAsInstructor.equals(other.coursesAsInstructor))
			return false;
		if (coursesAsStudent == null) {
			if (other.coursesAsStudent != null)
				return false;
		} else if (!coursesAsStudent.equals(other.coursesAsStudent))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idCode != other.idCode)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (submissions == null) {
			if (other.submissions != null)
				return false;
		} else if (!submissions.equals(other.submissions))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}
