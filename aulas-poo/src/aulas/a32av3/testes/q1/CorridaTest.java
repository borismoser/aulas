package aulas.a32av3.testes.q1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import aulas.a32av3.q1.Corrida;

class CorridaTest {

	@Test
	void testCorrida() {
		Corrida c = new Corrida("X", "Y", 5000);
		assertNotNull(c);
	}

	@Test
	void testGetCapacidadeCorrida() {
		Corrida c = new Corrida("X", "Y", 5000);
		assertEquals(5000, c.getVelocidadeMax());
	}

	@Test
	void testGetMarca() {
		Corrida c = new Corrida("X", "Y", 5000);
		assertEquals("X", c.getMarca());
	}

	@Test
	void testGetModelo() {
		Corrida c = new Corrida("X", "Y", 5000);
		assertEquals("Y", c.getModelo());
	}

}
