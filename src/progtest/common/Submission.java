package progtest.common;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import progtest.common.keys.SubmissionPK;

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
	@JoinColumn(name = "assignment", referencedColumnName = "idCode")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assignment == null) ? 0 : assignment.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pinstTst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pstTinst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pstTst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		result = prime * result
				+ ((submissionDate == null) ? 0 : submissionDate.hashCode());
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
		Submission other = (Submission) obj;
		if (assignment == null) {
			if (other.assignment != null)
				return false;
		} else if (!assignment.equals(other.assignment))
			return false;
		if (Double.doubleToLongBits(pinstTst) != Double
				.doubleToLongBits(other.pinstTst))
			return false;
		if (Double.doubleToLongBits(pstTinst) != Double
				.doubleToLongBits(other.pstTinst))
			return false;
		if (Double.doubleToLongBits(pstTst) != Double
				.doubleToLongBits(other.pstTst))
			return false;
		if (Double.doubleToLongBits(score) != Double
				.doubleToLongBits(other.score))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		if (submissionDate == null) {
			if (other.submissionDate != null)
				return false;
		} else if (!submissionDate.equals(other.submissionDate))
			return false;
		return true;
	}

}
