package progtest.execution.exceptions;

public class UploadException extends RunException {

	private static final long serialVersionUID = -326879118444484048L;
	
	public UploadException() {
		super();
	}
	
	public UploadException(String message) {
		super(message);
	}
	
	public UploadException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UploadException(Throwable cause) {
		super(cause);
	}

}
