package progtest.addons.gcov;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

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

			XMLUtil.clean(root);

			return root;

		} catch (Throwable e) {

			throw e;

		}

	}

	public static void generateXML(File f, String[][] data) throws Throwable {

		try {

			if (!f.getParentFile().exists())
				f.getParentFile().mkdirs();

			PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

			XMLFile.println("<?xml version='1.0'?>");
			XMLFile.println("<report>");

			for (int i = 1; i < data.length; i++) {

				XMLFile.println("\t<record>");

				for (int j = 0; j < data[0].length; j++) {
					XMLFile.println("\t\t<" + data[0][j].replace(" ", "_")
							+ " value=\"" + data[i][j] + "\"/>");
				}

				XMLFile.println("\t</record>");

			}

			XMLFile.println("</report>");

			XMLFile.close();

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
