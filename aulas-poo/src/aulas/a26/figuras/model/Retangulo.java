package aulas.a26.figuras.model;

public final class Retangulo extends Paralelogramo {

	public Retangulo(String nome, double ladoA, double ladoB) {
		super(nome, ladoA, ladoB);
	}

	public double getLadoMaior() {
		return (getLadoA() > getLadoB() ? getLadoA() : getLadoB());
	}
	
	public double getLadoMenor() {
		return (getLadoA() < getLadoB() ? getLadoA() : getLadoB());
	}

}
