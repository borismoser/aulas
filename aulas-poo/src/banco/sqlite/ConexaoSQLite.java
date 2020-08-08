package banco.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConexaoSQLite {
	
	// Design Pattern Singleton

	// Uma instância do SQLite pode ser criada para uso em memória,
	// sem gerar um arquivo físico, através desta sintaxe da String de conexão:

//	private static String sqlite = "jdbc:sqlite::memory:";

	// Para criar um arquivo físico ou conectar-se a um já existente,
	// configura-se a String de conexão informando o caminho do arquivo:

	private static String sqlite = "jdbc:sqlite:./src/banco/sqlite/cidades.db";

	private static Connection conn = null;

	public static Connection conexao() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(sqlite);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	

	private ConexaoSQLite() {
		// "Escondendo" o construtor, de forma que esta classe não possa ser instanciada.
	}
}
