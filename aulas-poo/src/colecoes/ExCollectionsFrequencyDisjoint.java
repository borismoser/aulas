package colecoes;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ExCollectionsFrequencyDisjoint {

	public static void main(String[] args) {

		String[] cores = { "black", "yellow", "green", "blue", "violet", "silver" };
		List<String> lista1 = new LinkedList<>(Arrays.asList(cores));

		String[] cores2 = { "gold", "white", "brown", "blue", "gray", "silver" };
		List<String> lista2 = new LinkedList<>(Arrays.asList(cores2));

		String[] cores3 = { "white", "gray", "blue" };
		List<String> lista3 = new LinkedList<>(Arrays.asList(cores3));
		
		// Collections.frequency() examina a frequência do argumento procurado através
		// de equals()
		System.out.println(Collections.frequency(lista1, "green"));
		System.out.println(Collections.frequency(lista2, "gold"));

		
		// Collections.disjoint() examina elementos em comum através de contains()
		System.out.printf("As listas 1 e 3%stêm elementos em comum.%n", Collections.disjoint(lista1, lista3) ? " não " : " ");
	}

}
