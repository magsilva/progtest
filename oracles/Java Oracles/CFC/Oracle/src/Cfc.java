
public class Cfc {

	private Grafo grafo;

	public Cfc(Grafo grafo) {
		this.grafo = grafo;
	}

	private void visitaDfs(Grafo grafo, int u, TempoTermino tt) {
		tt.restantes[u] = false;
		tt.numRestantes--;
		System.out.println("  Vertice: " + u);
		if (!grafo.listaAdjVazia(u)) {
			Aresta a = grafo.primeiroListaAdj(u);
			while (a != null) {
				int v = a.v2();
				if (tt.restantes[v]) {
					this.visitaDfs(grafo, v, tt);
				}
				a = grafo.proxAdj(u);
			}
		}
	}

	public void obterCfc() {
		BuscaEmProfundidade dfs = new BuscaEmProfundidade(this.grafo);
		dfs.buscaEmProfundidade();
		TempoTermino tt = new TempoTermino(this.grafo.numVertices());
		for (int u = 0; u < this.grafo.numVertices(); u++) {
			tt.t[u] = dfs.t(u);
			tt.restantes[u] = true;
		}
		System.out.println();
		Grafo grafoT = this.grafo.grafoTransposto();
		while (tt.numRestantes > 0) {
			int vRaiz = tt.maxTT();
			System.out.println("Raiz da proxima arvore: " + vRaiz);
			this.visitaDfs(grafoT, vRaiz, tt);
		}
	}
}
