package colecoes;

import java.util.Comparator;

public class PessoaComparatorIdade implements Comparator<Pessoa> {

	private boolean ascendente;
	
	public PessoaComparatorIdade(boolean ascendente) {
		this.ascendente = ascendente;
	}

	@Override
	public int compare(Pessoa p1, Pessoa p2) {
		if (ascendente) {
			return p1.getIdade() - p2.getIdade();
		} else {
			return p2.getIdade() - p1.getIdade();
		}
	}

}
