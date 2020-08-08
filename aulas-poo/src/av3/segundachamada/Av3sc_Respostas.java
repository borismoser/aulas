package av3.segundachamada;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Av3sc_Respostas {

	public static void main(String[] args) {

		Banco.inicializar();

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean fim = false;
		do {
			System.out.println();
			System.out.println("A - Ver os produto disponíveis");
			System.out.println("B - Consultar histórico de vendas");
			System.out.println("C - Maiores altas");
			System.out.println("D - Percentual de lucro");
			System.out.println("F - Fim");
			System.out.print("Informe uma opção: ");
			switch (input.nextLine().toUpperCase().trim().charAt(0)) {
			case 'A':
				qA_listarProdutos();
				break;

			case 'B':
				System.out.print("Qual o código do produto que deseja consultar? ");
				qB_ConsultarHistorico(input.nextLine());
				break;

			case 'C':
				qC_MaiorFaturamento();
				break;

			case 'D':
				System.out.print("Qual data deseja consultar? (aaaa-mm-dd) ");
				LocalDate data = LocalDate.parse(input.nextLine());
				qD_Lucratividade(data);
				break;

			case 'F':
				System.out.println("Bye bye...");
				fim = true;
			}
		} while (!fim);
	}

//	A - listar os produtos (código e descrição) em ordem alfabética crescente de descrição (2 pontos);
//	B - listar as informações de data, preço de compra, preço de venda e quantidades vendidas de um determinado produto (solicitar o código), 
//		classificadas pelas datas mais recentes (2 pontos);
//	C - listar o dia com maior faturamento (preço de venda X quantidade) de cada produto, com respectivos valores (3 pontos);
//	D - solicitar uma data, e listar o percentual de lucro com as vendas de cada produto naquela data (3 pontos).

	private static void qD_Lucratividade(LocalDate data) {
		String sql = "select codigo, precoVenda / precoCompra as lucratividade from VENDAS where data = ?";
		try (PreparedStatement ps = Banco.conexao().prepareStatement(sql)) {
			ps.setDate(1, java.sql.Date.valueOf(data));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.isFirst()) {
					System.out.println();
					System.out.println("CÓDIGO LUCRO %");
					System.out.println("------ -------");
				}
				String codigo = rs.getString("codigo");
				Double lucratividade = (rs.getDouble("lucratividade") - 1) * 100;
				System.out.printf("%6s %5.2f %% %n", codigo, lucratividade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void qC_MaiorFaturamento() {

		Map<String, Faturamento> mapa = new HashMap<>();
		String sql = "select codigo, data, precoCompra, precoVenda, quantidade from VENDAS order by data desc";
		try (PreparedStatement ps = Banco.conexao().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				String codigo = rs.getString("codigo");
				LocalDate data = rs.getDate("data").toLocalDate();
				Double compra = rs.getDouble("precoCompra");
				Double venda = rs.getDouble("precoVenda");
				Integer quantidade = rs.getInt("quantidade");

				Faturamento f1 = mapa.get(codigo);
				Faturamento f2 = new Faturamento(codigo, data, compra, venda, quantidade);

				if ((f1 == null) || (f2.faturamento > f1.faturamento)) {
					mapa.put(codigo, f2);
				}

			}
			System.out.println();
			System.out.println("CÓDIGO DATA       QUANTIDADE  PÇ VENDA       TOTAL");
			System.out.println("------ ---------- ----------  ----------     --------");

			for (Map.Entry<String, Faturamento> par : mapa.entrySet()) {
				Faturamento f = par.getValue();
				System.out.printf("%s %s   %5d    %,8.2f     %,8.2f%n", f.codigo, f.data, f.quantidade, f.precoVenda,
						f.faturamento);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void qB_ConsultarHistorico(String produto) {
		String sql = "select codigo, data, precoCompra, precoVenda, quantidade from VENDAS where codigo = ? order by 2 desc";
		try (PreparedStatement ps = Banco.conexao().prepareStatement(sql)) {
			ps.setString(1, produto.toUpperCase().trim());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.isFirst()) {
					System.out.println();
					System.out.println("CÓDIGO DATA        PÇ COMPRA    PÇ VENDA     QTDD");
					System.out.println("------ ---------- ----------  ----------     ----");
				}
				String codigo = rs.getString("codigo");
				LocalDate data = rs.getDate("data").toLocalDate();
				Double precoCompra = rs.getDouble("precoCompra");
				Double precoVenda = rs.getDouble("precoVenda");
				Integer quantidade = rs.getInt("quantidade");
				System.out.printf("%6s %s   %,8.2f    %,8.2f     %d%n", codigo, data, precoCompra, precoVenda,
						quantidade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void qA_listarProdutos() {
		String sql = "select * from produtos order by 2";
		try (Statement st = Banco.conexao().createStatement()) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				if (rs.isFirst()) {
					System.out.println();
					System.out.println("Código Descrição");
					System.out.println("------ -------------------------------");
				}
				System.out.printf("%6s %s%n", rs.getString("codigo"), rs.getString("descricao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

class Faturamento {

	String codigo;
	LocalDate data;
	Double precoCompra;
	Double precoVenda;
	Integer quantidade;
	Double faturamento;

	public Faturamento(String codigo, LocalDate data, Double precoCompra, Double precoVenda, Integer quantidade) {
		this.codigo = codigo;
		this.data = data;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.faturamento = this.quantidade * this.precoVenda;
	}

}