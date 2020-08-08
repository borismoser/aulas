package formasHeranca;

public class Paralelogramo extends Forma2d {
	private double ladoA;
	private double ladoB;

	public Paralelogramo(String nome, double ladoA, double ladoB) {
		super(nome);
		this.ladoA = ladoA;
		this.ladoB = ladoB;
	}
	
	@Override
	public double getPerimetro() {
		return 2 * (ladoA + ladoB);
	}
	
	@Override
	public double getArea() {
		return ladoA * ladoB;
	}

}
