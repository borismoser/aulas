package lista01;

import java.util.Scanner;

public class Ex00 {

	private static Scanner numberScan = new Scanner(System.in);
	private static Scanner stringScan = new Scanner(System.in);

	public static String lerString(String msg) {
		System.out.print(msg);
		return stringScan.nextLine();
	}

	public static int lerInt(String msg) {
		System.out.print(msg);
		return numberScan.nextInt();
	}

	public static double lerDouble(String msg) {
		System.out.print(msg);
		return numberScan.nextDouble();
	}
	
}
