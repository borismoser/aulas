package bingo2;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class Cartela {

	private ArrayList<Integer> numeros;
	private ArrayList<Integer> acertos;

	public Cartela() {
		this.numeros = new ArrayList<>(25);
		this.acertos = new ArrayList<>(24);
		preencher();
	}

	public Cartela(Cartela original) {
		this.numeros = new ArrayList<>(original.numeros);
		this.acertos = new ArrayList<>(original.acertos);
	}

	private static SecureRandom sr = new SecureRandom();

	private void preencher() {
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

	public String toString() {
		return numeros.toString();
	}

	public ArrayList<Integer> getNumeros() {
		return new ArrayList<>(numeros);
	}

	public int hashCode() {
		return numeros.hashCode();
	}

	public void marcarNumero(int numeroSorteado) {
		if (numeros.contains(numeroSorteado)) {
			acertos.add(numeroSorteado);
		}
	}

	public boolean ehVencedora() {
		return acertos.size() == numeros.size();
	}

	public String getCartelaParaImprimir() {
		ArrayList<Integer> cartela = new ArrayList<Integer>(numeros);
		Collections.sort(cartela);
		cartela.add(12, 0);
		StringBuilder ret = new StringBuilder();
		int[][] cart = new int[5][5];
		for (int i = 0; i < cart.length; i++) {
			for (int j = 0; j < cart[i].length; j++) {
				int numero = cartela.get(i + j * 5);
				cart[i][j] = numero;
				ret.append(String.format("  %02d", numero));
			}
			ret.append(String.format("%n"));
		}
		return ret.toString();
	}

}
