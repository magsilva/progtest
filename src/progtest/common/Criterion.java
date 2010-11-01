package progtest.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;



@Entity
@IdClass(CriterionPK.class)
public class Criterion {
	
	private Tool tool;
	
	private int idCode;
	
	private String name;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "tool")
	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

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

}
