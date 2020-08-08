package folhaPagamentoHerancaInterface.classes;

public class Mensalista implements ModeloPagamento {

	private double salarioMensal;

	public Mensalista(double salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

	@Override
	public double getSalarioBruto() {
		return salarioMensal;
	}

}
