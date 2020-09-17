package aulas.a11av1;

public class Pessoa {
	private String nome;
	private String cpf;
	private int idade;

	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public boolean maiorIdade() {
		return idade >= 18;
	}

	public void anoNascimento(int ano) {
		this.idade = 2020 - ano;
	}

	public String getCpfFormatado() {
		return cpf.substring(0, 3) + "." + //
				cpf.substring(3, 6) + "." + //
				cpf.substring(6, 9) + "-" + //
				cpf.substring(9);
	}
}
