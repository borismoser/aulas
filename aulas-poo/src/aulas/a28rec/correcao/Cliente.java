package aulas.a28rec.correcao;

import java.util.Objects;

public class Cliente {

	private String nome;
	private int telefone;
	
	public Cliente(String nome, int telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}
	
	public int getTelefone() {
		return telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, telefone);
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
		Cliente other = (Cliente) obj;
		return Objects.equals(this.nome, other.nome) && this.telefone == other.telefone;
	}
	
	
	
	
}
