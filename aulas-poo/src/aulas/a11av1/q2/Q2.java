package aulas.a11av1.q2;

public class Q2 {

	public static void main(String[] args) {
		int[] v = { 9, 5, 3, 7 };

		inverter(v);
		mostrarVetorFinal(v);

	}

	private static void mostrarVetorFinal(int[] v) {
		for (int j : v) {
			System.out.print(j + " ");
		}
	}

	private static void inverter(int[] v) {
		int i = 0;
		int f = v.length - 1;

		while (i < f) {
			mudarPosicao(v, i, f);
			i++;
			f--;
		}
	}

	private static void mudarPosicao(int[] v, int i, int f) {
		int contador = v[i];
		v[i] = v[f];
		v[f] = contador;
	}
}
