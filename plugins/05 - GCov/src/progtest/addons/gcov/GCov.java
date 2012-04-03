package progtest.addons.gcov;

import java.io.File;

public class GCov {

	public static void main(String args[]) {if (args.length < 4) {

		System.out
				.println("Usage: progtest.addons.CUnit <source directory> <binaries directory> <temporary directory> <reports directory>");

	} else {

		File srcDir = new File(args[0]);
		File binDir = new File(args[1]);
		File tmpDir = new File(args[2]);
		File rptDir = new File(args[3]);

		if (!srcDir.exists()) {

			System.err.println("Directory not found: " + srcDir.getPath());

		} else if (!binDir.exists()) {

			System.err.println("Directory not found: " + binDir.getPath());

		} else if (!tmpDir.exists()) {

			System.err.println("Directory not found: " + tmpDir.getPath());

		} else if (!rptDir.exists()) {

			System.err.println("Directory not found: " + rptDir.getPath());

		} else if (!srcDir.isDirectory()) {

			System.err.println("It's not a directory: " + srcDir.getPath());

		} else if (!binDir.isDirectory()) {

			System.err.println("It's not a directory: " + binDir.getPath());

		} else if (!tmpDir.isDirectory()) {

			System.err.println("It's not a directory: " + tmpDir.getPath());

		} else if (!rptDir.isDirectory()) {

			System.err.println("It's not a directory: " + rptDir.getPath());

		} else {
			
			Executor exec = null;
			Reader reader = null;

			try {

				CUnitUtil.configureCUnitOutput(srcDir,
						tmpDir);

				exec = new Executor();
				exec.compile(srcDir);
				exec.link(srcDir, binDir);
				exec.execute(binDir);
				exec.analize(srcDir);
				
				reader = new Reader(srcDir);
				Addon.cleanOutput(rptDir);
				Addon.saveOutput(rptDir, 1, reader.getLineCoverage());
				Addon.saveOutput(rptDir, 2, reader.getBranchCoverage());
				
				Reporter.generateOutputReport(srcDir, rptDir);
				Reporter.generateSourcesReport(srcDir, rptDir);

			} catch (Throwable t) {

				t.printStackTrace();

			} finally {

				if (exec != null)
					exec.finalize();

			}

		}

	}

}

}
