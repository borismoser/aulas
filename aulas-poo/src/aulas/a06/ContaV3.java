package aulas.a06;

// Cada classe pública deve ser declarada em
// um arquivo .java com o mesmo nome da classe.

public class ContaV3 {

	// Em geral, atributos são privados:

	private String titular;

	// É possível inicializar uma propriedade automaticamente:
	private double saldo = 0.0;

	// Construtor da classe, inicializando o nome do titular:
	public ContaV3(String titular) {
		this.titular = titular;
	}

	// Construtor da classe, inicializando titular e saldo:
	public ContaV3(String titular, double saldo) {
		this.titular = titular;
		if (saldo > 0) {
			this.saldo = saldo;
		}
	}

	// Os métodos públicos oferecem formas de interação com o objeto.
	// Manter os atributos privados, portanto, fornece uma maneira
	// controlada de acesso e manipulação do estado interno de um objeto.

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	// O saldo nunca é modificado diretamente, apenas através de métodos
	// que aumentam ou diminuem seu valor, conforme a operação realizada:

	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
		}
	}

	public void sacar(double valor) {
		if (valor > 0) {
			this.saldo -= valor;
		}
	}

}
