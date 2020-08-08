package av3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Av3 {

	public static void main(String[] args) {

		Banco.inicializar();

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String acao;
		int opcao = 0;
		do {
			System.out.println();
			System.out.println("1 - Consulta de ações disponíveis");
			System.out.println("2 - Consulta de cotações");
			System.out.println("3 - Maiores altas");
			System.out.println("4 - Poder de compra");
			System.out.println("0 - Sair");
			System.out.print("Informe uma opção: ");
			opcao = input.nextInt();
			input.nextLine();
			switch (opcao) {
			case 1:
				qA_listarAcoes();
				break;

			case 2:
				System.out.print("Qual ação deseja consultar? ");
				acao = input.nextLine();
				qB_ConsultarCotacoes(acao);
				break;

			case 3:
				qC_MaioresAltas();
				break;

			case 4:
				System.out.print("Qual data deseja consultar? (aaaa-mm-dd) ");
				LocalDate data = LocalDate.parse(input.nextLine());
				System.out.print("Qual valor? ");
				BigDecimal valor = new BigDecimal(input.nextLine());
				qD_poderDeCompra(data, valor);
				break;

			case 0:
				System.out.println("Bye bye...");
				break;
			}
		} while (opcao != 0);
	}

//	A - listar as ações (símbolo e nome) disponíveis para consulta (2 pontos);
//	B - listar as informações de data, cotação de abertura, fechamento e volume de negociação de uma determinada ação (solicitar o símbolo), 
//		classificadas pelas datas mais recentes (2 pontos);
//	C - listar o dia com maior variação percentual positiva (e o percentual) entre abertura e fechamento de cada ação (3 pontos);
//	D - solicitar uma data, um valor em Reais e listar a quantidade (inteira) de ações que teria sido possível comprar de cada empresa 
//		(pela cotação de abertura) naquela data (3 pontos).

	private static void qB_ConsultarCotacoes(String acao) {
		String sql = "select simbolo, data, abertura, fechamento, volume from cotacao where simbolo = ? order by 2 desc";
		try (PreparedStatement ps = Banco.conexao().prepareStatement(sql)) {
			ps.setString(1, acao.toUpperCase());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.isFirst()) {
					System.out.println();
					System.out.println("AÇÃO  DATA         ABERTURA  FECHAMENTO       VOLUME");
					System.out.println("----  ---------- ----------  ----------     --------");
				}
				String simbolo = rs.getString("simbolo");
				LocalDate data = rs.getDate("data").toLocalDate();
				BigDecimal abertura = new BigDecimal(Double.toString(rs.getDouble("abertura")));
				BigDecimal fechamento = new BigDecimal(Double.toString(rs.getDouble("fechamento")));
				Integer volume = rs.getInt("volume");
				System.out.printf("%s %s   %8.2f    %8.2f     %d%n", simbolo, data, abertura, fechamento, volume);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void qC_MaioresAltas() {

//		select a.simbolo, a.data, (a.fechamento/a.abertura * 100 -100) a.variacao from Cotacao a,
//		(select max(fechamento/abertura * 100 -100) maxvariacao, simbolo from Cotacao group by simbolo) b
//		where a.simbolo = b.simbolo and (a.fechamento/a.abertura * 100 -100) = b.maxvariacao
//		order by a.data

		Map<String, Cotacao> mapa = new HashMap<>();
		String sql = "select simbolo, data, abertura, fechamento from cotacao order by data desc";
		try (PreparedStatement ps = Banco.conexao().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				String simbolo = rs.getString("simbolo");
				LocalDate data = rs.getDate("data").toLocalDate();
				Double abertura = rs.getDouble("abertura");
				Double fechamento = rs.getDouble("fechamento");

				Cotacao c1 = mapa.get(simbolo);
				Cotacao c2 = new Cotacao(simbolo, data, abertura, fechamento);

				if ((c1 == null) || (c2.variacao > c1.variacao)) {
					mapa.put(simbolo, c2);
				}

			}
			System.out.println();
			System.out.println("AÇÃO  DATA         ABERTURA  FECHAMENTO     VARIAÇÃO");
			System.out.println("----  ---------- ----------  ----------     --------");

			for (Map.Entry<String, Cotacao> par : mapa.entrySet()) {
				Cotacao c = par.getValue();
				System.out.printf("%s %s   %8.2f    %8.2f     %8.5f%n", c.simbolo, c.data, c.abertura, c.fechamento,
						c.variacao);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void qD_poderDeCompra(LocalDate data, BigDecimal valor) {
		String sql = "select simbolo, abertura from cotacao where data = ?";
		try (PreparedStatement ps = Banco.conexao().prepareStatement(sql)) {
			ps.setDate(1, java.sql.Date.valueOf(data));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.isFirst()) {
					System.out.println();
					System.out.println("AÇÃO   ABERTURA  QT ACOES");
					System.out.println("-----  --------  --------");
				}
				String simbolo = rs.getString("simbolo");
				BigDecimal abertura = new BigDecimal(Double.toString(rs.getDouble("abertura")));
				int qtAcoes = valor.divide(abertura, RoundingMode.DOWN).intValue();
				System.out.printf("%s %8.2f  %d%n", simbolo, abertura, qtAcoes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void qA_listarAcoes() {
		String sql = "select * from acao";
		try (Statement st = Banco.conexao().createStatement()) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				if (rs.isFirst()) {
					System.out.println();
					System.out.println("AÇÃO   NOME");
					System.out.println("-----  -------------------------------");
				}
				System.out.printf("%s %s%n", rs.getString("simbolo"), rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

class Cotacao {
	String simbolo;
	LocalDate data;
	Double abertura;
	Double fechamento;
	Double variacao;

	public Cotacao(String simbolo, LocalDate data, Double abertura, Double fechamento) {
		super();
		this.simbolo = simbolo;
		this.data = data;
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.variacao = fechamento / abertura * 100 - 100;
	}

}