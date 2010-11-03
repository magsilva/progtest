package progtest.execution.exceptions;

public class ExecutionException extends RunException {

	private static final long serialVersionUID = -1012527032152369786L;

	public ExecutionException() {
		super();
	}
	
	public ExecutionException(String message) {
		super(message);
	}
	
	public ExecutionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExecutionException(Throwable cause) {
		super(cause);
	}

}
