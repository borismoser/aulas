package bingo;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class CartelaDeBingo {

	private ArrayList<Integer> numeros;

	private static final int quantidadeNumerosCartela = 25;

	public CartelaDeBingo() {
		this.numeros = new ArrayList<>(quantidadeNumerosCartela);
		preencher(numeros);
	}

	public boolean ehVencedora(ArrayList<Integer> numerosSorteados) {
		return numerosSorteados.containsAll(this.numeros);
	}

	public String toString() {
		return numeros.toString();
	}
	
	public int hashCode() {
		return this.numeros.hashCode();
	}

	private static void preencher(ArrayList<Integer> lista) {
		int n;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				do {
					n = (15 * i + 1);
					n = sortearNumero(n, n + 14);
				} while (lista.contains(n));
				lista.add(n);
			}
		}
		Collections.sort(lista);
		lista.remove(12);
	}

	private static SecureRandom sr = new SecureRandom();

	private static int sortearNumero(int inicio, int fim) {
		int escala = fim - inicio + 1;
		return inicio + sr.nextInt(escala);
	}

}
