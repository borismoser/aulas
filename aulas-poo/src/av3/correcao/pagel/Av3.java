package av3.correcao.pagel;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

import av3.Banco;

public class Av3 {

	public static void main(String[] args) throws SQLException {

		Banco.inicializar();
		
		String letra = Teclado.lerString("Digite a opção: (A,B,C,D ou E para sair): ");
		System.out.println("\n");
		
		do {
			if (letra.equals("A") || letra.equals("a")) {

				Av3Dao.imprimirAcoes();
				System.out.println("\n");

			}

			if (letra.equals("B") || letra.equals("b")) {

				String simbolo = Teclado.lerString("Digite o simbolo desejado: ");
				Av3Dao.imprimirInformacoesConformeSimbolo(simbolo);

			}

			if (letra.equals("C") || letra.equals("c")) {

				Av3Dao.imprimirVaricaoPercentual();

			}

			if (letra.equals("D") || letra.equals("d")) {

				String data = Teclado.lerString("Digite a data desejada: (formato: yyyy-mm-dd) ");
				Double valor = Teclado.lerDouble("Digite o valor desejado: ");
				System.out.println("\n");

				Av3Dao.imprimirTotalAcoes(LocalDate.parse(data), new BigDecimal(valor));

			}
			
			letra = Teclado.lerString("Digite a opção: (A,B,C,D ou E para sair): ");
			System.out.println("\n");
		}
		while(!letra.equalsIgnoreCase("e"));
		
		
		System.out.println("Fim do programa");
	}

}