package av3.correcao.franz;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import av3.Banco;

public class Av3 {
	public static void main(String[] args) {
		Banco.inicializar();
		
		
		ex01();
		System.out.println("-------------");		
		ex02();
		System.out.println("-------------");
		ex03();
		System.out.println("-------------");
		ex04();
		
		
	}
	public static void ex01() {
		try {
			//Simbolo e nome -> acao
			Connection conexao = Banco.conexao();
			String sql = "SELECT simbolo, nome FROM acao";
			Statement stmt = conexao.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while(resultado.next()) {
				System.out.println("Simbolo: " + resultado.getString(1));
				System.out.println("Nome: " + resultado.getString(2));
			}
			stmt.close();
			conexao.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void ex02() {
		//data, abertura, fechamento, volume -> cotacao - order by data asc; pedir simbolo
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o simbolo: ");
		String simbolo = input.nextLine();
		
		try {
			
			Connection conexao = Banco.conexao();
			String sql = "SELECT abertura, fechamento, volume, data FROM cotacao WHERE simbolo = ? ORDER BY data ASC";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, simbolo);
			ps.execute();
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()) {
				System.out.println("Data: " + resultado.getDate(4));
				System.out.println("Abertura: " + resultado.getFloat(1));
				System.out.println("Fechamento: " + resultado.getFloat(2));
				System.out.println("Volume: " + resultado.getInt(3));
				System.out.println("-----------------------------------");
				
				
			}
			ps.close();
			conexao.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}

	public static void ex03() {
		/*
		  listar o dia com maior variação percentual positiva (e o percentual)
		   entre abertura e fechamento de cada ação (3 pontos);
		 */
		
		try {		
			Connection conexao = Banco.conexao();
			String sql = "SELECT data, MAX(((fechamento - abertura) / abertura) * 100) FROM cotacao GROUP BY data";
			Statement stmt = conexao.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while(resultado.next()) {			
				LocalDate dia = resultado.getDate(1).toLocalDate();
				BigDecimal variacaoPertercentualPositiva = resultado.getBigDecimal(2);				
				System.out.println("Dia: " + dia.getDayOfMonth() + "\nVariacao percentual Positiva: " + variacaoPertercentualPositiva);				
				System.out.println("------------------------------------");
			}
			stmt.close();
			conexao.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void ex04() {
		/*
		 solicitar uma data, um valor em Reais e listar a
		  quantidade (inteira) de ações que teria sido possível 
		  comprar de cada empresa (pela cotação de abertura) naquela data (3 pontos).
		  
		*/
		Scanner input = new Scanner(System.in);
		System.out.println("Digite uma data: ");
		String data = input.nextLine();
		//2019-11-28
		System.out.println("Valor em reais: ");
		BigDecimal valorReais = input.nextBigDecimal();	
		try {			
			Connection conexao = Banco.conexao();
			
			String sql = "SELECT COUNT(simbolo) FROM cotacao WHERE data = ? AND ? > abertura";			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, data);
			ps.setBigDecimal(2, valorReais);			
			ps.execute();
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()) {
				System.out.println("Seria possivel comprar a seguinte quantidade de açoes: " + resultado.getString(1));
			}
			
			conexao.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
