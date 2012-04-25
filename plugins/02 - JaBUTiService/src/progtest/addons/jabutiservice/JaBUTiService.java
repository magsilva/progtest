package progtest.addons.jabutiservice;

import java.io.File;

public class JaBUTiService {

	public static void main(String[] args) {

		if (args.length < 9) {

			System.out
					.println("Usage: progtest.tools.JabutiService <end point> <patch jar> <source directory> <binaries directory> <program directory> <tests directory> <instrumented files directory> <temporaries directory> <reports directory>");

		} else {

			String endPoint = args[0];

			File patchPackage = new File(args[1]);

			File srcDir = new File(args[2]);
			File binDir = new File(args[3]);
			File progDir = new File(args[4]);
			File testDir = new File(args[5]);
			File instDir = new File(args[6]);
			File tmpDir = new File(args[7]);
			File rptDir = new File(args[8]);

			if (!srcDir.exists()) {

				System.err.println("Directory not found: " + srcDir.getPath());

			} else if (!binDir.exists()) {

				System.err.println("Directory not found: " + binDir.getPath());

			} else if (!progDir.exists()) {

				System.err.println("Directory not found: " + progDir.getPath());

			} else if (!testDir.exists()) {

				System.err.println("Directory not found: " + testDir.getPath());

			} else if (!instDir.exists()) {

				System.err.println("Directory not found: " + instDir.getPath());

			} else if (!tmpDir.exists()) {

				System.err.println("Directory not found: " + tmpDir.getPath());

			} else if (!rptDir.exists()) {

				System.err.println("Directory not found: " + rptDir.getPath());

			} else if (!srcDir.isDirectory()) {

				System.err.println("It's not a directory: " + srcDir.getPath());

			} else if (!binDir.isDirectory()) {

				System.err.println("It's not a directory: " + binDir.getPath());

			} else if (!progDir.isDirectory()) {

				System.err
						.println("It's not a directory: " + progDir.getPath());

			} else if (!testDir.isDirectory()) {

				System.err
						.println("It's not a directory: " + testDir.getPath());

			} else if (!instDir.isDirectory()) {

				System.err
						.println("It's not a directory: " + instDir.getPath());

			} else if (!tmpDir.isDirectory()) {

				System.err.println("It's not a directory: " + tmpDir.getPath());

			} else if (!rptDir.isDirectory()) {

				System.err.println("It's not a directory: " + rptDir.getPath());

			} else {

				try {

					Executor executor = new Executor(endPoint, patchPackage,
							srcDir, binDir, progDir, testDir, instDir, tmpDir);
					
					System.out.println("");
					System.out.println("Compiling source files ...");
					System.out.println("");
					
					executor.compile();
					
					Result r = executor.execute();
					
					System.out.println("");
					System.out.println("Saving results ...");
					System.out.println("");
					
					for(int i = 1; i <= 8; i++) {
						double total = Reader.getTotal(i, r);
						Addon.saveOutput(i, total, rptDir);
					}
					
					System.out.println("");
					System.out.println("Generating graphs ...");
					System.out.println("");
					
					Grapher gp = new Grapher(tmpDir, rptDir);
					gp.generateGraphs(r);
					
					System.out.println("");
					System.out.println("Generating reports ...");
					System.out.println("");
					
					Reporter.generateReports(r, rptDir);
					
					System.out.println("");
					System.out.println("Finished!!!");
					System.out.println("");

				} catch (Throwable t) {

					t.printStackTrace();

				}

			}

		}
	}

}
