package av1;

public class Q5 {

	public static void main(String[] args) {
		double r = Math.random() * 100;
		System.out.println("Raio: " + r);
		System.out.printf("Diâmetro: %f%n", 2 * r);
		System.out.printf("Circunferência: %f%n", Math.PI * 2 * r);
		System.out.printf("Área: %f%n", Math.PI * Math.pow(r, 2));
	}

}
