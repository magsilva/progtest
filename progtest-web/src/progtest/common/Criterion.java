package progtest.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import progtest.common.keys.CriterionPK;

@Entity
@IdClass(CriterionPK.class)
public class Criterion {
	
	private Tool tool;
	
	private int idCode;
	
	private String name;
	
	private String propertyKey;
	
	private List<Operator> operators = new ArrayList<Operator>();
	
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
	
	public String getPropertyKey() {
		return propertyKey;
	}

	public void setPropertyKey(String propertyKey) {
		this.propertyKey = propertyKey;
	}

	@OneToMany(mappedBy = "criterion")
	public List<Operator> getOperators() {
		return operators;
	}

	public void setOperators(List<Operator> operators) {
		this.operators = operators;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCode;
		result = prime * result + ((tool == null) ? 0 : tool.hashCode());
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
		Criterion other = (Criterion) obj;
		if (idCode != other.idCode)
			return false;
		if (tool == null) {
			if (other.tool != null)
				return false;
		} else if (!tool.equals(other.tool))
			return false;
		return true;
	}

}
