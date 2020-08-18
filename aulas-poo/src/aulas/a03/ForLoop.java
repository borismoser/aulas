package aulas.a03;

public class ForLoop {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Math.random());
		}

		// leitura dos parâmetros de entrada do método main():
		for (String s : args) {
			System.out.println(s);
		}
		
		// a construção acima é equivalente a:
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}

}
