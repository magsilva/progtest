package progtest.addons.gcov;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Reporter {

	private static final String REPORT_OUTPUT_FILENAME = "Output";

	private static final String REPORT_SOURCES_FILENAME = "Sources";

	public static void generateOutputReport(File srcDir, File rptDir)
			throws Throwable {

		File report = new File(rptDir + File.separator + REPORT_OUTPUT_FILENAME);

		if (report.exists())
			FileUtil.delete(report);

		for (File file : FileUtil.list(srcDir, ".out"))
			copy(file, report);

	}

	public static void generateSourcesReport(File srcDir, File rptDir)
			throws Throwable {

		File report = new File(rptDir + File.separator
				+ REPORT_SOURCES_FILENAME);

		if (report.exists())
			FileUtil.delete(report);

		for (File file : FileUtil.list(srcDir, ".gcov"))
			copy(file, report);

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
