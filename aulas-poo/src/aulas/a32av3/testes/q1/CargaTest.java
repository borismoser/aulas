package aulas.a32av3.testes.q1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aulas.a32av3.q1.Carga;

class CargaTest {

	@Test
	void testCarga() {
		Carga c = new Carga("X", "Y", 5000);
		assertNotNull(c);
	}

	@Test
	void testGetCapacidadeCarga() {
		Carga c = new Carga("X", "Y", 5000);
		assertEquals(5000, c.getCapacidadeCarga());
	}

	@Test
	void testGetMarca() {
		Carga c = new Carga("X", "Y", 5000);
		assertEquals("X", c.getMarca());
	}

	@Test
	void testGetModelo() {
		Carga c = new Carga("X", "Y", 5000);
		assertEquals("Y", c.getModelo());
	}

}
