package aulas.a29.folha.model;

public class Fatura implements Pagavel, Tributavel {

	private String codigoItem;
	private int quantidade;
	private double valorItem;

	public Fatura(String codigoItem, int quantidade, double valorItem) {
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
