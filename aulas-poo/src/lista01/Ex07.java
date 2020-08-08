package lista01;

public class Ex07 {

	public static void main(String[] args) {
		int co = Ex00.lerInt("Cateto oposto: ");
		int ca = Ex00.lerInt("Cateto adjacente: ");
		double hip = Math.sqrt(Math.pow(co, 2)+Math.pow(ca, 2));
		System.out.println("Hipotenusa = "+hip);
		System.out.printf("Hipotenusa = %.2f%n", hip);
		System.out.println("Hipotenusa (round) = " + Math.round(hip));
		System.out.println("Hipotenusa (ceil)  = " + Math.ceil(hip));
		System.out.println("Hipotenusa (floor) = " + Math.floor(hip));
	}

}
