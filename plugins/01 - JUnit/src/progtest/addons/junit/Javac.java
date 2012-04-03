package progtest.addons.junit;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.Path;

public class Javac {

	public static void main(String[] args) {

		if (args.length < 2) {

			System.out
					.println("Usage: progtest.compilers.Javac <sources directory> <target directory>");

		} else {

			File sourceDir = new File(args[0]);

			File targetDir = new File(args[1]);

			if (!sourceDir.exists()) {

				System.out.println("Directory not found: "
						+ sourceDir.getPath());

			} else if (!targetDir.exists()) {

				System.out.println("Directory not found: "
						+ targetDir.getPath());

			} else if (!sourceDir.isDirectory()) {

				System.out.println("It's not a directory: "
						+ sourceDir.getPath());

			} else if (!targetDir.isDirectory()) {

				System.out.println("It's not a directory: "
						+ targetDir.getPath());

			} else {

				Project project = new Project();
				project.init();
				org.apache.tools.ant.taskdefs.Javac javac = (org.apache.tools.ant.taskdefs.Javac) project
						.createTask("javac");
				javac.init();
				javac.setDebug(true);
				javac.setVerbose(true);

				// Source directory
				Path src = javac.createSourcepath();
				src.setLocation(sourceDir);
				javac.setSrcdir(src);

				// Target directory
				javac.setDestdir(targetDir);

				// Remove any compiled file
				clean(targetDir);

				javac.perform();

			}

		}

	}

	private static void clean(File f) {
		if (f.isDirectory()) {
			File[] children = f.listFiles();
			for (int i = 0; i < children.length; i++)
				delete(children[i]);
		}
	}

	private static void delete(File f) {
		clean(f);
		f.delete();
	}

}
