package av3.correcao.andrei;

import java.sql.PreparedStatement;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import av3.Banco;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.Connection;

public class Resolucao {
	public static void Criar(char letraQuestao) throws Exception {
		Connection conn = Banco.conexao();
		switch (letraQuestao) {
		case 'A': {
			QuestaoA(conn);
			break;
		}
		case 'B': {
			QuestaoB(conn);
			break;
		}
		case 'C': {
			QuestaoC(conn);
			break;
		}
		case 'D': {
			QuestaoD(conn);
			break;
		}
		default: {
			throw new Exception("Questão inexistente.");
		}
		}
	}

	private static void QuestaoA(Connection connection) throws Exception {
		String query = "SELECT SIMBOLO, NOME FROM ACAO";
		
//		TemplateMethod(connection, query, Impressores.class.getMethod("QuestaoAResultados", ResultSet.class), null,
		TemplateMethod(connection, query, Impressores.GetMethodResultados('A'), null,
				new Object[0]);
	}

	private static void QuestaoB(Connection connection) throws Exception {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Informe o simbolo: ");
		
		String simbolo = teclado.next().toUpperCase();
		
		String query = "SELECT DATA, ABERTURA, FECHAMENTO, VOLUME FROM COTACAO WHERE SIMBOLO = ? ORDER BY DATA DESC";
		
		TemplateMethod(connection, query, Impressores.GetMethodResultados('B'), Impressores.GetMethodParametros('B'),
				simbolo);
	}

	private static void QuestaoC(Connection connection) throws Exception {
		String query = "SELECT DATA, CONCAT(PERCENTUAL,' %') PERCENTUAL, SIMBOLO FROM (SELECT DATA, (((100 * FECHAMENTO) / ABERTURA) - 100) PERCENTUAL, SIMBOLO FROM COTACAO) A ORDER BY PERCENTUAL";
		TemplateMethod(connection, query, Impressores.GetMethodResultados('C'), null, new Object[0]);
	}

	private static void QuestaoD(Connection connection) throws Exception {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Informe uma data (dia/mes/ano(4 digitos): ");
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");		
		Date data = formatter.parse(teclado.next());
		
		System.out.println("Informe um valor: ");
		double valor = teclado.nextDouble();
		
		String query = "SELECT SIMBOLO, DATA, ABERTURA, CAST((? / ABERTURA) AS INT) QUANTIDADE FROM COTACAO WHERE DATA = ? ";
		TemplateMethod(connection, query, Impressores.GetMethodResultados('D'), Impressores.GetMethodParametros('D'),
				valor, data);
	}

	private static void TemplateMethod(Connection connection, String query, Method method, Method methodParameters,
			Object... parameterValues) throws Exception {
		try (PreparedStatement stmt = connection.prepareStatement(query)) {

			if (methodParameters != null) {
//				methodParameters.invoke(new Impressores(), stmt, parameterValues);
				methodParameters.invoke(null, stmt, parameterValues);
			}
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
//				method.invoke(new Impressores(), resultado);
				method.invoke(null, resultado);
				System.out.println("-------------------------------------------------");

			}
		}
	}
}