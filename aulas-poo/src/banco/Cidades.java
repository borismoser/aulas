package banco;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class Cidades {

	public static void main(String[] args) throws SQLException {

		String banco;
		banco = "jdbc:hsqldb:file:./src/banco/hsql/cidades;ifexists=true";
//		banco = "jdbc:hsqldb:hsql://localhost/cidades";
//		banco = "jdbc:sqlite:./src/banco/sqlite/cidades.db"; // Não suporta ResultSet.CONCUR_UPDATABLE

		String usr = "SA";
		String pwd = "";

		String sql = "select * from cidades where idcidade between 101 and 110 or idcidade = 9999";

		try (Connection conn = DriverManager.getConnection(banco, usr, pwd)) {
			DatabaseMetaData md = conn.getMetaData();
			System.out.println("Banco : " + md.getDatabaseProductName() + " " + md.getDatabaseProductVersion() + " ["
					+ md.getURL() + "]");
			System.out.println("Driver: " + md.getDriverName() + ". Versão: " + md.getDriverVersion());
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(banco, usr, pwd); //
				Statement st = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
			ResultSet rs = st.executeQuery(sql);
			conn.setAutoCommit(false);
			while (rs.next()) {

				if (rs.isFirst()) {
					System.out.println("  Id UF Cidade                            Habitantes");
					System.out.println("---- -- ------                            ----------");
				}

				System.out.printf("%4d %s %-30s  %,12d%n", rs.getInt("idcidade"), rs.getString("uf"),
						rs.getString("nome"), rs.getInt("poptotal"));

				if (rs.getInt("idcidade") == 104) {
					String nomeCidade = rs.getString("nome").toUpperCase();
					rs.updateString("nome", nomeCidade);
					rs.updateRow();
				}
			}

			rs.moveToInsertRow();
			rs.updateInt("idcidade", 9999);
			rs.updateString("uf", "XX");
			rs.updateString("nome", "Abc De Fghijkl");
			rs.updateInt("poptotal", 9999);
			rs.updateInt("popmasc", 4999);
			rs.updateInt("popfem", 5000);
			rs.insertRow();

			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println();

		// Connected RowSet -> permanece conectado até o fechamento.
		try (JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet()) {
			rs.addRowSetListener(new MyListener());
			rs.setUrl(banco);
			rs.setUsername(usr);
			rs.setPassword(pwd);
			rs.setCommand(sql);
			rs.execute();
			while (rs.next()) {

				if (rs.isFirst()) {
					System.out.println("  Id UF Cidade                            Habitantes");
					System.out.println("---- -- ------                            ----------");
				}

				System.out.printf("%4d %s %-30s  %,12d%n", rs.getInt("idcidade"), rs.getString("uf"),
						rs.getString("nome"), rs.getInt("poptotal"));

				if (rs.getInt("idcidade") == 104) {
					String nomeCidade = rs.getString("nome").toLowerCase();
					rs.updateString("nome", nomeCidade);
					rs.updateRow();
				}

				if (rs.getInt("idcidade") == 9999) {
					rs.deleteRow();
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println();

		// Disconnected RowSet -> busca o resultado e desconecta-se.
		try (CachedRowSet rs = RowSetProvider.newFactory().createCachedRowSet()) {
			rs.addRowSetListener(new MyListener());
			rs.setUrl(banco);
			rs.setUsername(usr);
			rs.setPassword(pwd);
			rs.setCommand(sql);
			rs.execute();
			rs.afterLast();
			while (rs.previous()) {

				if (rs.isLast()) {
					System.out.println("  Id UF Cidade                            Habitantes");
					System.out.println("---- -- ------                            ----------");
				}

				System.out.printf("%4d %s %-30s  %,12d%n", rs.getInt("idcidade"), rs.getString("uf"),
						rs.getString("nome"), rs.getInt("poptotal"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

class MyListener implements RowSetListener {
	public void cursorMoved(RowSetEvent event) {
		ResultSet rs = (ResultSet) event.getSource();
		try {
			if (rs.isAfterLast()) {
				System.out.println("ResultSet chegou ao final dos resultados.");
			} else if (rs.isBeforeFirst()) {
				System.out.println("ResultSet chegou no início dos resultados.");
			} else {
				System.out.println("ResultSet movido para cidade com id " + rs.getInt("idcidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rowChanged(RowSetEvent event) {
		ResultSet rs = (ResultSet) event.getSource();
		try {
			System.out.println("A cidade com id " + rs.getInt("idcidade") + " foi alterada.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rowSetChanged(RowSetEvent event) {
		System.out.println("ResultSet sofreu alterações.");
	}
}