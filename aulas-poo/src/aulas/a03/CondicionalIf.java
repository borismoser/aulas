package aulas.a03;

import java.util.Scanner;

public class CondicionalIf {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe um número maior do que 0: ");
		int n = entrada.nextInt();

		if (n <= 0) {
			System.out.println("O número informado não é maior do que ZERO.");
		}

		if (n % 2 == 0) {
			System.out.println("O número informado é par.");
		} else {
			System.out.println("O número informado é impar.");
		}

		if (n < 0) {
			System.out.println("O número informado é negativo.");
		} else if (n <= 50) {
			System.out.println("O número informado está entre 0 e 50.");
		} else if (n <= 150) {
			System.out.println("O número informado está entre 51 e 150.");
		} else {
			System.out.println("O número informado é maior que 150.");
		}

	}

}
