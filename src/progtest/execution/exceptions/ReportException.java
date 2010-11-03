package progtest.execution.exceptions;

public class ReportException extends RunException {

	private static final long serialVersionUID = -553048758947476509L;

	public ReportException() {
		super();
	}
	
	public ReportException(String message) {
		super(message);
	}
	
	public ReportException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ReportException(Throwable cause) {
		super(cause);
	}

}
