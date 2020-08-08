package colecoes;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ExSet {

	public static void main(String[] args) {

		String[] cores = { "red", "white", "blue", "green", "gray", "orange", "tan", "white", "cyan", "peach", "gray",
				"orange" };
		List<String> lista = Arrays.asList(cores);
		System.out.printf("Lista de cores: %s%n", lista);

		mostrarSemDuplicatas(lista);
		mostrarSemDuplicatasEmOrdem(lista);
	}

	private static void mostrarSemDuplicatas(Collection<String> values) {

		Set<String> set = new HashSet<>(values);

		System.out.printf("%nNão duplicadas: %s%n", set);

	}
	
	private static void mostrarSemDuplicatasEmOrdem(Collection<String> values) {
		
		Set<String> set = new TreeSet<>(values);
		
		System.out.printf("%nNão duplicadas, alfabeticamente: %s%n", set);
		
	}
}
