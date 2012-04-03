public class Identifier {

	public static boolean valid_s(char c) {
		if (((c >= 'A') &&
			(c <= 'Z')) ||
			((c >= 'a') &&
			(c <= 'z')))
			return true;
		else
			return false;
	}

	public static boolean valid_f(char c) {
		if (((c >= 'A') &&
			(c <= 'Z')) ||
			((c >= 'a') &&
			(c <= 'z')) ||
			((c >= '0') &&
			(c <= '9')))
			return true;
		else
			return false;
	}

	public static boolean identifier(String str) {
		if(str.length() >= 1 && str.length() <= 6 && valid_s(str.charAt(0))) {
			for(int i = 1; i < str.length(); i++)
				if(!valid_f(str.charAt(i)))
					return false;
			return true;
		}
		return false;
	}

}
