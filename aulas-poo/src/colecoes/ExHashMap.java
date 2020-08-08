package colecoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ExHashMap {

	// Maps associam chaves (keys) e valores (values).
	// As chaves precisam ser únicas (sem repetição), os valores, não.
	// Quando ambos são únicos, temos um mapeamento "um-para-um",
	// pois cada chave correponde somente a um valor.
	// Caso os valores não sejam únicos, temos um mapeamento "muitos-para-um",
	// pois várias chaves podem corresponder ao mesmo valor.

	public static void main(String[] args) {

		String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Nullam odio sapien, consectetur nec orci eu, accumsan dapibus felis. "
				+ "Sed consequat posuere turpis. Sed eget turpis et mi dapibus dapibus. "
				+ "Etiam rhoncus tempor nunc non commodo. Sed accumsan tellus in justo semper vehicula. "
				+ "Suspendisse purus mi, ornare at est id, aliquam dapibus risus. "
				+ "Praesent eu facilisis est, quis iaculis nunc. "
				+ "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; "
				+ "Mauris vitae molestie dui, eget tristique risus. "
				+ "Vestibulum volutpat lectus eros, nec condimentum felis iaculis eget. "
				+ "Aliquam ac velit elementum, gravida sapien sit amet, elementum lectus.\n"
				+ "In vitae purus dictum, bibendum erat in, placerat eros. In hac habitasse platea dictumst. "
				+ "Aliquam cursus cursus urna et blandit. Integer id libero congue, posuere nulla vitae, luctus nibh. "
				+ "Vivamus dui risus, convallis vitae laoreet sit amet, tempor id dui. "
				+ "Quisque id ornare neque. Quisque at vehicula diam. Maecenas auctor tortor ac gravida imperdiet. "
				+ "Etiam hendrerit a risus a imperdiet. Phasellus hendrerit, arcu ut ornare volutpat, "
				+ "ligula elit tempus enim, sed auctor ante nulla vitae odio.";

		Map<String, Integer> mapa = new HashMap<>();

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(loremIpsum);

		String palavra;
		int cont = 0;
		int total = 0;

		while (scan.hasNext()) {

			// ler a próxima palavra, converter em minúsculas e remover espaçoes e pontuação.
			palavra = scan.next().trim().toLowerCase();
			if (!Character.isLetter(palavra.charAt(palavra.length() - 1))) {
				palavra = palavra.substring(0, palavra.length() - 1);
			}

			// incrementar a contagem caso a palavra já esteja no mapa, ou inseri-la.
			if (mapa.containsKey(palavra)) {
				cont = mapa.get(palavra);
				mapa.put(palavra, cont + 1);
			} else {
				mapa.put(palavra, 1);
			}

			total++;
		}

		printMap(mapa);
		System.out.println("palavras analisadas: " + total);

	}

	private static void printMap(Map<String, Integer> mapa) {

		// Obtém um conjunto com todas as chaves do mapa 
		Set<String> keys = mapa.keySet();

		// Classifica as chaves
		TreeSet<String> sortedKeys = new TreeSet<>(keys);

		System.out.printf("Chave\t\tValor%n");

		// Imprime as chaves e respectivos valores 
		for (String key : sortedKeys) {
			System.out.printf("%-12s%10s%n", key, mapa.get(key));
		}

		System.out.printf("%ntamanho: %d%nestá vazio: %b%n", mapa.size(), mapa.isEmpty());
	}

}
