package aulas.a32av3.gabarito.q2;

public class Arquivo implements Imprimivel {

	private String nomeArquivo;
	private String conteudo;

	public Arquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String formatoImpressao() {
		return getConteudo();
	}

}
