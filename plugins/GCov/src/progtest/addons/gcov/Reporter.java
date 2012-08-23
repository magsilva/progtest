package progtest.addons.gcov;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Reporter {

	private static final String REPORT_COVERAGES = "Coverages.xml";

	private static final String REPORT_SOURCES = "Sources.xml";

	public static void generateReports(File rptDir, Result result)
			throws Throwable {
		generateCoveragesReport(rptDir, result.getCoverages());
		generateSourcesReport(rptDir, result.getSources());
	}

	private static void generateCoveragesReport(File rptDir,
			String[][] coverages) throws Throwable {

		File xmlFile = new File(rptDir + File.separator + REPORT_COVERAGES);

		try {

			if (!xmlFile.getParentFile().exists())
				xmlFile.getParentFile().mkdirs();

			PrintWriter pw = new PrintWriter(new FileOutputStream(xmlFile));
			pw.println("<?xml version='1.0'?>");
			pw.println("<report name=\"Coverages\" tool=\"GCov\">");
			pw.println("\t<section title=\"Summary\">");
			pw.println("\t\t<table>");

			pw.println("\t\t\t<header>");
			pw.println("\t\t\t\t<column value=\"Source\"/>");
			pw.println("\t\t\t\t<column value=\"Lines\"/>");
			pw.println("\t\t\t\t<column value=\"Branches\"/>");
			pw.println("\t\t\t\t<column value=\"Taken at Least Once\"/>");
			pw.println("\t\t\t\t<column value=\"Calls\"/>");
			pw.println("\t\t\t</header>");

			for (int i = 0; i < coverages.length; i++) {

				pw.println("\t\t\t<row>");
				pw.println("\t\t\t\t<column value=\"" + coverages[i][0]
						+ "\"/>");
				pw.println("\t\t\t\t<column value=\"" + coverages[i][1]
						+ " of " + coverages[i][2] + "\"/>");
				pw.println("\t\t\t\t<column value=\"" + coverages[i][3]
						+ " of " + coverages[i][4] + "\"/>");
				pw.println("\t\t\t\t<column value=\"" + coverages[i][5]
						+ " of " + coverages[i][6] + "\"/>");
				pw.println("\t\t\t\t<column value=\"" + coverages[i][7]
						+ " of " + coverages[i][8] + "\"/>");
				pw.println("\t\t\t</row>");

			}

			pw.println("\t\t</table>");
			pw.println("\t</section>");
			pw.println("</report>");
			pw.close();

		} catch (Throwable t) {

			throw t;

		}

	}

	private static void generateSourcesReport(File rptDir, List<File> sources) throws IOException {

		PrintWriter pw = new PrintWriter(rptDir + File.separator
				+ REPORT_SOURCES);
		
		pw.write("<?xml version='1.0'?>\n");
		pw.write("<report name=\"Sources\" tool=\"GCov\">\n");

		for (File source : sources) {

			FileReader fr = null;
			BufferedReader br = null;

			try {

				pw.write("\t<section title=\"" + source.getName() + "\">\n");

				fr = new FileReader(source);
				br = new BufferedReader(fr);

				while (br.ready()) {

					String line = br.readLine().replace("&", "&amp;")
							.replace("\"", "&quot;").replace("'", "&apos;")
							.replace(">", "&gt;").replace("<", "&lt;");

					if (!line.startsWith("branch") && !line.startsWith("call")
							&& !line.startsWith("function")
							&& !line.startsWith("        -:    0")) {

						if (line.startsWith("    #####"))
							pw.write("\t\t<text value=\"" + line.substring(4)
									+ "\" color=\"#FF0000\"/>\n");
						else
							pw.write("\t\t<text value=\"" + line.substring(4)
									+ "\" color=\"#FFFFFF\"/>\n");

					}

				}

				pw.write("\t</section>\n");

			} finally {

				if (br != null)
					br.close();
				if (fr != null)
					fr.close();

			}

			pw.write("</report>\n");
			pw.close();

		}

	}

}
