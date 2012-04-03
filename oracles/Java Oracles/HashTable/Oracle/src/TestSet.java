import static org.junit.Assert.*;

import org.junit.Test;

public class TestSet {

	TabelaHash tabela = new TabelaHash();

	@Test
	public void test1_1() {
		tabela = new TabelaHash();
		assertEquals(tabela != null, true);
	}

	@Test
	public void test2_1() {
		Object obj;

		tabela = new TabelaHash();

		tabela.insere("dafa", "fsdfa");
		tabela.insere("asdf", "asdf");
		tabela.insere("sdhg", "sdhg");
		tabela.insere("sdfhdd", "sdfhdd");
		tabela.insere("jkhgfd", "jkhgfd");

		obj = tabela.pesquisa("sdhg");

		assertEquals(obj != null, true);
	}

	@Test
	public void test2_2() {
		Object obj;

		tabela = new TabelaHash();

		tabela.insere("dafa", "fsdfa");
		tabela.insere("asdf", "asdf");
		tabela.insere("sdhg", "sdhg");
		tabela.insere("sdfhdd", "sdfhdd");
		tabela.insere("jkhgfd", "jkhgfd");

		obj = tabela.pesquisa("sdhgd");

		assertEquals(obj == null, true);
	}

	@Test
	public void test3_1e3() {
		Object obj;

		tabela = new TabelaHash();

		tabela.insere("dafa", "fsdfa");
		tabela.insere("asdf", "asdf");
		tabela.insere("sdhg", "sdhg");
		tabela.insere("sdfhdd", "sdfhdd");
		tabela.insere("jkhgfd", "jkhgfd");

		tabela.insere("teste", "teste");

		obj = tabela.pesquisa("teste");

		assertEquals(obj != null, true);
	}

	@Test
	public void test3_2() {
		Object obj;

		tabela = new TabelaHash();

		tabela.insere("teste", "teste");

		obj = tabela.pesquisa("teste");

		assertEquals(obj != null, true);
	}

	@Test
	public void test3_4() {
		Object obj;

		tabela = new TabelaHash();

		tabela.insere("dafa", "fsdfa");
		tabela.insere("asdf", "asdf");
		tabela.insere("sdhg", "sdhg");
		tabela.insere("sdfhdd", "sdfhdd");
		tabela.insere("jkhgfd", "jkhgfd");

		tabela.insere("sdhg", "sdhg");

		obj = tabela.pesquisa("sdhg");

		assertEquals(obj != null, true);
		// verificar erro na saida padrao: Registro ja esta presente
	}

	@Test
	public void test4_1e3() {
		Object obj1, obj2;

		tabela = new TabelaHash();

		tabela.insere("dafa", "fsdfa");
		tabela.insere("asdf", "asdf");
		tabela.insere("sdhg", "sdhg");
		tabela.insere("sdfhdd", "sdfhdd");
		tabela.insere("jkhgfd", "jkhgfd");

		obj1 = tabela.pesquisa("sdhg");
		try {
			tabela.retira("sdhg");
		} catch (Exception e) {
		}

		obj2 = tabela.pesquisa("sdhg");

		assertEquals(obj1 != null && obj2 == null, true);
	}

	@Test
	public void test4_2() {
		Object obj;

		tabela = new TabelaHash();

		try {
			tabela.retira("sdhg");
		} catch (Exception e) {
		}

		obj = tabela.pesquisa("sdhg");

		assertEquals(obj == null, true);
	}

	@Test
	public void test4_4() {
		Object obj1, obj2;

		tabela = new TabelaHash();

		tabela.insere("dafa", "fsdfa");
		tabela.insere("asdf", "asdf");
		tabela.insere("sdhg", "sdhg");
		tabela.insere("sdfhdd", "sdfhdd");
		tabela.insere("jkhgfd", "jkhgfd");

		obj1 = tabela.pesquisa("teste");
		try {
			tabela.retira("teste");
		} catch (Exception e) {
		}

		obj2 = tabela.pesquisa("teste");

		assertEquals(obj1 == null && obj2 == null, true);
	}

	@Test
	public void test5_1() {
		tabela = new TabelaHash();

		tabela.insere("dafa", "fsdfa");
		tabela.insere("asdf", "asdf");
		tabela.insere("sdhg", "sdhg");
		tabela.insere("sdfhdd", "sdfhdd");
		tabela.insere("jkhgfd", "jkhgfd");

		tabela.imprime();
		// verifica a impressao;
	}

	public void test5_2() {
		tabela = new TabelaHash();

		tabela.imprime();
		// verifica a impressao;
	}

	@Test
	public void testFC_1() {
		tabela = new TabelaHash();

		tabela.insere("dafa", "fsdfa");
		tabela.insere("asdf", "asdf");
		tabela.insere("sdhg", "sdhg");
		tabela.insere("sdfhdd", "sdfhdd");
		tabela.insere("jkhgfd", "jkhgfd");
		tabela.insere("jkhgfd1", "jkhgfd1");
		tabela.insere("jkhgfd2", "jkhgfd2");

		tabela.insere("jkhgfdas2", "jkhgfdas2");
		// verifica a impressao;
	}

	@Test
	public void testFC_2() throws Exception {
		tabela = new TabelaHash();

		tabela.insere("dafa", "fsdfa");
		tabela.insere("asdf", "asdf");
		tabela.insere("sdhg", "sdhg");
		tabela.insere("sdfhdd", "sdfhdd");
		tabela.retira("asdf");
		tabela.insere("jkhgfd", "jkhgfd");
		tabela.insere("jkhgfd1", "jkhgfd1");
		tabela.insere("jkhgfd2", "jkhgfd2");

		tabela.insere("asdf", "asdf");
		// verifica a impressao;
	}

	@Test
	public void testFC_3() throws Exception {
		tabela = new TabelaHash();

		tabela.insere("dafa", "fsdfa");
		tabela.insere("asdf", "asdf");
		tabela.insere("sdhg", "sdhg");
		tabela.insere("sdfhdd", "sdfhdd");
		tabela.retira("asdf");
		tabela.insere("jkhgfd", "jkhgfd");
		tabela.insere("jkhgfd1", "jkhgfd1");
		tabela.insere("jkhgfd2", "jkhgfd2");

		tabela.imprime();
		// verifica a impressao;
	}

	@Test
	public void testFD_1() throws Exception {
		tabela = new TabelaHash();

		tabela.insere("", "madas");

		// verifica a impressao;
	}

	@Test
	public void testFD_2() throws Exception {
		tabela = new TabelaHash();
		tabela.insere("dafa", "fsdfa");
		tabela.retira("dafa");
		tabela.imprime();

		// verifica a impressao;
	}

	@Test
	public void testFD_3() throws Exception {
		tabela = new TabelaHash();
		tabela.insere("dafa", "fsdfa");
		tabela.insere("dafa", "fsdfa");

		// verifica a impressao;
	}

}
