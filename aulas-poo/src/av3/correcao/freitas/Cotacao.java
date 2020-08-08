package av3.correcao.freitas;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cotacao{
	
	private String simbolo;
	private LocalDate data;
	private double abertura;
	private double fechamento;
	private Integer volume;
	
	public Cotacao() {}
	
	public Cotacao(String simbolo, LocalDate data, double abertura, double fechamento, Integer volume) {
		this.simbolo = simbolo;
		this.data = data;
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.volume = volume;
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
	public Integer getVolume() {
		return volume;
	}
	@Override
	public String toString() {
		return  "Simbolo: " + this.simbolo +
				" - Data: " + this.data.format(DateTimeFormatter.ISO_LOCAL_DATE) +
				" - Cotação de abertura: " + this.abertura + 
				" - Cotação de fechamento: " + this.fechamento + 
				" - Volume de negociação: " + this.volume;
	}
	
	public String toStringVariacao() {
		return  "Simbolo: " + this.simbolo +
				" - Data: " + this.data.format(DateTimeFormatter.ISO_LOCAL_DATE) +
				" - Variação " + this.getVariacaoStr();
	}

	public String getVariacaoStr() {
		DecimalFormat formato = new DecimalFormat("#.##");      
		return String.format("%.2f", (((this.fechamento * 100) / this.abertura) - 100));
	}
	public double getVariacao() {
		return (((this.fechamento * 100) / this.abertura) - 100);
	}
}
