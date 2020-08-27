package aulas.a06;

import java.util.Scanner;

public class ContaV2Main {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);

		// Criando uma instância para um objeto da classe Conta:
		ContaV2 c1 = new ContaV2();

		// Inicialmente, a informação do titular está nula:
		System.out.println("Titular da conta 1: " + c1.getTitular());

		// Atualizando a informação do titular da conta:
		System.out.print("Informe o nome do titular da conta 1: ");
		String nome = ler.nextLine();
		c1.setTitular(nome);
		// Agora o objeto contém a informação atualizada do titular:
		System.out.println("Titular da conta 1: " + c1.getTitular());

		// Inicialmente, o saldo está zerado:
		System.out.println("Saldo da conta 1: " + c1.getSaldo());
		// Solicitando um valor para depósito:
		System.out.print("Valor a depositar na conta 1: ");
		double valor = ler.nextDouble();
		// Atualizando o saldo por meio de um depósito:
		c1.depositar(valor);
		System.out.println("Saldo da conta 1: " + c1.getSaldo());

		// Solicitando um valor para saque:
		System.out.print("Valor a sacar da conta 1: ");
		valor = ler.nextDouble();
		// Atualizando o saldo por meio de um saque:
		c1.sacar(valor);
		System.out.println("Saldo da conta 1: " + c1.getSaldo());

		
		// Criando uma instância para outro objeto da classe Conta:
		ContaV2 c2 = new ContaV2();
		System.out.println("Titular da conta 2: " + c2.getTitular());
		c2.setTitular("Fulano de tal");
		System.out.println("Titular da conta 2: " + c2.getTitular());
		System.out.println("Saldo da conta 2: " + c2.getSaldo());
		c2.depositar(5000);
		System.out.println("Saldo da conta 2: " + c2.getSaldo());
		c2.sacar(1500);
		System.out.println("Saldo da conta 2: " + c2.getSaldo());

		// Os objetos são instâncias diferentes entre si:
		System.out.println();
		System.out.println(c1);
		System.out.println(c2);
	}

}
