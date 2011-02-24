package progtest.execution;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import progtest.common.Requisite;
import progtest.common.User;

public class Reader {

	public static double readPiTi(Requisite requisite) {

		File pitiDir = new File(Directories.getPitiDirPath(requisite
				.getAssignment()));

		File toolReportsFile = new File(Directories.getToolReportsDirPath(
				pitiDir, requisite.getCriterion().getTool()));

		String outputFile = toolReportsFile.getPath() + File.separator
				+ requisite.getCriterion().getTool().getOutputfile();

		return read(outputFile, requisite.getCriterion().getPropertyKey());

	}

	public static double readPsTs(Requisite requisite, User student) {

		File pstsDir = new File(Directories.getPstsDirPath(
				requisite.getAssignment(), student));

		File toolReportsFile = new File(Directories.getToolReportsDirPath(
				pstsDir, requisite.getCriterion().getTool()));

		String outputFile = toolReportsFile.getPath() + File.separator
				+ requisite.getCriterion().getTool().getOutputfile();

		return read(outputFile, requisite.getCriterion().getPropertyKey());

	}

	public static double readPiTs(Requisite requisite, User student) {

		File pitsDir = new File(Directories.getPitsDirPath(
				requisite.getAssignment(), student));

		File toolReportsFile = new File(Directories.getToolReportsDirPath(
				pitsDir, requisite.getCriterion().getTool()));

		String outputFile = toolReportsFile.getPath() + File.separator
				+ requisite.getCriterion().getTool().getOutputfile();

		return read(outputFile, requisite.getCriterion().getPropertyKey());

	}

	public static double readPsTi(Requisite requisite, User student) {

		File pstiDir = new File(Directories.getPstiDirPath(
				requisite.getAssignment(), student));

		File toolReportsFile = new File(Directories.getToolReportsDirPath(
				pstiDir, requisite.getCriterion().getTool()));

		String outputFile = toolReportsFile.getPath() + File.separator
				+ requisite.getCriterion().getTool().getOutputfile();

		return read(outputFile, requisite.getCriterion().getPropertyKey());

	}

	private static double read(String outputFile, String property) {

		try {

			Properties properties = new Properties();
			properties.load(new FileInputStream(outputFile));
			String value = properties.getProperty(property);
			
			return Double.parseDouble(value);

		} catch (Throwable e) {

			e.printStackTrace();
			return 0;

		}

	}

}
