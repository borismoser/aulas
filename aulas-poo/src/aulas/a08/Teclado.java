package aulas.a08;

import java.util.Scanner;

public class Teclado {

	// Escondendo o construtor para não permitir
	// que sejam criados objetos desta classe.
	private Teclado() {
	}
	
	private static Scanner entrada = new Scanner(System.in);

	private static void mensagem(String msg) {
		if (msg != null && !msg.isEmpty()) {
			System.out.print(msg);
		}
	}

	public static String lerString(String msg) {
		mensagem(msg);
		String txt = entrada.nextLine();
		return txt;
	}

	public static double lerDouble(String msg) {
		mensagem(msg);
		double db = entrada.nextDouble();
		return db;
	}

	public static int lerInt(String msg) {
		mensagem(msg);
		int num = entrada.nextInt();
		return num;
	}

}
