package av3.correcao.dussmann;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import av3.Banco;

public class Av3 {

    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Banco.inicializar();
        Banco.conexao();

        chamaMenu();
    }

    private static void chamaMenu() {

        System.out.println("Selecione a opção desejada: ('XAU' para encerrar)");
        System.out.println("A- Listar as ações;");
        System.out.println("B- Listar informações por ação;");
        System.out.println("C- Listar variação;");
        System.out.println("D- Listar ações por data e valor.");
        String opcao = entrada.nextLine();

        while (!opcao.equals("A") && !opcao.equals("B") && !opcao.equals("C") && !opcao.equals("D") && !opcao.equals("XAU")) {
            System.out.println("Selecione uma opção VÁLIDA:");
            System.out.println("A) Listar as ações;");
            System.out.println("B) Listar informações por ação;");
            System.out.println("C) Listar variação;");
            System.out.println("D) Listar ações por data e valor.");

            opcao = entrada.nextLine();
        }

        System.out.println();
        switch (opcao) {
            case "A":
                Consulta.listarAcoes();
                System.out.println();
                chamaMenu();
                break;
            case "B":
                menuInformacao();
                chamaMenu();
                break;
            case "C":
                Consulta.listarDia();
                chamaMenu();
                break;
            case "D":
                menuDatas();
                chamaMenu();
                break;
            case "XAU":
                System.out.println("XAU XAU");
                break;
        }
    }

    private static void menuInformacao() {
        List<String> lista = Consulta.getAcoes();

        System.out.println("Qual ação deseja listar as informações");
        Consulta.listarAcoes();

        String acao = entrada.nextLine();

        while (!lista.contains(acao)) {
            System.out.println("Opção inválida, informe a ação novamente:");
            Consulta.listarAcoes();
            acao = entrada.nextLine();
        }

        System.out.println();
        Consulta.listarInfoPorAcao(acao);
        System.out.println();
    }

    private static void menuDatas() {
        List<String> listaDatas = Consulta.getDatas();

        System.out.println("Qual data deseja listar as informações");
        listaDatas.forEach(System.out::println);

        String data = entrada.nextLine();

        while (!listaDatas.contains(data)) {
            System.out.println("Opção inválida, informe a data novamente:");
            listaDatas.forEach(System.out::println);
            data = entrada.nextLine();
        }

        System.out.println("Informe o valor a ser consultado: ");
        double valor = entrada.nextDouble();

        Consulta.listarValorPorData(data, valor);
        System.out.println();
    }
}
