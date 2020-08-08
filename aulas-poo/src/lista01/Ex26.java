package lista01;

public class Ex26 {

	public static void main(String[] args) {
		int pedro = 155;
		int jose = 115;
		int anos = 0;
		do {
			pedro += 20;
			jose += 30;
			anos++;
		} while (pedro >= jose);
		System.out.println("Serão necessários " + anos + " anos para que José fique mais alto do que Pedro.");
		System.out.println("Altura de Pedro: " + pedro/100d);
		System.out.println("Altura de José: " + jose/100d);
	}

}
