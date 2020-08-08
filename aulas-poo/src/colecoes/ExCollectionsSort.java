package colecoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExCollectionsSort {

	// Collections.sort() é compatível com coleções List.

	public static void main(String[] args) {

		ordenarStrings();
		ordenarPessoas();
		
	}
	
	private static void ordenarStrings() {
		String[] naipes = { "Ouros", "Copas", "Paus", "Espadas" };
		List<String> lista = Arrays.asList(naipes);
		
		System.out.printf("Naipes na ordem original:    %s%n", lista);
		
		Collections.sort(lista);
		System.out.printf("Naipes em ordem ascendente:  %s%n", lista);
		
		Collections.sort(lista, Collections.reverseOrder());
		System.out.printf("Naipes em ordem descendente: %s%n", lista);
	}

	private static void ordenarPessoas() {
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("Thor", 3500));
		pessoas.add(new Pessoa("Hulk", 44));
		pessoas.add(new Pessoa("Spiderman", 22));
		pessoas.add(new Pessoa("Ironman", 50));

		// Classificação utilizando a interface Comparable
		System.out.printf("Pessoas na ordem original:             %s%n", pessoas);
		Collections.sort(pessoas);
		System.out.printf("Pessoas em ordem ascendente de nome:   %s%n", pessoas);
		Collections.sort(pessoas, Collections.reverseOrder());
		System.out.printf("Pessoas em ordem descendente de nome:  %s%n", pessoas);

		// Classificação utilizando a interface Comparator
		Collections.sort(pessoas, new PessoaComparatorIdade(true));
		System.out.printf("Pessoas em ordem ascendente de idade:  %s%n", pessoas);
		Collections.sort(pessoas, new PessoaComparatorIdade(false));
		System.out.printf("Pessoas em ordem descendente de idade: %s%n", pessoas);
	}

}
