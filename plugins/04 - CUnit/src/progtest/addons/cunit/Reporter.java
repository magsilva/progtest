package progtest.addons.cunit;

import java.io.File;

public class Reporter {
	
	private static final String REPORT_SUMMARY_FILENAME = "Run Summary.xml";
	
	private static final String REPORT_LISTING_FILENAME = "Result Listing.xml";

	public static void generateSummaryReport(File rptDir, String[][] summary) throws Throwable {
		File file = new File(rptDir + File.separator + REPORT_SUMMARY_FILENAME);
		XMLUtil.generateXML(file, summary);
	}

	public static void generateListingReport(File rptDir, String[][] listing) throws Throwable {
		File file = new File(rptDir + File.separator + REPORT_LISTING_FILENAME);
		XMLUtil.generateXML(file, listing);
	}

}
