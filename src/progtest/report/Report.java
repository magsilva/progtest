package progtest.report;

import java.util.ArrayList;
import java.util.List;

public class Report {
	
	private String name = null;

	private List<Section> sections = new ArrayList<Section>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Section> getSections() {
		return sections;
	}

}
