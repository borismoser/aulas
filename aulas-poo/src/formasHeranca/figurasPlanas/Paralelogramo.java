package formasHeranca.figurasPlanas;

public abstract class Paralelogramo extends Forma2d {
	private double ladoA;
	private double ladoB;

	public Paralelogramo(String nome, double ladoA, double ladoB) {
		super(nome);
		this.ladoA = ladoA;
		this.ladoB = ladoB;
	}
	
	@Override
	public final double getPerimetro() {
		return 2 * (ladoA + ladoB);
	}
	
	@Override
	public final double getArea() {
		return ladoA * ladoB;
	}
	
	double getLadoA() {
		return ladoA;
	}
	
	protected double getLadoB() {
		return ladoB;
	}


}
