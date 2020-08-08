package colecoes;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExCollectionsShuffle {

	// Collections.shuffle() é compatível com coleções List.

	public static void main(String[] args) {

		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("Batman", 33));
		pessoas.add(new Pessoa("Hulk", 44));
		pessoas.add(new Pessoa("Ironman", 50));
		pessoas.add(new Pessoa("Spiderman", 22));
		pessoas.add(new Pessoa("Superman", 35));
		pessoas.add(new Pessoa("Thor", 3500));

		System.out.printf("Pessoas na ordem original:   %s%n", pessoas);

		Collections.shuffle(pessoas);
		System.out.printf("Pessoas em ordem aleatória:  %s%n", pessoas);

		Collections.shuffle(pessoas, new SecureRandom());
		System.out.printf("Pessoas em ordem aleatória:  %s%n", pessoas);
	}

}
