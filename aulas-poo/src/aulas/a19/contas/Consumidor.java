package aulas.a19.contas;

import java.util.Objects;

public class Consumidor {

	private String nome;

	public Consumidor(String nome) {
		this.nome = Objects.requireNonNull(nome);
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Consumidor other = (Consumidor) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Consumidor [nome=" + nome + "]";
	}

}
