package aulas.a29.folha.model;

public class Mensalista extends Empregado {

	private double salarioMensal;

	public Mensalista(String nome, String sobreNome, String cpf, double salarioMensal) {
		super(nome, sobreNome, cpf);
		this.salarioMensal = salarioMensal;
	}

	@Override
	public double getSalarioBruto() {
		return salarioMensal;
	}

	public double getSalarioMensal() {
		return salarioMensal;
	}

}
