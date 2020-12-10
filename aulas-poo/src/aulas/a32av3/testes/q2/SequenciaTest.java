package aulas.a32av3.testes.q2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aulas.a32av3.q2.Sequencia;

class SequenciaTest {

	@Test
	void testSequencia() {
		Sequencia s = new Sequencia(7, 12);
		assertNotNull(s);
	}

	@Test
	void testFormatoImpressao() {
		Sequencia s = new Sequencia(7, 12);
		assertEquals("7, 8, 9, 10, 11, 12", s.formatoImpressao());
	}

}
