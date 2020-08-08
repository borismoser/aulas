package av3.correcao.elison.br.com.prova.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import av3.correcao.elison.br.com.prova.core.Banco;
import av3.correcao.elison.br.com.prova.models.Cotacao;

public class CotacaoRepository {

    public static List<Cotacao> findCotacaoById (String simbolo) {
        List<Cotacao> cotacoes = new ArrayList<>();
            String sql;
            sql = String.format("SELECT * FROM COTACAO WHERE SIMBOLO = '%s'", simbolo);
            try (Statement preparedStatement = Banco.conexao().createStatement();
                 ResultSet resultSet = preparedStatement.executeQuery(sql)) {
                while (resultSet.next()) {
                    cotacoes.add(new Cotacao(
                            resultSet.getString("SIMBOLO"),
                            resultSet.getDate("DATA").toLocalDate(),
                            resultSet.getBigDecimal("ABERTURA"),
                            resultSet.getBigDecimal("FECHAMENTO"),
                            resultSet.getInt("VOLUME")
                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return cotacoes;
    }

    public static List<Cotacao> findAllCotacao() {
        List<Cotacao> cotacoes = new ArrayList<>();
        String sql = "SELECT * FROM COTACAO";
        try (Statement preparedStatement = Banco.conexao().createStatement();
             ResultSet resultSet = preparedStatement.executeQuery(sql)) {
            while (resultSet.next()) {
                cotacoes.add(new Cotacao(
                        resultSet.getString("SIMBOLO"),
                        resultSet.getDate("DATA").toLocalDate(),
                        resultSet.getBigDecimal("ABERTURA"),
                        resultSet.getBigDecimal("FECHAMENTO"),
                        resultSet.getInt("VOLUME")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cotacoes;
    }

    public static List<Cotacao> findCotacoesByDate (LocalDate date) {
        List<Cotacao> cotacoes = new ArrayList<>();
        String sql = String.format("SELECT * FROM COTACAO WHERE DATA = '%s'", date.toString());
        try (Statement preparedStatement = Banco.conexao().createStatement();
             ResultSet resultSet = preparedStatement.executeQuery(sql)) {
            while (resultSet.next()) {
                cotacoes.add(new Cotacao(
                        resultSet.getString("SIMBOLO"),
                        resultSet.getDate("DATA").toLocalDate(),
                        resultSet.getBigDecimal("ABERTURA"),
                        resultSet.getBigDecimal("FECHAMENTO"),
                        resultSet.getInt("VOLUME")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cotacoes;
    }

}
