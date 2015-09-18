package progtest.addons.proteum;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Proteum {

	public static void main(String args[]) {
		
		if (args.length < 4) {

			System.out
					.println("Usage: progtest.addons.proteum.Proteum <source directory> <binaries directory> <temporary directory> <reports directory>");

		} else {

			File srcDir = new File(args[0]);
			File binDir = new File(args[1]);
			File tmpDir = new File(args[2]);
			File rptDir = new File(args[3]);
			
			String additionals = "";
			
			if (args.length > 3) {
				for(int i = 4; i < args.length; i++)
					additionals += args[i] + " ";
			}

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
				List<Result> results = new ArrayList<Result>();

				try {

					CUnitUtil.configureCUnitOutput(srcDir, tmpDir);

					exec = new Executor(tmpDir);
					exec.compile(srcDir);
					exec.link(srcDir);
					results = exec.execute(srcDir, additionals);

					double total = Reader.getTotal(results);
					Addon.cleanOutput(rptDir);
					Addon.saveOutput(rptDir, 1, total);

					Reporter.generateReports(results, rptDir);

				} catch (Throwable t) {

					t.printStackTrace();

				}

			}

		}

	}

}
