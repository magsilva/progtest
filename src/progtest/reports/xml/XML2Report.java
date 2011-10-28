package progtest.reports.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import progtest.reports.Object;
import progtest.reports.Report;
import progtest.reports.Row;
import progtest.reports.Section;
import progtest.util.Constants;
import progtest.util.FileUtil;

public class XML2Report {

	private static final String TAG_REPORT = "report";

	private static final String TAG_SECTION = "section";

	private static final String TAG_TEXT = "text";

	private static final String TAG_TABLE = "table";

	private static final String TAG_HEADER = "header";

	private static final String TAG_ROW = "row";

	private static final String TAG_COLUMN = "column";

	private static final String TAG_FIGURE = "figure";

	private static final String ATTR_TOOL = "tool";

	private static final String ATTR_NAME = "name";

	private static final String ATTR_TITLE = "title";

	private static final String ATTR_TEXTVALUE = "value";

	private static final String ATTR_TEXTCOLOR = "color";

	private static final String ATTR_COLUMNVALUE = "value";

	private static final String ATTR_FILENAME = "filename";

	private static final String DIR_FIGURES = Constants.PATH_FIGURES;

	public static Report parse(File xmlFile) throws Throwable {

		Report report = null;

		Element root = load(xmlFile);

		if (root.getNodeName().equals(TAG_REPORT)) {
			report = new Report();
			for (int i = 0; i < root.getAttributes().getLength(); i++) {
				if (root.getAttributes().item(i).getNodeName()
						.equals(ATTR_TOOL))
					report.setTool(root.getAttributes().item(i).getNodeValue());
				if (root.getAttributes().item(i).getNodeName()
						.equals(ATTR_NAME))
					report.setName(root.getAttributes().item(i).getNodeValue());
			}
			for (int i = 0; i < root.getChildNodes().getLength(); i++) {
				Node a = root.getChildNodes().item(i);
				if (a.getNodeName().equals(TAG_SECTION)) {
					Section section = new Section();
					for (int j = 0; j < a.getAttributes().getLength(); j++) {
						if (a.getAttributes().item(j).getNodeName()
								.equals(ATTR_TITLE))
							section.setTitle(a.getAttributes().item(j)
									.getNodeValue());
					}
					for (int j = 0; j < a.getChildNodes().getLength(); j++) {
						Node b = a.getChildNodes().item(j);
						if (b.getNodeName().equals(TAG_TEXT)) {
							Object object = new Object(Object.TYPE_TEXT);
							for (int k = 0; k < b.getAttributes().getLength(); k++) {
								if (b.getAttributes().item(k).getNodeName()
										.equals(ATTR_TEXTVALUE))
									object.setTextValue(b.getAttributes()
											.item(k).getNodeValue());
							}
							for (int k = 0; k < b.getAttributes().getLength(); k++) {
								if (b.getAttributes().item(k).getNodeName()
										.equals(ATTR_TEXTCOLOR))
									object.setTextColor(b.getAttributes()
											.item(k).getNodeValue());
							}
							while (object.getTextValue().length() > 70) {
								Object object2 = new Object(Object.TYPE_TEXT);
								object2.setTextColor(object.getTextColor());
								object2.setTextValue(object.getTextValue().substring(0, 70)
										.replace("&", "&amp;").replace("\"", "&quot;")
										.replace("'", "&apos;").replace(">", "&gt;")
										.replace("<", "&lt;").replace(" ", "&nbsp;"));
								section.getObjects().add(object2);
								object.setTextValue(object.getTextValue().substring(70));
							}
							object.setTextValue(object.getTextValue()
									.replace("&", "&amp;").replace("\"", "&quot;")
									.replace("'", "&apos;").replace(">", "&gt;")
									.replace("<", "&lt;").replace(" ", "&nbsp;"));
							section.getObjects().add(object);
						}
						if (b.getNodeName().equals(TAG_TABLE)) {
							Object object = new Object(Object.TYPE_TABLE);
							for (int k = 0; k < b.getChildNodes().getLength(); k++) {
								Node c = b.getChildNodes().item(k);
								if (c.getNodeName().equals(TAG_HEADER)) {
									int columnx = 1;
									for (int l = 0; l < c.getChildNodes()
											.getLength(); l++) {
										Node d = c.getChildNodes().item(l);
										if (d.getNodeName().equals(TAG_COLUMN)) {
											for (int m = 0; m < d
													.getAttributes()
													.getLength(); m++) {
												if (d.getAttributes()
														.item(m)
														.getNodeName()
														.equals(ATTR_COLUMNVALUE)) {
													switch (columnx) {
													case 1:
														object.getTableHeader()
																.setColumn1(
																		d.getAttributes()
																				.item(m)
																				.getNodeValue());
														break;
													case 2:
														object.getTableHeader()
																.setColumn2(
																		d.getAttributes()
																				.item(m)
																				.getNodeValue());
														break;
													case 3:
														object.getTableHeader()
																.setColumn3(
																		d.getAttributes()
																				.item(m)
																				.getNodeValue());
														break;
													case 4:
														object.getTableHeader()
																.setColumn4(
																		d.getAttributes()
																				.item(m)
																				.getNodeValue());
														break;
													case 5:
														object.getTableHeader()
																.setColumn5(
																		d.getAttributes()
																				.item(m)
																				.getNodeValue());
														break;
													case 6:
														object.getTableHeader()
																.setColumn6(
																		d.getAttributes()
																				.item(m)
																				.getNodeValue());
														break;
													case 7:
														object.getTableHeader()
																.setColumn7(
																		d.getAttributes()
																				.item(m)
																				.getNodeValue());
														break;
													case 8:
														object.getTableHeader()
																.setColumn8(
																		d.getAttributes()
																				.item(m)
																				.getNodeValue());
														break;
													case 9:
														object.getTableHeader()
																.setColumn9(
																		d.getAttributes()
																				.item(m)
																				.getNodeValue());
														break;
													case 10:
														object.getTableHeader()
																.setColumn10(
																		d.getAttributes()
																				.item(m)
																				.getNodeValue());
														break;
													}
												}
											}
										}
										columnx++;
									}
								}
								if (c.getNodeName().equals(TAG_ROW)) {
									Row row = new Row();
									int columnx = 1;
									for (int l = 0; l < c.getChildNodes()
											.getLength(); l++) {
										Node d = c.getChildNodes().item(l);
										if (d.getNodeName().equals(TAG_COLUMN)) {
											for (int m = 0; m < d
													.getAttributes()
													.getLength(); m++) {
												if (d.getAttributes()
														.item(m)
														.getNodeName()
														.equals(ATTR_COLUMNVALUE)) {
													switch (columnx) {
													case 1:
														row.setColumn1(d
																.getAttributes()
																.item(m)
																.getNodeValue());
														break;
													case 2:
														row.setColumn2(d
																.getAttributes()
																.item(m)
																.getNodeValue());
														break;
													case 3:
														row.setColumn3(d
																.getAttributes()
																.item(m)
																.getNodeValue());
														break;
													case 4:
														row.setColumn4(d
																.getAttributes()
																.item(m)
																.getNodeValue());
														break;
													case 5:
														row.setColumn5(d
																.getAttributes()
																.item(m)
																.getNodeValue());
														break;
													case 6:
														row.setColumn6(d
																.getAttributes()
																.item(m)
																.getNodeValue());
														break;
													case 7:
														row.setColumn7(d
																.getAttributes()
																.item(m)
																.getNodeValue());
														break;
													case 8:
														row.setColumn8(d
																.getAttributes()
																.item(m)
																.getNodeValue());
														break;
													case 9:
														row.setColumn9(d
																.getAttributes()
																.item(m)
																.getNodeValue());
														break;
													case 10:
														row.setColumn10(d
																.getAttributes()
																.item(m)
																.getNodeValue());
														break;
													}
												}
											}
										}
										columnx++;
									}
									object.getTableRows().add(row);
								}
							}
							section.getObjects().add(object);
						}
						if (b.getNodeName().equals(TAG_FIGURE)) {
							Object object = new Object(Object.TYPE_FIGURE);
							for (int k = 0; k < b.getAttributes().getLength(); k++) {
								if (b.getAttributes().item(k).getNodeName()
										.equals(ATTR_FILENAME)) {

									File figure = new File(
											xmlFile.getParentFile(), b
													.getAttributes().item(k)
													.getNodeValue());

									if (figure.exists()) {

										File destDir = new File(DIR_FIGURES
												+ File.separator + "1");
										for (int l = 2; destDir.exists(); l++)
											destDir = new File(DIR_FIGURES
													+ File.separator + l);

										FileUtil.copy(figure, destDir);

										object.setFigurePath("/figures/"
												+ destDir.getName() + "/"
												+ figure.getName());

									}

								}
							}
							section.getObjects().add(object);
						}
					}
					report.getSections().add(section);
				}
			}
		}

		return report;
	}

	private static Element load(File xmlFile) throws Throwable {

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFile);
			Element root = doc.getDocumentElement();

			clean(root);

			return root;

		} catch (Throwable e) {

			throw e;

		}

	}

	private static void clean(Node root) {

		int i = 0;

		NodeList nl = root.getChildNodes();

		while (i < nl.getLength()) {

			if (nl.item(i).getNodeType() == Node.ELEMENT_NODE
					|| nl.item(i).getNodeType() == Node.ATTRIBUTE_NODE) {

				clean(nl.item(i));
				i++;

			} else {

				root.removeChild(nl.item(i));

			}
		}

	}

}
