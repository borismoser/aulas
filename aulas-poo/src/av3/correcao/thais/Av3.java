package av3.correcao.thais;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import av3.Banco;

public class Av3 {

	public static void main(String[] args) throws SQLException, IOException {

		Banco.inicializar();

// Funcionando		
		selectAcao(Banco.conexao());
		buscarCotacaoPorSimboloDesc(Banco.conexao(), "ITUB4");
		
// n sei se funciona
		LocalDate localDateAntigo = LocalDate.of(2019, 9, 25);            
		System.out.println(localDateAntigo);
		buscarQuantidadeAcao(Banco.conexao(), localDateAntigo, 68.32);
		

//n funciona
//		buscarPorcentagemDeVariacao(Banco.conexao(), "ITUB4");

		
		
	}
	
	
	public static void selectAcao(Connection conn) throws SQLException {
		try {
            Statement stmt = conn.createStatement();
            ResultSet rs =  stmt.executeQuery("select * FROM acao");
             

            while (rs.next()) {
				System.out.printf("%s %n", "Simbolo: " + rs.getString("simbolo") + "	" + "Nome: " + rs.getString("nome"));
			}
             

            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            try {
                if (conn != null) 
                    conn.close();
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

	}
	
	public static void buscarPorcentagemDeVariacao(Connection conexaoBanco, String simbolo) throws SQLException {

		String sql = "select data FROM cotacao as c inner join cotacao as d on (c.data = d.data) WHERE ((c.abertura - c.fechamento)/ 100) > ((d.abertura - d.fechamento)/ 100)";
		
		
		try (PreparedStatement ps = conexaoBanco.prepareStatement(sql)) {

			ps.setString(1, simbolo);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				LocalDate dia = rs.getDate("data").toLocalDate();
				Double variacao = rs.getDouble("variacao");
				
				System.out.format("%s, %s, %s, %s, %s\n", dia, variacao);
				
				
			}
				



		} catch (SQLException e) {
			System.out.println("Algo deu errado, tente novamente.");
			e.printStackTrace();
		} 
	}
	
	public static void buscarCotacaoPorSimboloDesc(Connection conexaoBanco, String simbolo) throws SQLException {

		String sql = "select * FROM cotacao where simbolo = ? order by data desc";
		
		try (PreparedStatement ps = conexaoBanco.prepareStatement(sql)) {

			ps.setString(1, simbolo);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String simbolo2 = rs.getString("simbolo");
				LocalDate dia = rs.getDate("data").toLocalDate();
				Double abertura = rs.getDouble("abertura");
				Double fechamento = rs.getDouble("fechamento");
				int volume = rs.getInt("volume");
				
				System.out.format("%s, %s, %s, %s, %s\n", simbolo2, dia, abertura, fechamento, volume);
			}



		} catch (SQLException e) {
			System.out.println("Algo deu errado, tente novamente.");
			e.printStackTrace();
		} 
	}
	
	public static void buscarQuantidadeAcao(Connection conexaoBanco, LocalDate data, double reais) throws SQLException {

		String sql = "select * FROM cotacao where data = ?";
		
		
		try (PreparedStatement ps = conexaoBanco.prepareStatement(sql)) {

			ps.setDate(1, Date.valueOf(data));

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String simbolo2 = rs.getString("simbolo");
				LocalDate dia = rs.getDate("data").toLocalDate();
				Double abertura = rs.getDouble("abertura");
				Double fechamento = rs.getDouble("fechamento");
				int volume = rs.getInt("volume");
				int qtdacao = 0;
				double a = abertura;
				
				while (a > 0) {
					a = a - reais;
					qtdacao++;
					if(a > 0) {
						qtdacao--;
					}
				}
				
				System.out.format("%s, %s, %s, %s, %s, %s\n", simbolo2, dia, abertura, fechamento, volume, qtdacao);
			}



		} catch (SQLException e) {
			System.out.println("Algo deu errado, tente novamente.");
			e.printStackTrace();
		} 
	}
	
	
	

}