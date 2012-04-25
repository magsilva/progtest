package progtest.addons.jumble;

import java.io.File;

public class Jumble {public static void main(String args[]) {

	if (args.length < 6) {

		System.out
				.println("Usage: progtest.addons.jumble.Jumble <jumble file> <source directory> <binaries directory> <program directory> <tests directory> <reports directory>");

	} else {

		File jumbleFile = new File(args[0]);

		File srcDir = new File(args[1]);
		File binDir = new File(args[2]);
		File progDir = new File(args[3]);
		File testDir = new File(args[4]);
		File rptDir = new File(args[5]);
		
		String additionals = "";
		
		if (args.length > 5) {
			for(int i = 6; i < args.length; i++)
				additionals += " " + args[i];
		}

		if (!srcDir.exists()) {

			System.err.println("Directory not found: " + srcDir.getPath());

		} else if (!binDir.exists()) {

			System.err.println("Directory not found: " + binDir.getPath());

		} else if (!progDir.exists()) {

			System.err.println("Directory not found: " + progDir.getPath());

		} else if (!testDir.exists()) {

			System.err.println("Directory not found: " + testDir.getPath());

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

		} else if (!rptDir.isDirectory()) {

			System.err.println("It's not a directory: " + rptDir.getPath());

		} else {

			try {
				
				System.out.println("");
				System.out.println("Compiling sources ...");
				System.out.println("");
				
				Executor executor = new Executor(jumbleFile, srcDir, binDir, progDir, testDir);
				executor.compile();
				
				System.out.println("");
				System.out.println("Executing Jumble ...");
				System.out.println("");
				
				Result r = executor.execute(additionals);
				
				System.out.println("");
				System.out.println("Calculating coverage ...");
				System.out.println("");
				
				double total = Reader.getTotal(r);
				
				System.out.println("");
				System.out.println("Saving results ...");
				System.out.println("");
				
				Addon.saveOutput(total, rptDir);
				
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
