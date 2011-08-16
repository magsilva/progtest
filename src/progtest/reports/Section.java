package progtest.reports;

import java.util.ArrayList;
import java.util.List;

public class Section {
	
	private String title = null;
	
	private List<Object> objects = new ArrayList<Object>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Object> getObjects() {
		return objects;
	}

}
