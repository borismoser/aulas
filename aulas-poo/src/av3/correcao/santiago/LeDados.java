package av3.correcao.santiago;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.Map;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class LeDados {
	private static RowSetFactory rsFactory = null;
	
	public static void mostraAcoes() {
		System.out.println("Ações:");
		String query = "select simbolo, nome from Acao";
		
		try (JdbcRowSet rs = executaSQL(query)) {
			while (rs.next()) {
				System.out.println("Simbolo: " + rs.getString("simbolo") + " Nome: " + rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n");
	}
	
	public static void monstraCotacaoPorSimbolo(String simbolo) {
		String query = "select data, abertura, fechamento, volume from Cotacao where simbolo = '" + simbolo + "' order by data";
		
		try (JdbcRowSet rs = executaSQL(query)) {
			while (rs.next()) {
				System.out.println("Data: " + rs.getDate("data") + ", Abertura: " + rs.getDouble("abertura") + ", Fechamento: " + rs.getDouble("fechamento") + ", Volume: " + rs.getInt("volume"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n");
	}
	
	public static void mostraDiaMaiorVariacaoPercentual() {
		String query = "select data, abertura, fechamento from Cotacao";
		
		LocalDate data = LocalDate.now();
		BigDecimal percentual = new BigDecimal("0");
		
		try (JdbcRowSet rs = executaSQL(query)) {
			while (rs.next()) {
				BigDecimal abertura = rs.getBigDecimal("abertura");
				BigDecimal fechamento = rs.getBigDecimal("fechamento");
				BigDecimal variacao = (fechamento.subtract(abertura)).divide(abertura, 10, RoundingMode.DOWN).multiply(new BigDecimal(100));  
				
				if (variacao.compareTo(percentual) > 0) {
					percentual = variacao;
					data = rs.getDate("data").toLocalDate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Data: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\nPercentual: " + percentual + "%");
		System.out.println("\n");
	}
	
	public static void mostraPossiveisAcoes(BigDecimal valor, LocalDate data) {
		String query = "select simbolo, abertura from Cotacao where data = '" + data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +"'";
	
		try (JdbcRowSet rs = executaSQL(query)) {
			while (rs.next()) {
				BigDecimal qtdAcoes = valor.divide(rs.getBigDecimal("abertura"), 0, RoundingMode.DOWN);
				
				System.out.println("Simbolo: " + rs.getString("simbolo") + ", Qtd. Ações: " + qtdAcoes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static JdbcRowSet executaSQL(String query) throws SQLException {
		JdbcRowSet rs = null;
		try {
			if (rsFactory == null) {
				rsFactory = RowSetProvider.newFactory();
			}
			
			rs = rsFactory.createJdbcRowSet();
			rs.setUrl("jdbc:hsqldb:mem:memorydb:");
			rs.setCommand(query);
			rs.execute();
		} catch (SQLException e) {
			throw e;
		}
		
		return rs;
	}
}
