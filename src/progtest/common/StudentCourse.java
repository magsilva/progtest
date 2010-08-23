package progtest.common;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_course")
@IdClass(StudentCoursePK.class)
public class StudentCourse {
	
	private User student;
	
	private Course course;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student")
	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "course")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
