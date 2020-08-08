package folhaPagamentoHerancaInterface.classes;

public class Comissionado implements ModeloPagamento {

	private double vendasBrutas;
	private double percentualComissao;

	public Comissionado(double vendasBrutas, double percentualComissao) {
		this.vendasBrutas = vendasBrutas;
		this.percentualComissao = percentualComissao;
	}

	@Override
	public double getSalarioBruto() {
		return vendasBrutas * percentualComissao;
	}

}
