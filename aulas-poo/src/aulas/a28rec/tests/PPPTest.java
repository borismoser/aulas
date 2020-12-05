package aulas.a28rec.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import aulas.a28rec.correcao.Cliente;
import aulas.a28rec.correcao.FormaEntrega;
import aulas.a28rec.correcao.PedidoPizzaPequena;
import aulas.a28rec.correcao.Sabor;

class PPPTest {

	private static final Cliente CLI1 = new Cliente("Um", 1);
	private static final PedidoPizzaPequena PPP1 = new PedidoPizzaPequena(CLI1, FormaEntrega.BALCAO, 1,
			Sabor.PORTUGUESA);

	private static final Cliente CLI2 = new Cliente("Dois", 2);

	@DisplayName("Pedido com todos os dados")
	@Test
	void testPedidoPizza() {
		PedidoPizzaPequena p = new PedidoPizzaPequena(CLI1, FormaEntrega.BALCAO, 1, Sabor.BACON);
		assertNotNull(p);
	}

	@DisplayName("Cliente do Pedido não pode ser nulo")
	@Test
	void testPedidoPizzaClienteNull() {
		assertThrows(NullPointerException.class, () -> {
			new PedidoPizzaPequena(null, FormaEntrega.BALCAO, 1, Sabor.BACON);
		});
	}

	@DisplayName("Get Cliente Pedido")
	@Test
	void testGetCliente() {
		assertEquals(CLI1, PPP1.getCliente());
	}

	@DisplayName("Get Forma Entrega")
	@Test
	void testGetEntrega() {
		assertEquals(FormaEntrega.BALCAO, PPP1.getEntrega());
	}

	@DisplayName("Get Quantidade Pedido")
	@Test
	void testGetQuantidade() {
		assertEquals(1, PPP1.getQuantidade());
	}

	@DisplayName("Quantidade do Pedido não pode ser Zero")
	@Test
	void testGetQuantidadeMenorUm() {
		PedidoPizzaPequena pp = new PedidoPizzaPequena(CLI1, FormaEntrega.BALCAO, 0, Sabor.CALABRESA);
		assertEquals(1, pp.getQuantidade());
	}

	@DisplayName("Quantidade do Pedido não pode ser Negativa")
	@Test
	void testGetQuantidadeNegativa() {
		PedidoPizzaPequena pp = new PedidoPizzaPequena(CLI1, FormaEntrega.BALCAO, -1, Sabor.CALABRESA);
		assertEquals(1, pp.getQuantidade());
	}

	@DisplayName("Preço de 1 pizza pequena no balcão")
	@Test
	void testGetPreco1balcao() {
		assertEquals(30.0, PPP1.getPreco());
	}

	@DisplayName("Preço de 5 pizzas pequenas no balcão")
	@Test
	void testGetPreco5balcao() {
		PedidoPizzaPequena pp = new PedidoPizzaPequena(CLI1, FormaEntrega.BALCAO, 5, Sabor.CALABRESA);
		assertEquals(150.0, pp.getPreco());
	}

	@DisplayName("Preço de 3 pizzas pequenas delivery")
	@Test
	void testGetPreco3delivery() {
		PedidoPizzaPequena pp = new PedidoPizzaPequena(CLI1, FormaEntrega.DELIVERY, 3, Sabor.CALABRESA);
		assertEquals(95.0, pp.getPreco());
	}

	@DisplayName("Preço de 1 pizza pequena delivery")
	@Test
	void testGetPreco1delivery() {
		PedidoPizzaPequena pp = new PedidoPizzaPequena(CLI1, FormaEntrega.DELIVERY, 1, Sabor.CALABRESA);
		assertEquals(35.0, pp.getPreco());
	}

	@DisplayName("Pedidos iguais de pizzas pequenas")
	@Test
	void testEquals() {
		PedidoPizzaPequena p = new PedidoPizzaPequena(CLI1, FormaEntrega.BALCAO, 1, Sabor.PORTUGUESA);
		assertEquals(PPP1, p);
	}

	@DisplayName("Pedidos de pizzas pequenas de clientes diferentes")
	@Test
	void testNotEqualsCliente() {
		PedidoPizzaPequena p = new PedidoPizzaPequena(CLI2, FormaEntrega.BALCAO, 1, Sabor.PORTUGUESA);
		assertNotEquals(PPP1, p);
	}
	
	@DisplayName("Pedidos de pizzas pequenas de sabores diferentes")
	@Test
	void testNotEqualsSabor() {
		PedidoPizzaPequena p = new PedidoPizzaPequena(CLI2, FormaEntrega.BALCAO, 1, Sabor.NAPOLITANA);
		assertNotEquals(PPP1, p);
	}
	
	@DisplayName("Pedidos de pizzas pequenas de entregas diferentes")
	@Test
	void testNotEqualsEntrega() {
		PedidoPizzaPequena p = new PedidoPizzaPequena(CLI1, FormaEntrega.DELIVERY, 1, Sabor.PORTUGUESA);
		assertNotEquals(PPP1, p);
	}
	
	@DisplayName("Get Sabor pizza pequena")
	@Test
	void testGetSabor() {
		assertEquals(Sabor.PORTUGUESA, PPP1.getSabor());
	}

}
