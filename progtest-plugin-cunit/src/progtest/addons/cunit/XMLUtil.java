package progtest.addons.cunit;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtil {

	public static Element load(File xmlFile) throws Throwable {
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
					|| nl.item(i).getNodeType() == Node.ATTRIBUTE_NODE
					|| (nl.item(i).getNodeType() == Node.TEXT_NODE && !nl
							.item(i).getNodeValue().trim().equals(""))) {
				clean(nl.item(i));
				i++;
			} else {
				root.removeChild(nl.item(i));
			}
		}
	}

}
