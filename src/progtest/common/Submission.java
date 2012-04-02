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

	private double pstsCoverage;

	private double pitsCoverage;

	private double pstiCoverage;

	private double grade;

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

	public double getPstsCoverage() {
		return pstsCoverage;
	}

	public void setPstsCoverage(double pstsCoverage) {
		this.pstsCoverage = pstsCoverage;
	}

	public double getPitsCoverage() {
		return pitsCoverage;
	}

	public void setPitsCoverage(double pitsCoverage) {
		this.pitsCoverage = pitsCoverage;
	}

	public double getPstiCoverage() {
		return pstiCoverage;
	}

	public void setPstiCoverage(double pstiCoverage) {
		this.pstiCoverage = pstiCoverage;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assignment == null) ? 0 : assignment.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

}
