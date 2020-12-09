package aulas.a32av3.qx;

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
		// TODO Auto-generated method stub
		return null;
	}

}
