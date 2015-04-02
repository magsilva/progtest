package progtest.addons.gcov;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Addon {

	private static final File ADDON_FILE = new File(GCov.class
			.getProtectionDomain().getCodeSource().getLocation().getPath()
			.replace("%20", " ")
			+ File.separator + "progtest-addon.xml");

	public static void cleanOutput(File rpt)
			throws IOException {
		FileWriter fw = new FileWriter(rpt + File.separator + getOutFile());
		fw.write("");
		fw.close();
	}

	public static void saveOutput(File rpt, int criterionId, double total)
			throws IOException {
		FileWriter fw = new FileWriter(rpt + File.separator + getOutFile(),
				true);
		fw.write(getCriterionKey(criterionId) + " = " + total + "\n");
		fw.close();
	}

	private static String getOutFile() {

		try {

			Element root = XMLUtil.load(ADDON_FILE);

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

	private static String getCriterionKey(int criterionId) {

		try {

			Element root = XMLUtil.load(ADDON_FILE);

			for (int i = 0; i < root.getChildNodes().item(0).getChildNodes()
					.item(criterionId - 1).getAttributes().getLength(); i++) {
				Node node = root.getChildNodes().item(0).getChildNodes()
						.item(criterionId - 1).getAttributes().item(i);
				if (node.getNodeName().equals("key"))
					return node.getNodeValue();
			}

			return null;

		} catch (Throwable e) {

			e.printStackTrace();

		}

		return null;

	}

}
