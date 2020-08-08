package jogodedados;

public class JogoDeDadosMain {

	public static void main(String[] args) {


		//DadoDeJogar dado = new DadoDeJogar(10, 60);
		//JogoDeDados jogo = new JogoDeDados(dado, jog1, jog2);
		JogoDeDados jogo = new JogoDeDados();
		jogo.adicionarJogador(new JogadorDeDados("Hulk"));
		jogo.adicionarJogador(new JogadorDeDados("Thor"));
		jogo.adicionarJogador(new JogadorDeDados("IronMan"));
		jogo.setQuantidadeRodadas(3);
		jogo.jogar();

		JogadorDeDados vencedor = jogo.getVencedor();
		if (vencedor != null) {
			System.out.println("Vencedor: " + vencedor.getNome());
		} else {
			System.out.println("O jogo terminou empatado.");
		}
	}

}
