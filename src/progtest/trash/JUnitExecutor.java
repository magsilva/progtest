package progtest.trash;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.optional.junit.FormatterElement;
import org.apache.tools.ant.taskdefs.optional.junit.JUnitTask;
import org.apache.tools.ant.taskdefs.optional.junit.JUnitTest;
import org.apache.tools.ant.taskdefs.optional.junit.FormatterElement.TypeAttribute;
import org.apache.tools.ant.taskdefs.optional.junit.JUnitTask.SummaryAttribute;
import org.apache.tools.ant.types.Path;

public class JUnitExecutor {

	public static void run(String testClassPath, String reportPath, String classPath, String outFileName) {
		
		File report = new File(reportPath);
		
		if(!report.exists())
			report.mkdirs();
		
		Project project = createProject();
		JUnitTask junit = (JUnitTask) project.createTask("junit");
		junit.init();
		
		SummaryAttribute value = new SummaryAttribute();
		value.setValue("yes");
		junit.setPrintsummary(value);
		junit.setHaltonfailure(false);
		junit.setShowOutput(true);

		// Classpath setup
		Path classpath = junit.createClasspath();
		Path.PathElement pe = classpath.createPathElement();
		pe.setPath(classPath);
		
		//
		JUnitTest test = new JUnitTest();
		TypeAttribute type = new TypeAttribute();
		type.setValue("xml");
		FormatterElement elem = new FormatterElement();
		elem.setType(type);
		test.addFormatter(elem);
		test.setOutfile(outFileName);
		test.setTodir(new File(reportPath));
		test.setName(new File(testClassPath).getName());
		junit.addTest(test);
		
		// Batchtest setup
		/*BatchTest batchTest = junit.createBatchTest();
		batchTest.setFork(false);
		batchTest.setTodir(new File(reportPath));
		TypeAttribute type = new TypeAttribute();
		type.setValue("xml");
		FormatterElement formatter = new FormatterElement();
		formatter.setType(type);
		batchTest.addFormatter(formatter);
		FileSet sourceSet = new FileSet();
		File testClassFile = new File(testClassPath);
		sourceSet.setDir(testClassFile.getParentFile());
		String includes[] = {"**" + File.separator + testClassFile.getName()};
		sourceSet.appendIncludes(includes);
		batchTest.addFileSet(sourceSet);*/

		//startLogging(project);
		try {
			junit.perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//stopLogging(project);
	}

	private static Project createProject() {
		Project project = new Project();
		project.init();
		return project;
	}
}
