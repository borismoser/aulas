package av2;

public class Pessoa {
	private String nome;
	private String telefone;
	private Sexo sexo;

	public Pessoa(String nome, String telefone, Sexo sexo) {
		this.nome = nome;
		this.telefone = telefone;
		this.sexo = sexo;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public String getNome() {
		return nome;
	}
}
