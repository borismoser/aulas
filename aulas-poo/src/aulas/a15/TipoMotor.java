package aulas.a15;

public enum TipoMotor {

	// Enumerações permitem listar as opções válidas para um tipo,
	// semelhante a um agrupamento de constantes.
	// Isso permite restringir os valores possíveis para uma
	// variável do tipo da enumeração, contribuindo para a robustez do código.

	COMBUSTAO("Combustão"),
	ELETRICO("Elétrico"),
	HIBRIDO("Híbrido");

	private final String nome;

	// O contrutor é privado e pega seus parâmetros a partir da
	// declaração de cada um dos valores válidos para a enumeração.

	private TipoMotor(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}
}
