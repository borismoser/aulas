package aulas.a13;

import java.util.ArrayList;
import java.util.Random;

public class ALConcurso {

	private static ArrayList<Integer> sorteio;

	public static ArrayList<Integer> numerosSorteados() {
		if (sorteio == null) {
			sorteio = new ArrayList<>(6);
			Random rd = new Random();
			int num;
			for (int i = 0; i < 6; i++) {
				do {
					num = 1 + rd.nextInt(60);
				} while (sorteio.contains(num));
				sorteio.add(num);
			}
		}
		// retornando uma cópia dos números armazenados internamente:
		return new ArrayList<Integer>(sorteio);
	}

	public static int quantidadeAcertos(ALAposta aposta) {
		int qt = 0;
		for (int s : numerosSorteados()) {
			if (aposta.getNumeros().contains(s)) {
				qt++;
			}
		}
		return qt;
	}
}
