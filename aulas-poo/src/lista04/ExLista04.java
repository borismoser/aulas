package lista04;

import java.util.Arrays;
import java.util.Scanner;

public class ExLista04 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);
		System.out.print("Informe o exerc�cio (1 a 11): ");
		int ex = ler.nextInt();

		switch (ex) {
		case 1:
			ex01();
			break;
		case 2:
			ex02();
			break;
		case 3:
			ex03();
			break;
		case 4:
			ex04();
			break;
		case 5:
			ex05();
			break;
		case 6:
			ex06();
			break;
		case 7:
			ex07();
			break;
		case 8:
			ex08();
			break;
		case 9:
			ex09();
			break;
		case 10:
			ex10();
			break;
		case 11:
			ex11();
			break;
		default:
			System.out.println("O exerc�cio informado n�o foi implementado...");
			break;
		}
	}

	private static void ex01() {
		System.out.println("Exerc�cio 01:");
		int[] numeros = new int[100];
		// inserindo os n�meros de 1 a 100:
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = i + 1;
		}

		// Abaixo, algumas maneira de gerar o mesmo resultado:

		// exibindo separados por ponto-e-v�rgula:
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
		System.out.println("\nExerc�cio 02:");
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
		System.out.println("\nExerc�cio 03:");
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
		System.out.printf("Soma: %,.2f. Multiplica��o: %,.2f. M�dia: %,.2f.%n", //
				soma, mult, media);
	}

	private static void ex04() {
		System.out.println("\nExerc�cio 04:");
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
		System.out.println("\nExerc�cio 05:");
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
		System.out.printf("Quantidade de pares: %d. Somat�rio: %d.%n", pares, somaPar);
		System.out.printf("Quantidade de �mpares: %d. Somat�rio: %d.%n", impares, somaImpar);
		System.out.printf("Maior n�mero: %d. Menor: %d.%n", maior, menor);
		System.out.println("Lista original: " + lista1);
		System.out.println("Lista inversa: " + lista2);
	}

	private static void ex06() {
		System.out.println("\nExerc�cio 06:");
		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);
		String[] nomes = new String[10];
		for (int i = 0; i < nomes.length; i++) {
			System.out.print("Informe o " + (i + 1) + "� nome: ");
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
					System.out.println("N�o encontrado...");
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
		System.out.println("\nExerc�cio 07:");
		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);
		String[] nomes = new String[10];
		for (int i = 0; i < nomes.length; i++) {
			System.out.print("Informe o " + (i + 1) + "� nome: ");
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
					System.out.println("N�o encontrado...");
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
		System.out.println("\nExerc�cio 08:");
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
		System.out.println("\nExerc�cio 09:");
		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);
		System.out.print("Informe um texto: ");
		String texto = ler.nextLine();
		String textoUp = texto.toUpperCase();

		final String letras = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String saida = "";
		for (int i = 0; i < letras.length(); i++) {
			char c = letras.charAt(i);
			int pos = textoUp.indexOf(c, 0);
			while (pos >= 0) {
				saida += texto.charAt(pos);
				pos = textoUp.indexOf(c, pos + 1);
			}
		}
		char[] vetor = saida.toCharArray();
		System.out.println(Arrays.toString(vetor));
	}

	private static void ex10() {
		System.out.println("\nExerc�cio 10:");
		int[] nums = new int[20];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 10);
		}
		System.out.println("Original = " + Arrays.toString(nums));
		// Ordenando para facilitar a identifica��o dos repetidos.
		Arrays.sort(nums);
		System.out.println("Ordenado = " + Arrays.toString(nums));
		String repetidos = "";
		boolean repetiu = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1] && !repetiu) {
				repetidos += nums[i] + " ";
				repetiu = true;
			}
			if (nums[i] != nums[i - 1]) {
				repetiu = false;
			}
		}
		if (repetidos.isEmpty()) {
			// Com n�meros de 0 a 9 em um vetor de 20 posi��es,
			// nunca deveria entrar nesta condi��o!
			System.out.println("N�o h� n�meros repetidos no vetor!");
		} else {
			System.out.println("Repetidos: " + repetidos);
		}
	}

	private static void ex11() {
		System.out.println("\nExerc�cio 11:");
		int[] va = new int[20];
		int[] vb = new int[20];
		for (int i = 0; i < va.length; i++) {
			long n = Math.round(Math.random() * 100);
			va[i] = (int) (n > 50 ? n - 50 : n);
			n = Math.round(Math.random() * 100);
			vb[i] = (int) (n > 50 ? n - 50 : n);
		}

		boolean[] vc = new boolean[51];
		for (int i = 0; i < va.length; i++) {
			vc[va[i]] = true;
		}
		boolean[] vd = new boolean[51];
		for (int i = 0; i < vb.length; i++) {
			vd[vb[i]] = true;
		}

		String emAmbos = "";
		for (int i = 0; i < vc.length; i++) {
			if (vc[i] && vd[i]) {
				emAmbos += i + " ";
			}
		}
		if (emAmbos.isEmpty()) {
			System.out.println("N�o h� n�meros iguais entre os vetores!");
		} else {
			System.out.println("N�meros em ambos: " + emAmbos);
		}

		System.out.println("A = " + Arrays.toString(va));
		System.out.println("B = " + Arrays.toString(vb));
		// Ordenando apenas para facilitar visualmente a identifica��o.
		Arrays.sort(va);
		Arrays.sort(vb);
		System.out.println("Ordenado A = " + Arrays.toString(va));
		System.out.println("Ordenado B = " + Arrays.toString(vb));

	}
}
