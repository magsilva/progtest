

public class CelulaG {
	int vertice, peso;

	public CelulaG(int v, int p) {
		this.vertice = v;
		this.peso = p;
	}

	public boolean equals(Object obj) {
		CelulaG item = (CelulaG) obj;
		return (this.vertice == item.vertice);
	}
}
