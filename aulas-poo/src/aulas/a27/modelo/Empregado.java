package aulas.a27.modelo;

public abstract class Empregado {
	private String nome;

	public Empregado(String nome) {
		this.nome = nome;
	}

	public final String getNome() {
		return nome;
	}

	public final double getSalarioLiquido() {
		return this.getSalarioBruto() - this.getImpostoDevido() - this.getINSS();
	}

	public final double getImpostoDevido() {
		return this.getSalarioBruto() * 0.2;
	}

	public final double getINSS() {
		return this.getSalarioBruto() * 0.085;
	}

	public abstract double getSalarioBruto();

}
