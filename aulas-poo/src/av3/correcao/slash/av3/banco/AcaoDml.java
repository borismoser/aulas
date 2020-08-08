package av3.correcao.slash.av3.banco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import av3.correcao.slash.model.Acao;

public class AcaoDml {

	public static List<Acao> listarAcoes() {
	
		List<Acao> acoes = new ArrayList<>();

		String sql = "select simbolo, nome from acao";
		try (JdbcRowSet rs = Av3SqlDml.executarSQL(sql)) {
			while (rs.next()) {
				acoes.add(new Acao(rs.getString("simbolo"), rs.getString("nome")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return acoes;
	}
}
