package jogodedados;

public class JogadorDeDados {
	private String nome;
	private int pontos;

	public JogadorDeDados(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int getPontos() {
		return pontos;
	}

	public int lancarDado(DadoDeJogar dado) {
		int res = dado.getFace();
		pontos += res;
		System.out.printf("%s jogou e fez %d pontos. Total: %d%n", nome, res, pontos);
		return res;
	}
}
