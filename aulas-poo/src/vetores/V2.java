package vetores;

import java.util.Arrays;

public class V2 {

	public static void main(String[] args) {
		int[] x = new int[12];
		for (int i = 0; i < x.length; i++) {
			x[i] = (int) (Math.random() * 100);
		}
		mostrarVetor(x);
		mostrarVetor(vetorOrdenado(x));
		mostrarVetor(x);

		Arrays.sort(x);
		mostrarVetor(x);
		
		Arrays.fill(x, 0);
		mostrarVetor(x);
	}

	private static void mostrarVetor(int[] v) {
		for (int n : v) {
			System.out.printf("%5d", n);
		}
		System.out.println();
	}
	private static int[] vetorOrdenado(int[] v) {
		int[] w = v.clone();
		Arrays.sort(w);
		return w;
	}

}
