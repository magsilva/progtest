package progtest.addons.jabutiservice;

public class Result {

	String[][] requiredElements = new String[0][0];

	String[][] coverageByClass = new String[0][0];

	String[][] coverageByMethod = new String[0][0];

	String[][] coverageByCriterion = new String[0][0];

	String[][] coveredAndUncoveredElements = new String[0][0];

	public String[][] getRequiredElements() {
		return requiredElements;
	}

	public void setRequiredElements(String[][] requiredElements) {
		this.requiredElements = requiredElements;
	}

	public String[][] getCoverageByClass() {
		return coverageByClass;
	}

	public void setCoverageByClass(String[][] coverageByClass) {
		this.coverageByClass = coverageByClass;
	}

	public String[][] getCoverageByMethod() {
		return coverageByMethod;
	}

	public void setCoverageByMethod(String[][] coverageByMethod) {
		this.coverageByMethod = coverageByMethod;
	}

	public String[][] getCoverageByCriterion() {
		return coverageByCriterion;
	}

	public void setCoverageByCriterion(String[][] coverageByCriterion) {
		this.coverageByCriterion = coverageByCriterion;
	}

	public String[][] getCoveredAndUncoveredElements() {
		return coveredAndUncoveredElements;
	}

	public void setCoveredAndUncoveredElements(
			String[][] coveredAndUncoveredElements) {
		this.coveredAndUncoveredElements = coveredAndUncoveredElements;
	}

}
