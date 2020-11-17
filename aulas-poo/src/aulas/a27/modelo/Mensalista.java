package aulas.a27.modelo;

public final class Mensalista extends Empregado {
	
	private double salarioMensal;

	public Mensalista(String nome, double salarioMensal) {
		super(nome);
		this.salarioMensal = salarioMensal;
	}

	@Override
	public final double getSalarioBruto() {
		return salarioMensal;
	}

	public final double getSalarioMensal() {
		return salarioMensal;
	}
	
}
