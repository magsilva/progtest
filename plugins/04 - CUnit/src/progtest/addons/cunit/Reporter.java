package progtest.addons.cunit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Reporter {
	
	private static final String REPORT_SUMMARY_REPORT = "Summary.xml";
	
	private static final String REPORT_RESULT_LISTING = "Result Listing.xml";
	
	public static void generateReports(File rptDir, Result result) throws Throwable {
		generateSummaryReport(rptDir, result.getSummary());
		generateResultListingReport(rptDir, result.getListing());
	}

	private static void generateSummaryReport(File rptDir, String[][] summary) throws Throwable {
		
		File xmlFile = new File(rptDir + File.separator + REPORT_SUMMARY_REPORT);
		
		try {
			
			if (!xmlFile.getParentFile().exists())
				xmlFile.getParentFile().mkdirs();
			
			PrintWriter pw = new PrintWriter(new FileOutputStream(xmlFile));
			pw.println("<?xml version='1.0'?>");
			pw.println("<report name=\"Summay\" tool=\"CUnit\">");
			pw.println("\t<section title=\"Run Summary\">");
			pw.println("\t\t<table>");
			
			pw.println("\t\t\t<header>");
			
			for (int j = 0; j < summary[0].length; j++)
				pw.println("\t\t\t\t<column value=\"" + summary[0][j] + "\"/>");
			
			pw.println("\t\t\t</header>");

			for (int i = 1; i < summary.length; i++) {

				pw.println("\t\t\t<row>");

				for (int j = 0; j < summary[i].length; j++)
					pw.println("\t\t\t\t<column value=\"" + summary[i][j] + "\"/>");

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

	private static void generateResultListingReport(File rptDir, String[][] listing) throws Throwable {
		
		File xmlFile = new File(rptDir + File.separator + REPORT_RESULT_LISTING);
		
		try {
			
			if (!xmlFile.getParentFile().exists())
				xmlFile.getParentFile().mkdirs();
			
			PrintWriter pw = new PrintWriter(new FileOutputStream(xmlFile));
			pw.println("<?xml version='1.0'?>");
			pw.println("<report name=\"Result Listing\" tool=\"CUnit\">");
			pw.println("\t<section title=\"Results\">");
			pw.println("\t\t<table>");
			
			pw.println("\t\t\t<header>");
			
			for (int j = 0; j < listing[0].length; j++)
				pw.println("\t\t\t\t<column value=\"" + listing[0][j] + "\"/>");
			
			pw.println("\t\t\t</header>");

			for (int i = 1; i < listing.length; i++) {

				pw.println("\t\t\t<row>");

				for (int j = 0; j < listing[i].length; j++)
					pw.println("\t\t\t\t<column value=\"" + listing[i][j] + "\"/>");

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

}
