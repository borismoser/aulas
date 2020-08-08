package bingoaula;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Cartela {

	private ArrayList<Integer> numeros;

	public Cartela() {
		this.numeros = new ArrayList<>(25);
		preencher();
	}

	private void preencher() {
		SecureRandom sr = new SecureRandom();
		int n;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				do {
					n = (15 * i) + 1 + sr.nextInt(15);
				} while (numeros.contains(n));
				numeros.add(n);
			}
		}
		numeros.remove(12);
	}
	
	public ArrayList<Integer> getNumeros() {
		return numeros;
	}
	
	public String toString() {
		return numeros.toString();
	}

}
