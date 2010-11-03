package progtest.execution.exceptions;

public class CopyException extends RunException {
	
	private static final long serialVersionUID = 5833711909682553191L;

	public CopyException() {
		super();
	}
	
	public CopyException(String message) {
		super(message);
	}
	
	public CopyException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CopyException(Throwable cause) {
		super(cause);
	}

}
