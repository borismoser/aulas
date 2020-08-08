package av3.correcao.slash.av3.banco;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Av3SqlDml {

	public static JdbcRowSet executarSQL(String SQL) {
		JdbcRowSet rs = null;

		RowSetFactory rsFactory;
		try {
			rsFactory = RowSetProvider.newFactory();
			rs = rsFactory.createJdbcRowSet();
			rs.setUrl("jdbc:hsqldb:mem:memorydb:");
			rs.setCommand(SQL);
//			st.execute(SQL);
			rs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
