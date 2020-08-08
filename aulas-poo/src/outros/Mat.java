package outros;

public class Mat {

	public static void main(String[] args) {

		double x = 30.6456;
		double y = -32.23789;
		
		// Arredondamentos
		double r1 = Math.round(x);
		System.out.printf("round(%f) = %f %n", x, r1);
		double r2 = Math.round(y);
		System.out.printf("round(%f) = %f %n", y, r2);
		System.out.println();
		r1 = Math.floor(x);
		System.out.printf("floor(%f) = %f %n", x, r1);
		r2 = Math.floor(y);
		System.out.printf("floor(%f) = %f %n", y, r2);
		System.out.println();
		r1 = Math.ceil(x);
		System.out.printf("ceil(%f) = %f %n", x, r1);
		r2 = Math.ceil(y);
		System.out.printf("ceil(%f) = %f %n", y, r2);
		System.out.println();

		// Valor absoluto (sem sinal)
		r1 = Math.abs(x);
		System.out.printf("Valor absoluto de %f = %f %n", x, r1);
		r2 = Math.abs(y);
		System.out.printf("Valor absoluto de %f = %f %n", y, r2);
		System.out.println();
		
		// Maior e menor de 2 valores
		double m = Math.max(x, y);
		System.out.printf("Maior de %f e %f = %f %n", x, y, m);
		m = Math.min(x, y);
		System.out.printf("Menor de %f e %f = %f %n", x, y, m);
		System.out.println();

		// Potenciação
		double p = Math.pow(x, 2);
		System.out.printf("%f elevado ao quadrado = %f %n", x, p);
		p = Math.pow(y, 3);
		System.out.printf("%f elevado ao cubo = %f %n", y, p);
		p = Math.pow(8, 1.0/3);
		System.out.printf("8 elevado a 1/3 = %f %n", p);
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
		// PI
		System.out.printf("Pi = %f %n", Math.PI);
		System.out.println();

		// Números aleatórios
		for (int i=1; i<=10; i++) {
			System.out.println(Math.random());
		}

	}

}
