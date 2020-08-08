package av3.correcao.luan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import av3.Banco;

public class Av3 {

	public static void main(String[] args) {

		Banco.inicializar();
		menu();

	}
	
	private static Scanner inputInt = new Scanner(System.in);
	private static Scanner inputString = new Scanner(System.in);
	
	public static void menu() {
				
		System.out.println("Menu principal:");
        System.out.println("1 - Lista de símbolo e nome disponíveis para consulta;");
        System.out.println("2 - Lista de data, cotacao da abertura, fechamento e volume;");
        System.out.println("3 - Lista do dia com maior variação;");
        System.out.println("4 - Lista da açoes que posso comprar;");
        System.out.println("5 - Sair");
        System.out.print("Opcao: ");
        
        int opcao = inputInt.nextInt();
        
        System.out.println();

        switch (opcao) {
			case 1: dbSimboloNome();break;
			case 2: dbDataAberturaFechammento();break;
			case 3: dbDiaMaiorVaricao(); break;
			case 4: dbQuantidadeAcao();break;
			case 5: System.out.println("Saindo...");System.exit(0);
		}
	}

	private static void dbSimboloNome() {
		String sql = "select simbolo, nome from acao";
		try (ResultSet rs = (ResultSet) Banco.conexao().prepareStatement(sql).executeQuery()) {
			while (rs.next()) {
				System.out.printf("%23s %1.5f %n", rs.getString("simbolo") + "/" + rs.getString("nome"),
						rs.getFloat("simboloNome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}	
	}
	
	private static void dbDataAberturaFechammento() {
		System.out.println("Digite o simbolo:");
		String simbolo = inputString.nextLine(); 
			
		String sql = "select simbolo, volume, (abertura - fechamento) AS percVariavel from cotacao where (abertura > fechamento)";
		try (ResultSet rs = (ResultSet) Banco.conexao().prepareStatement(sql).executeQuery()) {
			while (rs.next()) {
				System.out.printf("%23s %1.5f %n", rs.getString("simbolo") + "/" + rs.getString("volume") + "/"+ rs.getString("percVarialvel"),
						rs.getFloat("percVariavel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}	
	}
		
	private static void dbDiaMaiorVaricao() {
		System.out.println("Digite o simbolo:");
		String simbolo = inputString.nextLine(); 
			
		String sql = "select simbolo, abertura, fechamento,((abertura-fechamento)*100) AS maiorDiaVariacao from cotacao order by ratio desc where simbolo = " + simbolo;
		try (ResultSet rs = (ResultSet) Banco.conexao().prepareStatement(sql).executeQuery()) {
			while (rs.next()) {
				System.out.printf("%23s %1.5f %n", rs.getString("simbolo") + "/" + rs.getString("abertura") + "/" + rs.getString("Fechamento"),
						rs.getFloat("maiorDiaVariacao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}	
	}
	
	private static void dbQuantidadeAcao() {
		System.out.println("Digite uma data(Entre os dias 17 à 30): ");
		int data = inputInt.nextInt();
		System.out.println("Digite um valor em Reais: ");
		int reais = inputInt.nextInt();
		
		String sql = "select simbolo, data, (valor / abertura) AS QuantidadeAcao from cotacao order by ratio desc where data = 2019-09-"+ data+";";
		try (ResultSet rs = (ResultSet) Banco.conexao().prepareStatement(sql).executeQuery()) {
			while (rs.next()) {
				System.out.printf("%23s %1.5f %n", rs.getString("simbolo") + "/" + rs.getString("abertura") + "/" + rs.getString("Fechamento"),
						rs.getFloat("QuantidadeAcao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		}	
	}
}