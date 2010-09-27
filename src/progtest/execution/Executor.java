package progtest.execution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import progtest.common.Tool;
import progtest.util.FileUtil;

public class Executor {

	private static final String FILE_PREPROCESS = "preprocess";
	private static final String FILE_COMPILE = "compile";
	private static final String FILE_POSTPROCESS = "postprocess";

	private static final String TAG_ROOT = "<root>";
	private static final String TAG_SOURCE = "<source>";
	private static final String TAG_BINARIES = "<binaries>";
	private static final String TAG_PROGRAM = "<program>";
	private static final String TAG_TESTS = "<tests>";
	private static final String TAG_INTRUMENTED = "<instrumented>";
	private static final String TAG_LIBRARIES = "<libraries>";
	private static final String TAG_REPORTS = "<reports>";

	public static void execute(Tool tool, File toolDir, File programDir,
			File testsDir, File reportsDir) throws IOException,
			InterruptedException {

		File toolFile = new File(Directories.getToolFilePath(tool));

		File srcDir = new File(Directories.getSrcDirPath(toolDir, tool));
		File binDir = new File(Directories.getBinDirPath(toolDir, tool));
		File progDir = new File(Directories.getProgDirPath(toolDir, tool));
		File testDir = new File(Directories.getTestDirPath(toolDir, tool));
		File instDir = new File(Directories.getInstDirPath(toolDir, tool));
		File libDir = new File(Directories.getLibDirPath(toolDir, tool));
		File rptDir = new File(Directories.getRptDirPath(toolDir, tool));

		makeDirectories(toolDir, srcDir, binDir, progDir, testDir, instDir,
				libDir, rptDir, toolFile, programDir, testsDir);

		preprocess(toolDir, srcDir, binDir, progDir, testDir, instDir, libDir,
				rptDir);

		compile(toolDir, srcDir, binDir, progDir, testDir, instDir, libDir,
				rptDir);

		postprocess(toolDir, srcDir, binDir, progDir, testDir, instDir, libDir,
				rptDir);

		removeDirectories(toolDir);

	}

	private static void makeDirectories(File toolDir, File srcDir, File binDir,
			File progDir, File testDir, File instDir, File libDir, File rptDir,
			File toolFile, File programDir, File testsDir) throws IOException {

		if (toolDir.exists())
			FileUtil.clean(toolDir);
		else
			toolDir.mkdirs();

		if (srcDir.exists())
			FileUtil.clean(srcDir);
		else
			srcDir.mkdirs();

		if (binDir.exists())
			FileUtil.clean(binDir);
		else
			binDir.mkdirs();

		if (progDir.exists())
			FileUtil.clean(progDir);
		else
			progDir.mkdirs();

		if (testDir.exists())
			FileUtil.clean(testDir);
		else
			testDir.mkdirs();

		if (instDir.exists())
			FileUtil.clean(instDir);
		else
			instDir.mkdirs();

		if (libDir.exists())
			FileUtil.delete(libDir);

		if (rptDir.exists())
			FileUtil.clean(rptDir);
		else
			rptDir.mkdirs();

		FileUtil.unzip(toolFile, toolDir);

		FileUtil.merge(programDir, testsDir, srcDir);

	}

	private static void preprocess(File toolDir, File srcDir, File binDir,
			File progDir, File testDir, File instDir, File libDir, File rptDir)
			throws IOException, InterruptedException {
		File script = new File(toolDir.getPath() + File.separator
				+ FILE_PREPROCESS);
		process(script, toolDir, srcDir, binDir, progDir, testDir, instDir,
				libDir, rptDir);
	}

	private static void compile(File toolDir, File srcDir, File binDir,
			File progDir, File testDir, File instDir, File libDir, File rptDir)
			throws IOException, InterruptedException {
		File script = new File(toolDir.getPath() + File.separator
				+ FILE_COMPILE);
		process(script, toolDir, srcDir, binDir, progDir, testDir, instDir,
				libDir, rptDir);
	}

	private static void postprocess(File toolDir, File srcDir, File binDir,
			File progDir, File testDir, File instDir, File libDir, File rptDir)
			throws IOException, InterruptedException {
		File script = new File(toolDir.getPath() + File.separator
				+ FILE_POSTPROCESS);
		process(script, toolDir, srcDir, binDir, progDir, testDir, instDir,
				libDir, rptDir);
	}

	private static void process(File script, File toolDir, File srcDir,
			File binDir, File progDir, File testDir, File instDir, File libDir,
			File rptDir) throws IOException, InterruptedException {

		BufferedReader input = new BufferedReader(new FileReader(script));

		try {

			while (input.ready()) {

				String[] args = input.readLine()
						.replace(TAG_ROOT, toolDir.getPath())
						.replace(TAG_SOURCE, srcDir.getPath())
						.replace(TAG_BINARIES, binDir.getPath())
						.replace(TAG_PROGRAM, progDir.getPath())
						.replace(TAG_TESTS, testDir.getPath())
						.replace(TAG_INTRUMENTED, instDir.getPath())
						.replace(TAG_LIBRARIES, libDir.getPath())
						.replace(TAG_REPORTS, rptDir.getPath()).split(" ");

				Process p = Runtime.getRuntime().exec(args);

				boolean isEmpty = true;

				InputStream st = p.getInputStream();
				InputStreamReader isr = new InputStreamReader(st);
				BufferedReader br = new BufferedReader(isr);
				while (br.ready()) {
					System.out.println(br.readLine());
					isEmpty = false;
				}

				st = p.getErrorStream();
				isr = new InputStreamReader(st);
				br = new BufferedReader(isr);
				while (br.ready()) {
					System.out.println(br.readLine());
					isEmpty = false;
				}

				if (!isEmpty)
					p.waitFor();

			}

		} finally {

			input.close();

		}

	}

	private static void removeDirectories(File toolDir) {
		toolDir.delete();
	}

}
