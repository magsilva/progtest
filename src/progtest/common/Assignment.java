package progtest.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

@Entity
public class Assignment {

	private int idCode;

	private Course course;

	private String title;

	private String description;

	private Date startDate;

	private Date endDate;
	
	private int timeout;
	
	private double minimumCoverage;
	
	private boolean pstsVisible;
	
	private boolean pitsVisible;
	
	private boolean pstiVisible;
	
	private double pstsWeight;
	
	private double pitsWeight;
	
	private double pstiWeight;

	private double pitiCoverage;

	private List<Requisite> requisites = new ArrayList<Requisite>();

	private List<Submission> submissions = new ArrayList<Submission>();

	@Id
	@TableGenerator(name = "AssignmentIDGEN", table = "Sequence", pkColumnName = "entity", valueColumnName = "id", pkColumnValue = "Assignment", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "AssignmentIDGEN")
	public int getIdCode() {
		return idCode;
	}

	@SuppressWarnings("unused")
	private void setIdCode(int idCode) {
		this.idCode = idCode;
	}

	@ManyToOne
	@JoinColumn(name = "course")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public double getMinimumCoverage() {
		return minimumCoverage;
	}

	public void setMinimumCoverage(double minimumCoverage) {
		this.minimumCoverage = minimumCoverage;
	}

	public boolean isPstsVisible() {
		return pstsVisible;
	}

	public void setPstsVisible(boolean pstsVisible) {
		this.pstsVisible = pstsVisible;
	}

	public boolean isPitsVisible() {
		return pitsVisible;
	}

	public void setPitsVisible(boolean pitsVisible) {
		this.pitsVisible = pitsVisible;
	}

	public boolean isPstiVisible() {
		return pstiVisible;
	}

	public void setPstiVisible(boolean pstiVisible) {
		this.pstiVisible = pstiVisible;
	}

	public double getPstsWeight() {
		return pstsWeight;
	}

	public void setPstsWeight(double pstsWeight) {
		this.pstsWeight = pstsWeight;
	}

	public double getPitsWeight() {
		return pitsWeight;
	}

	public void setPitsWeight(double pitsWeight) {
		this.pitsWeight = pitsWeight;
	}

	public double getPstiWeight() {
		return pstiWeight;
	}

	public void setPstiWeight(double pstiWeight) {
		this.pstiWeight = pstiWeight;
	}

	public double getPitiCoverage() {
		return pitiCoverage;
	}

	public void setPitiCoverage(double pitiCoverage) {
		this.pitiCoverage = pitiCoverage;
	}

	@OneToMany(mappedBy = "assignment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Requisite> getRequisites() {
		return requisites;
	}

	public void setRequisites(List<Requisite> requisites) {
		this.requisites = requisites;
	}

	@OneToMany(mappedBy = "assignment")
	public List<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}

	@Transient
	public List<Tool> getTools() {
		List<Tool> tools = new ArrayList<Tool>();
		for (Requisite requisite : requisites) {
			boolean contains = false;
			for (Tool tool : tools) {
				if (tool.getIdCode() == requisite.getCriterion().getTool()
						.getIdCode())
					contains = true;
			}
			if (!contains)
				tools.add(requisite.getCriterion().getTool());
		}
		return tools;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + idCode;
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
		Assignment other = (Assignment) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (idCode != other.idCode)
			return false;
		return true;
	}

}
