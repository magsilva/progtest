package progtest.common;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;



@Entity
@IdClass(SubmissionPK.class)
public class Submission {

	private User student;

	private Assignment assignment;

	private Date submissionDate;

	private double pstTst;

	private double pinstTst;

	private double pstTinst;

	private double score;

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
	@JoinColumns( { @JoinColumn(name = "course", referencedColumnName = "course"),
			@JoinColumn(name = "assignment", referencedColumnName = "idCode") })
	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public double getPstTst() {
		return pstTst;
	}

	public void setPstTst(double pstTst) {
		this.pstTst = pstTst;
	}

	public double getPinstTst() {
		return pinstTst;
	}

	public void setPinstTst(double pinstTst) {
		this.pinstTst = pinstTst;
	}

	public double getPstTinst() {
		return pstTinst;
	}

	public void setPstTinst(double pstTinst) {
		this.pstTinst = pstTinst;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

}
