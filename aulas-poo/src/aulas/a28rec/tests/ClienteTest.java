package aulas.a28rec.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import aulas.a28rec.correcao.Cliente;

public class ClienteTest {


	@DisplayName("Cliente não pode ter nome nulo.")
	@Test
	void testNewClienteNomeNulo() {
		assertThrows(NullPointerException.class, () -> {
			new Cliente(null, 0);
		});
	}

	@DisplayName("Cliente com nome correto.")
	@Test
	void testNewCliente() {
		assertNotNull(new Cliente("Fulano de Tal", 12345));
	}
	
	@DisplayName("Get nome cliente.")
	@Test
	void testGetNomeCliente() {
		String nome = "Fulano de Tal";
		Cliente cli = new Cliente(nome, 12345);
		assertEquals(nome, cli.getNome());
	}
	
	@DisplayName("Get telefone cliente.")
	@Test
	void testGetTelefoneCliente() {
		int fone = 12345;
		Cliente cli = new Cliente("", fone);
		assertEquals(fone, cli.getTelefone());
	}
	
	@DisplayName("Clientes iguais.")
	@Test
	void testClienteEquals() {
		String nome = "Fulano de Tal";
		Cliente cli = new Cliente(nome, 12345);
		Cliente cli2 = new Cliente(nome, 12345);
		assertEquals(cli, cli2);
	}

	@DisplayName("Clientes com telefones diferentes.")
	@Test
	void testClienteFoneNotEquals() {
		String nome = "Fulano de Tal";
		Cliente cli = new Cliente(nome, 12345);
		Cliente cli2 = new Cliente(nome, 123456);
		assertNotEquals(cli, cli2);
	}
	
	@DisplayName("Clientes com nomes diferentes.")
	@Test
	void testClienteNotEquals() {
		Cliente cli = new Cliente("Fulano de Tal", 12345);
		Cliente cli2 = new Cliente("Fulano de Tall", 123456);
		assertNotEquals(cli, cli2);
	}
	
}

