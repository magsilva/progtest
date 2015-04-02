package progtest.common.keys;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import progtest.common.Assignment;
import progtest.common.Criterion;



public class RequisitePK implements Serializable {

	private static final long serialVersionUID = -9064262612318912241L;
	
	private Assignment assignment;

	private Criterion criterion;

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

}
