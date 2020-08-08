package heranca1;

public class Retangulo extends Forma2d {
	private int ladoA;
	private int ladoB;

	public Retangulo(String nome, int ladoA, int ladoB) {
		super(nome);
		this.ladoA = ladoA;
		this.ladoB = ladoB;
	}
	
	public int getPerimetro() {
		return 2 * (ladoA + ladoB);
	}
	
	//@Override
	public int getArea() {
		return ladoA * ladoB;
		//return super.getArea();
	}

}
