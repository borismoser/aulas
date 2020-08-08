package banco.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConexaoSQLite {
	
	// Design Pattern Singleton

	// Uma inst�ncia do SQLite pode ser criada para uso em mem�ria,
	// sem gerar um arquivo f�sico, atrav�s desta sintaxe da String de conex�o:

//	private static String sqlite = "jdbc:sqlite::memory:";

	// Para criar um arquivo f�sico ou conectar-se a um j� existente,
	// configura-se a String de conex�o informando o caminho do arquivo:

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
		// "Escondendo" o construtor, de forma que esta classe n�o possa ser instanciada.
	}
}
