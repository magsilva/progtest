package progtest.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SourceUtil {

	public static boolean isSource(File file) {
		return file.getName().endsWith(".java")
				|| file.getName().endsWith(".h")
				|| file.getName().endsWith(".c");
	}

	public static boolean isTestSource(File file) {

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
						|| line.contains("@Test")
						|| line.contains("CU_automated_run_tests()"))
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

}
