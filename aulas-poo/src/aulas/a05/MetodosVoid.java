package aulas.a05;

public class MetodosVoid {

	public static void main(String[] args) {
		mostrarMenu();
		
		String palavra = "Palavra";
		maiusculas(palavra);
		System.out.println(palavra);

		int x = 5;
		triplicar(x);
		System.out.println(x);
	}

	// Métodos do tipo 'void' não retornam valores para o ponto de chamada.

	// A instrução 'return' interrompe a execução do método imediatamente,
	// devolvendo a execução para o ponto de chamada.
	
	private static void mostrarMenu() {
		String menu =
				"**************************\n" +
				"1 - Fazer alguma coisa\n" +
				"2 - Não fazer coisa alguma\n" +
				"3 - Fazer outra coisa\n" +
				"0 - Fim!\n" +
				"**************************\n";
		System.out.println(menu);
		return;
	}
	
	// A passagem de parâmetros em Java acontece por valor.
	// Os métodos recebem cópias dos parâmetros, ou seja,
	// as alterações feitas nos parâmetros dentro do método
	// não são levadas para contextos externos.
	
	private static void maiusculas(String txt) {
		txt = txt.toUpperCase();
		System.out.println(txt);
	}
	
	private static void triplicar(int numero) {
		numero = numero * 3;
		System.out.println(numero);
	}
	
	

}
