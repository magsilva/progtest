package progtest.execution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import progtest.common.Requisite;
import progtest.common.User;

public class Reader {

	public static double readPiTi(
			Requisite requisite) {

		File pitiDir = new File(Directories.getPitiDirPath(requisite
				.getAssignment()));

		File outputFile = new File(Directories.getToolOutputFilePath(pitiDir,
				requisite.getCriterion().getTool()));

		return read(outputFile, requisite.getCriterion().getIdCode());

	}

	public static double readPsTs(
			Requisite requisite, User student) {

		File pstsDir = new File(Directories.getPstsDirPath(
				requisite.getAssignment(), student));

		File outputFile = new File(Directories.getToolOutputFilePath(pstsDir,
				requisite.getCriterion().getTool()));

		return read(outputFile, requisite.getCriterion().getIdCode());

	}

	public static double readPiTs(
			Requisite requisite, User student) {

		File pitsDir = new File(Directories.getPitsDirPath(
				requisite.getAssignment(), student));

		File outputFile = new File(Directories.getToolOutputFilePath(pitsDir,
				requisite.getCriterion().getTool()));

		return read(outputFile, requisite.getCriterion().getIdCode());

	}

	public static double readPsTi(
			Requisite requisite, User student) {

		File pstiDir = new File(Directories.getPstiDirPath(
				requisite.getAssignment(), student));

		File outputFile = new File(Directories.getToolOutputFilePath(pstiDir,
				requisite.getCriterion().getTool()));

		return read(outputFile, requisite.getCriterion().getIdCode());

	}

	private static double read(File outputFile, int criterionId) {

		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(outputFile);
			br = new BufferedReader(fr);

			for(int i = 1; i < criterionId; i++) {
				if(br.ready())
					br.readLine();
				else
					return 0;
			}
			
			return Double.parseDouble(br.readLine());

		} catch (Throwable e) {

			System.out.println("Warning: Result could not be read: "
					+ e.getMessage());

			return 0;

		} finally {

			try {

				if (br != null)
					br.close();
				if (fr != null)
					fr.close();

			} catch (IOException e) {

				System.out
						.println("Warning: An error occurred while reading file: "
								+ outputFile + ": " + e.getMessage());

			}

		}

	}

}
