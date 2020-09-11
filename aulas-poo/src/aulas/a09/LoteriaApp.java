package aulas.a09;

import java.util.Random;

public class LoteriaApp {

	public static void main(String[] args) {

		final int QT_APOSTAS = 500;

		Aposta[] apostas = new Aposta[QT_APOSTAS];

		Random rd = new Random();

		int n;
		for (int i = 0; i < QT_APOSTAS; i++) {
			n = 6 + rd.nextInt(10);
			apostas[i] = new Aposta("Apostador " + i + "/" + n, n);
		}

		int[] resumo = new int[3];
		Aposta ap;
		for (int i = 0; i < QT_APOSTAS; i++) {
			ap = apostas[i];
			n = Concurso.acertos(ap, Concurso.resultado());
			if (n >= 4) {
				System.out.println(ap.getNome() + " = " + n + " acertos.");
				resumo[n - 4]++;
			}
		}

		System.out.println("4 acertos: " + resumo[0] + " apostadores.");
		System.out.println("5 acertos: " + resumo[1] + " apostadores.");
		System.out.println("6 acertos: " + resumo[2] + " apostadores.");

	}

}
