public class Grafo {

	private Lista adj[];
	private int numVertices;

	public Grafo(int numVertices) {
		this.adj = new Lista[numVertices];
		this.numVertices = numVertices;
		for (int i = 0; i < this.numVertices; i++)
			this.adj[i] = new Lista();
	} // @\lstcontinue@

	public void insereAresta(int v1, int v2, int peso) {
		CelulaG item = new CelulaG(v2, peso);
		this.adj[v1].insere(item);
	}

	public boolean existeAresta(int v1, int v2) {
		CelulaG item = new CelulaG(v2, 0);
		return (this.adj[v1].pesquisa(item) != null);
	}

	public boolean listaAdjVazia(int v) {
		return this.adj[v].vazia();
	}

	public Aresta primeiroListaAdj(int v) {
		// @{\it Retorna a primeira aresta que o v\'ertice v participa ou}@
		// @{\it {\bf NULL} se a lista de adjac\^encia de v for vazia}@
		CelulaG item = (CelulaG) this.adj[v].primeiro();
		return item != null ? new Aresta(v, item.vertice, item.peso) : null;
	}

	public Aresta proxAdj(int v) {
		// @{\it Retorna a pr\'oxima aresta que o v\'ertice v participa ou}@
		// @{\it {\bf null} se a lista de adjac\^encia de v estiver no fim}@
		CelulaG item = (CelulaG) this.adj[v].proximo();
		return item != null ? new Aresta(v, item.vertice, item.peso) : null;
	}

	public Aresta retiraAresta(int v1, int v2) throws Exception {
		CelulaG chave = new CelulaG(v2, 0);
		CelulaG item = (CelulaG) this.adj[v1].retira(chave);
		return item != null ? new Aresta(v1, v2, item.peso) : null;
	}

	public void imprime() {
		for (int i = 0; i < this.numVertices; i++) {
			System.out.println("Vertice " + i + ":");
			CelulaG item = (CelulaG) this.adj[i].primeiro();
			while (item != null) {
				System.out
						.println("  " + item.vertice + " (" + item.peso + ")");
				item = (CelulaG) this.adj[i].proximo();
			}
		}
	}

	public int numVertices() {
		return this.numVertices;
	}

	public Grafo grafoTransposto() {
		Grafo grafoT = new Grafo(this.numVertices);
		for (int v = 0; v < this.numVertices; v++)
			if (!this.listaAdjVazia(v)) {
				Aresta adj = this.primeiroListaAdj(v);
				while (adj != null) {
					grafoT.insereAresta(adj.v2(), adj.v1(), adj.peso());
					adj = this.proxAdj(v);
				}
			}
		return grafoT;
	}
}
