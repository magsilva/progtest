package progtest.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
public class Tool {

	private int idCode;

	private String name;

	private String language;

	private String compiler;

	private String testFormat;

	private String commandFile;

	private String outputFile;

	private List<Criterion> criteria = new ArrayList<Criterion>();

	@Id
	@TableGenerator(name = "ToolIDGEN", table = "Sequence", pkColumnName = "entity", valueColumnName = "id", pkColumnValue = "Tool", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ToolIDGEN")
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCompiler() {
		return compiler;
	}

	public void setCompiler(String compiler) {
		this.compiler = compiler;
	}

	public String getTestFormat() {
		return testFormat;
	}

	public void setTestFormat(String testFormat) {
		this.testFormat = testFormat;
	}

	public String getCommandFile() {
		return commandFile;
	}

	public void setCommandFile(String commandFile) {
		this.commandFile = commandFile;
	}

	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	@OneToMany(mappedBy = "tool", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Criterion> getCriteria() {
		return criteria;
	}

	public void setCriteria(List<Criterion> criteria) {
		this.criteria = criteria;
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
		Tool other = (Tool) obj;
		if (idCode != other.idCode)
			return false;
		return true;
	}

}
