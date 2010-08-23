package progtest.util;

public class Math {

	public static double round(double num, int precisao) {
		num *= java.lang.Math.pow(10, precisao);
		num = java.lang.Math.round(num);
		num /= java.lang.Math.pow(10, precisao);
		return num;
	}

	public static double max(double a, double b) {
		return java.lang.Math.max(a, b);
	}

}
