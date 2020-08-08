package colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExCollectionsReverseFillCopy {

	// Collections.reverse(), fill() e copy() são compatíveis com coleções List.

	public static void main(String[] args) {

		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("Batman", 33));
		pessoas.add(new Pessoa("Hulk", 44));
		pessoas.add(new Pessoa("Ironman", 50));
		pessoas.add(new Pessoa("Spiderman", 22));
		pessoas.add(new Pessoa("Superman", 35));
		pessoas.add(new Pessoa("Thor", 3500));

		System.out.printf("Pessoas na ordem original:   %s%n", pessoas);

		Collections.reverse(pessoas);
		System.out.printf("Pessoas em ordem inversa:    %s%n", pessoas);

		List<Pessoa> pessoas2 = new ArrayList<>();
		pessoas2.add(new Pessoa("", 0));
		pessoas2.add(new Pessoa("", 0));
		pessoas2.add(new Pessoa("", 0));
		pessoas2.add(new Pessoa("", 0));
		pessoas2.add(new Pessoa("", 0));
		pessoas2.add(new Pessoa("", 0));
		System.out.printf("Pessoas 2:  %s%n", pessoas2);
		Collections.copy(pessoas2, pessoas);
		System.out.printf("Pessoas 2 após copy():  %s%n", pessoas2);
		Collections.fill(pessoas2, null);
		System.out.printf("Pessoas 2 após fill():  %s%n", pessoas2);
	}

}
