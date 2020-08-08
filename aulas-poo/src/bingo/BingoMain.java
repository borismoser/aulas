package bingo;

import java.security.SecureRandom;
import java.time.LocalTime;
import java.util.ArrayList;

public class BingoMain {

	public static void main(String[] args) {

		final int numeroJogadores = 50;
		final int numeroCartelas = 10;

		ArrayList<Integer> idCartelas = new ArrayList<>(numeroJogadores * numeroCartelas);
		ArrayList<JogadorDeBingo> jogadores = new ArrayList<>(numeroJogadores);

		JogadorDeBingo jog;
		CartelaDeBingo cart;

		System.out.println(LocalTime.now());

		for (int i = 0; i < numeroJogadores; i++) {
			jog = new JogadorDeBingo(numeroCartelas);
			jogadores.add(jog);
			for (int j = 0; j < numeroCartelas; j++) {
				do {
					cart = new CartelaDeBingo();
				} while (idCartelas.contains(cart.hashCode()));
				idCartelas.add(cart.hashCode());
				jog.getCartelas().add(cart);
			}
		}

		ArrayList<Integer> globo = new ArrayList<>(75);
		for (int i = 0; i < 75; i++) {
			globo.add(i + 1);
		}

		SecureRandom sr = new SecureRandom();
		ArrayList<Integer> sorteio = new ArrayList<>(75);
		int n;
		for (int i = 0; i < 24; i++) {
			n = sr.nextInt(globo.size());
			sorteio.add(globo.get(n));
			globo.remove(n);
		}

		while ((!temVencedor(jogadores, sorteio)) && (globo.size() > 0)) {
			n = sr.nextInt(globo.size());
			sorteio.add(globo.get(n));
			globo.remove(n);
		}
		System.out.println("Números sorteados: " + sorteio.size());
		System.out.println(sorteio);
		System.out.println(LocalTime.now());
	}

	private static boolean temVencedor(ArrayList<JogadorDeBingo> jogadores, ArrayList<Integer> sorteio) {
		boolean vencedor = false;
		for (JogadorDeBingo jog : jogadores) {
			for (CartelaDeBingo cart : jog.getCartelas()) {
				if (cart.ehVencedora(sorteio)) {
					vencedor = true;
					System.out.println(cart);
				}
			}
		}
		return vencedor;
	}

}
