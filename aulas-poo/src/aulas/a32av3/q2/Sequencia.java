package aulas.a32av3.q2;

public class Sequencia implements Imprimivel {

	private int inicio;
	private int fim;

	public Sequencia(int inicio, int fim) {
		this.inicio = inicio;
		this.fim = fim;
	}

	@Override
	public String formatoImpressao() {
		String s = "";
		for (int x = inicio; x < fim; x++) {
			s += x + ", ";
		}
		s += fim;
		return s;
	}

}
