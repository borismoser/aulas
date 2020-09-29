package aulas.a13a14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class ListaPalavrasAuxiliar {

	private static Scanner scanNumero = new Scanner(System.in);

	private static Scanner scanString = new Scanner(System.in);

	private static final String MENU_PRINCIPAL = //
			"Operações disponíveis:\n" + //
					"1) Informar uma palavra\n" + //
					"2) Exibir as palavras\n" + //
					"3) Classificar as palavras\n" + //
					"4) Limpar a lista\n" + //
					"0) Sair do programa";

	private static final String MENU_JA_EXISTE = //
			"Já existe na lista. O que deseja fazer?\n" + //
					"1) Alterar/Substituir\n" + //
					"2) Remover da lista\n" + //
					"0) Voltar para o menu principal";

	private static final String MENU_CLASSIFICACAO = //
			"Escolha a ordenação desejada:\n1) Em ordem ascendente\n2) Em ordem descendente";

	private static int menu(String menu) {
		int op;
		System.out.println("\n" + menu);
		System.out.print("Informe uma opção: ");
		op = scanNumero.nextInt();
		return op;
	}

	public static int menuPrincipal() {
		return menu(MENU_PRINCIPAL);
	}

	public static int menuJaExiste() {
		return menu(MENU_JA_EXISTE);
	}

	public static int menuClassificacao() {
		return menu(MENU_CLASSIFICACAO);
	}

	public static String lerPalavra(String msg) {
		if (msg != null && !msg.isEmpty()) {
			System.out.print(msg);
		}
		return scanString.nextLine();
	}

	public static String listagem(ArrayList<String> lista) {
		String saida = "";
		Iterator<String> it = lista.iterator();
		while (it.hasNext()) {
			saida += it.next();
			if (it.hasNext()) {
				saida += "\n";
			}
		}
		return saida;
	}

	public static void classificarLista(ArrayList<String> lista, boolean ascendente) {
		if (lista != null) {
			if (ascendente) {
				Collections.sort(lista);
			} else {
				Collections.sort(lista, Collections.reverseOrder());
			}
		}
	}

	public static void limparLista(ArrayList<String> lista) {
		if (lista != null) {
			lista.clear();
		}
	}

}
