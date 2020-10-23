package aulas.a20.familia;

import java.util.ArrayList;
import java.util.Objects;

public class Pessoa {

	private String nome;
	private Pessoa pai;
	private Pessoa mae;
	private ArrayList<Pessoa> filhos;

	public Pessoa(String nome) {
		this.nome = Objects.requireNonNull(nome);
	}

	public Pessoa(String nome, Pessoa pai, Pessoa mae) {
		this(nome);
		this.pai = pai;
		this.mae = mae;
	}

	public Pessoa getPai() {
		return pai;
	}

	public Pessoa getMae() {
		return mae;
	}

	public void setPai(Pessoa pai) {
		if (Objects.equals(this.pai, pai))
			return;
		if (this.pai != null) {
			this.pai.getFilhos().remove(this);
		}
		if (pai != null) {
			this.pai = pai;
			this.pai.addFilho(this);
		} else {
			this.pai = null;
		}		
	}

	public void setMae(Pessoa mae) {
		if (Objects.equals(this.mae, mae))
			return;
		if (this.mae != null) {
			this.mae.getFilhos().remove(this);
		}
		if (mae != null) {
			this.mae = mae;
			this.mae.addFilho(this);
		} else {
			this.mae = null;
		}		
	}

	private boolean addFilho(Pessoa umFilho) {
		if (umFilho == null)
			return false;
		if (filhos == null)
			filhos = new ArrayList<>(1);
		if (filhos.contains(umFilho))
			return false;
		return filhos.add(umFilho);
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Pessoa> getFilhos() {
		return filhos;
	}

	public ArrayList<Pessoa> getIrmaos() {
		// devolver uma lista unificada de filhos do pai e da mãe

		Pessoa paimae = new Pessoa("");
		if (pai != null) {
			addFilhos(paimae, pai.filhos);
		}
		if (mae != null) {
			addFilhos(paimae, mae.filhos);
		}
		return paimae.getFilhos();
	}

	private void addFilhos(Pessoa pes, ArrayList<Pessoa> listaFilhos) {
		if (listaFilhos == null)
			return;
		for (Pessoa p : listaFilhos) {
			if (!Objects.equals(p, this))
				pes.addFilho(p);
		}
	}

	public ArrayList<Pessoa> getSobrinhos() {
		// devolver uma lista unificada de filhos dos irmãos
		return null;
	}

	public ArrayList<Pessoa> getNetos() {
		// devolver uma lista unificada de filhos dos filhos
		return null;
	}

	public ArrayList<Pessoa> getTios() {
		// devolver uma lista unificada dos irmãos dos pais
		return null;
	}

	public ArrayList<Pessoa> getPrimos() {
		// devolver uma lista unificada de filhos dos tios
		return null;
	}

	public ArrayList<Pessoa> getAvosMaternos() {
		// devolver uma lista unificada com os pais da mãe
		return null;
	}

	public ArrayList<Pessoa> getAvosPaternos() {
		// devolver uma lista unificada com os pais do pai
		return null;
	}

	@Override
	public boolean equals(Object outraPessoa) {

		if (outraPessoa == null)
			return false;

		if (this == outraPessoa)
			return true;

		if (this.getClass() != outraPessoa.getClass())
			return false;

		// Duas pessoas são iguais se tiverem o mesmo nome e os mesmos pais

		Pessoa p = (Pessoa) outraPessoa;
		return Objects.equals(this.getNome(), p.getNome()) && //
				Objects.equals(this.getPai(), p.getPai()) && //
				Objects.equals(this.getMae(), p.getMae());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNome(), getPai(), getMae());
	}

	@Override
	public String toString() {
		return "[" + nome + ", pai=" + pai + ", mae=" + mae + "]";
	}

}
