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

	private static final String SCRIPT = "script";

	private static final String TAG_ROOT = "<root>";
	private static final String TAG_SOURCE = "<source>";
	private static final String TAG_BINARIES = "<binaries>";
	private static final String TAG_PROGRAM = "<program>";
	private static final String TAG_TESTS = "<tests>";
	private static final String TAG_INTRUMENTED = "<instrumented>";
	private static final String TAG_LIBRARIES = "<libraries>";
	private static final String TAG_REPORTS = "<reports>";

	public static void execute(Tool tool, File rootDir, File programDir,
			File testsDir, File targetDir) throws IOException,
			InterruptedException {

		File toolFile = new File(Directories.getToolFilePath(tool));
		
		File toolDir = new File(Directories.getToolDirPath(rootDir, tool));
		File srcDir = new File(Directories.getSrcDirPath(rootDir, tool));
		File binDir = new File(Directories.getBinDirPath(rootDir, tool));
		File progDir = new File(Directories.getProgDirPath(rootDir, tool));
		File testDir = new File(Directories.getTestDirPath(rootDir, tool));
		File instDir = new File(Directories.getInstDirPath(rootDir, tool));
		File libDir = new File(Directories.getLibDirPath(rootDir, tool));
		File rptDir = new File(Directories.getRptDirPath(rootDir, tool));

		initialize(toolDir, srcDir, binDir, progDir, testDir, instDir, libDir,
				rptDir, toolFile, programDir, testsDir);

		process(toolDir, srcDir, binDir, progDir, testDir, instDir, libDir,
				rptDir);

		finalize(toolDir, rptDir, targetDir);

	}

	private static void initialize(File toolDir, File srcDir, File binDir,
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

	private static void process(File toolDir, File srcDir, File binDir,
			File progDir, File testDir, File instDir, File libDir, File rptDir)
			throws IOException, InterruptedException {

		File script = new File(toolDir.getPath() + File.separator + SCRIPT);

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
							.replace(TAG_REPORTS, rptDir.getPath());

				Process p = Runtime.getRuntime().exec(args);

				InputStream st = p.getInputStream();
				InputStreamReader isr = new InputStreamReader(st);
				BufferedReader br = new BufferedReader(isr);
				while (br.ready())
					System.out.println(br.readLine());

				st = p.getErrorStream();
				isr = new InputStreamReader(st);
				br = new BufferedReader(isr);
				while (br.ready())
					System.err.println(br.readLine());

				p.waitFor();

			}

		} finally {

			input.close();

		}

	}

	private static void finalize(File toolDir, File rptDir, File targetDir)
			throws IOException {
		FileUtil.copyContent(rptDir, targetDir);
		FileUtil.delete(toolDir);
	}

}
