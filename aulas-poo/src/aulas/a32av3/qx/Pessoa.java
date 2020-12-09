package aulas.a32av3.qx;

public abstract class Pessoa {

	private String nome;
	private int idade;

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public final String getNome() {
		return nome;
	}

	public final int getIdade() {
		return idade;
	}

}
