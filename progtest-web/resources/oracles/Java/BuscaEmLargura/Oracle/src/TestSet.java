import static org.junit.Assert.*;

import org.junit.Test;

public class TestSet {

	Grafo grafo = new Grafo();

	@Test
	public void test1_1() {
		grafo = new Grafo();
		assertEquals(grafo != null, true);
	}

	@Test
	public void test2_1() {
		Aresta a;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());

		assertEquals(grafo.existeAresta(3, 5), true);
	}

	@Test
	public void test2_2() {
		Aresta a;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());

		a = new Aresta(3, 5, 9);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());

		assertEquals(grafo.existeAresta(3, 5), true);
	}

	@Test
	public void test3_1() {
		Aresta a;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());

		assertEquals(grafo.existeAresta(3, 5), true);
	}

	@Test
	public void test3_2() {
		Aresta a;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		assertEquals(grafo.existeAresta(3, 6), false);
	}

	@Test
	public void test4_1() {
		Aresta a;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());

		assertEquals(grafo.listaAdjVazia(4), true);
	}

	@Test
	public void test4_2() {
		Aresta a;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());

		assertEquals(grafo.listaAdjVazia(3), false);
	}

	@Test
	public void test5_1() {
		Aresta a, b;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 2, 1);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 7, 3);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());

		a = new Aresta(3, 5, 7);

		b = grafo.primeiroListaAdj(3);

		assertEquals(a.v1() == b.v1() && a.v2() == b.v2()
				&& a.peso() == b.peso(), true);
	}

	@Test
	public void test5_2() {
		Aresta b;

		b = grafo.primeiroListaAdj(3);

		assertEquals(b, null);
	}

	@Test
	public void test6_1e3() {
		Aresta a, b;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 2, 1);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 7, 3);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());

		a = new Aresta(3, 5, 7);

		b = grafo.proxAdj(3);

		assertEquals(a.v1() == b.v1() && a.v2() == b.v2()
				&& a.peso() == b.peso(), true);
	}

	@Test
	public void test6_2() {
		Aresta b;

		b = grafo.proxAdj(3);

		assertEquals(b, null);
	}

	@Test
	public void test6_4() {
		Aresta a, b;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 2, 1);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 7, 3);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());

		grafo.proxAdj(3);
		grafo.proxAdj(3);
		grafo.proxAdj(3);

		a = new Aresta(3, 5, 7);

		b = grafo.proxAdj(3);

		assertEquals(b, null);
	}

	@Test
	public void test7_1() {
		Aresta a, b;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 2, 1);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 7, 3);
		grafo.insereAresta(a.v1(), a.v2(), a.peso()); 

		a = new Aresta(3, 2, 1);

		try {
			b = grafo.retiraAresta(3, 2);
		} catch (Exception e) {
			b = null;
		}

		assertEquals(a.v1() == b.v1() && a.v2() == b.v2()
				&& a.peso() == b.peso(), true);

	}

	@Test
	public void test7_2() {
		Aresta a, b;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 2, 1);
		grafo.insereAresta(a.v1(), a.v2(), a.peso()); 
		a = new Aresta(3, 7, 3);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());

		a = new Aresta(3, 2, 1);

		try {
			b = grafo.retiraAresta(3, 3);
		} catch (Exception e) {
			b = null;
		}
		assertEquals(b, null);
	}

	@Test
	public void test8_1() {
		Aresta a;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 2, 1);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 7, 3);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());

		grafo.imprime();
	}

	@Test
	public void test8_2() {
		grafo.imprime();
	}

	@Test
	public void test10_1() {
		Aresta a;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 2, 1);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 7, 3);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());

		Grafo grafoT = grafo.grafoTransposto();

		grafoT.imprime();

	}

	@Test
	public void test10_2() {
		Grafo grafoT = grafo.grafoTransposto();

		grafoT.imprime();

	}


	@Test
	public void test_FC1() {
		Grafo grafoT = grafo.grafoTransposto();
		grafoT.imprime();
		grafoT.numVertices();

	}

	@Test
	public void test_FD1() {
		Grafo gf;

		Aresta a;

		gf = new Grafo();
		a = new Aresta(0, 5, 7);
		gf.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(0, 9, 7);
		gf.insereAresta(a.v1(), a.v2(), a.peso());

		gf.grafoTransposto();

	}

	@Test
	public void test_FD2() {
		Grafo gf;

		Aresta a;

		gf = new Grafo();
		a = new Aresta(0, 5, 7);
		gf.insereAresta(a.v1(), a.v2(), a.peso());

		gf.imprime();

	}

	@Test
	public void test_FD3() {
		Grafo gf;

		gf = new Grafo();

		gf.imprime();

	}

	@Test
	public void test11_1() {
		Grafo grafo = new Grafo();
		Aresta a;

		a = new Aresta(3, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 5, 9);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(6, 3, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(3, 7, 9);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(7, 5, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(5, 34, 9);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(34, 3, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(7, 6, 9);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(5, 12, 7);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());
		a = new Aresta(12, 4, 9);
		grafo.insereAresta(a.v1(), a.v2(), a.peso());

		grafo.imprime();
		BuscaEmLargura dfs = new BuscaEmLargura(grafo);
		dfs.buscaEmProfundidade();
		for (int v = 0; v < grafo.numVertices(); v++) {
			System.out.println("d[" + v + "]:" + dfs.d(v) + " -- t[" + v + "]:"
					+ dfs.t(v) + " -- antecessor[" + v + "]:"
					+ dfs.antecessor(v));
		}
	}

	@Test
	public void test_FD4() {
		Grafo grafo = new Grafo();

		BuscaEmLargura dfs = new BuscaEmLargura(grafo);
		dfs.buscaEmProfundidade();

	}

}
