package folhaPagamentoHerancaInterface.classes;

public class Horista implements ModeloPagamento {

	private double salarioHora;
	private double horasTrabalhadas;

	public Horista(double salarioHora, double horasTrabalhadas) {
		this.salarioHora = salarioHora;
		this.horasTrabalhadas = horasTrabalhadas;
	}

	@Override
	public double getSalarioBruto() {
		if (horasTrabalhadas <= 40) {
			return salarioHora * horasTrabalhadas;
		} else {
			return 40 * salarioHora + (horasTrabalhadas - 40) * salarioHora * 1.5;
		}
	}

}
