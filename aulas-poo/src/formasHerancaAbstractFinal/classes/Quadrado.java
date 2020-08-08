package formasHerancaAbstractFinal.classes;

public class Quadrado extends Paralelogramo {

	public Quadrado(String nome, double lado) {
		super(nome, lado, lado);
	}
	
	public double getLado() {
		return super.getLadoA();
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
			return this.getLado() == ((Quadrado) outro).getLado();
		}
		return false;
	}

}
