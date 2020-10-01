package aulas.a16;

public class Autor {

	private String nome;
	private String sobrenome;

	public Autor(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	@Override
	public String toString() {
		return String.format("%s, %s", getSobrenome(), getNome());
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

}
