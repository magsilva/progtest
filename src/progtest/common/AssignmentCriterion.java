package progtest.common;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assignment_criterion")
@IdClass(AssignmentCriterionPK.class)
public class AssignmentCriterion {

	private Assignment assignment;

	private Criterion criterion;

	private int weight;

	public AssignmentCriterion() {
		this.weight = 0;
	}

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
			@JoinColumn(name = "course", referencedColumnName = "course"),
			@JoinColumn(name = "assignment", referencedColumnName = "idCode") })
	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "criterion", referencedColumnName = "idCode")
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
