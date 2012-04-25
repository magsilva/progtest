package progtest.addons.cunit;

public class Result {

	private double total = 0;

	private double suceeded = 0;

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSuceeded() {
		return suceeded;
	}

	public void setSuceeded(double suceeded) {
		this.suceeded = suceeded;
	}

	private String[][] listing = new String[0][0];

	private String[][] summary = new String[0][0];

	public String[][] getListing() {
		return listing;
	}

	public void setListing(String[][] listing) {
		this.listing = listing;
	}

	public String[][] getSummary() {
		return summary;
	}

	public void setSummary(String[][] summary) {
		this.summary = summary;
	}

}
