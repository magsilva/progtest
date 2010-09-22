package progtest.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Tool {
	
	private int idCode;
	
	private String name;
	
	private String type;
	
	private Language language;
	
	private List<Criterion> criterion = new ArrayList<Criterion>();

	@Id
	@SequenceGenerator(name = "SEQ_TOOL", sequenceName = "SEQ_TOOL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TOOL")
	public int getIdCode() {
		return idCode;
	}

	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "language")
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@OneToMany(mappedBy = "tool")
	public List<Criterion> getCriterion() {
		return criterion;
	}

	public void setCriterion(List<Criterion> criterion) {
		this.criterion = criterion;
	}

}
