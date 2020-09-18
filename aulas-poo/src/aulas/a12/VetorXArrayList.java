package aulas.a12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class VetorXArrayList {

	public static void main(String[] args) {

		Random rd = new Random();

		// Declaração e preenchimento de um vetor de 10 inteiros.
		// O vetor terá sempre o mesmo tamanho, não há como redimensionar.

		int[] vetor = new int[10];
		System.out.println("Vetor = " + Arrays.toString(vetor));
		System.out.println("Comprimento do vetor = " + vetor.length);
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = rd.nextInt(100);
		}
		System.out.println("Vetor = " + Arrays.toString(vetor));
		System.out.println("Comprimento do vetor = " + vetor.length);

		// Uma lista é uma coleção de elementos em sequência, que
		// pode conter itens duplicados e ser redimensionada.

		// Declaração e preenchimento de um ArrayList do tipo Integer.
		// Listas não aceitam tipos primitivos, portanto devemos
		// utilizar a classe equivalente ao int.
		// Nos próximos comentários, sempre que se falar em 'lista',
		// entenda-se como qualquer ArrayList.

		ArrayList<Integer> lista = new ArrayList<Integer>();

		System.out.println("\nLista = " + lista);
		System.out.println("Tamanho da Lista = " + lista.size());

		// O método add() insere um elemento no final da lista.
		for (int i = 0; i < vetor.length; i++) {

			lista.add(vetor[i]);

		}
		System.out.println("\nLista = " + lista);
		System.out.println("Tamanho da Lista = " + lista.size());

		// Ao contrário do vetor, o tamanho da lista muda
		// conforme os elementos são inseridos nela.
		// A lista é redimensionada conforme necessário para
		// acomodar novos elementos.

		for (int i = 0; i < 5; i++) {
			lista.add(rd.nextInt(80));
		}
		System.out.println("\nLista = " + lista);
		System.out.println("Tamanho da Lista = " + lista.size());

		// De forma similar ao vetor, os elementos da lista também
		// podem ser acessados pelos seus índices, através do método get().
		// O primeiro elemento de um lista tem índice ZERO e seu
		// tamanho total é obtido pelo método size().
		for (int i = 0; i < lista.size(); i++) {

			int num = lista.get(i);
			System.out.printf("%d ", num);
		}
		System.out.println();

		// Também como um vetor, podemos usar o for otimizado para ler
		// os elementos da lista, quando o índice não for relevante.
		for (int x : lista) {
			System.out.printf("%d ", x);
		}
		System.out.println();

		// É possível inserir um elemento em qualquer posição disponível
		// na lista, o que provoca o deslocamento dos demais elementos.

		// Inserindo o elemento 999 na posição 0:
		lista.add(0, 999);
		System.out.println("\nLista = " + lista);
		System.out.println("Tamanho da Lista = " + lista.size());
		// Inserindo o elemento 888 na posição 5:
		lista.add(5, 888);
		System.out.println("\nLista = " + lista);
		System.out.println("Tamanho da Lista = " + lista.size());

		// Assim como é possível inserir, também podemos remover
		// posicionalmente um elemento da lista, o que novamente
		// provoca o reposicionamento dos itens restantes.

		// Removendo o elemento da posição 0 e retornando-o em uma variável:
		int removido = lista.remove(0);
		System.out.println("\nLista = " + lista);
		System.out.println("Elemento removido = " + removido);
		System.out.println("Tamanho da Lista = " + lista.size());

		// Além de remover um elemento de uma posição específica,
		// é possível remover a primeira ocorrência de um elemento
		// que contenha um determinado VALOR:

		if (lista.remove(Integer.valueOf(888))) {
			System.out.println("\nLista = " + lista);
			System.out.println("Tamanho da Lista = " + lista.size());
		}

		if (!lista.remove(Integer.valueOf(123456))) {
			System.out.println("\nElemento 123456 não foi localizado para remoção.");
		}

		// É possível alterar um elemento da lista, indicando a
		// posição a alterar e o valor, com o método set().

		// Alterando a posição 2 para o valor 5000:
		lista.set(2, 55);
		System.out.println("\nLista = " + lista);
		System.out.println("Tamanho da Lista = " + lista.size());

		// Pode-se perguntar para a lista se ela contém um
		// determinado valor, através do método contains():
		if (lista.contains(55)) {
			System.out.println("\nO elemento 55 foi localizado na lista.");
		} else {
			System.out.println("\nO elemento 55 não foi localizado na lista.");
		}

		// Também podemos descobrir a posição da primeira ocorrência de um
		// elemento que contenha o valor procurado, com o método indexOf():
		int pos = lista.indexOf(55);
		if (pos >= 0) {
			System.out.println("O valor 55 está na posição " + pos);
		}

		// Uma lista pode ser facilmente ordenada de forma ascendente
		// ou descendente usando o método sort() da classe Collections:

		Collections.sort(lista);
		System.out.println("\nLista crescente = " + lista);

		Collections.sort(lista, Collections.reverseOrder());
		System.out.println("Lista decrescente = " + lista);

		// Para eliminar todos os elementos da lista,
		// utiliza-se o método clear():
		lista.clear();
		System.out.println("\nLista = " + lista);
		System.out.println("Tamanho da Lista = " + lista.size());

		if (lista.isEmpty()) {
			System.out.println("A lista não contém elemento algum.");
		}

		// Quando nada é especificado no construtor, os ArrayLists são
		// criados com a capacidade default de 10 elementos.
		// Quando tentarmos adicionar o 11º elemento, a estrutura interna
		// de armazenamento será redimensionada para se adequar à necessidade.

		// Quando sabemos previamente o tamanho da lista, podemos criar
		// o objeto já com a capacidade desejada, passando um parâmetro
		// para o construtor. Por exemplo, para reservar 35 posições:

		lista = new ArrayList<Integer>(35);

		// Dessa forma, a estrutura interna (que na verdade é um Array
		// convencional) será redimensionada apenas se forem inseridos
		// mais do que 35 elementos.

	}

}
