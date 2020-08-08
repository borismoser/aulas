package comp1;

public class Estado {
	private String nome;
	private String abreviatura;
	private Pais pais;

	public Estado(String nome, String abreviatura, Pais pais) {
		this.nome = nome;
		this.abreviatura = abreviatura;
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

}
