package progtest.addons.proteum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Reader {

	private double score;

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Reader(File srcDir) {

		try {

			double score = 0;

			List<File> lstFiles = FileUtil.list(srcDir, ".lst");

			for (File lstFile : lstFiles)
				score += getScore(lstFile);

			if(lstFiles.size() != 0)
				score /= (double) lstFiles.size();

			this.score = score;

		} catch (Throwable t) {

			t.printStackTrace();

		}

	}

	private double getScore(File lstFile) throws Throwable {

		double value = 0;

		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(lstFile);
			br = new BufferedReader(fr);

			while (br.ready()) {

				String line = br.readLine();

				if (line.contains("[]   MUTATION SCORE: ")) {
					String score = line.substring(line.indexOf(": ") + 2);
					value = Double.parseDouble(score);
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
