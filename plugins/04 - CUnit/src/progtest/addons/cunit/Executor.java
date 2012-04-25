package progtest.addons.cunit;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

	public void compile(File srcDir) {

		String[] args = new String[9];
		args[0] = "gcc";
		args[1] = "-L";
		args[2] = lib.getPath();
		args[3] = "-I";
		args[4] = include.getPath();
		args[5] = "-c";
		args[7] = "-o";

		List<File> cFiles = FileUtil.list(srcDir, ".c");

		for (File cFile : cFiles) {
			args[6] = cFile.getPath();
			args[8] = cFile.getPath().replace(".c", ".o");
			cmd(args);
		}

	}

	public void link(File srcDir, File binDir) {

		List<File> oFiles = FileUtil.list(srcDir, ".o");

		int n = oFiles.size();

		String[] args = new String[8 + n];

		args[0] = "gcc";
		args[1] = "-L";
		args[2] = lib.getPath();
		args[3] = "-I";
		args[4] = include.getPath();

		for (int i = 5; i < 5 + n; i++) {
			args[i] = oFiles.get(i - 5).getPath();
		}

		args[n + 5] = "-lcunit";
		args[n + 6] = "-o";
		args[n + 7] = binDir.getPath() + File.separator + OUTFILENAME;

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

	public void finalize() {
		FileUtil.delete(tmpDir);
	}

}
