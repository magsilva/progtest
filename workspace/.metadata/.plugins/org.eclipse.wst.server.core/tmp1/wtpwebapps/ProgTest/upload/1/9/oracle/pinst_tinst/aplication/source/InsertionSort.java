public class InsertionSort {

	public static void sort(int v[], int iterations) {
		for (int i = 1; i < v.length; i++) {
			int j = i - 1;
			while ((v[j + 1] < v[j])) {
				swap(v, j + 1, j);
				j--;
				if(j < 0)
					break;
			}
			if(i == iterations)
				break;
		}
	}
	
	private static void swap(int v[], int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}

}
