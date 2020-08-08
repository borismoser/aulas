package av3.correcao.marlon.Model;

import java.sql.Date;

public class Cotacao {

	String simbolo;
	Date data;
	Double abertura;
	Double fechamento;
	Integer volume;
	Double dif;
	
	public Cotacao(String simbolo, Date data, Double abertura, Double fechamento, Integer volume, Double dif) {
		this.simbolo = simbolo;
		this.data = data;
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.volume = volume;
		this.dif = dif;
	}

	public Cotacao() {}
	
	private Double getPorentagem() {
		return (fechamento*100/abertura)-100;
	}

	@Override
	public String toString() {
		return "Cotacao [simbolo=" + simbolo + ", data=" + data + ", abertura=" + abertura + ", fechamento="
				+ fechamento + ", volume=" + volume + ", dif=" + dif + ", porcentagem: " + getPorentagem() + "%]";
	}

	public String getSimbolo() {
		return simbolo;
	}

	public Date getData() {
		return data;
	}

	public Double getAbertura() {
		return abertura;
	}

	public Double getFechamento() {
		return fechamento;
	}

	public Integer getVolume() {
		return volume;
	}

	public Double getDif() {
		return dif;
	}
}
