package aulas.a28rec.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import aulas.a28rec.correcao.Cliente;
import aulas.a28rec.correcao.FormaEntrega;
import aulas.a28rec.correcao.PedidoPizzaGrande;
import aulas.a28rec.correcao.Sabor;

class PPGTest {

	private static final Cliente CLI1 = new Cliente("Um", 1);
	private static final PedidoPizzaGrande PPG = new PedidoPizzaGrande(CLI1, FormaEntrega.BALCAO, 1, Sabor.PORTUGUESA,
			Sabor.NAPOLITANA, Sabor.BACON);

	private static final Cliente CLI2 = new Cliente("Dois", 2);

	@DisplayName("Pedido com todos os dados")
	@Test
	void testPedidoPizza() {
		PedidoPizzaGrande p = new PedidoPizzaGrande(CLI1, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.NAPOLITANA,
				Sabor.CALABRESA);
		assertNotNull(p);
	}

	@DisplayName("Cliente do Pedido não pode ser nulo")
	@Test
	void testPedidoPizzaClienteNull() {
		assertThrows(NullPointerException.class, () -> {
			new PedidoPizzaGrande(null, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.BACON, Sabor.BACON);
		});
	}

	@DisplayName("Get Cliente Pedido")
	@Test
	void testGetCliente() {
		assertEquals(CLI1, PPG.getCliente());
	}

	@DisplayName("Get Forma Entrega")
	@Test
	void testGetEntrega() {
		assertEquals(FormaEntrega.BALCAO, PPG.getEntrega());
	}

	@DisplayName("Get Quantidade Pedido")
	@Test
	void testGetQuantidade() {
		assertEquals(1, PPG.getQuantidade());
	}

	@DisplayName("Quantidade do Pedido não pode ser Zero")
	@Test
	void testGetQuantidadeMenorUm() {
		PedidoPizzaGrande pp = new PedidoPizzaGrande(CLI1, FormaEntrega.BALCAO, 0, Sabor.BACON, Sabor.BACON,
				Sabor.BACON);
		assertEquals(1, pp.getQuantidade());
	}

	@DisplayName("Quantidade do Pedido não pode ser Negativa")
	@Test
	void testGetQuantidadeNegativa() {
		PedidoPizzaGrande pp = new PedidoPizzaGrande(CLI1, FormaEntrega.BALCAO, -1, Sabor.CALABRESA, Sabor.CALABRESA,
				Sabor.BACON);
		assertEquals(1, pp.getQuantidade());
	}

	@DisplayName("Preço de 1 pizza Grande no balcão")
	@Test
	void testGetPreco1balcao() {
		assertEquals(50.0, PPG.getPreco());
	}

	@DisplayName("Preço de 5 pizzas Grandes no balcão")
	@Test
	void testGetPreco5balcao() {
		PedidoPizzaGrande pp = new PedidoPizzaGrande(CLI1, FormaEntrega.BALCAO, 5, Sabor.CALABRESA, Sabor.NAPOLITANA,
				Sabor.BACON);
		assertEquals(250.0, pp.getPreco());
	}

	@DisplayName("Preço de 3 pizzas Grandes delivery")
	@Test
	void testGetPreco3delivery() {
		PedidoPizzaGrande pp = new PedidoPizzaGrande(CLI1, FormaEntrega.DELIVERY, 3, Sabor.CALABRESA, Sabor.BACON,
				Sabor.PORTUGUESA);
		assertEquals(155.0, pp.getPreco());
	}

	@DisplayName("Preço de 1 pizza Grande delivery")
	@Test
	void testGetPreco1delivery() {
		PedidoPizzaGrande pp = new PedidoPizzaGrande(CLI1, FormaEntrega.DELIVERY, 1, Sabor.CALABRESA, Sabor.PORTUGUESA,
				Sabor.BACON);
		assertEquals(55.0, pp.getPreco());
	}

	@DisplayName("Pedidos iguais de pizzas Grandes")
	@Test
	void testEquals() {
		PedidoPizzaGrande p = new PedidoPizzaGrande(CLI1, FormaEntrega.BALCAO, 1, Sabor.PORTUGUESA, Sabor.NAPOLITANA,
				Sabor.BACON);
		assertEquals(PPG, p);
	}

	@DisplayName("Pedidos de pizzas Grandes de clientes diferentes")
	@Test
	void testNotEqualsCliente() {
		PedidoPizzaGrande p = new PedidoPizzaGrande(CLI2, FormaEntrega.BALCAO, 1, Sabor.PORTUGUESA, Sabor.NAPOLITANA,
				Sabor.BACON);
		assertNotEquals(PPG, p);
	}

	@DisplayName("Pedidos de pizzas Grandes de sabores diferentes")
	@Test
	void testNotEqualsSabor() {
		PedidoPizzaGrande p = new PedidoPizzaGrande(CLI2, FormaEntrega.BALCAO, 1, Sabor.PORTUGUESA, Sabor.BACON,
				Sabor.BACON);
		assertNotEquals(PPG, p);
	}

	@DisplayName("Pedidos de pizzas Grandes de entregas diferentes")
	@Test
	void testNotEqualsEntrega() {
		PedidoPizzaGrande p = new PedidoPizzaGrande(CLI1, FormaEntrega.DELIVERY, 1, Sabor.PORTUGUESA, Sabor.NAPOLITANA,
				Sabor.BACON);
		assertNotEquals(PPG, p);
	}

	@DisplayName("Pedidos de pizzas Grandes de sabores iguais em ordens diferentes")
	@Test
	void testEqualsOrdemSabor() {
		PedidoPizzaGrande p = new PedidoPizzaGrande(CLI1, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.PORTUGUESA,
				Sabor.NAPOLITANA);
		assertEquals(PPG, p);
	}

	@DisplayName("Pedidos de pizzas Grandes de sabores iguais em ordens diferentes")
	@Test
	void testEqualsOrdemSabor2() {
		PedidoPizzaGrande p = new PedidoPizzaGrande(CLI1, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.CALABRESA,
				Sabor.NAPOLITANA);
		PedidoPizzaGrande pp = new PedidoPizzaGrande(CLI1, FormaEntrega.BALCAO, 1, Sabor.NAPOLITANA, Sabor.CALABRESA,
				Sabor.BACON);
		assertEquals(pp, p);
	}
	
	@DisplayName("Pedidos de pizzas Grandes de sabores iguais em quantidades diferentes")
	@Test
	void testEqualsQuantidadeSabor() {
		PedidoPizzaGrande p = new PedidoPizzaGrande(CLI1, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.BACON,
				Sabor.NAPOLITANA);
		PedidoPizzaGrande pp = new PedidoPizzaGrande(CLI1, FormaEntrega.BALCAO, 1, Sabor.NAPOLITANA, Sabor.BACON,
				Sabor.NAPOLITANA);
		assertNotEquals(pp, p);
	}
	
	@DisplayName("Get Sabor 1 pizza Grande")
	@Test
	void testGetSabor1() {
		assertEquals(Sabor.PORTUGUESA, PPG.getSabor1());
	}

	@DisplayName("Get Sabor 2 pizza Grande")
	@Test
	void testGetSabor2() {
		assertEquals(Sabor.NAPOLITANA, PPG.getSabor2());
	}

	@DisplayName("Get Sabor 2 pizza Grande")
	@Test
	void testGetSabor3() {
		assertEquals(Sabor.BACON, PPG.getSabor3());
	}

}
