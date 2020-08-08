package exame.heranca;

import java.time.LocalDate;

public class ContaEletricidade extends Conta {

	private double kilowatts;

	public ContaEletricidade(LocalDate vencimento, double valorDevido, double kilowatts) {
		super(vencimento, valorDevido);
		this.kilowatts = kilowatts;
	}

	@Override
	public void imprimir() {
		System.out.println("Conta de Eletricidade");
		System.out.println("Vencimento: " + this.getVencimento());
		System.out.println("Consumo: " + this.kilowatts + " kw");
		System.out.println("Valor a pagar: R$ " + this.getValorDevido());
	}
}