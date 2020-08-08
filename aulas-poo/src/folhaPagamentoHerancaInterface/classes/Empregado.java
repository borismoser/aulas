package folhaPagamentoHerancaInterface.classes;

public class Empregado implements Pagavel {
	private String nome;
	private String sobrenome;
	private String cpf;
	private ModeloPagamento modeloPagamento;

	public Empregado(String nome, String sobrenome, String cpf) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}

	public final String getNome() {
		return nome;
	}

	public final String getSobrenome() {
		return sobrenome;
	}

	public final String getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return nome + " " + sobrenome + " (" + cpf + ")";
	}

	public void setModeloPagamento(ModeloPagamento modeloPagamento) {
		this.modeloPagamento = modeloPagamento;
	}

	public ModeloPagamento getModeloPagamento() {
		return modeloPagamento;
	}

	@Override
	public double getTotalDevido() {
		return modeloPagamento.getSalarioBruto();
	}

}
