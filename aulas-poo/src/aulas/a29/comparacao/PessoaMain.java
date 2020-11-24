package aulas.a29.comparacao;

import java.util.ArrayList;
import java.util.Collections;

public class PessoaMain {

	public static void main(String[] args) {

		ArrayList<String> palavras = new ArrayList<>();
		palavras.add("Ford");
		palavras.add("Fiat");
		palavras.add("Renault");
		palavras.add("Honda");
		palavras.add("Chevrolet");
		System.out.println(palavras);

		Collections.sort(palavras);
		System.out.println(palavras);

		Collections.sort(palavras, Collections.reverseOrder());
		System.out.println(palavras);

		ArrayList<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("Beatriz", 10));
		pessoas.add(new Pessoa("Ana", 30));
		pessoas.add(new Pessoa("Carla", 25));
		pessoas.add(new Pessoa("Beatriz", 15));
		pessoas.add(new Pessoa("Ana", 20));
		System.out.println(pessoas);

		Collections.sort(pessoas);
		System.out.println(pessoas);

		Collections.sort(pessoas, Collections.reverseOrder());
		System.out.println(pessoas);
	}

}
