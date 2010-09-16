package progtest.trash;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import progtest.reports.XMLParser;

public class JUnit {

	public static void run(String testClass, String report, String classpath,
			String workspace) {
		String outFileName = "Funcional";
		JUnitExecutor.run(testClass, workspace, classpath, outFileName);
		generateXMLReports(workspace, report, outFileName);
	}
	
	private static void generateXMLReports(String workspace, String reports,
			String outFileName) {
		generateTestCasesXMLReport(workspace, reports, "TestCases");
		generateFuncionalXMLReport(workspace, reports, outFileName);
	}

	private static void generateTestCasesXMLReport(String workspace, String reports,
			String outFileName) {

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(workspace + File.separator
					+ "Funcional" + ".xml"));
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
			
			int ntestcase = 0;
			
			for(int i = 0; i < root.getChildNodes().getLength(); i++) {
				if(root.getChildNodes().item(i).getNodeName().equals("testcase"))
					ntestcase++;
			}

			String[][] report = new String[ntestcase + 1][3];

			report[0][0] = "ClassName";
			report[0][1] = "Name";
			report[0][2] = "Status";
			
			for(int i = 0, j = 1; i < root.getChildNodes().getLength(); i++) {
				if(root.getChildNodes().item(i).getNodeName().equals("testcase")) {
					report[j][0] = root.getChildNodes().item(i).getAttributes().item(0).getNodeValue();
					report[j][1] = root.getChildNodes().item(i).getAttributes().item(1).getNodeValue();
					if(root.getChildNodes().item(i).hasChildNodes())
						report[j][2] = root.getChildNodes().item(i).getChildNodes().item(0).getNodeName();
					else
						report[j][2] = "success";
					j++;
				}
			}

			XMLParser.generateXML("TestCases", report, reports + File.separator
					+ outFileName + ".xml");

		} catch (Exception e) {

			e.printStackTrace();

		}
		
	}

	private static void generateFuncionalXMLReport(String workspace, String reports,
			String outFileName) {

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(workspace + File.separator
					+ outFileName + ".xml"));
			Element root = doc.getDocumentElement();

			String[][] report = new String[2][4];

			report[0][0] = "Tests";
			report[0][1] = "Errors";
			report[0][2] = "Failures";
			report[0][3] = "Coverage";

			for (int i = 0; i < root.getAttributes().getLength(); i++) {
				if (root.getAttributes().item(i).getNodeName().equals("tests"))
					report[1][0] = root.getAttributes().item(i).getNodeValue();
				if (root.getAttributes().item(i).getNodeName().equals("errors"))
					report[1][1] = root.getAttributes().item(i).getNodeValue();
				if (root.getAttributes().item(i).getNodeName().equals(
						"failures"))
					report[1][2] = root.getAttributes().item(i).getNodeValue();
			}
			
			report[1][3] = String.valueOf(progtest.util.Math.round((
					(Double.valueOf(report[1][0]) - (Double
							.valueOf(report[1][1]) + Double
							.valueOf(report[1][2])))
							/ Double.valueOf(report[1][0])) * 100, 2));

			XMLParser.generateXML("Funcional", report, reports + File.separator
					+ outFileName + ".xml");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
