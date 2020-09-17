package aulas.a11av1;

import java.security.SecureRandom;
import java.util.Scanner;

public class JogoDeDados {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);
		int limite;

		do {
			System.out.print("Quantos lançamentos? ");
			limite = ler.nextInt();
		} while (limite < 1 || limite > 150_000);

		SecureRandom sr = new SecureRandom();
		int[] frequencia = new int[6];

		for (int i = 0; i < limite; i++) {
			int res = sr.nextInt(6);
			frequencia[res]++;
		}
		for (int i = 0; i < frequencia.length; i++) {
			System.out.printf("%d: %,7d%n", i + 1, frequencia[i]);
		}

	}

}
