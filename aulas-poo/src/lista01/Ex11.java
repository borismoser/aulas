package lista01;

public class Ex11 {

	public static void main(String[] args) {
		int n;
		do {
			n = Ex00.lerInt("Informe um n�mero: ");
			boolean par = n % 2 == 0;
			boolean positivo = n >= 0;
			System.out.printf("%d � %s e %s.%n", n, par ? "par" : "�mpar", positivo ? "positivo" : "negativo");
		} while (n != 0);
	}

}
