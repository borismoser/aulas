package av3.correcao.scottini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import av3.Banco;

public class Consultas {

	Connection conn;

	public Consultas() {
		conn = Banco.conexao();
	}

	public void selecionarAcoesDisponiveis() throws SQLException {

		String sql = "select simbolo, nome from Acao group by simbolo, nome";

		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("simbolo") + " - " + rs.getString("nome"));
		}
	}

	public void informacoesAcaoEspecifica(String simbolo) throws SQLException {
		String sql = "select data, abertura, fechamento, volume from Cotacao where simbolo = ? order by data desc";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, simbolo);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("data") + " - " + rs.getString("abertura") + " - "
					+ rs.getString("fechamento") + " - " + rs.getString("volume"));
		}

	}

	public void maiorVariacao() throws SQLException {

		String sql = "select a.simbolo, a.data, ((a.abertura-a.fechamento)/a.abertura * 100.00) as percentual from Cotacao "
				+ "a join (select simbolo, max(data) as datamax, max(((abertura-fechamento)/abertura * 100.00)) as percent from Cotacao group by simbolo) a2 "
				+ "on a.simbolo = a2.simbolo and ((a.abertura-a.fechamento)/a.abertura * 100.00) = a2.percent  "
				+ "group by simbolo, data, ((a.abertura-a.fechamento)/a.abertura * 100.00)";
		
//		String sql = "select a.simbolo, a.data, (a.fechamento/a.abertura * 100.0 -100) a.percentual from Cotacao a, "
//				+ "(select max(fechamento/abertura * 100.0 -100) maxvariacao, simbolo from Cotacao group by simbolo) b "
//				+ "where a.simbolo = b.simbolo and (a.fechamento/a.abertura * 100.0 -100) = b.maxvariacao";

		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println(
					rs.getString("simbolo") + " - " + rs.getString("data") + " - " + rs.getString("percentual"));
		}

	}

	public void maxCompra(Date dt, Double dinheiro) throws SQLException {

		String sql = "select (?/abertura) as contador, a.simbolo from Cotacao a where data = ? group by simbolo, (?/abertura)";

		java.sql.Date dataSql = new java.sql.Date(dt.getTime());

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDate(2, dataSql);
		ps.setDouble(1, dinheiro);
		ps.setDouble(3, dinheiro);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int arredondado = (int) Math.floor(rs.getFloat("contador"));
			System.out.println(arredondado + " - " + rs.getString("simbolo"));
		}

	}
}
