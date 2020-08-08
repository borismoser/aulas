package av3.correcao.barg;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;

import av3.Banco;



public class Av3 {

	public static void main(String[] args) throws SQLException {
		Scanner teclado = new Scanner(System.in);
		Banco.inicializar();
		menu(teclado);
	
	}
	
	
	public static void menu(Scanner teclado) throws SQLException {
		System.out.println("1 - Listar Açoes");
		System.out.println("2 - istar as informações de data, cotação de abertura, fechamento e volume de negociação de uma determinada ação");
		System.out.println("3 - listar o dia com maior variação percentual positiva");
		System.out.println("4 - solicitar uma data, um valor em Reais e listar a quantidade (inteira) de ações que teria sido possível comprar de cada empresa");
		int opcao = teclado.nextInt();
		
		switch(opcao){

        case 1:
        	
           listarAcoes();
            break;

        case 2:
        	infoAcoes( teclado);
            
            break;
        case 3:
            maiorPercentual();
            break;
        case 4:
        	quantidadeAcoes(teclado);
            break;

        default:
       
	}
	
	}
	
	public static void listarAcoes() throws SQLException {
		System.out.println("Listar Açoes");
		String sql =("Select * from acao ");
			try(ResultSet rs =  (ResultSet) Banco.conexao().prepareStatement(sql)){
				while(rs.next()) {
					System.out.printf("%23s %1.5f %n","Simbolo"+ rs.getInt(1) + "/" ,"Nome" + rs.getString(2));
							
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public static void infoAcoes(Scanner teclado ) throws SQLException {
		System.out.println();
		System.out.println("Escolha");
		System.out.println("1 - PETR4");
		System.out.println("2 - VALE3");
		System.out.println("3 - ABEV3 ");
		System.out.println("4 - ITUB4");
		int acao = teclado.nextInt();
		String sql =("seelct * from cotacao where simbolo = '&quot;+acao+&quot'");
		
		try(ResultSet rs = (ResultSet) Banco.conexao().prepareStatement(sql)){
			
		while(rs.next()) {
			System.out.printf("%23s %1.5f %n","Simbolo"+ rs.getInt(1) + "/" ,"Data" + rs.getDate(2)+ "/" ,"abertura" + rs.getDouble(3)+ "/" ,"fechamento" + rs.getDouble(4)+ "/" ,"volume" + rs.getDouble(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void maiorPercentual() throws SQLException {
		System.out.println("Maior Percentual");
		String sql= ("select data,abertura-fechamento as diferenca from cotacao where max(diferenca)");
		try(ResultSet rs = (ResultSet) Banco.conexao().prepareStatement(sql)){
			while(rs.next()) {
				System.out.printf("data"+ rs.getInt(1));
						
			}
		}catch(SQLException e) {
			e.printStackTrace();
			}
		}
	
	public static void quantidadeAcoes (Scanner teclado) throws SQLException   {
		String sql = ("select nome,('&quot;+valor+&quot'/abertura) as Quantidade from cotacao where data = '&quot;+data+&quot' ");
		System.out.println("Informe um valor em reais");
		Double valor = teclado.nextDouble();
		System.out.println("Informe uma data entre 2019-09-17 ate 2019-09-306");
		String data = teclado.nextLine();
		try(ResultSet rs = (ResultSet) Banco.conexao().prepareStatement(sql)){
			while(rs.next()) {
				System.out.printf("Nome"+rs.getString(1)+"/"+"Quantidade"+rs.getDouble(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}