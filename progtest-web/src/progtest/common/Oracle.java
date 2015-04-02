package progtest.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Oracle {
	
	private int idCode;
	
	private String title;
	
	private String description;
	
	private String language;

	@Id
	@TableGenerator(name = "OracleIDGEN", table = "Sequence", pkColumnName = "entity", valueColumnName = "id", pkColumnValue = "Oracle", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "OracleIDGEN")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Oracle other = (Oracle) obj;
		if (idCode != other.idCode)
			return false;
		return true;
	}

}
