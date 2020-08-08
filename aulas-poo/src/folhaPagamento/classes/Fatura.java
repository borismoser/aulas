package folhaPagamento.classes;

public class Fatura implements Pagavel, Tributavel {

	private String codigoItem;
	private int quantidade;
	private double valorItem;

	private Fatura() {
		System.out.println("chegou aqui...");
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
	
	public String getCodigoItem() {
		return codigoItem;
	}

	@Override
	public double getImpostoDevido() {
		return this.getTotalDevido() * 0.33;
	}

}
