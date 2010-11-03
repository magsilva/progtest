package progtest.execution.exceptions;

public class RunDirectoriesException extends RunException {

	private static final long serialVersionUID = 6236943538253969614L;
	
	public RunDirectoriesException() {
		super();
	}
	
	public RunDirectoriesException(String message) {
		super(message);
	}
	
	public RunDirectoriesException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public RunDirectoriesException(Throwable cause) {
		super(cause);
	}

}
