package aulas.a11av1;

import java.util.Arrays;

public class Av1Main {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa("eu", "12345678900");
		p1.anoNascimento(2003);
		System.out.printf("%s%s é maior de idade.%n", p1.getCpfFormatado(), //
				p1.maiorIdade() ? "" : " não");

		p1 = new Pessoa("eu", "00345678900");
		p1.anoNascimento(2000);
		System.out.printf("%s%s é maior de idade.%n", p1.getCpfFormatado(), //
				p1.maiorIdade() ? "" : " não");

		
		int[] vet = { 9, 7, 1 };
		System.out.println(Arrays.toString(vet));
		System.out.println(Arrays.toString(Estaticos.vetorInvertido(vet)));
		System.out.println(Arrays.toString(vet));

		char[] letras = "alfabeto".toCharArray();
		System.out.println(Arrays.toString(letras));
		System.out.println(Estaticos.stringVetor(letras));
	}

}
