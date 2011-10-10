package progtest.execution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import progtest.common.Tool;
import progtest.util.FileUtil;

public class Executor {

	private static final String TAG_ROOT = "<root>";
	private static final String TAG_SOURCE = "<source>";
	private static final String TAG_BINARIES = "<binaries>";
	private static final String TAG_PROGRAM = "<program>";
	private static final String TAG_TESTS = "<tests>";
	private static final String TAG_INTRUMENTED = "<instrumented>";
	private static final String TAG_LIBRARIES = "<libraries>";
	private static final String TAG_TEMPORARIES = "<temporaries>";
	private static final String TAG_REPORTS = "<reports>";

	private static final String FILE_SEPARATOR = "/";

	public static void execute(Tool tool, File rootDir, File programDir,
			File testsDir, File reportsDir, String additionals)
			throws IOException, InterruptedException {

		File toolFile = new File(Directories.getToolFilePath(tool));

		File toolReportsDir = new File(Directories.getToolReportsDirPath(
				reportsDir, tool));

		File toolDir = new File(Directories.getToolDirPath(rootDir, tool));
		File srcDir = new File(Directories.getSrcDirPath(rootDir, tool));
		File binDir = new File(Directories.getBinDirPath(rootDir, tool));
		File progDir = new File(Directories.getProgDirPath(rootDir, tool));
		File testDir = new File(Directories.getTestDirPath(rootDir, tool));
		File instDir = new File(Directories.getInstDirPath(rootDir, tool));
		File libDir = new File(Directories.getLibDirPath(rootDir, tool));
		File tmpDir = new File(Directories.getTmpDirPath(rootDir, tool));
		File rptDir = new File(Directories.getRptDirPath(rootDir, tool));

		initialize(toolDir, srcDir, binDir, progDir, testDir, instDir, libDir,
				tmpDir, rptDir, toolFile, programDir, testsDir);

		process(toolDir, srcDir, binDir, progDir, testDir, instDir, libDir,
				tmpDir, rptDir, tool.getCmdfile(), additionals);

		finalize(toolDir, rptDir, toolReportsDir);

	}

	private static void initialize(File toolDir, File srcDir, File binDir,
			File progDir, File testDir, File instDir, File libDir, File tmpDir,
			File rptDir, File toolFile, File programDir, File testsDir)
			throws IOException {

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

		if (tmpDir.exists())
			FileUtil.clean(tmpDir);
		else
			tmpDir.mkdirs();

		if (rptDir.exists())
			FileUtil.clean(rptDir);
		else
			rptDir.mkdirs();

		FileUtil.unzip(toolFile, toolDir);

		FileUtil.merge(programDir, testsDir, srcDir);

	}

	private static void process(File toolDir, File srcDir, File binDir,
			File progDir, File testDir, File instDir, File libDir, File tmpDir,
			File rptDir, String cmdFileName, String additionals)
			throws IOException, InterruptedException {

		ProcessBuilder processBuilder = null;
		Process process = null;
		Worker worker = null;

		File script = new File(toolDir.getPath() + File.separator + cmdFileName);

		BufferedReader input = new BufferedReader(new FileReader(script));

		try {

			while (input.ready()) {

				String[] args = input.readLine().split(" ");

				for (int i = 0; i < args.length; i++)
					args[i] = args[i].replace(TAG_ROOT, toolDir.getPath())
							.replace(TAG_SOURCE, srcDir.getPath())
							.replace(TAG_BINARIES, binDir.getPath())
							.replace(TAG_PROGRAM, progDir.getPath())
							.replace(TAG_TESTS, testDir.getPath())
							.replace(TAG_INTRUMENTED, instDir.getPath())
							.replace(TAG_LIBRARIES, libDir.getPath())
							.replace(TAG_TEMPORARIES, tmpDir.getPath())
							.replace(TAG_REPORTS, rptDir.getPath())
							.replace(FILE_SEPARATOR, File.separator);

				processBuilder = new ProcessBuilder(args);
				process = processBuilder.start();

				worker = new Worker(process);
				worker.start();

				worker.join(60000);

			}

		} catch (InterruptedException e) {

			worker.interrupt();
			Thread.currentThread().interrupt();
			throw e;

		} finally {

			input.close();
			process.destroy();

		}

	}

	private static void finalize(File toolDir, File rptDir, File reportsDir)
			throws IOException {

		if (reportsDir.exists())
			FileUtil.clean(reportsDir);
		else
			reportsDir.mkdirs();

		FileUtil.copyContent(rptDir, reportsDir);

		FileUtil.delete(toolDir);

	}

	private static class Worker extends Thread {
		
		private final Process process;

		private Worker(Process process) {
			this.process = process;
		}

		public void run() {
			try {
				process.waitFor();
			} catch (InterruptedException ignore) {
				return;
			}
		}
		
	}

}
