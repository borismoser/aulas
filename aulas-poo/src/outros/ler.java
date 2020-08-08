package outros;

import java.util.Scanner;

public class ler {

	private static Scanner teclado = new Scanner(System.in);

	public static String lerString(String mensagem) {
		System.out.print(mensagem);
		String txt = teclado.nextLine();
		return txt;
	}

	public static double lerDouble(String mensagem) {
		System.out.print(mensagem);
		double db = teclado.nextDouble();
		return db;
	}

	public static int lerInteiro(String mensagem) {
		System.out.print(mensagem);
		int numero = teclado.nextInt();
		return numero;
	}

}
