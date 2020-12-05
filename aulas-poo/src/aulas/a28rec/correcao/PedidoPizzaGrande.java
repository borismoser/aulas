package aulas.a28rec.correcao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class PedidoPizzaGrande extends PedidoPizza {

	private Sabor sabor1;
	private Sabor sabor2;
	private Sabor sabor3;

	public PedidoPizzaGrande(Cliente cliente, FormaEntrega entrega, int quantidade, //
			Sabor sabor1, Sabor sabor2, Sabor sabor3) {
		super(cliente, entrega, quantidade);
		this.sabor1 = sabor1;
		this.sabor2 = sabor2;
		this.sabor3 = sabor3;
	}

	public Sabor getSabor1() {
		return sabor1;
	}

	public Sabor getSabor2() {
		return sabor2;
	}

	public Sabor getSabor3() {
		return sabor3;
	}

	@Override
	public double getPreco() {
		return getQuantidade() * 50 + super.getPreco();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(sabor1, sabor2, sabor3);
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
		PedidoPizzaGrande other = (PedidoPizzaGrande) obj;
		
		ArrayList<Sabor> saborThis = new ArrayList<>();
		saborThis.add(sabor1);
		saborThis.add(sabor2);
		saborThis.add(sabor3);
		
		ArrayList<Sabor> saborOther = new ArrayList<>();
		saborOther.add(other.sabor1);
		saborOther.add(other.sabor2);
		saborOther.add(other.sabor3);

		Collections.sort(saborThis);
		Collections.sort(saborOther);
		
		return saborThis.equals(saborOther);
	}

}
