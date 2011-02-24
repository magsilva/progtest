package progtest.execution;

import java.io.File;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

import javax.faces.context.FacesContext;

public class Logger {
	
	java.util.logging.Logger logger = java.util.logging.Logger
	.getLogger("Runner");
	
	FileHandler fh = null;

	public void start(File logFile) {

		try {

			fh = new FileHandler(logFile.getPath(), true);
			logger.addHandler(fh);
			logger.setLevel(Level.ALL);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

		} catch (Throwable t) {

			t.printStackTrace();

		}

	}

	public void severe(String key) {
		logger.severe(getMessage(key));
	}

	public void warning(String key) {
		logger.warning(getMessage(key));
	}

	public void info(String key) {
		logger.info(getMessage(key));
	}

	public void config(String key) {
		logger.severe(getMessage(key));
	}

	public void fine(String key) {
		logger.fine(getMessage(key));
	}

	public void finer(String key) {
		logger.finer(getMessage(key));
	}

	public void finest(String key) {
		logger.finest(getMessage(key));
	}

	public void stop() {
		logger.removeHandler(fh);
	}
	
	private static String getMessage(String key) {
		
		try {
			
			ResourceBundle bundle = ResourceBundle.getBundle(
					"logger", FacesContext
							.getCurrentInstance().getViewRoot().getLocale());
			
			return bundle.getString(key);
			
		} catch (Throwable t) {
			
			return key;
			
		}
		
	}

}
