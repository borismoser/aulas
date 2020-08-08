package av3.correcao.esperandio;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public final class ConexaoHSQL {

	private static String hsql = "jdbc:hsqldb:mem:memorydb:";

	private static RowSetFactory rsFactory = null;
	
	public static JdbcRowSet executarSQL(String sql, Object[] params) throws SQLException {
		
		JdbcRowSet rs = null;

		try {
			if (rsFactory == null) {
				rsFactory = RowSetProvider.newFactory();
			}
			rs = rsFactory.createJdbcRowSet();
			rs.setUrl(hsql);
			rs.setCommand(sql);

			for (int i = 1; i <= params.length; i++) {
				rs.setObject(i, params[i-1]);
			}

			rs.execute();

		} catch (SQLException e) {
			throw e;
		}
		return rs;

	}

	public static JdbcRowSet executarSQL(String sql) throws SQLException {

		JdbcRowSet rs = null;
		try {
			if (rsFactory == null) {
				rsFactory = RowSetProvider.newFactory();
			}
			rs = rsFactory.createJdbcRowSet();
			rs.setUrl(hsql);
			rs.setCommand(sql);
			rs.execute();
		} catch (SQLException e) {
			throw e;
		}
		return rs;

	}

	private ConexaoHSQL() {}

}
