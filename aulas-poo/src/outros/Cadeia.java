package outros;

public class Cadeia {
	private String conteudo;
	private int tamanho;
	
	public Cadeia(String conteudo) {
		this.conteudo = conteudo;
		this.tamanho = conteudo.length();
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public int tamanho() {
		return this.tamanho;
	}
	
	@Override
	public String toString() {
		return this.conteudo;
	}
}
