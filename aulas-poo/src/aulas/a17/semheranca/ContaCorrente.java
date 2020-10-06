package aulas.a17.semheranca;

public class ContaCorrente {

	private String titular;
	private double saldo = 0.0;
	private double limite = 0.0;

	public ContaCorrente(String titular) {
		this.titular = titular;
	}

	public ContaCorrente(String titular, double saldo) {
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
			if (this.saldo - valor >= this.limite) {
				this.saldo -= valor;
			}
		}
	}

	private boolean valorValido(double valor) {
		return valor > 0.0;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		if (limite <= 0) {
			this.limite = limite;
		}
	}
}
