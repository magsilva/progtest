package progtest.execution.exceptions;

public class EvaluationException extends RunException {

	private static final long serialVersionUID = 7066044774721993609L;

	public EvaluationException() {
		super();
	}
	
	public EvaluationException(String message) {
		super(message);
	}
	
	public EvaluationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EvaluationException(Throwable cause) {
		super(cause);
	}

}
