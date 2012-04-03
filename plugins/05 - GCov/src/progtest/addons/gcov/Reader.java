package progtest.addons.gcov;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Reader {
	
	private double lineCoverage;
	
	private double branchCoverage;
	
	public double getLineCoverage() {
		return lineCoverage;
	}

	public void setLineCoverage(double lineCoverage) {
		this.lineCoverage = lineCoverage;
	}

	public double getBranchCoverage() {
		return branchCoverage;
	}

	public void setBranchCoverage(double branchCoverage) {
		this.branchCoverage = branchCoverage;
	}

	public Reader(File srcDir) {

		try {

		double lineCoverage = 0;
		double branchCoverage = 0;

		List<File> outFiles = FileUtil.list(srcDir, ".out");

		for (File outFile : outFiles) {
			lineCoverage += getLines(outFile);
			branchCoverage += getBranches(outFile);
		}
		
		lineCoverage /= (double) outFiles.size();
		branchCoverage /= (double) outFiles.size();
		
		this.lineCoverage = lineCoverage;
		this.branchCoverage = branchCoverage;

		} catch (Throwable t) {

			t.printStackTrace();

		}
		
	}

	private double getLines(File outFile) throws Throwable {

		double value = 0;

		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(outFile);
			br = new BufferedReader(fr);

			while (br.ready()) {

				String line = br.readLine();

				if (line.contains("Lines executed")) {
					String percentage = line.substring(line.indexOf(":") + 1,
							line.indexOf("%"));
					value = Double.parseDouble(percentage) / ((double) 100);
				}

			}

		} finally {

			if (br != null)
				br.close();
			if (fr != null)
				fr.close();

		}

		return value;

	}

	private double getBranches(File outFile) throws Throwable {

		double value = 0;

		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(outFile);
			br = new BufferedReader(fr);

			while (br.ready()) {

				String line = br.readLine();

				if (line.contains("Branches executed")) {
					String percentage = line.substring(line.indexOf(":") + 1,
							line.indexOf("%"));
					value = Double.parseDouble(percentage) / ((double) 100);
				}

			}

		} finally {

			if (br != null)
				br.close();
			if (fr != null)
				fr.close();

		}

		return value;

	}

}
