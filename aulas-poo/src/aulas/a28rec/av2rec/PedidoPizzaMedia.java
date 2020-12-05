package aulas.a28rec.av2rec;

import java.util.Objects;

public class PedidoPizzaMedia extends PedidoPizza {

	private Sabor sabor1;
	private Sabor sabor2;

	public PedidoPizzaMedia(Cliente cliente, FormaEntrega entrega, int quantidade, //
			Sabor sabor1, Sabor sabor2) {
		super(cliente, entrega, quantidade);
		this.sabor1 = sabor1;
		this.sabor2 = sabor2;
	}

	public Sabor getSabor1() {
		return sabor1;
	}

	public Sabor getSabor2() {
		return sabor2;
	}

	@Override
	public double getPreco() {
		return 40;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(sabor1, sabor2);
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
		PedidoPizzaMedia other = (PedidoPizzaMedia) obj;
		return ((sabor1 == other.sabor1 && sabor2 == other.sabor2) || // ;
				(sabor1 == other.sabor2 && sabor2 == other.sabor1));
	}

}
