package progtest.report;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML2Report {

	private static final String TAG_REPORT = "report";

	private static final String TAG_SECTION = "section";

	private static final String ATTR_NAME = "attribute";

	private static final String ATTR_TITLE = "title";

	private static final String TAG_TEXT = "text";

	private static final String ATTR_TEXTVALUE = "value";

	private static final String ATTR_TEXTCOLOR = "color";

	private static final Object TAG_TABLE = null;

	private static final Object TAG_HEADER = null;

	private static final Object TAG_ROW = null;

	private static final Object TAG_COLUMN = null;

	private static final Object ATTR_COLUMNVALUE = null;

	public static Report parse(File xmlFile) throws Throwable {

		Report report = null;

		Element root = load(xmlFile);

		if (root.getNodeName().equals(TAG_REPORT)) {
			report = new Report();
			for (int i = 0; i < root.getAttributes().getLength(); i++) {
				if (root.getAttributes().item(i).getNodeName()
						.equals(ATTR_NAME))
					report.setName(root.getAttributes().item(i).getNodeValue());
			}
			for (int i = 0; i < root.getChildNodes().getLength(); i++) {
				Node a = root.getChildNodes().item(i);
				if (a.getNodeName().equals(TAG_SECTION)) {
					Section section = new Section();
					for (int j = 0; j < a.getAttributes().getLength(); j++) {
						if (root.getAttributes().item(j).equals(ATTR_TITLE))
							section.setTitle(root.getAttributes().item(j)
									.getNodeValue());
					}
					for (int j = 0; j < a.getChildNodes().getLength(); j++) {
						Node b = a.getChildNodes().item(j);
						if (b.getNodeName().equals(TAG_TEXT)) {
							Object object = new Object(Object.TYPE_TEXT);
							for (int k = 0; k < b.getAttributes().getLength(); k++) {
								if (b.getAttributes().item(k)
										.equals(ATTR_TEXTVALUE))
									object.setTextValue(b.getAttributes()
											.item(k).getNodeValue());
							}
							for (int k = 0; k < b.getAttributes().getLength(); k++) {
								if (b.getAttributes().item(k)
										.equals(ATTR_TEXTCOLOR))
									object.setTextValue(b.getAttributes()
											.item(k).getNodeValue());
							}
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
										Node d = c.getChildNodes().item(i);
										if (d.getNodeName().equals(TAG_COLUMN)) {
											for (int m = 0; m < d
													.getAttributes()
													.getLength(); m++) {
												if (d.getNodeName().equals(
														ATTR_COLUMNVALUE)) {
													switch (columnx) {
													case 1:
														object.getTableHeader()
																.setColumn1(
																		d.getNodeValue());
														break;
													case 2:
														object.getTableHeader()
																.setColumn2(
																		d.getNodeValue());
														break;
													case 3:
														object.getTableHeader()
																.setColumn3(
																		d.getNodeValue());
														break;
													case 4:
														object.getTableHeader()
																.setColumn4(
																		d.getNodeValue());
														break;
													case 5:
														object.getTableHeader()
																.setColumn5(
																		d.getNodeValue());
														break;
													case 6:
														object.getTableHeader()
																.setColumn6(
																		d.getNodeValue());
														break;
													case 7:
														object.getTableHeader()
																.setColumn7(
																		d.getNodeValue());
														break;
													case 8:
														object.getTableHeader()
																.setColumn8(
																		d.getNodeValue());
														break;
													case 9:
														object.getTableHeader()
																.setColumn9(
																		d.getNodeValue());
														break;
													case 10:
														object.getTableHeader()
																.setColumn10(
																		d.getNodeValue());
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
										Node d = c.getChildNodes().item(i);
										if (d.getNodeName().equals(TAG_COLUMN)) {
											for (int m = 0; m < d
													.getAttributes()
													.getLength(); m++) {
												if (d.getNodeName().equals(
														ATTR_COLUMNVALUE)) {
													switch (columnx) {
													case 1:
														row.setColumn1(
																		d.getNodeValue());
														break;
													case 2:
														row.setColumn2(
																		d.getNodeValue());
														break;
													case 3:
														row.setColumn3(
																		d.getNodeValue());
														break;
													case 4:
														row.setColumn4(
																		d.getNodeValue());
														break;
													case 5:
														row.setColumn5(
																		d.getNodeValue());
														break;
													case 6:
														row.setColumn6(
																		d.getNodeValue());
														break;
													case 7:
														row.setColumn7(
																		d.getNodeValue());
														break;
													case 8:
														row.setColumn8(
																		d.getNodeValue());
														break;
													case 9:
														row.setColumn9(
																		d.getNodeValue());
														break;
													case 10:
														row.setColumn10(
																		d.getNodeValue());
														break;
													}
												}
											}
										}
										columnx++;
									}
								}
							}
							section.getObjects().add(object);
						}

						// TODO

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
