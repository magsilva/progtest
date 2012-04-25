package progtest.addons.gcov;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Reader {

	private Result result = new Result();

	public Result getResult() {
		return result;
	}

	public Reader(File srcDir) {

		try {

			List<File> outFiles = FileUtil.list(srcDir, ".out");

			String[][] coverages = new String[outFiles.size()][9];

			for (int i = 0; i < outFiles.size(); i++) {

				File outFile = outFiles.get(i);
				
				coverages[i][0] = outFile.getName().replace(".out", "");
				
				FileReader fr = null;
				BufferedReader br = null;

				try {

					fr = new FileReader(outFile);
					br = new BufferedReader(fr);

					while (br.ready()) {

						String line = br.readLine();

						if (line.contains("Lines executed")) {
							
							String value = line.substring(line.indexOf(":") + 1,
									line.indexOf("%"));
							coverages[i][1] = value + "%";
							
							value = line.substring(line.indexOf("of ") + 3);
							coverages[i][2] = value;
							
						}
						
						if (line.contains("Branches executed")) {
							
							String value = line.substring(line.indexOf(":") + 1,
									line.indexOf("%"));
							coverages[i][3] = value + "%";
							
							value = line.substring(line.indexOf("of ") + 3);
							coverages[i][4] = value;
							
						}
						
						if (line.contains("Taken at least once")) {
							
							String value = line.substring(line.indexOf(":") + 1,
									line.indexOf("%"));
							coverages[i][5] = value + "%";
							
							value = line.substring(line.indexOf("of ") + 3);
							coverages[i][6] = value;
							
						}
						
						if (line.contains("Calls executed")) {
							
							String value = line.substring(line.indexOf(":") + 1,
									line.indexOf("%"));
							coverages[i][7] = value + "%";
							
							value = line.substring(line.indexOf("of ") + 3);
							coverages[i][8] = value;
							
						}

					}

				} finally {

					if (br != null)
						br.close();
					if (fr != null)
						fr.close();

				}

			}

			result.setCoverages(coverages);
			
			result.setSources(FileUtil.list(srcDir, ".gcov"));

		} catch (Throwable t) {

			t.printStackTrace();

		}

	}

}
