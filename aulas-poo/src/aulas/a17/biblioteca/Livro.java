package aulas.a17.biblioteca;

public class Livro {

	private Autor autor;
	private String titulo;
	private int ano;
	private Genero genero;

	public Livro(Autor autor, String titulo, int ano, Genero genero) {
		this.autor = autor;
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
	}

	public Autor getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAno() {
		return ano;
	}

	public Genero getGenero() {
		return genero;
	}

}
