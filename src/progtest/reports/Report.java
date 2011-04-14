package progtest.reports;

import java.io.File;

import progtest.common.Tool;
import progtest.database.Querier;

public class Report {

	private String tool = null;

	private String name = null;

	private File file = null;

	public Report(File f) {

		String parent = f.getParentFile().getName();

		if (parent.contains("tool")) {
			String toolId = parent.substring(4);
			Tool t = Querier.getTool(Integer.parseInt(toolId));
			tool = t.getName();
		} else {
			tool = "Others";
		}

		if (f.getName().contains("."))
			name = f.getName().substring(0, f.getName().lastIndexOf("."));
		else
			name = f.getName();

		file = f;

	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
