package cidades;

import java.util.Objects;

public class Cidade implements Comparable<Cidade> {
	private String uf;
	private String nome;
	private int popTotal;
	private int popMasc;
	private int popFem;

	public Cidade(String uf, String nome, int popTotal, int popMasc, int popFem) {
		this.uf = uf;
		this.nome = nome;
		this.popTotal = popTotal;
		this.popMasc = popMasc;
		this.popFem = popFem;
	}

	public Cidade(String[] campos) {
		this(campos[0], campos[1], Integer.valueOf(campos[2]), Integer.valueOf(campos[3]), Integer.valueOf(campos[4]));
	}

	@Override
	public String toString() {
		return String.format("%s/%s (%,d)", this.nome, this.uf, this.popTotal);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.uf, this.nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	public String getUf() {
		return uf;
	}

	public String getNome() {
		return nome;
	}

	public int getPopTotal() {
		return popTotal;
	}

	public int getPopMasc() {
		return popMasc;
	}

	public int getPopFem() {
		return popFem;
	}

	@Override
	public int compareTo(Cidade obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			return 1;
		if (this.equals(obj))
			return 0;
		Cidade other = (Cidade) obj;
		return this.nome.compareTo(other.nome);
	}

}
