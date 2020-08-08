package lista02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ex0201a05 {

	public static void main(String[] args) {

		exercicios1a5comArrays();

		outrosMetodosParaArrays();

		exemplosComArrayLists();

		exercicios1a5comArrayLists();

	}

	private static void exercicios1a5comArrays() {
		int[] vetor = new int[15];
		Ex0200.sorteiaVetor(vetor, 1, 99);
		int[] vetorInvertido = new int[vetor.length];

		int maior = vetor[0];
		int menor = vetor[0];
		int pares = 0;
		int impares = 0;
		int somaPar = 0;
		int somaImpar = 0;
		int vi = vetorInvertido.length;

		for (int i : vetor) {

			vetorInvertido[--vi] = i;

			if (i > maior) {
				maior = i;
			}

			if (i < menor) {
				menor = i;
			}

			if (i % 2 == 0) {
				pares++;
				somaPar += i;
			} else {
				impares++;
				somaImpar += i;
			}

		}

		System.out.println("Ordem informada: " + Arrays.toString(vetor));
		System.out.println("Ordem inversa: " + Arrays.toString(vetorInvertido));
		System.out.println("Maior = " + maior);
		System.out.println("Menor = " + menor);
		System.out.println("Quantidade de pares = " + pares + ". Somatório = " + somaPar);
		System.out.println("Quantidade de ímpares = " + impares + ". Somatório = " + somaImpar);

		int[] primeiro = new int[15];
		int[] segundo = new int[primeiro.length];
		int[] terceiro = new int[primeiro.length];

		Ex0200.sorteiaVetor(primeiro, 1, 99);
		Ex0200.sorteiaVetor(segundo, 1, 99);

		for (int i = 0; i < terceiro.length; i++) {
			terceiro[i] = primeiro[i] + segundo[i];
		}
		System.out.println("Primeiro: " + Arrays.toString(primeiro));
		System.out.println("Segundo : " + Arrays.toString(segundo));
		System.out.println("Terceiro: " + Arrays.toString(terceiro));

		int[] vetor2 = new int[10];
		int[] vetor2invertido = new int[vetor2.length];

		Ex0200.sorteiaVetor(vetor2, 1, 99);
		System.out.println("Vetor2 original: " + Arrays.toString(vetor2));
		Arrays.sort(vetor2);
		for (int i = 0; i < vetor2invertido.length; i++) {
			vetor2invertido[i] = vetor2[vetor2.length - 1 - i];
		}
		System.out.println("Vetor2 crescente: " + Arrays.toString(vetor2));
		System.out.println("Vetor2 decrescente: " + Arrays.toString(vetor2invertido));

	}

	private static void outrosMetodosParaArrays() {
		int[] vetor1 = new int[15];
		int[] vetor2 = new int[15];
		Ex0200.sorteiaVetor(vetor1, 1, 99);

		// copiando 2 elementos a partir do índice 7 do primeiro vetor para o índice 7
		// do segundo
		System.arraycopy(vetor1, 7, vetor2, 7, 2);
		System.out.println("v1: " + Arrays.toString(vetor1));
		System.out.println("v2: " + Arrays.toString(vetor2));

		// copiando 3 elementos a partir do índice 0 do primeiro vetor para o índice 9
		// do segundo
		System.arraycopy(vetor1, 0, vetor2, 9, 3);
		System.out.println("v1: " + Arrays.toString(vetor1));
		System.out.println("v2: " + Arrays.toString(vetor2));

		Arrays.fill(vetor2, 123);
		System.out.println("v2: " + Arrays.toString(vetor2));

		Arrays.sort(vetor1);
		System.out.println("v1: " + Arrays.toString(vetor1));
		System.out.println("Posição do valor 75 no vetor1: " + Arrays.binarySearch(vetor1, 75));

		System.out.println("Vetor 1 == Vetor 2 ? " + Arrays.equals(vetor1, vetor2));
	}

	private static void exemplosComArrayLists() {
		ArrayList<Integer> lista = new ArrayList<>();
		Ex0200.sorteiaLista(lista, 15, 1, 9);
		System.out.println(lista.toString());

		lista.add(999);
		lista.add(0, 0);
		System.out.println(lista.toString());
		System.out.println("Contém 999 ? " + (lista.contains(999) ? "Sim" : "Não"));
		System.out.println("Contém 123 ? " + (lista.contains(123) ? "Sim" : "Não"));
		System.out.println("Quinto elemento = " + lista.get(4));
		lista.set(0, -1);
		System.out.println(lista.toString());

		if (lista.contains(3)) {
			lista.remove(lista.indexOf(3));
			System.out.println("Remoção do valor 3: " + lista.toString());
		}

		lista.remove(3);
		System.out.println("Remoção do índice 3: " + lista.toString());
		System.out.println("[0]+[1] = " + (lista.get(0) + lista.get(1)));
		System.out.println("Valor 3 no índice " + lista.indexOf(3));
		System.out.println("A lista contém " + lista.size() + "Elementos");

		Collections.sort(lista);
		System.out.println("Lista ordenada: " + lista.toString());
		Collections.sort(lista, Collections.reverseOrder());
		System.out.println("Lista inversa: " + lista.toString());
		
		int total = 0;
		for (Integer n : lista) {
			total += n;
		}
		System.out.println("Soma dos elementos da lista (for otimizado): " + total);

		total = 0;
		for (int i = 0; i < lista.size(); i++) {
			total += lista.get(i);
		}
		System.out.println("Soma dos elementos da lista (for tradicional): " + total);

		System.out.println("A lista está vazia? " + lista.isEmpty());
		lista.clear();
		System.out.println("A lista está vazia? " + lista.isEmpty());
		
	}

	private static void exercicios1a5comArrayLists() {
		//
	}

}
