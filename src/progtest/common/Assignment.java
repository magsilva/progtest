package progtest.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import progtest.database.Querier;

@Entity
@IdClass(AssignmentPK.class)
public class Assignment {
	
	private Course course;
	
	private int idCode = Querier.getNewId();
	
	private String title;
	
	private String description;
	
	private Date startDate;
	
	private Date endDate;
	
	private int weightPinstTinst;
	
	private int weightPalTal;
	
	private int weightPinstTal;
	
	private int weightPalTinst;
	
	private int weightFunctional;
	
	private int weightAllNodes;
	
	private int weightAllEdges;
	
	private int weightAllUses;
	
	private int weightAllPotUses;

	private List<Evaluation> evaluations = new ArrayList<Evaluation>();

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
	public int getIdCode() {
		return idCode;
	}

	@SuppressWarnings("unused")
	private void setIdCode(int idCode) {
		this.idCode = idCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getWeightPinstTinst() {
		return weightPinstTinst;
	}

	public void setWeightPinstTinst(int weightPinstTinst) {
		this.weightPinstTinst = weightPinstTinst;
	}

	public int getWeightPalTal() {
		return weightPalTal;
	}

	public void setWeightPalTal(int weightPalTal) {
		this.weightPalTal = weightPalTal;
	}

	public int getWeightPinstTal() {
		return weightPinstTal;
	}

	public void setWeightPinstTal(int weightPinstTal) {
		this.weightPinstTal = weightPinstTal;
	}

	public int getWeightPalTinst() {
		return weightPalTinst;
	}

	public void setWeightPalTinst(int weightPalTinst) {
		this.weightPalTinst = weightPalTinst;
	}

	public int getWeightFunctional() {
		return weightFunctional;
	}

	public void setWeightFunctional(int weightFunctional) {
		this.weightFunctional = weightFunctional;
	}

	public int getWeightAllNodes() {
		return weightAllNodes;
	}

	public void setWeightAllNodes(int weightAllNodes) {
		this.weightAllNodes = weightAllNodes;
	}

	public int getWeightAllEdges() {
		return weightAllEdges;
	}

	public void setWeightAllEdges(int weightAllEdges) {
		this.weightAllEdges = weightAllEdges;
	}

	public int getWeightAllUses() {
		return weightAllUses;
	}

	public void setWeightAllUses(int weightAllUses) {
		this.weightAllUses = weightAllUses;
	}

	public int getWeightAllPotUses() {
		return weightAllPotUses;
	}

	public void setWeightAllPotUses(int weightAllPotUses) {
		this.weightAllPotUses = weightAllPotUses;
	}

	@OneToMany(mappedBy = "assignment")
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

}
