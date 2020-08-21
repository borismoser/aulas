package aulas.a04;

import java.util.Arrays;

public class Vetores {

	public static void main(String[] args) {

		// Declaração completa de um array unidimensional - um vetor - em uma única
		// linha. Após declarado, não é possível alterar o comprimento de um array.

		int[] v1 = new int[8]; // criando um array do tipo int, com 8 posições.

		// Arrays são objetos e como tais possuem métodos e propriedades,
		// diferentemente de variáveis primitivas, que guardam apenas seus próprios
		// valores.

		// Todo array possui uma propriedade chamada 'length',
		// que nos fornece o seu comprimento (quantidade de posições).

		System.out.println("O array v1 possui " + v1.length + " posições:");

		// Arrays são indexados a partir de zero e devem ser acessados dentro do limite
		// de seu tamanho. Qualquer acesso fora desses limites gera um erro de execução.

		// O acesso ao um elemento, tanto para ler quanto para atribuir um valor,
		// é feito pela indexação direta da posição desejada, isto é, "vetor[índice]".

		// Preenchimento com números aleatórios entre 0 e 99:
		for (int i = 0; i < v1.length; i++) {
			v1[i] = (int) (Math.random() * 100);
		}

		System.out.printf("%6s%8s%n", "Índice", "Valor");

		for (int i = 0; i < v1.length; i++) {
			System.out.printf("%6d%8d%n", i, v1[i]);
		}

		// Declaração de uma constante com o comprimento do array:

		final int TAMANHO_VETOR = 15;

		// A declaração de um array pode ser feita em linhas separadas:

		int[] v2;
		v2 = new int[TAMANHO_VETOR];

		System.out.print("\nConteúdo de v2: ");
		for (int i = 0; i < TAMANHO_VETOR; i++) {
			v2[i] = (int) (Math.random() * 100);
			System.out.print(v2[i] + " ");
		}
		System.out.println();

		// Calculando a soma dos elementos de um array
		// através de um 'for' tradicional, com variável de controle:

		int total = 0;
		for (int i = 0; i < TAMANHO_VETOR; i++) {
			total += v2[i];
		}
		System.out.printf("a) Total dos elementos em v2: %8d%n", total);

		// Calculando a soma dos elementos de um array
		// através de um laço 'for' otimizado para uso em listas.

		// Só pode ser usado para obter valores, não para modificar,
		// pois o índice de cada elemento não é conhecido na iteração.

		total = 0;
		for (int n : v2) {
			total += n;
		}
		System.out.printf("b) Total dos elementos em v2: %8d%n", total);

		// Um array também pode ser declarado e inicializado
		// sob a forma de uma lista contendo seus elementos.

		// Neste caso, o comprimento não é declarado explicitamente,
		// pois é decorrente da quantidade de elementos especificados:

		int[] v3 = { 99, 66, 75, 44, 21, 3, 58 };

		// A linguagem Java possui uma classe chamada "Arrays", que contém
		// diversos métodos utilitários para manipulação desse tipo de objeto.

		// Obtendo um String com os elementos do array:
		String texto = Arrays.toString(v3);
		System.out.println("\nConteúdo de v3: " + texto);

		// Copiando o conteúdo de um array para outro:

		int[] v4 = Arrays.copyOf(v3, v3.length);
		System.out.println("Conteúdo de v4: " + Arrays.toString(v4));

		// Verificando se dois arrays são iguais, ou seja,
		// se possuem a mesma quantidade de elementos, nas mesmas posições:
		System.out.print("Os arrays v3 e v4 são iguais? ");
		if (Arrays.equals(v3, v4)) {
			texto = "Sim!";
		} else {
			texto = "Não!";
		}
		System.out.println(texto);

		// Classificando o conteúdo de um array:
		Arrays.sort(v4);
		texto = Arrays.toString(v4);
		System.out.println("\nConteúdo de v4 COM ordenação: " + texto);
		texto = Arrays.toString(v3);
		System.out.println("Conteúdo de v3 SEM ordenação: " + texto);

		System.out.print("Os arrays v3 e v4 são iguais? ");
		texto = Arrays.equals(v3, v4) ? "Sim!" : "Não!";
		System.out.println(texto);

		// Preenchendo um array com um determinado valor:
		Arrays.fill(v4, 123);
		texto = Arrays.toString(v4);
		System.out.println("\nConteúdo de v4: " + texto);

	}

}
