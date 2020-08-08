package jogodedados;

import java.security.SecureRandom;

public class DadoDeJogar {
	private int valorInferior;
	private int valorSuperior;
	private int valorEscala;

	public DadoDeJogar(int valorInferior, int valorSuperior) {
		this.valorInferior = valorInferior;
		this.valorSuperior = valorSuperior;
		this.valorEscala = this.valorSuperior - this.valorInferior + 1;
	}

	private static SecureRandom sr = new SecureRandom();
	
	public int getFace() {
		int face = valorInferior + sr.nextInt(valorEscala);
		return face;
	}
}
