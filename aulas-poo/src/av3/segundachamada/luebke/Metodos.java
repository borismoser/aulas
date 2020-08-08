package av3.segundachamada.luebke;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import java.util.Scanner;

public class Metodos {

	private static String hsql = "jdbc:hsqldb:mem:memorydb:";
	private static String usr = "SA";
	private static String pwd = "";
	private static RowSetFactory rsFactory = null;
	private static Scanner scanner = new Scanner(System.in);

	private static void menu() {
		System.out.println("--Menu--");
		System.out.println("1. listar os produtos");
		System.out.println("2. Ler concurso de uma data espec�fica");
		System.out.println("3. Mostrar todos os concursos previamente simulados");
		System.out.println("4. Mostrar lot�ricas com vencedores previamente simulados");
		System.out.println("0. Sair");
	}

	public static boolean menuOpcoes() {
		menu();
		int opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			listarTodosProdutos();
			break;

		case 2:
			System.out.println("Informe o código do produto: ");
			String codigo = scanner.next();
			listarProduto(codigo);
			break;

		case 3:
			maiorFaturamento();
			break;

		case 4:
			lucroProduto();
			break;

		case 0:
			return true;
		}

		return false;
	}

	private static void listarTodosProdutos() {
		System.out.println("Lista de produtos");
		String sql = "select codigo, descricao from PRODUTOS order by descricao DESC";

		try (JdbcRowSet rs = Metodos.executarSQL(sql)) {
			while (rs.next()) {
				System.out.printf("%s %s", "Codigo:" + rs.getString("codigo") + " / Descrição: ",
						rs.getString("descricao") + "\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void listarProduto(String codigo) {
			String sql = "select data, precoCompra, precoVenda, quantidade from VENDAS where codigo = '"+ codigo +"' order by data";
			try (JdbcRowSet rs = Metodos.executarSQL(sql)) {
				while (rs.next()) {
					LocalDate dia = rs.getDate("data").toLocalDate();
					System.out.println("Data: " + dia + " precoCompra: " + rs.getDouble("precoCompra") + " precoVenda: " + rs.getDouble("precoVenda") + " quantidade: " + rs.getInt("quantidade"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	private static void maiorFaturamento() {
		System.out.println("Faturamento");
		String sql = "select codigo, data, precoVenda * quantidade as faturamento from VENDAS order by faturamento";

		try (JdbcRowSet rs = Metodos.executarSQL(sql)) {
			while (rs.next()) {

				LocalDate dia = rs.getDate("data").toLocalDate();
				System.out.println("Código: "+rs.getString("codigo") + " Faturamento: " + rs.getDouble("valor") + " Dia: " + dia);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void lucroProduto() {
		System.out.println("Lista de produtos");
		String sql = "select codigo, descricao from PRODUTOS order by descricao DESC";

		try (JdbcRowSet rs = Metodos.executarSQL(sql)) {
			while (rs.next()) {
				System.out.printf("Código: ", rs.getString("codigo") + "/ Descrição: " + rs.getString("descricao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static JdbcRowSet executarSQL(String SQL) throws SQLException {
		JdbcRowSet rs = null;
		try {
			if (rsFactory == null) {
				rsFactory = RowSetProvider.newFactory();
			}
			rs = rsFactory.createJdbcRowSet();
			rs.setUrl(hsql);
			rs.setUsername(usr);
			rs.setPassword(pwd);
			rs.setCommand(SQL);
			rs.execute();
		} catch (SQLException e) {
			throw e;
		}
		return rs;
	}

}
