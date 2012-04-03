package progtest.addons.junit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JUnit {

	private static final String XML_FILE = JUnit.class.getProtectionDomain()
			.getCodeSource().getLocation().getPath()
			+ File.separator + "progtest-addon.xml";;

	public static void main(String args[]) {

		if (args.length < 2) {

			System.out
					.println("Usage: progtest.tools.JUnit <junit classes directory> <reports directory>");

		} else {

			File dir = new File(args[0]);

			File rpt = new File(args[1]);

			if (!dir.exists()) {

				System.err.println("Directory not found: " + dir.getPath());

			} else if (!rpt.exists()) {

				System.err.println("Directory not found: " + rpt.getPath());

			} else if (!dir.isDirectory()) {

				System.err.println("It's not a directory: " + dir.getPath());

			} else if (!rpt.isDirectory()) {

				System.err.println("It's not a directory: " + rpt.getPath());

			} else {

				List<Result> results = new ArrayList<Result>();

				List<String> classNames = new ArrayList<String>();

				for (File file : listFiles(dir, ".class")) {

					URL urls[] = new URL[1];

					try {

						urls[0] = new URL("file://"
								+ file.getParentFile().getPath()
										.replace("\\", "/") + "/");

					} catch (MalformedURLException e) {

						System.err.println("Warnning: Invalid URL: "
								+ "file://"
								+ file.getParentFile().getPath()
										.replace("\\", "/") + "/");

						continue;

					}

					URLClassLoader loader = new URLClassLoader(urls);

					Class<?> clazz;

					try {

						clazz = loader.loadClass(file.getName().replace(
								".class", ""));

					} catch (ClassNotFoundException e) {

						System.err
								.println("Class not found: " + file.getName());

						continue;

					}

					Result r = JUnitCore.runClasses(clazz);

					if ((r.getFailureCount() == 1)
							&& r.getFailures().get(0).getMessage()
									.equals("No runnable methods")) {

						continue;

					} else {

						results.add(r);
						classNames.add(clazz.getCanonicalName());

					}

				}

				String report[][] = new String[results.size() + 1][3];

				report[0][0] = "Class";
				report[0][1] = "Success";
				report[0][2] = "Percentage";

				double allSuccess = 0;

				double allRuns = 0;

				for (int i = 1; i <= results.size(); i++) {

					String className = classNames.get(i - 1);

					Result r = results.get(i - 1);

					int success = r.getRunCount() - r.getFailureCount();
					int runs = r.getRunCount();
					double percentage = round(
							(((double) success) / ((double) runs)) * 100, 2);

					allSuccess += success;
					allRuns += runs;

					report[i][0] = className;
					report[i][1] = success + " of " + runs;
					report[i][2] = String.valueOf(percentage) + "%";

				}

				try {

					String result = String.valueOf(round(((double) allSuccess)
							/ ((double) allRuns), 2));

					FileWriter fw = new FileWriter(rpt.getPath()
							+ File.separator + getOutFile());
					fw.write(getCriterionKey() + " = " + result);
					fw.close();

					generateXML(new File(rpt.getPath() + File.separator
							+ "Tests Result.xml"), report);

				} catch (Throwable e) {

					System.err.println("Error: Report not generated: "
							+ e.getMessage());

				}

			}

		}

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

	private static List<File> listFiles(File dir, String extensionFilter) {
		List<File> files = new ArrayList<File>();
		File[] localFiles = dir.listFiles();
		for (File file : localFiles) {
			if (file.isDirectory()) {
				files.addAll(listFiles(file, extensionFilter));
			} else if (file.getName().endsWith(extensionFilter)) {
				files.add(file);
			}
		}
		return files;
	}

	private static void generateXML(File f, String[][] data)
			throws FileNotFoundException, SecurityException {

		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();

		PrintWriter XMLFile = new PrintWriter(new FileOutputStream(f));

		XMLFile.println("<?xml version='1.0'?>");
		XMLFile.println("<report>");

		for (int i = 1; i < data.length; i++) {

			XMLFile.println("\t<record>");

			for (int j = 0; j < data[0].length; j++) {
				XMLFile.println("\t\t<" + data[0][j] + " value=\"" + data[i][j]
						+ "\"/>");
			}

			XMLFile.println("\t</record>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static double round(double num, int precisao) {
		num *= java.lang.Math.pow(10, precisao);
		num = java.lang.Math.round(num);
		num /= java.lang.Math.pow(10, precisao);
		return num;
	}

}
