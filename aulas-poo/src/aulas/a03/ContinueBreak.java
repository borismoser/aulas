package aulas.a03;

public class ContinueBreak {

	public static void main(String[] args) {

		int cont;

		for (cont = 1; cont <= 10; cont++) {
			if (cont == 5) {
				break; // encerra o laço quando o contador chegar em 5
			}
			System.out.printf("%d ", cont);
		}
		System.out.printf("%nQuebrou o FOR no contador = %d%n", cont);
		
		for (cont = 1; cont <= 10; cont++) {
			if (cont == 5) {
				continue; // não executa as instruções abaixo caso contador = 5
			}
			System.out.printf("%d ", cont);
		}

		System.out.printf("%nUsamos 'continue' para não exibir o número 5%n");
	}

}
