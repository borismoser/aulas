package av3.correcao.santiago;

import java.util.Scanner;

import av3.Banco;

public class Av3 {

	public static void main(String[] args) {
		Banco.inicializar();

		Scanner scanner = new Scanner(System.in);
		
		String opcao;
		
		do {
			Menu.monstraMenu();
			opcao = scanner.next();
			Menu.leOpcao(opcao);
		} while (!opcao.equals("0"));
	}

}