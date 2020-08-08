package jogodedados;

import java.util.ArrayList;

public class JogoDeDados {
	private DadoDeJogar dado;
	private int jogadorMaisRecente;
	private int quantidadeRodadas = 1;
	private ArrayList<JogadorDeDados> jogadores = new ArrayList<JogadorDeDados>();

	public JogoDeDados() {
		this.dado = new DadoDeJogar(1, 6);
	}

	public JogoDeDados(DadoDeJogar dado) {
		this.dado = dado;
	}

	public void adicionarJogador(JogadorDeDados jogador) {
		this.jogadores.add(jogador);
	}

	public void setQuantidadeRodadas(int quantidadeRodadas) {
		this.quantidadeRodadas = quantidadeRodadas;
	}

	public JogadorDeDados getVencedor() {
		// TODO Verificar empates 
		int maiorPlacar = 0;
		JogadorDeDados vencedor = null;
		for (JogadorDeDados jogador : jogadores) {
			if (jogador.getPontos() > maiorPlacar) {
				vencedor = jogador;
			}
		}
		return vencedor;
	}

	private void zerarPlacar() {
		for (JogadorDeDados jogador : jogadores) {
			// TODO Como zerar os scores dos jogadores?
		}
	}
	
	public void jogar() {
		zerarPlacar();
		JogadorDeDados jogador;
		int p;
		for (int i = 1; i <= quantidadeRodadas; i++) {
			jogador = proximoJogador();
			while (jogador != null) {
				do {
					p = jogador.lancarDado(dado);
				} while (p == 1 || p == 6);
				jogador = proximoJogador();
			}
		}
	}

	private JogadorDeDados proximoJogador() {
		if (jogadores.size() == 0)
			return null;
		if (jogadorMaisRecente == jogadores.size()) {
			jogadorMaisRecente = 0;
			return null;
		}
		return jogadores.get(jogadorMaisRecente++);
	}
}
