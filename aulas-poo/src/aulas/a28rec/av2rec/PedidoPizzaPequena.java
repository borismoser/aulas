package aulas.a28rec.av2rec;

import java.util.Objects;

public class PedidoPizzaPequena extends PedidoPizza {

	private Sabor sabor;

	public PedidoPizzaPequena(Cliente cliente, FormaEntrega entrega, int quantidade, Sabor sabor) {
		super(cliente, entrega, quantidade);
		this.sabor = sabor;
	}
	
	public Sabor getSabor() {
		return sabor;
	}

	@Override
	public double getPreco() {
		return getQuantidade() * 30 + super.getPreco();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(sabor);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoPizzaPequena other = (PedidoPizzaPequena) obj;
		return sabor == other.sabor;
	}
	
	
}
