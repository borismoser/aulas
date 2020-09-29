package aulas.a13a14;

import java.util.ArrayList;

public class ListaPalavrasPrincipal {

	public static void main(String[] args) {

		ArrayList<String> listaPalavras = new ArrayList<>();
		String palavra;

		int opcao, subOpcao;
		do {
			opcao = ListaPalavrasAuxiliar.menuPrincipal();
			switch (opcao) {

			case 1:
				palavra = ListaPalavrasAuxiliar.lerPalavra("\nInforme uma palavra: ");
				if (!palavra.isEmpty()) {
					if (listaPalavras.contains(palavra)) {
						do {
							subOpcao = ListaPalavrasAuxiliar.menuJaExiste();
							if (subOpcao == 1) {
								int i = listaPalavras.indexOf(palavra);
								do {
									palavra = ListaPalavrasAuxiliar.lerPalavra("\nInforme uma nova palavra: ");
								} while (listaPalavras.contains(palavra));
								if (!palavra.isEmpty()) {
									listaPalavras.set(i, palavra);
								}
							} else if (subOpcao == 2) {
								if (listaPalavras.remove(palavra)) {
									System.out.println("Removido na lista: " + palavra);
								} else {
									System.out.println("Não deveria ser possível entrar aqui...");
								}
							}
						} while (subOpcao < 0 || subOpcao > 2);
					} else {
						listaPalavras.add(palavra);
						System.out.println("Incluído na lista: " + palavra);
					}
				}
				break;

			case 2:
				System.out.println("\nPalavras da lista:");
				System.out.println(ListaPalavrasAuxiliar.listagem(listaPalavras));
				break;

			case 3:
				subOpcao = ListaPalavrasAuxiliar.menuClassificacao();
				if (subOpcao == 1) {
					ListaPalavrasAuxiliar.classificarLista(listaPalavras, true);
					System.out.println("\nA lista foi classificada em ordem ascendente.\n");
				} else if (subOpcao == 2) {
					ListaPalavrasAuxiliar.classificarLista(listaPalavras, false);
					System.out.println("\nA lista foi classificada em ordem descendente.\n");
				} else {
					System.out.println("\nOpção inválida. A lista não foi classificada.\n");
				}
				break;

			case 4:
				ListaPalavrasAuxiliar.limparLista(listaPalavras);
				break;

			}
		} while (opcao != 0);

	}

}
