package av3.correcao.pagel;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import av3.Banco;

public class Av3Dao {

	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public static void imprimirAcoes() throws SQLException {

		String sql;

		sql = "select * from acao";

		try (Statement st = Banco.conexao().createStatement()) {

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println("Nome: " + rs.getString("nome") + " - Simbolo: " + rs.getString("simbolo"));
			}
		}
	}

	public static void imprimirInformacoesConformeSimbolo(String simbolo) throws SQLException {

		String sql;

		sql = "select * from cotacao where simbolo like '%" + simbolo + "%' order by data desc";

		try (Statement st = Banco.conexao().createStatement()) {

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println("Simbolo: " + rs.getString("simbolo"));
				System.out.println("Data: " + rs.getDate("data").toLocalDate());
				System.out.println("Abertura: " + rs.getBigDecimal("abertura"));
				System.out.println("Fechamento: " + rs.getBigDecimal("fechamento"));
				System.out.println("Volume: " + rs.getInt("volume"));
				System.out.println("\n");
			}
		}
	}

	public static List<Acoes> getAcoes() throws SQLException {

		List<Acoes> acoes = new ArrayList<Acoes>();

		String sql;

		sql = "select * from acao";

		try (Statement st = Banco.conexao().createStatement()) {

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				Acoes acao = new Acoes();

				acao.setNome(rs.getString("nome"));
				acao.setSimbolo(rs.getString("simbolo"));
				acao.setCotacao(getCotacoes(rs.getString("simbolo")));

				acoes.add(acao);
			}
			return acoes;
		}
	}

	private static List<Cotacao> getCotacoes(String simbolo) throws SQLException {

		String sql;
		List<Cotacao> cotacoes = new ArrayList<Cotacao>();

		sql = "select * from cotacao where simbolo like '%" + simbolo + "%' order by data desc";

		try (Statement st = Banco.conexao().createStatement()) {

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				Cotacao cotacao = new Cotacao();

				cotacao.setAbertura(rs.getBigDecimal("abertura"));
				cotacao.setData(rs.getDate("data").toLocalDate());
				cotacao.setFechamento(rs.getBigDecimal("fechamento"));
				cotacao.setSimbolo(rs.getString("simbolo"));
				cotacao.setVolume(rs.getInt("volume"));

				cotacoes.add(cotacao);
			}

		}
		return cotacoes;
	}

	public static void imprimirTotalAcoes(LocalDate data, BigDecimal valor) throws SQLException {

		String sql = "select B.nome, B.simbolo, A.abertura from cotacao A join acao B on B.simbolo = A.simbolo \n"
				+ "where A.data = ?";

		try (PreparedStatement st = Banco.conexao().prepareStatement(sql)) {

			st.setDate(1, Date.valueOf(data));

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				BigDecimal abertura = rs.getBigDecimal("abertura");

				String simbolo = rs.getString("simbolo");
				String nome = rs.getString("nome");

				int totalAcoes = (int) (valor.doubleValue() / abertura.doubleValue());

				System.out.println("Nome: " + nome);
				System.out.println("Simbolo: " + simbolo);
				System.out.println("Total ações conforme valor: " + totalAcoes);
				System.out.println("\n");
			}
		}
	}

	public static void imprimirVaricaoPercentual() throws SQLException {
		
		List<Acoes> acoes = getAcoes();

		for (Acoes acao : acoes) {

			Double maiorPercentual = acao.calculaPercentual();
			System.out.println("Ação: " + acao.getNome());
			System.out.println("Simbolo: " + acao.getSimbolo());
			System.out.println("Maior percentual: " + df2.format(maiorPercentual) + "%");
			System.out.println("Data Maior Percentual: " + acao.retornaDiaMaiorPercentual());
			System.out.println("\n");
		}

	}

}
