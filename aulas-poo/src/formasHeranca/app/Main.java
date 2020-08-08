package formasHeranca.app;

import formasHeranca.classes.Forma;
import formasHeranca.figurasPlanas.Forma2d;
import formasHeranca.figurasPlanas.Paralelogramo;
import formasHeranca.figurasPlanas.Quadrado;
import formasHeranca.figurasPlanas.Triangulo;
import formasHeranca.figurasPlanas.TrianguloEquilatero;

public class Main {

	public static void main(String[] args) {

		Forma f = new Quadrado("forma <-- quadrado", 3);
		System.out.println(f.getNome());

		Forma2d f2d = new Quadrado("forma2d <-- quadrado", 3);
		System.out.println(f2d.getPerimetro());

		Paralelogramo p = new Quadrado("paralelogramo <-- quadrado", 3);
		System.out.println(p.getArea());
		
		Triangulo t = new TrianguloEquilatero("", 2);

		Quadrado q1 = new Quadrado("quadrado de verdade", 3);
		Quadrado q2 = new Quadrado("outro quadrado de verdade", 3);
		System.out.println(q1.equals(t));
		
		

	}

}
