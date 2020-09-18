package aulas.a11av1;

public class Estaticos {

	public static int[] vetorInvertido(int[] vetor) {
		int tamanho = vetor.length;
		int[] inv = new int[tamanho];
		for (int i = 0; i < tamanho; i++) {
			inv[i] = vetor[tamanho - 1 - i];
		}
		return inv;
	}

	public static String stringVetor(char[] vetor) {
		int tamanho = vetor.length;
		String saida = "";
		for (int i = 0; i < tamanho; i++) {
			saida += vetor[i];
		}
		return saida;
	}
}
