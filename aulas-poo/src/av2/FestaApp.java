package av2;

public class FestaApp {

	public static void main(String[] args) {
		Festa festa = new Festa("Aniversário da minha mãe");
		festa.setOrganizador(new Pessoa("Eu", "3210-0123", Sexo.MASCULINO));
		convidarPessoas(festa, 35);
		festa.imprimirConvites();
		System.out.println("Pessoas convidadas: " + festa.getQtdeConvidados());
		System.out.println("Pessoas confirmadas: " + festa.getQtdePessoasConfirmadas());
		
		// Operações bônus:

		System.out.println("Mulheres convidadas: " + festa.getQtdeConvidados(Sexo.FEMININO));
		System.out.println("Mulheres confirmadas: " + festa.getQtdePessoasConfirmadas(Sexo.FEMININO));
		System.out.println("Homens convidados: " + festa.getQtdeConvidados(Sexo.MASCULINO));
		System.out.println("Homens confirmados: " + festa.getQtdePessoasConfirmadas(Sexo.MASCULINO));
	}
	
	private static void convidarPessoas(Festa festa, int qtde) {
		Pessoa pessoa;
		Sexo sexo;
		boolean acompanhado;
		boolean confirmado;
		for (int i = 0; i < qtde; i++) {
			sexo = Math.random() < 0.5 ? Sexo.FEMININO : Sexo.MASCULINO;
			acompanhado = Math.random() < 0.5;
			confirmado = Math.random() < 0.5;
			pessoa = new Pessoa("Pessoa "+i, Integer.toString(i), sexo);
			festa.convidar(pessoa, acompanhado, confirmado);
		}
	}

}
