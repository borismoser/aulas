package aulas.a07;

public class Vendedor {

	// Dados que podem ser alterados por get/set:
	private String nome;
	private double salarioFixo;
	private double pctComissao;

	// Dados mantidos internamente:
	private double vendas;

	public Vendedor(String nome, double salarioFixo, double pctComissao) {
		this.nome = nome;
		this.salarioFixo = salarioFixo;
		this.pctComissao = pctComissao;
	}

	public double totalSalario() {
		return salarioFixo + this.totalComissao();
	}

	public double totalComissao() {
		return vendas * pctComissao / 100;
	}

	public double totalVendas() {
		return vendas;
	}

	public void incluirVenda(double valor) {
		if (valor > 0.0) {
			vendas += valor;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(double salarioFixo) {
		this.salarioFixo = salarioFixo;
	}

	public double getPctComissao() {
		return pctComissao;
	}

	public void setPctComissao(double pctComissao) {
		this.pctComissao = pctComissao;
	}

}
