package aulas.a08;

import java.util.Arrays;

public class VetorUtilMain {

	public static void main(String[] args) {

		long[] v = { 90, 5, 55, 1, 123, -984, 0 };
		long maiorV = VetorUtil.maiorElemento(v);
		System.out.println("Maior elemento no vetor v: " + maiorV);

		double[] w = { 9.123, 5.426, 55.998, 10.0, 123.321, -984.0001, 0.5 };
		double maiorW = VetorUtil.maiorElemento(w);
		System.out.println("Maior elemento no vetor w: " + maiorW);

		String[] palavras = { "um", "dois", "três", "quatro", "Dez" };
		System.out.println("Maior elemento no vetor de palavras: " + //
				VetorUtil.maiorElemento(palavras));

		String txt = "qwertzy";
		char[] letras = txt.toCharArray();
		System.out.println("Maior elemento no vetor de letras: " + //
				VetorUtil.maiorElemento(letras));

		long somaV = VetorUtil.somaVetor(v);
		System.out.println("Soma dos elementos do vetor v: " + somaV);

		double somaW = VetorUtil.somaVetor(w);
		System.out.println("Soma dos elementos do vetor w: " + somaW);

		long[] paresV = VetorUtil.somentePares(v);
		System.out.println("Elementos pares no vetor v: " + Arrays.toString(paresV));

		double[] paresW = VetorUtil.somentePares(w);
		System.out.println("Elementos pares no vetor w: " + Arrays.toString(paresW));

		long[] imparesV = VetorUtil.somenteImpares(v);
		System.out.println("Elementos ímpares no vetor v: " + Arrays.toString(imparesV));

		double[] imparesW = VetorUtil.somenteImpares(w);
		System.out.println("Elementos ímpares no vetor w: " + Arrays.toString(imparesW));

	}

}
