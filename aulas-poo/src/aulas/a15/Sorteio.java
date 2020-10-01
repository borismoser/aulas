package aulas.a15;

public class Sorteio {

	public static FaceMoeda jogarMoeda() {
		if (Math.random() < 0.5) {
			return FaceMoeda.CARA;
		} else {
			return FaceMoeda.COROA;
		}
	}
}
