package aulas.a15;

public enum FaceMoeda {

	CARA("Cara"),
	COROA("Coroa");

	private String nome;
	
	private FaceMoeda(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
