package progtest.execution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Listener {

	private PrintWriter XMLFile = null;

	private String tool = null;
	
	private String root = null;

	public Listener(String tool, String root, File outFile)
			throws FileNotFoundException {
		this.XMLFile = new PrintWriter(new FileOutputStream(outFile));
		this.tool = tool;
		this.root = root;
	}

	public void start() {
		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"" + tool + " Output\" tool=\"" + tool
				+ "\">");
		XMLFile.println("\t<section title=\"Standard Output\">");
	}

	public void listen(String line) {
		
		line = line.replace(root, "");
		
		XMLFile.println("\t\t<text value=\"" + line.replace("&", "&amp;").replace("\"", "&quot;")
				.replace("'", "&apos;").replace(">", "&gt;").replace("<", "&lt;") + "\" color=\"#FFFFFF\"/>");
		
	}

	public void finish() {
		XMLFile.println("\t</section>");
		XMLFile.println("</report>");
		XMLFile.close();
	}

}
