package progtest.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Oracle {
	
	private int idCode;
	
	private String title;
	
	private String description;
	
	private String language;

	@Id
	@SequenceGenerator(name = "SEQ_ORACLE", sequenceName = "SEQ_ORACLE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ORACLE")
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
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
