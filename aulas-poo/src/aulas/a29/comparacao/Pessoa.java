package aulas.a29.comparacao;

import java.util.Objects;

public class Pessoa implements Comparable<Pessoa> {

	private String nome;
	private int idade;

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idade, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return idade == other.idade && Objects.equals(nome, other.nome);
	}

	// O método compareTo, definido na interface Comparable, deve retornar:
	// - um valor NEGATIVO quando 'this' for MENOR que o outro valor;
	// - um valor POSITIVO quando 'this' for MAIOR que o outro valor;
	// - O valor ZERO quando 'this' e o outro valor forem comparativamente iguais.
	// ATENÇÃO:
	// O retorno do valor ZERO não significa, necessariamente, que os
	// objetos comparados serão iguas se comparados com equals().

	// Neste exemplo, está implemetada uma comparação que leva em
	// consideração o nome e a idade da pessoa para definir a ordenação da classe.
	// Compara-se inicialmente o nome das duas pessoas.
	// Se os nomes 'empatarem', ou seja, se a comparação retornar ZERO,
	// compara-se a idade como critério para definir qual objeto é 'maior'.

	@Override
	public int compareTo(Pessoa o) {
		int result = this.nome.compareTo(o.nome);
		if (result == 0) {
			result = this.idade - o.idade;
		}
		return result;
	}

	@Override
	public String toString() {
		return nome + "/" + idade;
	}

}
