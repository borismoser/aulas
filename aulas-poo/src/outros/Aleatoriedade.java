package outros;

import java.security.SecureRandom;
import java.time.LocalTime;
import java.util.Random;

public class Aleatoriedade {

	public static void main(String[] args) {

		// Math.random gera somente pseudo randoms do tipo double.
		System.out.println("Math.random number = " + Math.random());
		System.out.println("Math.random number = " + Math.random());

		// A classe Random gera diferentes tipos de resultados pseudo randômicos.
		Random rand = new Random();
		System.out.println("Random Int     : " + rand.nextInt());
		System.out.println("Random Int 0-99: " + rand.nextInt(100));
		System.out.println("Random Long    : " + rand.nextLong());
		System.out.println("Random Float   : " + rand.nextFloat());
		System.out.println("Random Double  : " + rand.nextDouble());
		System.out.println("Random Boolean : " + rand.nextBoolean());

		// A classe SecureRandom gera diferentes tipos de resultados randômicos fortes.
		SecureRandom srand = new SecureRandom();
		System.out.println("Secure Random Int     : " + srand.nextInt());
		System.out.println("Secure Random Int 0-99: " + srand.nextInt(100));
		System.out.println("secure Random Long    : " + srand.nextLong());
		System.out.println("Secure Random Float   : " + srand.nextFloat());
		System.out.println("Secure Random Double  : " + srand.nextDouble());
		System.out.println("Secure Random Boolean : " + srand.nextBoolean());

		geradorRandom(500000);
		geradorSecureRandom(500000);
		geradorMathRandom(10);

	}

	private static void geradorMathRandom(int qt) {
		System.out.println("Random start: " + LocalTime.now());
		for (int i = 1; i <= qt; i++) {
			Math.random();
		}
		System.out.println("Random stop:  " + LocalTime.now());
	}

	private static void geradorRandom(int qt) {
		System.out.println("Random start: " + LocalTime.now());
		// A classe Random gera diferentes tipos de resultados pseudo randômicos.
		Random rand = new Random();
		for (int i = 1; i <= qt; i++) {
			rand.nextInt();
		}
		System.out.println("Random stop:  " + LocalTime.now());
	}
	
	private static void geradorSecureRandom(int qt) {
		System.out.println("SecureRandom start: " + LocalTime.now());
		// A classe Random gera diferentes tipos de resultados pseudo randômicos.
		SecureRandom rand = new SecureRandom();
		for (int i = 1; i <= qt; i++) {
			rand.nextInt();
		}
		System.out.println("SecureRandom stop:  " + LocalTime.now());
	}

}
