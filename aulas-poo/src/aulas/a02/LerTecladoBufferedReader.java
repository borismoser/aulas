package aulas.a02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LerTecladoBufferedReader {

	public static void main(String[] args) throws IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(isr);

		// De maneira geral, a entrada é lida como String
		// e depois convertida para o tipo desejado.

		System.out.print("Informe seu nome: ");
		String nome = teclado.readLine();
		System.out.println("Olá, " + nome + ". Bem vindo ao mundo Java!");

		System.out.print("Informe o valor...: ");
		String valorStr = teclado.readLine();

		float valFloat = Float.parseFloat(valorStr);
		System.out.println("Valor Float " + valFloat);
		double valDouble = Double.parseDouble(valorStr);
		System.out.println("Valor Double " + valDouble);
		byte valByte = Byte.parseByte(valorStr);
		System.out.println("Valor Byte " + valByte);
		short valShort = Short.parseShort(valorStr);
		System.out.println("Valor Short " + valShort);
		int valInt = Integer.parseInt(valorStr);
		System.out.println("Valor Int " + valInt);
		long valLong = Long.parseLong(valorStr);
		System.out.println("Valor Long " + valLong);
		boolean valBool = Boolean.parseBoolean(valorStr);
		System.out.println("Valor Booleano " + valBool);

	}

}
