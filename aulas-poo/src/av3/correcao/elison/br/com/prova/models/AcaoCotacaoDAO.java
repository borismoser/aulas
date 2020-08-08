package av3.correcao.elison.br.com.prova.models;

import java.util.List;

public class AcaoCotacaoDAO {

    private Acao acao;
    private List<Cotacao> cotacao;

    public AcaoCotacaoDAO(Acao acao, List<Cotacao> cotacao) {
        this.acao = acao;
        this.cotacao = cotacao;
    }

    public Acao getAcao() {
        return acao;
    }

    public List<Cotacao> getCotacao() {
        return cotacao;
    }
}
