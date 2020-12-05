package aulas.a28rec.correcao;

public class PedidoPizzaGrande extends PedidoPizza {

	private Sabor sabor1;
	private Sabor sabor2;
	private Sabor sabor3;
	
	
	public PedidoPizzaGrande(Cliente nome, FormaEntrega entrega, int quantidade,Sabor sabor1, Sabor sabor2, Sabor sabor3) {
		super(nome, entrega, quantidade);
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
	
	
	public double getPreco() {
		if(this.getQuantidade() <= 0) {
			return 1;
		} else if (this.getEntrega() == FormaEntrega.DELIVERY) {
			return this.getQuantidade() * 50 + 5;			
		} else {
			return this.getQuantidade() * 50;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((sabor1 == null) ? 0 : sabor1.hashCode());
		result = prime * result + ((sabor2 == null) ? 0 : sabor2.hashCode());
		result = prime * result + ((sabor3 == null) ? 0 : sabor3.hashCode());
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
		if (super.getCliente() != other.getCliente())
			return false;
		if (super.getEntrega() != other.getEntrega()) 
			return false;
		if (super.getQuantidade() != other.getQuantidade())
			return false;
		if (sabor1 != other.sabor1)
			return false;
		if (sabor2 != other.sabor2)
			return false;
		if (sabor3 != other.sabor3)
			return false;
		return true;
	}
	
}
