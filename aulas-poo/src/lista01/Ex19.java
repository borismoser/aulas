package lista01;

public class Ex19 {

	public static void main(String[] args) {
		int n = Ex00.lerInt("Quantos termos de Fibonacci deseja calcular? ");
		for (int i = 1; i <= n; i++) {
			System.out.printf("%d%s", fib(i), i == n ? "." : ", ");
		}
	}

	private static int fib(int n) {
		if (n > 1) {
			int anterior = 1;
			int atual = 0;
			int f = 0;
			for (int i = 2; i <= n; i++) {
				f = atual + anterior;
				anterior = atual;
				atual = f;
			}
			return f;
		}
		return 0;
	}

}
