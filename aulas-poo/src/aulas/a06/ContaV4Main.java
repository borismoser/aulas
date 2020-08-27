package aulas.a06;

import java.util.Scanner;

public class ContaV4Main {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);

		System.out.print("Informe o nome do titular da conta: ");
		String nome = ler.nextLine();

		// Criando uma instância para um objeto da classe Conta:
		ContaV4 c1 = new ContaV4(nome);

		// Inicialmente, o saldo está zerado:
		exibirDadosConta(c1);

		// Solicitando um valor para depósito:
		System.out.printf("Valor a depositar para %s: ", c1.getTitular());
		double valor = ler.nextDouble();
		// Atualizando o saldo por meio de um depósito:
		c1.depositar(valor);
		exibirDadosConta(c1);

		// Solicitando um valor para saque:
		System.out.printf("Valor a sacar de %s: ", c1.getTitular());
		valor = ler.nextDouble();
		// Atualizando o saldo por meio de um saque:
		c1.sacar(valor);
		exibirDadosConta(c1);

		// Criando uma instância para outro objeto da classe Conta:
		ContaV4 c2 = new ContaV4("Fulano de tal", 1000);
		exibirDadosConta(c2);
		c2.depositar(5000);
		exibirDadosConta(c2);
		c2.sacar(1500);
		exibirDadosConta(c2);

		// Os objetos são instâncias diferentes entre si:
		System.out.println();
		System.out.println(c1);
		System.out.println(c2);
	}

	private static void exibirDadosConta(ContaV4 conta) {
		String nome = conta.getTitular();
		double saldo = conta.getSaldo();
		System.out.printf("Titular: %s --> Saldo: %,.2f %n", nome, saldo);

	}

}
