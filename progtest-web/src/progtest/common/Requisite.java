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

	private int weight;
	
	private boolean pstsRequired;
	
	private boolean pitsRequired;
	
	private boolean pstiRequired;
	
	private String executionParameters;

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

	public boolean isPstsRequired() {
		return pstsRequired;
	}

	public void setPstsRequired(boolean pstsRequired) {
		this.pstsRequired = pstsRequired;
	}

	public boolean isPitsRequired() {
		return pitsRequired;
	}

	public void setPitsRequired(boolean pitsRequired) {
		this.pitsRequired = pitsRequired;
	}

	public boolean isPstiRequired() {
		return pstiRequired;
	}

	public void setPstiRequired(boolean pstiRequired) {
		this.pstiRequired = pstiRequired;
	}

	public String getExecutionParameters() {
		return executionParameters;
	}

	public void setExecutionParameters(String executionParameters) {
		this.executionParameters = executionParameters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assignment == null) ? 0 : assignment.hashCode());
		result = prime * result
				+ ((criterion == null) ? 0 : criterion.hashCode());
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
		return true;
	}

}
