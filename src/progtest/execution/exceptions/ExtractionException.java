package progtest.execution.exceptions;

public class ExtractionException extends RunException {

	private static final long serialVersionUID = 3555030934497818153L;

	public ExtractionException() {
		super();
	}
	
	public ExtractionException(String message) {
		super(message);
	}
	
	public ExtractionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExtractionException(Throwable cause) {
		super(cause);
	}

}
