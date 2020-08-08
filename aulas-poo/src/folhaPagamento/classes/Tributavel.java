package folhaPagamento.classes;

public interface Tributavel {

	public double getImpostoDevido();
	
	default public double getINSS() {
		return 0;
	}
}
