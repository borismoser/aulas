package comp1;

public enum TipoLogradouro {

	RUA("Rua", "R."),
	AVENIDA("Avenida", "Av."),
	ALAMEDA("Alameda", "Al."),
	SERVIDAO("Servidão", "Srv."),
	PRACA("Praça", "Pca");

	private final String descricao;
	private final String abreviatura;

	private TipoLogradouro(String descricao, String abreviatura) {
		this.descricao = descricao;
		this.abreviatura = abreviatura;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

}
