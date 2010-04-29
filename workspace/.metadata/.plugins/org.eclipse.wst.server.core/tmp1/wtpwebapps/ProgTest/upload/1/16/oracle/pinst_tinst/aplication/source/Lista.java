public class Lista {

	private CelulaL primeiro, ultimo, pos;

	public Lista() {
		this.primeiro = new CelulaL();
		this.pos = this.primeiro;
		this.ultimo = this.primeiro;
		this.primeiro.prox = null;
	}

	public Object pesquisa(Object chave) {
		if (this.vazia() || chave == null)
			return null;
		CelulaL aux = this.primeiro;
		while (aux.prox != null) {
			if (aux.prox.item.equals(chave))
				return aux.prox.item;
			aux = aux.prox;
		}
		return null;
	}

	public void insere(Object x) {
		this.ultimo.prox = new CelulaL();
		this.ultimo = this.ultimo.prox;
		this.ultimo.item = x;
		this.ultimo.prox = null;
	}

	public void inserePrimeiro(Object item) {
		CelulaL aux = this.primeiro.prox;
		this.primeiro.prox = new CelulaL();
		this.primeiro.prox.item = item;
		this.primeiro.prox.prox = aux;
	}

	public Object retira(Object chave) throws Exception {
		if (this.vazia() || (chave == null))
			throw new Exception("Erro: Lista vazia ou chave invalida");
		CelulaL aux = this.primeiro;
		while (aux.prox != null && !aux.prox.item.equals(chave))
			aux = aux.prox;
		if (aux.prox == null)
			return null;
		CelulaL q = aux.prox;
		Object item = q.item;
		aux.prox = q.prox;
		if (aux.prox == null)
			this.ultimo = aux;
		return item;
	}

	public Object retiraPrimeiro() throws Exception {
		if (this.vazia())
			throw new Exception("Erro: Lista vazia");
		CelulaL aux = this.primeiro;
		CelulaL q = aux.prox;
		Object item = q.item;
		aux.prox = q.prox;
		if (aux.prox == null)
			this.ultimo = aux;
		return item;
	}

	public boolean vazia() {
		return (this.primeiro == this.ultimo);
	}

	public void imprime() {
		CelulaL aux = this.primeiro.prox;
		while (aux != null) {
			System.out.println(aux.item.toString());
			aux = aux.prox;
		}
	}

	public boolean estaNaLista(Object chave) {
		Object obj = this.pesquisa(chave);
		return (obj != null);
	}

	public Object primeiro() {
		this.pos = this.primeiro;
		return this.proximo();
	}

	public Object proximo() {
		this.pos = this.pos.prox;
		if (this.pos == null)
			return null;
		else
			return this.pos.item;
	}

}
