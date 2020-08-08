package controleRemoto.classes.tv;

public abstract class TV implements ITV {

	private String serial;
	private boolean ligado;
	private int volumeAtual;
	private int canalAtual;

	private int volumeAnterior;

	private final int maxVolume;
	private final int minCanal;
	private final int maxCanal;

	public TV(int maxVolume, int minCanal, int maxCanal) {
		this.maxVolume = maxVolume;
		this.minCanal = minCanal;
		this.maxCanal = maxCanal;
		this.ligado = false;
		this.volumeAtual = maxVolume / 2;
		this.canalAtual = minCanal;
		this.volumeAnterior = 0;
		long x = Math.round(Math.random() * 1000000);
		serial = Long.toHexString(x);
		System.out.println("Nova TV: " + this);
	}

	public String getSerial() {
		return serial;
	}

	@Override
	public void ligarDesligar() {
		ligado = !ligado;
	}

	@Override
	public void aumentarVolume() {
		if (ligado && (volumeAtual < maxVolume)) {
			volumeAtual++;
		}
	}

	@Override
	public void diminuirVolume() {
		if (ligado && (volumeAtual > 0)) {
			volumeAtual--;
		}
	}

	@Override
	public void aumentarCanal() {
		if (ligado) {
			if (canalAtual < maxCanal) {
				canalAtual++;
			} else {
				canalAtual = minCanal;
			}
		}
	}

	@Override
	public void diminuirCanal() {
		if (ligado) {
			if (canalAtual > minCanal) {
				canalAtual--;
			} else {
				canalAtual = maxCanal;
			}
		}
	}

	@Override
	public void comSomSemSom() {
		if (ligado) {
			if (volumeAtual > 0) {
				volumeAnterior = volumeAtual;
				volumeAtual = 0;
			} else {
				volumeAtual = volumeAnterior;
			}
		}
	}

	@Override
	public String toString() {
		return this.getClass().toString();
	}

}
