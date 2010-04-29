

public class MaxHeap {
	
	private int v[];
	
	private int n;

	public MaxHeap(int v[]) {
		this.v = v;
		this.n = this.v.length - 1;
	}

	public void refaz(int esq, int dir) {
		int j = esq * 2;
		int x = this.v[esq];
		while (j <= dir) {
			if ((j < dir) && (v[j] < (v[j + 1])))
				j++;
			if (x >= this.v[j])
				break;
			this.v[esq] = this.v[j];
			esq = j;
			j = esq * 2;
		}
		this.v[esq] = x;
	}

	public void constroi() {
		int esq = n / 2 + 1;
		while (esq > 1) {
			esq--;
			this.refaz(esq, this.n);
		}
	}
	
}
