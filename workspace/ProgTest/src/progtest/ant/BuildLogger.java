package progtest.ant;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.DefaultLogger;

public class BuildLogger extends DefaultLogger {

	private PrintStream ps;
	private FileOutputStream fs;

	public BuildLogger() {
		try {
			fs = new FileOutputStream("build.log");
			ps = new PrintStream(fs);
			setOutputPrintStream(ps);
			setErrorPrintStream(ps);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void buildStarted(BuildEvent event) {
	}

	public void buildFinished(BuildEvent event) {
	}

	public void targetStarted(BuildEvent event) {
	}

	public void targetFinished(BuildEvent event) {
	}

	public void taskStarted(BuildEvent event) {
	}

	public void taskFinished(BuildEvent event) {
	}

	public void messageLogged(BuildEvent event) {
		System.out.println(event.getMessage());
		if (event.getException() != null) {
			System.out.println(event.getException());
		}
	}

	public void finalize() {
		try {
			fs.close();
			ps.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
