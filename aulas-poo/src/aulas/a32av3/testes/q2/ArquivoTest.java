package aulas.a32av3.testes.q2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aulas.a32av3.q2.Arquivo;

class ArquivoTest {

	@Test
	void testArquivo() {
		Arquivo a = new Arquivo("teste");
		assertNotNull(a);
	}

	@Test
	void testGetNomeArquivo() {
		Arquivo a = new Arquivo("teste");
		assertEquals("teste", a.getNomeArquivo());
	}

	@Test
	void testGetConteudo() {
		Arquivo a = new Arquivo("teste");
		a.setConteudo("conteúdo");
		assertEquals("conteúdo", a.getConteudo());
	}

	@Test
	void testSetConteudo() {
		Arquivo a = new Arquivo("teste");
		a.setConteudo("conteúdo");
		a.setConteudo("conteúdo2");
		assertEquals("conteúdo2", a.getConteudo());
	}

	@Test
	void testFormatoImpressao() {
		Arquivo a = new Arquivo("teste");
		a.setConteudo("conteúdo");
		assertEquals("conteúdo", a.formatoImpressao());
	}

}
