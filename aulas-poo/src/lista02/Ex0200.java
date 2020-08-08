package lista02;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Ex0200 {

	private static SecureRandom sr = new SecureRandom();

	public static void sorteiaVetor(int[] vetor, int inicio, int fim) {
		int escala = fim - inicio + 1;
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = inicio + sr.nextInt(escala);
		}
	}
	
	public static void sorteiaLista(ArrayList<Integer> lista, int quantidade, int inicio, int fim) {
		int escala = fim - inicio + 1;
		for (int i = 0; i < quantidade; i++) {
			lista.add(inicio + sr.nextInt(escala));
		}
	}
	
}
