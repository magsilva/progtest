package progtest.reports.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import progtest.reports.Object;
import progtest.reports.Report;
import progtest.reports.Row;
import progtest.reports.Section;

public class Report2XML {

	public static void generate(Report report, File reportFile)
			throws FileNotFoundException {

		if (!reportFile.getParentFile().exists())
			reportFile.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(reportFile));

		XMLFile.println("<?xml version='1.0'?>");

		if (report != null) {

			XMLFile.println("<report name=\"" + report.getName() + "\">");

			for (Section section : report.getSections()) {

				XMLFile.println("\t<section title=\"" + section.getTitle()
						+ "\">");

				for (Object object : section.getObjects()) {

					if (object.getType() == Object.TYPE_TEXT) {

						XMLFile.println("\t\t<text value=\""
								+ object.getTextValue() + "\" color=\""
								+ object.getTextColor() + "\"/>");

					} else if (object.getType() == Object.TYPE_TABLE) {

						XMLFile.println("\t\t<table>");

						XMLFile.println("\t\t\t<header>");

						for (int i = 1; i <= 10; i++) {

							String column = null;

							switch (i) {
							case 1:
								column = object.getTableHeader().getColumn1();
								break;
							case 2:
								column = object.getTableHeader().getColumn2();
								break;
							case 3:
								column = object.getTableHeader().getColumn3();
								break;
							case 4:
								column = object.getTableHeader().getColumn4();
								break;
							case 5:
								column = object.getTableHeader().getColumn5();
								break;
							case 6:
								column = object.getTableHeader().getColumn6();
								break;
							case 7:
								column = object.getTableHeader().getColumn7();
								break;
							case 8:
								column = object.getTableHeader().getColumn8();
								break;
							case 9:
								column = object.getTableHeader().getColumn9();
								break;
							case 10:
								column = object.getTableHeader().getColumn10();
								break;
							}

							if (column != null)
								XMLFile.println("\t\t\t\t<column value=\""
										+ column + "\"/>");

						}

						XMLFile.println("\t\t\t</header>");

						for (Row row : object.getTableRows()) {

							XMLFile.println("\t\t\t<row>");

							for (int i = 1; i <= 10; i++) {

								String column = null;

								switch (i) {
								case 1:
									column = row.getColumn1();
									break;
								case 2:
									column = row.getColumn2();
									break;
								case 3:
									column = row.getColumn3();
									break;
								case 4:
									column = row.getColumn4();
									break;
								case 5:
									column = row.getColumn5();
									break;
								case 6:
									column = row.getColumn6();
									break;
								case 7:
									column = row.getColumn7();
									break;
								case 8:
									column = row.getColumn8();
									break;
								case 9:
									column = row.getColumn9();
									break;
								case 10:
									column = row.getColumn10();
									break;
								}

								if (column != null)
									XMLFile.println("\t\t\t\t<column value=\""
											+ column + "\"/>");

							}

							XMLFile.println("\t\t\t</row>");

						}

						XMLFile.println("\t\t</table>");

					} else if (object.getType() == Object.TYPE_FIGURE) {

					}

				}

				XMLFile.println("\t</section>");

			}

			XMLFile.println("</report>");

		}

		XMLFile.close();

	}

}
