package av3.correcao.elison.br.com.prova.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import av3.correcao.elison.br.com.prova.components.Menu;
import av3.correcao.elison.br.com.prova.models.Acao;
import av3.correcao.elison.br.com.prova.models.Cotacao;
import av3.correcao.elison.br.com.prova.repositories.AcaoRepository;
import av3.correcao.elison.br.com.prova.repositories.CotacaoRepository;

public class MenuService {

    public void printAllAcoes () {
        List<Acao> acoes = AcaoRepository.findAllAcoes();
        System.out.println("------------LISTA DE ACÕES------------");
        for (Acao acao: acoes) {
            System.out.println(String.format("Simbolo : %s - Nome: %s", acao.getSimbolo(), acao.getNome()));
        }
        System.out.println("--------------------------------------");
        Menu.showMenu();
    }

    public void printAllCotacoesByAcao(String simbolo){
        List<Cotacao> cotacoes = CotacaoRepository.findCotacaoById(simbolo);
        System.out.println("------------Cotações da Ação------------");
        for (Cotacao cotacao: cotacoes) {
            System.out.println(String.format("Data: %s - Abertura: %s - Fechamento: %s - Volume: %d",
                    cotacao.getData(), cotacao.getAbertura(), cotacao.getFechamento(), cotacao.getVolume()));
        }
        System.out.println("----------------------------------------");
    }

    public void printMaxPercentByAcoes() {
        List<Cotacao> cotacoes = CotacaoRepository.findAllCotacao();
        Map<String, Cotacao> maps = getCotacaoMaxVariable(cotacoes);
        System.out.println("--------------Variação de percentual-------------");
        for (Map.Entry<String,Cotacao> cotacao : maps.entrySet()) {

            System.out.println(String.format("Ação: %s", cotacao.getKey()));
            System.out.println(String.format("Dia: %s - Variação: %s", cotacao.getValue().getData(), cotacao.getValue().getVariacao()));
            System.out.println("----------------------------------------------");
        }
    }

    public void printAmountBuyAcoesInDate(LocalDate date, BigDecimal value){
        List<Cotacao> cotacoes = CotacaoRepository.findCotacoesByDate(date);
        System.out.println("--------------Quantidade de ações que podem ser compradas-------------");
        for (Cotacao cotacao: cotacoes) {
            System.out.println(String.format("Ação: %s", cotacao.getSimbolo()));
            Boolean i = true;
            int quantidade = 0;
            BigDecimal valueAmount = value;
            while (i) {
                valueAmount = valueAmount.subtract(cotacao.getAbertura());
                if (valueAmount.compareTo(new BigDecimal(0)) == 1){
                    quantidade++;
                } else {
                    i = false;
                }
            }
            System.out.println(String.format("Quantidade: %s", quantidade));
            System.out.println("----------------------------------------------------------------------");
        }
    }

    public Map getCotacaoMaxVariable(List<Cotacao>cotacoes) {
        Map<String, Cotacao> maps =  new HashMap<>();
        for (int i = 0; i < cotacoes.size(); i++) {
            Cotacao cotacao = cotacoes.get(i);
            if (maps.containsKey(cotacao.getSimbolo())) {
                if (cotacao.getVariacao().compareTo(maps.get(cotacao.getSimbolo()).getVariacao()) == 1) {
                    maps.put(cotacao.getSimbolo(), cotacao);
                }
            } else {
                maps.put(cotacao.getSimbolo(), cotacao);
            }
        }
        return maps;
    }
}
