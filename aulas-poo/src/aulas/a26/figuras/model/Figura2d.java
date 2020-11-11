package aulas.a26.figuras.model;

public abstract class Figura2d extends Figura {

	public Figura2d(String nome) {
		super(nome);
	}

	public abstract double getArea();

	public abstract double getPerimetro();

}
