package av3.correcao.elison.br.com.prova.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import av3.correcao.elison.br.com.prova.core.Banco;
import av3.correcao.elison.br.com.prova.models.Acao;

public class AcaoRepository {

    public static List<Acao> findAllAcoes() {
        List<Acao> acoes = new ArrayList<>();
        String sql = "SELECT * FROM ACAO";
        try (Statement preparedStatement = Banco.conexao().createStatement();
             ResultSet resultSet = preparedStatement.executeQuery(sql)) {
            while (resultSet.next()) {
                acoes.add(new Acao(resultSet.getString("simbolo"), resultSet.getString("nome")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acoes;
    }
}
