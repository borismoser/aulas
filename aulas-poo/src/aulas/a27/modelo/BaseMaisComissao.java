package aulas.a27.modelo;

public final class BaseMaisComissao extends Comissionado {

	private double salarioBase;

	public BaseMaisComissao(String nome, double vendasBrutas, //
			double percentualComissao, double salarioBase) {
		super(nome, vendasBrutas, percentualComissao);
		this.salarioBase = salarioBase;
	}

	@Override
	public final double getSalarioBruto() {
		return super.getSalarioBruto() + salarioBase;
	}

}
