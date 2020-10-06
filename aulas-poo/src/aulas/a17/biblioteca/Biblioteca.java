package aulas.a17.biblioteca;

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

	public ArrayList<Livro> getAcervo(Genero gen) {
		ArrayList<Livro> livrosGenero = new ArrayList<>();
		for (Livro li : acervo) {
			if (li.getGenero() == gen) {
				livrosGenero.add(li);
			}
		}
		return livrosGenero;
	}

	public void incluirLivro(Livro livro) {
		acervo.add(livro);
	}

	public int quantidadeLivrosAutor(String nome, String sobrenome) {
		int qt = 0;
		for (Livro li : acervo) {
			if (nome.equalsIgnoreCase(li.getAutor().getNome()) && //
					sobrenome.equalsIgnoreCase(li.getAutor().getSobrenome())) {
				qt++;
			}
		}

		return qt;
	}
}
