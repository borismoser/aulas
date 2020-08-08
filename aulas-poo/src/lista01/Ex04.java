package lista01;

public class Ex04 {

	public static void main(String[] args) {

		int eleitores = Ex00.lerInt("Número de eleitores: ");
		int brancos = Ex00.lerInt("Número de votos brancos: ");
		int nulos = Ex00.lerInt("Número de votos nulos: ");
		int validos = Ex00.lerInt("Número de votos válidos: ");

		System.out.printf("Votos brancos: %1.2f%%%n", calcularPercentual(brancos, eleitores));
		System.out.printf("Votos nulos: %1.2f%%%n", calcularPercentual(nulos, eleitores));
		System.out.printf("Votos válidos: %1.2f%%%n", calcularPercentual(validos, eleitores));

		Eleicao eleicao = new Eleicao(eleitores, brancos, nulos, validos);

		System.out.printf("Votos brancos: %1.2f%%%n", eleicao.getPercentualVotosBrancos());
		System.out.printf("Votos nulos: %1.2f%%%n", eleicao.getPercentualVotosNulos());
		System.out.printf("Votos válidos: %1.2f%%%n", eleicao.getPercentualVotosValidos());
	}
	
	private static float calcularPercentual(float parte, float todo) {
		return parte / todo * 100;
	}

}