package aulas.a12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class StringArrayList {

	// Uma lista é uma coleção de elementos em sequência e que pode conter itens
	// duplicados.

	// ArrayList é uma implementação da interface List para um vetor
	// redimensionável. A inserção de elementos entre outros já existentes não
	// é eficiente, pois implica no deslocamento dos elementos posteriores.

	public static void main(String[] args) {

		// preenche uma lista com os elementos de um vetor de cores
		String[] cores = { "PRETO", "VERMELHO", "BRANCO", "AZUL", "AMARELO" };
		List<String> lista = new ArrayList<String>();
		for (String cor : cores) {
			lista.add(cor);
		}

		// preenche uma lista com cores a serem removidas
		String[] removerCores = { "VERMELHO", "BRANCO", "AZUL" };
		List<String> listaRemover = new ArrayList<String>();
		for (String cor : removerCores) {
			listaRemover.add(cor);
		}

		// conteúdo da lista de cores original
		System.out.println("ArrayList cores: ");
		for (int cor = 0; cor < lista.size(); cor++) {
			System.out.printf("%s ", lista.get(cor));
		}

		// remover da lista de cores os elementos em listaRemover
		removerCores(lista, listaRemover);

		// conteúdo da lista de cores após remover os elementos especificados
		System.out.printf("%n%nArrayList cores após remoção:%n");
		for (String cor : lista) {
			System.out.printf("%s ", cor);
		}

	}

	private static void removerCores(Collection<String> original, Collection<String> aRemover) {

		Iterator<String> iterator = original.iterator();
		while (iterator.hasNext()) {
			if (aRemover.contains(iterator.next())) {
				iterator.remove();
			}
		}
	}

}
