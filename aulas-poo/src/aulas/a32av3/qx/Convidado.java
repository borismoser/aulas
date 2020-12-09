package aulas.a32av3.qx;

public class Convidado extends Pessoa {

	private TemaFantasia tema;

	public Convidado(String nome, int idade, TemaFantasia tema) {
		super(nome, idade);
		this.tema = tema;
	}

	public final TemaFantasia getTema() {
		return tema;
	}

}