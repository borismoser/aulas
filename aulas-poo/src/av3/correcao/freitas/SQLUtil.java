package av3.correcao.freitas;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class SQLUtil {
	
	private static RowSetFactory rsFactory = null;
	
	public static JdbcRowSet executarSQL(String SQL) throws SQLException {
		JdbcRowSet rs = null;
		try {
			if (rsFactory == null) {
				rsFactory = RowSetProvider.newFactory();
			}
			rs = rsFactory.createJdbcRowSet();
			rs.setUrl("jdbc:hsqldb:mem:memorydb:");
			rs.setCommand(SQL);
			rs.execute();
		} catch (SQLException e) {
			throw e;
		}
		return rs;
	}
}
