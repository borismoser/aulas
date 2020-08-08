package av3.correcao.andrei;

import java.lang.reflect.Method;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Impressores {
	public static void QuestaoAResultados(ResultSet resultado) throws SQLException {
		System.out.println("Simbolo: " + resultado.getString("SIMBOLO"));
		System.out.println("Nome: " + resultado.getString("NOME"));
	}

	public static void QuestaoBResultados(final ResultSet resultado) throws SQLException {
		System.out.println("Data: " + resultado.getDate("DATA"));
		System.out.println("Abertura: " + resultado.getDouble("ABERTURA"));
		System.out.println("Fechamento: " + resultado.getDouble("FECHAMENTO"));
		System.out.println("Volume: " + resultado.getInt("VOLUME"));
	}

	public static void QuestaoBParametros(PreparedStatement stmt, Object... parametros) throws SQLException {
		stmt.setString(1, parametros[0].toString());
	}

	public static void QuestaoCResultados(ResultSet resultado) throws SQLException {
		System.out.println("Simbolo: " + resultado.getString("SIMBOLO"));
		System.out.println("Data: " + resultado.getDate("DATA"));
		System.out.println("Percentual: " + resultado.getString("PERCENTUAL"));
	}

	public static void QuestaoDResultados(ResultSet resultado) throws SQLException {
		System.out.println("Data: " + resultado.getDate("DATA"));
		System.out.println("Quantidade comprada: " + resultado.getInt("QUANTIDADE"));
		System.out.println("Simbolo: " + resultado.getString("SIMBOLO"));
		System.out.println("Valor abertura: " + resultado.getDouble("ABERTURA"));
	}

	public static void QuestaoDParametros(PreparedStatement stmt, Object... parametros) throws SQLException {
		stmt.setDouble(1, Double.parseDouble(parametros[0].toString()));
		Date data = (Date) parametros[1];
		stmt.setDate(2, new java.sql.Date(data.getTime()));
	}

	public static Method GetMethodResultados(char letraQuestao) throws NoSuchMethodException, SecurityException {
		String methodName = "Questao" + letraQuestao + "Resultados";
		return Impressores.class.getMethod(methodName, ResultSet.class);
	}

	public static Method GetMethodParametros(char letraQuestao) throws NoSuchMethodException, SecurityException {
		String methodName = "Questao" + letraQuestao + "Parametros";
		return Impressores.class.getMethod(methodName, PreparedStatement.class, Object[].class);
	}
}