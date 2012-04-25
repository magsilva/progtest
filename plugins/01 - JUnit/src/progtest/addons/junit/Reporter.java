package progtest.addons.junit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Reporter {

	private static final String REPORT_RUNNING = "Running Report.xml";

	public static void generateJUnitReport(List<Result> results, File rpt) {

		int runCount = 0;
		int failureCount = 0;

		long runtime = 0;

		List<Failure> failures = new ArrayList<Failure>();

		for (int i = 0; i < results.size(); i++) {

			Result r = results.get(i);

			runCount += r.getRunCount();
			failureCount += r.getFailureCount();
			runtime += r.getRunTime();

			failures.addAll(r.getFailures());

		}

		try {

			File xmlFile = new File(rpt.getPath() + File.separator
					+ REPORT_RUNNING);

			generateXML(xmlFile, runCount, failureCount, runtime, failures);

		} catch (Throwable e) {

			System.err
					.println("Error: Report not generated: " + e.getMessage());

		}

	}

	private static void generateXML(File xmlFile, int runCount,
			int failureCount, long runtime, List<Failure> failures)
			throws FileNotFoundException, SecurityException {

		if (!xmlFile.getParentFile().exists())
			xmlFile.getParentFile().mkdirs();

		PrintWriter pw = new PrintWriter(new FileOutputStream(xmlFile));

		pw.println("<?xml version='1.0'?>");

		pw.println("<report name=\"Running Report\" tool=\"JUnit\">");

		pw.println("\t<section title=\"Running\">");
		pw.println("\t\t<table>");
		pw.println("\t\t\t<header>");
		pw.println("\t\t\t\t<column value=\"Runs\"/>");
		pw.println("\t\t\t\t<column value=\"Failures\"/>");
		pw.println("\t\t\t\t<column value=\"Runtime\"/>");
		pw.println("\t\t\t</header>");
		pw.println("\t\t\t<row>");
		pw.println("\t\t\t\t<column value=\"" + runCount + "\"/>");
		pw.println("\t\t\t\t<column value=\"" + failureCount + "\"/>");
		pw.println("\t\t\t\t<column value=\"" + runtime + "ms\"/>");
		pw.println("\t\t\t</row>");
		pw.println("\t\t</table>");
		pw.println("\t</section>");

		if (!failures.isEmpty()) {

			pw.println("\t<section title=\"Failures\">");

			for (Failure failure : failures) {

				String line = failure.toString();

				pw.println("\t\t<text value=\""
						+ line.replace("&", "&amp;").replace("\"", "&quot;")
								.replace("'", "&apos;").replace(">", "&gt;")
								.replace("<", "&lt;")
						+ "\" color=\"#FFFFFF\"/>");

			}

			pw.println("\t</section>");

		}

		pw.println("</report>");

		pw.close();

	}

}
