package aulas.a03;

import java.util.Scanner;

public class DoWhileLoop {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int num;

		do {
			System.out.print("Informe um número entre 51 e 99: ");
			num = teclado.nextInt();
		} while (num < 51 || num > 99);

	}

}
