package aulas.a22av2;

import java.util.ArrayList;
import java.util.Objects;

public class Loja {

	private String nomeLoja;
	private ArrayList<Nacional> nacionais = new ArrayList<>();
	private ArrayList<Importado> importados = new ArrayList<>();

	public Loja(String nomeLoja) {
		this.nomeLoja = Objects.requireNonNull(nomeLoja);
	}

	public boolean novoProduto(Nacional prod) {
		if (nacionais.contains(prod)) {
			return false;
		}
		return nacionais.add(prod);
	}

	public boolean novoProduto(Importado prod) {
		if (importados.contains(prod)) {
			return false;
		}
		return importados.add(prod);
	}

	public Nacional nacionalMaisCaro() {
		Nacional maisCaro = null;
		for (Nacional nac : nacionais) {
			if (maisCaro == null || nac.getPrecoFinal() > maisCaro.getPrecoFinal()) {
				maisCaro = nac;
			}
		}
		return maisCaro;
	}

	public Importado importadoMaisBarato() {
		Importado maisBarato = null;
		for (Importado imp : importados) {
			if (maisBarato == null || imp.getPrecoMinimo() < maisBarato.getPrecoMinimo()) {
				maisBarato = imp;
			}
		}
		return maisBarato;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}
}
