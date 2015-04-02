public class BTree {

	private No raiz;

	public BTree() {
		this.raiz = null;
	}

	public void add(int reg) {
		this.raiz = this.add(reg, this.raiz);
	}

	public void remove(int reg) {
		this.raiz = this.remove(reg, this.raiz);
	}

	public String print() {
		return print(raiz);
	}

	private No add(int reg, No p) {
		if (p == null) {
			p = new No();
			p.reg = reg;
			p.esq = null;
			p.dir = null;
		} else if (reg < p.reg)
			p.esq = add(reg, p.esq);
		else if (reg > p.reg)
			p.dir = add(reg, p.dir);
		else
			throw new RuntimeException();
		return p;
	}

	private No remove(int reg, No p) {//
		if (p == null)
			throw new RuntimeException();
		else if (reg < p.reg)
			p.esq = remove(reg, p.esq);
		else if (reg > p.reg)
			p.dir = remove(reg, p.dir);
		else {
			if (p.dir == null)
				p = p.esq;
			else if (p.esq == null)
				p = p.dir;
			else
				p.esq = antecessor(p, p.esq);
		}
		return p;
	}

	private No antecessor(No q, No r) {
		if (r.dir != null)
			r.dir = antecessor(q, r.dir);
		else {
			q.reg = r.reg;
			r = r.esq;
		}
		return r;
	}

	private String print(No raiz) {
		if (raiz == null)
			return "";
		else if ((raiz.esq == null) && (raiz.dir == null))
			return String.valueOf(raiz.reg);
		else if ((raiz.esq != null) && (raiz.dir == null))
			return print(raiz.esq) + "," + raiz.reg + print(raiz.dir);
		else if ((raiz.esq == null) && (raiz.dir != null))
			return print(raiz.esq) + raiz.reg + "," + print(raiz.dir);
		else
			return print(raiz.esq) + "," + raiz.reg + "," + print(raiz.dir);
	}

}
