package lista01;

public class Ex12 {

	public static void main(String[] args) {
		int idade;
		do {
			idade = Ex00.lerInt("Informa a idade (>=0): ");
		} while (idade < 0);
		System.out.print("Categoria:");
		if (idade <= 7) {
			System.out.println("Infantil");
		} else if (idade >= 8 && idade <= 10) {
			System.out.println("Mirim");
		} else if (idade >= 11 && idade <= 13) {
			System.out.println("Junior");
		} else if (idade >= 14 && idade <= 17) {
			System.out.println("Juvenil");
		} else if (idade >= 18 && idade <= 40) {
			System.out.println("Adulto");
		} else if (idade > 40) {
			System.out.println("Master");
		}
	}

}
