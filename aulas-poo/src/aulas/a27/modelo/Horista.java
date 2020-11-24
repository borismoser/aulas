package aulas.a27.modelo;

public final class Horista extends Empregado {

	private double salarioHora;
	private double horasTrabalhadas;

	public Horista(String nome, double salarioHora, double horasTrabalhadas) {
		super(nome);
		this.salarioHora = salarioHora;
		this.horasTrabalhadas = horasTrabalhadas;
	}

	@Override
	public final double getSalarioBruto() {
		if (horasTrabalhadas <= 40) {
			return salarioHora * horasTrabalhadas;
		} else {
			return (40 * salarioHora) + ((horasTrabalhadas - 40) * salarioHora * 1.5);
		}
	}

}
