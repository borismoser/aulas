package formasHerancaInterface.classes;

public abstract class Forma {
	private String nome;

	public Forma(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
}
