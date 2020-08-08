package exame.heranca;

import java.time.LocalDate;

public abstract class Conta implements Impressao {

	private LocalDate vencimento;
	private double valorDevido;

	public Conta(LocalDate vencimento, double valorDevido) {
		this.vencimento = vencimento;
		this.valorDevido = valorDevido;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public double getValorDevido() {
		return valorDevido;
	}

}
