package outros;

import java.util.Scanner;

public class Wrappers {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		/*
		 * Convers�o de tipos: - Para a convers�o de dados, utilizamos os m�todos
		 * est�ticos das classes correspondentes aos tipos de dados (Float, Integer,
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

		// Tratamento de exce��o para uma convers�o inv�lida.
		try {
			byte valByte = Byte.parseByte(valorStr);
			System.out.println("Valor Byte " + valByte);
		} catch (NumberFormatException e) {
			System.out.println("N�o � poss�vel converter '" + valorStr + "' em um byte: " + e.getMessage());
		}

		/*
		 * - Pode-se utilizar os m�todos das classes para obter valor m�ximo, m�nimo,
		 * converter para outra base, etc.: - Abaixo o exemplo do uso de MAX_VALUE,
		 * MIN_VALUE e convers�o de bases:
		 */

		int maximo = Integer.MAX_VALUE;
		int minimo = Integer.MIN_VALUE;
		System.out.println("Maior Valor Inteiro (int)...: " + maximo);
		System.out.println("Menor Valor Inteiro (int)...: " + minimo);
		System.out.println("Bin�rio.....................: " + Integer.toBinaryString(maximo));
		System.out.println("Octal.......................: " + Integer.toOctalString(maximo));
		System.out.println("Hexadecimal.................: " + Integer.toHexString(maximo).toUpperCase());
		System.out.print("Informe um valor (long).....: ");
		long valorLongo;
		valorLongo = Long.parseLong(teclado.nextLine());
		System.out.println("Valor Lido..................: " + valorLongo);
		System.out.println("Bin�rio.....................: " + Long.toBinaryString(valorLongo));
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
			System.out.println("\t M�ximo: " + maxByte);
			System.out.println("\t M�nimo: " + minByte);
			System.out.println("Short");
			System.out.println("\t M�ximo: " + maxShort);
			System.out.println("\t M�nimo: " + minShort);
			System.out.println("Int");
			System.out.println("\t M�ximo: " + maxInt);
			System.out.println("\t M�nimo: " + minInt);
			System.out.println("Long");
			System.out.println("\t M�ximo: " + maxLong);
			System.out.println("\t M�nimo: " + minLong);
			System.out.println("Float");
			System.out.println("\t M�ximo: " + maxFloat);
			System.out.println("\t M�nimo: " + minFloat);
			System.out.println("Double");
			System.out.println("\t M�ximo: " + maxDouble);
			System.out.println("\t M�nimo: " + minDouble);
			System.out.println("\nCaracter");
		}
	}

}
