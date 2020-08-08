package exame.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {

	private static String hsql = "jdbc:hsqldb:mem:memorydb:";

	private static Connection conn = null;

	public static Connection conexao() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(hsql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void inicializar() {
		String sql;
		try (Statement st = conexao().createStatement()) {

			sql = "create table PRODUTOS ( " + //
					" codigo varchar(5) primary key," + //
					" descricao varchar(50) )";
			st.executeUpdate(sql);

			sql = "create table VENDAS ( " + //
					" codigo varchar(5)," + //
					" data date," + //
					" precoCompra double," + //
					" precoVenda double," + //
					" quantidade integer," + //
					" primary key (codigo, data)," + //
					" foreign key (codigo) references PRODUTOS (codigo))";
			st.executeUpdate(sql);

			st.executeUpdate(scriptAcoes);

			st.executeUpdate(scriptCotacoes);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static final String scriptAcoes = //
			"insert into PRODUTOS (codigo, descricao) values ('PCDSK', 'DESKTOP PC');"
					+ "insert into PRODUTOS (codigo, descricao) values ('PCNTB', 'NOTEBOOK PC');"
					+ "insert into PRODUTOS (codigo, descricao) values ('MCDSK', 'DESKTOP MAC');"
					+ "insert into PRODUTOS (codigo, descricao) values ('MCNTB', 'NOTEBOOK MAC');";

	private static final String scriptCotacoes = //
			"insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCDSK', '2019-09-17', 2827.66, 3457.69, 67);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCDSK', '2019-09-18', 2827.37, 3457.22, 40);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCDSK', '2019-09-19', 2827.83, 3457.29, 41);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCDSK', '2019-09-20', 2827.35, 3457.00, 51);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCDSK', '2019-09-23', 2827.00, 3457.48, 32);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCDSK', '2019-09-24', 2827.42, 3457.27, 36);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCDSK', '2019-09-25', 2827.03, 3457.34, 28);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCDSK', '2019-09-26', 2827.40, 3457.70, 33);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCDSK', '2019-09-27', 2827.55, 3457.66, 31);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCDSK', '2019-09-30', 2827.56, 3457.55, 22);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCNTB', '2019-09-17', 3548.25, 4858.90, 14);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCNTB', '2019-09-18', 3549.00, 4858.40, 15);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCNTB', '2019-09-19', 3548.40, 4858.32, 15);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCNTB', '2019-09-20', 3548.66, 4858.42, 23);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCNTB', '2019-09-23', 3548.19, 4858.10, 11);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCNTB', '2019-09-24', 3547.71, 4856.93, 15);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCNTB', '2019-09-25', 3547.03, 4857.86, 14);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCNTB', '2019-09-26', 3548.10, 4857.86, 12);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCNTB', '2019-09-27', 3548.15, 4857.66, 13);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('PCNTB', '2019-09-30', 3547.65, 4857.75, 12);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCDSK', '2019-09-17', 4919.03, 5659.43, 16);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCDSK', '2019-09-18', 4919.36, 5659.26, 18);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCDSK', '2019-09-19', 4919.48, 5659.35, 31);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCDSK', '2019-09-20', 4919.43, 5659.39, 32);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCDSK', '2019-09-23', 4919.24, 5659.41, 13);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCDSK', '2019-09-24', 4919.47, 5659.35, 16);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCDSK', '2019-09-25', 4919.25, 5659.60, 15);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCDSK', '2019-09-26', 4919.57, 5659.53, 33);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCDSK', '2019-09-27', 4919.56, 5659.45, 12);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCDSK', '2019-09-30', 4919.53, 5659.25, 21);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCNTB', '2019-09-17', 6634.87, 7755.33, 12);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCNTB', '2019-09-18', 6635.34, 7755.22, 13);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCNTB', '2019-09-19', 6635.51, 7754.63, 17);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCNTB', '2019-09-20', 6634.85, 7754.72, 32);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCNTB', '2019-09-23', 6634.67, 7754.61, 13);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCNTB', '2019-09-24', 6634.79, 7754.25, 10);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCNTB', '2019-09-25', 6634.16, 7754.65, 14);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCNTB', '2019-09-26', 6634.85, 7755.65, 18);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCNTB', '2019-09-27', 6635.56, 7755.50, 16);"
					+ "insert into VENDAS (codigo, data, precoCompra, precoVenda, quantidade) values ('MCNTB', '2019-09-30', 6635.52, 7755.00, 15);";

}
