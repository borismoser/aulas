package bingo3;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Cartela {

	private final List<Integer> numeros;
	private final Set<Integer> dezenas;
	private final List<Integer> acertos;

	public Cartela() {
		this.numeros = new ArrayList<>(25);
		this.acertos = new ArrayList<>(24);
		this.dezenas = new TreeSet<>();
		preencher();
	}

	public Cartela(Cartela original) {
		this.numeros = new ArrayList<>(original.numeros);
		this.acertos = new ArrayList<>(original.acertos);
		this.dezenas = new TreeSet<>(original.dezenas);
	}

	private static SecureRandom sr = new SecureRandom();

	private void preencher() {
		int n;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				do {
					n = sorteia(i);
				} while (numeros.contains(n));
				numeros.add(n);
			}
		}
		numeros.remove(12);
		dezenas.addAll(numeros);
	}
	
	private int sorteia(int faixa) {
		return (15 * faixa) + 1 + sr.nextInt(15);
	}

	public String toString() {
		return numeros.toString();
		//return dezenas.toString();
	}

	public List<Integer> getNumeros() {
		return Collections.unmodifiableList(numeros);
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

	public String cartelaParaImprimir() {
		List<Integer> cartela = new ArrayList<Integer>(numeros);
		Collections.sort(cartela);
		cartela.add(12, 0);
		StringBuilder ret = new StringBuilder();
		int[][] cart = new int[5][5];
		for (int i = 0; i < cart.length; i++) {
			for (int j = 0; j < cart[i].length; j++) {
				if (i == 2 && j == 2) {
					ret.append("    ");
				} else {
					int numero = cartela.get(i + j * 5);
					cart[i][j] = numero;
					ret.append(String.format("  %02d", numero));
				}
			}
			ret.append(String.format("%n"));
		}
		return ret.toString();
	}

}
