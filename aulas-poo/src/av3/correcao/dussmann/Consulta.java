package av3.correcao.dussmann;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public final class Consulta {

    private static String hsql = "jdbc:hsqldb:mem:memorydb:";
    private static String usr = "SA";
    private static String pwd = "";


    private static NumberFormat currencyformatter = NumberFormat.getCurrencyInstance();
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    private static RowSetFactory factory = null;

    public static JdbcRowSet executarSQL(String SQL) throws SQLException {
        JdbcRowSet rs = null;
        try {
            if (factory == null) {
                factory = RowSetProvider.newFactory();
            }
            rs = factory.createJdbcRowSet();
            rs.setUrl(hsql);
            rs.setUsername(usr);
            rs.setPassword(pwd);
            rs.setCommand(SQL);
            rs.execute();
        } catch (SQLException e) {
            throw e;
        }
        return rs;
    }


    public static void listarAcoes() {
        String sql = "select simbolo, nome from acao";
        try (JdbcRowSet rs = Consulta.executarSQL(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString(1) + " | " + rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getAcoes() {
        List<String> resultList = new ArrayList<>();
        String sql = "select simbolo from acao";
        try (JdbcRowSet rs = Consulta.executarSQL(sql)) {
            while (rs.next()) {
                resultList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static List<String> getDatas() {
        List<String> resultList = new ArrayList<>();
        String sql = "SELECT DISTINCT DATA FROM COTACAO";
        try (JdbcRowSet rs = Consulta.executarSQL(sql)) {
            while (rs.next()) {
                resultList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static void listarInfoPorAcao(String acao) {
        String sql = "select * from cotacao where simbolo = '" + acao + "' order by data desc";
        try (JdbcRowSet rs = Consulta.executarSQL(sql)) {
            while (rs.next()) {
                System.out.println(
                        "Ação: " + rs.getString(1) + " | " +
                        "Data: " + dateFormatter.format(rs.getDate(2)) + " | " +
                        "Valor Abertura: " + currencyformatter.format(rs.getBigDecimal(3)) + " | " +
                        "Valor Fechamento: " + currencyformatter.format(rs.getBigDecimal(4)) + " | " +
                        "Volume: " + rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listarDia() {
        List<ListaDia> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT C.simbolo, (c.fechamento*100/c.abertura)-100, c.data FROM cotacao c";
        try (JdbcRowSet rs = Consulta.executarSQL(sql)) {
            while (rs.next()) {
                lista.add(new ListaDia(rs.getString(1), rs.getDouble(2), rs.getDate(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String, ListaDia> map = new HashMap<>();
        for (ListaDia l: lista) {
            ListaDia ld = map.getOrDefault(l.acao, new ListaDia(l.acao, -100.0, new Date()));
            if (l.valor > ld.valor) {
                map.put(l.acao, l);
            }
        }
        map.values().forEach((ListaDia::imprimeListaDia));
        System.out.println();
    }

    public static void listarValorPorData(String data, double valor) {
        String sql = "SELECT A.NOME, C.ABERTURA FROM COTACAO C INNER JOIN ACAO A ON C.SIMBOLO = A.SIMBOLO WHERE C.DATA = '" + data + "'";
        try (JdbcRowSet rs = Consulta.executarSQL(sql)) {
            while (rs.next()) {
                System.out.println(
                        "Empresa: " + rs.getString(1) + " | " +
                                "Quantidade de Ações: " + (int) (valor / rs.getDouble(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Consulta() {
    }

    private static class ListaDia {
        String acao;
        Double valor;
        Date data;

        public ListaDia(String acao, Double valor, Date data) {
            this.acao = acao;
            this.valor = valor;
            this.data = data;
        }

        public void imprimeListaDia() {
            System.out.println("Ação: " + acao + " | Variação: " + valor + "% | Data: " + dateFormatter.format(data));
        }
    }
}
