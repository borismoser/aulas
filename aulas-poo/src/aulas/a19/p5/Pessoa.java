package aulas.a19.p5;

import java.util.Objects;

public class Pessoa {

	private String nome;
	private int idade;

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public Pessoa(String nome, int idade) {
		this(nome);
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getIdade() {
		return this.idade;
	}

	public void oi() {
		System.out.println("Olá, eu me chamo " + nome + " e tenho " + idade + " anos.");
	}

	// O método equals() contém a implementação padrão da linguagem para 
	// verificar se dois objetos são iguais. Essa implementação faz uma
	// comparação de igualdade de referências, com o operador ==.
	
	// Para que possamos definir nossas próprias regras de comparação
	// a fim de verificar se dois objetos devem ser considerados iguais,
	// precisamos sobrescrever o método equals() nas classes necessárias.
	
	// Atenção para as regras 1, 2 e 3, do exemplo a seguir, pois elas
	// sempre devem ser seguidas em uma implementação do método equals().

	@Override
	public boolean equals(Object outraPessoa) {

		// 1 - Um objeto comparado com null não pode resultar em igualdade.
		if (outraPessoa == null) {
			return false;
		}

		// 2 - Um objeto comparado consigo mesmo deve ser considerado igual.
		if (this == outraPessoa) {
			return true;
		}

		// 3 - Objetos de classes diferentes não são considerados iguais.
		if (this.getClass() != outraPessoa.getClass()) {
			return false;
		}

		Pessoa p = (Pessoa) outraPessoa;
		return Objects.equals(this.getNome(), p.getNome()) && //
				this.getIdade() == p.getIdade();
	}

	// De forma geral, sempre que sobrescrevemos o método equals()
	// devemos também sobrescrever o método hashCode() utilizando os mesmos
	// atributos que foram considerados na comparação de igualdade.

	// Por definição da linguagem, dois objetos considerados iguais pelo equals()
	// deveriam retornar o mesmo valor ao chamar seus respectivos hashCode().

	// O contrário, porém, não é obrigatório. É possível que objetos considerados
	// "não iguais" retornem o mesmo hashCode().

	@Override
	public int hashCode() {
		return Objects.hash(this.getNome(), this.getIdade());
	}

}
