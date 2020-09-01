package outros;

public class EleicaoMain {

	public static void main(String[] args) {

		System.out.println("Elei��es: " + Eleicao.getQtdEleicoes());
		
		int eleitores = Teclado.lerInt("N�mero de eleitores: ");
		int brancos = Teclado.lerInt("N�mero de votos brancos: ");
		int nulos = Teclado.lerInt("N�mero de votos nulos: ");
		int validos = Teclado.lerInt("N�mero de votos v�lidos: ");
		
		Eleicao municipal = new Eleicao(eleitores, brancos, nulos, validos);
		System.out.println("Elei��es: " + Eleicao.getQtdEleicoes());
	
		double pctBrancos = municipal.getPctVotosBrancos();
		double pctNulos = municipal.getPctVotosNulos();
		double pctValidos = municipal.getPctVotosValidos();

		System.out.printf("Votos brancos: %1.2f%%%n", pctBrancos);
		System.out.printf("Votos nulos: %1.2f%%%n", pctNulos);
		System.out.printf("Votos v�lidos: %1.2f%%%n", pctValidos);

		
		eleitores = Teclado.lerInt("N�mero de eleitores: ");
		brancos = Teclado.lerInt("N�mero de votos brancos: ");
		nulos = Teclado.lerInt("N�mero de votos nulos: ");
		validos = Teclado.lerInt("N�mero de votos v�lidos: ");
		
		Eleicao estadual = new Eleicao(eleitores, brancos, nulos, validos);
		System.out.println("Elei��es: " + Eleicao.getQtdEleicoes());
		
		pctBrancos = estadual.getPctVotosBrancos();
		pctNulos = estadual.getPctVotosNulos();
		pctValidos = estadual.getPctVotosValidos();

		System.out.printf("Votos brancos: %1.2f%%%n", pctBrancos);
		System.out.printf("Votos nulos: %1.2f%%%n", pctNulos);
		System.out.printf("Votos v�lidos: %1.2f%%%n", pctValidos);

	}

}