package aulas.a28rec.correcao;

import java.util.Objects;

public class PedidoPizzaMedia extends PedidoPizza {

	private Sabor sabor;
	private Sabor sabor2;
	
	
	public PedidoPizzaMedia(Cliente nome, FormaEntrega entrega, int quantidade, Sabor sabor, Sabor sabor2) {
		super(nome, entrega, quantidade);
		this.sabor = sabor;
		this.sabor2 = sabor2;
	}

	public Sabor getSabor1() {
		return sabor;
	}
	
	public Sabor getsabor2() {
		return sabor2;
	}
	
	public double getPreco() {
		if(this.getQuantidade() <= 0) {
			return 1;
		} else if (this.getEntrega() == FormaEntrega.DELIVERY) {
			return this.getQuantidade() * 40 + 5;			
		} else {
			return this.getQuantidade() * 40;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(sabor, sabor2);
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
		if (super.getCliente() != other.getCliente())
			return false;
		if (super.getEntrega() != other.getEntrega()) 
			return false;
		if (super.getQuantidade() != other.getQuantidade())
			return false;
		return sabor == other.sabor && sabor2 == other.sabor2;
	}
}
