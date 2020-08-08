package av3.correcao.esperandio;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;

import av3.Banco;

public class Av3 {

	private static Scanner input;
	private static boolean continuar = true;

	public static void main(String[] args) {		
		
		Banco.inicializar();
		
		while (continuar) {
			
			input = new Scanner(System.in);
		
			System.out.println("Avaliação");
			
			System.out.println("1 - listar as ações (símbolo e nome) disponíveis para consulta");
			System.out.println("2 - listar as informações de data, cotação de abertura, fechamento e volume de negociação de uma determinada ação (solicitar o símbolo), classificadas pelas datas mais recentes");
			System.out.println("3 - listar o dia com maior variação percentual positiva (e o percentual) entre abertura e fechamento de cada ação");
			System.out.println("4 - solicitar uma data, um valor em Reais e listar a quantidade (inteira) de ações que teria sido possível comprar de cada empresa (pela cotação de abertura) naquela data");
			System.out.println("5 - Sair");
			System.out.print("Opcao: ");
			int opcao = input.nextInt();
			
			switch (opcao) {
			case 1:
				listarAcoes();
				break;
			case 2:
				listarCotacoes();
				break;
			case 3:
				listarMaiorVariacao();
				break;
			case 4:
				listarPossibilidadeCompra();
				break;
			case 5:
				continuar = false;
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
			
		}		

	}

	private static void listarAcoes() {

		String sql = "SELECT simbolo, nome FROM acao";
		
		try (JdbcRowSet rs = ConexaoHSQL.executarSQL(sql)) {

			System.out.println("");

			while (rs.next()) {
				System.out.printf("Simbolo: " + rs.getString("simbolo") + " | Nome" + rs.getString("nome") + "\n");
			}

			System.out.println("");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void listarCotacoes() {

		System.out.print("Simbolo: ");
		String simbolo = input.next();
		
		String sql = "SELECT data, abertura, fechamento, volume FROM cotacao WHERE simbolo = ?";
		
		Object[] params = {simbolo};
		
		try (JdbcRowSet rs = ConexaoHSQL.executarSQL(sql, params)) {
			
			System.out.println("");

			while (rs.next()) {
				System.out.println(
					"Data: " + rs.getString("data") + 
					" | Abertura" + rs.getDouble("abertura") + 
					" | Fechamento" + rs.getDouble("fechamento") + 
					" | Volume" + rs.getDouble("volume")
				);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("");

	}
	
	private static void listarMaiorVariacao() {
		
		String sql = "SELECT simbolo, MAX(CASE WHEN abertura < fechamento THEN ((fechamento * 100) / abertura) - 100 ELSE 0 END) AS perc FROM cotacao GROUP BY simbolo";
		
		try (JdbcRowSet rs = ConexaoHSQL.executarSQL(sql)) {

			System.out.println("");

			while (rs.next()) {
				System.out.println(
					"Simbolo: " + rs.getString("simbolo") + 
					" | Perc.: " + rs.getDouble("perc") 
				);
			}

			System.out.println("");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void listarPossibilidadeCompra() {

		System.out.print("Data (AAAA-mm-dd): ");
		String data = input.next();
		
		System.out.print("Valor: ");
		double valor = input.nextDouble();
		
		String sql = "SELECT simbolo, abertura FROM cotacao WHERE data = ?";
		
		Object[] params = {data};
		
		try (JdbcRowSet rs = ConexaoHSQL.executarSQL(sql, params)) {
			
			System.out.println("");

			while (rs.next()) {
				System.out.println(
					"simbolo: " + rs.getString("simbolo") + 
					" | Abertura: " + rs.getDouble("abertura") +
					" | Quantidade: " + (int) (valor / rs.getDouble("abertura")) 
				);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("");

	}
	
}