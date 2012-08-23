public class Celula {
	String chave;
	Object item;
	boolean retirado;

	public Celula(String chave, Object item) {
		this.chave = chave;
		this.item = item;
		this.retirado = false;
	}

	public boolean equals(Object obj) {
		Celula cel = (Celula) obj;
		return chave.equals(cel.chave);
	}

	public String toString() {
		return "  " + item.toString();
	}
}
