package aulas.a03;

public class CondicionalTernario {

	public static void main(String[] args) {

		int x = 175;
		String aux = "";

		// resultado = condição ? valor Verdadeiro : valor Falso;
		aux = x >= 0 ? "positivo" : "negativo";
		System.out.println("x é " + aux);

		// Outra forma (bem menos legível) de escrever:
		System.out.println("x é " + ((x >= 0) ? "positivo" : "negativo"));

		// A operação ternária acima é equivalente a:
		if (x >= 0) {
			aux = "positivo";
		} else {
			aux = "negativo";
		}

		aux = x % 2 == 0 ? "par" : "ímpar";
		System.out.println("x é " + aux);

		// A operação ternária acima é equivalente a:
		if (x % 2 == 0) {
			aux = "par";
		} else {
			aux = "ímpar";
		}

		int y = x > 100 ? 1000 : 0;
		System.out.println("y = " + y);
	}

}
