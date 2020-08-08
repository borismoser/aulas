package exame.heranca;

import java.time.LocalDate;

public class ContaAgua extends Conta {

	private double metrosCubicos;

	public ContaAgua(LocalDate vencimento, double valorDevido, double metrosCubicos) {
		super(vencimento, valorDevido);
		this.metrosCubicos = metrosCubicos;
	}

	@Override
	public void imprimir() {
		System.out.println("Conta de Água");
		System.out.println("Vencimento: " + this.getVencimento());
		System.out.println("Consumo: " + this.metrosCubicos + " metros cúbicos");
		System.out.println("Valor a pagar: R$ " + this.getValorDevido());
	}
}
