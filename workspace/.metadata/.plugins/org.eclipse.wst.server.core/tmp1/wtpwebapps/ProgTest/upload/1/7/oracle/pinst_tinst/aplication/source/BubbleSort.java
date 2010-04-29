

public class BubbleSort {
	
	public static void sort(int v[], int n) {
		int iteration = 1;
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v.length - 1; j++) {
				if(v[j] > v[j+1])
					swap(v, j, j+1);
			}
			if(iteration == n) break;
			else iteration += 1;
		}
	}
	
	private static void swap(int v[], int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}
	
}
