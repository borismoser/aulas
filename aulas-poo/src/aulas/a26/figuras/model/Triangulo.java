package aulas.a26.figuras.model;

public abstract class Triangulo extends Figura2d {
	private double ladoA;
	private double ladoB;
	private double ladoC;

	public Triangulo(String nome, double ladoA, double ladoB, double ladoC) {
		super(nome);
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}

	@Override
	public final double getPerimetro() {
		return ladoA + ladoB + ladoC;
	}

	@Override
	public final double getArea() {
		// semiperímetro = perímetro / 2
		double sp = this.getPerimetro() / 2;
		double area = Math.sqrt(sp * (sp - ladoA) * (sp - ladoB) * (sp - ladoC));
		return area;
	}

}
