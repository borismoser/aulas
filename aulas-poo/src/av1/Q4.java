package av1;

import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		System.out.print("Informe um n�mero inteiro: ");
		int numero = ler.nextInt();
		double resultado = Math.sqrt(numero);
		System.out.printf("A raiz quadrada de %d � %1.2f", numero, resultado);
	}

}
