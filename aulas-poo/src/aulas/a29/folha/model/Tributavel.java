package aulas.a29.folha.model;

public interface Tributavel {

	public double getImpostoDevido();

	default public double getINSS() {
		return 0;
	}
}
