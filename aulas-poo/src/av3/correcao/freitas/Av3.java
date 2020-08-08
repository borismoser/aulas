package av3.correcao.freitas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import av3.Banco;

public class Av3 {

	public static void main(String[] args) {

		Banco.inicializar();
		List<Acao> lAcoes = AcaoDAO.recuperaAcoes();
		
		System.out.println("!-- Ações existentes --!");
		lAcoes.forEach(obj -> System.out.println(obj.toString()));
		
		String simbolo = JOptionPane.showInputDialog("Com as ações existentes(Expressas no console), favor informar um símbolo");
		simbolo = simbolo.toUpperCase();
		List<Cotacao> lCotacoes = CotacaoDAO.buscaCotacao(simbolo);
		if (!lCotacoes.isEmpty()) {
			System.out.println("\n!-- Cotações " + simbolo + " --!");
			lCotacoes.forEach(obj -> System.out.println(obj.toString()));
		} else {
			System.out.println("Simbolo incorreto digitado!");
		}

		List<String> lSimbolos = new ArrayList<String>();
		lAcoes.forEach(obj -> lSimbolos.add(obj.getSimbolo()));
		List<Cotacao> lMaioresVariacoesCotacao = maioresCotacoes(CotacaoDAO.retornaCotacoes(), lSimbolos);
		
		System.out.println("\n!-- Maior variação percentual positiva --!");
		lMaioresVariacoesCotacao.forEach(obj -> System.out.println(obj.toStringVariacao()));
		
		Integer valorCompra = null;
		LocalDate dataCompra = null;
		try{valorCompra = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de compra(Numeros): EX: 1000"));} catch (Exception e) {}
		try{dataCompra = LocalDate.parse(JOptionPane.showInputDialog("Favor, digite a data de compra no formato YYYY-MM-DD: EX: 2019-11-28"));} catch (Exception e) {}
		if(valorCompra == null || dataCompra == null) {
			System.out.println("\nValor de compra e/ou data de compra invalido(s)");
		} else {
			List<SimulacaoCotacaoDTO> lPossiveisComprasCotacao = CotacaoDAO.comprasCotacao(valorCompra, dataCompra); 
			if(!lPossiveisComprasCotacao.isEmpty()) {
				System.out.println("\n!-- Quantidade de compra no dia " + dataCompra.format(DateTimeFormatter.ISO_DATE) + " --!");
				lPossiveisComprasCotacao.forEach(obj -> System.out.println(obj.toString()));
			} else {
				System.out.println("\nNão possuem registros na data digitada");
			}
		}
		
	}
	
	private static List<Cotacao> maioresCotacoes(List<Cotacao> lCotacoes, List<String> lSimbolos) {
		List<Cotacao> lMaioresCotacoes = new ArrayList<Cotacao>();
		for (String umSimbolo : lSimbolos) {
			Cotacao maiorVariacao = null;
			for (Cotacao umaCotacao : lCotacoes) {
				if(umSimbolo.equals(umaCotacao.getSimbolo())){
					if(maiorVariacao == null) {
						maiorVariacao = umaCotacao;
						continue;
					}
					if(umaCotacao.getVariacao() > maiorVariacao.getVariacao()) {
						maiorVariacao = umaCotacao;
					}
				}
			}
			lMaioresCotacoes.add(maiorVariacao);
		}
		return lMaioresCotacoes;
	}

}