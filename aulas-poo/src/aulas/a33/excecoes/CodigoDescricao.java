package aulas.a33.excecoes;

public class CodigoDescricao {

	private int codigo;
	private String descricao;

	public CodigoDescricao(int codigo, String descricao) throws IllegalArgumentException {
		if (descricao == null) {
			throw new IllegalArgumentException("A descrição não pode ser nula");
		}
		this.codigo = codigo;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return this.codigo + " : " + this.descricao;
	}

}
