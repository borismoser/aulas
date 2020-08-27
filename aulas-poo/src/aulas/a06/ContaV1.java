package aulas.a06;

// Cada classe pública deve ser declarada em
// um arquivo .java com o mesmo nome da classe.

public class ContaV1 {

	// Em geral, atributos são privados:
	private String titular;

	// Os métodos públicos oferecem formas de interação com o objeto.
	// Manter os atributos privados, portanto, fornece uma maneira
	// controlada de acesso e manipulação do estado interno de um objeto.

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}
