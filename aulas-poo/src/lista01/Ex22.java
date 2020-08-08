package lista01;

public class Ex22 {

	public static void main(String[] args) {
		int idade = 0;
		int maiorIdade = 0;
		String nomeMaiorIdade = "";
		String nome = Ex00.lerString("Nome: ").trim();
		while (!nome.equalsIgnoreCase("fim")) {
			idade = Ex00.lerInt("Idade: ");
			if (idade > maiorIdade) {
				maiorIdade = idade;
				nomeMaiorIdade = nome;
			}
			nome = Ex00.lerString("Nome: ").trim();
		}
		if (!nomeMaiorIdade.equals("")) {
			System.out.printf("Pessoa mais velha: %s, com %d anos.", nomeMaiorIdade, maiorIdade);
		}
	}

}
