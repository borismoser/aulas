package aulas.a22av2;

public class Produto {

	private int codigo;
	private String descricao;
	private double precoCusto;

	public Produto(int codigo, String descricao, double precoCusto) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoCusto = precoCusto;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

}
