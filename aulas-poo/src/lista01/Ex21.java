package lista01;

public class Ex21 {

	public static void main(String[] args) {
		String aluno = Ex00.lerString("Nome do aluno: ");
		double total = 0, nota, media;
		int qtNotas = 0;
		do {
			nota = Ex00.lerDouble("Nota: ");
			if (nota >= 0) {
				total += nota;
				qtNotas++;
			}
		} while (nota >= 0);
		if (qtNotas > 0) {
			media = total / qtNotas;
			System.out.printf("Aluno: %s. Média = %1.2f", aluno, media);
		}
	}

}
