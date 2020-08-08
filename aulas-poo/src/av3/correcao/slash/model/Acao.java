package av3.correcao.slash.model;

public class Acao {
	
	private String simbolo;
	private String nome;
	
	public Acao(String simbolo, String nome) {
		this.nome = nome;
		this.simbolo = simbolo;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public String getNome() {
		return nome;
	}



}
