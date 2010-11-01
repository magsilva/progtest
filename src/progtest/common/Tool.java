package progtest.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Tool {
	
	private int idCode;
	
	private String name;
	
	private String type;
	
	private String language;
	
	private List<Criterion> criteria = new ArrayList<Criterion>();

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
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@OneToMany(mappedBy = "tool")
	public List<Criterion> getCriteria() {
		return criteria;
	}

	public void setCriteria(List<Criterion> criteria) {
		this.criteria = criteria;
	}

}