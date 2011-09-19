package progtest.common;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import progtest.common.keys.RequisitePK;

@Entity
@IdClass(RequisitePK.class)
public class Requisite {

	private Assignment assignment;

	private Criterion criterion;

	private int weight = 0;
	
	private String execInfo;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "assignment", referencedColumnName = "idCode")
	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
			@JoinColumn(name = "criterion", referencedColumnName = "idCode"),
			@JoinColumn(name = "tool", referencedColumnName = "tool") })
	public Criterion getCriterion() {
		return criterion;
	}

	public void setCriterion(Criterion criterion) {
		this.criterion = criterion;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getExecInfo() {
		return execInfo;
	}

	public void setExecInfo(String execInfo) {
		this.execInfo = execInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assignment == null) ? 0 : assignment.hashCode());
		result = prime * result
				+ ((criterion == null) ? 0 : criterion.hashCode());
		result = prime * result
				+ ((execInfo == null) ? 0 : execInfo.hashCode());
		result = prime * result + weight;
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
		Requisite other = (Requisite) obj;
		if (assignment == null) {
			if (other.assignment != null)
				return false;
		} else if (!assignment.equals(other.assignment))
			return false;
		if (criterion == null) {
			if (other.criterion != null)
				return false;
		} else if (!criterion.equals(other.criterion))
			return false;
		if (execInfo == null) {
			if (other.execInfo != null)
				return false;
		} else if (!execInfo.equals(other.execInfo))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

}
