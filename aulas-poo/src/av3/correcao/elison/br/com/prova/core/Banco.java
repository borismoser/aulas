package av3.correcao.elison.br.com.prova.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {

    private static String hsql = "jdbc:hsqldb:mem:memorydb:";

    private static Connection conn = null;

    public static Connection conexao() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(hsql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void inicializar() {
        String sql;
        try (Statement st = conexao().createStatement()) {

            sql = "create table acao ( " + //
                    " simbolo varchar(5) primary key," + //
                    " nome varchar(20) )";
            st.executeUpdate(sql);

            sql = "create table cotacao ( " + //
                    " simbolo varchar(5)," + //
                    " data date," + //
                    " abertura numeric (5,2)," + //
                    " fechamento numeric (5,2)," + //
                    " volume integer," + //
                    " primary key (simbolo, data)," + //
                    " foreign key (simbolo) references acao (simbolo))";
            st.executeUpdate(sql);

            st.executeUpdate(scriptAcoes);

            st.executeUpdate(scriptCotacoes);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static final String scriptAcoes = //
            "insert into acao (simbolo, nome) values ('PETR4', 'PETROBRAS PN');"
                    + "insert into acao (simbolo, nome) values ('VALE3', 'VALE ON');"
                    + "insert into acao (simbolo, nome) values ('ABEV3', 'AMBEV S/A ON');"
                    + "insert into acao (simbolo, nome) values ('ITUB4', 'ITAU UNIBANCO PN');";

    private static final String scriptCotacoes = //
            "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('PETR4', '2019-09-17', 27.66, 27.69, 67144400);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('PETR4', '2019-09-18', 27.37, 27.22, 40144100);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('PETR4', '2019-09-19', 27.83, 27.29, 41984200);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('PETR4', '2019-09-20', 27.35, 27.00, 51584800);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('PETR4', '2019-09-23', 27.00, 27.48, 32497300);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('PETR4', '2019-09-24', 27.42, 27.27, 36534000);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('PETR4', '2019-09-25', 27.03, 27.34, 28963400);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('PETR4', '2019-09-26', 27.40, 27.70, 33466600);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('PETR4', '2019-09-27', 27.55, 27.66, 31816500);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('PETR4', '2019-09-30', 27.56, 27.55, 22984800);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('VALE3', '2019-09-17', 48.25, 48.90, 14434300);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('VALE3', '2019-09-18', 49.00, 48.40, 15202000);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('VALE3', '2019-09-19', 48.40, 48.32, 15640000);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('VALE3', '2019-09-20', 48.66, 48.42, 23849300);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('VALE3', '2019-09-23', 48.19, 48.10, 11925200);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('VALE3', '2019-09-24', 47.71, 46.93, 15215800);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('VALE3', '2019-09-25', 47.03, 47.86, 14517900);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('VALE3', '2019-09-26', 48.10, 47.86, 12193600);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('VALE3', '2019-09-27', 48.15, 47.66, 13257300);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('VALE3', '2019-09-30', 47.65, 47.75, 12073300);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ABEV3', '2019-09-17', 19.03, 19.43, 16907300);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ABEV3', '2019-09-18', 19.36, 19.26, 18058200);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ABEV3', '2019-09-19', 19.48, 19.35, 31674100);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ABEV3', '2019-09-20', 19.43, 19.39, 32256500);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ABEV3', '2019-09-23', 19.24, 19.41, 13283800);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ABEV3', '2019-09-24', 19.47, 19.35, 16061600);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ABEV3', '2019-09-25', 19.25, 19.60, 15238600);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ABEV3', '2019-09-26', 19.57, 19.53, 33341000);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ABEV3', '2019-09-27', 19.56, 19.45, 12406000);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ABEV3', '2019-09-30', 19.53, 19.25, 21538100);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ITUB4', '2019-09-17', 34.87, 35.33, 12170100);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ITUB4', '2019-09-18', 35.34, 35.22, 13259400);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ITUB4', '2019-09-19', 35.51, 34.63, 17884100);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ITUB4', '2019-09-20', 34.85, 34.72, 32814100);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ITUB4', '2019-09-23', 34.67, 34.61, 13194400);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ITUB4', '2019-09-24', 34.79, 34.25, 10472700);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ITUB4', '2019-09-25', 34.16, 34.65, 14103900);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ITUB4', '2019-09-26', 34.85, 35.65, 18630400);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ITUB4', '2019-09-27', 35.56, 35.50, 16137500);"
                    + "insert into cotacao (simbolo, data, abertura, fechamento, volume) values ('ITUB4', '2019-09-30', 35.52, 35.00, 15800200);";

}