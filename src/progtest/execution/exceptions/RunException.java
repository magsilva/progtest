package progtest.execution.exceptions;

public class RunException extends Exception {

	private static final long serialVersionUID = 4171159968674271174L;
	
	public RunException() {
		super();
	}
	
	public RunException(String message) {
		super(message);
	}
	
	public RunException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public RunException(Throwable cause) {
		super(cause);
	}

}
