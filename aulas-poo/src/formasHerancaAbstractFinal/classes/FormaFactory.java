package formasHerancaAbstractFinal.classes;

public class FormaFactory {

	public static int RETANGULO=1;
	public static int TRI_ISO=2;
	/*
	public static Forma novaForma(int tipo, String nome, int a, int b) {
		switch (tipo) {
		case RETANGULO:
			
			break;

		default:
			break;
		}
		switch (tipo)
		case 1: // novo retangulo
		case 2: // novo triangulo isosceles
	}
	
	public static Forma novaForma(int tipo, String nome, int a) {
		switch (tipo)
		case 3: // novo quadrado
		case 4: // novo circulo
	}
	*/
	public static Forma novoRetangulo(String nome, int a, int b) {
		Retangulo r = new Retangulo(nome, a, b);
		return r;
	}
	
	public static Forma novoQuadrado(String nome, int a) {
		Quadrado q = new Quadrado(nome, a);
		return q;
	}
}
