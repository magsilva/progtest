package progtest.addons.cunit;

import java.io.File;

public class Constants {

	public static final String CUNIT_SHARE_FILE = CUnit.class
			.getProtectionDomain().getCodeSource().getLocation().getPath()
			.replace("%20", " ")
			+ File.separator
			+ "cunit"
			+ File.separator
			+ "share.zip";

	public static final String CUNIT_INCLUDE_FILE = CUnit.class
			.getProtectionDomain().getCodeSource().getLocation().getPath()
			.replace("%20", " ")
			+ File.separator
			+ "cunit"
			+ File.separator
			+ "include.zip";

	public static final String CUNIT_LIB_FILE = CUnit.class
			.getProtectionDomain().getCodeSource().getLocation().getPath()
			.replace("%20", " ")
			+ File.separator
			+ "cunit"
			+ File.separator
			+ "lib.zip";

	public static final String CUNIT_LIB64_FILE = CUnit.class
			.getProtectionDomain().getCodeSource().getLocation().getPath()
			.replace("%20", " ")
			+ File.separator
			+ "cunit"
			+ File.separator
			+ "lib64.zip";

}
