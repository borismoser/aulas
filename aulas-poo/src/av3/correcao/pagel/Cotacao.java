package av3.correcao.pagel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cotacao {

	private String simbolo;
	private LocalDate data;
	private BigDecimal abertura;
	private BigDecimal fechamento;
	private int volume;
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public BigDecimal getAbertura() {
		return abertura;
	}
	public void setAbertura(BigDecimal abertura) {
		this.abertura = abertura;
	}
	public BigDecimal getFechamento() {
		return fechamento;
	}
	public void setFechamento(BigDecimal fechamento) {
		this.fechamento = fechamento;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	
	
	
}
