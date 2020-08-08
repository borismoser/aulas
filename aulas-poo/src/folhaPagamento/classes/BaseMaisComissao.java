package folhaPagamento.classes;

public class BaseMaisComissao extends Comissionado {

	private double salarioBase;

	public BaseMaisComissao(String nome, String sobreNome, String cpf, //
			double vendasBrutas, double percentualComissao, double salarioBase) {
		super(nome, sobreNome, cpf, vendasBrutas, percentualComissao);
		this.salarioBase = salarioBase;
	}

	@Override
	public double getSalarioBruto() {
		return super.getSalarioBruto() + salarioBase;
	}

}
