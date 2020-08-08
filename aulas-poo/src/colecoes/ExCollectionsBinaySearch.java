package colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExCollectionsBinaySearch {

	// Collections.binarySearch() precisa que a coleção esteja classificada pelo
	// critério de busca.

	public static void main(String[] args) {

		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("Batman", 33));
		pessoas.add(new Pessoa("Hulk", 44));
		pessoas.add(new Pessoa("Ironman", 50));
		pessoas.add(new Pessoa("Spiderman", 22));
		pessoas.add(new Pessoa("Superman", 35));
		pessoas.add(new Pessoa("Thor", 3500));
		pessoas.add(new Pessoa("Zorro", 64));

		Pessoa procurado = new Pessoa("Ironman", 50);

		System.out.println("Pesquisa binária pela interface Comparable (nome):");
		System.out.printf("Procurando %s em %s%n", procurado, pessoas);
		int i = Collections.binarySearch(pessoas, procurado);
		System.out.printf("A pessoa procurada%sfoi encontrada (%d).%n", i >= 0 ? " " : " não ", i);
		System.out.println();
		System.out.println("Pesquisa binária pela interface Comparator (idade):");
		Collections.sort(pessoas, new PessoaComparatorIdade(true));
		System.out.printf("Procurando %s em %s%n", procurado, pessoas);
		i = Collections.binarySearch(pessoas, procurado, new PessoaComparatorIdade(true));
		System.out.printf("A pessoa procurada%sfoi encontrada (%d).%n", i >= 0 ? " " : " não ", i);

	}

}
