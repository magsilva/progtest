package progtest.addons.jabutiservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Reporter {

	private static final String REPORT_COVERAGES = "Coverages.xml";

	private static final String REPORT_ALLNODESEI = "AllNodesei.xml";

	private static final String REPORT_ALLNODESED = "AllNodesed.xml";

	private static final String REPORT_ALLEDGESEI = "AllEdgesei.xml";

	private static final String REPORT_ALLEDGESED = "AllEdgesed.xml";

	private static final String REPORT_ALLUSESEI = "AllUsesei.xml";

	private static final String REPORT_ALLUSESED = "AllUsesed.xml";

	private static final String REPORT_ALLPOTUSESEI = "AllPotUsesei.xml";

	private static final String REPORT_ALLPOTUSESED = "AllPotUsesed.xml";

	public static void generateReports(Result r, File rptDir)
			throws FileNotFoundException {
		generateCoveragesReport(new File(rptDir + File.separator
				+ REPORT_COVERAGES), r);
		generateAllNodeseiReport(new File(rptDir + File.separator
				+ REPORT_ALLNODESEI), r);
		generateAllNodesedReport(new File(rptDir + File.separator
				+ REPORT_ALLNODESED), r);
		generateAllEdgeseiReport(new File(rptDir + File.separator
				+ REPORT_ALLEDGESEI), r);
		generateAllEdgesedReport(new File(rptDir + File.separator
				+ REPORT_ALLEDGESED), r);
		generateAllUseseiReport(new File(rptDir + File.separator
				+ REPORT_ALLUSESEI), r);
		generateAllUsesedReport(new File(rptDir + File.separator
				+ REPORT_ALLUSESED), r);
		generateAllPotUseseiReport(new File(rptDir + File.separator
				+ REPORT_ALLPOTUSESEI), r);
		generateAllPotUsesedReport(new File(rptDir + File.separator
				+ REPORT_ALLPOTUSESED), r);
	}

	private static void generateCoveragesReport(File f, Result r)
			throws FileNotFoundException {

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"Coverages\" tool=\"JaBUTiService\">");

		XMLFile.println("\t<section title=\"Coverages By Class\">");

		String data[][] = new String[r.getCoverageByClass().length][r
				.getCoverageByClass()[0].length];

		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[i].length; j++)
				data[i][j] = r.getCoverageByClass()[i][j].replace("&", "&amp;")
						.replace("\"", "&quot;").replace("'", "&apos;")
						.replace(">", "&gt;").replace("<", "&lt;");

		XMLFile.println("\t\t<table>");
		XMLFile.println("\t\t\t<header>");

		for (int j = 0; j < data[0].length && j < 5; j++)
			XMLFile.println("\t\t\t\t<column value=\"" + data[0][j] + "\"/>");

		XMLFile.println("\t\t\t</header>");

		for (int i = 1; i < data.length; i++) {

			XMLFile.println("\t\t\t<row>");

			for (int j = 0; j < data[i].length && j < 5; j++)
				XMLFile.println("\t\t\t\t<column value=\"" + data[i][j]
						+ "\"/>");

			XMLFile.println("\t\t\t</row>");

		}

		XMLFile.println("\t\t</table>");

		XMLFile.println("\t\t<table>");
		XMLFile.println("\t\t\t<header>");

		XMLFile.println("\t\t\t\t<column value=\"" + data[0][0] + "\"/>");

		for (int j = 5; j < data[0].length; j++)
			XMLFile.println("\t\t\t\t<column value=\"" + data[0][j] + "\"/>");

		XMLFile.println("\t\t\t</header>");

		for (int i = 1; i < data.length; i++) {

			XMLFile.println("\t\t\t<row>");
			XMLFile.println("\t\t\t\t<column value=\"" + data[i][0] + "\"/>");

			for (int j = 5; j < data[i].length; j++)
				XMLFile.println("\t\t\t\t<column value=\"" + data[i][j]
						+ "\"/>");

			XMLFile.println("\t\t\t</row>");

		}

		XMLFile.println("\t\t</table>");

		XMLFile.println("\t</section>");
		XMLFile.println("\t<section title=\"Coverages By Method\">");

		data = new String[r.getCoverageByMethod().length][r
				.getCoverageByMethod()[0].length];

		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[i].length; j++)
				data[i][j] = r.getCoverageByMethod()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		XMLFile.println("\t\t<table>");
		XMLFile.println("\t\t\t<header>");

		for (int j = 0; j < data[0].length && j < 5; j++)
			XMLFile.println("\t\t\t\t<column value=\"" + data[0][j] + "\"/>");

		XMLFile.println("\t\t\t</header>");

		for (int i = 1; i < data.length; i++) {

			XMLFile.println("\t\t\t<row>");

			for (int j = 0; j < data[i].length && j < 5; j++)
				XMLFile.println("\t\t\t\t<column value=\"" + data[i][j]
						+ "\"/>");

			XMLFile.println("\t\t\t</row>");

		}

		XMLFile.println("\t\t</table>");

		XMLFile.println("\t\t<table>");
		XMLFile.println("\t\t\t<header>");

		XMLFile.println("\t\t\t\t<column value=\"" + data[0][0] + "\"/>");

		for (int j = 5; j < data[0].length; j++)
			XMLFile.println("\t\t\t\t<column value=\"" + data[0][j] + "\"/>");

		XMLFile.println("\t\t\t</header>");

		for (int i = 1; i < data.length; i++) {

			XMLFile.println("\t\t\t<row>");
			XMLFile.println("\t\t\t\t<column value=\"" + data[i][0] + "\"/>");

			for (int j = 5; j < data[i].length; j++)
				XMLFile.println("\t\t\t\t<column value=\"" + data[i][j]
						+ "\"/>");

			XMLFile.println("\t\t\t</row>");

		}

		XMLFile.println("\t\t</table>");

		XMLFile.println("\t</section>");
		XMLFile.println("\t<section title=\"Coverages By Criterion\">");

		data = new String[r.getCoverageByCriterion().length][r
				.getCoverageByCriterion()[0].length];

		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[i].length; j++)
				data[i][j] = r.getCoverageByCriterion()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		XMLFile.println("\t\t<table>");
		XMLFile.println("\t\t\t<header>");

		for (int j = 0; j < data[0].length; j++)
			XMLFile.println("\t\t\t\t<column value=\"" + data[0][j] + "\"/>");

		XMLFile.println("\t\t\t</header>");

		for (int i = 1; i < data.length; i++) {

			XMLFile.println("\t\t\t<row>");

			for (int j = 0; j < data[i].length; j++)
				XMLFile.println("\t\t\t\t<column value=\"" + data[i][j]
						+ "\"/>");

			XMLFile.println("\t\t\t</row>");

		}

		XMLFile.println("\t\t</table>");
		XMLFile.println("\t</section>");

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateAllNodeseiReport(File f, Result r)
			throws FileNotFoundException {

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"All-Nodes-ei\" tool=\"JaBUTiService\">");

		String required[][] = new String[r.getRequiredElements().length][r
				.getRequiredElements()[0].length];
		String covered[][] = new String[r.getCoveredAndUncoveredElements().length][r
				.getCoveredAndUncoveredElements()[0].length];

		for (int i = 0; i < required.length; i++)
			for (int j = 0; j < required[i].length; j++)
				required[i][j] = r.getRequiredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 0; i < covered.length; i++)
			for (int j = 0; j < covered[i].length; j++)
				covered[i][j] = r.getCoveredAndUncoveredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 1; i < required.length && (i * 8 - 7) < covered.length; i++) {

			XMLFile.println("\t<section title=\"" + required[i][0] + "\">");

			if (required[i][1] != "")
				XMLFile.println("\t\t<text value=\"Required Elements: "
						+ required[i][1] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 7][2] != "")
				XMLFile.println("\t\t<text value=\"Covered Elements: "
						+ covered[i * 8 - 7][2] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 7][3] != "")
				XMLFile.println("\t\t<text value=\"Uncovered Elements: "
						+ covered[i * 8 - 7][3] + "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t\t<figure filename=\""
					+ "allnodesei-"
					+ required[i][0].replace("&amp;", "&")
							.replace("&quot;", "\"").replace("&apos;", "'")
							.replace("&gt;", ">").replace("&lt;", "<")
							.replaceAll("[^a-zA-Z 0-9]+", "") + ".png"
					+ "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateAllNodesedReport(File f, Result r)
			throws FileNotFoundException {

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"All-Nodes-ed\" tool=\"JaBUTiService\">");

		String required[][] = new String[r.getRequiredElements().length][r
				.getRequiredElements()[0].length];
		String covered[][] = new String[r.getCoveredAndUncoveredElements().length][r
				.getCoveredAndUncoveredElements()[0].length];

		for (int i = 0; i < required.length; i++)
			for (int j = 0; j < required[i].length; j++)
				required[i][j] = r.getRequiredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 0; i < covered.length; i++)
			for (int j = 0; j < covered[i].length; j++)
				covered[i][j] = r.getCoveredAndUncoveredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 1; i < required.length && (i * 8 - 7) < covered.length; i++) {

			XMLFile.println("\t<section title=\"" + required[i][0] + "\">");

			if (required[i][2] != "")
				XMLFile.println("\t\t<text value=\"Required Elements: "
						+ required[i][2] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 6][2] != "")
				XMLFile.println("\t\t<text value=\"Covered Elements: "
						+ covered[i * 8 - 6][2] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 6][3] != "")
				XMLFile.println("\t\t<text value=\"Uncovered Elements: "
						+ covered[i * 8 - 6][3] + "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t\t<figure filename=\"" + "allnodesed-"
					+ required[i][0].replace("&amp;", "&")
					.replace("&quot;", "\"").replace("&apos;", "'")
					.replace("&gt;", ">").replace("&lt;", "<")
					.replaceAll("[^a-zA-Z 0-9]+", "") + ".png"
					+ "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateAllEdgeseiReport(File f, Result r)
			throws FileNotFoundException {

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"All-Edges-ei\" tool=\"JaBUTiService\">");

		String required[][] = new String[r.getRequiredElements().length][r
				.getRequiredElements()[0].length];
		String covered[][] = new String[r.getCoveredAndUncoveredElements().length][r
				.getCoveredAndUncoveredElements()[0].length];

		for (int i = 0; i < required.length; i++)
			for (int j = 0; j < required[i].length; j++)
				required[i][j] = r.getRequiredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 0; i < covered.length; i++)
			for (int j = 0; j < covered[i].length; j++)
				covered[i][j] = r.getCoveredAndUncoveredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 1; i < required.length && (i * 8 - 7) < covered.length; i++) {

			XMLFile.println("\t<section title=\"" + required[i][0] + "\">");

			if (required[i][3] != "")
				XMLFile.println("\t\t<text value=\"Required Elements: "
						+ required[i][3] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 5][2] != "")
				XMLFile.println("\t\t<text value=\"Covered Elements: "
						+ covered[i * 8 - 5][2] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 5][3] != "")
				XMLFile.println("\t\t<text value=\"Uncovered Elements: "
						+ covered[i * 8 - 5][3] + "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t\t<figure filename=\"" + "alledgesei-"
					+ required[i][0].replace("&amp;", "&")
					.replace("&quot;", "\"").replace("&apos;", "'")
					.replace("&gt;", ">").replace("&lt;", "<")
					.replaceAll("[^a-zA-Z 0-9]+", "") + ".png"
					+ "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateAllEdgesedReport(File f, Result r)
			throws FileNotFoundException {

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"All-Edges-ed\" tool=\"JaBUTiService\">");

		String required[][] = new String[r.getRequiredElements().length][r
				.getRequiredElements()[0].length];
		String covered[][] = new String[r.getCoveredAndUncoveredElements().length][r
				.getCoveredAndUncoveredElements()[0].length];

		for (int i = 0; i < required.length; i++)
			for (int j = 0; j < required[i].length; j++)
				required[i][j] = r.getRequiredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 0; i < covered.length; i++)
			for (int j = 0; j < covered[i].length; j++)
				covered[i][j] = r.getCoveredAndUncoveredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 1; i < required.length && (i * 8 - 7) < covered.length; i++) {

			XMLFile.println("\t<section title=\"" + required[i][0] + "\">");

			if (required[i][4] != "")
				XMLFile.println("\t\t<text value=\"Required Elements: "
						+ required[i][4] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 4][2] != "")
				XMLFile.println("\t\t<text value=\"Covered Elements: "
						+ covered[i * 8 - 4][2] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 4][3] != "")
				XMLFile.println("\t\t<text value=\"Uncovered Elements: "
						+ covered[i * 8 - 4][3] + "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t\t<figure filename=\"" + "alledgesed-"
					+ required[i][0].replace("&amp;", "&")
					.replace("&quot;", "\"").replace("&apos;", "'")
					.replace("&gt;", ">").replace("&lt;", "<")
					.replaceAll("[^a-zA-Z 0-9]+", "") + ".png"
					+ "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateAllUseseiReport(File f, Result r)
			throws FileNotFoundException {

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"All-Uses-ei\" tool=\"JaBUTiService\">");

		String required[][] = new String[r.getRequiredElements().length][r
				.getRequiredElements()[0].length];
		String covered[][] = new String[r.getCoveredAndUncoveredElements().length][r
				.getCoveredAndUncoveredElements()[0].length];

		for (int i = 0; i < required.length; i++)
			for (int j = 0; j < required[i].length; j++)
				required[i][j] = r.getRequiredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 0; i < covered.length; i++)
			for (int j = 0; j < covered[i].length; j++)
				covered[i][j] = r.getCoveredAndUncoveredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 1; i < required.length && (i * 8 - 7) < covered.length; i++) {

			XMLFile.println("\t<section title=\"" + required[i][0] + "\">");

			if (required[i][5] != "")
				XMLFile.println("\t\t<text value=\"Required Elements: "
						+ required[i][5] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 3][2] != "")
				XMLFile.println("\t\t<text value=\"Covered Elements: "
						+ covered[i * 8 - 3][2] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 3][3] != "")
				XMLFile.println("\t\t<text value=\"Uncovered Elements: "
						+ covered[i * 8 - 3][3] + "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t\t<figure filename=\"" + "allusesei-"
					+ required[i][0].replace("&amp;", "&")
					.replace("&quot;", "\"").replace("&apos;", "'")
					.replace("&gt;", ">").replace("&lt;", "<")
					.replaceAll("[^a-zA-Z 0-9]+", "") + ".png"
					+ "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateAllUsesedReport(File f, Result r)
			throws FileNotFoundException {

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"All-Uses-ed\" tool=\"JaBUTiService\">");

		String required[][] = new String[r.getRequiredElements().length][r
				.getRequiredElements()[0].length];
		String covered[][] = new String[r.getCoveredAndUncoveredElements().length][r
				.getCoveredAndUncoveredElements()[0].length];

		for (int i = 0; i < required.length; i++)
			for (int j = 0; j < required[i].length; j++)
				required[i][j] = r.getRequiredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 0; i < covered.length; i++)
			for (int j = 0; j < covered[i].length; j++)
				covered[i][j] = r.getCoveredAndUncoveredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 1; i < required.length && (i * 8 - 7) < covered.length; i++) {

			XMLFile.println("\t<section title=\"" + required[i][0] + "\">");

			if (required[i][6] != "")
				XMLFile.println("\t\t<text value=\"Required Elements: "
						+ required[i][6] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 2][2] != "")
				XMLFile.println("\t\t<text value=\"Covered Elements: "
						+ covered[i * 8 - 2][2] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 2][3] != "")
				XMLFile.println("\t\t<text value=\"Uncovered Elements: "
						+ covered[i * 8 - 2][3] + "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t\t<figure filename=\"" + "allusesed-"
					+ required[i][0].replace("&amp;", "&")
					.replace("&quot;", "\"").replace("&apos;", "'")
					.replace("&gt;", ">").replace("&lt;", "<")
					.replaceAll("[^a-zA-Z 0-9]+", "") + ".png"
					+ "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateAllPotUseseiReport(File f, Result r)
			throws FileNotFoundException {

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"All-Pot-Uses-ei\" tool=\"JaBUTiService\">");

		String required[][] = new String[r.getRequiredElements().length][r
				.getRequiredElements()[0].length];
		String covered[][] = new String[r.getCoveredAndUncoveredElements().length][r
				.getCoveredAndUncoveredElements()[0].length];

		for (int i = 0; i < required.length; i++)
			for (int j = 0; j < required[i].length; j++)
				required[i][j] = r.getRequiredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 0; i < covered.length; i++)
			for (int j = 0; j < covered[i].length; j++)
				covered[i][j] = r.getCoveredAndUncoveredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 1; i < required.length && (i * 8 - 7) < covered.length; i++) {

			XMLFile.println("\t<section title=\"" + required[i][0] + "\">");

			if (required[i][7] != "")
				XMLFile.println("\t\t<text value=\"Required Elements: "
						+ required[i][7] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 1][2] != "")
				XMLFile.println("\t\t<text value=\"Covered Elements: "
						+ covered[i * 8 - 1][2] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8 - 1][3] != "")
				XMLFile.println("\t\t<text value=\"Uncovered Elements: "
						+ covered[i * 8 - 1][3] + "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t\t<figure filename=\"" + "allpotusesei-"
					+ required[i][0].replace("&amp;", "&")
					.replace("&quot;", "\"").replace("&apos;", "'")
					.replace("&gt;", ">").replace("&lt;", "<")
					.replaceAll("[^a-zA-Z 0-9]+", "") + ".png"
					+ "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static void generateAllPotUsesedReport(File f, Result r)
			throws FileNotFoundException {

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report name=\"All-Pot-Uses-ed\" tool=\"JaBUTiService\">");

		String required[][] = new String[r.getRequiredElements().length][r
				.getRequiredElements()[0].length];
		String covered[][] = new String[r.getCoveredAndUncoveredElements().length][r
				.getCoveredAndUncoveredElements()[0].length];

		for (int i = 0; i < required.length; i++)
			for (int j = 0; j < required[i].length; j++)
				required[i][j] = r.getRequiredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 0; i < covered.length; i++)
			for (int j = 0; j < covered[i].length; j++)
				covered[i][j] = r.getCoveredAndUncoveredElements()[i][j]
						.replace("&", "&amp;").replace("\"", "&quot;")
						.replace("'", "&apos;").replace(">", "&gt;")
						.replace("<", "&lt;");

		for (int i = 1; i < required.length && (i * 8 - 7) < covered.length; i++) {

			XMLFile.println("\t<section title=\"" + required[i][0] + "\">");

			if (required[i][8] != "")
				XMLFile.println("\t\t<text value=\"Required Elements: "
						+ required[i][8] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8][2] != "")
				XMLFile.println("\t\t<text value=\"Covered Elements: "
						+ covered[i * 8][2] + "\" color=\"#FFFFFF\"/>");

			if (covered[i * 8][3] != "")
				XMLFile.println("\t\t<text value=\"Uncovered Elements: "
						+ covered[i * 8][3] + "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t\t<figure filename=\"" + "allpotusesed-"
					+ required[i][0].replace("&amp;", "&")
					.replace("&quot;", "\"").replace("&apos;", "'")
					.replace("&gt;", ">").replace("&lt;", "<")
					.replaceAll("[^a-zA-Z 0-9]+", "") + ".png"
					+ "\" color=\"#FFFFFF\"/>");

			XMLFile.println("\t</section>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

}
