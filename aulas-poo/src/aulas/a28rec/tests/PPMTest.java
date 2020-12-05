package aulas.a28rec.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import aulas.a28rec.correcao.Cliente;
import aulas.a28rec.correcao.FormaEntrega;
import aulas.a28rec.correcao.PedidoPizzaMedia;
import aulas.a28rec.correcao.Sabor;

class PPMTest {

	private static final Cliente CLI1 = new Cliente("Um", 1);
	private static final PedidoPizzaMedia PPM = new PedidoPizzaMedia(CLI1, FormaEntrega.BALCAO, 1, Sabor.PORTUGUESA,
			Sabor.NAPOLITANA);

	private static final Cliente CLI2 = new Cliente("Dois", 2);

	@DisplayName("Pedido com todos os dados")
	@Test
	void testPedidoPizza() {
		PedidoPizzaMedia p = new PedidoPizzaMedia(CLI1, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.NAPOLITANA);
		assertNotNull(p);
	}

	@DisplayName("Cliente do Pedido não pode ser nulo")
	@Test
	void testPedidoPizzaClienteNull() {
		assertThrows(NullPointerException.class, () -> {
			new PedidoPizzaMedia(null, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.BACON);
		});
	}

	@DisplayName("Get Cliente Pedido")
	@Test
	void testGetCliente() {
		assertEquals(CLI1, PPM.getCliente());
	}

	@DisplayName("Get Forma Entrega")
	@Test
	void testGetEntrega() {
		assertEquals(FormaEntrega.BALCAO, PPM.getEntrega());
	}

	@DisplayName("Get Quantidade Pedido")
	@Test
	void testGetQuantidade() {
		assertEquals(1, PPM.getQuantidade());
	}

	@DisplayName("Quantidade do Pedido não pode ser Zero")
	@Test
	void testGetQuantidadeMenorUm() {
		PedidoPizzaMedia pp = new PedidoPizzaMedia(CLI1, FormaEntrega.BALCAO, 0, Sabor.CALABRESA, Sabor.CALABRESA);
		assertEquals(1, pp.getQuantidade());
	}

	@DisplayName("Quantidade do Pedido não pode ser Negativa")
	@Test
	void testGetQuantidadeNegativa() {
		PedidoPizzaMedia pp = new PedidoPizzaMedia(CLI1, FormaEntrega.BALCAO, -1, Sabor.CALABRESA, Sabor.CALABRESA);
		assertEquals(1, pp.getQuantidade());
	}

	@DisplayName("Preço de 1 pizza Media no balcão")
	@Test
	void testGetPreco1balcao() {
		assertEquals(40.0, PPM.getPreco());
	}

	@DisplayName("Preço de 5 pizzas Medias no balcão")
	@Test
	void testGetPreco5balcao() {
		PedidoPizzaMedia pp = new PedidoPizzaMedia(CLI1, FormaEntrega.BALCAO, 5, Sabor.CALABRESA, Sabor.NAPOLITANA);
		assertEquals(200.0, pp.getPreco());
	}

	@DisplayName("Preço de 3 pizzas Medias delivery")
	@Test
	void testGetPreco3delivery() {
		PedidoPizzaMedia pp = new PedidoPizzaMedia(CLI1, FormaEntrega.DELIVERY, 3, Sabor.CALABRESA, Sabor.BACON);
		assertEquals(125.0, pp.getPreco());
	}

	@DisplayName("Preço de 1 pizza Media delivery")
	@Test
	void testGetPreco1delivery() {
		PedidoPizzaMedia pp = new PedidoPizzaMedia(CLI1, FormaEntrega.DELIVERY, 1, Sabor.CALABRESA, Sabor.PORTUGUESA);
		assertEquals(45.0, pp.getPreco());
	}

	@DisplayName("Pedidos iguais de pizzas Medias")
	@Test
	void testEquals() {
		PedidoPizzaMedia p = new PedidoPizzaMedia(CLI1, FormaEntrega.BALCAO, 1, Sabor.PORTUGUESA, Sabor.NAPOLITANA);
		assertEquals(PPM, p);
	}

	@DisplayName("Pedidos de pizzas Medias de clientes diferentes")
	@Test
	void testNotEqualsCliente() {
		PedidoPizzaMedia p = new PedidoPizzaMedia(CLI2, FormaEntrega.BALCAO, 1, Sabor.PORTUGUESA, Sabor.NAPOLITANA);
		assertNotEquals(PPM, p);
	}

	@DisplayName("Pedidos de pizzas Medias de sabores diferentes")
	@Test
	void testNotEqualsSabor() {
		PedidoPizzaMedia p = new PedidoPizzaMedia(CLI2, FormaEntrega.BALCAO, 1, Sabor.PORTUGUESA, Sabor.BACON);
		assertNotEquals(PPM, p);
	}

	@DisplayName("Pedidos de pizzas Medias de entregas diferentes")
	@Test
	void testNotEqualsEntrega() {
		PedidoPizzaMedia p = new PedidoPizzaMedia(CLI1, FormaEntrega.DELIVERY, 1, Sabor.PORTUGUESA, Sabor.NAPOLITANA);
		assertNotEquals(PPM, p);
	}

	@DisplayName("Pedidos de pizzas Medias de sabores iguais em ordens diferentes")
	@Test
	void testEqualsOrdemSabor() {
		PedidoPizzaMedia p = new PedidoPizzaMedia(CLI1, FormaEntrega.DELIVERY, 1, Sabor.NAPOLITANA, Sabor.PORTUGUESA);
		assertEquals(PPM, p);
	}
	
	@DisplayName("Get Sabor 1 pizza Media")
	@Test
	void testGetSabor1() {
		assertEquals(Sabor.PORTUGUESA, PPM.getSabor1());
	}

	@DisplayName("Get Sabor 2 pizza Media")
	@Test
	void testGetSabor2() {
		assertEquals(Sabor.NAPOLITANA, PPM.getsabor2());
	}
	
}
