package folhaPagamento.classes;

public class Horista extends Empregado {

	private double salarioHora;
	private double horasTrabalhadas;

	public Horista(String nome, String sobreNome, String cpf, double salarioHora, double horasTrabalhadas) {
		super(nome, sobreNome, cpf);
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
