package progtest.addons.jabutiservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestCaseUtil {

	public static boolean isTestCase(File file) {

		FileInputStream stream = null;
		InputStreamReader streamReader = null;
		BufferedReader reader = null;

		try {

			stream = new FileInputStream(file.getPath());
			streamReader = new InputStreamReader(stream);
			reader = new BufferedReader(streamReader);
			String line = null;

			while ((line = reader.readLine()) != null) {
				if (line.contains("extends junit.framework.TestCase")
						|| line.contains("extends TestCase")
						|| line.contains("@org.junit.Test")
						|| line.contains("@Test"))
					return true;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (reader != null)
					reader.close();
				if (streamReader != null)
					streamReader.close();
				if (stream != null)
					stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return false;

	}

	public static String getPackage(File file) {

		FileInputStream stream = null;
		InputStreamReader streamReader = null;
		BufferedReader reader = null;

		try {

			stream = new FileInputStream(file.getPath());
			streamReader = new InputStreamReader(stream);
			reader = new BufferedReader(streamReader);
			String line = null;

			while ((line = reader.readLine()) != null) {
				if (line.contains("package"))
					return line.substring(line.indexOf("package") + 7,
							line.indexOf(";")).trim();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (reader != null)
					reader.close();
				if (streamReader != null)
					streamReader.close();
				if (stream != null)
					stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "";

	}

	public static void genarateTestSuite(List<File> testClasses, File testSuite)
			throws IOException {

		if (!testSuite.getName().endsWith(".java"))
			throw new IllegalArgumentException();

		String text = "import org.junit.runner.RunWith;"
				+ "\nimport org.junit.runners.Suite;"
				+ "\nimport org.junit.runners.Suite.SuiteClasses;" + "\n"
				+ "\n@RunWith(value=Suite.class)" + "\n@SuiteClasses(value={";

		for (File file : testClasses)
			if (isTestCase(file)) {
				String pack = getPackage(file);
				if (pack.equals(""))
					text += "\n		" + file.getName().replace("java", "class")
							+ ",";
				else
					text += "\n		" + getPackage(file) + "."
							+ file.getName().replace("java", "class") + ",";
			}

		text = text.substring(0, text.lastIndexOf(",")) + "\n})"
				+ "\npublic class " + testSuite.getName().replace(".java", "")
				+ " {" + "\n}";

		FileWriter fw = new FileWriter(testSuite);
		fw.write(text);
		fw.close();

	}

	public static void removeTestCases(List<String> testCases, File testClass, File output) {
		
		if(!output.getParentFile().exists())
			output.getParentFile().mkdirs();
			
		if (!testClass.getName().endsWith(".java"))
			throw new IllegalArgumentException();

		FileInputStream stream = null;
		InputStreamReader streamReader = null;
		BufferedReader reader = null;

		try {

			stream = new FileInputStream(testClass.getPath());
			streamReader = new InputStreamReader(stream);
			reader = new BufferedReader(streamReader);
			String line = null;

			List<String> words = new ArrayList<String>();

			while ((line = reader.readLine()) != null) {
				String[] wd = line.split(" ");
				for (int i = 0; i < wd.length; i++) {
					words.add(wd[i]);
				}
			}

			write(output, "");
			String testCase = "";

			int open = 0;
			int close = 0;

			int i = 0;

			for (String word : words) {
				if(word.endsWith(";") || word.endsWith("}") || word.endsWith("{"))
					word += "\n";
				switch (i) {
				case 0:
					if (word.contains("@Test")) {
						testCase = word + " ";
						i++;
					} else {
						append(output, word + " ");
					}
					break;
				case 1:
					testCase += word + " ";
					if (word.contains("{")) {
						open++;
						i++;
					}
					if (word.contains("}")) {
						close++;
						boolean remove = false;
						for (String tcName : testCases) {
							if (testCase.contains(tcName + "()"))
								remove = true;
						}
						if (!remove)
							append(output, testCase);
						i = 0;
					}
					break;
				case 2:
					testCase += word + " ";
					if (word.contains("{"))
						open++;
					if (word.contains("}"))
						close++;
					if (open == close) {
						boolean remove = false;
						for (String tcName : testCases) {
							if (testCase.contains(tcName + "()"))
								remove = true;
						}
						if (!remove)
							append(output, testCase);
						i = 0;
					}
					break;
				}
			}

			if (reader != null)
				reader.close();
			if (streamReader != null)
				streamReader.close();
			if (stream != null)
				stream.close();

		} catch (Exception e) {

		}

	}

	private static void write(File file, String text) throws IOException {
		FileWriter fw = new FileWriter(file);
		fw.write(text);
		fw.close();
	}

	private static void append(File file, String text) throws IOException {
		FileWriter fw = new FileWriter(file, true);
		fw.append(text);
		fw.close();
	}

}
