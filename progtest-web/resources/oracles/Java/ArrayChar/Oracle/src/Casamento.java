public class Casamento {

	public static String match(String T, int n, String P, int m) {
		for (int i = 0; i < (n - m + 1); i++) {
			int k = i;
			int j = 0;
			while ((j < m) && (T.charAt(k) == P.charAt(j))) {
				j++;
				k++;
			}
			if (j == m)
				return String.valueOf(i);
		}
		return String.valueOf("-1");
	}

}
