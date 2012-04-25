package progtest.addons.junit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.Path;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Executor {

	public static void compile(File src, File bin) throws IOException {

		Project project = new Project();
		project.init();
		org.apache.tools.ant.taskdefs.Javac javac = (org.apache.tools.ant.taskdefs.Javac) project
				.createTask("javac");
		javac.init();
		javac.setDebug(true);
		javac.setVerbose(true);

		Path source = javac.createSourcepath();
		source.setLocation(src);
		javac.setSrcdir(source);

		javac.setDestdir(bin);

		FileUtil.clean(bin);

		PrintStream out = System.out;
		PrintStream err = System.err;

		String time = String.valueOf(new Date().getTime());

		File tmp = File.createTempFile(time, time);

		System.setOut(new PrintStream(tmp));
		System.setErr(new PrintStream(tmp));

		javac.perform();

		System.setOut(out);
		System.setErr(err);

		FileReader fr = new FileReader(tmp);
		BufferedReader br = new BufferedReader(fr);

		while (br.ready())
			System.out.println(br.readLine().replace(src.getPath(), "")
					.replace(bin.getPath(), ""));

	}

	public static List<Result> execute(File bin) {

		List<Result> results = new ArrayList<Result>();

		for (File file : FileUtil.listFiles(bin, ".class")) {

			String clazzName = file.getName().replace(".class", "");
			File root = file.getParentFile();

			try {

				while (!root.getPath().equals(bin.getPath())) {
					clazzName = root.getName() + "." + clazzName;
					root = root.getParentFile();
				}

				URL urls[] = new URL[1];

				urls[0] = new URL("file://"
						+ root.getPath().replace("\\", "/") + "/");

				URLClassLoader loader = new URLClassLoader(urls);

				Class<?> clazz = loader.loadClass(clazzName);

				if (clazz != null && isTestClass(clazz))
					results.add(JUnitCore.runClasses(clazz));

			} catch (MalformedURLException e) {

				System.err.println("Warnning: Invalid URL: " + "file://"
						+ file.getParentFile().getPath().replace("\\", "/") + "/");

			} catch (ClassNotFoundException e) {

				System.err.println("Class not found: " + clazzName);

			}

		}

		return results;

	}

	private static boolean isTestClass(Class<?> clazz) {

		for (int i = 0; i < clazz.getMethods().length; i++)
			for (int j = 0; j < clazz.getMethods()[i].getAnnotations().length; j++)
				if (clazz.getMethods()[i].getAnnotations()[j].annotationType() == org.junit.Test.class)
					return true;

		return false;

	}

}
