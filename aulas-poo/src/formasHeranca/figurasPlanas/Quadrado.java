package formasHeranca.figurasPlanas;

public final class Quadrado extends Paralelogramo {

	public Quadrado(String nome, double lado) {
		super(nome, lado, lado);
	}
	
	public double getLado() {
		return this.getLadoA();
	}
	
	@Override
	public boolean equals(Object outro) {
		if (outro == null) {
			return false;
		}
		if (this == outro) {
			return true;
		}
		if (outro instanceof Quadrado) {
			return this.getLadoA() == ((Quadrado) outro).getLadoA();
		}
		return false;
	}

}
