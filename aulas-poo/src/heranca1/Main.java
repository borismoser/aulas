package heranca1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Objeto o = new Objeto();
		System.out.println(o.toString());
		System.out.println(o.getClass().toString());

		Forma2d quadrado = new Forma2d("meu quadrado");
		Forma3d esfera = new Forma3d("minha esfera");
		System.out.println(quadrado.getNome());
		System.out.println(esfera.getNome());

		Triangulo tri = new Triangulo("um triangulo", 2, 4, 10);
		System.out.println(tri.getPerimetro());

		Retangulo ret = new Retangulo("um retangulo", 3, 9);
		System.out.println("Perímetro do retângulo: " + ret.getPerimetro());
		System.out.println("Área do retângulo: " + ret.getArea());

		Forma f = new Retangulo("forma <-- retângulo", 2, 2);
		System.out.println(f.getNome());
		System.out.println(f.getClass());
		if (f instanceof Retangulo) {
			System.out.println(((Retangulo) f).getPerimetro());
		}

		System.out.println(tri instanceof Forma);
		System.out.println(tri instanceof Forma2d);
		System.out.println(f instanceof Forma2d);

		ArrayList<Forma> formas = new ArrayList<>();
		formas.add(quadrado);
		formas.add(esfera);
		formas.add(tri);
		formas.add(ret);
		formas.add(f);
		for (Forma forma : formas) {
			System.out.println(forma.getNome());
			int perimetro;
			if (forma instanceof Triangulo) {
				perimetro = ((Triangulo) forma).getPerimetro();
				System.out.println(perimetro);
			}
			if (forma instanceof Retangulo) {
				perimetro = ((Retangulo) forma).getPerimetro();
				System.out.println(perimetro);
			}
		}
	}

}
