package aulas.a05;

import java.util.Arrays;

public class MetodosParametrosArrays {

	public static void main(String[] args) {

		int[] x = new int[12];
		inicializarVetorAleatorio(x);

		System.out.println("Array inicializado:");
		mostrarVetor(x);

		System.out.println("\nArray ordenado:");
		mostrarVetor(vetorOrdenado(x));

		System.out.println("\nArray original:");
		mostrarVetor(x);

		// declaração de uma matrix 3x4
		int[][] m = new int[3][4];
		preencherMatrizAleatoria(m);
		
		System.out.println("\nMatriz:");
		mostrarMatrizTabela(m);
	}

	// Parâmetros array não indicam o tamanho das dimensões.
	// O verificação é feita pela propriedade 'length'.

	// O vetor recebido como parâmetro é alterado e tal
	// alteração é visível no escopo externo ao método.
	// Isso acontece porque o parâmetro recebido é uma referência
	// ao vetor original. O vetor não é copiado, apenas a referência.

	private static void inicializarVetorAleatorio(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
	}

	private static void mostrarVetor(int[] v) {
		for (int n : v) {
			System.out.printf("%5d", n);
		}
		System.out.println();
	}

	// Um método pode retornar um novo array.
	// Observe a declaração do tipo antes do nome.

	private static int[] vetorOrdenado(int[] v) {
		int[] w = Arrays.copyOf(v, v.length);
		Arrays.sort(w);
		return w;
	}

	private static void preencherMatrizAleatoria(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (int) (Math.random() * 100);
			}
		}
	}

	private static void mostrarMatrizTabela(int[][] w) {
		System.out.println("--------------------");
		for (int i = 0; i < w.length; i++) {
			for (int j = 0; j < w[i].length; j++) {
				System.out.printf("%5d", w[i][j]);
			}
			System.out.println();
		}
	}

}
