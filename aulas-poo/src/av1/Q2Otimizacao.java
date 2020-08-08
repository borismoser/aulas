package av1;

import java.util.Scanner;

public class Q2Otimizacao {

	public static void main(String[] args) {
		
		Q2CorVoto az = new Q2CorVoto("AZUL");
		Q2CorVoto ve = new Q2CorVoto("VERDE");
		Q2CorVoto am = new Q2CorVoto("AMARELO");
		
		int opcao;
		do {
			opcao = opcaoMenu();
			switch (opcao) {
			case 1:
				votar(az);
				break;
			case 2:
				votar(ve);
				break;
			case 3:
				votar(am);
				break;
			}
		} while (opcao != 0);

		System.out.println("Total AZUL = " + az.getVotos());
		System.out.println("Total VERDE = " + ve.getVotos());
		System.out.println("Total AMARELO = " + am.getVotos());

	}

	private static void votar(Q2CorVoto cv) {
		cv.computarVoto();
		System.out.println("Você votou " + cv.getCor() + ". Total = " + cv.getVotos());
	}

private static int opcaoMenu() {
		Scanner ler = new Scanner(System.in);
		int opcao;
		do {
			System.out.println("Vote em uma cor, informando o código correspondente:");
			System.out.println("1 - azul");
			System.out.println("2 - verde");
			System.out.println("3 - amarelo");
			System.out.println("0 - fim");
			System.out.print("Cor: ");
			opcao = ler.nextInt();
			if (opcao < 0 || opcao > 3) {
				System.out.println("\n*** Opção inválida! ***\n");
			}
		} while (opcao < 0 || opcao > 3);
		return opcao;
	}

}
