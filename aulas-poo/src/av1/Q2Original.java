package av1;

import java.util.Scanner;

public class Q2Original {

	public static void main(String[] args) {
		int azul = 0;
		int verde = 0;
		int amarelo = 0;
		
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
			switch (opcao) {
			case 0: break;
			case 1:
				azul = azul + 1;
				System.out.println("Você votou AZUL. Total = " + azul);
				break;
			case 2:
				verde = verde + 1;
				System.out.println("Você votou VERDE. Total = " + verde);
				break;
			case 3:
				amarelo = amarelo + 1;
				System.out.println("Você votou AMARELO. Total = " + amarelo);
				break;
			default:
				System.out.println("\n*** Opção inválida! ***\n");
			}
		} while (opcao != 0);

		System.out.println("Total AZUL = " + azul);
		System.out.println("Total VERDE = " + verde);
		System.out.println("Total AMARELO = " + amarelo);

	}

}
