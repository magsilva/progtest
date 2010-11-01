package progtest.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.Test;

public class JUnitUtil {

	public static void split(File sourceDir, File programDir, File testsDir)
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
					FileUtil.copy(file, testsDir);
				} else {
					FileUtil.copy(file, programDir);
				}

			}

		}

	}

	public static boolean isTestClass(File file) {

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

	public static void generateTestSuite(File testsDir, File testSuiteFile)
			throws IOException {

		if (!testSuiteFile.getName().endsWith(".java"))
			throw new IllegalArgumentException();

		String text = "import org.junit.runner.RunWith;"
				+ "\nimport org.junit.runners.Suite;"
				+ "\nimport org.junit.runners.Suite.SuiteClasses;" + "\n"
				+ "\n@RunWith(value=Suite.class)" + "\n@SuiteClasses(value={";

		for (File file : FileUtil.listFiles(testsDir, ".class"))
			if (isTestClass(file)) {

				try {

					URL urls[] = new URL[1];

					urls[0] = new URL("file://"
							+ file.getParentFile().getPath().replace("\\", "/")
							+ "/");

					URLClassLoader loader = new URLClassLoader(urls);

					Class<?> clazz = loader.loadClass(file.getName().replace(
							".class", ""));

					text += "\n\t" + clazz.getName() + ".class" + ",";

				} catch (MalformedURLException e) {

					System.err.println("Warnning: Invalid URL: " + "file://"
							+ file.getParentFile().getPath().replace("\\", "/")
							+ "/");

				} catch (ClassNotFoundException e) {

					System.err.println("Class not found: " + file.getName());

				}
			}

		text = text.substring(0, text.lastIndexOf(",")) + "\n})"
				+ "\npublic class "
				+ testSuiteFile.getName().replace(".java", "") + " {" + "\n}";

		FileWriter fw = new FileWriter(testSuiteFile);
		fw.write(text);
		fw.close();

	}

}
