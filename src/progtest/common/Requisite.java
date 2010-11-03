package progtest.common;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import progtest.common.keys.RequisitePK;



@Entity
@Table(name = "assignment_criterion")
@IdClass(RequisitePK.class)
public class Requisite {

	private Assignment assignment;

	private Criterion criterion;

	private int weight = 0;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "course", referencedColumnName = "course"),
			@JoinColumn(name = "assignment", referencedColumnName = "idCode") })
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

}
