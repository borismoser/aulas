package aulas.a22av2;

import java.util.Objects;

public class Importado extends Produto {

	private double taxaImportacao;

	public Importado(int codigo, String descricao, double precoCusto, double taxaImportacao) {
		super(codigo, descricao, precoCusto);
		this.taxaImportacao = taxaImportacao;
	}

	public double getPrecoMinimo() {
		return getPrecoCusto() * (1 + (taxaImportacao / 100));
	}

	@Override
	public int hashCode() {
		return Objects.hash(taxaImportacao, getPrecoCusto(), getDescricao(), getCodigo());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Importado other = (Importado) obj;
		return taxaImportacao == other.taxaImportacao && //
				getPrecoCusto() == other.getPrecoCusto() && //
				getDescricao() == other.getDescricao() && //
				getCodigo() == other.getCodigo();
	}

}
