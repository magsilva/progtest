package progtest.addons.proteum;

public class Result {
	
	private String source = "";
	
	private int total = 0;
	
	private int alive = 0;
	
	private int dead = 0;
	
	private int anomalous = 0;
	
	private double score = 0;
	
	private String[][] mutants = new String[0][0];

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAlive() {
		return alive;
	}

	public void setAlive(int alive) {
		this.alive = alive;
	}

	public int getDead() {
		return dead;
	}

	public void setDead(int dead) {
		this.dead = dead;
	}

	public int getAnomalous() {
		return anomalous;
	}

	public void setAnomalous(int anomalous) {
		this.anomalous = anomalous;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String[][] getMutants() {
		return mutants;
	}

	public void setMutants(String[][] mutants) {
		this.mutants = mutants;
	}

}
