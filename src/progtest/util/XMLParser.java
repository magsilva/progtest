package progtest.util;

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

			int m = root.getChildNodes().getLength() + 1;
			int n = root.getChildNodes().item(0).getChildNodes().getLength() + 1;
			int i = 0;
			int j = 0;

			String[][] report = new String[m][n];

			for (i = 0; i < m; i++) {
				for (j = 0; j < n; j++) {
					if ((i == 0) && (j == 0)) {
						report[i][j] = root.getNodeName().replace("&lt;", "<").replace(
										"&gt;", ">");
					} else if ((i == 0) && (j != 0)) {
						report[i][j] = root.getChildNodes().item(0).getChildNodes().item(j-1).getNodeName().replace("&lt;", "<").replace("&gt;", ">");
					} else if ((i != 0) && (j == 0)) {
						report[i][j] = root.getChildNodes().item(i-1).getAttributes().item(0).getNodeValue().replace("&lt;", "<").replace("&gt;", ">");
					} else if ((i != 0) && (j != 0)) {
						report[i][j] = root.getChildNodes().item(i-1)
								.getChildNodes().item(j-1).getAttributes()
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

	public static void generateXML(File f, String[][] data)
			throws FileNotFoundException {
		
		if(!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<" + data[0][0] + ">");

		for (int i = 1; i < data.length; i++) {
			
			XMLFile.println("\t<" + "reg" + i + " name=\""
					+ data[i][0] + "\">");

			for (int j = 1; j < data[0].length; j++) {
				XMLFile.println("\t\t<" + data[0][j] + " value=\""
							+ data[i][j] + "\"/>");
			}
			
			XMLFile.println("\t</" + "reg" + i + ">");
			
		}

		XMLFile.println("</" + data[0][0] + ">");

		XMLFile.close();
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		String[][] data = new String[4][3];
		
		data[0][0] = "X";
		data[0][1] = "A";
		data[0][2] = "B";
		data[1][0] = "1";
		data[1][1] = "A1";
		data[1][2] = "B1";
		data[2][0] = "2";
		data[2][1] = "A2";
		data[2][2] = "B2";
		data[3][0] = "3";
		data[3][1] = "A3";
		data[3][2] = "B3";
		
		File XMLFile = new File("." + File.separator + "XML.xml");
		
		XMLParser.generateXML(XMLFile, data);
		
		data = XMLParser.parse(XMLFile);
		
	}

}
