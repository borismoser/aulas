package av3.correcao.junior;

import java.sql.SQLException;
import java.util.Scanner;
import javax.sql.rowset.JdbcRowSet;

import av3.Banco;

public class Av3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco.inicializar();

		
		System.out.println("[1] Listar as a��es");
		System.out.println("[2] Listar informa��es de data");
		System.out.println("[3] Maior varia��o percentual");
		System.out.println("[4] Quantidade de A��es");
		System.out.println("[5] Sair\n");
		System.out.print("Op��o: ");
		Scanner teclado = new Scanner(System.in);
		int opcao = teclado.nextInt();	
		
		/*
		if (opcao == 1) {
			perguntaA();
		} else if (opcao == 2) {
			perguntaB();
		} else if (opcao == 3) {
			perguntaC();
		} else if (opcao == 4) {
			perguntaD();
		} else if (opcao == 5) {
			System.out.println("Saindo...");
		}
		*/
		
	}
	/*
	private static void perguntaA() {
		System.out.println("\nA-");
		String sql = "select simbolo, nome from acao;";
		try (JdbcRowSet rs = Banco.conexao().executarSQL(sql)) {
			while (rs.next()) {
				System.out.printf("%23s %1.5f %n", rs.getString("simbolo") + "/" + rs.getString("acao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void perguntaB() {
		System.out.println("\nB-");
		String sql = "select data, abertura, fechamento, volume from cotacao order by data asc;";
		try (JdbcRowSet rs = .executarSQL(sql)) {
			while (rs.next()) {
				System.out.printf("%23s %1.5f %n", rs.getString("data") + "/" + rs.getString("abertura") + "/" 
								 + rs.getString("fechamento") + "/" + rs.getString("volume"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void perguntaC() {
		System.out.println("\nC-");
		String sql = "select  ((fechamento/volume) - 1) as variavelpercentual from cotacao;";
		try (JdbcRowSet rs = .executarSQL(sql)) {
			while (rs.next()) {
				System.out.printf("%23s %1.5f %n", rs.getString("variavelpercentual"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void perguntaD() {
		System.out.println("\nD-");
		String sql = "select count(*) as quantidade from cotacao;";
		try (JdbcRowSet rs = .executarSQL(sql)) {
			while (rs.next()) {
				System.out.printf("%23s %1.5f %n", rs.getString("quantidade"));			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*/
}
