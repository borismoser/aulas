package av3.correcao.freitas;

public class SimulacaoCotacaoDTO {

	private String simbolo;
	private Integer qntdCompra;
	
	
	public SimulacaoCotacaoDTO() {}
	
	public SimulacaoCotacaoDTO(String simbolo, Integer qntdCompra) {
		this.simbolo = simbolo;
		this.qntdCompra = qntdCompra;
	}
	
	public String getSimbolo() {
		return simbolo;
	}
	public Integer getQntdCompra() {
		return qntdCompra;
	}
	@Override
	public String toString() {
		return "Simbolo: " + this.simbolo +
				" - Quantidade de compra: " + this.qntdCompra;
	}
	
}
