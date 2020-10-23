package triangulos;

public class Triangulo {
	private String nome;
	private double ladoA;
	private double ladoB;
	private double ladoC;

	public Triangulo(String nome, double ladoA, double ladoB, double ladoC) {
		this.nome = nome;
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}

	public double getPerimetro() {
		return ladoA + ladoB + ladoC;
	}

	public double getArea() {
		// semiperímetro = perímetro / 2
		double sp = this.getPerimetro() / 2;
		double area = Math.sqrt(sp * (sp - ladoA) * (sp - ladoB) * (sp - ladoC));
		return area;
	}

	@Override
	public String toString() {
		return "Triangulo [nome=" + nome + ", ladoA=" + ladoA + ", ladoB=" + ladoB + ", ladoC=" + ladoC + "]";
	}

}
