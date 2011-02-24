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

	private String cmdfile;

	private String outputfile;

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

	public String getCmdfile() {
		return cmdfile;
	}

	public void setCmdfile(String cmdfile) {
		this.cmdfile = cmdfile;
	}

	public String getOutputfile() {
		return outputfile;
	}

	public void setOutputfile(String outputfile) {
		this.outputfile = outputfile;
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
		result = prime * result
				+ ((criteria == null) ? 0 : criteria.hashCode());
		result = prime * result + idCode;
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((compiler == null) ? 0 : compiler.hashCode());
		result = prime * result + ((testFormat == null) ? 0 : testFormat.hashCode());
		result = prime * result + ((cmdfile == null) ? 0 : cmdfile.hashCode());
		result = prime * result + ((outputfile == null) ? 0 : outputfile.hashCode());
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
		if (criteria == null) {
			if (other.criteria != null)
				return false;
		} else if (!criteria.equals(other.criteria))
			return false;
		if (idCode != other.idCode)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (compiler == null) {
			if (other.compiler != null)
				return false;
		} else if (!compiler.equals(other.compiler))
			return false;
		if (testFormat == null) {
			if (other.testFormat != null)
				return false;
		} else if (!testFormat.equals(other.testFormat))
			return false;
		if (cmdfile == null) {
			if (other.cmdfile != null)
				return false;
		} else if (!cmdfile.equals(other.cmdfile))
			return false;
		if (outputfile == null) {
			if (other.outputfile != null)
				return false;
		} else if (!outputfile.equals(other.outputfile))
			return false;
		return true;
	}

}
