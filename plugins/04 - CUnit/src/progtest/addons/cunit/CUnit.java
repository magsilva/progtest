package progtest.addons.cunit;

import java.io.File;

public class CUnit {

	public static void main(String args[]) {

		if (args.length < 4) {

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

				File cunit_output = null;
				Executor exec = null;
				Reader reader = null;

				try {

					cunit_output = CUnitUtil.configureCUnitOutput(srcDir,
							tmpDir);

					exec = new Executor();
					exec.compile(srcDir);
					exec.link(srcDir, binDir);
					exec.execute(binDir);
					
					reader = new Reader(cunit_output);
					Addon.saveOutput(rptDir, reader.getPassRate());
					
					Reporter.generateSummaryReport(rptDir, reader.getSummary());
					Reporter.generateListingReport(rptDir, reader.getRunResults());

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
