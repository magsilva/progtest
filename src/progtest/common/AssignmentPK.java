package progtest.common;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

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
	@SequenceGenerator(name = "SEQ_ASSIGNMENT", sequenceName = "SEQ_ASSIGNMENT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ASSIGNMENT")
	public int getIdCode() {
		return idCode;
	}

	@SuppressWarnings("unused")
	private void setIdCode(int idCode) {
		this.idCode = idCode;
	}

}
