package aulas.a15;

public class MoedaMain {

	public static void main(String[] args) {

		int caras = 0;
		int coroas = 0;
		
		for (int n=0; n < 1000; n++) {
			if (Sorteio.jogarMoeda() == FaceMoeda.CARA) {
				caras++;
			} else {
				coroas++;
			}
			
			//System.out.println(Sorteio.jogarMoeda());
		}
		System.out.println("Caras: " + caras);
		System.out.println("Coroas: " + coroas);
	}

}
