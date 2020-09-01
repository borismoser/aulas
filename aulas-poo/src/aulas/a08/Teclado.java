package aulas.a08;

import java.util.Scanner;

public class Teclado {

	private static Scanner teclado = new Scanner(System.in);

	private static void mensagem(String msg) {
		if (msg != null && !msg.isEmpty()) {
			System.out.print(msg);
		}
	}

	public static String lerString(String msg) {
		mensagem(msg);
		String txt = teclado.nextLine();
		return txt;
	}

	public static double lerDouble(String msg) {
		mensagem(msg);
		double db = teclado.nextDouble();
		return db;
	}

	public static int lerInt(String msg) {
		mensagem(msg);
		int num = teclado.nextInt();
		return num;
	}

}
