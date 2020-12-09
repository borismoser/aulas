package aulas.a32av3.q1;

public abstract class Veiculo {

	private String marca;
	private String modelo;

	public Veiculo(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	public final String getMarca() {
		return marca;
	}

	public final String getModelo() {
		return modelo;
	}

}
