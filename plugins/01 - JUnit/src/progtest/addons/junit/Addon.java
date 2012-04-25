package progtest.addons.junit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Addon {

	private static final String XML_FILE = JUnit.class.getProtectionDomain()
			.getCodeSource().getLocation().getPath()
			+ File.separator + "progtest-addon.xml";;

	public static void saveOutput(double total, File rpt) throws IOException {
		
		FileWriter fw = new FileWriter(rpt.getPath() + File.separator
				+ getOutFile());
		fw.write(getCriterionKey() + " = " + total);
		fw.close();
		
	}

	private static String getCriterionKey() {

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(XML_FILE);
			Element root = doc.getDocumentElement();

			int a, b;
			NodeList nodeList1 = root.getChildNodes();
			for (a = 0; a < nodeList1.getLength(); a++) {
				if (!(nodeList1.item(a).getNodeType() == Node.ELEMENT_NODE)
						&& !(nodeList1.item(a).getNodeType() == Node.ATTRIBUTE_NODE)) {
					root.removeChild(nodeList1.item(a));
					a--;
				} else {
					NodeList nodeList2 = nodeList1.item(a).getChildNodes();
					for (b = 0; b < nodeList2.getLength(); b++) {
						if (!(nodeList2.item(b).getNodeType() == Node.ELEMENT_NODE)
								&& !(nodeList2.item(b).getNodeType() == Node.ATTRIBUTE_NODE)) {
							nodeList1.item(a).removeChild(nodeList2.item(b));
							b--;
						}
					}
				}
			}

			for (int i = 0; i < root.getChildNodes().item(0).getChildNodes()
					.item(0).getAttributes().getLength(); i++) {
				Node node = root.getChildNodes().item(0).getChildNodes()
						.item(0).getAttributes().item(i);
				if (node.getNodeName().equals("key"))
					return node.getNodeValue();
			}

			return null;

		} catch (Throwable e) {

			e.printStackTrace();

		}

		return null;

	}

	private static String getOutFile() {

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(XML_FILE);
			Element root = doc.getDocumentElement();

			int a, b;
			NodeList nodeList1 = root.getChildNodes();
			for (a = 0; a < nodeList1.getLength(); a++) {
				if (!(nodeList1.item(a).getNodeType() == Node.ELEMENT_NODE)
						&& !(nodeList1.item(a).getNodeType() == Node.ATTRIBUTE_NODE)) {
					root.removeChild(nodeList1.item(a));
					a--;
				} else {
					NodeList nodeList2 = nodeList1.item(a).getChildNodes();
					for (b = 0; b < nodeList2.getLength(); b++) {
						if (!(nodeList2.item(b).getNodeType() == Node.ELEMENT_NODE)
								&& !(nodeList2.item(b).getNodeType() == Node.ATTRIBUTE_NODE)) {
							nodeList1.item(a).removeChild(nodeList2.item(b));
							b--;
						}
					}
				}
			}

			for (int i = 0; i < root.getChildNodes().item(0).getAttributes()
					.getLength(); i++) {
				Node node = root.getChildNodes().item(0).getAttributes()
						.item(i);
				if (node.getNodeName().equals("outfile"))
					return node.getNodeValue();
			}

		} catch (Throwable e) {

			e.printStackTrace();

		}

		return null;

	}

}
