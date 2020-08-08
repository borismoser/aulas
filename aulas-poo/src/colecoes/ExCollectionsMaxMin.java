package colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExCollectionsMaxMin {

	// Collections.max() e min() são compatíveis com qualquer Collection.

	public static void main(String[] args) {

		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("Batman", 33));
		pessoas.add(new Pessoa("Hulk", 44));
		pessoas.add(new Pessoa("Ironman", 50));
		pessoas.add(new Pessoa("Spiderman", 22));
		pessoas.add(new Pessoa("Superman", 35));
		pessoas.add(new Pessoa("Thor", 3500));
		pessoas.add(new Pessoa("Zorro", 64));

		Collections.shuffle(pessoas);
		System.out.printf("Pessoas:   %s%n", pessoas);
		System.out.println();
		System.out.println("Maior (max) e menor (min) conforme interface Comparable (nome): ");
		System.out.println("\"Maior\" pessoa da lista: "  + Collections.max(pessoas));
		System.out.println("\"Menor\" pessoa da lista: "  + Collections.min(pessoas));
		System.out.println();
		System.out.println("Maior (max) e menor (min) conforme interface Comparator (idade): ");
		System.out.println("\"Maior\" pessoa da lista: "  + Collections.max(pessoas, new PessoaComparatorIdade(true)));
		System.out.println("\"Menor\" pessoa da lista: "  + Collections.min(pessoas, new PessoaComparatorIdade(true)));
	}

}
