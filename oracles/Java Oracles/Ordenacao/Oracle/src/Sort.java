public class Sort {
	
	public static void sort(int v[]) {
		for (int i = 0; i < v.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < v.length; j++)
				if (v[j] < v[min])
					min = j;
			int x = v[min];
			v[min] = v[i];
			v[i] = x;
		}
	}
	
}
