package av3.correcao.brunodossantos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import av3.Banco;

public class AV3 {

    public static void main(String[] args) {
        Banco.inicializar();

        Menu();
    }

    private static void Menu() {
        String rep;
        Scanner a = new Scanner(System.in);   
        System.out.println("Escolha uma das opções abaixo:\n"
                + "A)Lista ações.\n"
                + "B)Lista Informações de data\n"
                + "C)Lista dia com maior cotação\n"
                + "D)Solicitar uma data.");
        rep = a.nextLine();
        if (rep.equals("A")) {
            N1();
        }else if(rep.equals("B")){
            System.out.println("Escreva a ação para ser vista");
            N2(a.nextLine());
        }else if(rep.equals("C")){
            N3();
        }else if(rep.equals("D")){
            System.out.println("Escreva a data para comprar formato('2019-09-19')");
            String data=a.nextLine();
            System.out.println("Escreva o valor para a compra");
            Double valor=a.nextDouble();
            N4(data, valor);
        }
    }

    private static void N1() {
        Connection cone = Banco.conexao();
        String cod = "Select * from acao";
        try {
            Statement st = cone.createStatement();
            ResultSet rs = st.executeQuery(cod);
            while (rs.next()) {
                System.out.println(rs.getString("Simbolo") + " " + rs.getString("Nome"));
            }
        } catch (Exception e) {
            System.out.println("Deu erro aqui");
        }
    }

    private static void N2(String Simbolo) {
        /*
         listar as informações de data, cotação de abertura, fechamento e volume de negociação de 
         uma determinada ação (solicitar o símbolo), classificadas pelas datas mais recentes (2 pontos);
        */  
        Connection cone = Banco.conexao();
        String cod = "Select co.data data, co.abertura aber, co.fechamento fecha, co.volume vol"
                + "     from cotacao co"
                + "    where co.simbolo = '"+Simbolo+"'"
                + "    order by co.data desc";
        try {
            Statement st = cone.createStatement();
            ResultSet rs = st.executeQuery(cod);
            while (rs.next()) {
                System.out.println(rs.getString("data") + " | " + rs.getString("aber") + " | "+ rs.getString("fecha")+ " | "+ rs.getString("vol"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private static void N3(){
        /*
         listar o dia com maior variação percentual positiva (e o percentual) 
         entre abertura e fechamento de cada ação (3 pontos);
        */
     
        Connection cone = Banco.conexao();
        /*String cod = "Select max((co.fechamento - co.abertura)*100) vari, co.data data, co.simbolo simbolo"
                + "     from cotacao co"
                + "    group by data, simbolo";*/
          
       String cod = "Select co.data data, co.simbolo simbolo, max((co.fechamento - co.abertura)*100) vari "
                 + "  from (select ca.simbolo simbolo, max((ca.fechamento - ca.abertura)*100) vai "
               + "            from cotacao ca group by simbolo) vari join cotacao co"
                + "     on co.simbolo = vari.simbolo"
                + "    group by co.data, co.simbolo";
        try {
            Statement st = cone.createStatement();
            ResultSet rs = st.executeQuery(cod);
            while (rs.next()) {
               System.out.println(rs.getString("simbolo")+ " | "+  rs.getString("vari")+ "% |"+ rs.getString("data"));  
               
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private static void N4(String data, double valor){
        /*
         solicitar uma data, um valor em Reais e listar a quantidade (inteira) 
         de ações que teria sido possível comprar de cada empresa (pela cotação de abertura) naquela data (3 pontos).
        */
        
        Connection cone = Banco.conexao();
        int cot;
        String cod = "Select co.abertura abr, co.simbolo"
                + "     from cotacao co"
                + "    where co.data =" + data;
              //  + "    order by vari desc limit 1";
        try {
            Statement st = cone.createStatement();
            ResultSet rs = st.executeQuery(cod);
            while (rs.next()) {
                cot = (int)(rs.getFloat("abr")/valor);
                System.out.println(cot + " | "+rs.getString("simbolo") + " | " + rs.getString("abr"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
