package colecoes;

import java.util.PriorityQueue;

public class ExPriorityQueue {

	// Implementação de uma fila baseada em critérios de prioridade.

	public static void main(String[] args) {

		exemploComparable();
		exemploComparator();

	}

	// A priorização da fila obedece a interface Comparable (nome)
	private static void exemploComparable() {
		PriorityQueue<Pessoa> pessoas = new PriorityQueue<>();
		enfileirar(pessoas);
		desenfileirar(pessoas);
	}

	// A priorização da fila obedece a interface Comparator (idade)
	private static void exemploComparator() {
		PriorityQueue<Pessoa> pessoas = new PriorityQueue<>(new PessoaComparatorIdade(false));
		enfileirar(pessoas);
		desenfileirar(pessoas);
	}

	private static void desenfileirar(PriorityQueue<Pessoa> q) {
		System.out.println("\nRetirando as pessoas da fila:\n");
		while (q.peek() != null) {
			System.out.println(q.poll() + " <-- " + q);
		}
	}

	private static void enfileirar(PriorityQueue<Pessoa> q) {
		System.out.println("\nColocando as pessoas na fila:\n");
		insere(new Pessoa("Hulk", 44), q);
		insere(new Pessoa("Batman", 33), q);
		insere(new Pessoa("Thor", 3500), q);
		insere(new Pessoa("Ironman", 50), q);
		insere(new Pessoa("Superman", 35), q);
		insere(new Pessoa("Zorro", 64), q);
		insere(new Pessoa("Spiderman", 22), q);
	}

	private static void insere(Pessoa p, PriorityQueue<Pessoa> q) {
		q.offer(p);
		System.out.println(p + " --> " + q);
	}
}
