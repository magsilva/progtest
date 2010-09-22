package progtest.common;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

public class AssignmentCriterionPK implements Serializable {

	private static final long serialVersionUID = -9064262612318912241L;
	
	private Assignment assignment;

	private Criterion criterion;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "course"),
			@JoinColumn(name = "assignment") }
	)
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

}
