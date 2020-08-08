package av3.correcao.freitas;

public class Acao {
	
	private String simbolo;
	private String nome;
	
	
	public Acao() {}
	public Acao(String simbolo, String nome) {
		super();
		this.simbolo = simbolo;
		this.nome = nome;
	}
	
	public String getSimbolo() {
		return simbolo;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public String toString() {
		return "Simbolo: " + this.getSimbolo() + " - Nome: " + this.getNome();
	}
}
