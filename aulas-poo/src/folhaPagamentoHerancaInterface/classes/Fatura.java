package folhaPagamentoHerancaInterface.classes;

public class Fatura implements Pagavel {

	private String codigoItem;
	private int quantidade;
	private double valorItem;

	private Fatura() {
		System.out.println("construtor privado...");
	}

	public Fatura(String codigoItem, int quantidade, double valorItem) {
		this();
		this.codigoItem = codigoItem;
		this.quantidade = quantidade;
		this.valorItem = valorItem;
	}

	@Override
	public double getTotalDevido() {
		return quantidade * valorItem;
	}

	@Override
	public String toString() {
		return codigoItem;
	}

}
