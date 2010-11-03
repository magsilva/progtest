package progtest.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import progtest.common.keys.AssignmentPK;



@Entity
@IdClass(AssignmentPK.class)
public class Assignment {

	private Course course;

	private int idCode;

	private String title;

	private String description;

	private Date startDate;

	private Date endDate;
	
	private double pinstTinst;

	private List<Criterion> criteria = new ArrayList<Criterion>();

	private List<Submission> submissions = new ArrayList<Submission>();

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
	@SequenceGenerator(name = "SEQ_ASSIGNMENT", sequenceName = "SEQ_ASSIGNMENT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ASSIGNMENT")
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

	public double getPinstTinst() {
		return pinstTinst;
	}

	public void setPinstTinst(double pinstTinst) {
		this.pinstTinst = pinstTinst;
	}

	@ManyToMany(targetEntity = progtest.common.Criterion.class)
	@JoinTable(name = "assignment_criterion", joinColumns = {
			@JoinColumn(name = "course"), @JoinColumn(name = "assignment") }, inverseJoinColumns = {
			@JoinColumn(name = "tool", referencedColumnName = "tool"),
			@JoinColumn(name = "criterion", referencedColumnName = "idCode") })
	public List<Criterion> getCriteria() {
		return criteria;
	}

	public void setCriteria(List<Criterion> criteria) {
		this.criteria = criteria;
	}

	@OneToMany(mappedBy = "assignment")
	public List<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}

}
