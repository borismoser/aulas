package colecoes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ExLinkedList {

	// Um objeto LinkedList proporciona inserção intermediária eficiente,
	// porém é mais lento para posicionar-se em um elemento específico.

	public static void main(String[] args) {

		String[] cores = { "black", "yellow", "green", "blue", "violet", "silver" };
		List<String> lista1 = new LinkedList<>();
		for (String cor : cores) {
			lista1.add(cor);
		}

		String[] cores2 = { "gold", "white", "brown", "blue", "gray", "silver" };
		List<String> lista2 = new LinkedList<>();
		for (String cor : cores2) {
			lista2.add(cor);
		}

		lista1.addAll(lista2); // concatena as listas
		lista2 = null; // libera a alocação de recursos da lista2
		printList(lista1); // imprime os elements da lista1

		converterParaMaiusculas(lista1);
		printList(lista1);

		System.out.printf("%nRemovendo elementos 4 a 6...");
		removeItems(lista1, 4, 7); // remove itens 4-6 da lista
		printList(lista1);
		printReversedList(lista1);

		usandoToArray();
	}

	private static void printList(List<String> lista) {
		System.out.printf("%nLista:%n");
		for (String cor : lista) {
			System.out.printf("%s ", cor);
		}
		System.out.println();
	}

	private static void converterParaMaiusculas(List<String> lista) {
		ListIterator<String> iterator = lista.listIterator();
		while (iterator.hasNext()) {
			String cor = iterator.next(); // obtém o elemento String
			iterator.set(cor.toUpperCase()); // atualiza o elemento convertendo para maiúsculas
		}
	}

	// obtém sublista and usa o método clear() para remover tais items
	private static void removeItems(List<String> list, int start, int end) {
		list.subList(start, end).clear(); // remove items
	}

	private static void printReversedList(List<String> list) {
		ListIterator<String> iterator = list.listIterator(list.size());
		System.out.printf("%nLista em ordem inversa:%n");
		while (iterator.hasPrevious()) {
			System.out.printf("%s ", iterator.previous());
		}
	}

	private static void usandoToArray() {
		String[] cores = { "black", "blue", "yellow" };

		// inicializa uma LinkedList a partir de um Array
		LinkedList<String> links = new LinkedList<>(Arrays.asList(cores));

		links.addLast("red"); // adiciona como último item
		links.add("pink"); // adiciona no final da lista
		links.add(3, "green"); // adiciona na terceira posição
		links.addFirst("cyan"); // adiciona na primeira posição

		// retorna os itens da LinkedList na forma de um Array
		cores = links.toArray(new String[links.size()]);

		System.out.println("\n\nCores: ");
		for (String cor : cores) {
			System.out.println(cor);
		}
	}

}
