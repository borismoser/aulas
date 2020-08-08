package formasHeranca.figurasEspaciais;

public class Esfera extends Forma3d {

	private double raio;
	
	public Esfera(String nome, double raio) {
		super(nome);
		this.raio = raio;
	}
	
	@Override
	public double getVolume() {
		return (4.0/3.0) * Math.PI * Math.pow(raio, 3);
	}

}
