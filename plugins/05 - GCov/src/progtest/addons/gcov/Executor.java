package progtest.addons.gcov;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

public class Executor {

	private final String OUTFILENAME = "out";

	private final boolean is64 = System.getProperty("os.arch").contains("64");

	private File tmpDir;

	private File lib;

	private File include;

	public Executor() throws IOException {

		tmpDir = FileUtil.createTempDirectory();

		include = new File(tmpDir + File.separator + "include");
		lib = new File(tmpDir + File.separator + "lib");

		File includeDir = new File(Constants.CUNIT_INCLUDE_FILE);
		File libDir = null;

		if (is64)
			libDir = new File(Constants.CUNIT_LIB64_FILE);
		else
			libDir = new File(Constants.CUNIT_LIB_FILE);

		FileUtil.unzip(includeDir, include);
		FileUtil.unzip(libDir, lib);

	}

	public void compile(File srcDir) throws Throwable {

		try {

			List<File> cFiles = FileUtil.list(srcDir, ".c");

			for (File cFile : cFiles) {

				if (CUnitUtil.isCUnitTest(cFile)) {

					String[] args = new String[9];
					args[0] = "gcc";
					args[1] = "-L";
					args[2] = lib.getPath();
					args[3] = "-I";
					args[4] = include.getPath();
					args[5] = "-c";
					args[6] = cFile.getPath();
					args[7] = "-o";
					args[8] = cFile.getPath().replace(".c", ".o");
					cmd(args);

				} else {

					String[] args = new String[10];
					args[0] = "gcc";
					args[1] = "--coverage";
					args[2] = "-L";
					args[3] = lib.getPath();
					args[4] = "-I";
					args[5] = include.getPath();
					args[6] = "-c";
					args[7] = cFile.getPath();
					args[8] = "-o";
					args[9] = cFile.getPath().replace(".c", ".o");
					cmd(args);

				}

			}

		} catch (Throwable t) {

			throw t;

		}

	}

	public void link(File srcDir, File binDir) {

		List<File> oFiles = FileUtil.list(srcDir, ".o");

		int n = oFiles.size();

		String[] args = new String[9 + n];

		args[0] = "gcc";
		args[1] = "--coverage";
		args[2] = "-L";
		args[3] = lib.getPath();
		args[4] = "-I";
		args[5] = include.getPath();

		for (int i = 6; i < 6 + n; i++) {
			args[i] = oFiles.get(i - 6).getPath();
		}

		args[n + 6] = "-lcunit";
		args[n + 7] = "-o";
		args[n + 8] = binDir.getPath() + File.separator + OUTFILENAME;

		cmd(args);

	}

	public void execute(File binDir) {

		String[] args = new String[4];

		if (is64)
			args[0] = "/lib64/ld-linux-x86-64.so.2";
		else
			args[0] = "/lib/ld-linux.so.2";
		
		args[1] = "--library-path";
		args[2] = lib.getPath();
		args[3] = binDir + File.separator + OUTFILENAME;

		cmd(args);

	}

	public void analize(File srcDir) {

		PrintStream ps = System.out;

		try {

			List<File> cFiles = FileUtil.list(srcDir, ".c");

			for (File cFile : cFiles) {

				if (!CUnitUtil.isCUnitTest(cFile)) {

					PrintStream out = new PrintStream(cFile.getPath()
							.replace(".c", ".out"));
					System.setOut(out);

					String[] args = new String[5];

					args[0] = "gcov";
					args[1] = "-b";
					args[2] = "-o";
					args[3] = cFile.getParent();
					args[4] = cFile.getName();

					cmd(args);

				}

			}
			
			List<File> gcovFiles = FileUtil.list(new File("."), ".gcov");
			
			for(File gcovFile : gcovFiles) {
				FileUtil.copy(gcovFile, srcDir);
				gcovFile.delete();
			}

		} catch (Throwable e) {

			e.printStackTrace();

		} finally {

			System.setOut(ps);

		}

	}

	public void finalize() {
		FileUtil.delete(tmpDir);
	}

	private void cmd(String[] args) {

		try {

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

			st = p.getInputStream();
			isr = new InputStreamReader(st);
			br = new BufferedReader(isr);
			while (br.ready())
				System.out.println(br.readLine());

			st = p.getErrorStream();
			isr = new InputStreamReader(st);
			br = new BufferedReader(isr);
			while (br.ready())
				System.err.println(br.readLine());

		} catch (Throwable t) {

			t.printStackTrace();

		}

	}

}
