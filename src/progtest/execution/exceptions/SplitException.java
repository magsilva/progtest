package progtest.execution.exceptions;

public class SplitException extends RunException {

	private static final long serialVersionUID = 1245581592267805543L;

	public SplitException() {
		super();
	}
	
	public SplitException(String message) {
		super(message);
	}
	
	public SplitException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SplitException(Throwable cause) {
		super(cause);
	}

}
