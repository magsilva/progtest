package progtest.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import progtest.compilers.Javac;

public class Jumble {

	private static final String XML_FILE = Jumble.class.getProtectionDomain()
			.getCodeSource().getLocation().getPath()
			+ File.separator + "progtest-addon.xml";

	public static void main(String args[]) {

		if (args.length < 5) {

			System.out
					.println("Usage: progtest.tools.Jumble <jumble file> <source directory> <binaries directory> <program directory> <tests directory> <reports directory>");

		} else {

			File jumbleFile = new File(args[0]);

			File srcDir = new File(args[1]);
			File binDir = new File(args[2]);
			File progDir = new File(args[3]);
			File testDir = new File(args[4]);
			File rptDir = new File(args[5]);

			if (!srcDir.exists()) {

				System.err.println("Directory not found: " + srcDir.getPath());

			} else if (!binDir.exists()) {

				System.err.println("Directory not found: " + binDir.getPath());

			} else if (!progDir.exists()) {

				System.err.println("Directory not found: " + progDir.getPath());

			} else if (!testDir.exists()) {

				System.err.println("Directory not found: " + testDir.getPath());

			} else if (!rptDir.exists()) {

				System.err.println("Directory not found: " + rptDir.getPath());

			} else if (!srcDir.isDirectory()) {

				System.err.println("It's not a directory: " + srcDir.getPath());

			} else if (!binDir.isDirectory()) {

				System.err.println("It's not a directory: " + binDir.getPath());

			} else if (!progDir.isDirectory()) {

				System.err
						.println("It's not a directory: " + progDir.getPath());

			} else if (!testDir.isDirectory()) {

				System.err
						.println("It's not a directory: " + testDir.getPath());

			} else if (!rptDir.isDirectory()) {

				System.err.println("It's not a directory: " + rptDir.getPath());

			} else {

				try {

					Javac.execute(srcDir, binDir);

					split(binDir, progDir, testDir);

					execute(jumbleFile, progDir, testDir, rptDir);

				} catch (Throwable t) {

					t.printStackTrace();

				}

			}

		}

	}

	private static void split(File sourceDir, File programDir, File testsDir)
			throws IOException {

		File[] localFiles = sourceDir.listFiles();

		for (File file : localFiles) {

			if (file.isDirectory()) {

				File newProgramDir = new File(sourceDir + File.separator
						+ file.getName());
				File newTestsDir = new File(sourceDir + File.separator
						+ file.getName());

				if (!newProgramDir.exists())
					newProgramDir.mkdirs();

				if (!newTestsDir.exists())
					newTestsDir.mkdirs();

				split(file, newProgramDir, newTestsDir);

			} else {

				if (isTestClass(file)) {
					copy(file, testsDir);
				} else {
					copy(file, programDir);
				}

			}

		}

	}

	private static void execute(File jumbleFile, File progDir, File testDir,
			File rptDir) throws IOException, InterruptedException {

		List<File> progClasses = listFiles(progDir, ".class");
		
		double total = 0;
		
		double numerator = 0;
		
		double denominator = 0;
		
		String[][] data = new String[progClasses.size() + 1][2];
		
		data[0][0] = "Class";
		data[0][1] = "Score";

		for (int i = 0; i < progClasses.size(); i++) {
			
			File classFile = progClasses.get(i);
			
			try {

				URL urls[] = new URL[1];

				urls[0] = new URL("file://"
						+ classFile.getParentFile().getPath().replace("\\", "/") + "/");

				URLClassLoader loader = new URLClassLoader(urls);

				Class<?> clazz = loader.loadClass(classFile.getName().replace(".class",
						""));
				
				double score = getScore(jumbleFile, classFile, testDir);
				
				numerator += score;
				denominator++;
				
				data[i+1][0] = clazz.getName();
				data[i+1][1] = String.valueOf(round(score, 2)) + "%";

			} catch (MalformedURLException e) {

				System.err.println("Warnning: Invalid URL: " + "file://"
						+ classFile.getParentFile().getPath().replace("\\", "/") + "/");

			} catch (ClassNotFoundException e) {

				System.err.println("Class not found: " + classFile.getName());

			}
			
		}
		
		File report = new File(rptDir.getPath() + File.separator + "Score by Class.xml");
		
		generateXML(report, data);
		
		if(denominator > 0)
			total = (numerator / denominator) / 100;
		
		File output = new File(rptDir.getPath() + File.separator + getOutFile());
		
		saveOutput(output, total);

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

	private static double getScore(File jumbleFile, File classFile,
			File testDir) throws IOException, InterruptedException {

		List<File> testClasses = listFiles(testDir, ".class");
		
		String args[] = new String[5 + testClasses.size()];

		args[0] = "java";
		args[1] = "-jar";
		args[2] = jumbleFile.getPath();
		args[3] = "--classpath=" + classFile.getParentFile().getPath() + ":" + testDir + ":"
				+ ".";
		args[4] = classFile.getName().replace(".class", "");

		for (int i = 0; i < testClasses.size(); i++)
			args[5 + i] = testClasses.get(i).getName()
					.replace(".class", "");

		Process p = Runtime.getRuntime().exec(args);

		InputStream st = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(st);
		BufferedReader br = new BufferedReader(isr);
		
		while (br.ready()) {
			
			String line = br.readLine();
			
			System.out.println(line);
			
			if(line.contains("Score: ")) {
				String value = line.substring(line.indexOf("Score: ") + 7, line.indexOf("%"));
				return Double.parseDouble(value);
			}
			
		}

		st = p.getErrorStream();
		isr = new InputStreamReader(st);
		br = new BufferedReader(isr);
		while (br.ready())
			System.err.println(br.readLine());

		p.waitFor();

		st = p.getInputStream();
		isr = new InputStreamReader(st);
		br = new BufferedReader(isr);
		
		while (br.ready()) {
			
			String line = br.readLine();
			
			System.out.println(line);
			
			if(line.contains("Score: ")) {
				String value = line.substring(line.indexOf("Score: ") + 7, line.indexOf("%"));
				return Double.parseDouble(value);
			}
			
		}
		
		return 0;
		
	}

	private static void saveOutput(File output, double total)
			throws IOException {
		FileWriter fw = new FileWriter(output);
		fw.write(getCriterionKey() + " = " + total);
		fw.close();
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
				XMLFile.println("\t\t<" + data[0][j].replace(" ", "_")
						+ " value=\"" + data[i][j] + "\"/>");
			}

			XMLFile.println("\t</record>");

		}

		XMLFile.println("</report>");

		XMLFile.close();

	}

	private static boolean isTestClass(File file) {

		try {

			URL urls[] = new URL[1];

			urls[0] = new URL("file://"
					+ file.getParentFile().getPath().replace("\\", "/") + "/");

			URLClassLoader loader = new URLClassLoader(urls);

			Class<?> clazz = loader.loadClass(file.getName().replace(".class",
					""));

			for (Method method : clazz.getDeclaredMethods())
				for (Annotation annotation : method.getAnnotations())
					if (annotation.annotationType().equals(Test.class))
						return true;

		} catch (MalformedURLException e) {

			System.err.println("Warnning: Invalid URL: " + "file://"
					+ file.getParentFile().getPath().replace("\\", "/") + "/");

		} catch (ClassNotFoundException e) {

			System.err.println("Class not found: " + file.getName());

		}

		return false;

	}

	private static File copy(File src, File dst) throws IOException {

		if (!dst.exists())
			dst.mkdirs();

		if (src.isDirectory()) {

			String[] children = src.list();

			for (int i = 0; i < children.length; i++)
				copy(new File(src, children[i]), new File(dst, src.getName()));

		} else {

			copyContent(src, new File(dst + File.separator + src.getName()));

		}

		return new File(dst + File.separator + src.getName());

	}

	private static void copyContent(File src, File dst) throws IOException {

		if (src.isDirectory()) {

			if (!dst.exists())
				dst.mkdirs();

			String[] children = src.list();

			for (int i = 0; i < children.length; i++)
				copy(new File(src, children[i]), dst);

		} else {

			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			in.close();
			out.close();

		}

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
	
	private static double round(double num, int precisao) {
		num *= java.lang.Math.pow(10, precisao);
		num = java.lang.Math.round(num);
		num /= java.lang.Math.pow(10, precisao);
		return num;
	}

}
