package aulas.a31.classes;

public class SecadorCabelo implements ControleTemperatura {

	private Temp posicao;

	private enum Temp {
		BAIXO, MEDIO, ALTO;
	}

	public SecadorCabelo() {
		posicao = Temp.BAIXO;
	}

	@Override
	public void aumentarTemperatura() {
		switch (posicao) {
		case BAIXO:
			posicao = Temp.MEDIO;
			break;
		case MEDIO:
			posicao = Temp.ALTO;
			break;
		default:
		}
	}

	@Override
	public void diminuirTemperatura() {
		switch (posicao) {
		case ALTO:
			posicao = Temp.MEDIO;
			break;
		case MEDIO:
			posicao = Temp.BAIXO;
			break;
		default:
		}
	}

	@Override
	public void aumentarMaximo() {
		posicao = Temp.ALTO;
	}

	@Override
	public void diminuirMinimo() {
		posicao = Temp.BAIXO;
	}

	public Temp getPosicao() {
		return posicao;
	}

}
