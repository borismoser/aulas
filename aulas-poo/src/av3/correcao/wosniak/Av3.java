package av3.correcao.wosniak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import av3.Banco;

public class Av3 {

	public static void main(String[] args) {

		Banco.inicializar();
		System.out.println("-----------------------Questao A-----------------------");
		QuestaoA(Banco.conexao());
		System.out.println("-----------------------Questao B-----------------------");
		QuestaoB(Banco.conexao());
		System.out.println("-----------------------Questao C-----------------------");
		QuestaoC(Banco.conexao());
		System.out.println("-----------------------Questao D-----------------------");
		QuestaoD(Banco.conexao());

}
	public static void QuestaoA(Connection conn) {
		String sql = "select simbolo , nome from acao";
		Statement st = null;
		
		try (ResultSet rs = executarSQL(conn, sql)) {
			while (rs.next()) {
				System.out.printf("Nome: "+rs.getString("nome")+" | Simbolo: "+rs.getString("simbolo")+" \n");
			}
			st = rs.getStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void QuestaoB(Connection conn) {
		String simboloP = JOptionPane.showInputDialog("Informe uma Sigla");
		String sql = "	select a.nome,b.data,b.abertura,b.fechamento, b.volume "
				+ "		from acao a,"
				+ "		cotacao b "
				+ "		where a.simbolo = '"+simboloP.toUpperCase()+"'"
				+ "		and a.simbolo = b.simbolo"
				+ "		order by b.data desc";
		Statement st = null;
		
		try (ResultSet rs = executarSQL(conn, sql)) {
			while (rs.next()) {
				System.out.printf("Nome: "+rs.getString("nome")+" | Data: "+rs.getString("data")+" | Cotação de abertura: "+rs.getString("abertura")+" | Fechamento: "+rs.getString("fechamento")+" | Volume:"+rs.getString("volume")+" \n");
			}
			st = rs.getStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void QuestaoC(Connection conn) {
		String sql = "select a.nome,a.simbolo,b.data,b.abertura,b.fechamento"
				+ "		from acao a,"
				+ "		cotacao b "
				+ "		where a.simbolo = b.simbolo"
				+ "		order by b.data";
		Statement st = null;
		String variacaoAmbev = null;
		Double maiorValorAmbev = 0.0;
		String variacaoItau = null;
		Double maiorValorItau = 0.0;
		String variacaoPetrobras = null;
		Double maiorValorPetrobras = 0.0;
		String variacaoVale = null;
		Double maiorValorVale = 0.0;
		try (ResultSet rs = executarSQL(conn, sql)) {
			
			while (rs.next()) {

				
				Double percentualFinal = (Double.parseDouble(rs.getString("abertura")) * Double.parseDouble(rs.getString("fechamento"))/100);
				if(rs.getString("simbolo").equals("ABEV3")){
					if(maiorValorAmbev < percentualFinal) {
						variacaoAmbev = ("Nome: "+rs.getString("nome")+" | Dia: "+rs.getString("data")+" | Variação: "+percentualFinal+" Porcento");
					}
						
				}
				if(rs.getString("simbolo").equals("ITUB4")){
					if(maiorValorItau < percentualFinal) {
						variacaoItau = ("Nome: "+rs.getString("nome")+" | Dia: "+rs.getString("data")+" | Variação: "+percentualFinal+" Porcento");
					}
				}
				if(rs.getString("simbolo").equals("PETR4")){
					if(maiorValorPetrobras < percentualFinal) {
						variacaoPetrobras = ("Nome: "+rs.getString("nome")+" | Dia: "+rs.getString("data")+" | Variação: "+percentualFinal+" Porcento");
					}
				}
				if(rs.getString("simbolo").equals("VALE3")){
					if(maiorValorVale < percentualFinal) {
						variacaoVale = ("Nome: "+rs.getString("nome")+" | Dia: "+rs.getString("data")+" | Variação: "+percentualFinal+" Porcento");
					}
				}
				
			}
			System.out.println(variacaoAmbev);
			System.out.println(variacaoItau);
			System.out.println(variacaoPetrobras);
			System.out.println(variacaoVale);
			st = rs.getStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void QuestaoD(Connection conn) {
		String dataP = JOptionPane.showInputDialog("Informe uma Data YYYY-MM-DD");
		String valorP = JOptionPane.showInputDialog("Informe um valor a ser investido");
		if(Double.parseDouble(valorP) < 0) {
			System.out.println("Voce informou um numero Invalido"); 
			System.out.close();
		}
		String sql = "	select * "
				+ "		from acao a,"
				+ "		cotacao b"
				+ "		where a.simbolo = b.simbolo"
				+ "		and b.data like '"+dataP+"'";
		Statement st = null;
		
		try (ResultSet rs = executarSQL(conn, sql)) {
			while (rs.next()) {
				Double abertura = Double.parseDouble(rs.getString("abertura"));
				Double valorParametro = Double.parseDouble(valorP);
				Double valorFinal = valorParametro/abertura;
				System.out.printf("Nome: "+rs.getString("nome")+" | Data: "+rs.getString("data")+" | Possivel comprar: "+valorFinal+" \n");
			}
			st = rs.getStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private static ResultSet executarSQL(Connection conn, String sql) throws SQLException {
		Statement st = conn.createStatement();
		return st.executeQuery(sql);

	}
}