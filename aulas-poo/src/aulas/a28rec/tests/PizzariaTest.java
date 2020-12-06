package aulas.a28rec.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import aulas.a28rec.correcao.Cliente;
import aulas.a28rec.correcao.FormaEntrega;
import aulas.a28rec.correcao.PedidoPizzaGrande;
import aulas.a28rec.correcao.PedidoPizzaMedia;
import aulas.a28rec.correcao.PedidoPizzaPequena;
import aulas.a28rec.correcao.Pizzaria;
import aulas.a28rec.correcao.Sabor;

public class PizzariaTest {

	private Pizzaria PZ;
	private Cliente CLI = new Cliente("eu", 0);

	@BeforeEach
	private void newPizzaria() {
		PZ = new Pizzaria("MegaPizza");
	}

	@DisplayName("Pizzaria não pode ter nome nulo.")
	@Test
	void testNewPizzariaNomeNulo() {
		assertThrows(NullPointerException.class, () -> {
			new Pizzaria(null);
		});
	}

	@DisplayName("Pizzaria com nome correto.")
	@Test
	void testNewPizzaria() {
		assertNotNull(new Pizzaria("MegaPizza"));
	}

	@DisplayName("Pedido de pizza pequena.")
	@Test
	void testNovoPedidoPedidoPizzaPequena() {
		PedidoPizzaPequena p = new PedidoPizzaPequena(CLI, FormaEntrega.BALCAO, 1, Sabor.BACON);
		assertTrue(PZ.novoPedido(p));
	}

	@DisplayName("Pedido de pizza pequena - duplicado.")
	@Test
	void testNovoPedidoPedidoPizzaPequenaDuplicado() {
		PedidoPizzaPequena p = new PedidoPizzaPequena(CLI, FormaEntrega.BALCAO, 1, Sabor.BACON);
		assertTrue(PZ.novoPedido(p));
		p = new PedidoPizzaPequena(CLI, FormaEntrega.BALCAO, 1, Sabor.BACON);
		assertFalse(PZ.novoPedido(p));
	}

	@DisplayName("Pedido de pizza média.")
	@Test
	void testNovoPedidoPedidoPizzaMedia() {
		PedidoPizzaMedia p = new PedidoPizzaMedia(CLI, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.CALABRESA);
		assertTrue(PZ.novoPedido(p));
	}

	@DisplayName("Pedido de pizza média - duplicado.")
	@Test
	void testNovoPedidoPedidoPizzaMediaDuplicado() {
		PedidoPizzaMedia p = new PedidoPizzaMedia(CLI, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.CALABRESA);
		assertTrue(PZ.novoPedido(p));
		p = new PedidoPizzaMedia(CLI, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.CALABRESA);
		assertFalse(PZ.novoPedido(p));
	}

	@DisplayName("Pedido de pizza grade.")
	@Test
	void testNovoPedidoPedidoPizzaGrande() {
		PedidoPizzaGrande p = new PedidoPizzaGrande(CLI, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.CALABRESA,
				Sabor.PORTUGUESA);
		assertTrue(PZ.novoPedido(p));
	}

	@DisplayName("Pedido de pizza grade - duplicado.")
	@Test
	void testNovoPedidoPedidoPizzaGrandeDuplicado() {
		PedidoPizzaGrande p = new PedidoPizzaGrande(CLI, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.CALABRESA,
				Sabor.PORTUGUESA);
		assertTrue(PZ.novoPedido(p));
		p = new PedidoPizzaGrande(CLI, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.CALABRESA, Sabor.PORTUGUESA);
		assertFalse(PZ.novoPedido(p));
	}

	@DisplayName("Get Nome da Pizzaria.")
	@Test
	void testGetNomePizzaria() {
		assertEquals("MegaPizza", PZ.getNomePizzaria());
	}

	@DisplayName("Valor total dos pedidos.")
	@Test
	void testGetValorTotalPedidos() {
		PedidoPizzaPequena p = new PedidoPizzaPequena(CLI, FormaEntrega.BALCAO, 1, Sabor.BACON);
		PZ.novoPedido(p);
		p = new PedidoPizzaPequena(CLI, FormaEntrega.DELIVERY, 2, Sabor.CALABRESA);
		PZ.novoPedido(p);
		PedidoPizzaMedia m = new PedidoPizzaMedia(CLI, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.CALABRESA);
		PZ.novoPedido(m);
		PedidoPizzaGrande g = new PedidoPizzaGrande(CLI, FormaEntrega.BALCAO, 1, Sabor.BACON, Sabor.CALABRESA,
				Sabor.PORTUGUESA);
		PZ.novoPedido(g);
		assertEquals(185.0, PZ.getValorTotalPedidos());
	}

}
