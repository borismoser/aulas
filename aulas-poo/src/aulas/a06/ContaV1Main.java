package aulas.a06;

import java.util.Scanner;

public class ContaV1Main {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);

		// Criando uma instância para um objeto da classe Conta:
		ContaV1 c1 = new ContaV1();

		// Inicialmente, a informação do titular está nula:
		System.out.println("Titular da conta 1: " + c1.getTitular());

		// Atualizando a informação do titular da conta:
		System.out.print("Informe o nome do titular da conta 1: ");
		String nome = ler.nextLine();
		c1.setTitular(nome);
		// Agora o objeto contém a informação atualizada do titular:
		System.out.println("Titular da conta 1: " + c1.getTitular());

		// Criando uma instância para outro objeto da classe Conta:
		ContaV1 c2 = new ContaV1();
		System.out.println("Titular da conta 2: " + c2.getTitular());
		c2.setTitular("Fulano de tal");
		System.out.println("Titular da conta 2: " + c2.getTitular());

		// Os objetos são instâncias diferentes entre si:
		System.out.println();
		System.out.println(c1);
		System.out.println(c2);
	}

}
