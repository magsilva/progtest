package progtest.reports;

public class CriterionCoverage {
	
	public String criterion;
	
	public String numberOfElements;
	
	public String numberOfCoveredElements;
	
	public String percentage;

	public String getCriterion() {
		return criterion;
	}

	public void setCriterion(String criterion) {
		this.criterion = criterion;
	}

	public String getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(String numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public String getNumberOfCoveredElements() {
		return numberOfCoveredElements;
	}

	public void setNumberOfCoveredElements(String numberOfCoveredElements) {
		this.numberOfCoveredElements = numberOfCoveredElements;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

}
