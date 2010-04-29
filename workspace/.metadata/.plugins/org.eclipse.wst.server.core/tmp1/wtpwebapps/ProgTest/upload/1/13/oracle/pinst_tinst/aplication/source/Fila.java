

public class Fila {
	
	private Celula frente;
	private Celula tras;

	public Fila() {
		this.frente = new Celula();
		this.tras = this.frente;
		this.frente.prox = null;
	}

	public void add(Object x) {
		this.tras.prox = new Celula();
		this.tras = this.tras.prox;
		this.tras.item = x;
		this.tras.prox = null;
	}

	public Object remove() throws Exception {
		Object item = null;
		if (this.isEmpty())
			throw new Exception("Erro: A fila esta vazia");
		this.frente = this.frente.prox;
		item = this.frente.item;
		return item;
	}

	public boolean isEmpty() {
		return (this.frente == this.tras);
	}

	public String print() {
		String list = "";
		Celula aux = this.frente.prox;
		while (aux != null) {
			list += aux.item.toString();
			if(aux.prox != null)
				list += ",";
			aux = aux.prox;
		}
		return list;
	}
	
}
