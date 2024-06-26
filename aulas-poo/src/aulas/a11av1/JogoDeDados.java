package aulas.a11av1;

import java.util.Random;
import java.util.Scanner;

public class JogoDeDados {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);
		int limite;

		do {
			System.out.print("Quantos lanšamentos? ");
			limite = ler.nextInt();
		} while (limite < 1 || limite > 150_000);

		Random sr = new Random();
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
