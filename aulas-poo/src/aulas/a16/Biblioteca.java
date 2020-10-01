package aulas.a16;

import java.util.ArrayList;

public class Biblioteca {

	private String nome;
	private ArrayList<Livro> acervo;

	public Biblioteca(String nome) {
		this.nome = nome;
		this.acervo = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Livro> getAcervo() {
		return acervo;
	}

	public void incluirLivro(Livro livro) {
		acervo.add(livro);
	}
}
