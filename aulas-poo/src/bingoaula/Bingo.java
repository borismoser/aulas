package bingoaula;

import java.util.ArrayList;

public class Bingo {

	private ArrayList<Jogador> jogadores;
	private ArrayList<Integer> idCartelasBingo;

	public Bingo(int qtJog, int qtCart) {
		this.jogadores = new ArrayList<>(qtJog);
		this.idCartelasBingo = new ArrayList<>(qtJog);
		for (int j = 0; j < qtJog; j++) {
			Jogador jogador;
			boolean jaExiste;
			do {
				jogador = new Jogador(qtCart);
				jaExiste = false;
				for (Integer i : jogador.getIdCartelasJogador()) {
					if (idCartelasBingo.contains(i)) {
						jaExiste = true;
					}
				}
			} while (jaExiste);
			jogadores.add(jogador);
			idCartelasBingo.addAll(jogador.getIdCartelasJogador());
		}
	}
}
