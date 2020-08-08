package outros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DataHoraBanco {

	private static String hsql = "jdbc:hsqldb:mem:memorydb:";
	private static Connection conn;

	public static void main(String[] args) throws SQLException {

		conn = DriverManager.getConnection(hsql);

		String sql = "CREATE TABLE dispatches(" + //
				"ProductName VARCHAR(255), " + //
				"CustomerName VARCHAR(255), " + //
				"DispatchDateTime DATETIME, " + //
				"Price INT " + //
				");";

		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		st.executeUpdate(sql);

		sql = "insert into dispatches values(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, "Key-Board");
		ps.setString(2, "Raja");
		ps.setTimestamp(3, Timestamp.valueOf("2019-09-01 11:00:00"));
		ps.setInt(4, 7000);
		ps.addBatch();

		ps.setString(1, "Earphones");
		ps.setString(2, "Roja");
		ps.setTimestamp(3, Timestamp.valueOf("2019-05-01 11:00:00"));
		ps.setInt(4, 2000);
		ps.addBatch();
		ps.executeBatch();

		sql = "select * from dispatches";
		ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		ResultSet rs = ps.executeQuery();
		rs.next();
		System.out.println("");
		System.out.println("Contents of the first record: ");
		System.out.println("Product Name: " + rs.getString("ProductName"));
		System.out.println("Customer Name: " + rs.getString("CustomerName"));
		System.out.println("Dispatch Date/Time: " + rs.getTimestamp("DispatchDateTime"));
		System.out.println("Price: " + rs.getInt("Price"));

		LocalDateTime ldt = rs.getTimestamp("DispatchDateTime").toLocalDateTime();
		System.out.println("LocalDateTime value from date:" + ldt);
		ldt = ldt.plusMinutes(30);
		rs.updateTimestamp("DispatchDateTime", java.sql.Timestamp.valueOf(ldt));
		rs.updateRow();
		rs.close();

		rs = ps.executeQuery();
		rs.next();
		rs.next();
		System.out.println("");
		System.out.println("Contents of the first record: ");
		System.out.println("Product Name: " + rs.getString("ProductName"));
		System.out.println("Customer Name: " + rs.getString("CustomerName"));
		System.out.println("Dispatch Date/Time: " + rs.getTimestamp("DispatchDateTime"));
		System.out.println("Price: " + rs.getInt("Price"));

		sql = "select count(*) from dispatches";
		rs = st.executeQuery(sql);
		if (rs.next()) {
			System.out.println(rs.getInt(1));
		}
	}

}
