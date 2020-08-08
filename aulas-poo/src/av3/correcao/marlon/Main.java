package av3.correcao.marlon;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import av3.correcao.marlon.Connector.Banco;

public class Main {
	public static Scanner scanner = new Scanner(System.in);
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) {
		Banco banco = new Banco();
		banco.inicializar();
		banco.a();
		System.out.println("----------------------------------------------------------------------");
		banco.b();
		System.out.println("----------------------------------------------------------------------");
		banco.c();
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Informe uma data (Formato MM/DD/YYYY)");
		String data = scanner.next();
		System.out.println("Informe uma valor em Real (Separador .)");
		Double valor = scanner.nextDouble();
		banco.d(data, valor);
	}

}
