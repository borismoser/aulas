package aulas.a31.classes;

public class Forno implements ControleTemperatura {

	private int minima;
	private int maxima;
	private int temperatura;

	public Forno(int minima, int maxima) {
		this.minima = minima;
		this.maxima = maxima;
		temperatura = minima;
	}

	@Override
	public void aumentarTemperatura() {
		if (temperatura + 5 > maxima) {
			aumentarMaximo();
		} else {
			temperatura += 5;
		}
	}

	@Override
	public void diminuirTemperatura() {
		if (temperatura - 5 < minima) {
			diminuirMinimo();
		} else {
			temperatura -= 5;
		}
	}

	@Override
	public void aumentarMaximo() {
		temperatura = maxima;
	}

	@Override
	public void diminuirMinimo() {
		temperatura = minima;
	}

	public int getTemperatura() {
		return temperatura;
	}
	
}
