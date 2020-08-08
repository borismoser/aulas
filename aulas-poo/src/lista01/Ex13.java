package lista01;

public class Ex13 {

	public static void main(String[] args) {
		int fase;
		do {
			fase = Ex00.lerInt("Informa a fase (1-6): ");
		} while (fase < 1 || fase > 6);
		System.out.println("Disciplinas restantes:");
		switch (fase) {
		case 1:
			System.out.println("Algoritmos");
		case 2:
			System.out.println("Programação Java");
		case 3:
			System.out.println("Banco de Dados");
		case 4:
			System.out.println("Programação Javascript");
		case 5:
			System.out.println("Web Design");
		case 6:
			System.out.println("Aplicativos Móveis");
		}
	}

}
