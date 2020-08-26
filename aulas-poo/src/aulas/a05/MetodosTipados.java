package aulas.a05;

public class MetodosTipados {

	public static void main(String[] args) {
		
		int num = 123;
		System.out.printf("%d %s", num, "é par? ");
		System.out.println(numeroPar(num) ? "Sim" : "Não");
		
		int a = 1500;
		int b = 1492;
		int c = 1888;
		System.out.printf("%n%s %d, %d e %d: ", "Maior entre ", a, b, c);
		long d = maiorDeTres(a, b, c);
		System.out.println(d);
		
		System.out.println("\nVariáveis de ambiente: " + variaveisAmbiente());
	}

	// O tipo de retorno de um método deve ser
	// identificado imediatamente antes do nome deste.

	// Todo método que não seja 'void' deve ter pelo menos
	// uma instrução 'return' válida e compatível com
	// o tipo definido para o método.

	private static boolean numeroPar(long n) {
		if (n % 2 == 0) {
			return true;
		} else {
			return false;
		}
		// outra forma de escrever:
		// return n % 2 == 0;
	}
	
	private static long maiorDeTres(long n1, long n2, long n3) {
		long tmp = Math.max(n1, n2);
		return Math.max(tmp, n3);
		// Ou ainda:
		// return Math.max(Math.max(n1, n2), n3);
	}

	private static String variaveisAmbiente() {
		return System.getenv().toString();
	}
}
