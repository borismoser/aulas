package colecoes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ExSetPessoas {

	// A verificação de elementos iguais em um Set depende dos métodos hashCode() e
	// equals() dos objetos que o conjunto pode conter.

	// Primeiro, o Set verifica se o hasCode() já existe no conjunto.
	// Se não existir, o novo elemento é adicionado.
	// Se o hashCode() já existir, o elemento é verificado através de equals().
	// Se o elemento não for equals() aos já existentes, é adicionado.

	// Observações sobre o contrato do método haschCode():
	// - objetos iguais (equals()) DEVEM retornar hashcodes iguais;
	// - objetos diferentes (!equals()) PODEM retornar hashcodes iguais.

	public static void main(String[] args) {

		// HashSet é um conjunto não ordenado.
		Set<Pessoa> pessoas = new HashSet<>();

		pessoas.add(new Pessoa("Hulk", 44));
		pessoas.add(new Pessoa("Batman", 33));
		pessoas.add(new Pessoa("Thor", 3500));
		pessoas.add(new Pessoa("Ironman", 50));
		pessoas.add(new Pessoa("Superman", 35));
		pessoas.add(new Pessoa("Zorro", 64));
		pessoas.add(new Pessoa("Spiderman", 22));
		pessoas.add(new Pessoa("Spiderman", 22));

		System.out.println(pessoas);
		printSet(pessoas);

		// TreeSet é um conjunto que pode ser ordenado conforme a interface Comparable.
		Set<Pessoa> p1 = new TreeSet<>(pessoas);
		System.out.println(p1);
		printSet(p1);

		// TreeSet é um conjunto que pode ser ordenado conforme a interface Comparator.
		Set<Pessoa> p2 = new TreeSet<>(new PessoaComparatorIdade(true));
		p2.addAll(pessoas);
		System.out.println(p2);
		printSet(p2);

		SortedSet<Pessoa> sset = new TreeSet<>(pessoas);
		System.out.println(sset);
		System.out.println(sset.first());
		System.out.println(sset.last());
		System.out.println(sset.headSet(new Pessoa("I",0)));
		System.out.println(sset.tailSet(new Pessoa("Q",0)));
		System.out.println(sset.subSet(new Pessoa("Hux",0), new Pessoa("X",0)));
	}

	private static void printSet(Set<Pessoa> set) {
		Iterator<Pessoa> pes = set.iterator();
		while (pes.hasNext()) {
			System.out.println(pes.next());
		}
	}
}
