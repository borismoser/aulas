package aulas.a31.classes;

public class Chuveiro implements ControleTemperatura {

	private int niveisTemperatura;
	private int nivelAtual;

	public Chuveiro(int niveisTemperatura) {
		this.niveisTemperatura = niveisTemperatura;
		nivelAtual = 1;
	}

	public int getNivelAtual() {
		return nivelAtual;
	}

	@Override
	public void aumentarTemperatura() {
		if (nivelAtual < niveisTemperatura) {
			nivelAtual++;
		}
	}

	@Override
	public void diminuirTemperatura() {
		if (nivelAtual > 1) {
			nivelAtual--;
		}
	}

	@Override
	public void aumentarMaximo() {
		nivelAtual = niveisTemperatura;
	}

	@Override
	public void diminuirMinimo() {
		nivelAtual = 1;
	}

}
