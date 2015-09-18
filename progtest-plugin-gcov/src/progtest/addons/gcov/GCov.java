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
				
				System.out.println("");
				System.out.println("Configuring CUnit...");
				System.out.println("");

				CUnitUtil.configureCUnitOutput(srcDir,
						tmpDir);
				
				System.out.println("");
				System.out.println("Compiling sources...");
				System.out.println("");

				exec = new Executor();
				exec.compile(srcDir);
				
				System.out.println("");
				System.out.println("Linking objects...");
				System.out.println("");
				
				exec.link(srcDir, binDir);
				
				System.out.println("");
				System.out.println("Executing GCov...");
				System.out.println("");
				
				exec.execute(srcDir, binDir);
				
				System.out.println("");
				System.out.println("Reading results...");
				System.out.println("");
				
				reader = new Reader(srcDir);
				Result result = reader.getResult();
				
				System.out.println("");
				System.out.println("Calculating coverage...");
				System.out.println("");
				
				double linesCoverage = Evaluator.linesCoverage(result);
				double branchesCoverage = Evaluator.branchesCoverage(result);
				
				System.out.println("");
				System.out.println("Saving results...");
				System.out.println("");
				
				Addon.cleanOutput(rptDir);
				Addon.saveOutput(rptDir, 1, linesCoverage);
				Addon.saveOutput(rptDir, 2, branchesCoverage);
				
				System.out.println("");
				System.out.println("Generating reports...");
				System.out.println("");
				
				Reporter.generateReports(rptDir, result);
				
				System.out.println("");
				System.out.println("Finished!!!");
				System.out.println("");

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
