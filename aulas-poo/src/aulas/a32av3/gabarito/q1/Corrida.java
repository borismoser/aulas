package aulas.a32av3.gabarito.q1;

public class Corrida extends Veiculo {

	public double velocidadeMax;

	public Corrida(String marca, String modelo, double velocidadeMax) {
		super(marca, modelo);
		this.velocidadeMax = velocidadeMax;
	}

	public final double getVelocidadeMax() {
		return velocidadeMax;
	}

}
