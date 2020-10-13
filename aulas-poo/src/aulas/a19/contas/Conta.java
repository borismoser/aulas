package aulas.a19.contas;

import java.util.Objects;

public class Conta {

	private Consumidor consumidor;
	private double valorDevido;

	public Conta(Consumidor consumidor, double valorDevido) {
		this.consumidor = Objects.requireNonNull(consumidor);
		this.valorDevido = valorDevido;
	}

	public double getValorDevido() {
		return valorDevido;
	}

	public void imprimir() {
		System.out.println("Método deve ser sobrescrito nas subclasses.");
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(consumidor, valorDevido);
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
		Conta other = (Conta) obj;
		return Objects.equals(consumidor, other.consumidor)
				&& valorDevido == other.valorDevido;
	}

}
