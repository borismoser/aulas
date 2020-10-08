package aulas.a18.p4;

public class Pessoa {

	private String nome;
	private int idade;

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public Pessoa(String nome, int idade) {
		this(nome);
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void oi() {
		System.out.println("Olá, eu me chamo " + nome + " e tenho " + idade + " anos.");
	}
}
