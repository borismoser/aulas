package av3.correcao.slash.model;

import java.time.LocalDate;

public class Cotacao {

	private String simbolo;
	private LocalDate data;
	private double abertura;
	private double fechamento;
	private double variacaoPercentual;
	private int volume;
	
	public Cotacao(String simbolo, LocalDate data, double abertura, double fechamento, int volume) {
		super();
		this.simbolo = simbolo;
		this.data = data;
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.volume = volume;
		this.variacaoPercentual = (fechamento - abertura)/abertura;		
	}

	public String getSimbolo() {
		return simbolo;
	}

	public LocalDate getData() {
		return data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public int getVolume() {
		return volume;
	}
	
	public double getVariacaoPercentual() {
		return variacaoPercentual; 
	}
	
}
