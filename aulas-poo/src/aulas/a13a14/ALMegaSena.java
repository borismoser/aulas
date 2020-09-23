package aulas.a13a14;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ALMegaSena {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);
		int qtApostas;

		do {
			System.out.print("Quantas apostas? ");
			qtApostas = ler.nextInt();
		} while (qtApostas < 1);

		int qt;
		ALAposta ap;
		Random rd = new Random();

		// lista contendo todas as apostas simuladas:
		ArrayList<ALAposta> apostas = new ArrayList<>(qtApostas);
		for (int i = 0; i < qtApostas; i++) {
			qt = 6 + rd.nextInt(10);
			ap = new ALAposta("Aposta " + i + "/" + qt, qt);
			apostas.add(ap);
		}

		// Sorteia e exibe o resultado oficial do concurso:
		System.out.println("Números sorteados: " + ALConcurso.numerosSorteados());
		System.out.println();

		int[] resumo = new int[3]; // Totais por quantidade de acertos

		// apuração dos resultados:
		for (ALAposta a : apostas) {
			qt = ALConcurso.quantidadeAcertos(a);
			if (qt >= 4) {
				// Imprimindo as apostas que fizeram pelo menos uma quadra:
				System.out.println("" + qt + " acertos: " + a);
				// Acumulando o total por quantidade de acertos:
				resumo[qt - 4]++;
			}
		}
		System.out.println();
		System.out.println("4 acertos: " + resumo[0] + " apostadores.");
		System.out.println("5 acertos: " + resumo[1] + " apostadores.");
		System.out.println("6 acertos: " + resumo[2] + " apostadores.");

	}

}
