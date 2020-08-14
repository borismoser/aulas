package outros;

import java.io.IOException;
import java.util.Scanner;

public class LerTecladoScanner {

	public static void main(String[] args) throws IOException {

		Scanner teclado = new Scanner(System.in);
		
		String saida = "Valor informado:";

		// Um método para ler cada tipo de dado:

		System.out.print("Informe um valor String: ");
		String str = teclado.nextLine();
		System.out.printf("%s %s%n%n", saida, str);

		System.out.print("Informe um valor byte: ");
		byte b = teclado.nextByte();
		System.out.printf("%s %d%n%n", saida, b);

		System.out.print("Informe um valor short: ");
		short s = teclado.nextShort();
		System.out.printf("%s %d%n%n", saida, s);

		System.out.print("Informe um valor int: ");
		int i = teclado.nextInt();
		System.out.printf("%s %d%n%n", saida, i);

		System.out.print("Informe um valor long: ");
		long l = teclado.nextLong();
		System.out.printf("%s %d%n%n", saida, l);

		System.out.print("Informe um valor float: ");
		float f = teclado.nextFloat();
		System.out.printf("%s %f%n%n", saida, f);

		System.out.print("Informe um valor double: ");
		double d = teclado.nextDouble();
		System.out.printf("%s %f%n%n", saida, d);
	}
}
