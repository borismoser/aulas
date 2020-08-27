package aulas.a06;

import java.util.Scanner;

public class ContaV3Main {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);

		System.out.print("Informe o nome do titular da conta 1: ");
		String nome = ler.nextLine();

		// Criando uma instância para um objeto da classe Conta:
		ContaV3 c1 = new ContaV3(nome);
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
		ContaV3 c2 = new ContaV3("Fulano de tal", 1000);
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
