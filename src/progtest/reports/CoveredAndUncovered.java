package progtest.reports;

public class CoveredAndUncovered {
	
	private String method;
	
	private String criterion;
	
	private String coveredElements;
	
	private String uncoveredElements;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCriterion() {
		return criterion;
	}

	public void setCriterion(String criterion) {
		this.criterion = criterion;
	}

	public String getCoveredElements() {
		return coveredElements;
	}

	public void setCoveredElements(String coveredElements) {
		this.coveredElements = coveredElements;
	}

	public String getUncoveredElements() {
		return uncoveredElements;
	}

	public void setUncoveredElements(String uncoveredElements) {
		this.uncoveredElements = uncoveredElements;
	}

}
