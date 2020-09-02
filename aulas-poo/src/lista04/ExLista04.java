package lista04;

import java.util.Arrays;
import java.util.Scanner;

public class ExLista04 {

	public static void main(String[] args) {
//		ex01();
//		ex02();
//		ex03();
//		ex04();
//		ex05();
//		ex06();
//		ex07();
//		ex08();
		ex09();
	}

	private static void ex01() {
		System.out.println("Exercício 01:");
		int[] numeros = new int[100];
		// inserindo os números de 1 a 100:
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = i + 1;
		}

		// Abaixo, algumas maneira de gerar o mesmo resultado:

		// exibindo separados por ponto-e-vírgula:
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] < 100) {
				System.out.print(numeros[i] + ";");
			} else {
				System.out.print(numeros[i]);
			}
		}
		System.out.println();
		// outra forma de exibir:
		String saida = "";
		for (int n : numeros) {
			saida += n + (n < 100 ? ";" : "");
		}
		System.out.println(saida);
	}

	private static void ex02() {
		System.out.println("\nExercício 02:");
		int[] numeros = new int[101];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = i;
		}
		String saida = "";
		for (int i = numeros.length - 1; i >= 0; i--) {
			saida += numeros[i] + (i > 0 ? ";" : "");
		}
		System.out.println(saida);
	}

	private static void ex03() {
		System.out.println("\nExercício 03:");
		double[] nums = new double[5];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Math.random() * 100;
		}
		System.out.println(Arrays.toString(nums));
		double soma = 0.0;
		double mult = 1.0;
		for (double n : nums) {
			soma += n;
			mult *= n;
		}
		double media = soma / nums.length;
		System.out.printf("Soma: %,.2f. Multiplicação: %,.2f. Média: %,.2f.%n", //
				soma, mult, media);
	}

	private static void ex04() {
		System.out.println("\nExercício 04:");
		double[] numA = new double[5];
		for (int i = 0; i < numA.length; i++) {
			numA[i] = Math.random() * 100;
		}
		double[] numB = new double[numA.length];
		for (int i = 0; i < numB.length; i++) {
			numB[i] = -numA[i];
		}
		System.out.println(Arrays.toString(numA));
		System.out.println(Arrays.toString(numB));
	}

	private static void ex05() {
		System.out.println("\nExercício 05:");
		int[] nums = new int[7];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(nums));
		String lista1 = "";
		String lista2 = "";
		int pares = 0;
		int impares = 0;
		int somaPar = 0;
		int somaImpar = 0;
		int maior = nums[0];
		int menor = maior;
		for (int n : nums) {
			if (n % 2 == 0.0) {
				pares++;
				somaPar += n;
			} else {
				impares++;
				somaImpar += n;
			}
			maior = Math.max(maior, n);
			menor = Math.min(menor, n);
			lista1 = lista1 + n + " ";
			lista2 = n + " " + lista2;
		}
		System.out.printf("Quantidade de pares: %d. Somatório: %d.%n", pares, somaPar);
		System.out.printf("Quantidade de ímpares: %d. Somatório: %d.%n", impares, somaImpar);
		System.out.printf("Maior número: %d. Menor: %d.%n", maior, menor);
		System.out.println("Lista original: " + lista1);
		System.out.println("Lista inversa: " + lista2);
	}

	private static void ex06() {
		System.out.println("\nExercício 06:");
		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);
		String[] nomes = new String[10];
		for (int i = 0; i < nomes.length; i++) {
			System.out.print("Informe o " + (i + 1) + "º nome: ");
			nomes[i] = ler.nextLine();
		}
		String busca;
		do {
			System.out.print("Informe o nome a procurar: ");
			busca = ler.nextLine();
			if (!"".equals(busca)) {
				if (ex06Achou(busca, nomes)) {
					System.out.println("Encontrado!");
				} else {
					System.out.println("Não encontrado...");
				}
			}
		} while (!"".equals(busca));
	}

	private static boolean ex06Achou(String procurado, String[] listaNomes) {
		for (String s : listaNomes) {
			if (procurado.equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}

	private static void ex07() {
		System.out.println("\nExercício 07:");
		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);
		String[] nomes = new String[10];
		for (int i = 0; i < nomes.length; i++) {
			System.out.print("Informe o " + (i + 1) + "º nome: ");
			nomes[i] = ler.nextLine();
		}
		String busca;
		do {
			System.out.print("Informe o nome a procurar: ");
			busca = ler.nextLine();
			if (!"".equals(busca)) {
				int pos = ex07Posicao(busca, nomes);
				if (pos >= 0) {
					System.out.print("Encontrado! Deseja alterar? (S/N) ");
					String resp = ler.nextLine();
					if ("S".equalsIgnoreCase(resp)) {
						System.out.print("Informe o novo nome: ");
						nomes[pos] = ler.nextLine();
					}
				} else {
					System.out.println("Não encontrado...");
				}
			}
		} while (!"".equals(busca));
	}

	private static int ex07Posicao(String procurado, String[] listaNomes) {
		for (int i = 0; i < listaNomes.length; i++) {
			if (procurado.equalsIgnoreCase(listaNomes[i])) {
				return i;
			}
		}
		return -1;
	}

	private static void ex08() {
		System.out.println("\nExercício 08:");
		int[] primeiro = new int[10];
		int[] segundo = new int[10];
		int[] terceiro = new int[10];
		for (int i = 0; i < primeiro.length; i++) {
			primeiro[i] = (int) (Math.random() * 100);
			segundo[i] = (int) (Math.random() * 100);
		}
		for (int i = 0; i < primeiro.length; i++) {
			terceiro[i] = primeiro[i] + segundo[i];
		}
		System.out.println("Primeiro: " + Arrays.toString(primeiro));
		System.out.println("Segundo: " + Arrays.toString(segundo));
		System.out.println("Terceiro: " + Arrays.toString(terceiro));
	}

	private static void ex09() {
		System.out.println("\nExercício 09:");
		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);
		System.out.print("Informe um texto: ");
		String texto = ler.nextLine();
		
		char[] cars = texto.toCharArray();
		Arrays.sort(cars);
		System.out.println(Arrays.toString(cars));

		final String letras = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] saida = new char[texto.length()];
		for (int i=0; i<letras.length(); i++) {
			
		}
	}
}
