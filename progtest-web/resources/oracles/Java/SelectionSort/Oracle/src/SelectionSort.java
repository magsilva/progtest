public class SelectionSort {

	public static void sort(int v[], int iterations) {
		for (int i = 0; (i < v.length) && (i < iterations); i++) {
			int min = i;
			for (int j = i; j < v.length; j++)
				if (v[j] < v[min])
					min = j;
			swap(v, i, min);
		}
	}
	
	private static void swap(int v[], int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}

}
