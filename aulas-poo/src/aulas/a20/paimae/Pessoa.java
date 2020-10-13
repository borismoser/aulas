package aulas.a20.paimae;

import java.util.Objects;

public class Pessoa {

	private String nome;
	private int idade;
	private Pessoa pai;
	private Pessoa mae;

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public Pessoa(String nome, int idade) {
		this(nome);
		this.idade = idade;
	}

	public Pessoa getPai() {
		return pai;
	}

	public void setPai(Pessoa pai) {
		this.pai = pai;
	}

	public Pessoa getMae() {
		return mae;
	}

	public void setMae(Pessoa mae) {
		this.mae = mae;
	}

	public String getNome() {
		return nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getIdade() {
		return this.idade;
	}

	public void oi() {
		System.out.println("Olá, eu me chamo " + nome + " e tenho " + idade + " anos.");
	}

	@Override
	public boolean equals(Object outraPessoa) {

		if (outraPessoa == null) return false;

		if (this == outraPessoa) return true;

		if (this.getClass() != outraPessoa.getClass()) return false;

		Pessoa p = (Pessoa) outraPessoa;
		return	this.getIdade() == p.getIdade() && //
				Objects.equals(this.getNome(), p.getNome()) && //
				Objects.equals(this.getPai(), p.getPai()) && //
				Objects.equals(this.getMae(), p.getMae());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getNome(), this.getIdade());
	}

}
