package av2;

public class Convidado {
	private Pessoa pessoaConvidada;
	private boolean temAcompanhante;
	private boolean confirmouPresenca;

	public Convidado(Pessoa pessoa, boolean temAcompanhante, boolean confirmouPresenca) {
		this.pessoaConvidada = pessoa;
		this.temAcompanhante = temAcompanhante;
		this.confirmouPresenca = confirmouPresenca;
	}

	public Pessoa getPessoaConvidada() {
		return pessoaConvidada;
	}

	public void setPessoaConvidada(Pessoa pessoaConvidada) {
		this.pessoaConvidada = pessoaConvidada;
	}

	public boolean isTemAcompanhante() {
		return temAcompanhante;
	}

	public void setTemAcompanhante(boolean temAcompanhante) {
		this.temAcompanhante = temAcompanhante;
	}

	public boolean isConfirmouPresenca() {
		return confirmouPresenca;
	}

	public void setConfirmouPresenca(boolean confirmouPresenca) {
		this.confirmouPresenca = confirmouPresenca;
	}
	
}
