package aulas.a03;

public class CondicionalSwitchCase {

	public static void main(String[] args) {

		int x = 0;
		
		switch (x) {
		case 1:
			System.out.println("Um");
			break;
		case 2:
			System.out.println("Dois");
			break;
		case 3:
		case 4:
			System.out.println("Três ou Quatro");
			break;
		default: // o bloco 'default' é opcional
			System.out.println("Outra coisa");
			break;
		}
	}

}
