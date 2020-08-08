package outros;

public class EleicaoMain {

	public static void main(String[] args) {

		System.out.println("Eleições: " + Eleicao.getQtdEleicoes());
		
		int eleitores = ler.lerInteiro("Número de eleitores: ");
		int brancos = ler.lerInteiro("Número de votos brancos: ");
		int nulos = ler.lerInteiro("Número de votos nulos: ");
		int validos = ler.lerInteiro("Número de votos válidos: ");
		
		Eleicao municipal = new Eleicao(eleitores, brancos, nulos, validos);
		System.out.println("Eleições: " + Eleicao.getQtdEleicoes());
	
		double pctBrancos = municipal.getPctVotosBrancos();
		double pctNulos = municipal.getPctVotosNulos();
		double pctValidos = municipal.getPctVotosValidos();

		System.out.printf("Votos brancos: %1.2f%%%n", pctBrancos);
		System.out.printf("Votos nulos: %1.2f%%%n", pctNulos);
		System.out.printf("Votos válidos: %1.2f%%%n", pctValidos);

		
		eleitores = ler.lerInteiro("Número de eleitores: ");
		brancos = ler.lerInteiro("Número de votos brancos: ");
		nulos = ler.lerInteiro("Número de votos nulos: ");
		validos = ler.lerInteiro("Número de votos válidos: ");
		
		Eleicao estadual = new Eleicao(eleitores, brancos, nulos, validos);
		System.out.println("Eleições: " + Eleicao.getQtdEleicoes());
		
		pctBrancos = estadual.getPctVotosBrancos();
		pctNulos = estadual.getPctVotosNulos();
		pctValidos = estadual.getPctVotosValidos();

		System.out.printf("Votos brancos: %1.2f%%%n", pctBrancos);
		System.out.printf("Votos nulos: %1.2f%%%n", pctNulos);
		System.out.printf("Votos válidos: %1.2f%%%n", pctValidos);

	}

}