package formasHerancaAbstractFinal.classes;

public class Cubo extends Forma3d {

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
