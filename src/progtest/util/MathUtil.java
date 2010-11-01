package progtest.util;

public class MathUtil {

	public static double round(double num, int precisao) {
		num *= java.lang.Math.pow(10, precisao);
		num = java.lang.Math.round(num);
		num /= java.lang.Math.pow(10, precisao);
		return num;
	}

}
