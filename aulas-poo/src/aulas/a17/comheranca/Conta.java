package aulas.a17.comheranca;

public class Conta {

	private String titular;
	private double saldo = 0.0;

	public Conta(String titular) {
		this.titular = titular;
	}

	public Conta(String titular, double saldo) {
		this.titular = titular;
		if (valorValido(saldo)) {
			this.saldo = saldo;
		}
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void depositar(double valor) {
		if (valorValido(valor)) {
			this.saldo += valor;
		}
	}

	public void sacar(double valor) {
		if (valorValido(valor)) {
			this.saldo -= valor;
		}
	}

	private boolean valorValido(double valor) {
		return valor > 0.0;
	}

}
