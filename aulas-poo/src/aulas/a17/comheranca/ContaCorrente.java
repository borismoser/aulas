package aulas.a17.comheranca;

public class ContaCorrente extends Conta {

	private double limite = 0.0;

	public ContaCorrente(String titular) {
		super(titular);
	}

	public ContaCorrente(String titular, double saldo) {
		super(titular, saldo);
	}

	@Override
	public void sacar(double valor) {
		if (this.getSaldo() - valor >= this.limite) {
			super.sacar(valor);
		}
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

}
