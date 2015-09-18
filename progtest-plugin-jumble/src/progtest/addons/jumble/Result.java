package progtest.addons.jumble;

import java.util.ArrayList;
import java.util.List;

public class Result {

	private String[][] scoreByClass;
	
	private List<String> allMutants = new ArrayList<String>();
	
	private List<String> aliveMutants = new ArrayList<String>();
	
	private List<String> deadMutants = new ArrayList<String>();

	public Result(String[][] scoreByClass) {
		this.scoreByClass = scoreByClass;
	}

	public String[][] getScoreByClass() {
		return scoreByClass;
	}

	public List<String> getAllMutants() {
		return allMutants;
	}

	public List<String> getAliveMutants() {
		return aliveMutants;
	}
	public List<String> getDeadMutants() {
		return deadMutants;
	}

}
