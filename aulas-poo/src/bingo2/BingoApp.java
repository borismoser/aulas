package bingo2;

import java.util.ArrayList;

public class BingoApp {

	public static void main(String[] args) {

		final int NR_JOGADORES = 150;
		final int NR_CARTELAS = 100;

		Bingo bingo = new Bingo(NR_JOGADORES, NR_CARTELAS);
		bingo.simular();
		int v = bingo.getVencedores().size();
		if (v > 0) {
			System.out.printf("O bingo teve %d vencedor%s.%n", v, v > 1 ? "es" : "");
			System.out.printf("Foram sorteados %d números: %s%n", bingo.getNumerosSorteados().size(),
					bingo.getNumerosSorteados());
			System.out.println("Cartelas Vencedoras:");
			ArrayList<Jogador> vencedores = bingo.getVencedores();
			for (Jogador jog : vencedores) {
				for (Cartela c : jog.getCartelasVencedoras()) {
					System.out.println(c.getCartelaParaImprimir());
				}
			}
		} else {
			System.out.println("Não houve vencedores... ?!");
		}

	}

}
