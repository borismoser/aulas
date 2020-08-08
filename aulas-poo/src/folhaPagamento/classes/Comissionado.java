package folhaPagamento.classes;

public class Comissionado extends Empregado {

	private double vendasBrutas;
	private double percentualComissao;

	public Comissionado(String nome, String sobreNome, String cpf, //
			double vendasBrutas, double percentualComissao) {
		super(nome, sobreNome, cpf);
		this.vendasBrutas = vendasBrutas;
		this.percentualComissao = percentualComissao;
	}

	@Override
	public double getSalarioBruto() {
		return vendasBrutas * percentualComissao;
	}

}
