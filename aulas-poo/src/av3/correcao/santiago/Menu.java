package av3.correcao.santiago;

import java.io.Console;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void monstraMenu() {
		System.out.println("Menu");
		System.out.println("A - Listar ações");
		System.out.println("B - Listar cotação");
		System.out.println("C - Maior variação percentual");
		System.out.println("D - Lista ações compráveis no dia");
		System.out.println("0 - Sair");
	}
	
	public static void leOpcao(String opcao) {
		switch (opcao.toUpperCase()) {
			case "A":
				LeDados.mostraAcoes();
				break;
				
			case "B":
				cotacaoPorSimbolo();
				break;
				
			case "C":
				LeDados.mostraDiaMaiorVariacaoPercentual();
				break;
				
			case "D":
				acoesCompraveis();
				break;
		}
	}
	
	private static void cotacaoPorSimbolo() {
		System.out.print("Informe o simbolo da cotação: ");
		String simbolo = scanner.next();
				
		LeDados.monstraCotacaoPorSimbolo(simbolo);
	}
	
	private static void acoesCompraveis() {
		System.out.print("Informe a data (dd/mm/aaaa): ");
		String dataString = scanner.next();
		LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.print("Informe um valor: ");
		BigDecimal valor = scanner.nextBigDecimal();
		
		LeDados.mostraPossiveisAcoes(valor, data);
	}
}
