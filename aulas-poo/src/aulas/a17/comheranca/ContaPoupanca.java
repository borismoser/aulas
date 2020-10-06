package aulas.a17.comheranca;

public class ContaPoupanca extends Conta {

	private int diaAniversario;

	public ContaPoupanca(String titular, int diaAniversario) {
		super(titular);
		this.diaAniversario = diaAniversario;
	}

	public ContaPoupanca(String titular, double saldo, int diaAniversario) {
		super(titular, saldo);
		this.diaAniversario = diaAniversario;
	}

	public int getDiaAniversario() {
		return diaAniversario;
	}

}
