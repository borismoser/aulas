package aulas.a18.p2;

public class Pessoa {

	private String nome;
	private int idade;

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void oi() {
		System.out.println("Ol�, eu me chamo " + nome + " e tenho " + idade + " anos.");
	}
}
