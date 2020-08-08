package formasHeranca.classes;

public abstract class Forma {
	private String nome;

	public Forma(String nome) {
		this.nome = nome;
	}

	public final String getNome() {
		return this.nome;
	}
}
