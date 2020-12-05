package aulas.a28rec.correcao;

import java.util.Objects;

public class PedidoPizzaPequena extends PedidoPizza {

	private Sabor sabor;
	
	
	public PedidoPizzaPequena(Cliente nome, FormaEntrega entrega, int quantidade, Sabor sabor) {
		super(nome, entrega, quantidade);
		this.sabor = sabor;
	}

	public Sabor getSabor() {
		return sabor;
	}
	
	public double getPreco() {
		if(this.getQuantidade() <= 0) {
			return 1;
		} else if (super.getEntrega() == FormaEntrega.DELIVERY) {
			return this.getQuantidade() * 30 + 5;			
		} else {
			return this.getQuantidade() * 30;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(this.getQuantidade(), sabor);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PedidoPizzaPequena other = (PedidoPizzaPequena) obj;
		if (super.getCliente() != other.getCliente())
			return false;
		if (super.getEntrega() != other.getEntrega()) 
			return false;
		if (super.getQuantidade() != other.getQuantidade())
			return false;
		return this.getQuantidade() == other.getQuantidade() && sabor == other.sabor;
	}
	
	
	
}
