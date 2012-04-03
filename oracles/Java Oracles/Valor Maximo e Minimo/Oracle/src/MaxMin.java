public class MaxMin {
	
	public static int[] maxMin(int v[]) {
		int max = v[0], min = v[0];
		for (int i = 1; i < v.length; i++) {
			if (v[i] > max)
				max = v[i];
			else if (v[i] < min)
				min = v[i];
		}
		int maxMin[] = new int[2];
		maxMin[0] = max;
		maxMin[1] = min;
		return maxMin;
	}

}
