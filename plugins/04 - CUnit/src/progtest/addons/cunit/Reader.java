package progtest.addons.cunit;

import java.io.File;

import org.w3c.dom.Node;

public class Reader {

	private static final String CUNIT_TEST_RUN_REPORT = "CUNIT_TEST_RUN_REPORT";

	private static final String CUNIT_RUN_SUMMARY = "CUNIT_RUN_SUMMARY";
	private static final String CUNIT_RUN_SUMMARY_RECORD = "CUNIT_RUN_SUMMARY_RECORD";

	private static final String TYPE = "TYPE";
	private static final String TOTAL = "TOTAL";
	private static final String RUN = "RUN";
	private static final String SUCCEEDED = "SUCCEEDED";
	private static final String FAILED = "FAILED";
	private static final String INACTIVE = "INACTIVE";

	private static final String TEST_CASES = " Test Cases ";

	private static final String CUNIT_RESULT_LISTING = "CUNIT_RESULT_LISTING";
	private static final String CUNIT_RUN_SUITE = "CUNIT_RUN_SUITE";
	private static final String CUNIT_RUN_SUITE_SUCCESS = "CUNIT_RUN_SUITE_SUCCESS";
	private static final String CUNIT_RUN_TEST_RECORD = "CUNIT_RUN_TEST_RECORD";

	private static final String CUNIT_RUN_TEST_SUCCESS = "CUNIT_RUN_TEST_SUCCESS";
	private static final String CUNIT_RUN_TEST_FAILURE = "CUNIT_RUN_TEST_FAILURE";

	private static final String SUITE_NAME = "SUITE_NAME";
	private static final String TEST_NAME = "TEST_NAME";
	private static final String TEST_RESULT = "TEST_RESULT";
	private static final String FILE_NAME = "FILE_NAME";
	private static final String LINE_NUMBER = "LINE_NUMBER";
	private static final String CONDITION = "CONDITION";

	private static final String PASS = "PASS";
	private static final String FAIL = "FAIL";

	private Node root;

	private Result result = new Result();

	public Result getResult() {
		return result;
	}

	public Reader(File cunit_output) throws Throwable {

		try {

			root = XMLUtil.load(cunit_output);
			readMainValues();
			readSummary();
			readListing();

		} catch (Throwable t) {

			throw t;

		}

	}

	private void readMainValues() {

		try {

			if (root.getNodeName().equals(CUNIT_TEST_RUN_REPORT))
				for (int i = 0; i < root.getChildNodes().getLength(); i++) {
					Node a = root.getChildNodes().item(i);
					if (a.getNodeName().equals(CUNIT_RUN_SUMMARY))
						for (int j = 0; j < a.getChildNodes().getLength(); j++) {
							Node b = a.getChildNodes().item(j);
							if (b.getNodeName()
									.equals(CUNIT_RUN_SUMMARY_RECORD)) {
								boolean isTestCases = false;
								for (int k = 0; k < b.getChildNodes()
										.getLength(); k++) {
									Node c = b.getChildNodes().item(k);
									if (c.getNodeName().equals(TYPE))
										if (c.getChildNodes().item(0)
												.getNodeValue()
												.equals(TEST_CASES))
											isTestCases = true;
									if (isTestCases
											&& c.getNodeName().equals(TOTAL))
										result.setTotal(Double.parseDouble(c
												.getChildNodes().item(0)
												.getNodeValue()));
									if (isTestCases
											&& c.getNodeName()
													.equals(SUCCEEDED))
										result.setSuceeded(Double.parseDouble(c
												.getChildNodes().item(0)
												.getNodeValue()));
								}
							}
						}
				}

		} catch (Throwable e) {

			e.printStackTrace();

		}

	}

	private void readSummary() {

		String[][] summary = new String[4][6];

		summary[0][0] = TYPE;
		summary[0][1] = TOTAL;
		summary[0][2] = RUN;
		summary[0][3] = SUCCEEDED;
		summary[0][4] = FAILED;
		summary[0][5] = INACTIVE;

		for (int i = 1; i < 4; i++)
			for (int j = 0; j < 6; j++)
				summary[i][j] = "";

		try {

			if (root.getNodeName().equals(CUNIT_TEST_RUN_REPORT))
				for (int i = 0; i < root.getChildNodes().getLength(); i++) {
					Node a = root.getChildNodes().item(i);
					if (a.getNodeName().equals(CUNIT_RUN_SUMMARY))
						for (int j = 0; j < a.getChildNodes().getLength(); j++) {
							Node b = a.getChildNodes().item(j);
							if (b.getNodeName()
									.equals(CUNIT_RUN_SUMMARY_RECORD)) {
								for (int k = 0; k < b.getChildNodes()
										.getLength(); k++) {
									Node c = b.getChildNodes().item(k);
									if (c.getNodeName().equals(TYPE))
										summary[j + 1][0] = c.getChildNodes()
												.item(0).getNodeValue();
									if (c.getNodeName().equals(TOTAL))
										summary[j + 1][1] = c.getChildNodes()
												.item(0).getNodeValue();
									if (c.getNodeName().equals(RUN))
										summary[j + 1][2] = c.getChildNodes()
												.item(0).getNodeValue();
									if (c.getNodeName().equals(SUCCEEDED))
										summary[j + 1][3] = c.getChildNodes()
												.item(0).getNodeValue();
									if (c.getNodeName().equals(FAILED))
										summary[j + 1][4] = c.getChildNodes()
												.item(0).getNodeValue();
									if (c.getNodeName().equals(INACTIVE))
										summary[j + 1][5] = c.getChildNodes()
												.item(0).getNodeValue();
								}
							}
						}
				}

		} catch (Throwable e) {

			e.printStackTrace();

		}

		result.setSummary(summary);

	}

	private void readListing() {

		int nlines = ((int) result.getTotal()) + 1;

		String[][] listing = new String[nlines][4];

		listing[0][0] = SUITE_NAME;
		listing[0][1] = TEST_NAME;
		listing[0][2] = TEST_RESULT;
		listing[0][3] = CONDITION;

		for (int i = 1; i < nlines; i++)
			for (int j = 0; j < 4; j++)
				listing[i][j] = "";

		try {

			if (root.getNodeName().equals(CUNIT_TEST_RUN_REPORT)) {
				for (int i = 0; i < root.getChildNodes().getLength(); i++) {
					Node a = root.getChildNodes().item(i);
					if (a.getNodeName().equals(CUNIT_RESULT_LISTING)) {
						for (int j = 0; j < a.getChildNodes().getLength(); j++) {
							Node b = a.getChildNodes().item(j);
							if (b.getNodeName().equals(CUNIT_RUN_SUITE)) {
								for (int k = 0; k < b.getChildNodes()
										.getLength(); k++) {
									Node c = b.getChildNodes().item(k);
									if (c.getNodeName().equals(
											CUNIT_RUN_SUITE_SUCCESS)) {
										String suite_name = "";
										for (int l = 0; l < c.getChildNodes()
												.getLength(); l++) {
											Node d = c.getChildNodes().item(l);
											if (d.getNodeName().equals(
													SUITE_NAME)) {
												suite_name = d.getTextContent();
											}
											if (d.getNodeName().equals(
													CUNIT_RUN_TEST_RECORD)) {
												for (int m = 0; m < d
														.getChildNodes()
														.getLength(); m++) {
													Node e = d.getChildNodes()
															.item(m);
													if (e.getNodeName()
															.equals(CUNIT_RUN_TEST_SUCCESS)) {
														for (int n = 0; n < e
																.getChildNodes()
																.getLength(); n++) {
															Node f = e
																	.getChildNodes()
																	.item(n);
															listing[l][0] = suite_name;
															if (f.getNodeName()
																	.equals(TEST_NAME)) {
																listing[l][1] = f
																		.getChildNodes()
																		.item(0)
																		.getNodeValue();
															}
															listing[l][2] = PASS;
														}
													}
													if (e.getNodeName()
															.equals(CUNIT_RUN_TEST_FAILURE)) {
														for (int n = 0; n < e
																.getChildNodes()
																.getLength(); n++) {
															Node f = e
																	.getChildNodes()
																	.item(n);
															listing[l][0] = suite_name;
															if (f.getNodeName()
																	.equals(TEST_NAME)) {
																listing[l][1] = f
																		.getChildNodes()
																		.item(0)
																		.getNodeValue();
															}
															listing[l][2] = FAIL;
															if (f.getNodeName()
																	.equals(FILE_NAME)) {
																listing[l][3] += "File: " + f
																		.getChildNodes()
																		.item(0)
																		.getNodeValue().substring(f
																		.getChildNodes()
																		.item(0)
																		.getNodeValue().lastIndexOf(File.separator) + 1)
																		+ " ";
															}
															if (f.getNodeName()
																	.equals(LINE_NUMBER)) {
																listing[l][3] += "Line: " + f
																		.getChildNodes()
																		.item(0)
																		.getNodeValue()
																		+ " ";
															}
															if (f.getNodeName()
																	.equals(CONDITION)) {
																listing[l][3] += f
																		.getChildNodes()
																		.item(0)
																		.getNodeValue()
																		+ " ";
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}

		} catch (Throwable e) {

			e.printStackTrace();

		}

		result.setListing(listing);

	}

}
