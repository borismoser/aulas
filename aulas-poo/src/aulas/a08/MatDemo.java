package aulas.a08;

public class MatDemo {

	public static void main(String[] args) {

		double x = Teclado.lerDouble("Informe um double positivo: ");
		double y = Teclado.lerDouble("Informe um double negativo: ");
		System.out.println();

		System.out.println("round() arredonda para o inteiro mais próximo:");
		long xx = Math.round(x);
		System.out.printf("round(%f) = %d %n", x, xx);
		long yy = Math.round(y);
		System.out.printf("round(%f) = %d %n", y, yy);
		System.out.println();

		System.out.println("floor() arredonda para baixo, retornando");
		System.out.println("um double sem valores decimais:");
		double r1 = Math.floor(x);
		System.out.printf("floor(%f) = %f %n", x, r1);
		double r2 = Math.floor(y);
		System.out.printf("floor(%f) = %f %n", y, r2);
		System.out.println();

		System.out.println("ceil() arredonda para cima, retornando");
		System.out.println("um double sem valores decimais:");
		r1 = Math.ceil(x);
		System.out.printf("ceil(%f) = %f %n", x, r1);
		r2 = Math.ceil(y);
		System.out.printf("ceil(%f) = %f %n", y, r2);
		System.out.println();

		System.out.println("abs() retorna o valor absoluto (sem sinal):");
		r1 = Math.abs(x);
		System.out.printf("abs(%f) = %f %n", x, r1);
		r2 = Math.abs(y);
		System.out.printf("abs(%f) = %f %n", y, r2);
		System.out.println();

		System.out.println("Maior e menor de 2 valores:");
		double m = Math.max(x, y);
		System.out.printf("max(%f, %f) = %f %n", x, y, m);
		m = Math.min(x, y);
		System.out.printf("min(%f, %f) = %f %n", x, y, m);
		System.out.println();

		// Potenciação
		double p = Math.pow(x, 2);
		System.out.printf("%f elevado ao quadrado = %f %n", x, p);
		p = Math.pow(y, 3);
		System.out.printf("%f elevado ao cubo = %f %n", y, p);
		System.out.printf("16 elevado a 1/4 = %f %n", Math.pow(16, 1.0 / 4));
		System.out.println();

		// Raízes
		double rq = Math.sqrt(x);
		System.out.printf("Raiz quadrada de %f = %f %n", x, rq);
		rq = Math.sqrt(y);
		System.out.printf("Raiz quadrada de %f = %f %n", y, rq);
		double rc = Math.cbrt(x);
		System.out.printf("Raiz cúbica de %f = %f %n", x, rc);
		rc = Math.cbrt(y);
		System.out.printf("Raiz cúbica de %f = %f %n", y, rc);
		System.out.println();

		// Hipotenusa
		double hip = Math.hypot(3, 4);
		System.out.printf("Hipotenusa hypot(3,4) = %f %n", hip);
		System.out.println();

		// A classe Math provê uma constante para PI:
		System.out.printf("Pi = %.18f %n", Math.PI);
		System.out.println();

		// Caracteres são internamente tratados como inteiros,
		// o que permite um laço conforme demostrado abaixo:
		System.out.println("Números aleatórios >= 0.0 e < 1.0:");
		for (char c = 'a'; c <= 'e'; c++) {
			System.out.println(c + ") " + Math.random());
		}

	}

}
