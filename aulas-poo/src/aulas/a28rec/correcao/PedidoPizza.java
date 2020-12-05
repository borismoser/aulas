package aulas.a28rec.correcao;

import java.util.Objects;

public class PedidoPizza {

	private int quantidade;
	private Cliente nome;
	private Cliente telefone;
	private FormaEntrega formaEntrega;
	private double preco;
	
	public PedidoPizza(Cliente nome, FormaEntrega entrega, int quantidade) {
		this.quantidade = quantidade;
		this.nome = nome;
		this.formaEntrega = entrega;
	}
	
	public Cliente getCliente() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}
	
	public FormaEntrega getEntrega() {
		return formaEntrega;
	}

	public int getQuantidade() {
		return quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, quantidade, telefone);
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
		return Objects.equals(nome, other.nome) && quantidade == other.quantidade
				&& Objects.equals(telefone, other.telefone);
	}
	
	
	
	
}
