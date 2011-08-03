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

	public static Report parse(File xmlFile) throws Throwable {
		
		Report report = null;
		
		Element root = load(xmlFile);
		
		if(root.getNodeName().equals(TAG_REPORT)) {
			report = new Report();
			for(int i = 0; i < root.getAttributes().getLength(); i++) {
				if(root.getAttributes().item(i).getNodeName().equals(ATTR_NAME))
					report.setName(root.getAttributes().item(i).getNodeValue());
			}
			for(int i = 0; i < root.getChildNodes().getLength(); i++) {
				Node a = root.getChildNodes().item(i);
				if(a.getNodeName().equals(TAG_SECTION)) {
					Section section = new Section();
					for(int j = 0; j < a.getAttributes().getLength(); j++) {
						if(root.getAttributes().item(j).equals(ATTR_TITLE))
							section.setTitle(root.getAttributes().item(j).getNodeValue());
					}
					for(int j = 0; j < a.getChildNodes().getLength(); j++) {
						Node b = a.getChildNodes().item(j);
						if(b.getNodeName().equals(TAG_TEXT)) {
							Object object = new Object(Object.TYPE_TEXT);
							for(int k = 0; k < b.getAttributes().getLength(); k++) {
								if(b.getAttributes().item(k).equals(ATTR_TEXTVALUE))
									object.setTextValue(b.getAttributes().item(k).getNodeValue());
							}
							for(int k = 0; k < b.getAttributes().getLength(); k++) {
								if(b.getAttributes().item(k).equals(ATTR_TEXTCOLOR))
									object.setTextValue(b.getAttributes().item(k).getNodeValue());
							}
							section.getObjects().add(object);
						}
						
						//TODO
						
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
