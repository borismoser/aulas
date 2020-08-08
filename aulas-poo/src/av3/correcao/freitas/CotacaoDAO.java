package av3.correcao.freitas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import av3.Banco;

public class CotacaoDAO {
	public static List<Cotacao> buscaCotacao(String simbolo) {
		String sql = " SELECT SIMBOLO, DATA, ABERTURA, FECHAMENTO, VOLUME FROM COTACAO WHERE SIMBOLO = ? ORDER BY DATA desc";
		List<Cotacao> lCotacao = new LinkedList<Cotacao>();
		
		try (Connection conn = Banco.conexao()){
			PreparedStatement pstm = conn.prepareStatement(sql);   
			pstm.setString(1, simbolo);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				lCotacao.add(new Cotacao(rs.getString("SIMBOLO"), rs.getDate("DATA").toLocalDate(), rs.getDouble("ABERTURA"), rs.getDouble("FECHAMENTO"), rs.getInt("VOLUME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lCotacao;
	}
	
	public static List<Cotacao> retornaCotacoes() {
		String sql = "SELECT SIMBOLO, DATA, ABERTURA, FECHAMENTO, VOLUME FROM COTACAO";
		List<Cotacao> lCotacoes = new ArrayList<Cotacao>();
		try (JdbcRowSet rs = SQLUtil.executarSQL(sql)){
			while (rs.next()) {
				lCotacoes.add(new Cotacao(rs.getString("SIMBOLO"), rs.getDate("DATA").toLocalDate(), rs.getDouble("ABERTURA"), rs.getDouble("FECHAMENTO"), rs.getInt("VOLUME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lCotacoes;
	}

	public static List<SimulacaoCotacaoDTO> comprasCotacao(Integer valorCompra, LocalDate dataCompra) {
		String sql = " SELECT SIMBOLO, CAST((? / ABERTURA) AS INT) AS QNTDCOMPRA FROM COTACAO WHERE DATA = ? ";
		List<SimulacaoCotacaoDTO> lSimulacaoCotacao = new LinkedList<SimulacaoCotacaoDTO>();
		
		try (Connection conn = Banco.conexao()){
			PreparedStatement pstm = conn.prepareStatement(sql);   
			pstm.setInt(1, valorCompra);
			pstm.setDate(2, Date.valueOf(dataCompra));
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				lSimulacaoCotacao.add(new SimulacaoCotacaoDTO(rs.getString("SIMBOLO"), rs.getInt("QNTDCOMPRA")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lSimulacaoCotacao;
	}
}
