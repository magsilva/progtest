package progtest.addons.junit;

import java.io.File;
import java.util.List;

import org.junit.runner.Result;

public class JUnit {

	public static void main(String args[]) {

		if (args.length < 3) {

			System.out
					.println("Usage: progtest.tools.JUnit <source directory> <classes directory> <reports directory>");

		} else {

			File src = new File(args[0]);

			File bin = new File(args[1]);

			File rpt = new File(args[2]);

			if (!src.exists()) {

				System.err.println("Directory not found: " + src.getPath());

			} else if (!bin.exists()) {

				System.err.println("Directory not found: " + bin.getPath());

			} else if (!rpt.exists()) {

				System.err.println("Directory not found: " + rpt.getPath());

			} else if (!src.isDirectory()) {

				System.err.println("It's not a directory: " + src.getPath());

			} else if (!bin.isDirectory()) {

				System.err.println("It's not a directory: " + bin.getPath());

			} else if (!rpt.isDirectory()) {

				System.err.println("It's not a directory: " + rpt.getPath());

			} else {

				try {

					System.out.println("");
					System.out.println("Compiling source files ...");
					System.out.println("");

					Executor.compile(src, bin);

					System.out.println("");
					System.out.println("Executing JUnit ...");
					System.out.println("");
					
					List<Result> results = Executor.execute(bin);

					System.out.println("");
					System.out.println("Calculating coverage ...");
					System.out.println("");

					double total = Reader.getTotal(results);

					System.out.println("");
					System.out.println("Saving results ...");
					System.out.println("");
					
					Addon.saveOutput(total, rpt);

					System.out.println("");
					System.out.println("Generating reports ...");
					System.out.println("");

					Reporter.generateJUnitReport(results, rpt);

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
