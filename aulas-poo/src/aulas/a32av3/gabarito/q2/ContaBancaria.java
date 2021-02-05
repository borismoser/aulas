package aulas.a32av3.gabarito.q2;

public class ContaBancaria implements Imprimivel{

	private String titular;
	private double saldo;

	public ContaBancaria(String titular, double saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String formatoImpressao() {
		return String.format("Nome: %s. Saldo: R$ %,5.2f", getTitular(), getSaldo());
	}

}
