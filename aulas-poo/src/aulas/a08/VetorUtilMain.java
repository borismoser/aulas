package aulas.a08;

import java.util.Arrays;

public class VetorUtilMain {

	public static void main(String[] args) {

		long[] v = { 90, 5, 55, 1, -123, 984, 0 };
		System.out.println("Vetor v = " + Arrays.toString(v));
		long maiorV = VetorUtil.maiorElemento(v);
		System.out.println("Maior elemento no vetor v: " + maiorV);

		double[] w = { 9.123, 5.426, 55.998, 10.0, 123.321, -984.0001, 0.5 };
		System.out.println("\nVetor w = " + Arrays.toString(w));
		double maiorW = VetorUtil.maiorElemento(w);
		System.out.println("Maior elemento no vetor w: " + maiorW);

		String[] palavras = { "um", "dois", "três", "quatro", "Dez" };
		System.out.println("\nVetor de palavras = " + Arrays.toString(palavras));
		System.out.println("Maior elemento no vetor de palavras: " + //
				VetorUtil.maiorElemento(palavras));

		String txt = "qwertzy";
		char[] letras = txt.toCharArray();
		System.out.println("\nVetor de caracteres = " + Arrays.toString(letras));
		System.out.println("Maior elemento no vetor de letras: " + //
				VetorUtil.maiorElemento(letras));

		long somaV = VetorUtil.somaVetor(v);
		System.out.println("\nSoma dos elementos do vetor v: " + somaV);

		double somaW = VetorUtil.somaVetor(w);
		System.out.println("\nSoma dos elementos do vetor w: " + somaW);

		long[] paresV = VetorUtil.somentePares(v);
		System.out.println("\nElementos pares no vetor v: " + Arrays.toString(paresV));

		double[] paresW = VetorUtil.somentePares(w);
		System.out.println("\nElementos pares no vetor w: " + Arrays.toString(paresW));

		long[] imparesV = VetorUtil.somenteImpares(v);
		System.out.println("\nElementos ímpares no vetor v: " + Arrays.toString(imparesV));

		double[] imparesW = VetorUtil.somenteImpares(w);
		System.out.println("\nElementos ímpares no vetor w: " + Arrays.toString(imparesW));

		int pos = VetorUtil.posicaoMaiorElemento(v);
		System.out.println("Índice do maior elemento no vetor v: " + pos);

		pos = VetorUtil.posicaoMaiorElemento(w);
		System.out.println("Índice do maior elemento no vetor w: " + pos);
		
		pos = VetorUtil.posicaoMaiorElemento(palavras);
		System.out.println("Índice do maior elemento no vetor de palavras: " + pos);
		
		pos = VetorUtil.posicaoMaiorElemento(letras);
		System.out.println("Índice do maior elemento no vetor de letras: " + pos);
		
	}

}
