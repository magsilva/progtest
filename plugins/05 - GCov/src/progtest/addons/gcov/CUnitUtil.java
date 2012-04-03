package progtest.addons.gcov;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CUnitUtil {

	public static final String CUNIT_OUTPUT_FILENAMEROOT = "CUNIT";

	public static final String CUNIT_OUTPUT_FILENAME = "CUNIT-Results.xml";

	public static File configureCUnitOutput(File srcDir, File tmpDir)
			throws IOException {

		List<File> cFiles = FileUtil.list(srcDir, ".c");

		for (File file : cFiles) {

			boolean replace = false;

			FileReader fr = null;
			BufferedReader br = null;

			File tf = null;
			FileWriter fw = null;

			try {

				fr = new FileReader(file);
				br = new BufferedReader(fr);

				tf = new File(tmpDir + File.separator + "cunit_test.c");
				tf.createNewFile();
				fw = new FileWriter(tf);

				while (br.ready()) {

					String line = br.readLine();

					if (line.contains("CU_automated_run_tests()")) {
						fw.write("CU_set_output_filename(\"" + tmpDir
								+ File.separator
								+ CUNIT_OUTPUT_FILENAMEROOT
								+ "\");\n");
						replace = true;
					}

					fw.write(line + "\n");

				}

				fw.close();
				br.close();
				fr.close();

				if (replace) {
					file.delete();
					tf.renameTo(file);
				}

			} finally {

				if (fw != null)
					fw.close();
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();

			}

			File shareDir = new File(Constants.CUNIT_SHARE_FILE);
			FileUtil.unzip(shareDir, tmpDir);

		}

		return new File(tmpDir + File.separator + CUNIT_OUTPUT_FILENAME);

	}

	public static boolean isCUnitTest(File cFile) throws IOException {

		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(cFile);
			br = new BufferedReader(fr);

			while (br.ready()) {

				String line = br.readLine();

				if (line.contains("CU_automated_run_tests()"))
					return true;

			}

			br.close();
			fr.close();

		} finally {

			if (br != null)
				br.close();
			if (fr != null)
				fr.close();

		}

		return false;

	}

}
