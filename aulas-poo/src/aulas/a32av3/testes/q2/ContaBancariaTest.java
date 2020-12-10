package aulas.a32av3.testes.q2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aulas.a32av3.q2.ContaBancaria;

class ContaBancariaTest {

	@Test
	void testContaBancaria() {
		ContaBancaria cb = new ContaBancaria("eu", 555.55);
		assertNotNull(cb);
	}

	@Test
	void testGetTitular() {
		ContaBancaria cb = new ContaBancaria("eu", 555.55);
		assertEquals("eu", cb.getTitular());
	}

	@Test
	void testGetSaldo() {
		ContaBancaria cb = new ContaBancaria("eu", 555.55);
		assertEquals(555.55, cb.getSaldo());
	}

	@Test
	void testFormatoImpressao() {
		ContaBancaria cb = new ContaBancaria("eu", 5555.55);
		System.out.println(cb.formatoImpressao());
		assertEquals("Nome: eu. Saldo: R$ 5.555,55", cb.formatoImpressao());
	}

}
