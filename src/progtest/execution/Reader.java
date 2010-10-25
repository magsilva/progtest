package progtest.execution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import progtest.common.AssignmentCriterion;
import progtest.common.User;

public class Reader {

	public static double readPiTi(
			AssignmentCriterion assignmentCriterion) {

		File pitiDir = new File(Directories.getPitiDirPath(assignmentCriterion
				.getAssignment()));

		File outputFile = new File(Directories.getToolOutputFilePath(pitiDir,
				assignmentCriterion.getCriterion().getTool()));

		return read(outputFile, assignmentCriterion.getCriterion().getIdCode());

	}

	public static double readPsTs(
			AssignmentCriterion assignmentCriterion, User student) {

		File pstsDir = new File(Directories.getPstsDirPath(
				assignmentCriterion.getAssignment(), student));

		File outputFile = new File(Directories.getToolOutputFilePath(pstsDir,
				assignmentCriterion.getCriterion().getTool()));

		return read(outputFile, assignmentCriterion.getCriterion().getIdCode());

	}

	public static double readPiTs(
			AssignmentCriterion assignmentCriterion, User student) {

		File pitsDir = new File(Directories.getPitsDirPath(
				assignmentCriterion.getAssignment(), student));

		File outputFile = new File(Directories.getToolOutputFilePath(pitsDir,
				assignmentCriterion.getCriterion().getTool()));

		return read(outputFile, assignmentCriterion.getCriterion().getIdCode());

	}

	public static double readPsTi(
			AssignmentCriterion assignmentCriterion, User student) {

		File pstiDir = new File(Directories.getPstiDirPath(
				assignmentCriterion.getAssignment(), student));

		File outputFile = new File(Directories.getToolOutputFilePath(pstiDir,
				assignmentCriterion.getCriterion().getTool()));

		return read(outputFile, assignmentCriterion.getCriterion().getIdCode());

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
