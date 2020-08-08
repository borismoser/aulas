package lista01;

public class Eleicao {
	
	private int totalEleitores;
	private int votosBrancos;
	private int votosNulos;
	private int votosValidos;

	public Eleicao(int totalEleitores, int votosBrancos, int votosNulos, int votosValidos) {
		this.totalEleitores = totalEleitores;
		this.votosBrancos = votosBrancos;
		this.votosNulos = votosNulos;
		this.votosValidos = votosValidos;
	}

	public float getPercentualVotosBrancos() {
		return (float) votosBrancos / totalEleitores * 100;
	}

	public float getPercentualVotosNulos() {
		return (float) votosNulos / totalEleitores * 100;
	}

	public float getPercentualVotosValidos() {
		return (float) votosValidos / totalEleitores * 100;
	}

}