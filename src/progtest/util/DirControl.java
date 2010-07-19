package progtest.util;

import java.io.File;

import progtest.common.Assignment;
import progtest.common.User;

public class DirControl {

	public static String getOraclePackage(int idCode) {
		return Constants.PATH_ORACLES + File.separator + idCode
				+ Constants.EXTENSION_JAR;
	}

	public static String getOraclePath(Assignment assigment) {
		return Constants.PATH_UPLOAD + File.separator
				+ assigment.getCourse().getIdCode() + File.separator
				+ assigment.getIdCode() + File.separator + Constants.DIR_ORACLE;
	}

	public static String getPinstTinstPath(Assignment assigment) {
		return getOraclePath(assigment) + File.separator
				+ Constants.DIR_PINSTTINST;
	}

	public static String getPinstTinstPackagePath(Assignment assigment) {
		return getPinstTinstPath(assigment) + File.separator
				+ Constants.DIR_PACKAGE;
	}

	public static String getPinstTinstTempPath(Assignment assigment) {
		return getPinstTinstPath(assigment) + File.separator
				+ Constants.DIR_TEMP;
	}

	public static String getPinstTinstApplicationPath(Assignment assigment) {
		return getPinstTinstPath(assigment) + File.separator
				+ Constants.DIR_APPLICATION;
	}

	public static String getPinstTinstApplicationSourcePath(Assignment assigment) {
		return getPinstTinstApplicationPath(assigment) + File.separator
				+ Constants.DIR_SOURCE;
	}

	public static String getPinstTinstApplicationBuildPath(Assignment assigment) {
		return getPinstTinstApplicationPath(assigment) + File.separator
				+ Constants.DIR_BUILD;
	}

	public static String getPinstTinstTestPath(Assignment assigment) {
		return getPinstTinstPath(assigment) + File.separator
				+ Constants.DIR_TESTSET;
	}

	public static String getPinstTinstTestSourcePath(Assignment assigment) {
		return getPinstTinstTestPath(assigment) + File.separator
				+ Constants.DIR_SOURCE;
	}

	public static String getPinstTinstTestSourceSuitePath(Assignment assigment) {
		return getPinstTinstTestSourcePath(assigment) + File.separator
				+ Constants.FILE_TESTSUITE + Constants.EXTENSION_JAVA;
	}

	public static String getPinstTinstTestBuildPath(Assignment assigment) {
		return getPinstTinstTestPath(assigment) + File.separator
				+ Constants.DIR_BUILD;
	}

	public static String getPinstTinstTestBuildSuitePath(Assignment assigment) {
		return getPinstTinstTestBuildPath(assigment) + File.separator
				+ Constants.FILE_TESTSUITE + Constants.EXTENSION_CLASS;
	}

	public static String getPinstTinstJUnitPath(Assignment assigment) {
		return getPinstTinstPath(assigment) + File.separator
				+ Constants.DIR_JUNIT;
	}

	public static String getPinstTinstJabutiPath(Assignment assigment) {
		return getPinstTinstPath(assigment) + File.separator
				+ Constants.DIR_JABUTI;
	}

	public static String getPinstTinstJabutiApplicationPath(Assignment assigment) {
		return getPinstTinstJabutiPath(assigment) + File.separator
				+ Constants.FILE_APPLICATION + Constants.EXTENSION_JAR;
	}

	public static String getPinstTinstJabutiTestSetPath(Assignment assigment) {
		return getPinstTinstJabutiPath(assigment) + File.separator
				+ Constants.FILE_TESTSET + Constants.EXTENSION_JAR;
	}

	public static String getPinstTinstReportsPath(Assignment assigment) {
		return getPinstTinstPath(assigment) + File.separator
				+ Constants.DIR_REPORTS;
	}

	public static String getUserPath(Assignment assigment, User user) {
		return Constants.PATH_UPLOAD + File.separator
				+ assigment.getCourse().getIdCode() + File.separator
				+ assigment.getIdCode() + File.separator + user.getUserName();
	}

	public static String getPalTalPath(Assignment assigment, User user) {
		return getUserPath(assigment, user) + File.separator
				+ Constants.DIR_PALTAL;
	}

	public static String getPalTalPackagePath(Assignment assigment, User user) {
		return getPalTalPath(assigment, user) + File.separator
				+ Constants.DIR_PACKAGE;
	}

	public static String getPalTalTempPath(Assignment assigment, User user) {
		return getPalTalPath(assigment, user) + File.separator
				+ Constants.DIR_TEMP;
	}

	public static String getPalTalApplicationPath(Assignment assigment, User user) {
		return getPalTalPath(assigment, user) + File.separator
				+ Constants.DIR_APPLICATION;
	}

	public static String getPalTalApplicationSourcePath(Assignment assigment,
			User user) {
		return getPalTalApplicationPath(assigment, user) + File.separator
				+ Constants.DIR_SOURCE;
	}

	public static String getPalTalApplicationBuildPath(Assignment assigment,
			User user) {
		return getPalTalApplicationPath(assigment, user) + File.separator
				+ Constants.DIR_BUILD;
	}

	public static String getPalTalTestPath(Assignment assigment, User user) {
		return getPalTalPath(assigment, user) + File.separator
				+ Constants.DIR_TESTSET;
	}

	public static String getPalTalTestSourcePath(Assignment assigment, User user) {
		return getPalTalTestPath(assigment, user) + File.separator
				+ Constants.DIR_SOURCE;
	}

	public static String getPalTalTestSourceSuitePath(Assignment assigment, User user) {
		return getPalTalTestSourcePath(assigment, user) + File.separator
				+ Constants.FILE_TESTSUITE + Constants.EXTENSION_JAVA;
	}

	public static String getPalTalTestBuildPath(Assignment assigment, User user) {
		return getPalTalTestPath(assigment, user) + File.separator
				+ Constants.DIR_BUILD;
	}

	public static String getPalTalTestBuildSuitePath(Assignment assigment, User user) {
		return getPalTalTestBuildPath(assigment, user) + File.separator
				+ Constants.FILE_TESTSUITE + Constants.EXTENSION_CLASS;
	}

	public static String getPalTalJUnitPath(Assignment assigment, User user) {
		return getPalTalPath(assigment, user) + File.separator
				+ Constants.DIR_JUNIT;
	}

	public static String getPalTalJabutiPath(Assignment assigment, User user) {
		return getPalTalPath(assigment, user) + File.separator
				+ Constants.DIR_JABUTI;
	}

	public static String getPalTalJabutiApplicationPath(Assignment assigment,
			User user) {
		return getPalTalJabutiPath(assigment, user) + File.separator
				+ Constants.FILE_APPLICATION + Constants.EXTENSION_JAR;
	}

	public static String getPalTalJabutiTestSetPath(Assignment assigment,
			User user) {
		return getPalTalJabutiPath(assigment, user) + File.separator
				+ Constants.FILE_TESTSET + Constants.EXTENSION_JAR;
	}

	public static String getPalTalReportsPath(Assignment assigment, User user) {
		return getPalTalPath(assigment, user) + File.separator
				+ Constants.DIR_REPORTS;
	}

	public static String getPinstTalPath(Assignment assigment, User user) {
		return getUserPath(assigment, user) + File.separator
				+ Constants.DIR_PINSTTAL;
	}

	public static String getPinstTalPackagePath(Assignment assigment, User user) {
		return getPinstTalPath(assigment, user) + File.separator
				+ Constants.DIR_PACKAGE;
	}

	public static String getPinstTalTempPath(Assignment assigment, User user) {
		return getPinstTalPath(assigment, user) + File.separator
				+ Constants.DIR_TEMP;
	}

	public static String getPinstTalPackageApplicationPath(Assignment assigment,
			User user) {
		return getPinstTalPackagePath(assigment, user) + File.separator
				+ Constants.FILE_APPLICATION + Constants.EXTENSION_JAR;
	}

	public static String getPinstTalPackageTestSetPath(Assignment assigment,
			User user) {
		return getPinstTalPackagePath(assigment, user) + File.separator
				+ Constants.FILE_TESTSET + Constants.EXTENSION_JAR;
	}

	public static String getPinstTalApplicationPath(Assignment assigment,
			User user) {
		return getPinstTalPath(assigment, user) + File.separator
				+ Constants.DIR_APPLICATION;
	}

	public static String getPinstTalApplicationSourcePath(Assignment assigment,
			User user) {
		return getPinstTalApplicationPath(assigment, user) + File.separator
				+ Constants.DIR_SOURCE;
	}

	public static String getPinstTalApplicationBuildPath(Assignment assigment,
			User user) {
		return getPinstTalApplicationPath(assigment, user) + File.separator
				+ Constants.DIR_BUILD;
	}

	public static String getPinstTalTestPath(Assignment assigment, User user) {
		return getPinstTalPath(assigment, user) + File.separator
				+ Constants.DIR_TESTSET;
	}

	public static String getPinstTalTestSourcePath(Assignment assigment,
			User user) {
		return getPinstTalTestPath(assigment, user) + File.separator
				+ Constants.DIR_SOURCE;
	}

	public static String getPinstTalTestSourceSuitePath(Assignment assigment, User user) {
		return getPinstTalTestSourcePath(assigment, user) + File.separator
				+ Constants.FILE_TESTSUITE + Constants.EXTENSION_JAVA;
	}

	public static String getPinstTalTestBuildPath(Assignment assigment, User user) {
		return getPinstTalTestPath(assigment, user) + File.separator
				+ Constants.DIR_BUILD;
	}

	public static String getPinstTalTestBuildSuitePath(Assignment assigment, User user) {
		return getPinstTalTestBuildPath(assigment, user) + File.separator
				+ Constants.FILE_TESTSUITE + Constants.EXTENSION_CLASS;
	}

	public static String getPinstTalJUnitPath(Assignment assigment, User user) {
		return getPinstTalPath(assigment, user) + File.separator
				+ Constants.DIR_JUNIT;
	}

	public static String getPinstTalJabutiPath(Assignment assigment, User user) {
		return getPinstTalPath(assigment, user) + File.separator
				+ Constants.DIR_JABUTI;
	}

	public static String getPinstTalJabutiApplicationPath(Assignment assigment,
			User user) {
		return getPinstTalJabutiPath(assigment, user) + File.separator
				+ Constants.FILE_APPLICATION + Constants.EXTENSION_JAR;
	}

	public static String getPinstTalJabutiTestSetPath(Assignment assigment,
			User user) {
		return getPinstTalJabutiPath(assigment, user) + File.separator
				+ Constants.FILE_TESTSET + Constants.EXTENSION_JAR;
	}

	public static String getPinstTalReportsPath(Assignment assigment, User user) {
		return getPinstTalPath(assigment, user) + File.separator
				+ Constants.DIR_REPORTS;
	}

	public static String getPalTinstPath(Assignment assigment, User user) {
		return getUserPath(assigment, user) + File.separator
				+ Constants.DIR_PALTINST;
	}

	public static String getPalTinstPackagePath(Assignment assigment, User user) {
		return getPalTinstPath(assigment, user) + File.separator
				+ Constants.DIR_PACKAGE;
	}

	public static String getPalTinstTempPath(Assignment assigment, User user) {
		return getPalTinstPath(assigment, user) + File.separator
				+ Constants.DIR_TEMP;
	}

	public static String getPalTinstPackageApplicationPath(Assignment assigment,
			User user) {
		return getPalTinstPackagePath(assigment, user) + File.separator
				+ Constants.FILE_APPLICATION + Constants.EXTENSION_JAR;
	}

	public static String getPalTinstPackageTestSetPath(Assignment assigment,
			User user) {
		return getPinstTalPackagePath(assigment, user) + File.separator
				+ Constants.FILE_TESTSET + Constants.EXTENSION_JAR;
	}

	public static String getPalTinstApplicationPath(Assignment assigment,
			User user) {
		return getPalTinstPath(assigment, user) + File.separator
				+ Constants.DIR_APPLICATION;
	}

	public static String getPalTinstApplicationSourcePath(Assignment assigment,
			User user) {
		return getPalTinstApplicationPath(assigment, user) + File.separator
				+ Constants.DIR_SOURCE;
	}

	public static String getPalTinstApplicationBuildPath(Assignment assigment,
			User user) {
		return getPalTinstApplicationPath(assigment, user) + File.separator
				+ Constants.DIR_BUILD;
	}

	public static String getPalTinstTestPath(Assignment assigment, User user) {
		return getPalTinstPath(assigment, user) + File.separator
				+ Constants.DIR_TESTSET;
	}

	public static String getPalTinstTestSourcePath(Assignment assigment,
			User user) {
		return getPalTinstTestPath(assigment, user) + File.separator
				+ Constants.DIR_SOURCE;
	}

	public static String getPalTinstTestSourceSuitePath(Assignment assigment, User user) {
		return getPalTinstTestSourcePath(assigment, user) + File.separator
				+ Constants.FILE_TESTSUITE + Constants.EXTENSION_JAVA;
	}

	public static String getPalTinstTestBuildPath(Assignment assigment, User user) {
		return getPalTinstTestPath(assigment, user) + File.separator
				+ Constants.DIR_BUILD;
	}

	public static String getPalTinstTestBuildSuitePath(Assignment assigment, User user) {
		return getPalTinstTestBuildPath(assigment, user) + File.separator
				+ Constants.FILE_TESTSUITE + Constants.EXTENSION_CLASS;
	}

	public static String getPalTinstJUnitPath(Assignment assigment, User user) {
		return getPalTinstPath(assigment, user) + File.separator
				+ Constants.DIR_JUNIT;
	}

	public static String getPalTinstJabutiPath(Assignment assigment, User user) {
		return getPalTinstPath(assigment, user) + File.separator
				+ Constants.DIR_JABUTI;
	}

	public static String getPalTinstJabutiApplicationPath(Assignment assigment,
			User user) {
		return getPalTinstJabutiPath(assigment, user) + File.separator
				+ Constants.FILE_APPLICATION + Constants.EXTENSION_JAR;
	}

	public static String getPalTinstJabutiTestSetPath(Assignment assigment,
			User user) {
		return getPalTinstJabutiPath(assigment, user) + File.separator
				+ Constants.FILE_TESTSET + Constants.EXTENSION_JAR;
	}

	public static String getPalTinstReportsPath(Assignment assigment, User user) {
		return getPalTinstPath(assigment, user) + File.separator
				+ Constants.DIR_REPORTS;
	}

	public static String getUserReportsPath(Assignment assigment, User user) {
		return getUserPath(assigment, user) + File.separator
				+ Constants.DIR_REPORTS;
	}

	/*
	 * public static String getOraclePackagePath(Assigment assigment) { return
	 * getOraclePath(assigment) + File.separator + Constants.DIR_PACKAGE; }
	 * 
	 * public static String getOracleApplicationPath(Assigment assigment) {
	 * return getOraclePath(assigment) + File.separator +
	 * Constants.DIR_APPLICATION; }
	 * 
	 * public static String getOracleApplicationSourcePath(Assigment assigment)
	 * { return getOracleApplicationPath(assigment) + File.separator +
	 * Constants.DIR_SOURCE; }
	 * 
	 * public static String getOracleApplicationBuildPath(Assigment assigment) {
	 * return getOracleApplicationPath(assigment) + File.separator +
	 * Constants.DIR_BUILD; }
	 * 
	 * public static String getOracleTestSetPath(Assigment assigment) { return
	 * getOraclePath(assigment) + File.separator + Constants.DIR_TESTSET; }
	 * 
	 * public static String getOracleTestSetSourcePath(Assigment assigment) {
	 * return getOracleTestSetPath(assigment) + File.separator +
	 * Constants.DIR_SOURCE; }
	 * 
	 * public static String getOracleTestSetBuildPath(Assigment assigment) {
	 * return getOracleTestSetPath(assigment) + File.separator +
	 * Constants.DIR_BUILD; }
	 * 
	 * public static String getUserPackagePath(Assigment assigment, User user) {
	 * return getUserPath(assigment, user) + File.separator +
	 * Constants.DIR_PACKAGE; }
	 * 
	 * public static String getUserApplicationPath(Assigment assigment, User
	 * user) { return getUserPath(assigment, user) + File.separator +
	 * Constants.DIR_APPLICATION; }
	 * 
	 * public static String getUserApplicationSourcePath(Assigment assigment,
	 * User user) { return getUserApplicationPath(assigment, user) +
	 * File.separator + Constants.DIR_SOURCE; }
	 * 
	 * public static String getUserApplicationBuildPath(Assigment assigment,
	 * User user) { return getUserApplicationPath(assigment, user) +
	 * File.separator + Constants.DIR_BUILD; }
	 * 
	 * public static String getUserTestSetPath(Assigment assigment, User user) {
	 * return getUserPath(assigment, user) + File.separator +
	 * Constants.DIR_TESTSET; }
	 * 
	 * public static String getUserTestSetSourcePath(Assigment assigment, User
	 * user) { return getUserTestSetPath(assigment, user) + File.separator +
	 * Constants.DIR_SOURCE; }
	 * 
	 * public static String getUserTestSetBuildPath(Assigment assigment, User
	 * user) { return getUserTestSetPath(assigment, user) + File.separator +
	 * Constants.DIR_BUILD; }
	 * 
	 * public static String getUserReportsPath(Assigment assigment, User user) {
	 * return getUserPath(assigment, user) + File.separator +
	 * Constants.DIR_REPORTS; }
	 * 
	 * public static String getPinstTinstPath(Assigment assigment) { return
	 * getOraclePath(assigment) + File.separator + Constants.DIR_PINSTTINST; }
	 * 
	 * public static String getPinstTinstPackagePath(Assigment assigment) {
	 * return getPinstTinstPath(assigment) + File.separator +
	 * Constants.DIR_PACKAGE; }
	 * 
	 * public static String getPinstTinstApplicationPath(Assigment assigment) {
	 * return getPinstTinstPackagePath(assigment) + File.separator +
	 * Constants.FILE_APPLICATION; }
	 * 
	 * public static String getPinstTinstTestSetPath(Assigment assigment) {
	 * return getPinstTinstPackagePath(assigment) + File.separator +
	 * Constants.FILE_TESTSET; }
	 * 
	 * public static String getPinstTinstReportsPath(Assigment assigment) {
	 * return getPinstTinstPath(assigment) + File.separator +
	 * Constants.DIR_REPORTS; }
	 * 
	 * public static String getPalTalPath(Assigment assigment, User user) {
	 * return getUserPath(assigment, user) + File.separator +
	 * Constants.DIR_PALTAL; }
	 * 
	 * public static String getPalTalPackagePath(Assigment assigment, User user)
	 * { return getPalTalPath(assigment, user) + File.separator +
	 * Constants.DIR_PACKAGE; }
	 * 
	 * public static String getPalTalApplicationPath(Assigment assigment, User
	 * user) { return getPalTalPackagePath(assigment, user) + File.separator +
	 * Constants.FILE_APPLICATION; }
	 * 
	 * public static String getPalTalTestSetPath(Assigment assigment, User user)
	 * { return getPalTalPackagePath(assigment, user) + File.separator +
	 * Constants.FILE_TESTSET; }
	 * 
	 * public static String getPalTalReportsPath(Assigment assigment, User user)
	 * { return getPalTalPath(assigment, user) + File.separator +
	 * Constants.DIR_REPORTS; }
	 * 
	 * public static String getPinstTalPath(Assigment assigment, User user) {
	 * return getUserPath(assigment, user) + File.separator +
	 * Constants.DIR_PINSTTAL; }
	 * 
	 * public static String getPinstTalApplicationPath(Assigment assigment, User
	 * user) { return getPinstTalPackagePath(assigment, user) + File.separator +
	 * Constants.FILE_APPLICATION; }
	 * 
	 * public static String getPinstTalTestSetPath(Assigment assigment, User
	 * user) { return getPinstTalPackagePath(assigment, user) + File.separator +
	 * Constants.FILE_TESTSET; }
	 * 
	 * public static String getPinstTalReportsPath(Assigment assigment, User
	 * user) { return getPinstTalPath(assigment, user) + File.separator +
	 * Constants.DIR_REPORTS; }
	 * 
	 * public static String getPalTinstPath(Assigment assigment, User user) {
	 * return getUserPath(assigment, user) + File.separator +
	 * Constants.DIR_PALTINST; }
	 * 
	 * public static String getPalTinstApplicationPath(Assigment assigment, User
	 * user) { return getPalTinstPackagePath(assigment, user) + File.separator +
	 * Constants.FILE_APPLICATION; }
	 * 
	 * public static String getPalTinstTestSetPath(Assigment assigment, User
	 * user) { return getPalTinstPackagePath(assigment, user) + File.separator +
	 * Constants.FILE_TESTSET; }
	 * 
	 * public static String getPalTinstReportsPath(Assigment assigment, User
	 * user) { return getPalTinstPath(assigment, user) + File.separator +
	 * Constants.DIR_REPORTS; }
	 * 
	 * public static String getOraclePackage(int idCode) { return
	 * Constants.PATH_ORACLES + File.separator + idCode +
	 * Constants.EXTENSION_JAR; }
	 * 
	 * public static String getPinstTalPackagePath(Assigment assigment, User
	 * user) { return getPinstTalPath(assigment, user) + File.separator +
	 * Constants.DIR_PACKAGE; }
	 * 
	 * public static String getPalTinstPackagePath(Assigment assigment, User
	 * user) { return getPalTinstPath(assigment, user) + File.separator +
	 * Constants.DIR_PACKAGE; }
	 * 
	 * public static String getPinstTalApplicationBuildPath(Assigment assigment,
	 * User user) { return getPinstTalPath(assigment, user) + File.separator +
	 * Constants.DIR_APPLICATION + File.separator + Constants.DIR_BUILD; }
	 * 
	 * public static String getPinstTalApplicationSourcePath(Assigment
	 * assigment, User user) { return getPinstTalPath(assigment, user) +
	 * File.separator + Constants.DIR_APPLICATION + File.separator +
	 * Constants.DIR_SOURCE; }
	 * 
	 * public static String getPinstTalTestSetSourcePath(Assigment assigment,
	 * User user) { return getPinstTalPath(assigment, user) + File.separator +
	 * Constants.DIR_TESTSET + File.separator + Constants.DIR_SOURCE; }
	 * 
	 * public static String getPinstTalTestSetBuildPath(Assigment assigment,
	 * User user) { return getPinstTalPath(assigment, user) + File.separator +
	 * Constants.DIR_TESTSET + File.separator + Constants.DIR_BUILD; }
	 * 
	 * public static String getPalTinstTestSetBuildPath(Assigment assigment,
	 * User user) { return getPalTinstPath(assigment, user) + File.separator +
	 * Constants.DIR_TESTSET + File.separator + Constants.DIR_BUILD; }
	 * 
	 * public static String getPalTinstTestSetSourcePath(Assigment assigment,
	 * User user) { return getPalTinstPath(assigment, user) + File.separator +
	 * Constants.DIR_TESTSET + File.separator + Constants.DIR_SOURCE; }
	 * 
	 * public static String getPalTinstApplicationBuildPath(Assigment assigment,
	 * User user) { return getPalTinstPath(assigment, user) + File.separator +
	 * Constants.DIR_APPLICATION + File.separator + Constants.DIR_BUILD; }
	 * 
	 * public static String getPalTinstApplicationSourcePath(Assigment
	 * assigment, User user) { return getPalTinstPath(assigment, user) +
	 * File.separator + Constants.DIR_APPLICATION + File.separator +
	 * Constants.DIR_SOURCE; }
	 */

}
