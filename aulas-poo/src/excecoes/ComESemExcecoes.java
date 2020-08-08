package excecoes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ComESemExcecoes {

	static Random rand = new Random();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		testeSemTratamentoDeExcecoes();

		testeComTratamentoDeExcecoes();

	}

	private static void testeSemTratamentoDeExcecoes() {
		System.out.print("Dividendo: ");
		int dividendo = scan.nextInt();
		System.out.print("Divisor: ");
		int divisor = scan.nextInt();
		System.out.println("Resultado da divisão: " + dividir(dividendo, divisor));

		int[] num = new int[10];
		for (int i = 0; i < num.length; i++) {
			num[i] = rand.nextInt(5);
		}
		System.out.println(Arrays.toString(num));

		for (int i = 0; i <= num.length; i++) {
			dividendo = num[i];
			divisor = rand.nextInt(5);
			System.out.printf("%d dividido por %d = %d%n", dividendo, divisor, dividir(dividendo, divisor));
		}
	}

	private static void testeComTratamentoDeExcecoes() {
		int dividendo = lerInteiro("Dividendo: ");
		int divisor = lerInteiro("Divisor: ");
		try {
			System.out.println("Resultado da divisão: " + dividir(dividendo, divisor));
		} catch (ArithmeticException e) {
			System.out.printf("Não foi possível dividir %d por %d%n", dividendo, divisor);
		}

		int[] num = new int[10];
		for (int i = 0; i < num.length; i++) {
			num[i] = rand.nextInt(5);
		}
		System.out.println(Arrays.toString(num));

		try {
			for (int i = 0; i <= num.length; i++) {
				dividendo = num[i];
				divisor = rand.nextInt(6);
				System.out.printf("%d dividido por %d = %d%n", dividendo, divisor, dividir(dividendo, divisor));
			}
		} catch (ArithmeticException e) {
			System.out.printf("Não foi possível dividir %d por %d%n", dividendo, divisor);
		} catch (IndexOutOfBoundsException e) {
			System.out.printf("Não foi possível acessar um elemento do vetor: %s%n", e.getMessage());
		} finally {
			System.out.println("Fim do processamento!");
		}
	}

	static int dividir(int x, int y) {
		return x / y;
	}

	static int lerInteiro(String msg) {
		do {
			try {
				System.out.print(msg);
				String entrada = scan.nextLine();
				return Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				System.err.println("Entrada inválida, informe novamente.");
			}
		} while (true);
	}

}
