package outros;

import java.security.SecureRandom;

public class JogarDado {

	public static void main(String[] args) {

		Dado dd = new Dado();
		for (int i = 0; i < 1000; i++) {
			dd.jogar();
		}
		System.out.println(dd);

	}
	
	private static SecureRandom sr = new SecureRandom();
	//private static Random sr = new Random();
	
	private static class Dado {

		private int[] frequencia = new int[6];
		
		public int jogar() {
			int res = sr.nextInt(6);
			frequencia[res]++;
			return 1 + res;
		}
		
		public String toString() {
			return String.format("1: %d%n2: %d%n3: %d%n4: %d%n5: %d%n6: %d%n",
					frequencia[0], frequencia[1], frequencia[2], frequencia[3], frequencia[4],frequencia[5]);
		}
	}

}
