package cidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CidadesMain {

	public static void main(String[] args) {

		List<Cidade> cidades = lerCidades();

		// Quantas cidades em cada UF;
		// Quantas pessoas em cada UF;
		// Qual a cidade com a maior população em cada UF;
		// Qual a cidade com a menor população em cada UF;
		// Qual população feminina total;
		// Qual população masculina total;
		// Qual população total;

		Map<String, Integer> cidadesPorUF = new TreeMap<>();
		Map<String, Integer> populacaoPorUF = new TreeMap<>();
		Map<String, Cidade> maiorCidadePorUF = new TreeMap<>();
		Map<String, Cidade> menorCidadePorUF = new TreeMap<>();
		Integer populacaoMasculina = 0;
		Integer populacaoFeminina = 0;

		for (Cidade c : cidades) {

			populacaoFeminina += c.getPopFem();
			populacaoMasculina += c.getPopMasc();

			cidadesPorUF.put(c.getUf(), cidadesPorUF.getOrDefault(c.getUf(), 0) + 1);
			populacaoPorUF.put(c.getUf(), populacaoPorUF.getOrDefault(c.getUf(), c.getPopTotal()) + c.getPopTotal());

			Cidade x = maiorCidadePorUF.get(c.getUf());
			if (x != null) {
				if (c.getPopTotal() > x.getPopTotal()) {
					maiorCidadePorUF.put(c.getUf(), c);
				}
			} else {
				maiorCidadePorUF.put(c.getUf(), c);
			}

			x = menorCidadePorUF.get(c.getUf());
			if (x != null) {
				if (c.getPopTotal() < x.getPopTotal()) {
					menorCidadePorUF.put(c.getUf(), c);
				}
			} else {
				menorCidadePorUF.put(c.getUf(), c);
			}

		}
		System.out.println("Cidades por UF:\n" + cidadesPorUF);
		System.out.println("\nPopulação por UF:\n" + populacaoPorUF);
		System.out.println("\nMaior cidade por UF:\n" + maiorCidadePorUF);
		System.out.println("\nMenor cidade por UF:\n" + menorCidadePorUF);
		System.out.printf("\nPopulação feminina: %,d%n", populacaoFeminina);
		System.out.printf("\nPopulação masculina: %,d%n", populacaoMasculina);
		System.out.printf("\nPopulação total: %,d%n", (populacaoFeminina + populacaoMasculina));

		// Descobrir as 10 maiores e menores cidades do país.

		List<Cidade> porTamanho = new ArrayList<>(cidades);
		Collections.sort(porTamanho, new Comparator<Cidade>() {
			@Override
			public int compare(Cidade c1, Cidade c2) {
				return c1.getPopTotal() - c2.getPopTotal();
			}
		});

		System.out.println("\n10 menores cidades:");
		for (int i = 0; i < 10; i++) {
			System.out.println(porTamanho.get(i));
		}

		System.out.println("\n10 maiores cidades:");
		for (int i = porTamanho.size() - 1; i >= porTamanho.size() - 10; i--) {
			System.out.println(porTamanho.get(i));
		}

		// Descobrir as 10 maiores proporções entre mulheres e homens e vice-versa.

		List<Cidade> proporcaoMasculinoXFeminino = new ArrayList<>(cidades);
		Collections.sort(proporcaoMasculinoXFeminino, new Comparator<Cidade>() {
			@Override
			public int compare(Cidade c1, Cidade c2) {
				double propC1 = (double) c1.getPopMasc() / c1.getPopFem();
				double propC2 = (double) c2.getPopMasc() / c2.getPopFem();
				if (propC1 < propC2) {
					return 1;
				} else if (propC1 > propC2) { // maiores proporções na frente
					return -1;
				} else {
					return 0;
				}
			}
		});

		System.out.println("\n10 maiores proporções de homens para mulheres:");
		for (int i = 0; i < 10; i++) {
			Cidade c = proporcaoMasculinoXFeminino.get(i);
			double p = (double) c.getPopMasc() / c.getPopFem();
			System.out.println(c + " --> " + p);
		}

		System.out.println("\n10 maiores proporções de mulheres para homens:");
		for (int i = proporcaoMasculinoXFeminino.size() - 1; i >= proporcaoMasculinoXFeminino.size() - 10; i--) {
			Cidade c = proporcaoMasculinoXFeminino.get(i);
			double p = (double) c.getPopFem() / c.getPopMasc();
			System.out.println(c + " --> " + p);
		}

	}

	private static List<Cidade> lerCidades() {
		String csv = "./aulas-poo/src/cidades/população.CSV";
		List<Cidade> cidades = new ArrayList<>();
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(csv), StandardCharsets.ISO_8859_1)) {
			String linha = reader.readLine(); // ignorar cabeçalho
			while ((linha = reader.readLine()) != null) {
				String[] palavras = linha.split(";");
				cidades.add(new Cidade(palavras));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cidades;
	}
}
