package aulas.a22av2;

import java.util.Objects;

public class Nacional extends Produto {

	private Categoria categoria;

	public Nacional(int codigo, String descricao, double precoCusto, Categoria categoria) {
		super(codigo, descricao, precoCusto);
		this.categoria = categoria;
	}

	public double getPrecoFinal() {
		if (categoria == Categoria.ARTESANAL) {
			return getPrecoCusto() * 1.5;
		} else {
			return getPrecoCusto() * 1.3;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, getPrecoCusto(), getDescricao(), getCodigo());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nacional other = (Nacional) obj;
		return categoria == other.categoria && //
				getPrecoCusto() == other.getPrecoCusto() && //
				getDescricao() == other.getDescricao() && //
				getCodigo() == other.getCodigo();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public String toString() {
		return "[getCodigo()=" + getCodigo() + ", getDescricao()=" + getDescricao() + //
				", categoria=" + categoria + ", getPrecoFinal()=" + getPrecoFinal() + //
				", getPrecoCusto()=" + getPrecoCusto() + "]";
	}

}
