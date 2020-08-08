package av3.correcao.vinicius.Model;

public class Acao {

	private String simbolo;
	private String nome;
	
	public Acao(String simbolo, String nome) {
		this.simbolo = simbolo;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSimbolo() {
		return simbolo;
	}
	
	@Override
	public String toString() {
		return "Simbolo: " + this.simbolo + " Nome: " + this.nome;
	}
}
