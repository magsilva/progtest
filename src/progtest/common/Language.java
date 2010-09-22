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
public class Language {
	
	private int idCode;
	
	private String name;
	
	private List<Compiler> compilers = new ArrayList<Compiler>();
	
	private List<Tool> tools = new ArrayList<Tool>();

	@Id
	@SequenceGenerator(name = "SEQ_LANGUAGE", sequenceName = "SEQ_LANGUAGE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LANGUAGE")
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

	@OneToMany(mappedBy = "language")
	public List<Compiler> getCompilers() {
		return compilers;
	}

	public void setCompilers(List<Compiler> compilers) {
		this.compilers = compilers;
	}

	@OneToMany(mappedBy = "language")
	public List<Tool> getTools() {
		return tools;
	}

	public void setTools(List<Tool> tools) {
		this.tools = tools;
	}

}
