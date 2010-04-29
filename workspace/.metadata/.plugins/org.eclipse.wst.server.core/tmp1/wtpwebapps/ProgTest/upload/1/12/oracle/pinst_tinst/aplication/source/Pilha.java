

public class Pilha {

	private Celula topo;
	
	private int tam;

	public Pilha() {
		this.topo = null;
		this.tam = 0;
	}

	public void push(Object x) {
		Celula aux = this.topo;
		this.topo = new Celula();
		this.topo.item = x;
		this.topo.prox = aux;
		this.tam++;
	}

	public Object pop() {
		if (this.isEmpty())
			return null;
		Object item = this.topo.item;
		this.topo = this.topo.prox;
		this.tam--;
		return item;
	}

	public boolean isEmpty() {
		return (this.topo == null);
	}
	
	public String print() {
		String list = "";
		Celula aux = this.topo;
		while (aux != null) {
			list += aux.item.toString();
			if(aux.prox != null)
				list += ",";
			aux = aux.prox;
		}
		return list;
	}
	
}