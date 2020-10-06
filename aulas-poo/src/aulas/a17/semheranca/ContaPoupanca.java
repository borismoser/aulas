package aulas.a17.semheranca;

public class ContaPoupanca {

	private String titular;
	private double saldo = 0.0;
	private int diaAniversario;

	public ContaPoupanca(String titular, int diaAniversario) {
		this.titular = titular;
		this.diaAniversario = diaAniversario;
	}

	public ContaPoupanca(String titular, double saldo, int diaAniversario) {
		this.titular = titular;
		this.diaAniversario = diaAniversario;
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

	public int getDiaAniversario() {
		return diaAniversario;
	}

}
