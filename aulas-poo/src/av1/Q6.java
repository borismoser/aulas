package av1;

public class Q6 {

	public static void main(String[] args) {
		int x = (int) Math.round(Math.random()*10);
		System.out.println("Nota: " + x);
		
		if (x < 7) { System.out.println("Aluno reprovado."); }

		if (x >= 7) { System.out.println("Aluno aprovado"); }
	}

}
