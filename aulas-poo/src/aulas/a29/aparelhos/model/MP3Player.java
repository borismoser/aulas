package aulas.a29.aparelhos.model;

public class MP3Player extends Aparelho implements ControlarReproducao {

	private int capacidade;
	
	public MP3Player(String marca, String modelo) {
		super(marca, modelo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	public int getCapacidade() {
		return capacidade;
	}

}
