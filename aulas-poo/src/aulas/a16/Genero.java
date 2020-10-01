package aulas.a16;

public enum Genero {

	FICCAO("Ficção"),
	TERROR("Terror"),
	CONTO("Conto"),
	TECNICO("Técnico");
	
	private String descricao;

	private Genero(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}
}
