package aulas.a32av3.testes.q1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import aulas.a32av3.q1.Transporte;

class TransporteTest {

	@Test
	void testTransporte() {
		Transporte c = new Transporte("X", "Y", 5000);
		assertNotNull(c);
	}

	@Test
	void testGetCapacidadeTransporte() {
		Transporte c = new Transporte("X", "Y", 5000);
		assertEquals(5000, c.getQtPassageiros());
	}

	@Test
	void testGetMarca() {
		Transporte c = new Transporte("X", "Y", 5000);
		assertEquals("X", c.getMarca());
	}

	@Test
	void testGetModelo() {
		Transporte c = new Transporte("X", "Y", 5000);
		assertEquals("Y", c.getModelo());
	}

}
