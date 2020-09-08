package aulas.a09;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class Aleatoriedade {

	public static void main(String[] args) {

		System.out.println("Math.random() gera somente pseudo randoms do tipo");
		System.out.println("DOUBLE na faixa que vai de 0 até 'quase' 1:\n");
		System.out.println("Math.random number: " + Math.random());
		System.out.println("Math.random number: " + Math.random());

		System.out.println("\nPara obter um número aleatório entre 0 e 9");
		System.out.println("pode-se multiplicar o resultado por 10 e desprezar as decimais:\n");
		int n = (int) (Math.random() * 10);
		System.out.println("Math.random number inteiro com 1 dígito: " + n);

		System.out.println("\nA classe Random gera diferentes tipos de números pseudo");
		System.out.println("randômicos, permitindo controlar a faixa INT desejada:\n");
		Random rand = new Random();
		System.out.println("Random Int     : " + rand.nextInt());
		System.out.println("Random Int 0-99: " + rand.nextInt(100));
		System.out.println("Random Long    : " + rand.nextLong());
		System.out.println("Random Float   : " + rand.nextFloat());
		System.out.println("Random Double  : " + rand.nextDouble());
		System.out.println("Random Boolean : " + rand.nextBoolean());

		System.out.println("\nA classe SecureRandom gera diferentes tipos de números");
		System.out.println("randômicos fortes. Permite controlar a faixa INT:\n");
		SecureRandom srand = new SecureRandom();
		System.out.println("Secure Random Int     : " + srand.nextInt());
		System.out.println("Secure Random Int 0-99: " + srand.nextInt(100));
		System.out.println("secure Random Long    : " + srand.nextLong());
		System.out.println("Secure Random Float   : " + srand.nextFloat());
		System.out.println("Secure Random Double  : " + srand.nextDouble());
		System.out.println("Secure Random Boolean : " + srand.nextBoolean());
		byte[] b = new byte[10];
		srand.nextBytes(b);
		System.out.println("Secure Random Bytes   : " + Arrays.toString(b));

		int quantos = 1_000_000;
		System.out.printf("%nGeração de %,d números aleatórios:%n", quantos);

		long inicio = System.nanoTime();
		geradorRandom(quantos);
		long duracao = System.nanoTime() - inicio;
		System.out.printf("Random()      demorou %,15d ns.%n", duracao);

		inicio = System.nanoTime();
		geradorSecureRandom(quantos);
		duracao = System.nanoTime() - inicio;
		System.out.printf("SecureRandom  demorou %,15d ns.%n", duracao);

		inicio = System.nanoTime();
		geradorMathRandom(quantos);
		duracao = System.nanoTime() - inicio;
		System.out.printf("Math.random() demorou %,15d ns.%n", duracao);
	}

	private static void geradorMathRandom(int qt) {
		for (int i = 1; i <= qt; i++) {
			Math.random();
		}
	}

	private static void geradorRandom(int qt) {
		Random rand = new Random();
		for (int i = 1; i <= qt; i++) {
			rand.nextInt();
		}
	}

	private static void geradorSecureRandom(int qt) {
		SecureRandom rand = new SecureRandom();
		for (int i = 1; i <= qt; i++) {
			rand.nextInt();
		}
	}

}
