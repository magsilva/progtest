package progtest.addons.jumble;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.Path;
import org.junit.Test;

public class Executor {

	private File jumbleFile;

	private File srcDir;
	
	private File binDir;
	
	private File progDir;
	
	private File testDir;

	public Executor(File jumbleFile, File srcDir, File binDir, File progDir, File testDir) {
		
		this.jumbleFile = jumbleFile;
		this.srcDir = srcDir;
		this.binDir = binDir;
		this.progDir = progDir;
		this.testDir = testDir;
		
	}

	public void compile() throws Throwable {

		try {

			Project project = new Project();
			project.init();
			org.apache.tools.ant.taskdefs.Javac javac = (org.apache.tools.ant.taskdefs.Javac) project
					.createTask("javac");
			javac.init();
			javac.setDebug(true);
			javac.setVerbose(true);

			// Source directory
			Path source = javac.createSourcepath();
			source.setLocation(srcDir);
			javac.setSrcdir(source);

			// Target directory
			javac.setDestdir(binDir);

			// Remove any compiled file
			FileUtil.clean(binDir);

			javac.perform();

		} catch (Throwable t) {

			throw t;

		}

	}

	public Result execute(String additionals) throws IOException, InterruptedException {
		
		split(binDir, progDir, testDir);
		
		return getResult(additionals);
		
	}

	private void split(File sourceDir, File programDir, File testsDir)
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

	private boolean isTestClass(File file) {

		String clazzName = file.getName().replace(".class", "");
		File root = file.getParentFile();

		try {

			while (!root.getPath().equals(srcDir.getPath())
					&& !root.getPath().equals(binDir.getPath())
					&& !root.getPath().equals(progDir.getPath())
					&& !root.getPath().equals(testDir.getPath())) {
				clazzName = root.getName() + "." + clazzName;
				root = root.getParentFile();
			}

			URL urls[] = new URL[1];

			urls[0] = new URL("file://"
					+ root.getPath().replace("\\", "/") + "/");

			URLClassLoader loader = new URLClassLoader(urls);

			Class<?> clazz = loader.loadClass(clazzName);

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

	private Result getResult(String additionals) throws IOException, InterruptedException {
		
		List<File> progClasses = FileUtil.listFiles(progDir, ".class");
		
		String[][] data = new String[progClasses.size() + 1][4];
		
		data[0][0] = "Class";
		data[0][1] = "Mutation Points";
		data[0][2] = "Time Limit";
		data[0][3] = "Score";
		
		Result result = new Result(data);

		for (int i = 0; i < progClasses.size(); i++) {
			
			File classFile = progClasses.get(i);
			
			String clazzName = classFile.getName().replace(".class", "");
			File root = classFile.getParentFile();

			try {

				while (!root.getPath().equals(progDir.getPath())) {
					clazzName = root.getName() + "." + clazzName;
					root = root.getParentFile();
				}

				URL urls[] = new URL[1];

				urls[0] = new URL("file://"
						+ root.getPath().replace("\\", "/") + "/");

				URLClassLoader loader = new URLClassLoader(urls);

				Class<?> clazz = loader.loadClass(clazzName);
				
				getScore(jumbleFile, classFile, testDir, additionals, clazz.getCanonicalName(), result, i + 1);

			} catch (MalformedURLException e) {

				System.err.println("Warnning: Invalid URL: " + "file://"
						+ classFile.getParentFile().getPath().replace("\\", "/") + "/");

			} catch (ClassNotFoundException e) {

				System.err.println("Class not found: " + clazzName);

			}
			
		}
		
		return result;
		
	}
	
	private static void getScore(File jumbleFile, File classFile,
			File testDir, String additionals, String className, Result result, int index) throws IOException, InterruptedException {
		
		result.getScoreByClass()[index][0] = className;
		
		String parameters[] = additionals.split(" ");
		
		String args[] = new String[5 + parameters.length];

		args[0] = "java";
		args[1] = "-jar";
		args[2] = jumbleFile.getPath();
		
		for(int i = 3; i < 2 + parameters.length; i++)
			args[i] = parameters[i - 2];
		
		args[2 + parameters.length] = "--classpath=" + classFile.getParentFile().getPath() + ":"
				+ jumbleFile.getParent();
		
		args[3 + parameters.length] = classFile.getName().replace(".class", "");
		
		args[4 + parameters.length] = "EmptyTest";

		Process p = Runtime.getRuntime().exec(args);
		
		InputStream st = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(st);
		BufferedReader br = new BufferedReader(isr);
		
		while (br.ready()) {
			String line = br.readLine();
			System.out.println(line);
			if(line.contains("M FAIL: ")) {
				String value = line.substring(line.indexOf("M FAIL: ") + 8);
				result.getAllMutants().add(value);
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
			if(line.contains("M FAIL: ")) {
				String value = line.substring(line.indexOf("M FAIL: ") + 8);
				result.getAllMutants().add(value);
			}
		}
		
		st = p.getErrorStream();
		isr = new InputStreamReader(st);
		br = new BufferedReader(isr);
		while (br.ready())
			System.err.println(br.readLine());
		
		List<File> testClasses = FileUtil.listFiles(testDir, ".class");
		
		args = new String[4 + testClasses.size() + parameters.length];

		args[0] = "java";
		args[1] = "-jar";
		args[2] = jumbleFile.getPath();
		
		for(int i = 3; i < 2 + parameters.length; i++)
			args[i] = parameters[i - 2];
		
		args[2 + parameters.length] = "--classpath=" + classFile.getParentFile().getPath() + ":" + testDir + ":"
				+ ".";
		args[3 + parameters.length] = classFile.getName().replace(".class", "");

		for (int i = 0; i < testClasses.size(); i++)
			args[4 + parameters.length + i] = testClasses.get(i).getName()
					.replace(".class", "");

		p = Runtime.getRuntime().exec(args);

		st = p.getInputStream();
		isr = new InputStreamReader(st);
		br = new BufferedReader(isr);
		
		while (br.ready()) {
			
			String line = br.readLine();
			
			System.out.println(line);
			
			if(line.contains("Score: ")) {
				String value = line.substring(line.indexOf("Score: ") + 7, line.indexOf("%"));
				result.getScoreByClass()[index][3] = value;
			}
			
			if (line.contains("Mutation points = ")) {
				String value = line.substring(line.indexOf("Mutation points = ") + 18, line.indexOf(","));
				result.getScoreByClass()[index][1] = value;
			}
			
			if (line.contains("unit test time limit ")) {
				String value = line.substring(line.indexOf("unit test time limit ") + 21);
				result.getScoreByClass()[index][2] = value;
			}
			
			if (line.contains("M FAIL: ")) {
				String value = line.substring(line.indexOf("M FAIL: ") + 8);
				result.getAliveMutants().add(value);
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
				result.getScoreByClass()[index][3] = value;
			}
			
			if (line.contains("Mutation points ")) {
				String value = line.substring(line.indexOf("Mutation points = ") + 18, line.indexOf(","));
				result.getScoreByClass()[index][1] = value;
			}
			
			if (line.contains("unit test time limit ")) {
				String value = line.substring(line.indexOf("unit test time limit ") + 21);
				result.getScoreByClass()[index][2] = value;
			}
			
			if (line.contains("M FAIL: ")) {
				String value = line.substring(line.indexOf("M FAIL: ") + 8);
				result.getAliveMutants().add(value);
			}
			
		}
		
		for(String mutant : result.getAllMutants())
			if(!result.getAliveMutants().contains(mutant))
				result.getDeadMutants().add(mutant);
		
	}

}
