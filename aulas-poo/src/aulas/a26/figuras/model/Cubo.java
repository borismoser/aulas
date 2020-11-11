package aulas.a26.figuras.model;

public class Cubo extends Figura3d {

	private double lado;

	public Cubo(String nome, double lado) {
		super(nome);
		this.lado = lado;
	}

	@Override
	public double getVolume() {
		return Math.pow(lado, 3);
	}
}
