package progtest.reports;

import java.util.ArrayList;
import java.util.List;

public class Report {
	
	private String tool = null;
	
	private String name = null;

	private List<Section> sections = new ArrayList<Section>();
	
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

	public List<Section> getSections() {
		return sections;
	}

}
