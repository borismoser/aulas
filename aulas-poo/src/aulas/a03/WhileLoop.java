package aulas.a03;

import java.util.Scanner;

public class WhileLoop {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		int senha = 456;
		int tentativas = 0;
		boolean acertou = false;
		int digitado;

		while (tentativas < 3 && !acertou) {
			System.out.print("Informe a senha: ");
			digitado = teclado.nextInt();
			if (senha == digitado) {
				acertou = true;
			} else {
				tentativas++;
				System.out.println("Senha incorreta. Tentativas restantes: " + (3-tentativas));
			}
		}

		if (acertou) {
			System.out.println("Acesso permitido.");
		} else {
			System.out.println("Acesso negado.");
		}
	}

}
