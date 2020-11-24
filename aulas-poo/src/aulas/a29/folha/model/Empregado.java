package aulas.a29.folha.model;

public abstract class Empregado implements Pagavel, Tributavel {
	private String nome;
	private String sobreNome;
	private String cpf;

	public Empregado(String nome, String sobreNome, String cpf) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
	}

	public final String getNome() {
		return nome;
	}

	public final String getSobreNome() {
		return sobreNome;
	}

	public final String getCpf() {
		return cpf;
	}

	public abstract double getSalarioBruto();

	@Override
	public final double getTotalDevido() {
		return this.getSalarioBruto() - getImpostoDevido() - getINSS();
	}

	@Override
	public double getImpostoDevido() {
		return this.getSalarioBruto() * 0.2;
	}

	@Override
	public double getINSS() {
		return this.getSalarioBruto() * 0.085;
	}

}
