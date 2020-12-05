package aulas.a28rec.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import aulas.a28rec.correcao.Cliente;
import aulas.a28rec.correcao.FormaEntrega;
import aulas.a28rec.correcao.PedidoPizza;

class PPTest {

	private static final Cliente CLI = new Cliente("", 0);
	private static final PedidoPizza PP = new PedidoPizza(CLI, FormaEntrega.BALCAO, 5);

	@DisplayName("Pedido com todos os dados")
	@Test
	void testPedidoPizza() {
		PedidoPizza pp = new PedidoPizza(CLI, FormaEntrega.BALCAO, 1);
		assertNotNull(pp);
	}

	@DisplayName("Cliente do Pedido não pode ser nulo")
	@Test
	void testPedidoPizzaClienteNull() {
		assertThrows(NullPointerException.class, () -> {
			new PedidoPizza(null, FormaEntrega.BALCAO, 1);
		});
	}

	@DisplayName("Get Cliente Pedido")
	@Test
	void testGetCliente() {
		assertEquals(CLI, PP.getCliente());
	}

	@DisplayName("Get Forma Entrega")
	@Test
	void testGetEntrega() {
		assertEquals(FormaEntrega.BALCAO, PP.getEntrega());
	}

	@DisplayName("Get Quantidade Pedido")
	@Test
	void testGetQuantidade() {
		assertEquals(5, PP.getQuantidade());
	}

}
