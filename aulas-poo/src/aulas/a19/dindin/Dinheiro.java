package aulas.a19.dindin;

import java.util.Objects;

public class Dinheiro {

	private int valor;
	private String simbolo;

	public Dinheiro(int valor, String simbolo) {
		this.valor = valor;
		this.simbolo = simbolo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(simbolo, valor);
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
		Dinheiro other = (Dinheiro) obj;
		return Objects.equals(simbolo, other.simbolo) && valor == other.valor;
	}

	@Override
	public String toString() {
		if (simbolo == null) {
			return String.valueOf(valor);
		}
		return simbolo + valor;
	}

}
