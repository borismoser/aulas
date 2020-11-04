package aulas.a22av2.q2;

public class Loja {
	private String nomeLoja;
	
	public Loja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
	
	public boolean novoProduto(Nacional nacional) {
		return false;
	}
	
	public boolean novoProduto(Importado importado) {
		return false;
	}
	
	public Nacional nacionalMaisCaro() {
		return null;
	}
	
	public Importado importadoMaisBarato() {
		return null;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}
}
