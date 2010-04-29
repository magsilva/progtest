package progtest.ant;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Javac;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.Path;
import org.apache.tools.ant.types.PatternSet;

import progtest.util.FileUtil;

public class JavacExecutor {

	private static BuildLogger logger = new BuildLogger();

	public static void run(String basicPath, String srcPath, String libsPath,
			String destPath) {
		Project project = createProject();
		Javac javac = (Javac) project.createTask("javac");
		javac.init();
		javac.setDebug(true);
		javac.setVerbose(true);

		// Source directory
		File sourceDir = new File(srcPath);
		if (!sourceDir.exists()) {
			throw new IllegalArgumentException("Invalid source path");
		}
		Path src = javac.createSourcepath();
		src.setLocation(sourceDir);
		javac.setSrcdir(src);

		// Target directory
		File destDir = new File(destPath);
		if (!destDir.exists()) {
			boolean result = destDir.mkdirs();
			if (result == false) {
				throw new IllegalArgumentException("Invalid target path");
			}
		} else {
			FileUtil.clean(destDir);
		}
		javac.setDestdir(destDir);

		// Remove any compiled file
		String[] list = destDir.list();
		for (String filename : list) {
			File file = new File(destPath + File.separator + filename);
			boolean result = file.delete();
			if (result == false) {
				throw new IllegalArgumentException(
						"The target path could not be cleant");
			}
		}

		// Classpath setup
		Path classpath = javac.createClasspath();

		// Packages currently at the classpath
		FileSet basicSet = new FileSet();
		File basicDir = new File(basicPath);
		basicSet.setDir(basicDir);
		PatternSet.NameEntry basicSetPattern = basicSet.createInclude();
		basicSetPattern.setName("*.jar");
		classpath.addFileset(basicSet);

		// Packages required to compile the application
		FileSet additionalSet = new FileSet();
		File libsDir = new File(libsPath);
		additionalSet.setDir(libsDir);
		PatternSet.NameEntry additionalSetPattern = additionalSet
				.createInclude();
		additionalSetPattern.setName("*.jar");
		classpath.addFileset(additionalSet);

		startLogging(project);
		javac.perform();
		stopLogging(project);
		
	}

	private static Project createProject() {
		Project project = new Project();
		project.init();
		return project;
	}

	private static void startLogging(Project project) {
		project.addBuildListener(logger);
	}

	private static void stopLogging(Project project) {
		logger.finalize();
	}
}
