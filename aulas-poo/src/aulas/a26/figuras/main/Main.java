package aulas.a26.figuras.main;

import java.util.ArrayList;

import aulas.a26.figuras.model.Cubo;
import aulas.a26.figuras.model.Esfera;
import aulas.a26.figuras.model.Figura;
import aulas.a26.figuras.model.Figura2d;
import aulas.a26.figuras.model.Paralelogramo;
import aulas.a26.figuras.model.Quadrado;
import aulas.a26.figuras.model.Retangulo;
import aulas.a26.figuras.model.Triangulo;
import aulas.a26.figuras.model.TrianguloEquilatero;
import aulas.a26.figuras.model.TrianguloEscaleno;
import aulas.a26.figuras.model.TrianguloIsosceles;

public class Main {

	public static void main(String[] args) {

		Quadrado q1 = new Quadrado("q1", 3);
		Quadrado q2 = new Quadrado("q2", 3);
		System.out.println(q1.equals(q2));
		System.out.println(q1 == q2);

		TrianguloEquilatero teq = new TrianguloEquilatero("tri equilátero", 8);
		TrianguloIsosceles tis = new TrianguloIsosceles("tri isósceles", 8, 3);
		TrianguloEscaleno tes = new TrianguloEscaleno("tri escaleno", 3, 4, 5);

		System.out.println("Perímetro " + teq.getNome() + ": " + teq.getPerimetro());
		System.out.println("Área " + teq.getNome() + ": " + teq.getArea());
		System.out.println();
		System.out.println("Perímetro " + tis.getNome() + ": " + tis.getPerimetro());
		System.out.println("Área " + tis.getNome() + ": " + tis.getArea());
		System.out.println();
		System.out.println("Perímetro " + tes.getNome() + ": " + tes.getPerimetro());
		System.out.println("Área " + tes.getNome() + ": " + tes.getArea());
		System.out.println();

		ArrayList<Triangulo> tris = new ArrayList<>();
		tris.add(teq);
		tris.add(tis);
		tris.add(tes);

		System.out.println(0 + " --> " + tris.get(0).getNome() + " --> " + tris.get(0).getClass().getSimpleName());
		System.out.println(1 + " --> " + tris.get(1).getNome() + " --> " + tris.get(1).getClass().getSimpleName());
		System.out.println(2 + " --> " + tris.get(2).getNome() + " --> " + tris.get(2).getClass().getSimpleName());
		System.out.println();

		for (Triangulo t : tris) {
			System.out.println(t.getNome() + ": Área = " + t.getArea() + " Perímetro = " + t.getPerimetro());
		}
		System.out.println();

		Figura ff = new TrianguloEscaleno("forma <-- tri escaleno", 3, 4, 5);
		System.out.println(ff.getNome());
		System.out.println(ff.getClass().getSimpleName());
		double x = ((Triangulo) ff).getPerimetro();
		System.out.println("Perímetro : " + x);
		System.out.println();

		System.out.println(teq.getNome() + " é uma Forma? " + (teq instanceof Figura));
		System.out.println(tis.getNome() + " é uma Forma2d? " + (tis instanceof Figura2d));
		System.out.println(ff.getNome() + " é um Triangulo? " + (ff instanceof Triangulo));
		System.out.println();

		Retangulo ret = new Retangulo("um retangulo", 3, 9);
		System.out.println("Perímetro do retângulo: " + ret.getPerimetro());
		System.out.println("Área do retângulo: " + ret.getArea());
		System.out.println("Lado maior do retângulo: " + ret.getLadoMaior());
		System.out.println("Lado menor do retângulo: " + ret.getLadoMenor());
		System.out.println();
		
		Quadrado qua = new Quadrado("um quadrado", 5);
		System.out.println("Lado do quadrado: " + qua.getLado());
		Paralelogramo parQua = qua;
		System.out.println("Perímetro do quadrado: " + parQua.getPerimetro());
		System.out.println("Área do quadrado: " + parQua.getArea());
		System.out.println();

		Cubo cb = new Cubo("Cubinho", 3);
		System.out.println("Volume do cubo: " + cb.getVolume());
		System.out.println();

		Esfera es = new Esfera("Esferinha", 5);
		System.out.println("Volume da esfera: " + es.getVolume());
		System.out.println();

		ArrayList<Figura> formas = new ArrayList<>();
		formas.add(teq);
		formas.add(tis);
		formas.add(tes);
		formas.add(ff);
		formas.add(ret);
		formas.add(qua);
		formas.add(cb);
		formas.add(es);
		for (Figura forma : formas) {
			if (forma instanceof Triangulo) {
				System.out.print("Triângulo: ");
			} else if (forma instanceof Quadrado) {
				System.out.print("Quadrado: ");
			} else {
				System.out.print(forma.getClass().getName() + ": ");
			}
			System.out.println(forma.getNome());
		}
	}
}
