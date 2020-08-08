package exame.vetores;

import java.util.Arrays;
import java.util.Random;

public class Vetores {

	public static void main(String[] args) {
		int[] v1 = { 1, 2, 3, 4, 5 };
		analisarVetor(v1);

		int[] v2 = { 9, 8, 7, 5, 1, 0 };
		analisarVetor(v2);

		Random r = new Random();
		int[] v3 = r.ints(10, 1, 100).toArray();
		analisarVetor(v3);
	}

/*
	Desenvolva o método abaixo de forma que sejam exibidas as seguintes informações sobre cada vetor analisado:
		a) Soma dos valores do vetor;
		b) Média dos valores do vetor;
		c) Quantidade de elementos acima da média dos valores do vetor;
		d) Quantidade de elementos abaixo da média dos valores do vetor.
*/

	private static void analisarVetor(int[] vetor) {
		System.out.println("Analisando vetor: " + Arrays.toString(vetor));
		int soma = 0;
		double media = 0.0;
		int acima = 0;
		int abaixo = 0;

		// desenvolver o método...

		System.out.println("Soma dos valores do vetor: " + soma);
		System.out.println("Média dos valores do vetor: " + media);
		System.out.println("Quantidade de elementos acima da média: " + acima);
		System.out.println("Quantidade de elementos abaixo da média: " + abaixo);
	}
}
