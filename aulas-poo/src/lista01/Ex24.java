package lista01;

public class Ex24 {

	public static void main(String[] args) {
		double tempC = 0;
		while (tempC != converterCparaF(tempC)) {
			tempC--;
		}
		System.out.printf("As temperaturas C e F são equivalentes em %.2f graus.", tempC);

	}
	private static double converterCparaF(double c) {
		double f = c * 9 / 5 + 32;
		return f;
	}

}
