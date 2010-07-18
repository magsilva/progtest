package progtest.common;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class AssignmentPK implements Serializable {
	
	private static final long serialVersionUID = -1341526506769668260L;

	private Course course;
	
	private int idCode;

	@Id
	@ManyToOne
	@JoinColumn(name = "course")
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}

	@Id
	public int getIdCode() {
		return idCode;
	}

	@SuppressWarnings("unused")
	private void setIdCode(int idCode) {
		this.idCode = idCode;
	}

}
