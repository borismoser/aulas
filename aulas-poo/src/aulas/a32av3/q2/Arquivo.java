package aulas.a32av3.q2;

public class Arquivo implements Imprimivel {

    private String nomeArquivo = "";
    private String conteudo = "";

    public Arquivo(String nome) {
                this.nomeArquivo = nome;
    }

    public String getNomeArquivo() {
        return this.nomeArquivo;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String formatoImpressao() {
        return this.conteudo;
    }
}
