package outros;

import java.util.Scanner;

public class Wrappers {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		/*
		 * Conversão de tipos: - Para a conversão de dados, utilizamos os métodos
		 * estáticos das classes correspondentes aos tipos de dados (Float, Integer,
		 * Byte, etc.): - float valFloat = Float.parseFloat(valorStr); - double
		 * valDouble = Double.parseDouble(valorStr); - byte valByte =
		 * Byte.parseByte(valorStr); - short valShort = Short.parseShort(valorStr); -
		 * int valInt = Integer.parseInt(valorStr); - long valLong =
		 * Long.parseLong(valorStr);
		 */

		String valorStr;
		System.out.print("Informe o valor...: ");
		valorStr = teclado.nextLine();
		float valFloat = Float.parseFloat(valorStr);
		System.out.println("Valor Float " + valFloat);
		double valDouble = Double.parseDouble(valorStr);
		System.out.println("Valor Double " + valDouble);
		short valShort = Short.parseShort(valorStr);
		System.out.println("Valor Short " + valShort);
		int valInt = Integer.parseInt(valorStr);
		System.out.println("Valor Int " + valInt);
		long valLong = Long.parseLong(valorStr);
		System.out.println("Valor Long " + valLong);
		boolean valBool = Boolean.parseBoolean(valorStr);
		System.out.println("Valor Booleano " + valBool);

		// Tratamento de exceção para uma conversão inválida.
		try {
			byte valByte = Byte.parseByte(valorStr);
			System.out.println("Valor Byte " + valByte);
		} catch (NumberFormatException e) {
			System.out.println("Não é possível converter '" + valorStr + "' em um byte: " + e.getMessage());
		}

		/*
		 * - Pode-se utilizar os métodos das classes para obter valor máximo, mínimo,
		 * converter para outra base, etc.: - Abaixo o exemplo do uso de MAX_VALUE,
		 * MIN_VALUE e conversão de bases:
		 */

		int maximo = Integer.MAX_VALUE;
		int minimo = Integer.MIN_VALUE;
		System.out.println("Maior Valor Inteiro (int)...: " + maximo);
		System.out.println("Menor Valor Inteiro (int)...: " + minimo);
		System.out.println("Binário.....................: " + Integer.toBinaryString(maximo));
		System.out.println("Octal.......................: " + Integer.toOctalString(maximo));
		System.out.println("Hexadecimal.................: " + Integer.toHexString(maximo).toUpperCase());
		System.out.print("Informe um valor (long).....: ");
		long valorLongo;
		valorLongo = Long.parseLong(teclado.nextLine());
		System.out.println("Valor Lido..................: " + valorLongo);
		System.out.println("Binário.....................: " + Long.toBinaryString(valorLongo));
		System.out.println("Octal.......................: " + Long.toOctalString(valorLongo));
		System.out.println("Hexadecimal.................: " + Long.toHexString(valorLongo).toUpperCase());

		/*
		 * - Exemplo com as faixas de valores dos tipos de dados.
		 */
		{
			byte minByte = Byte.MIN_VALUE, maxByte = Byte.MAX_VALUE;
			short minShort = Short.MIN_VALUE, maxShort = Short.MAX_VALUE;
			int minInt = Integer.MIN_VALUE, maxInt = Integer.MAX_VALUE;
			long minLong = Long.MIN_VALUE, maxLong = Long.MAX_VALUE;
			float minFloat = Float.MIN_VALUE, maxFloat = Float.MAX_VALUE;
			double minDouble = Double.MIN_VALUE, maxDouble = Double.MAX_VALUE;

			System.out.println("Tipos primitivos do Java");
			System.out.println("Byte");
			System.out.println("\t Máximo: " + maxByte);
			System.out.println("\t Mínimo: " + minByte);
			System.out.println("Short");
			System.out.println("\t Máximo: " + maxShort);
			System.out.println("\t Mínimo: " + minShort);
			System.out.println("Int");
			System.out.println("\t Máximo: " + maxInt);
			System.out.println("\t Mínimo: " + minInt);
			System.out.println("Long");
			System.out.println("\t Máximo: " + maxLong);
			System.out.println("\t Mínimo: " + minLong);
			System.out.println("Float");
			System.out.println("\t Máximo: " + maxFloat);
			System.out.println("\t Mínimo: " + minFloat);
			System.out.println("Double");
			System.out.println("\t Máximo: " + maxDouble);
			System.out.println("\t Mínimo: " + minDouble);
			System.out.println("\nCaracter");
		}
	}

}
