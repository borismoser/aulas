package av3.correcao.elison.br.com.prova.components;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import av3.correcao.elison.br.com.prova.services.MenuService;

public class Menu {

	private static Scanner scanner = new Scanner(System.in);

	public static void showMenu() {
		MenuService menuService = new MenuService();
		int n = 0;
		do {
			System.out.println("-------MENU-------");
			System.out.println(" 1) Listar as Acões");
			System.out.println(" 2) Listar informações");
			System.out.println(" 3) Listar dia com maior variação");
			System.out.println(" 4) Quantidade a comprar de cada uma");
			n = scanner.nextInt();
			switch (n) {
			case 1:
				menuService.printAllAcoes();
				break;
			case 2:
				System.out.println("Informe um Simbolo: ");
				String simbolo = scanner.next();
				menuService.printAllCotacoesByAcao(simbolo);
				break;
			case 3:
				menuService.printMaxPercentByAcoes();
				break;
			case 4:
				System.out.println("Informe uma Data: ");
				String date = scanner.next();
				System.out.println("Informe o valor em reais: ");
				BigDecimal value = scanner.nextBigDecimal();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDate = LocalDate.parse(date, formatter);
				menuService.printAmountBuyAcoesInDate(localDate, value);
				break;
			}
		} while (n != 0);
	}
}
