package outros;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LerTeclado {

	public static void main(String[] args)  throws IOException {
		
		Scanner scan = new Scanner(System.in);
		String name;
		do {
			System.out.print("Nome: ");
			name = scan.nextLine();
		} while (name.length() == 0);

		
		scan.close();
		System.exit(0);

		/*
		Console con = System.console();
		System.out.println(con.readLine());
		*/

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Informe seu nome: ");
		String nome = teclado.readLine();
		System.out.println("Olá " + nome + ", bem vindo ao mundo Java!");

		System.out.print("Informe o valor...: ");
		String valorStr = teclado.readLine();
		float valFloat = Float.parseFloat(valorStr);
		double valDouble = Double.parseDouble(valorStr);
		byte valByte = Byte.parseByte(valorStr);
		short valShort = Short.parseShort(valorStr);
		int valInt = Integer.parseInt(valorStr);
		long valLong = Long.parseLong(valorStr);
		boolean valBool = Boolean.parseBoolean(valorStr);
		System.out.println("Valor Booleano " + valBool);
		System.out.println("Valor Float " + valFloat);
		System.out.println("Valor Double " + valDouble);
		System.out.println("Valor Byte " + valByte);
		System.out.println("Valor Short " + valShort);
		System.out.println("Valor Int " + valInt);
		System.out.println("Valor Long " + valLong);
		
	}

}
