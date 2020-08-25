package aulas.a05;

public class MetodosSobrecarregados {

	// Técnica de OVERLOADING (sobrecarga):
	// É possível declarar métodos com o mesmo nome, porém eles
	// devem conter listas distintas de parâmetros.

	// O método usado será aquele com a lista de
	// parâmetros correspondentes à chamada.

	public static void main(String[] args) {

		int x = 515;
		int y = triploDe(x); // chamada com parâmetro INT
		System.out.println(y);

		x = 9967;
		long z = triploDe(x); // chamada com parâmetro INT
		System.out.println(z);

		z = triploDe(z); // chamada com parâmetro LONG
		System.out.println(z);

		double w = triploDe(z); // chamada com parâmetro LONG
		System.out.println(w);

		w = triploDe(w); // chamada com parâmetro DOUBLE
		System.out.println(w);

		String s = triploDe("Java!"); // chamada com parâmetro STRING
		System.out.println(s);
		
	}

	// A instrução 'return' devolve o controle ao ponto de chamada,
	// retornando o valor especificado.

	private static int triploDe(int numero) {
		System.out.println("\nChamada para o método que retorna INT:");
		return numero * 3;
	}

	private static long triploDe(long numero) {
		System.out.println("\nChamada para o método que retorna LONG:");
		return numero * 3;
	}

	private static double triploDe(double numero) {
		System.out.println("\nChamada para o método que retorna DOUBLE:");
		return numero * 3;
	}

	private static String triploDe(String texto) {
		System.out.println("\nChamada para o método que retorna STRING:");
		return texto.repeat(3);
	}

}
