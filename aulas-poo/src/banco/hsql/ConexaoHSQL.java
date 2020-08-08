package banco.hsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public final class ConexaoHSQL {

//	private static String hsql = "jdbc:hsqldb:mem:memorydb:";
//	private static String hsql = "jdbc:hsqldb:file:./src/banco/hsql/cidades";
	private static String hsql = "jdbc:hsqldb:hsql://localhost/cidades";
	private static String usr = "SA";
	private static String pwd = "";

	private static Connection conn = null;
	private static RowSetFactory rsFactory = null;

	public static Connection conexao() throws SQLException {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(hsql, usr, pwd);
			}
		} catch (SQLException e) {
			throw e;
		}
		return conn;
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

	private ConexaoHSQL() {
		// "Escondendo" o construtor, de forma que esta classe não possa ser
		// instanciada.
	}
}
