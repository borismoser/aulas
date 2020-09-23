package aulas.a13a14;

import java.util.ArrayList;
import java.util.Random;

public class ALAposta {

	private String nome;
	private ArrayList<Integer> numeros;

	public ALAposta(String nome, int tamanho) {
		this.nome = nome;
		// Instância preparada para a quantidade necessária de números:
		this.numeros = new ArrayList<>(tamanho);

		Random rnd = new Random();
		int num;
		for (int i = 0; i < tamanho; i++) {
			do {
				num = 1 + rnd.nextInt(60); // Sortear um número para a aposta ...
			} while (this.numeros.contains(num)); // ...até não encontrá-lo na lista, ...
			this.numeros.add(num); // ...para somente então incluí-lo.
		}
	}

	public String getNome() {
		return nome;
	}

	// Retorna uma referência para a lista interna,
	// o que permite manipulação externa do conteúdo.
	// Ou seja, permite que os números da aposta sejam alterados,
	// o que vai contra as regras do jogo.
	public ArrayList<Integer> getNumeros() {
		return numeros;
	}

	// Retorna uma referência para uma nova lista, que é uma cópia da lista interna.
	// Qualquer alteração externa feita nessa lista não vai refletir internamente.
	// Assim, o público tem acesso aos números, mas não consegue alterar a aposta.
	public ArrayList<Integer> getNumerosApostados() {
		return new ArrayList<Integer>(numeros);
	}

	// Sobrescrevendo o método toString, herdado da classe Object:	
	@Override
	public String toString() {
		return nome + " " + numeros;
	}

}
