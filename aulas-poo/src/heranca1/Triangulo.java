package heranca1;

public class Triangulo extends Forma2d {
	private int ladoA;
	private int ladoB;
	private int ladoC;

	public Triangulo(String nome, int ladoA, int ladoB, int ladoC) {
		super(nome);
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}
	
	public int getPerimetro() {
		return ladoA + ladoB + ladoC;
	}

}
