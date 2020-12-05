package aulas.a28rec.correcao;

import java.util.Objects;

public class PedidoPizza {

	private Cliente cliente;
	private FormaEntrega entrega;
	private int quantidade;

	public PedidoPizza(Cliente cliente, FormaEntrega entrega, int quantidade) {
		this.cliente = Objects.requireNonNull(cliente);
		this.entrega = entrega;
		this.quantidade = quantidade < 1 ? 1 : quantidade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public FormaEntrega getEntrega() {
		return entrega;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getPreco() {
		return entrega == FormaEntrega.BALCAO ? 0.0 : 5.0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, entrega, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoPizza other = (PedidoPizza) obj;
		return Objects.equals(cliente, other.cliente) && entrega == other.entrega && quantidade == other.quantidade;
	}

	
}
