package av3.correcao.slash.av3.banco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import av3.correcao.slash.model.Cotacao;


public class CotacaoDml {

	public static List<Cotacao> getCotacoesPorSimbolo(String simbolo) {
		List<Cotacao> cotacoes = new ArrayList<>();
		String sql = "";
		if (simbolo.equals("")) {
			sql = "select simbolo, data, abertura, fechamento, volume from cotacao ";
		} else {

			sql = "select simbolo, data, abertura, fechamento, volume from cotacao where simbolo = '" + simbolo + "'";
		}

		try (JdbcRowSet rs = Av3SqlDml.executarSQL(sql)) {
			while (rs.next()) {
				cotacoes.add(new Cotacao(rs.getString("simbolo"), rs.getDate("data").toLocalDate(),
						rs.getDouble("abertura"), rs.getDouble("fechamento"), rs.getInt("volume")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cotacoes;
	}
}
