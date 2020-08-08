package folhaPagamento.classes;

public interface TributavelSC extends Tributavel {

	public static String ESTADO = "SC";
	
	public static String getEstado() {
		return "Santa Catarina";
	}
	
	public double getImpostoCatarinense();
}
