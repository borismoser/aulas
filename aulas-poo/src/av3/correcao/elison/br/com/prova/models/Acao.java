package av3.correcao.elison.br.com.prova.models;

public class Acao {

    private String simbolo;
    private String nome;

    public Acao(String simbolo, String nome) {
        this.simbolo = simbolo;
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getNome() {
        return nome;
    }
}
