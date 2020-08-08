package comp1;

import java.util.ArrayList;

public class Pessoa {
	private String nome;
	private Integer idade;
	private Endereco endereco;
	private Pessoa mae;
	private Pessoa pai;
	private ArrayList<Pessoa> dependentes;

	public Pessoa() {
		this.dependentes = new ArrayList<>();
	}

	public Pessoa(String nome) {
		this();
		this.nome = nome;
	}

	public Pessoa(String nome, Integer idade) {
		this(nome);
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Pessoa getMae() {
		return mae;
	}

	public void setMae(Pessoa mae) {
		this.mae = mae;
	}

	public Pessoa getPai() {
		return pai;
	}

	public void setPai(Pessoa pai) {
		this.pai = pai;
	}

	public ArrayList<Pessoa> getDependentes() {
		return dependentes;
	}

	public void addDependente(Pessoa dependente) {
		dependente.setPai(this);
		this.dependentes.add(dependente);
	}

	public void listarDependente() {
		if (dependentes.size() == 0) {
			System.out.println(this.nome + " não possui dependentes.");
		} else {
			System.out.println("Dependentes de " + this.nome + ":");
			for (Pessoa dep : dependentes) {
				System.out.println(dep.getNome());
			}
		}
	}
	
}
