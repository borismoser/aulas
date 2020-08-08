package av3.correcao.slash.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import av3.Banco;
import av3.correcao.slash.av3.banco.AcaoDml;
import av3.correcao.slash.av3.banco.CotacaoDml;
import av3.correcao.slash.model.Acao;
import av3.correcao.slash.model.Cotacao;

public class Av3 {
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		Banco.inicializar();
		
		
		System.out.println("Selecione uma das opções para realizar uma ação: ");
		System.out.println("A - listar as ações (símbolo e nome) disponíveis para consulta \n ");
		System.out.println("B - listar as informações de data, cotação de abertura, fechamento e volume de negociação de uma determinada ação (solicitar o símbolo), classificadas pelas datas mais recentes \n");
		System.out.println("C - listar o dia com maior variação percentual positiva (e o percentual) entre abertura e fechamento de cada ação \n");
		System.out.println("D - solicitar uma data, um valor em Reais e listar a quantidade (inteira) de ações que teria sido possível comprar de cada empresa (pela cotação de abertura) naquela data \n");
		String resposta = teclado.nextLine();
		//Não me orgulho do que fiz, mas precisava sair rápido
		if(resposta.equals("A")){
			List<Acao> acoes = AcaoDml.listarAcoes();
			listarAcoes(acoes);
		}else if (resposta.equals("B")) {
			printarCotacoes();			
		} else if(resposta.equals("C")) {
			printarMaiorVariacaoPercent();
		} else if(resposta.equals("D")) {
			printarQuantidadeAcoes();
		}
		
	}

	private static void printarQuantidadeAcoes() {
		System.out.println("Digite uma data (dd/MM/yyyy: \n");
		String data = teclado.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		System.out.println("Digite um valor em reais: ");
		double valorReais = teclado.nextDouble();
		
		
		List<Cotacao> cotacoes = CotacaoDml.getCotacoesPorSimbolo("");
		cotacoes = cotacoes.stream().filter(c -> c.getData().equals(localDate)).collect(Collectors.toList());
//			ABEV3 ITUB4 PETR4 VALE3
		List<Cotacao> cotacoesAbev3 = cotacoes.stream().filter(c -> c.getSimbolo().equals("ABEV3")).collect(Collectors.toList());
		
		int quantidadeCotacoesAbev3 = 0;
		int quantidadeCotacoesItub4 = 0;
		int quantidadeCotacoesPetr4 = 0;
		int quantidadeCotacoesVale3 = 0;
		
		for (Cotacao cotacao : cotacoesAbev3) {
			quantidadeCotacoesAbev3 = quantidadeCotacoesAbev3 + ((Double)(valorReais / cotacao.getAbertura())).intValue();
		}
		List<Cotacao> cotacoesItub4 = cotacoes.stream().filter(c -> c.getSimbolo().equals("ITUB4")).collect(Collectors.toList());
		for (Cotacao cotacao : cotacoesItub4) {
			quantidadeCotacoesItub4 = quantidadeCotacoesItub4 + ((Double)(valorReais / cotacao.getAbertura())).intValue();
		}
		List<Cotacao> cotacoesPetr4 = cotacoes.stream().filter(c -> c.getSimbolo().equals("PETR4")).collect(Collectors.toList());
		for (Cotacao cotacao : cotacoesPetr4) {
			quantidadeCotacoesPetr4 = quantidadeCotacoesPetr4 + ((Double)(valorReais / cotacao.getAbertura())).intValue();
		}
		List<Cotacao> cotacoesVale3 = cotacoes.stream().filter(c -> c.getSimbolo().equals("VALE3")).collect(Collectors.toList());
		for (Cotacao cotacao : cotacoesVale3) {
			quantidadeCotacoesVale3 = quantidadeCotacoesVale3 + ((Double)(valorReais / cotacao.getAbertura())).intValue();
		}
		
		System.out.println("Você poderia ter comprado as quantidades ações de cada empresa: \n");
		System.out.println("AMBEV S/A ON quantidade: " + quantidadeCotacoesAbev3);
		System.out.println("ITAU UNIBANCO PN quantidade: " + quantidadeCotacoesItub4);
		System.out.println("PETROBRAS PN quantidade: " + quantidadeCotacoesPetr4);
		System.out.println("VALE ON quantidade: " + quantidadeCotacoesVale3);
	}

	private static void printarMaiorVariacaoPercent() {
		List<Cotacao> cotacoes = CotacaoDml.getCotacoesPorSimbolo("");
		double maiorVariacaoPercentual = cotacoes.stream().map(Cotacao::getVariacaoPercentual).max(Double::compare).get();
		
		Cotacao cotacaoMaiorVariacaoPercentual = cotacoes.stream().filter(c -> c.getVariacaoPercentual() == maiorVariacaoPercentual).findFirst().get();
		String data = cotacaoMaiorVariacaoPercentual.getData().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
		System.out.println("Dia com maior variação: " + data + "\nO percentual foi de " + maiorVariacaoPercentual + "%");
	}

	private static void printarCotacoes() {
		System.out.println("Favor digitar uma ação: \n");
		String simbolo = teclado.nextLine();
		List<Cotacao> cotacoes = CotacaoDml.getCotacoesPorSimbolo(simbolo);
		System.out.println("Data"+ "\t| Abertura | Fechamento | Volume");
		
		for (Cotacao cotacao : cotacoes) {
			String data = cotacao.getData().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
			System.out.println(data + "| " + cotacao.getAbertura() + "| \t" + cotacao.getFechamento() + "| \t" + cotacao.getVolume());
		}
	}

	private static void listarAcoes(List<Acao> acoes) {
		System.out.println("Ações disponíveis: \n");
		System.out.println("Símbolo | Nome ");
		acoes.forEach(a ->{ 
				System.out.println(a.getSimbolo()+ " \t| "+ a.getNome());
		});
	}
}