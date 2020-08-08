package formasHerancaInterface.app;

import java.util.ArrayList;

import formasHerancaAbstractFinal.classes.Cubo;
import formasHerancaAbstractFinal.classes.Esfera;
import formasHerancaAbstractFinal.classes.Forma;
import formasHerancaAbstractFinal.classes.Forma2d;
import formasHerancaAbstractFinal.classes.Paralelogramo;
import formasHerancaAbstractFinal.classes.Quadrado;
import formasHerancaAbstractFinal.classes.Retangulo;
import formasHerancaAbstractFinal.classes.Triangulo;
import formasHerancaAbstractFinal.classes.TrianguloEquilatero;
import formasHerancaAbstractFinal.classes.TrianguloEscaleno;
import formasHerancaAbstractFinal.classes.TrianguloIsosceles;

public class Main {

	public static void main(String[] args) {

		Quadrado q1 = new Quadrado("q1", 3);
		Quadrado q2 = new Quadrado("q2", 3);
		System.out.println(q1.equals(q2));
		System.out.println(q1 == q2);
		
		System.exit(0);
		
		TrianguloEquilatero teq = new TrianguloEquilatero("tri equil�tero", 8);
		TrianguloIsosceles tis = new TrianguloIsosceles("tri is�sceles", 8, 3);
		TrianguloEscaleno tes = new TrianguloEscaleno("tri escaleno", 3, 4, 5);

		System.out.println("Per�metro " + teq.getNome() + ": " + teq.getPerimetro());
		System.out.println("�rea " + teq.getNome() + ": " + teq.getArea());
		System.out.println();
		System.out.println("Per�metro " + tis.getNome() + ": " + tis.getPerimetro());
		System.out.println("�rea " + tis.getNome() + ": " + tis.getArea());
		System.out.println();
		System.out.println("Per�metro " + tes.getNome() + ": " + tes.getPerimetro());
		System.out.println("�rea " + tes.getNome() + ": " + tes.getArea());
		System.out.println();

		ArrayList<Triangulo> tris = new ArrayList<>();
		tris.add(teq);
		tris.add(tis);
		tris.add(tes);

		System.out.println(0 + " --> " + tris.get(0).getNome() + " --> " + tris.get(0).getClass());
		System.out.println(1 + " --> " + tris.get(1).getNome() + " --> " + tris.get(1).getClass());
		System.out.println(2 + " --> " + tris.get(2).getNome() + " --> " + tris.get(2).getClass());
		System.out.println();

		for (Triangulo t : tris) {
			System.out.println(t.getNome() + ": �rea = " + t.getArea() + " Per�metro = " + t.getPerimetro());
		}
		System.out.println();

		Forma ff = new TrianguloEscaleno("forma <-- tri escaleno", 3, 4, 5);
		System.out.println(ff.getNome());
		System.out.println(ff.getClass());
		double x = ((Triangulo) ff).getPerimetro();
		System.out.println("Per�metro : " + x);
		System.out.println();

		System.out.println(teq.getNome() + " � uma Forma? " + (teq instanceof Forma));
		System.out.println(tis.getNome() + " � uma Forma2d? " + (tis instanceof Forma2d));
		System.out.println(ff.getNome() + " � um Triangulo? " + (ff instanceof Triangulo));
		System.out.println();

		Retangulo ret = new Retangulo("um retangulo", 3, 9);
		System.out.println("Per�metro do ret�ngulo: " + ret.getPerimetro());
		System.out.println("�rea do ret�ngulo: " + ret.getArea());
		System.out.println();

		Quadrado qua = new Quadrado("um quadrado", 5);
		Paralelogramo parQua = qua;
		System.out.println("Per�metro do quadrado: " + parQua.getPerimetro());
		System.out.println("�rea do quadrado: " + parQua.getArea());
		System.out.println();

		Cubo cb = new Cubo("Cubinho", 3);
		System.out.println("Volume do cubo: " + cb.getVolume());
		System.out.println();

		Esfera es = new Esfera("Esferinha", 5);
		System.out.println("Volume da esfera: " + es.getVolume());
		System.out.println();

		ArrayList<Forma> formas = new ArrayList<>();
		formas.add(teq);
		formas.add(tis);
		formas.add(tes);
		formas.add(ff);
		formas.add(ret);
		formas.add(qua);
		formas.add(cb);
		formas.add(es);
		for (Forma forma : formas) {
			if (forma instanceof Triangulo) {
				System.out.print("Tri�ngulo: ");
			} else if (forma instanceof Quadrado) {
				System.out.print("Quadrado: ");
			} else {
				System.out.print(forma.getClass().getName() + ": ");
			}
			System.out.println(forma.getNome());
		}
	}
}
