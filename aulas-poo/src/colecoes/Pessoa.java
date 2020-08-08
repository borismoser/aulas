package colecoes;

import java.util.Objects;

public class Pessoa implements Comparable<Pessoa> {

	private String nome;
	private int idade;

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public int getIdade() {
		return this.idade;
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public String toString() {
		return this.nome + ":" + this.idade;
	}

	@Override
	public int compareTo(Pessoa o) {
		return this.getNome().compareTo(o.getNome());
	}

	@Override
	public int hashCode() {
		/*
		final int prime = 31;
		int result = 1;
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
		*/
		return Objects.hash(idade, nome);
	}

	@Override
	public boolean equals(Object obj) {
		Pessoa p = (Pessoa) obj;
		return (idade == p.idade) && (nome.equals(p.nome));
	}

}
