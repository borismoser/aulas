package av3.correcao.vinicius.Model;

import java.math.BigDecimal;
import java.util.Date;

public class Cotacao {

	private String simbolo;
	private Date data;
	private BigDecimal abertura;
	private BigDecimal fechamento;
	private Integer volume;
	
	public Cotacao(String simbolo, Date data, BigDecimal abertura, BigDecimal fechamento, Integer volume) {
		this.simbolo = simbolo;
		this.data = data;
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.volume = volume;
	}
	
	public String getSimbolo() {
		return simbolo;
	}
	
	public BigDecimal getAbertura() {
		return abertura;
	}
	
	public BigDecimal getFechamento() {
		return fechamento;
	}
	
	@Override
	public String toString() {
		return "Simbolo: " + this.simbolo + " Data: " + this.data + " Abertura: " + this.abertura + " Fechamento: " + this.fechamento + " Volume: " +this.volume;
	}
}
