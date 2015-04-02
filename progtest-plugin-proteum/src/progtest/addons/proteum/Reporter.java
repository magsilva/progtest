package progtest.addons.proteum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class Reporter {

	private static final String REPORT_STATISTICS = "Statistics.xml";

	private static final String REPORT_ALL_MUTANTS = "All Mutants.xml";

	private static final String REPORT_ANOMALOUS_MUTANTS = "Anomalous Mutants.xml";

	private static final String REPORT_ALIVE_MUTANTS = "Alive Mutants.xml";

	private static final String REPORT_DEAD_MUTANTS = "Dead Mutants.xml";

	public static void generateReports(List<Result> results, File rptDir)
			throws Throwable {
		generateStatisticsReport(results, rptDir);
		generateAllMutantsReport(results, rptDir);
		generateAnomalousMutantsReport(results, rptDir);
		generateAliveMutantsReport(results, rptDir);
		generateDeadMutantsReport(results, rptDir);
	}

	private static void generateStatisticsReport(List<Result> results,
			File rptDir) throws FileNotFoundException {

		File f = new File(rptDir, REPORT_STATISTICS);

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"Statistics\" tool=\"Proteum\">");
		XMLFile.println("\t<section title=\"Statistics by Source\">");
		XMLFile.println("\t\t<table>");

		XMLFile.println("\t\t\t<header>");
		XMLFile.println("\t\t\t\t<column value=\"SOURCE\"/>");
		XMLFile.println("\t\t\t\t<column value=\"TOTAL\"/>");
		XMLFile.println("\t\t\t\t<column value=\"ANOMALOUS\"/>");
		XMLFile.println("\t\t\t\t<column value=\"ALIVE\"/>");
		XMLFile.println("\t\t\t\t<column value=\"DEAD\"/>");
		XMLFile.println("\t\t\t\t<column value=\"SCORE\"/>");
		XMLFile.println("\t\t\t</header>");

		for (Result result : results) {

			XMLFile.println("\t\t\t<row>");
			XMLFile.println("\t\t\t\t<column value=\"" + result.getSource()
					+ "\"/>");
			XMLFile.println("\t\t\t\t<column value=\"" + result.getTotal()
					+ "\"/>");
			XMLFile.println("\t\t\t\t<column value=\"" + result.getAnomalous()
					+ "\"/>");
			XMLFile.println("\t\t\t\t<column value=\"" + result.getAlive()
					+ "\"/>");
			XMLFile.println("\t\t\t\t<column value=\"" + result.getDead()
					+ "\"/>");
			XMLFile.println("\t\t\t\t<column value=\"" + result.getScore()
					+ "\"/>");
			XMLFile.println("\t\t\t</row>");

		}

		XMLFile.println("\t\t</table>");
		XMLFile.println("\t</section>");
		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateAllMutantsReport(List<Result> results,
			File rptDir) throws FileNotFoundException {

		File f = new File(rptDir, REPORT_ALL_MUTANTS);

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"All Mutants\" tool=\"Proteum\">");

		for (Result result : results) {

			XMLFile.println("\t<section title=\"" + result.getSource()
					+ " Source\">");

			XMLFile.println("\t\t<table>");

			XMLFile.println("\t\t\t<header>");
			XMLFile.println("\t\t\t\t<column value=\"#\"/>");
			XMLFile.println("\t\t\t\t<column value=\"STATUS\"/>");
			XMLFile.println("\t\t\t\t<column value=\"OPERATOR\"/>");
			XMLFile.println("\t\t\t\t<column value=\"GET ON\"/>");
			XMLFile.println("\t\t\t</header>");

			String[][] mutants = result.getMutants();

			for (int i = 0; i < mutants.length; i++) {

				XMLFile.println("\t\t\t<row>");
				XMLFile.println("\t\t\t\t<column value=\""
						+ mutants[i][0].replace("&", "&amp;")
						.replace("\"", "&quot;").replace("'", "&apos;")
						.replace(">", "&gt;").replace("<", "&lt;")
						+ "\"/>");
				XMLFile.println("\t\t\t\t<column value=\""
						+ mutants[i][1].replace("&", "&amp;")
						.replace("\"", "&quot;").replace("'", "&apos;")
						.replace(">", "&gt;").replace("<", "&lt;")
						+ "\"/>");
				XMLFile.println("\t\t\t\t<column value=\""
						+ mutants[i][2].replace("&", "&amp;")
						.replace("\"", "&quot;").replace("'", "&apos;")
						.replace(">", "&gt;").replace("<", "&lt;")
						+ "\"/>");
				XMLFile.println("\t\t\t\t<column value=\""
						+ mutants[i][3].replace("&", "&amp;")
						.replace("\"", "&quot;").replace("'", "&apos;")
						.replace(">", "&gt;").replace("<", "&lt;")
						+ "\"/>");
				XMLFile.println("\t\t\t</row>");

			}

			XMLFile.println("\t\t</table>");
			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateAnomalousMutantsReport(List<Result> results,
			File rptDir) throws FileNotFoundException {

		File f = new File(rptDir, REPORT_ANOMALOUS_MUTANTS);

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"Anomalous Mutants\" tool=\"Proteum\">");

		for (Result result : results) {

			XMLFile.println("\t<section title=\"" + result.getSource()
					+ " Source\">");

			XMLFile.println("\t\t<table>");

			XMLFile.println("\t\t\t<header>");
			XMLFile.println("\t\t\t\t<column value=\"#\"/>");
			XMLFile.println("\t\t\t\t<column value=\"OPERATOR\"/>");
			XMLFile.println("\t\t\t\t<column value=\"GET ON\"/>");
			XMLFile.println("\t\t\t</header>");

			String[][] mutants = result.getMutants();

			for (int i = 0; i < mutants.length; i++) {

				if (mutants[i][1].equals("Anomalous")) {

					XMLFile.println("\t\t\t<row>");
					XMLFile.println("\t\t\t\t<column value=\""
							+ mutants[i][0].replace("&", "&amp;")
							.replace("\"", "&quot;").replace("'", "&apos;")
							.replace(">", "&gt;").replace("<", "&lt;") + "\"/>");
					XMLFile.println("\t\t\t\t<column value=\""
							+ mutants[i][2].replace("&", "&amp;")
							.replace("\"", "&quot;").replace("'", "&apos;")
							.replace(">", "&gt;").replace("<", "&lt;") + "\"/>");
					XMLFile.println("\t\t\t\t<column value=\""
							+ mutants[i][3].replace("&", "&amp;")
							.replace("\"", "&quot;").replace("'", "&apos;")
							.replace(">", "&gt;").replace("<", "&lt;") + "\"/>");
					XMLFile.println("\t\t\t</row>");

				}

			}

			XMLFile.println("\t\t</table>");
			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateAliveMutantsReport(List<Result> results,
			File rptDir) throws FileNotFoundException {

		File f = new File(rptDir, REPORT_ALIVE_MUTANTS);

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"Alive Mutants\" tool=\"Proteum\">");

		for (Result result : results) {

			XMLFile.println("\t<section title=\"" + result.getSource()
					+ " Source\">");

			XMLFile.println("\t\t<table>");

			XMLFile.println("\t\t\t<header>");
			XMLFile.println("\t\t\t\t<column value=\"#\"/>");
			XMLFile.println("\t\t\t\t<column value=\"OPERATOR\"/>");
			XMLFile.println("\t\t\t\t<column value=\"GET ON\"/>");
			XMLFile.println("\t\t\t</header>");

			String[][] mutants = result.getMutants();

			for (int i = 0; i < mutants.length; i++) {

				if (mutants[i][1].equals("Alive")) {

					XMLFile.println("\t\t\t<row>");
					XMLFile.println("\t\t\t\t<column value=\""
							+ mutants[i][0].replace("&", "&amp;")
							.replace("\"", "&quot;").replace("'", "&apos;")
							.replace(">", "&gt;").replace("<", "&lt;") + "\"/>");
					XMLFile.println("\t\t\t\t<column value=\""
							+ mutants[i][2].replace("&", "&amp;")
							.replace("\"", "&quot;").replace("'", "&apos;")
							.replace(">", "&gt;").replace("<", "&lt;") + "\"/>");
					XMLFile.println("\t\t\t\t<column value=\""
							+ mutants[i][3].replace("&", "&amp;")
							.replace("\"", "&quot;").replace("'", "&apos;")
							.replace(">", "&gt;").replace("<", "&lt;") + "\"/>");
					XMLFile.println("\t\t\t</row>");

				}

			}

			XMLFile.println("\t\t</table>");
			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateDeadMutantsReport(List<Result> results,
			File rptDir) throws FileNotFoundException {

		File f = new File(rptDir, REPORT_DEAD_MUTANTS);

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"Dead Mutants\" tool=\"Proteum\">");

		for (Result result : results) {

			XMLFile.println("\t<section title=\"" + result.getSource()
					+ " Source\">");

			XMLFile.println("\t\t<table>");

			XMLFile.println("\t\t\t<header>");
			XMLFile.println("\t\t\t\t<column value=\"#\"/>");
			XMLFile.println("\t\t\t\t<column value=\"OPERATOR\"/>");
			XMLFile.println("\t\t\t\t<column value=\"GET ON\"/>");
			XMLFile.println("\t\t\t</header>");

			String[][] mutants = result.getMutants();

			for (int i = 0; i < mutants.length; i++) {

				if (mutants[i][1].equals("Dead")) {

					XMLFile.println("\t\t\t<row>");
					XMLFile.println("\t\t\t\t<column value=\""
							+ mutants[i][0].replace("&", "&amp;")
							.replace("\"", "&quot;").replace("'", "&apos;")
							.replace(">", "&gt;").replace("<", "&lt;") + "\"/>");
					XMLFile.println("\t\t\t\t<column value=\""
							+ mutants[i][2].replace("&", "&amp;")
							.replace("\"", "&quot;").replace("'", "&apos;")
							.replace(">", "&gt;").replace("<", "&lt;") + "\"/>");
					XMLFile.println("\t\t\t\t<column value=\""
							+ mutants[i][3].replace("&", "&amp;")
							.replace("\"", "&quot;").replace("'", "&apos;")
							.replace(">", "&gt;").replace("<", "&lt;") + "\"/>");
					XMLFile.println("\t\t\t</row>");

				}

			}

			XMLFile.println("\t\t</table>");
			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

}
