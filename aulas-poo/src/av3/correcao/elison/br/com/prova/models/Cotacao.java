package av3.correcao.elison.br.com.prova.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cotacao {

    private String simbolo;
    private LocalDate data;
    private BigDecimal abertura;
    private BigDecimal fechamento;
    private Integer volume;
    private BigDecimal variacao;

    public Cotacao(String simbolo, LocalDate data, BigDecimal abertura, BigDecimal fechamento, Integer volume) {
        this.simbolo = simbolo;
        this.data = data;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.volume = volume;
        this.variacao = (fechamento.multiply(BigDecimal.valueOf(100)).divide(abertura,2,BigDecimal.ROUND_HALF_EVEN)).subtract(BigDecimal.valueOf(100));
    }

    public String getSimbolo() {
        return simbolo;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getAbertura() {
        return abertura;
    }

    public BigDecimal getFechamento() {
        return fechamento;
    }

    public Integer getVolume() {
        return volume;
    }

    public BigDecimal getVariacao() {
        return variacao;
    }
}
