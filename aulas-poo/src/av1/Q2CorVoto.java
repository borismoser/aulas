package av1;

public class Q2CorVoto {
	private String cor;
	private int votos;

	public Q2CorVoto(String cor) {
		this.cor = cor;
		this.votos = 0;
	}
	public void computarVoto() {
		votos++;
	}
	public String getCor() {
		return cor;
	}
	public int getVotos() {
		return votos;
	}
	
}
