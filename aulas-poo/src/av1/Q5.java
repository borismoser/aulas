package av1;

public class Q5 {

	public static void main(String[] args) {
		double r = Math.random() * 100;
		System.out.println("Raio: " + r);
		System.out.printf("Di�metro: %f%n", 2 * r);
		System.out.printf("Circunfer�ncia: %f%n", Math.PI * 2 * r);
		System.out.printf("�rea: %f%n", Math.PI * Math.pow(r, 2));
	}

}
