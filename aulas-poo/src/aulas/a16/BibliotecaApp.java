package aulas.a16;

import java.util.ArrayList;

public class BibliotecaApp {

	public static void main(String[] args) {

		Autor aut = new Autor("Paul", "Deitel");
		Livro liv = new Livro(aut, "Java: como programar", 2011, Genero.TECNICO);

		Biblioteca senai = new Biblioteca("SENAI");
		senai.incluirLivro(liv);
		liv = new Livro(new Autor("Monteiro", "Lobato"), "Urupês", 1918, Genero.CONTO);
		senai.incluirLivro(liv);
		listarAcervo(senai);

		Biblioteca furb = new Biblioteca("FURB");
		aut = new Autor("Ian", "Sommerville");
		liv = new Livro(aut, "Software Engineering", 2016, Genero.TECNICO);
		furb.incluirLivro(liv);
		listarAcervo(furb);
	}

	private static void listarAcervo(Biblioteca biblioteca) {
		System.out.printf("%nLivros da Biblioteca %s:%n", biblioteca.getNome());
		ArrayList<Livro> livros = biblioteca.getAcervo();
		Autor a;
		for (Livro livro : livros) {
			a = livro.getAutor();
			String t = livro.getTitulo();
			System.out.println(t + " - " + a);
		}
	}

}
