package progtest.common.keys;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import progtest.common.Tool;

public class CriterionPK implements Serializable {
	
	private static final long serialVersionUID = 4753671316385228333L;
	
	private Tool tool;
	
	private int idCode;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "tool")
	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	@TableGenerator(name = "CriterionIDGEN", table = "Sequence", pkColumnName = "entity", valueColumnName = "id", pkColumnValue = "Criterion")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CriterionIDGEN")
	public int getIdCode() {
		return idCode;
	}

	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}

}
