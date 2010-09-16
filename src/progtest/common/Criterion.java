package progtest.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Criterion {
	
	private int idCode;
	
	private String name;
	
	private String tool;
	
	private String language;
	
	private String type;
	
	@Id
	@SequenceGenerator(name = "SEQ_CRITERION", sequenceName = "SEQ_CRITERION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CRITERION")
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

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
