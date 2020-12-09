package aulas.a32av3.q1;

import java.util.ArrayList;

public class Fabrica {

	private final String marca;
	private final ArrayList<Veiculo> veiculos;

	public Fabrica(String marca) {
		this.marca = marca;
		veiculos = new ArrayList<>();
	}

	public final String getMarca() {
		return marca;
	}

	public final ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void construirVeiculoCarga(String modelo, int kilosCarga) {
		veiculos.add(new Carga(marca, modelo, kilosCarga));
	}

	public void construirVeiculoTransporte(String modelo, int qtPassageiros) {
		veiculos.add(new Transporte(marca, modelo, qtPassageiros));
	}

	public void construirVeiculoCorrida(String modelo, double velocidadeMax) {
		veiculos.add(new Corrida(marca, modelo, velocidadeMax));
	}

	public int qtVeiculosCarga() {
		return 0;
	}

	public int qtVeiculosTransporte() {
		return 0;
	}

	public int qtVeiculosCorrida() {
		return 0;
	}

}
