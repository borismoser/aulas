package colecoes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class ExMapPessoas {

	public static void main(String[] args) {

		List<Pessoa> listaPessoas = new ArrayList<>();

		listaPessoas.add(new Pessoa("Hulk", 44));
		listaPessoas.add(new Pessoa("Batman", 33));
		listaPessoas.add(new Pessoa("Thor", 3500));
		listaPessoas.add(new Pessoa("Ironman", 50));
		listaPessoas.add(new Pessoa("Superman", 35));
		listaPessoas.add(new Pessoa("Zorro", 64));
		listaPessoas.add(new Pessoa("Spiderman", 22));

		Random rand = new Random();

		// HashMap é um mapa sem ordenação
		Map<Pessoa, Integer> hmPessoas = new HashMap<>();

		for (Pessoa p : listaPessoas) {
			int valor = 1 + rand.nextInt(1000000);
			hmPessoas.put(p, valor);
		}
		System.out.println(hmPessoas);
		printMapIterator(hmPessoas);
		System.out.println();

		// TreeMap ordenado pela interface Comparable
		Map<Pessoa, Integer> tmPessoasNome = new TreeMap<>(hmPessoas);

		System.out.println(tmPessoasNome);
		printMapForKeys(tmPessoasNome);
		System.out.println();

		// TreeMap ordenado pela interface Comparator
		Map<Pessoa, Integer> tmPessoasIdade = new TreeMap<>(new PessoaComparatorIdade(true));
		tmPessoasIdade.putAll(hmPessoas);

		System.out.println(tmPessoasIdade);
		printMapEntry(tmPessoasIdade);
		System.out.println();

		classificarPorValor(hmPessoas);
		System.out.println();
		
	}

	private static void classificarPorValor(Map<Pessoa, Integer> mapa) {
		// Implementação da interface Comparator in-place:
		Map<Pessoa, Integer> porValor = new TreeMap<>(new Comparator<Pessoa>() {
			@Override
			public int compare(Pessoa p1, Pessoa p2) {
				Integer v1 = mapa.get(p1);
				Integer v2 = mapa.get(p2);
				return v1.compareTo(v2);
			}
		});
		porValor.putAll(mapa);
		System.out.println(porValor);
		printMapEntry(porValor);
	}

	private static void printMapIterator(Map<Pessoa, Integer> mapa) {
		Set<Pessoa> sp = mapa.keySet();
		Iterator<Pessoa> ip = sp.iterator();
		while (ip.hasNext()) {
			Pessoa p = ip.next();
			System.out.println(chaveValor(p, mapa.get(p)));
		}
	}

	private static void printMapForKeys(Map<Pessoa, Integer> mapa) {
		Set<Pessoa> sp = mapa.keySet();
		for (Pessoa p : sp) {
			System.out.println(chaveValor(p, mapa.get(p)));
		}
	}

	private static void printMapEntry(Map<Pessoa, Integer> mapa) {
		for (Map.Entry<Pessoa, Integer> par : mapa.entrySet()) {
			System.out.println(chaveValor(par.getKey(), par.getValue()));
		}
	}
	
	private static String chaveValor(Pessoa p, Integer v) {
		return String.format("%13s %,8d", p, v);
	}
}
