public class TempoTermino {
	public int numRestantes, t[];
	public boolean restantes[];

	public TempoTermino(int numVertices) {
		t = new int[numVertices];
		restantes = new boolean[numVertices];
		numRestantes = numVertices;
	}

	public int maxTT() {
		int vMax = 0;
		while (!this.restantes[vMax])
			vMax++;
		for (int i = 0; i < this.t.length; i++) {
			if (this.restantes[i]) {
				if (this.t[i] > this.t[vMax])
					vMax = i;
			}
		}
		return vMax;
	}
}
