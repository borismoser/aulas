package aulas.a32av3.q2;

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
		// TODO Auto-generated method stub
		return null;
	}

}
