package av3.correcao.freitas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

public class AcaoDAO {
	
	public static List<Acao> recuperaAcoes(){
		String sql = "SELECT SIMBOLO, NOME FROM ACAO";
		List<Acao> lAcoes = new ArrayList<Acao>();
		try (JdbcRowSet rs = SQLUtil.executarSQL(sql)){
			while (rs.next()) {
				lAcoes.add(new Acao(rs.getString("SIMBOLO"), rs.getString("NOME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lAcoes;
	}

}
