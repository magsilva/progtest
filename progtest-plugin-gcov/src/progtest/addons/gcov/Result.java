package progtest.addons.gcov;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Result {
	
	private String[][] coverages = new String[0][0];
	
	private List<File> sources = new ArrayList<File>();

	public String[][] getCoverages() {
		return coverages;
	}

	public void setCoverages(String[][] coverages) {
		this.coverages = coverages;
	}

	public List<File> getSources() {
		return sources;
	}

	public void setSources(List<File> sources) {
		this.sources = sources;
	}

}
