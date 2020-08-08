package av3.correcao.vinicius.executavel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import av3.Banco;
import av3.correcao.vinicius.Model.Acao;
import av3.correcao.vinicius.Model.Cotacao;

public class Respondendo {

	public static void questaoA() {
		Connection conn = Banco.conexao();

		String sql = "Select * from acao";

		try (Statement st = conn.createStatement()) {
			ResultSet rs = st.executeQuery(sql);

			List<Acao> listaAcao = new ArrayList<>();
			while (rs.next()) {
				Acao acao = new Acao(rs.getString("simbolo"), rs.getString("nome"));
				listaAcao.add(acao);
			}

			for (Acao acao : listaAcao) {
				System.out.println(acao.toString());
			}
		} catch (Exception e) {
			System.out.println("");
			System.out.println(e);
		}
	}

	public static void questaoB() {
		Connection conn = Banco.conexao();

		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a Simbolo que deseja visualizar");
		String nomeSimbolo = sc.next();

		String sql = "Select * from cotacao where simbolo like '" + nomeSimbolo + "'";

		try (Statement st = conn.createStatement()) {
			ResultSet rs = st.executeQuery(sql);

			List<Cotacao> listaCotacao = new ArrayList<>();
			while (rs.next()) {
				Cotacao cotacao = new Cotacao(rs.getString("simbolo"), rs.getDate("data"), rs.getBigDecimal("abertura"),
						rs.getBigDecimal("fechamento"), rs.getInt("volume"));
				listaCotacao.add(cotacao);
			}

			for (Cotacao cotacao : listaCotacao) {
				System.out.println(cotacao.toString());
			}
		} catch (Exception e) {
			System.out.println("");
			System.out.println(e);
		}
	}

	public static void questaoC() {
		Connection conn = Banco.conexao();

		String sql = "Select * from cotacao";

		try (Statement st = conn.createStatement()) {
			ResultSet rs = st.executeQuery(sql);

			List<Cotacao> listaCotacao = new ArrayList<>();
			while (rs.next()) {
				Cotacao cotacao = new Cotacao(rs.getString("simbolo"), rs.getDate("data"), rs.getBigDecimal("abertura"),
						rs.getBigDecimal("fechamento"), rs.getInt("volume"));
				listaCotacao.add(cotacao);
			}

			List<Cotacao> ABEV3 = new ArrayList<>();
			List<Cotacao> ITUB4 = new ArrayList<>();
			List<Cotacao> PETR4 = new ArrayList<>();
			List<Cotacao> VALE3 = new ArrayList<>();

			for (Cotacao cotacao : listaCotacao) {
				if (cotacao.getSimbolo().equals("ABEV3")) {
					ABEV3.add(cotacao);
				}
				if (cotacao.getSimbolo().equals("ITUB4")) {
					ITUB4.add(cotacao);
				}
				if (cotacao.getSimbolo().equals("PETR4")) {
					PETR4.add(cotacao);
				}
				if (cotacao.getSimbolo().equals("VALE3")) {
					VALE3.add(cotacao);
				}
			}

			List<Cotacao> ABEV3Final = new ArrayList<>();
			BigDecimal valorFinal = new BigDecimal("0");

			for (Cotacao cotacao : ABEV3) {
				BigDecimal valor1 = cotacao.getFechamento().subtract(cotacao.getAbertura());
				BigDecimal valor2 = valor1.divide(cotacao.getAbertura(), 2, RoundingMode.HALF_UP);
				BigDecimal valor3 = valor2.multiply(new BigDecimal("100"));

				if (valor3.compareTo(valorFinal) == 1) {
					ABEV3Final.add(cotacao);
					valorFinal = valor3;

				}
			}

			System.out.println(ABEV3Final.get(0) + "\nPorcentagem: " + valorFinal);

			List<Cotacao> ITUB4Final = new ArrayList<>();
			BigDecimal valorFinal2 = new BigDecimal("0");

			for (Cotacao cotacao : ITUB4) {
				BigDecimal valor1 = cotacao.getFechamento().subtract(cotacao.getAbertura());
				BigDecimal valor2 = valor1.divide(cotacao.getAbertura(), 2, RoundingMode.HALF_UP);
				BigDecimal valor3 = valor2.multiply(new BigDecimal("100"));

				if (valor3.compareTo(valorFinal2) == 1) {
					ITUB4Final.add(cotacao);
					valorFinal2 = valor3;

				}
			}

			System.out.println(ITUB4Final.get(0) + "\nPorcentagem: " + valorFinal2);

			
			List<Cotacao> PETR4Final = new ArrayList<>();
			BigDecimal valorFinal3 = new BigDecimal("0");

			for (Cotacao cotacao : PETR4) {
				BigDecimal valor1 = cotacao.getFechamento().subtract(cotacao.getAbertura());
				BigDecimal valor2 = valor1.divide(cotacao.getAbertura(), 2, RoundingMode.HALF_UP);
				BigDecimal valor3 = valor2.multiply(new BigDecimal("100"));

				if (valor3.compareTo(valorFinal3) == 1) {
					PETR4Final.add(cotacao);
					valorFinal3 = valor3;

				}
			}

			System.out.println(PETR4Final.get(0) + "\nPorcentagem: " + valorFinal3);
			
			
			List<Cotacao> VALE3Final = new ArrayList<>();
			BigDecimal valorFinal4 = new BigDecimal("0");

			for (Cotacao cotacao : VALE3) {
				BigDecimal valor1 = cotacao.getFechamento().subtract(cotacao.getAbertura());
				BigDecimal valor2 = valor1.divide(cotacao.getAbertura(), 2, RoundingMode.HALF_UP);
				BigDecimal valor3 = valor2.multiply(new BigDecimal("100"));

				if (valor3.compareTo(valorFinal4) == 1) {
					VALE3Final.add(cotacao);
					valorFinal4 = valor3;

				}
			}
			
			System.out.println(VALE3Final.get(0) + "\nPorcentagem: " + valorFinal4);
			
		} catch (Exception e) {
			System.out.println("Erro questao 3");
			e.printStackTrace();
		}
	}

	public static void questaoD() {
		Connection conn = Banco.conexao();

		Scanner sc = new Scanner(System.in);
		System.out.println("Digite uma data: Digite em yyyy-MM-dd");
		String data = sc.next();

		System.out.println("Digite um valor em Reais: ");
		BigDecimal valor = sc.nextBigDecimal();

		String sql = "Select * from cotacao where data like '" + data + "'";

		try (Statement st = conn.createStatement()) {
			ResultSet rs = st.executeQuery(sql);

			List<Cotacao> listaCotacao = new ArrayList<>();
			while (rs.next()) {
				Cotacao cotacao = new Cotacao(rs.getString("simbolo"), rs.getDate("data"), rs.getBigDecimal("abertura"),
						rs.getBigDecimal("fechamento"), rs.getInt("volume"));
				listaCotacao.add(cotacao);
			}

			List<Integer> res = new ArrayList<Integer>();

			for (Cotacao cotacao : listaCotacao) {
				int numAcao = 0;
				BigDecimal valorcomparar = valor;
				while (valorcomparar.compareTo(BigDecimal.ZERO) > 0) {
					valorcomparar = valorcomparar.subtract(cotacao.getAbertura());
					if (valorcomparar.compareTo(BigDecimal.ZERO) <= 0) {
						numAcao--;
					}
					numAcao++;
				}
				res.add(numAcao);
				System.out.println(cotacao.getSimbolo() + " " + numAcao);
			}

		} catch (Exception e) {
			System.out.println("Questao D");
			System.out.println(e);
		}
	}
}
