package aulas.a32av3.testes.q1;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import aulas.a32av3.q1.Carga;
import aulas.a32av3.q1.Corrida;
import aulas.a32av3.q1.Fabrica;
import aulas.a32av3.q1.Transporte;

class FabricaTest {

	@Test
	void newFabrica() {
		Fabrica f = new Fabrica("GM");
		assertNotNull(f);
	}

	@Test
	void new2Veiculos() {
		Fabrica f = new Fabrica("Ferrari");
		f.construirVeiculoCorrida("F1", 350.0);
		f.construirVeiculoCarga("F1000", 1200);
		assertEquals(2, f.getVeiculos().size());
	}

	@Test
	void new3Veiculos() {
		Fabrica f = new Fabrica("Pirata");
		f.construirVeiculoCorrida("F1", 350.0);
		f.construirVeiculoCarga("F1000", 1200);
		f.construirVeiculoTransporte("Kombi", 15);
		assertEquals(3, f.getVeiculos().size());
	}

	@Test
	void new30Veiculos() {
		Fabrica f = new Fabrica("Pirata");
		for (int i = 0; i < 10; i++) {
			f.construirVeiculoCorrida("F1", 350.0);
			f.construirVeiculoCarga("F1000", 1200);
			f.construirVeiculoTransporte("Kombi", 15);
		}
		assertEquals(30, f.getVeiculos().size());
	}

	@Test
	void qt10VeiculosCorrida() {
		Fabrica f = new Fabrica("Pirata");
		for (int i = 0; i < 10; i++) {
			f.construirVeiculoCorrida("F1", 350.0);
			f.construirVeiculoCarga("F1000", 1200);
			f.construirVeiculoTransporte("Kombi", 15);
		}
		assertEquals(10, f.qtVeiculosCorrida());
	}
	
	@Test
	void qt8VeiculosCarga() {
		Fabrica f = new Fabrica("Pirata");
		for (int i = 0; i < 8; i++) {
			f.construirVeiculoCorrida("F1", 350.0);
			f.construirVeiculoCarga("F1000", 1200);
			f.construirVeiculoTransporte("Kombi", 15);
		}
		assertEquals(8, f.qtVeiculosCarga());
	}
	
	@Test
	void qt18VeiculosTransporte() {
		Fabrica f = new Fabrica("Pirata");
		f.construirVeiculoCorrida("F1", 350.0);
		for (int i = 0; i < 18; i++) {
			f.construirVeiculoTransporte("Kombi", 15);
		}
		f.construirVeiculoCarga("F1000", 1200);
		assertEquals(18, f.qtVeiculosTransporte());
	}
	
	@Test
	void newCorridaMarca() {
		Fabrica f = new Fabrica("Ferrari");
		f.construirVeiculoCorrida("F1", 350.0);
		assertEquals("Ferrari", ((Corrida) f.getVeiculos().get(0)).getMarca());
	}

	@Test
	void newCorridaModelo() {
		Fabrica f = new Fabrica("Ferrari");
		f.construirVeiculoCorrida("F1", 350.0);
		assertEquals("F1", ((Corrida) f.getVeiculos().get(0)).getModelo());
	}

	@Test
	void newCorridaVelocidade() {
		Fabrica f = new Fabrica("Ferrari");
		f.construirVeiculoCorrida("F1", 350.0);
		assertEquals(350.0, ((Corrida) f.getVeiculos().get(0)).getVelocidadeMax());
	}

	@Test
	void newCargaMarca() {
		Fabrica f = new Fabrica("Ford");
		f.construirVeiculoCarga("F1000", 1200);
		assertEquals("Ford", ((Carga) f.getVeiculos().get(0)).getMarca());
	}

	@Test
	void newCargaModelo() {
		Fabrica f = new Fabrica("Ford");
		f.construirVeiculoCarga("F1000", 1200);
		assertEquals("F1000", ((Carga) f.getVeiculos().get(0)).getModelo());
	}

	@Test
	void newCargaCapacidade() {
		Fabrica f = new Fabrica("Ford");
		f.construirVeiculoCarga("F1000", 1200);
		assertEquals(1200, ((Carga) f.getVeiculos().get(0)).getCapacidadeCarga());
	}

	@Test
	void newTransporteMarca() {
		Fabrica f = new Fabrica("VW");
		f.construirVeiculoTransporte("Kombi", 15);
		assertEquals("VW", ((Transporte) f.getVeiculos().get(0)).getMarca());
	}

	@Test
	void newTransporteModelo() {
		Fabrica f = new Fabrica("VW");
		f.construirVeiculoTransporte("Kombi", 15);
		assertEquals("Kombi", ((Transporte) f.getVeiculos().get(0)).getModelo());
	}

	@Test
	void newTransportePassageiros() {
		Fabrica f = new Fabrica("VW");
		f.construirVeiculoTransporte("Kombi", 15);
		assertEquals(15, ((Transporte) f.getVeiculos().get(0)).getQtPassageiros());
	}

}
