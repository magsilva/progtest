package progtest.addons.jumble;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Reporter {

	private static final String REPORT_SCOREBYCLASS = "Score by Class.xml";

	private static final String REPORT_ALLMUTANTS = "All Mutants.xml";

	private static final String REPORT_ALIVEMUTANTS = "Alive Mutants.xml";

	private static final String REPORT_DEADMUTANTS = "Dead Mutants.xml";

	public static void generateReports(Result r, File rptDir)
			throws FileNotFoundException {
		generateScoreByClassReport(r, rptDir);
		generateAllMutantsReport(r, rptDir);
		generateAliveMutantsReport(r, rptDir);
		generateDeadMutantsReport(r, rptDir);
	}

	private static void generateScoreByClassReport(Result r, File rptDir)
			throws FileNotFoundException {

		File f = new File(rptDir, REPORT_SCOREBYCLASS);

		String[][] data = r.getScoreByClass();

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"Scores\" tool=\"Jumble\">");
		XMLFile.println("\t<section title=\"Scores By Class\">");
		XMLFile.println("\t\t<table>");

		XMLFile.println("\t\t\t<header>");
		XMLFile.println("\t\t\t\t<column value=\"" + data[0][0] + "\"/>");
		XMLFile.println("\t\t\t\t<column value=\"" + data[0][1] + "\"/>");
		XMLFile.println("\t\t\t\t<column value=\"" + data[0][2] + "\"/>");
		XMLFile.println("\t\t\t\t<column value=\"" + data[0][3] + "\"/>");
		XMLFile.println("\t\t\t</header>");

		for (int i = 1; i < data.length; i++) {

			XMLFile.println("\t\t\t<row>");
			XMLFile.println("\t\t\t\t<column value=\"" + data[i][0] + "\"/>");
			XMLFile.println("\t\t\t\t<column value=\"" + data[i][1] + "\"/>");
			XMLFile.println("\t\t\t\t<column value=\"" + data[i][2] + "\"/>");
			XMLFile.println("\t\t\t\t<column value=\"" + data[i][3] + "%\"/>");
			XMLFile.println("\t\t\t</row>");

		}

		XMLFile.println("\t\t</table>");
		XMLFile.println("\t</section>");
		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateAllMutantsReport(Result r, File rptDir)
			throws FileNotFoundException {

		File f = new File(rptDir, REPORT_ALLMUTANTS);

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"All Mutants\" tool=\"Jumble\">");

		for (int i = 1; i < r.getScoreByClass().length; i++) {

			String className = r.getScoreByClass()[i][0];

			XMLFile.println("\t<section title=\"" + className + "\">");

			List<String> allMutants = new ArrayList<String>();

			for (String mutant : r.getAllMutants()) {
				if (mutant.startsWith(className + ":"))
					allMutants.add(mutant);
			}

			if (allMutants.isEmpty())
				XMLFile.println("\t\t<text value=\"Any mutants for this class!\" color=\"#FFFFFF\"/>");
			else
				for (String mutant : allMutants)
					XMLFile.println("\t\t<text value=\""
							+ mutant.replace("&", "&amp;")
									.replace("\"", "&quot;")
									.replace("'", "&apos;")
									.replace(">", "&gt;").replace("<", "&lt;")
							+ "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateAliveMutantsReport(Result r, File rptDir)
			throws FileNotFoundException {

		File f = new File(rptDir, REPORT_ALIVEMUTANTS);

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"Alive Mutants\" tool=\"Jumble\">");

		for (int i = 1; i < r.getScoreByClass().length; i++) {

			String className = r.getScoreByClass()[i][0];

			XMLFile.println("\t<section title=\"" + className + "\">");

			List<String> aliveMutants = new ArrayList<String>();

			for (String mutant : r.getAliveMutants()) {
				if (mutant.startsWith(className + ":"))
					aliveMutants.add(mutant);
			}

			if (aliveMutants.isEmpty())
				XMLFile.println("\t\t<text value=\"Any alive mutants for this class!\" color=\"#FFFFFF\"/>");
			else
				for (String mutant : aliveMutants)
					XMLFile.println("\t\t<text value=\""
							+ mutant.replace("&", "&amp;")
									.replace("\"", "&quot;")
									.replace("'", "&apos;")
									.replace(">", "&gt;").replace("<", "&lt;")
							+ "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateDeadMutantsReport(Result r, File rptDir)
			throws FileNotFoundException {

		File f = new File(rptDir, REPORT_DEADMUTANTS);

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"Dead Mutants\" tool=\"Jumble\">");

		for (int i = 1; i < r.getScoreByClass().length; i++) {

			String className = r.getScoreByClass()[i][0];

			XMLFile.println("\t<section title=\"" + className + "\">");

			List<String> deadMutants = new ArrayList<String>();

			for (String mutant : r.getDeadMutants()) {
				if (mutant.startsWith(className + ":"))
					deadMutants.add(mutant);
			}

			if (deadMutants.isEmpty())
				XMLFile.println("\t\t<text value=\"Any dead mutants for this class!\" color=\"#FFFFFF\"/>");
			else
				for (String mutant : deadMutants)
					XMLFile.println("\t\t<text value=\""
							+ mutant.replace("&", "&amp;")
									.replace("\"", "&quot;")
									.replace("'", "&apos;")
									.replace(">", "&gt;").replace("<", "&lt;")
							+ "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

}
