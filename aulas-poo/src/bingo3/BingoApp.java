package bingo3;

import java.util.List;

public class BingoApp {

	public static void main(String[] args) {

		final int NR_JOGADORES = 15;
		final int NR_CARTELAS = 10;
		
		Cartela cc = new Cartela();
		System.out.println(cc);
		System.exit(0);
		
		Bingo bingo = new Bingo(NR_JOGADORES, NR_CARTELAS);
		bingo.simular();
		int v = bingo.getVencedores().size();
		if (v > 0) {
			System.out.printf("O bingo teve %d vencedor%s.%n", v, v > 1 ? "es" : "");
			System.out.printf("Foram sorteados %d números: %s%n", bingo.getNumerosSorteados().size(),
					bingo.getNumerosSorteados());
			System.out.println("Cartelas Vencedoras:");
			List<Jogador> vencedores = bingo.getVencedores();
			for (Jogador jog : vencedores) {
				for (Cartela c : jog.getCartelasVencedoras()) {
					System.out.println(c.cartelaParaImprimir());
				}
			}
		} else {
			System.out.println("Não houve vencedores... ?!");
		}

	}

}
