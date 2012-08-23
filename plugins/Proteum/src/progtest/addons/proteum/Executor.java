package progtest.addons.proteum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Executor {

	private final String OUTFILENAME = "out";

	private final boolean is64 = System.getProperty("os.arch").contains("64");

	private File bin;

	private File lib;

	private File include;

	public Executor(File tmpDir) throws IOException {

		bin = new File(tmpDir + File.separator + "bin");
		include = new File(tmpDir + File.separator + "include");
		lib = new File(tmpDir + File.separator + "lib");

		File binDir = new File(Constants.PROTEUM_BIN_FILE);
		File includeDir = new File(Constants.CUNIT_INCLUDE_FILE);
		File libDir = null;

		if (is64)
			libDir = new File(Constants.CUNIT_LIB64_FILE);
		else
			libDir = new File(Constants.CUNIT_LIB_FILE);

		FileUtil.unzip(binDir, bin);
		FileUtil.unzip(includeDir, include);
		FileUtil.unzip(libDir, lib);

		chmod();

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

	public void link(File srcDir) {

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
		args[n + 7] = srcDir.getPath() + File.separator + OUTFILENAME;

		cmd(args);

	}

	public List<Result> execute(File srcDir, String additionals) {

		List<Result> results = new ArrayList<Result>();

		try {

			List<File> cFiles = FileUtil.list(srcDir, ".c");

			List<File> cFiles2 = FileUtil.list(srcDir, ".c");

			for (File cFile : cFiles) {

				if (!CUnitUtil.isCUnitTest(cFile)
						&& !cFile.getName().startsWith("__")) {

					String command = "gcc -I " + include + " -L " + lib
							+ " -o " + OUTFILENAME + " " + cFile.getName();

					for (File cFile2 : cFiles2)
						if (!cFile.getName().equals(cFile2.getName())
								&& !cFile2.getName().startsWith("__"))
							command += " " + cFile2.getPath();

					command += " -w -lcunit";

					String filename = cFile.getName().replace(".c", "");

					proteum(srcDir, filename, command, additionals);

					muta(srcDir, filename);

				}

			}

			results = getResults(srcDir);

		} catch (Throwable e) {

			e.printStackTrace();

		}

		return results;

	}

	private void proteum(File srcDir, String filename, String command,
			String additionals) throws IOException {

		String[] args = new String[5];

		args[0] = "xvfb-run";
		args[1] = "-a";
		args[2] = "xterm";
		args[3] = "-e";
		args[4] = bin + File.separator + "proteum" + " " + srcDir.getPath()
				+ " " + filename + " " + OUTFILENAME + " \"" + command
				+ "\" \"" + additionals + "\" >" + srcDir.getPath()
				+ File.separator + filename + ".log 2>&1";

		cmd(args);

		File file = new File(srcDir, filename + ".log");

		if (file.exists()) {

			FileReader fr = null;
			BufferedReader br = null;

			try {

				fr = new FileReader(file);
				br = new BufferedReader(fr);

				while (br.ready()) {
					String line = br.readLine();
					if (!line.equals("PASS") && !line.equals("FAIL"))
						System.out.println(line);
				}

			} finally {

				if (br != null)
					br.close();
				if (fr != null)
					fr.close();

			}

		}

	}

	private void muta(File srcDir, String filename) {

		String[] args = new String[5];

		args[0] = "xvfb-run";
		args[1] = "-a";
		args[2] = "xterm";
		args[3] = "-e";
		args[4] = bin + File.separator + "muta -l -D " + srcDir.getPath() + " "
				+ filename + " >" + srcDir.getPath() + File.separator
				+ filename + ".muta 2>&1";

		cmd(args);

	}

	private List<Result> getResults(File srcDir) throws IOException {

		List<Result> results = new ArrayList<Result>();

		List<File> lstFiles = FileUtil.list(srcDir, ".lst");

		for (File lstFile : lstFiles) {

			Result result = new Result();

			FileReader fr = null;
			BufferedReader br = null;

			try {

				fr = new FileReader(lstFile);
				br = new BufferedReader(fr);

				while (br.ready()) {

					String line = br.readLine();

					if (line.contains("[]   SOURCE FILE: "))
						result.setSource(line.substring(line.indexOf(": ") + 2));
					else if (line.contains("[]   TOTAL MUTANTS: "))
						result.setTotal(Integer.parseInt(line.substring(line
								.indexOf(": ") + 2)));
					else if (line.contains("[]   ANOMALOUS MUTANTS: "))
						result.setAnomalous(Integer.parseInt(line
								.substring(line.indexOf(": ") + 2)));
					else if (line.contains("[]   ALIVE MUTANTS: ")) {
						result.setAlive(Integer.parseInt(line.substring(line
								.indexOf(": ") + 2)));
						result.setDead(result.getTotal()
								- result.getAnomalous() - result.getAlive());
					} else if (line.contains("[]   MUTATION SCORE: "))
						result.setScore(Double.parseDouble(line.substring(line
								.indexOf(": ") + 2)));

				}

			} finally {

				if (br != null)
					br.close();
				if (fr != null)
					fr.close();

			}

			result.setMutants(getMutants(srcDir, result));

			results.add(result);

		}

		return results;

	}

	private String[][] getMutants(File srcDir, Result result)
			throws IOException {

		String[][] mutants = new String[result.getTotal() + 1][4];

		for (int i = 0; i < mutants.length; i++)
			for (int j = 0; j < mutants[0].length; j++)
				mutants[i][j] = "";

		File mutaFile = new File(srcDir, result.getSource() + ".muta");

		if (mutaFile.exists()) {

			FileReader fr = null;
			BufferedReader br = null;

			int index = 1;

			try {

				fr = new FileReader(mutaFile);
				br = new BufferedReader(fr);

				while (br.ready()) {

					String line = br.readLine();

					if (line.contains("MUTANT # ")) {
						index = Integer.parseInt(line.substring(line
								.indexOf("MUTANT # ") + 9));
						mutants[index][0] = line.substring(line
								.indexOf("MUTANT # ") + 9);
					} else if (line.contains("\tStatus ")) {
						mutants[index][1] = line.substring(
								line.indexOf("\tStatus ") + 8,
								line.lastIndexOf(" "));
					} else if (line.contains("\tOperator: ")) {
						mutants[index][2] = line.substring(
								line.indexOf("(u-") + 3, line.lastIndexOf(")"));
					} else if (line.contains("\t\tGet on: ")) {
						mutants[index][3] = line.substring(line
								.indexOf("\t\tGet on: ") + 10);
					}

				}

			} finally {

				if (br != null)
					br.close();
				if (fr != null)
					fr.close();

			}

		}

		return mutants;

	}

	private void chmod() {

		String args[] = new String[3];

		args[0] = "chmod";
		args[1] = "+x";

		args[2] = bin + File.separator + "bac";
		cmd(args);

		args[2] = bin + File.separator + "ccc";
		cmd(args);

		args[2] = bin + File.separator + "check-equiv";
		cmd(args);

		args[2] = bin + File.separator + "clean";
		cmd(args);

		args[2] = bin + File.separator + "exemuta";
		cmd(args);

		args[2] = bin + File.separator + "extimout";
		cmd(args);

		args[2] = bin + File.separator + "headtail";
		cmd(args);

		args[2] = bin + File.separator + "instrum";
		cmd(args);

		args[2] = bin + File.separator + "li";
		cmd(args);

		args[2] = bin + File.separator + "list-good";
		cmd(args);

		args[2] = bin + File.separator + "makezip";
		cmd(args);

		args[2] = bin + File.separator + "muta";
		cmd(args);

		args[2] = bin + File.separator + "muta-gen";
		cmd(args);

		args[2] = bin + File.separator + "muta-view";
		cmd(args);

		args[2] = bin + File.separator + "opmuta";
		cmd(args);

		args[2] = bin + File.separator + "proteuIMcpp";
		cmd(args);

		args[2] = bin + File.separator + "proteum";
		cmd(args);

		args[2] = bin + File.separator + "proteumim";
		cmd(args);

		args[2] = bin + File.separator + "pteste";
		cmd(args);

		args[2] = bin + File.separator + "recinput";
		cmd(args);

		args[2] = bin + File.separator + "report";
		cmd(args);

		args[2] = bin + File.separator + "splitarg";
		cmd(args);

		args[2] = bin + File.separator + "tcase";
		cmd(args);

		args[2] = bin + File.separator + "tcase-add";
		cmd(args);

		args[2] = bin + File.separator + "test-new";
		cmd(args);

	}

	private void cmd(String[] args) {

		try {

			ProcessBuilder pb = new ProcessBuilder(args);

			Map<String, String> env = pb.environment();
			String path = env.get("PATH");
			env.put("PATH", path + File.pathSeparator + bin.getPath());
			env.put("PROTEUMIMHOME", bin.getPath());

			Process p = pb.start();

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
