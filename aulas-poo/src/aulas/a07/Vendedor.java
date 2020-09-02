package aulas.a07;

public class Vendedor {

	private String nome;
	private double salarioFixo;
	private double pctComissao;
	private double vendas;

	public Vendedor(String nome, double salarioFixo, double pctComissao) {
		this.nome = nome;
		this.salarioFixo = salarioFixo;
		this.pctComissao = pctComissao;
	}

	public double getSalarioTotal() {
		return this.getSalarioFixo() + this.getComissao();
	}

	public double getComissao() {
		return this.getVendas() * this.getPctComissao() / 100;
	}

	public double getVendas() {
		return this.vendas;
	}

	public void incluirVenda(double valor) {
		if (valor > 0.0) {
			this.vendas += valor;
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

	public double getPctComissao() {
		return pctComissao;
	}

}
