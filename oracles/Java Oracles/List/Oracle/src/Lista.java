

public class Lista {

	private Celula primeiro, ultimo;

	public Lista() {
		this.primeiro = new Celula();
		this.ultimo = this.primeiro;
		this.primeiro.prox = null;
	}

	public void add(Object x) {
		this.ultimo.prox = new Celula();
		this.ultimo = this.ultimo.prox;
		this.ultimo.item = x;
		this.ultimo.prox = null;
	}

	public Object remove(Object chave) {
		if (this.isEmpty() || (chave == null))
			throw new RuntimeException("Erro: Lista vazia ou chave invalida");
		Celula aux = this.primeiro;
		while (aux.prox != null && !aux.prox.item.equals(chave))
			aux = aux.prox;
		if (aux.prox == null)
			return null;
		Celula q = aux.prox;
		Object item = q.item;
		aux.prox = q.prox;
		if (aux.prox == null)
			this.ultimo = aux;
		return item;
	}

	public boolean isEmpty() {
		return (this.primeiro == this.ultimo);
	}

	public String print() {
		String list = "";
		Celula aux = this.primeiro.prox;
		while (aux != null) {
			list += aux.item.toString();
			if(aux.prox != null)
				list += ",";
			aux = aux.prox;
		}
		return list;
	}

}
