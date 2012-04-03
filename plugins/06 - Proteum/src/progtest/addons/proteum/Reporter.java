package progtest.addons.proteum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Reporter {

	public static void generateReports(File srcDir, File rptDir)
			throws Throwable {

		for (File file : FileUtil.list(srcDir, ".lst")) {

			File report = new File(rptDir + File.separator + file.getName());

			if (report.exists())
				FileUtil.delete(report);

			copy(file, report);

		}

	}

	private static void copy(File file, File report) throws Throwable {

		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {

			fw = new FileWriter(report, true);
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			while (br.ready())
				fw.write(br.readLine() + "\n");

			fw.write("\n\n");

			fw.close();

		} catch (Throwable t) {

			throw t;

		} finally {

			if (br != null)
				br.close();
			if (fr != null)
				fr.close();
			if (fw != null)
				fw.close();

		}

	}

}
