package progtest.util;

import java.util.ResourceBundle;

public class BundleUtil {

	public static String getString(String URL, String key) {
		try {
			return getBundle(URL).getString(key);
		} catch (Throwable t) {
			t.printStackTrace();
			return "";
		}
	}

	private static ResourceBundle getBundle(String URL) {
		return ResourceBundle.getBundle(URL, FacesUtil.getLocale());
	}

}
