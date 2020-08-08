package av3.correcao.scottini;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import av3.Banco;

public class Av3 {

	public static void main(String[] args) throws SQLException {

		Banco.inicializar();
		Consultas c = new Consultas();

		Scanner s = new Scanner(System.in);

		int opcao = 0;

		do {
			System.out.println(
					"Bem vindo\nO que deseja fazer:\n 1 - Listar as a��es\n2 - Listar as informa��es de a��o espec�fica\n3 - Listar o dia com maior varia��o percentual positiva\n4 - Solicitar uma data, um valor em Reais e listar a quantidade de a��es que teria sido poss�vel comprar de cada empresa naquela data");
			opcao = s.nextInt();

			switch (opcao) {
			case 1:
				c.selecionarAcoesDisponiveis();
				break;

			case 2:
				System.out.println("Digite uma a��o");
				String acao = s.next();
				c.informacoesAcaoEspecifica(acao);
				break;
			case 3:
				c.maiorVariacao();
				break;
			case 4:
				System.out.println("Digite uma data no seguinte formato dd-mm-aaaa");
				String data = s.next();
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				Date dt = null;
				try {
					dt = df.parse(data);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				System.out.println("Digite uma quantidade de dinheiro");
				Double dinheiro = s.nextDouble();
				c.maxCompra(dt, dinheiro);
				break;
			case 0:

				break;
			default:
				System.out.println("Op��o inv�lida!");
				break;
			}

		} while (opcao != 0);

	}

}