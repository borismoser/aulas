package comp1;

public class Endereco {
	private TipoLogradouro tipoLogradouro;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private Cidade cidade;

	@Override
	public String toString() {
		return tipoLogradouro.getAbreviatura() + " " + logradouro + ", " + numero + "\n" +
				cidade.getNome() + "/" + cidade.getEstado().getAbreviatura() + " - " +
				cidade.getEstado().getPais().getNome();
	}
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

}
