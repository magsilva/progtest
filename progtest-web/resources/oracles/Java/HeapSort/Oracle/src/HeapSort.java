public class HeapSort {
	
	public static void sort(int v[], int iterations) {
		int i = 1;
		MaxHeap heap = new MaxHeap(v);
		int dir = v.length-1;
		heap.constroi();
		while (dir > 1) {
			int x = v[1];
			v[1] = v[dir];
			v[dir] = x;
			dir--;
			if(i == iterations)
				return;
			else
				i++;
			heap.refaz(1, dir);
		}
	}

}
