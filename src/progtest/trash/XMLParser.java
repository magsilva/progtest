package progtest.trash;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {

	public static String[][] parse(File f) {

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(f);
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

			int n = root.getChildNodes().getLength() + 1;
			int m = root.getChildNodes().item(0).getChildNodes().getLength();
			int i = 0;
			int j = 0;

			String[][] report = new String[n][m];

			for (i = 0; i < n; i++) {
				for (j = 0; j < m; j++) {
					if ((i == 0)) {
						report[i][j] = root.getChildNodes().item(i)
						.getChildNodes().item(j).getNodeName()
						.replace("&lt;", "<").replace("&gt;", ">");
					} else if ((i != 0)) {
						report[i][j] = root.getChildNodes().item(i - 1)
								.getChildNodes().item(j).getAttributes()
								.item(0).getNodeValue().replace("&lt;", "<")
								.replace("&gt;", ">");
					}
				}
			}

			return report;

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}

	}

	public static void generateXML(String root, String data[][], String name)
			throws FileNotFoundException {
		
		File f = new File(name);
		
		if(!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter fileXML = new PrintWriter(new FileOutputStream(name));

		fileXML.println("<?xml version='1.0'?>");
		fileXML.println("<" + root + ">");

		for (int i = 1; i < data.length; i++) {

			for (int j = 0; j < data[0].length; j++) {
				if (j == 0)
					fileXML.println("   <" + data[0][j] + " name=\""
							+ data[i][j] + "\">");
				else
					fileXML.println("      <" + data[0][j] + " value=\""
							+ data[i][j] + "\"/>");
			}
			fileXML.println("   </" + data[0][0] + ">");
		}

		fileXML.println("</" + root + ">");

		fileXML.close();

	}

}
